package christmas.Message.Excepton;

import static christmas.Message.Excepton.ExceptionPrefix.*;

public enum ExceptionPrompt {
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요.");

    private String prompt;

    ExceptionPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return ERROR_PREFIX.getPrompt() + prompt;
    }
}