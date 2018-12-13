package io.github.bhuwanupadhyay.ordering;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EndpointResponse<T> {
    public static final String BODY = "body";
    private T body;
    private LocalDateTime generatedAt;
    private String message;

    public EndpointResponse(T body) {
        this(body, null);
    }

    public EndpointResponse(T body, String message) {
        this.body = body;
        this.message = message;
        this.generatedAt = LocalDateTime.now();
    }

}
