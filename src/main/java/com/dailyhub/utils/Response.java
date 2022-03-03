package com.dailyhub.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(int code, String message, T data) {
        return new Response(code, "操作成功", data);
    }

    public static <T> Response<T> failure(int code, String message, T data) {
        return new Response(code, "操作失败", data);
    }
}
