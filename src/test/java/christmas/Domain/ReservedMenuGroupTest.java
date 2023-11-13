package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservedMenuGroupTest {

    private final String validMenuInput = "해산물파스타-2,레드와인-1,초코케이크-1";

    @Test
    @DisplayName("메뉴와 개수를 입력하면 해당하는 메뉴와 개수를 예약한다.")
    void findAllReservedMenuTest(){
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput);
        Map<Menu, Integer> allReservedMenu = reservedMenuGroup.getMenuGroup();

        //then
        assertEquals(3, allReservedMenu.size());
        assertEquals(2, allReservedMenu.get(Menu.SEA_FOOD_PASTA));
        assertEquals(1, allReservedMenu.get(Menu.RED_WINE));
        assertEquals(1, allReservedMenu.get(Menu.CHOCO_CAKE));
    }

    @Test
    @DisplayName("예약한 메뉴중 디저트의 개수를 반환한다.")
    void countDessertTest(){
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput);
        int dessertCount = reservedMenuGroup.countDessert();

        //then
        assertEquals(1, dessertCount);
    }

    @Test
    @DisplayName("예약한 메뉴중 메인메뉴의 개수를 반환한다.")
    void countMainDishTest(){
        //when
        ReservedMenuGroup reservedMenuGroup = new ReservedMenuGroup(validMenuInput);
        int MainDishCount = reservedMenuGroup.countMainDish();

        //then
        assertEquals(2, MainDishCount);
    }
}