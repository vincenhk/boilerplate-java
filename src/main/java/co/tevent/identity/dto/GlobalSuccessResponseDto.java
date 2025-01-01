package co.tevent.identity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalSuccessResponseDto<T> {
    private String status;
    private String code;
    private String message;
    private T data;

    public GlobalSuccessResponseDto(String status, String message, T data) {
        this.status = status;
        this.code = status;
        this.message = message;
        this.data = data;
    }
    public GlobalSuccessResponseDto(String status, String message) {
        this.status = status;
        this.code = status;
        this.message = message;
    }
}
