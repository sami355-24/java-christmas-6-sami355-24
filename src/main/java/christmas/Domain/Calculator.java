package christmas.Domain;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;

public class Calculator {

    public int calculateChristmasDiscount(int day) {
        return 1000 + 100 * (day-1);
    }

    public int calculateWeekdayDiscount(int dessertCount) {
        return dessertCount * 2023;
    }

    public int calculateWeekendDiscount(int mainDishCount) {
        return mainDishCount * 2023;
    }

    public int specialDiscount(){
        return 1000;
    }

    public int giftBenefit(){
        return Menu.CHAMPAGNE.getPrice();
    }

    public int calculateTotalPriceAfterDiscount(ReservedMenuGroup menuGroup, BenefitRecord benefitRecord){
        int totalPrice = calculateTotalPriceBeforeDiscount(menuGroup);
        int totalBenefitAmount = calculateTotalBenefitAmount(benefitRecord);
        return totalPrice - totalBenefitAmount;
    }

    public int calculateTotalPriceBeforeDiscount(ReservedMenuGroup menuGroup){
        Map<Menu, Integer> menus = menuGroup.getMenuGroup();
        int totalPrice = 0;
        for (Menu menu : menus.keySet()) {
            totalPrice += menu.getPrice() * menus.get(menu);
        }
        return totalPrice;
    }

    public int calculateTotalBenefitAmount(BenefitRecord benefitRecord){
        int totalBenefitAmount = 0;
        for (int benefitAmount : benefitRecord.getBenefitAmounts()) {
            totalBenefitAmount += benefitAmount;
        }
        return totalBenefitAmount;
    }
}
