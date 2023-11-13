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
        String validDay = "1";
        ReservedDate reservedDate = new ReservedDate(validDay);
        assertEquals(1, reservedDate.getDay());
    }

    @Test
    @DisplayName("범위에 맞지 않는 날짜로 예약일자 객체를 생성시 예외를 발생시킨다.")
    void createReservedDateExceptionTest1() {
        final String invalidRangeDay1 = "0";
        final String invalidRangeDay2 = "32";

        assertThrows(DateException.class, () -> new ReservedDate(invalidRangeDay1));
        assertThrows(DateException.class, () -> new ReservedDate(invalidRangeDay2));
    }

    @Test
    @DisplayName("숫자이외의 값으로 예약일자 객체를 생성시 예외를 발생시킨다.")
    void createReservedDateExceptionTest2() {
        final String stringInput = "a";
        final String blankInput = "";
        final String emptyInput = " ";

        assertThrows(CommonValidateException.class, () -> new ReservedDate(stringInput));
        assertThrows(CommonValidateException.class, () -> new ReservedDate(blankInput));
        assertThrows(CommonValidateException.class, () -> new ReservedDate(emptyInput));
    }

    @Test
    @DisplayName("평일 할인에 해당되는 날짜로 예약하였을때 평일 할인에 해당한다고 알려준다.")
    void isWeekDayTest() {
        ReservedDate reservedDate = new ReservedDate("1");
        assertTrue(reservedDate.isWeekDay());
    }
}