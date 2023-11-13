package christmas.Domain;

import static christmas.CommonValidator.CommonValidator.validateBlankInput;
import static christmas.CommonValidator.CommonValidator.validateEmptyInput;
import static christmas.CommonValidator.CommonValidator.validateIntegerInput;
import static christmas.Message.Excepton.ExceptionPrompt.INVALID_DATE;
import static christmas.Utility.Utility.convertStringToInt;

import christmas.Exception.DateException;

public class ReservedDate {

    private int day;
    private final int MIN_DAY = 1;
    private final int MAX_DAY = 31;

    public ReservedDate(String day) {
        validate(day);
        this.day = convertStringToInt(day);
    }

    private void validate(String day) {
        validateIntegerInput(day);
        validateBlankInput(day);
        validateEmptyInput(day);
        validateDay(convertStringToInt(day));
    }

    private void validateDay(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new DateException(INVALID_DATE.getPrompt(), new IllegalArgumentException());
        }
    }

    public int getDay() {
        return day;
    }
}
