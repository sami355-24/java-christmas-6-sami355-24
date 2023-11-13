package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final int normalDay = 4;
    private final int discountPriceInNormalDay = 1300;
    private final int dessertCount = 2;
    private final int discountPriceInWeekday = 4046;
    private final int christmasDay = 25;

    @Test
    @DisplayName("크리스마스 디데이 할인 금액을 계산한다.")
    void calculateChristmasDiscountTest() {
        int calculated = calculator.calculateChristmasDiscount(normalDay);
        assertEquals(discountPriceInNormalDay, calculated);
    }

    @Test
    @DisplayName("주중 할인 금액을 계산한다.")
    void calculateWeekdayDiscountTest(){
        int calculated = calculator.calculateWeekdayDiscount(dessertCount);
        assertEquals(discountPriceInWeekday, calculated);
    }
}