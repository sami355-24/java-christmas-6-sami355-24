package christmas.Domain;

import static org.assertj.core.api.Assertions.*;
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
    @DisplayName("주문한 메뉴의 전체 금액이 할인을 받을 수 있는 기준 금액보다 높을때 할인 받을 수 있다.")
    void getBenefitRecord() {
        AppliedEventGroup appliedEventGroup = reservedOrder2.getAppliedEvent();

        assertThat(appliedEventGroup.getAppliedEventGroup()).isNotEmpty();
    }

    @Test
    @DisplayName("예약한 메뉴들의 할인전 총합이 맞는지 확인한다.")
    void getTotalPriceAfterDiscount() {
        int totalPriceBeforeDiscount = reservedOrder1.getTotalPriceBeforeDiscount();

        assertThat(totalPriceBeforeDiscount).isEqualTo(8500);
    }

    @Test
    @DisplayName("예약한 메뉴들의 할인후 총합이 맞는지 확인한다.")
    void getTotalPriceBeforeDiscount() {
        int totalPriceAfterDiscount = reservedOrder1.getTotalPriceAfterDiscount();

        assertThat(totalPriceAfterDiscount).isEqualTo(8500);
    }
}