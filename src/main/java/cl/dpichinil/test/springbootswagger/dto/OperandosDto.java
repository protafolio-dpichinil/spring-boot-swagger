package cl.dpichinil.test.springbootswagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Schema(description = "Request generico del service del cual se obtienen los numeros pàra hacer las operaciones de la api")
public class OperandosDto {
    @NotBlank
    @Schema(description = "numero que sera usado como primer operando", name = "operando1", example = "3")
    private int operando1;
    @NotBlank
    @Schema(description = "numero que sera usado como segundo operando", name = "operando2", example = "1")
    private int operando2;
}
