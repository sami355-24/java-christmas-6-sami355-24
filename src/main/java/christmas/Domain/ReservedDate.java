package christmas.Domain;

import static christmas.CommonValidator.CommonValidator.validateBlankInput;
import static christmas.CommonValidator.CommonValidator.validateEmptyInput;
import static christmas.CommonValidator.CommonValidator.validateIntegerInput;
import static christmas.Constant.Date.CHRISTMAS;
import static christmas.Constant.Date.MAX_DAY;
import static christmas.Constant.Date.MIN_DAY;
import static christmas.Constant.Date.MONTH;
import static christmas.Constant.Date.SATURDAY;
import static christmas.Constant.Date.SUNDAY;
import static christmas.Constant.Date.YEAR;
import static christmas.Message.Excepton.ExceptionPrompt.INVALID_DATE;
import static christmas.Utility.Utility.convertStringToInt;

import christmas.Exception.DateException;
import java.time.LocalDate;

public class ReservedDate {

    private final LocalDate date;

    public ReservedDate(String day) {
        validate(day);
        this.date = LocalDate.of(YEAR.getValue(), MONTH.getValue(), convertStringToInt(day));
    }

    private void validate(String day) {
        validateIntegerInput(day);
        validateBlankInput(day);
        validateEmptyInput(day);
        validateDay(convertStringToInt(day));
    }

    private void validateDay(int day) {
        if (day < MIN_DAY.getValue() || day > MAX_DAY.getValue()) {
            throw new DateException(INVALID_DATE.getPrompt(), new IllegalArgumentException());
        }
    }

    public boolean isWeekend() {
        return date.getDayOfWeek().getValue() == SATURDAY.getValue()
                || date.getDayOfWeek().getValue() == SUNDAY.getValue();
    }

    public boolean isWeekDay() {
        return date.getDayOfWeek().getValue() < SATURDAY.getValue();
    }

    public boolean isChristmasFuture() {
        return date.getDayOfMonth() <= CHRISTMAS.getValue();
    }

    public boolean isStarDay() {
        return date.getDayOfWeek().getValue() == SUNDAY.getValue() || date.getDayOfMonth() == CHRISTMAS.getValue();
    }

    public int getDay() {
        return date.getDayOfMonth();
    }
}
