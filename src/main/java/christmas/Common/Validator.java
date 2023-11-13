package christmas.Common;

import static christmas.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import christmas.Exception.CommonValidateException;

public class Validator {

    private Validator() {
    }

    public static void validateIntegerInput(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), e);
        }
    }

    public static void validateBlankInput(String str) {
        if (!str.isEmpty() && str.isBlank()) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

    public static void validateEmptyInput(String str) {
        if (str.isEmpty()) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }
}
