package org.example.lesson4;

import java.util.Arrays;

public class AreaTriangle {
    // Метод вычисления площади треугольника: дано a, b, c -стороны , возвращает площадь треугольника
    public static double areaTriangleOnThreeSides(double a, double b, double c) throws SideIsOrLessZero {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new SideIsOrLessZero();
        }
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p -a)*(p -b)*(p -c));
    }


    public static boolean isTriangleValid(String s) {
        String[] strArr = s.split(",");
        double[] numArr = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Double.parseDouble(strArr[i]);
        }
        Arrays.sort(numArr);
        return !(numArr[0] <= 0) && !(numArr[2] >= numArr[0] + numArr[1]);
    }
}


