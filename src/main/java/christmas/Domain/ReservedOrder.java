package christmas.Domain;

import static christmas.Constant.Benefit.DISCOUNT_CRITERIA;
import static christmas.Domain.Menu.CHAMPAGNE;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;

public class ReservedOrder {

    private final ReservedMenuGroup menuGroup;
    private final ReservedDate date;
    private final Calculator calculator;
    private final BenefitRecord benefitRecord;

    public ReservedOrder(ReservedMenuGroup menuGroup, ReservedDate date) {
        this.menuGroup = menuGroup;
        this.date = date;
        this.calculator = new Calculator();
        this.benefitRecord = new BenefitRecord(menuGroup, date);
    }

    public boolean isDiscountAvailable() {
        return calculator.calculateTotalPriceBeforeDiscount(menuGroup) >= DISCOUNT_CRITERIA;
    }

    public Map<String, Integer> getGifts() {
        return Map.of(CHAMPAGNE.getName(), CHAMPAGNE.getPrice());
    }

    public Map<String, Integer> getBenefitRecord() {
        return benefitRecord.getBenefits();
    }

    public int getTotalPriceAfterDiscount() {
        return calculator.calculateTotalPriceAfterDiscount(menuGroup, benefitRecord);
    }

    public int getTotalPriceBeforeDiscount() {
        return calculator.calculateTotalPriceBeforeDiscount(menuGroup);
    }
}
