package christmas.Constant;

public enum Event {
    CHRISTMAS_EVENT("크리스마스 디데이 할인"),
    WEEKDAY_EVENT("평일 할인"),
    WEEKEND_EVENT("주말 할인"),
    SPECIAL_EVENT("특별 할인"),
    GIFT_EVENT("증정 이벤트"),

    STAR_BADGE("별"),
    TREE_BADGE("트리"),
    SANTA_BADGE("산타"),

    NOTHING("없음");

    private String value;

    public static final int CHRISTMAS_EVENT_BASIC_DISCOUNT_AMOUNT = 1000;
    public static final int CHRISTMAS_EVENT_PER_DAY_DISCOUNT_AMOUNT = 100;
    public static final int WEEKDAY_EVENT_DISCOUNT_AMOUNT = 2023;
    public static final int WEEKEND_EVENT_DISCOUNT_AMOUNT = 2023;
    public static final int SPECIAL_EVENT_DISCOUNT_AMOUNT = 1000;

    public static final int EVENT_CRITERIA = 10_000;
    public static final int GIFT_EVENT_CRITERIA = 120_000;
    public static final int GIFT_COUNT = 1;

    Event(String eventName) {
        this.value = eventName;
    }

    public String getValue() {
        return value;
    }
}
