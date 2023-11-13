package christmas.Common;

import static christmas.Common.Utility.convertStringToInt;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilityTest {

    @Test
    @DisplayName("정수로 변환하는 기능을 테스트한다.")
    void convertStringToIntTest() {
        assertEquals(1, convertStringToInt("1"));
    }

}