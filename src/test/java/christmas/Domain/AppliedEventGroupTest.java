package christmas.Domain;

import static christmas.Constant.Event.SANTA_BADGE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppliedEventGroupTest {

    private final String validMenuInput1 = "해산물파스타-2,레드와인-1,초코케이크-1";
    private final String validMenuInput2 = "티본스테이크-2";
    private final ReservedMenuGroup reservedMenuGroup1 = new ReservedMenuGroup(validMenuInput1);
    private final ReservedMenuGroup reservedMenuGroup2 = new ReservedMenuGroup(validMenuInput2);
    private final ReservedDate date = new ReservedDate("3");
    private AppliedEventGroup appliedEventGroup1 = new AppliedEventGroup(reservedMenuGroup1, date);
    private AppliedEventGroup appliedEventGroup2 = new AppliedEventGroup(reservedMenuGroup2, date);

    @Test
    @DisplayName("올바른 배지를 받을 수 있는지 확인한다.")
    void getBadge() {
        String badge = appliedEventGroup1.getBadge();
        assertThat(badge).isEqualTo(SANTA_BADGE.getValue());
    }

    @Test
    @DisplayName("이벤트 금액의 총합을 구한다.")
    void findTotalEventAmount() {
        int totalEventAmount = appliedEventGroup1.findTotalEventAmount();
        assertThat(totalEventAmount).isEqualTo(29_223);
    }

    @Test
    @DisplayName("이벤트 금액들이 있는 리스트를 구한다.")
    void findEventAmounts() {
        List<Integer> eventAmounts1 = appliedEventGroup1.findEventAmounts();
        assertThat(eventAmounts1).containsExactly(25_000, 1_200,2_023,1_000);
    }

    @Test
    @DisplayName("적용된 이벤트가 있는 리스트를 구한다.")
    void getAppliedEventGroup() {
        Map<String, Integer> appliedEventGroup = appliedEventGroup1.getAppliedEventGroup();
        assertThat(appliedEventGroup.size()).isEqualTo(4);
    }
}