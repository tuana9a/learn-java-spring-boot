package com.tuana9a.learnjavaspringboot.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponse {
    private int code;
    private Object data;
    private String message;
}
