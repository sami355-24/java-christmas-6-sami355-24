package christmas.Domain;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;

public class Calculator {

    public Calculator() {
    }

    public int calculateChristmasDiscount(int day) {
        return 1000 + 100 * (day-1);
    }

    public int calculateWeekdayDiscount(int dessertCount) {
        return dessertCount * 2023;
    }
}
