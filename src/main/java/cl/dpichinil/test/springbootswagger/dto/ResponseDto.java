package cl.dpichinil.test.springbootswagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Response generico de los endpoint")
public class ResponseDto {

    @Schema(description = "codigo de respuesta", name = "code", example = "0")
    private int code;

    @Schema(description = "mensaje explicativo correspondiente al codigo de respuesta de la ejecucion", name = "message", example = "Error al procesar")
    private String message;

    @Schema(description = "campo generico en el cual se retornan datos primitivos u objetos resultantes de la ejecucion", name = "data", example = "1")
    private Object data;

    public ResponseDto(int code){
        this.code = code;
    }

    public ResponseDto(int code, Object data){
        this.code = code;
        this.data = data;
    }

    public ResponseDto(int code, Object data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
