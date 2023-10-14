package pro.sky.skypro.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro.calculator.servise.CalculatorServise;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServise calculatorServise;

    public CalculatorController(CalculatorServise calculatorServise) {
        this.calculatorServise = calculatorServise;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorServise.sum(num1, num2);
        return creaters(num1, num2, '+', result);
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorServise.subtract(num1, num2);
        return creaters(num1, num2, '-', result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorServise.multiply(num1, num2);
        return creaters(num1, num2, '*', result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0){
           return "Делить на ноль нальзя";
        }
        int result = calculatorServise.divide(num1, num2);
        return creaters(num1, num2, '/', result);
    }

    private String creaters(int num1, int num2, char action, int result) {
        return String.format("%d %c %d = %d", num1, action, num2, result);
    }

}
