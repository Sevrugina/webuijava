package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.example.lesson4.Functions.isPalindrome;

public class AreaTest {
    @Test
    @DisplayName("Проверка треугольника с валидными сторонами")
    void triangleValidTest() throws SideIsOrLessZero {
        Assertions.assertEquals(AreaTriangle.areaTriangleOnThreeSides(3, 3, 3), 3.897, 0.001);
    }

    @Test
    @DisplayName("Проверка треугольника со стороной, равной нулю")
    void triangleSideIsZeroTest() {
        Assertions.assertThrows(SideIsOrLessZero.class, () -> AreaTriangle.areaTriangleOnThreeSides(0, 3, 3));

    }

    @Test
    @DisplayName("Проверка треугольника с отрицательной стороной")
    void triangleSideLessZeroTest() {
        Assertions.assertThrows(SideIsOrLessZero.class, () -> AreaTriangle.areaTriangleOnThreeSides(-5, 3, 3));
    }

    @ParameterizedTest
    @DisplayName("Проверка валидности треугольника c валидными сторонами")
    @ValueSource(strings = {"3, 3, 3", "8, 4, 5"})
    void ValidData(String data) {
        boolean result = AreaTriangle.isTriangleValid(data);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @DisplayName("Проверка валидности треугольника с невалидными сторонами")
    @ValueSource(strings = {"0, 3, 3", "-5, 3, 3", "1, 4, 5"})
    void NoValidData(String data) {
        boolean result = AreaTriangle.isTriangleValid(data);
        Assertions.assertFalse(result);
    }
}