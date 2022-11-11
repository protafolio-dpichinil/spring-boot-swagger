package cl.dpichinil.test.springbootswagger.controller;

import cl.dpichinil.test.springbootswagger.dto.OperandosDto;
import cl.dpichinil.test.springbootswagger.service.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/operations")
@RestController
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @PostMapping("sum")
    public int sum(@RequestBody OperandosDto operandosDto){
        return calculatorService.sum(operandosDto);
    }

    @PostMapping("subtraction")
    public int subtraction(@RequestBody OperandosDto operandosDto){
        return calculatorService.subtraction(operandosDto);
    }

    @PostMapping("multiply")
    public int multiply(@RequestBody OperandosDto operandosDto){
        return calculatorService.multiply(operandosDto);
    }

    @PostMapping("divide")
    public int divide(@RequestBody OperandosDto operandosDto){
        return calculatorService.divide(operandosDto);
    }
}
