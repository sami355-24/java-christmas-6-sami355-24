package christmas.Constant;

public enum Date {

    MIN_DAY(1),
    MAX_DAY(31),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    CHRISTMAS(25),
    YEAR(2023),
    MONTH(12);

    private final int value;

    Date(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
