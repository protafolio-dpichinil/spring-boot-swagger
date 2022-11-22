package cl.dpichinil.test.springbootswagger.service;

import cl.dpichinil.test.springbootswagger.dto.OperandosDto;
import cl.dpichinil.test.springbootswagger.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {
    private final String LOG_NUMBERS = "datos de la operacion %s: { num1: %d num2: %d }";
    private final String LOG_RESULT = "el resultado de la operacion %s es %d";


    public ResponseEntity<ResponseDto> sum(OperandosDto operandosDto) {
        String operation = "suma";
        log.info(String.format(this.LOG_NUMBERS, operation, operandosDto.getOperando1(), operandosDto.getOperando2()));
        int result = operandosDto.getOperando1() + operandosDto.getOperando2();
        log.info(String.format(this.LOG_RESULT, operation, result));
        ResponseDto response = new ResponseDto(0,result,"OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> subtraction(OperandosDto operandosDto) {
        String operation = "resta";
        log.info(String.format(this.LOG_NUMBERS, operation, operandosDto.getOperando1(), operandosDto.getOperando2()));
        int result = operandosDto.getOperando1() - operandosDto.getOperando2();
        log.info(String.format(this.LOG_RESULT, operation, result));
        ResponseDto response = new ResponseDto(0,result,"OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> divide(OperandosDto operandosDto) {
        String operation = "division";
        log.info(String.format(this.LOG_NUMBERS, operation, operandosDto.getOperando1(), operandosDto.getOperando2()));
        int result = operandosDto.getOperando1() / operandosDto.getOperando2();
        log.info(String.format(this.LOG_RESULT, operation, result));
        ResponseDto response = new ResponseDto(0,result,"OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> multiply(OperandosDto operandosDto) {
        String operation = "multiplicacion";
        log.info(String.format(this.LOG_NUMBERS, operation, operandosDto.getOperando1(), operandosDto.getOperando2()));
        int result = operandosDto.getOperando1() * operandosDto.getOperando2();
        log.info(String.format(this.LOG_RESULT, operation, result));
        ResponseDto response = new ResponseDto(0,result,"OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
