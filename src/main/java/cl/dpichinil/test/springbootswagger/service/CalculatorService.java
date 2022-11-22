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

    public ResponseEntity<ResponseDto> sum(OperandosDto operandosDto) {
        String operation = "suma";
        ResponseDto response;
        printLogInicial(operation, operandosDto);
        response = validationErrorInFieldOperators(operandosDto);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        int result = operandosDto.getOperando1() + operandosDto.getOperando2();
        printLogResult(operation, result);
        return new ResponseEntity<>(new ResponseDto(0,result,"OK"), HttpStatus.OK);

    }

    public ResponseEntity<ResponseDto> subtraction(OperandosDto operandosDto) {
        String operation = "resta";
        ResponseDto response;
        printLogInicial(operation,operandosDto);
        response = validationErrorInFieldOperators(operandosDto);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        int result = operandosDto.getOperando1() - operandosDto.getOperando2();
        printLogResult(operation, result);
        return new ResponseEntity<>(new ResponseDto(0,result,"OK") , HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> divide(OperandosDto operandosDto) {
        String operation = "division";
        ResponseDto response;
        printLogInicial(operation,operandosDto);
        response = validationErrorInFieldOperators(operandosDto);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        if(operandosDto.getOperando2() != 0){
            response = new ResponseDto(1001,null,"Error el operando2 debe ser distinto de cero");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        int result = operandosDto.getOperando1() / operandosDto.getOperando2();
        printLogResult(operation, result);
        return new ResponseEntity<>(new ResponseDto(0,result,"OK"), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> multiply(OperandosDto operandosDto) {
        String operation = "multiplicacion";
        ResponseDto response;
        printLogInicial(operation,operandosDto);
        response = validationErrorInFieldOperators(operandosDto);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        int result = operandosDto.getOperando1() * operandosDto.getOperando2();
        printLogResult(operation, result);
        return new ResponseEntity<>(new ResponseDto(0,result,"OK"), HttpStatus.OK);
    }

    private void printLogInicial(String operation, OperandosDto operandosDto){
        String logTemplate = "datos de la operacion %s: { num1: %d num2: %d }";
        log.info(String.format(logTemplate, operation, operandosDto.getOperando1(), operandosDto.getOperando2()));
    }

    private void printLogResult(String operation, int result){
        String logTemplate = "el resultado de la operacion %s es %d";
        log.info(String.format(logTemplate, operation, result));
    }

    private ResponseDto validationErrorInFieldOperators(OperandosDto operandosDto){
        if(operandosDto==null){
            return new ResponseDto(1001,null,"Error al validar el operandoDto");
        }
        if(operandosDto.getOperando1() < 0 && operandosDto.getOperando2() < 0){
            return new ResponseDto(1001,null,"Error al validar los operandos");
        }
        return null;
    }
}