package christmas.Constant;

public enum Benefit {
    CHRISTMAS_BENEFIT("크리스마스 디데이 할인"),
    WEEKDAY_BENEFIT("평일 할인"),
    WEEKEND_BENEFIT("주말 할인"),
    SPECIAL_BENEFIT("특별 할인"),
    GIFT_BENEFIT("증정 이벤트"),

    STAR_BADGE("별 배지"),
    TREE_BADGE("트리 배지"),
    SANTA_BADGE("산타 배지"),

    NOTHING("없음");

    private String value;

    Benefit(String benefitName) {
        this.value = benefitName;
    }

    public String getValue() {
        return value;
    }
}
