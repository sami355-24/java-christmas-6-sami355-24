package christmas.CommonValidator;

import static christmas.CommonValidator.CommonValidator.validateIntegerInput;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.Exception.CommonValidateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonValidatorTest {

    private final String INTEGER_INPUT = "1";
    private final String BLANK_INPUT = " ";
    private final String EMPTY_INPUT = "";

    @Test
    @DisplayName("정수 입력 검증을 하는 기능을 테스트한다.")
    void validateIntegerInputTest() {
        assertDoesNotThrow(() -> validateIntegerInput(INTEGER_INPUT));
        assertThrows(CommonValidateException.class, () -> validateIntegerInput(BLANK_INPUT));
        assertThrows(CommonValidateException.class, () -> validateIntegerInput(EMPTY_INPUT));
    }

    @Test
    void validateBlankInput() {
    }

    @Test
    void validateEmptyInput() {
    }
}