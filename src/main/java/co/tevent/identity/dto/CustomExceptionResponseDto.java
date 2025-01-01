package co.tevent.identity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CustomExceptionResponseDto extends RuntimeException{

    private String status;
    private String code;
    private String error;


    public CustomExceptionResponseDto(String message) {
        super(message);
    }

    public CustomExceptionResponseDto(String message, String errorCode, String error) {
        super(message);
        this.code = errorCode;
        this.error = error;
    }

    public CustomExceptionResponseDto(String message, String errorCode) {
        super(message);
        this.code = errorCode;
    }
}
