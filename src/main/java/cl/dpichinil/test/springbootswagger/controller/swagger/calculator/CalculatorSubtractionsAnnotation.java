package cl.dpichinil.test.springbootswagger.controller.swagger.calculator;


import cl.dpichinil.test.springbootswagger.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
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
public @interface CalculatorSubtractionsAnnotation {
}
