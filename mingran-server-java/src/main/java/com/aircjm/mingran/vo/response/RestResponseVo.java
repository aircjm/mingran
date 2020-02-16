package com.aircjm.mingran.vo.response;

import lombok.Data;

/**
 * rest json返回基类
 *
 * @author aircjm
 */
@Data
public class RestResponseVo<T> {

    private int code;
    private String msg;
    private T data;
    private boolean success;

    private RestResponseVo() {
    }

    private RestResponseVo(boolean success) {
        this.success = success;
    }

    private RestResponseVo(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    private RestResponseVo(boolean success, T data, int code) {
        this.success = success;
        this.data = data;
        this.code = code;
    }

    private RestResponseVo(boolean success, int code) {
        this.success = success;
        this.code = code;
    }

    private RestResponseVo(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }


    private RestResponseVo(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public static <T> RestResponseVo success() {
        return new RestResponseVo(true);
    }

    public static <T> RestResponseVo success(T data) {
        return new RestResponseVo<T>(true, data);
    }

    public static <T> RestResponseVo success(T data, int code) {
        return new RestResponseVo<T>(true, data, code);
    }

    public static RestResponseVo fail() {
        return new RestResponseVo(false);
    }

    public static RestResponseVo fail(int code) {
        return new RestResponseVo(false, code);
    }

    public static RestResponseVo fail(String msg) {
        return new RestResponseVo(false, msg);
    }

    public static RestResponseVo fail(int code, String msg) {
        return new RestResponseVo(false, code, msg);
    }
}
