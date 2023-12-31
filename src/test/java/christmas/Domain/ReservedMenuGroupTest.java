package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import christmas.Exception.MenuException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservedMenuGroupTest {

    private final String validMenuInput1 = "해산물파스타-2,레드와인-1,초코케이크-1";
    private final String validMenuInput2 = "티본스테이크-2";
    private final String invalidMenuInput1 = "레드와인-1";
    private final String invalidMenuInput2 = "존재하지 않는 메뉴-1";
    private final String invalidMenuInput3 = "해산물파스타-21,레드와인-1,초코케이크-1";
    private final String invalidMenuInput4 = "해산물파스타-2,레드와인-1,초코케이크-1,1-1-1";
    private final String invalidMenuInput5 = "해산물파스타-2,레드와인-1,초코케이크-1,해산물파스타-2";

    @Test
    @DisplayName("메뉴와 개수를 입력하면 해당하는 메뉴와 개수를 예약한다.")
    void findAllReservedMenuTest() {
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput1);
        Map<Menu, Integer> allReservedMenu = reservedMenuGroup.getMenuGroup();

        //then
        assertEquals(3, allReservedMenu.size());
        assertEquals(2, allReservedMenu.get(Menu.SEA_FOOD_PASTA));
        assertEquals(1, allReservedMenu.get(Menu.RED_WINE));
        assertEquals(1, allReservedMenu.get(Menu.CHOCO_CAKE));
    }

    @Test
    @DisplayName("음료를 제외한 메뉴만 입력하면 해당하는 메뉴와 개수를 예약한다.")
    void findAllReservedMenuExceptBeverageTest() {
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput2);
        Map<Menu, Integer> allReservedMenu = reservedMenuGroup.getMenuGroup();

        //then
        assertEquals(1, allReservedMenu.size());
        assertEquals(2, allReservedMenu.get(Menu.T_BONE_STEAK));
    }

    @Test
    @DisplayName("예약한 메뉴중 디저트의 개수를 반환한다.")
    void countDessertTest() {
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput1);
        int dessertCount = reservedMenuGroup.countDessert();

        //then
        assertEquals(1, dessertCount);
    }

    @Test
    @DisplayName("예약한 메뉴중 메인메뉴의 개수를 반환한다.")
    void countMainDishTest() {
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput1);
        int MainDishCount = reservedMenuGroup.countMainDish();

        //then
        assertEquals(2, MainDishCount);
    }

    @Test
    @DisplayName("음료만 주문하였을때 예외를 발생시킨다.")
    void hasOnlyBeveragesTest() {
        assertThrows(MenuException.class, () -> new ReservedMenuGroup(invalidMenuInput1));
    }

    @Test
    @DisplayName("메뉴의 이름이 존재하지 않을때 예외를 발생시킨다.")
    void hasValidMenuNameTest() {
        assertThrows(MenuException.class, () -> new ReservedMenuGroup(invalidMenuInput2));
    }

    @Test
    @DisplayName("메뉴의 개수가 0개 이하 또는 20개 초과일때 예외를 발생시킨다.")
    void hasValidMenuCountTest() {
        assertThrows(MenuException.class, () -> new ReservedMenuGroup(invalidMenuInput3));
    }

    @Test
    @DisplayName("메뉴의 형식이 올바르지 않을때 예외를 발생시킨다.")
    void isValidFormatTest() {
        assertThrows(MenuException.class, () -> new ReservedMenuGroup(invalidMenuInput4));
    }

    @Test
    @DisplayName("중복된 메뉴가 있을때 예외를 발생시킨다.")
    void idDuplicateMenuTest() {
        assertThrows(MenuException.class, () -> new ReservedMenuGroup(invalidMenuInput5));
    }
}