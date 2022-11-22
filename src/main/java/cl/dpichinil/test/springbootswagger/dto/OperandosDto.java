package cl.dpichinil.test.springbootswagger.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OperandosDto {
    @NotBlank
    private int operando1;
    @NotBlank
    private int operando2;
}
