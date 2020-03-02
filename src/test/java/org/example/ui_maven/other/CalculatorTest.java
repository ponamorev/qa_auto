package org.example.ui_maven.other;

import org.example.ui_maven.other.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("1 + 1 = 2")
    void addTwoNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.calculate(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,    1",
            "1,    2,    3",
            "49,  51,  100",
            "1,  100,  101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.calculate(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }
}
