package com.layunne.exemplo.springwebsocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Layunne
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String name;
    private Object data;
}
