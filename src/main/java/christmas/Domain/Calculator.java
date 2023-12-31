package christmas.Domain;

import static christmas.Constant.Event.CHRISTMAS_EVENT_BASIC_DISCOUNT_AMOUNT;
import static christmas.Constant.Event.CHRISTMAS_EVENT_PER_DAY_DISCOUNT_AMOUNT;
import static christmas.Constant.Event.GIFT_EVENT;
import static christmas.Constant.Event.SPECIAL_EVENT_DISCOUNT_AMOUNT;
import static christmas.Constant.Event.WEEKDAY_EVENT_DISCOUNT_AMOUNT;
import static christmas.Constant.Event.WEEKEND_EVENT_DISCOUNT_AMOUNT;
import static christmas.Domain.Menu.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;
import java.util.Map.Entry;

public class Calculator {

    public int calculateChristmasDiscount(int day) {
        return CHRISTMAS_EVENT_BASIC_DISCOUNT_AMOUNT +
                CHRISTMAS_EVENT_PER_DAY_DISCOUNT_AMOUNT * (day-1);
    }

    public int calculateWeekdayDiscount(int dessertCount) {
        return dessertCount * WEEKDAY_EVENT_DISCOUNT_AMOUNT;
    }

    public int calculateWeekendDiscount(int mainDishCount) {
        return mainDishCount * WEEKEND_EVENT_DISCOUNT_AMOUNT;
    }

    public int specialDiscount(){
        return SPECIAL_EVENT_DISCOUNT_AMOUNT;
    }

    public int giftEventAmount(){
        return CHAMPAGNE.getPrice();
    }

    public int calculateTotalPriceAfterDiscount(ReservedMenuGroup menuGroup, AppliedEventGroup appliedEventGroup){
        int totalPrice = calculateTotalPriceBeforeDiscount(menuGroup);
        int totalEventAmountWithoutGift = appliedEventGroup.getAppliedEventGroup().entrySet().stream()
                .filter(event -> !event.getKey().equals(GIFT_EVENT.getValue()))
                .mapToInt(Entry::getValue)
                .sum();
        return totalPrice - totalEventAmountWithoutGift;
    }

    public int calculateTotalPriceBeforeDiscount(ReservedMenuGroup menuGroup){
        Map<Menu, Integer> menus = menuGroup.getMenuGroup();
        int totalPrice = 0;
        for (Menu menu : menus.keySet()) {
            totalPrice += menu.getPrice() * menus.get(menu);
        }
        return totalPrice;
    }

    public int calculateTotalEventAmount(AppliedEventGroup appliedEventGroup){
        int totalEventAmount = 0;
        for (int eventAmount : appliedEventGroup.findEventAmounts()) {
            totalEventAmount += eventAmount;
        }
        return totalEventAmount;
    }
}
