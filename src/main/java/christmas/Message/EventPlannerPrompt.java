package christmas.Message;

public enum EventPlannerPrompt {
    WELL_COME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASK_RESERVATION_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_RESERVATION_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW_EVENT_BENEFITS("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),

    RESERVED_MENU_TITLE("\n<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT_TITLE("\n<할인 전 총주문 금액>"),
    GIFT_TITLE("\n<증정 메뉴>"),
    APPLIED_BENEFIT_TITLE("\n<혜택 내역>"),
    TOTAL_BENEFIT_PRICE_TITLE("\n<총혜택 금액>"),
    TOTAL_PRICE_AFTER_DISCOUNT_TITLE("\n<할인 후 예상 결제 금액>"),
    EVENT_BADGE_TITLE("\n<12월 이벤트 배지>"),

    RESERVED_MENU("%s %,d개"),
    TOTAL_PRICE("%,d원"),
    GIFT_MENU("%s %,d개"),
    APPLIED_EVENT("%s %,d원"),
    TOTAL_BENEFIT_PRICE("-%,d원");

    private final String prompt;

    EventPlannerPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
