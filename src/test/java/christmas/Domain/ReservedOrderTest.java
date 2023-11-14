package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservedOrderTest {

    ReservedMenuGroup menuGroup1 = new ReservedMenuGroup("타파스-1,제로콜라-1");
    ReservedMenuGroup menuGroup2 = new ReservedMenuGroup("크리스마스파스타-19,제로콜라-1");
    ReservedDate date = new ReservedDate("3");
    ReservedOrder reservedOrder1 = new ReservedOrder(menuGroup1, date);
    ReservedOrder reservedOrder2 = new ReservedOrder(menuGroup2, date);

    @Test
    @DisplayName("주문한 메뉴의 전체 금액이 증정 이벤트 기준보다 낮을때 증정 품목을 받지 못한다.")
    void getGifts() {
        Map<String, Integer> gifts1 = reservedOrder1.getGifts();

        assertEquals(0, gifts1.size());
    }

    @Test
    void getBenefitRecord() {
    }

    @Test
    void getTotalPriceAfterDiscount() {
    }

    @Test
    void getTotalPriceBeforeDiscount() {
    }
}