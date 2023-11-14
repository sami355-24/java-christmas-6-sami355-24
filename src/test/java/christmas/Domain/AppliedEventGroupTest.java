package christmas.Domain;

import static christmas.Constant.Event.SANTA_BADGE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
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
    void findTotalEventAmount() {
    }

    @Test
    void findEventAmounts() {
    }

    @Test
    void getAppliedEventGroup() {
    }
}