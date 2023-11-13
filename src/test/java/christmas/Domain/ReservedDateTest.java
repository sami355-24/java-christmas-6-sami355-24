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
    void isWeekDayTest1() {
        ReservedDate reservedDate = new ReservedDate("1");
        assertTrue(reservedDate.isWeekDay());
    }

    @Test
    @DisplayName("평일 할인에 해당되지 않는 날짜로 예약했을때 평일 할인에 해당되지 않는다고 알려준다.")
    void isWeekDayTest2() {
        String FRIDAY = "2";

        ReservedDate reservedDate = new ReservedDate(FRIDAY);
        assertFalse(reservedDate.isWeekDay());
    }

    @Test
    @DisplayName("주말 할인에 해당되는 날짜로 예약했을때 주말 할인에 해당한다고 알려준다.")
    void isWeekendTest1() {
        String FRIDAY = "1";
        String SATURDAY = "2";

        ReservedDate reservedDate1 = new ReservedDate(FRIDAY);
        ReservedDate reservedDate2 = new ReservedDate(SATURDAY);

        assertTrue(reservedDate1.isWeekend());
        assertTrue(reservedDate2.isWeekend());
    }

    @Test
    @DisplayName("주말 할인에 해당되지 않는 날짜로 예약했을때 주말 할인에 해당되지 않는다고 알려준다.")
    void isWeekendTest2() {
        String SUNDAY = "3";
        String MONDAY = "4";

        ReservedDate reservedDate2 = new ReservedDate(SUNDAY);
        ReservedDate reservedDate1 = new ReservedDate(MONDAY);

        assertFalse(reservedDate2.isWeekend());
        assertFalse(reservedDate1.isWeekend());
    }

    @Test
    @DisplayName("특별 할인에 해당되는 날짜로 예약했을때 특별 할인에 해당한다고 알려준다.")
    void isStarDayTest1() {
        String SUNDAY = "3";
        String CHRISTMAS = "25";

        ReservedDate reservedDate1 = new ReservedDate(SUNDAY);
        ReservedDate reservedDate2 = new ReservedDate(CHRISTMAS);

        assertTrue(reservedDate1.isStarDay());
        assertTrue(reservedDate2.isStarDay());
    }

    @Test
    @DisplayName("특별 할인에 해당되지 않는 날짜로 예약했을때 특별 할인에 해당되지 않는다고 알려준다.")
    void isStarDayTest2() {
        String MONDAY = "4";
        String TUESDAY = "26";

        ReservedDate reservedDate1 = new ReservedDate(MONDAY);
        ReservedDate reservedDate2 = new ReservedDate(TUESDAY);

        assertFalse(reservedDate1.isStarDay());
        assertFalse(reservedDate2.isStarDay());
    }

    @Test
    @DisplayName("크리스마스 할인에 해당되는 날짜로 예약했을때 크리스마스 할인에 해당된다고 알려준다.")
    void isChristmasPassedTest1() {
        String CHRISTMAS = "25";

        ReservedDate reservedDate = new ReservedDate(CHRISTMAS);

        assertTrue(reservedDate.isChristmasPassed());
    }

    @Test
    @DisplayName("크리스마스 할인에 해당되지 않는 날짜로 예약했을때 크리스마스 할인에 해당되지 않는다고 알려준다.")
    void isChristmasPassedTest2() {
        String CHRISTMAS = "26";

        ReservedDate reservedDate = new ReservedDate(CHRISTMAS);

        assertFalse(reservedDate.isChristmasPassed());
    }
}