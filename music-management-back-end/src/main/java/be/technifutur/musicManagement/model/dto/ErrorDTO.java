package be.technifutur.musicManagement.model.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class ErrorDTO {

    private final String message;
    private final int status;
    private final String uri;
    private final HttpMethod method;
    private final Map<String, Object> info = new HashMap<>();

    public ErrorDTO(String message, String uri, HttpMethod method) {
        this.message = message;
        this.uri = uri;
        this.status = 400;
        this.method = method;
    }

    public ErrorDTO(String message, int status, String uri, HttpMethod method) {
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.method = method;
    }

    public ErrorDTO(String message, int status, String uri, HttpMethod method, Map<String, Object> info) {
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.method = method;
        this.info.putAll(info);
    }

}
