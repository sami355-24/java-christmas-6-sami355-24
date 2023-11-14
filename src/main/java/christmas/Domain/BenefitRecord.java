package christmas.Domain;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitRecord {

    private final String CHRISTMAS_BENEFIT = "크리스마스 디데이 할인";
    private final String WEEKDAY_BENEFIT = "평일 할인";
    private final String WEEKEND_BENEFIT = "주말 할인";
    private final String SPECIAL_BENEFIT = "특별 할인";
    private final String GIFT_BENEFIT = "증정 이벤트";
    private final int GIFT_BENEFIT_CRITERIA = 120_000;

    Map<String, Integer> benefits;
    Calculator calculator = new Calculator();

    BenefitRecord(ReservedMenuGroup menuGroup, ReservedDate date) {
        this.benefits = new HashMap<>();

        if (date.isChristmasNotPassed())
            addBenefit(CHRISTMAS_BENEFIT, calculator.calculateChristmasDiscount(date.getDay()));
        if (date.isWeekDay())
            addBenefit(WEEKDAY_BENEFIT, calculator.calculateWeekdayDiscount(menuGroup.countDessert()));
        if (date.isWeekend())
            addBenefit(WEEKEND_BENEFIT, calculator.calculateWeekendDiscount(menuGroup.countMainDish()));
        if (date.isStarDay())
            addBenefit(SPECIAL_BENEFIT, calculator.specialDiscount());
        if (calculator.calculateTotalPriceBeforeDiscount(menuGroup) >= GIFT_BENEFIT_CRITERIA)
            addBenefit(GIFT_BENEFIT, calculator.giftBenefit());
    }

    private void addBenefit(String benefitName, int benefitAmount) {
        benefits.put(benefitName, -benefitAmount);
    }

    public Map<String, Integer> getBenefits() {
        return Collections.unmodifiableMap(benefits);
    }

    public List<Integer> getBenefitAmounts() {
        return benefits.values().stream().toList();
    }
}
