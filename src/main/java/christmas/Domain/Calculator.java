package christmas.Domain;

import static christmas.Constant.Benefit.CHRISTMAS_BASIC_BENEFIT_DISCOUNT;
import static christmas.Constant.Benefit.CHRISTMAS_PER_DAY_BENEFIT_DISCOUNT;
import static christmas.Constant.Benefit.GIFT_BENEFIT;
import static christmas.Constant.Benefit.SPECIAL_BENEFIT_DISCOUNT;
import static christmas.Constant.Benefit.WEEKDAY_BENEFIT_DISCOUNT;
import static christmas.Constant.Benefit.WEEKEND_BENEFIT_DISCOUNT;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;
import java.util.Map.Entry;

public class Calculator {

    public int calculateChristmasDiscount(int day) {
        return CHRISTMAS_BASIC_BENEFIT_DISCOUNT +
                CHRISTMAS_PER_DAY_BENEFIT_DISCOUNT * (day-1);
    }

    public int calculateWeekdayDiscount(int dessertCount) {
        return dessertCount * WEEKDAY_BENEFIT_DISCOUNT;
    }

    public int calculateWeekendDiscount(int mainDishCount) {
        return mainDishCount * WEEKEND_BENEFIT_DISCOUNT;
    }

    public int specialDiscount(){
        return SPECIAL_BENEFIT_DISCOUNT;
    }

    public int giftBenefit(){
        return Menu.CHAMPAGNE.getPrice();
    }

    public int calculateTotalPriceAfterDiscount(ReservedMenuGroup menuGroup, AppliedEventGroup appliedEventGroup){
        int totalPrice = calculateTotalPriceBeforeDiscount(menuGroup);
        int benefitPriceWithoutGift = appliedEventGroup.getBenefits().entrySet().stream()
                .filter(benefit -> !benefit.getKey().equals(GIFT_BENEFIT.getValue()))
                .mapToInt(Entry::getValue)
                .sum();
        return totalPrice - benefitPriceWithoutGift;
    }

    public int calculateTotalPriceBeforeDiscount(ReservedMenuGroup menuGroup){
        Map<Menu, Integer> menus = menuGroup.getMenuGroup();
        int totalPrice = 0;
        for (Menu menu : menus.keySet()) {
            totalPrice += menu.getPrice() * menus.get(menu);
        }
        return totalPrice;
    }

    public int calculateTotalBenefitAmount(AppliedEventGroup appliedEventGroup){
        int totalBenefitAmount = 0;
        for (int benefitAmount : appliedEventGroup.getBenefitAmounts()) {
            totalBenefitAmount += benefitAmount;
        }
        return totalBenefitAmount;
    }
}
