package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final int normalDay = 4;
    private final int christmasDay = 25;
    private final int weekendDay = 1;
    private final int starDay = 3;

    @Test
    @DisplayName("크리스마스 디데이 할인 금액을 계산한다.")
    void calculateChristmasDiscount() {
        int calculated = calculator.calculateChristmasDiscount(normalDay);
        assertEquals(1300, calculated);
    }
}