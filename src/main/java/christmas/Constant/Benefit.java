package christmas.Constant;

public enum Benefit {
    CHRISTMAS_BENEFIT("크리스마스 디데이 할인"),
    WEEKDAY_BENEFIT("평일 할인"),
    WEEKEND_BENEFIT("주말 할인"),
    SPECIAL_BENEFIT("특별 할인"),
    GIFT_BENEFIT("증정 이벤트"),

    STAR_BADGE("별"),
    TREE_BADGE("트리"),
    SANTA_BADGE("산타"),

    NOTHING("없음");

    private String value;

    public static final int CHRISTMAS_BASIC_BENEFIT_DISCOUNT = 1000;
    public static final int CHRISTMAS_PER_DAY_BENEFIT_DISCOUNT = 100;
    public static final int WEEKDAY_BENEFIT_DISCOUNT = 2023;
    public static final int WEEKEND_BENEFIT_DISCOUNT = 2023;
    public static final int SPECIAL_BENEFIT_DISCOUNT = 1000;

    public static final int DISCOUNT_CRITERIA = 10_000;
    public static final int GIFT_COUNT = 1;

    Benefit(String benefitName) {
        this.value = benefitName;
    }

    public String getValue() {
        return value;
    }
}
