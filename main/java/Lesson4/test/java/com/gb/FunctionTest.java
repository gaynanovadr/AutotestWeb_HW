package com.gb;

import Lesson4.Function;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    @BeforeAll
    static void beforeAll(){
    }
    @BeforeEach
    void beforeEach(){
    }
    @Test
    void givenCorrectValuesThenTrue() {
        Assertions.assertTrue(Function.correctValues(3, 2, 5));
    }

    @Test
    void givenNonCorrectValuesThenFalse() {
        Assertions.assertFalse(Function.correctValues(0, 2, -5));
    }

    @Test
    void givenCorrectValuesThenTrueTriangleExistence() {
        Assertions.assertTrue(Function.existenceOfTriangle(3, 4, 5));
    }

    @Test
    void givenNonCorrectValuesThenFalseTriangleNoExistence() {
        Assertions.assertFalse(Function.existenceOfTriangle(10, 2, 5));
    }

    @Test
    void givenCorrectValuesThenSquareIsCorrect() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(6, Function.triangleSquare(3, 4, 5)),
                () -> Assertions.assertEquals(20, Function.triangleSquare(6, 7, 9)),
                () -> Assertions.assertEquals(34, Function.triangleSquare(7, 10, 11))
        );
    }

    @AfterEach
    void afterEach() {
    }

    @AfterAll
    static void afterAll() {
    }
}
