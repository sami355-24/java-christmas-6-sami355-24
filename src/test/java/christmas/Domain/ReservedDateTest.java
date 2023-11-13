package christmas.Domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.Exception.CommonValidateException;
import christmas.Exception.DateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservedDateTest {

    @Test
    @DisplayName("범위에 맞는 날짜로 예약일자 객체를 생성시 정상 수행된다.")
    void createReservedDateTest() {
        ReservedDate reservedDate = new ReservedDate("1");
        assertEquals(1, reservedDate.getDay());
    }

    @Test
    @DisplayName("범위에 맞지 않는 날짜로 예약일자 객체를 생성시 예외를 발생시킨다.")
    void createReservedDateExceptionTest1() {
        assertThrows(DateException.class, () -> new ReservedDate("0"));
        assertThrows(DateException.class, () -> new ReservedDate("32"));
    }

    @Test
    @DisplayName("숫자이외의 값으로 예약일자 객체를 생성시 예외를 발생시킨다.")
    void createReservedDateExceptionTest2() {
        assertThrows(CommonValidateException.class, () -> new ReservedDate("a"));
        assertThrows(CommonValidateException.class, () -> new ReservedDate(""));
        assertThrows(CommonValidateException.class, () -> new ReservedDate(" "));
    }
}