package christmas.Domain;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;

public class ReservedOrder {

    private final ReservedMenuGroup menuGroup;
    private final ReservedDate date;
    private final Calculator calculator;

    public ReservedOrder(ReservedMenuGroup menuGroup, ReservedDate date, Calculator calculator) {
        this.menuGroup = menuGroup;
        this.date = date;
        this.calculator = calculator;
    }


}
