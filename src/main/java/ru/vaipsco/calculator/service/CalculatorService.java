package ru.vaipsco.calculator.service;

import org.springframework.stereotype.Service;

// Была идея сделать всего один метод, который бы принимал на вход помимо массива значений символ операции. Это с одной
// стороны сократило количество кода, но сделала бы его менее понятным (на мой взгляд). Поэтому я решил сделать отдельный
// метод для каждой операции, чтобы всё было удобночитаемо и понятно.

@Service
public class CalculatorService {

    public String sum(double[] paramsArray) {
        double result = 0;
        for (double param : paramsArray) {
            result += param;
        }
        return String.valueOf(result);
    }

    public String subtract(double[] paramsArray) {
        double result = paramsArray[0];
        for (int i = 1; i < paramsArray.length; i++) {
            result -= paramsArray[i];
        }
        return String.valueOf(result);
    }

    public String multiplication(double[] paramsArray) {
        double result = 1;
        for (double param : paramsArray) {
            result *= param;
        }
        return String.valueOf(result);
    }

    // Заметил интересное поведение, пока писал метод. Оказывается, если делить целочисленное число на ноль,
    // то выкинет исключение, а если разделить примитив типа double на ноль, то никакого исключения не будет, ответом будет "infinity".
    // Идея с исключением мне понравилась больше, поэтому я её обыграл в методе.
    // upd. Оказывается, так и было задумано :)
    public String divide(double[] paramsArray) {
        double result = paramsArray[0];
        try {
            for (int i = 1; i < paramsArray.length; i++) {
                if (paramsArray[i] == 0) throw new ArithmeticException();
                result /= paramsArray[i];
            }
        } catch (ArithmeticException e) {
            return String.format("\"%s\"", "error: division by zero");
        }
        return String.valueOf(result);
    }



}
