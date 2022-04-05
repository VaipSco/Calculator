package ru.vaipsco.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vaipsco.calculator.service.CalculatorService;

@SpringBootTest
class CalculatorApplicationTests {

    @Autowired
    CalculatorService calculatorService;

    @Test
    void sumTest() {
        Assertions.assertEquals(calculatorService.sum(new double[]{1,23}), "24.0");
        Assertions.assertEquals(calculatorService.sum(new double[]{25,25}), "50.0");
        Assertions.assertEquals(calculatorService.sum(new double[]{50,50}), "100.0");
        Assertions.assertEquals(calculatorService.sum(new double[]{33,33,33}), "99.0");
        Assertions.assertEquals(calculatorService.sum(new double[]{-10,20}), "10.0");
        Assertions.assertEquals(calculatorService.sum(new double[]{90}), "90.0");
    }

    @Test
    void subTest() {
        Assertions.assertEquals(calculatorService.subtract(new double[]{1,23}), "-22.0");
        Assertions.assertEquals(calculatorService.subtract(new double[]{0,99}), "-99.0");
        Assertions.assertEquals(calculatorService.subtract(new double[]{-5,-10}), "5.0");
        Assertions.assertEquals(calculatorService.subtract(new double[]{-5,5}), "-10.0");
        Assertions.assertEquals(calculatorService.subtract(new double[]{100,40,10,20}), "30.0");
    }

    @Test
    void multiTest() {
        Assertions.assertEquals(calculatorService.multiplication(new double[]{5,5}), "25.0");
        Assertions.assertEquals(calculatorService.multiplication(new double[]{5,5,5}), "125.0");
        Assertions.assertEquals(calculatorService.multiplication(new double[]{5,-5,5}), "-125.0");
        Assertions.assertEquals(calculatorService.multiplication(new double[]{5,0,5}), "0.0");

    }

    @Test
    void divideTest() {
        Assertions.assertEquals(calculatorService.divide(new double[]{5,5}), "1.0");
        Assertions.assertEquals(calculatorService.divide(new double[]{-25,5}), "-5.0");
        Assertions.assertEquals(calculatorService.divide(new double[]{125,5,-5}), "-5.0");
        Assertions.assertEquals(calculatorService.divide(new double[]{125,0,-5}), "\"error: division by zero\"");

    }

}
