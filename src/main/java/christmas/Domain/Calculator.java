package christmas.Domain;

public class Calculator {

    public Calculator() {
    }

    public int calculateChristmasDiscount(int day) {
        return 1000 + 100 * (day-1);
    }
}
