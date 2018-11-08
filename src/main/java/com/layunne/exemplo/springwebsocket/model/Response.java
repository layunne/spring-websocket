package com.layunne.exemplo.springwebsocket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Layunne
 */
@Getter
@Setter
@NoArgsConstructor
public class Response {

    private String message;

    public Response(String message) {
        this.message = message;
    }
}
