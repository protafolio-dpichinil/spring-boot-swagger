package cl.dpichinil.test.springbootswagger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
    private int code;
    private String message;
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
