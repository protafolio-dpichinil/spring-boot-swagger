package cl.dpichinil.test.springbootswagger.controller;

import cl.dpichinil.test.springbootswagger.dto.OperandosDto;
import cl.dpichinil.test.springbootswagger.dto.ResponseDto;
import cl.dpichinil.test.springbootswagger.service.CalculatorService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDto> sum(@RequestBody OperandosDto operandosDto){
        return calculatorService.sum(operandosDto);
    }

    @PostMapping("subtraction")
    public ResponseEntity<ResponseDto> subtraction(@RequestBody OperandosDto operandosDto){
        return calculatorService.subtraction(operandosDto);
    }

    @PostMapping("multiply")
    public ResponseEntity<ResponseDto> multiply(@RequestBody OperandosDto operandosDto){
        return calculatorService.multiply(operandosDto);
    }

    @PostMapping("divide")
    public ResponseEntity<ResponseDto> divide(@RequestBody OperandosDto operandosDto){
        return calculatorService.divide(operandosDto);
    }
}
