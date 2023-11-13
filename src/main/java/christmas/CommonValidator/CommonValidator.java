package christmas.CommonValidator;

import static christmas.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import christmas.Exception.CommonValidateException;

public class CommonValidator {

    public static void validateIntegerInput(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), e);
        }
    }

    public static void validateBlankInput(String str) {
    }

    public static void validateEmptyInput(String str) {
    }
}
