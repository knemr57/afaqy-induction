package com.afaqy.service.junit;

import org.junit.jupiter.api.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addition() {
        int actual = calculator.add(1, 1);
        int expected = 2;
        Assertions.assertEquals(expected, actual, "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        Assertions.assertEquals(20, calculator.multiply(4, 5), "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        Assertions.assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
        Assertions.assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
    }

}
