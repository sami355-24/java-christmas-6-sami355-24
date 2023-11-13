package christmas.Domain;

public class Calculator {

    public Calculator() {
    }

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
}
