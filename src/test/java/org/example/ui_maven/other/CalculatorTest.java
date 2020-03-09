package org.example.ui_maven.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void setUpPreconditions() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addTwoNumber() {
        log.info("Test method - addTwoNumber(): 1 + 1 = " + calculator.calculate(1, 1));
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
        log.info("Test method - add(): {} + {} = {}", first, second, calculator.calculate(first, second));
        assertEquals(expectedResult, calculator.calculate(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void addToSeven(int secondNumber) throws ClassNotFoundException, NoSuchMethodException {
        log.info("Test method - {}(): 7 + {} = {}",
                Class.forName("org.example.ui_maven.other.CalculatorTest").getMethod("addToSeven", int.class).getName(),
                secondNumber,
                calculator.calculate(7, secondNumber));
        assertEquals(7 + secondNumber, calculator.calculate(7, secondNumber), "Calculate method is broken");
    }
}
