package cl.dpichinil.test.springbootswagger.controller;

import cl.dpichinil.test.springbootswagger.dto.OperandosDto;
import cl.dpichinil.test.springbootswagger.dto.ResponseDto;
import cl.dpichinil.test.springbootswagger.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/operations")
@RestController
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }


    @Operation(summary = "Endpoint dedicado a la sustraccion de numeros")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sustraccion realizada de forma correcta",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "OK-0",
                                            value = "{\"code\": \"0\", \"message\" : \"Sustraccion OK\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en validacion de operandos",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Error-1001",
                                            value = "{\"code\": \"1001\", \"message\" : \"No se encuentran los operandos\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1002",
                                            value = "{\"code\": \"1002\", \"message\" : \"El valor del operando 1 no encontrado\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1003",
                                            value = "{\"code\": \"1003\", \"message\" : \"El valor del operando 2 no encontrado\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al ejecutar la api",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Error-1000",
                                                    description = "Error generico al procesar la peticion",
                                                    value = "{\"code\": \"1000\", \"message\" : \"Error en la generacion de la operacion\", \"data\": null }"
                                            )
                                    }
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Server Unaviable",
                    content = @Content
            )
    })
    @PostMapping("subtraction")
    public ResponseEntity<ResponseDto> subtraction(
            @Parameter(description = "operando 1 para la operacion deseada", example = "3", name = "op1") @RequestParam(name="op1") int operando1,
            @Parameter(description = "operando 1 para la operacion deseada", example = "1", name = "op2") @RequestParam(name="op2") int operando2
            ){
        OperandosDto operandosDto = new OperandosDto();
        operandosDto.setOperando1(operando1);
        operandosDto.setOperando2(operando2);
        return calculatorService.subtraction(operandosDto);
    }

    @Operation(summary = "Endpoint dedicado a la suma de numeros")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Suma realizada de forma correcta",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "OK-0",
                                            value = "{\"code\": \"0\", \"message\" : \"Suma OK\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en validacion de operandos",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Error-1001",
                                            value = "{\"code\": \"1001\", \"message\" : \"No se encuentran los operandos\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1002",
                                            value = "{\"code\": \"1002\", \"message\" : \"El valor del operando 1 no encontrado\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1003",
                                            value = "{\"code\": \"1003\", \"message\" : \"El valor del operando 2 no encontrado\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Acceso no autorizado a la api",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Error-401",
                                                    description = "Acceso no permitdo para el uso de la api",
                                                    value = "{\"code\": \"401\", \"message\" : \"Acceso no autorizado\", \"data\": null }"
                                            )
                                    }
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al ejecutar la api",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Error-1000",
                                                    description = "Error generico al procesar la peticion",
                                                    value = "{\"code\": \"1000\", \"message\" : \"Error en la generacion de la operacion\", \"data\": null }"
                                            )
                                    }
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Server Unaviable",
                    content = @Content
            )
    })
    @PostMapping("sum/{operando1}/{operando2}")
    public ResponseEntity<ResponseDto> sum(
            @Parameter(description = "operando 1 para la operacion deseada", example = "1", name = "Operando1") @PathVariable("operando1") Integer operando1,
            @Parameter(description = "operando 2 para la operacion deseada", example = "2") @PathVariable("operando2") Integer operando2){
        OperandosDto operandosDto = new OperandosDto();
        operandosDto.setOperando1(operando1);
        operandosDto.setOperando2(operando2);
        return calculatorService.sum(operandosDto);
    }


    @Operation(summary = "Endpoint dedicado a la multiplicacion de numeros")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Multiplicacion realizada de forma correcta",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "OK-0",
                                            value = "{\"code\": \"0\", \"message\" : \"Multiplicacion OK\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en validacion de operandos",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Error-1001",
                                            value = "{\"code\": \"1001\", \"message\" : \"No se encuentran los operandos\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1002",
                                            value = "{\"code\": \"1002\", \"message\" : \"El valor del operando 1 no encontrado\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1003",
                                            value = "{\"code\": \"1003\", \"message\" : \"El valor del operando 2 no encontrado\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Acceso no autorizado a la api",
                    content = {
                        @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                @ExampleObject(
                                        name = "Error-401",
                                        description = "Acceso no permitdo para el uso de la api",
                                        value = "{\"code\": \"401\", \"message\" : \"Acceso no autorizado\", \"data\": null }"
                                )
                            }
                        )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al ejecutar la api",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Error-1000",
                                                    description = "Error generico al procesar la peticion",
                                                    value = "{\"code\": \"1000\", \"message\" : \"Error en la generacion de la operacion\", \"data\": null }"
                                            )
                                    }
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Server Unaviable",
                    content = @Content
            )
    })
    @PostMapping("multiply")
    public ResponseEntity<ResponseDto> multiply(@RequestBody OperandosDto operandosDto){
        return calculatorService.multiply(operandosDto);
    }

    @PostMapping("divide")
    @Operation(summary = "Endpoint dedicado a la Divicion de numeros")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Division realizada de forma correcta",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "OK-0",
                                            value = "{\"code\": \"0\", \"message\" : \"Division OK\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en validacion de operandos",
                    content = { @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Error-1001",
                                            value = "{\"code\": \"1001\", \"message\" : \"No se encuentran los operandos\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1002",
                                            value = "{\"code\": \"1002\", \"message\" : \"El valor del operando 1 no encontrado\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1003",
                                            value = "{\"code\": \"1003\", \"message\" : \"El valor del operando 2 no encontrado\", \"data\": null }"
                                    ),
                                    @ExampleObject(
                                            name = "Error-1004",
                                            value = "{\"code\": \"1004\", \"message\" : \"El valor del operando 2 no puede ser menor o igual a 0\", \"data\": null }"
                                    )
                            }
                    )}
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Acceso no autorizado a la api",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Error-401",
                                                    description = "Acceso no permitdo para el uso de la api",
                                                    value = "{\"code\": \"401\", \"message\" : \"Acceso no autorizado\", \"data\": null }"
                                            )
                                    }
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno al ejecutar la api",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Error-1000",
                                                    description = "Error generico al procesar la peticion",
                                                    value = "{\"code\": \"1000\", \"message\" : \"Error en la generacion de la operacion\", \"data\": null }"
                                            )
                                    }
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Server Unaviable",
                    content = @Content
            )
    })
    public ResponseEntity<ResponseDto> divide(@RequestBody OperandosDto operandosDto){
        return calculatorService.divide(operandosDto);
    }
}
