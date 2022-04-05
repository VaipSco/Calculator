package ru.vaipsco.calculator.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vaipsco.calculator.service.CalculatorService;

@RestController
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping(value = "/sum", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Суммирование", notes = "Принимает на вход массив чисел через запятую. Возвращает результат суммирования.")
    public String sum(@RequestParam(name = "values") double[] parameters) {
        return String.format("{\"result\":%s}", calculatorService.sum(parameters));
    }

    @GetMapping(value = "/sub", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Вычитание", notes = "Принимает на вход массив чисел через запятую. Возвращает результат вычитания.")
    public String sub(@RequestParam(name = "values") double[] parameters) {
        return String.format("{\"result\":%s}", calculatorService.subtract(parameters));
    }

    @GetMapping(value = "/multi", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Умножение", notes = "Принимает на вход массив чисел через запятую. Возвращает результат умножения.")
    public String multi(@RequestParam(name = "values") double[] parameters) {
        return String.format("{\"result\":%s}", calculatorService.multiplication(parameters));
    }

    @GetMapping(value = "/divide", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Деление", notes = "Принимает на вход массив чисел через запятую. Возвращает результат деления.")
    public String divide(@RequestParam(name = "values") double[] parameters) {
        return String.format("{\"result\":%s}", calculatorService.divide(parameters));
    }

}
