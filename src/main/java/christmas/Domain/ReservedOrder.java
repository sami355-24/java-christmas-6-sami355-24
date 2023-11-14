package christmas.Domain;

import static christmas.Constant.Benefit.DISCOUNT_CRITERIA;
import static christmas.Constant.Benefit.GIFT_CRITERIA;
import static christmas.Domain.Menu.CHAMPAGNE;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;

public class ReservedOrder {

    private final ReservedMenuGroup menuGroup;
    private final ReservedDate date;
    private final Calculator calculator;
    private BenefitRecord benefitRecord;

    public ReservedOrder(ReservedMenuGroup menuGroup, ReservedDate date) {
        this.menuGroup = menuGroup;
        this.date = date;
        this.calculator = new Calculator();
        this.benefitRecord = new BenefitRecord(menuGroup, date);
    }


    public Map<String, Integer> getGifts() {
        if (calculator.calculateTotalPriceBeforeDiscount(menuGroup) >= GIFT_CRITERIA)
            return Map.of(CHAMPAGNE.getName(), CHAMPAGNE.getPrice());
        return Map.of();
    }

    public BenefitRecord getBenefitRecord() {
        return new BenefitRecord(menuGroup, date);
    }

    public int getTotalPriceAfterDiscount() {
        return calculator.calculateTotalPriceAfterDiscount(menuGroup, benefitRecord);
    }

    public int getTotalPriceBeforeDiscount() {
        return calculator.calculateTotalPriceBeforeDiscount(menuGroup);
    }
}
