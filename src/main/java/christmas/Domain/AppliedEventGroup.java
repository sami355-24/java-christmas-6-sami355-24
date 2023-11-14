package christmas.Domain;

import static christmas.Constant.Event.CHRISTMAS_EVENT;
import static christmas.Constant.Event.EVENT_CRITERIA;
import static christmas.Constant.Event.GIFT_EVENT;
import static christmas.Constant.Event.GIFT_EVENT_CRITERIA;
import static christmas.Constant.Event.NOTHING;
import static christmas.Constant.Event.SANTA_BADGE;
import static christmas.Constant.Event.SPECIAL_EVENT;
import static christmas.Constant.Event.STAR_BADGE;
import static christmas.Constant.Event.TREE_BADGE;
import static christmas.Constant.Event.WEEKDAY_EVENT;
import static christmas.Constant.Event.WEEKEND_EVENT;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppliedEventGroup {

    private final int MIN = 0;
    private final int MAX = 1;
    private final List<Integer> STAR_BADGE_CRITERIA = List.of(5_000, 9_999);
    private final List<Integer> TREE_BADGE_CRITERIA = List.of(10_000, 19_999);
    private final List<Integer> SANTA_BADGE_CRITERIA = List.of(20_000);

    Map<String, Integer> appliedEventGroup;
    Calculator calculator = new Calculator();

    AppliedEventGroup(ReservedMenuGroup menuGroup, ReservedDate date) {
        this.appliedEventGroup = new HashMap<>();
        if (calculator.calculateTotalPriceBeforeDiscount(menuGroup) >= EVENT_CRITERIA)
            initAppliedEventGroup(menuGroup, date);
    }

    private void initAppliedEventGroup(ReservedMenuGroup menuGroup, ReservedDate date) {
        if (date.isChristmasNotPassed())
            addEvent(CHRISTMAS_EVENT.getValue(), calculator.calculateChristmasDiscount(date.getDay()));
        if (date.isWeekDay())
            addEvent(WEEKDAY_EVENT.getValue(), calculator.calculateWeekdayDiscount(menuGroup.countDessert()));
        if (date.isWeekend())
            addEvent(WEEKEND_EVENT.getValue(), calculator.calculateWeekendDiscount(menuGroup.countMainDish()));
        if (date.isStarDay())
            addEvent(SPECIAL_EVENT.getValue(), calculator.specialDiscount());
        if (calculator.calculateTotalPriceBeforeDiscount(menuGroup) >= GIFT_EVENT_CRITERIA)
            addEvent(GIFT_EVENT.getValue(), calculator.giftEventAmount());
    }

    private void addEvent(String eventName, int eventAmount) {
        appliedEventGroup.put(eventName, eventAmount);
    }

    public String getBadge() {
        int eventAmount = findTotalEventAmount();
        if (STAR_BADGE_CRITERIA.get(MIN) <= eventAmount && eventAmount <= STAR_BADGE_CRITERIA.get(MAX))
            return STAR_BADGE.getValue();
        if (TREE_BADGE_CRITERIA.get(MIN) <= eventAmount && eventAmount <= TREE_BADGE_CRITERIA.get(MAX))
            return TREE_BADGE.getValue();
        if (SANTA_BADGE_CRITERIA.get(MIN) <= eventAmount)
            return SANTA_BADGE.getValue();

        return NOTHING.getValue();
    }

    public int findTotalEventAmount() {
        return calculator.calculateTotalEventAmount(this);
    }
    public List<Integer> findEventAmounts() {
        return appliedEventGroup.values().stream().toList();
    }

    public Map<String, Integer> getAppliedEventGroup() {
        return Collections.unmodifiableMap(appliedEventGroup);
    }
}
