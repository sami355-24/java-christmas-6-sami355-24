package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final int normalDay = 4;
    private final int discountPriceInNormalDay = 1300;
    private final int dessertCount = 2;
    private final int discountPriceInWeekday = 4046;
    private final int mainDishCount = 3;
    private final int discountPriceInWeekend = 6069;
    private final String menuInput = "해산물파스타-2,레드와인-1,초코케이크-1";

    @Test
    @DisplayName("크리스마스 디데이 할인 금액을 계산한다.")
    void calculateChristmasDiscountTest() {
        int calculated = calculator.calculateChristmasDiscount(normalDay);
        assertEquals(discountPriceInNormalDay, calculated);
    }

    @Test
    @DisplayName("주중 할인 금액을 계산한다.")
    void calculateWeekdayDiscountTest() {
        int calculated = calculator.calculateWeekdayDiscount(dessertCount);
        assertEquals(discountPriceInWeekday, calculated);
    }

    @Test
    @DisplayName("주말 할인 금액을 계산한다.")
    void calculateWeekendDiscountTest() {
        int calculated = calculator.calculateWeekendDiscount(mainDishCount);
        assertEquals(discountPriceInWeekend, calculated);
    }

    @Test
    @DisplayName("특별 할인 금액을 계산한다.")
    void specialDiscountTest() {
        int calculated = calculator.specialDiscount();
        assertEquals(1000, calculated);
    }

    @Test
    @DisplayName("증정 혜택 금액을 계산한다.")
    void giftBenefitTest() {
        int calculated = calculator.giftEventAmount();
        assertEquals(Menu.CHAMPAGNE.getPrice(), calculated);
    }

    @Test
    @DisplayName("할인 적용 전 총 금액을 계산한다.")
    void calculateTotalPriceBeforeDiscountTest() {
        ReservedMenuGroup menuGroup = new ReservedMenuGroup(menuInput);
        int calculatedPrice = calculator.calculateTotalPriceBeforeDiscount(menuGroup);

        assertEquals(
                Menu.SEA_FOOD_PASTA.getPrice() * 2 +
                        Menu.RED_WINE.getPrice() +
                        Menu.CHOCO_CAKE.getPrice()
                , calculatedPrice
        );
    }



}