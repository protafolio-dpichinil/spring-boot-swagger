package cl.dpichinil.test.springbootswagger.controller;

import cl.dpichinil.test.springbootswagger.controller.swagger.calculator.CalculatorDivideAnnotation;
import cl.dpichinil.test.springbootswagger.controller.swagger.calculator.CalculatorMultiplyAnnotation;
import cl.dpichinil.test.springbootswagger.controller.swagger.calculator.CalculatorSubtractionsAnnotation;
import cl.dpichinil.test.springbootswagger.controller.swagger.calculator.CalculatorSumAnnotation;
import cl.dpichinil.test.springbootswagger.dto.OperandosDto;
import cl.dpichinil.test.springbootswagger.dto.ResponseDto;
import cl.dpichinil.test.springbootswagger.service.CalculatorService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/operations")
@RestController
public class CalculatorController {
    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @PostMapping("sum/{operando1}/{operando2}")
    @CalculatorSumAnnotation
    public ResponseEntity<ResponseDto> sum(
            @Parameter(description = "operando 1 para la operacion deseada", example = "1", name = "Operando1") @PathVariable("operando1") Integer operando1,
            @Parameter(description = "operando 2 para la operacion deseada", example = "2") @PathVariable("operando2") Integer operando2){
        OperandosDto operandosDto = new OperandosDto();
        operandosDto.setOperando1(operando1);
        operandosDto.setOperando2(operando2);
        return calculatorService.sum(operandosDto);
    }

    @PostMapping("subtraction")
    @CalculatorSubtractionsAnnotation
    public ResponseEntity<ResponseDto> subtraction(
            @Parameter(description = "operando 1 para la operacion deseada", example = "3", name = "op1") @RequestParam(name="op1") int operando1,
            @Parameter(description = "operando 1 para la operacion deseada", example = "1", name = "op2") @RequestParam(name="op2") int operando2
            ){
        OperandosDto operandosDto = new OperandosDto();
        operandosDto.setOperando1(operando1);
        operandosDto.setOperando2(operando2);
        return calculatorService.subtraction(operandosDto);
    }

    @PostMapping("multiply")
    @CalculatorMultiplyAnnotation
    public ResponseEntity<ResponseDto> multiply(@RequestBody OperandosDto operandosDto){
        return calculatorService.multiply(operandosDto);
    }

    @PostMapping("divide")
    @CalculatorDivideAnnotation
    public ResponseEntity<ResponseDto> divide(@RequestBody OperandosDto operandosDto){
        return calculatorService.divide(operandosDto);
    }
}
