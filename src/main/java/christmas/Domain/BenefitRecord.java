package christmas.Domain;

import static christmas.Constant.Benefit.CHRISTMAS_BENEFIT;
import static christmas.Constant.Benefit.GIFT_BENEFIT;
import static christmas.Constant.Benefit.NOTHING;
import static christmas.Constant.Benefit.SANTA_BADGE;
import static christmas.Constant.Benefit.SPECIAL_BENEFIT;
import static christmas.Constant.Benefit.STAR_BADGE;
import static christmas.Constant.Benefit.TREE_BADGE;
import static christmas.Constant.Benefit.WEEKDAY_BENEFIT;
import static christmas.Constant.Benefit.WEEKEND_BENEFIT;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitRecord {

    private final int GIFT_BENEFIT_CRITERIA = 120_000;

    private final int MIN = 0;
    private final int MAX = 1;
    private final List<Integer> STAR_BADGE_CRITERIA = List.of(5_000, 9_999);
    private final List<Integer> TREE_BADGE_CRITERIA = List.of(10_000, 19_999);
    private final List<Integer> SANTA_BADGE_CRITERIA = List.of(20_000);


    Map<String, Integer> benefits;
    Calculator calculator = new Calculator();

    BenefitRecord(ReservedMenuGroup menuGroup, ReservedDate date) {
        this.benefits = new HashMap<>();
        initBenefitRecords(menuGroup, date);
    }

    private void initBenefitRecords(ReservedMenuGroup menuGroup, ReservedDate date) {
        if (date.isChristmasNotPassed())
            addBenefit(CHRISTMAS_BENEFIT.getValue(), calculator.calculateChristmasDiscount(date.getDay()));
        if (date.isWeekDay())
            addBenefit(WEEKDAY_BENEFIT.getValue(), calculator.calculateWeekdayDiscount(menuGroup.countDessert()));
        if (date.isWeekend())
            addBenefit(WEEKEND_BENEFIT.getValue(), calculator.calculateWeekendDiscount(menuGroup.countMainDish()));
        if (date.isStarDay())
            addBenefit(SPECIAL_BENEFIT.getValue(), calculator.specialDiscount());
        if (calculator.calculateTotalPriceBeforeDiscount(menuGroup) >= GIFT_BENEFIT_CRITERIA)
            addBenefit(GIFT_BENEFIT.getValue(), calculator.giftBenefit());
    }

    private void addBenefit(String benefitName, int benefitAmount) {
        benefits.put(benefitName, -benefitAmount);
    }

    public String getBadge() {
        int benefitAmount = calculator.calculateTotalBenefitAmount(this);
        if (STAR_BADGE_CRITERIA.get(MIN) <= benefitAmount && benefitAmount < STAR_BADGE_CRITERIA.get(MAX))
            return STAR_BADGE.getValue();
        if (TREE_BADGE_CRITERIA.get(MIN) <= benefitAmount && benefitAmount < TREE_BADGE_CRITERIA.get(MAX))
            return TREE_BADGE.getValue();
        if (SANTA_BADGE_CRITERIA.get(MIN) <= benefitAmount)
            return SANTA_BADGE.getValue();

        return NOTHING.getValue();
    }

    public Map<String, Integer> getBenefits() {
        return Collections.unmodifiableMap(benefits);
    }

    public List<Integer> getBenefitAmounts() {
        return benefits.values().stream().toList();
    }
}
