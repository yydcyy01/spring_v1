package com.yydcyy.exception;

/**
 *
 * 自定义异常类
 * @author YYDCYY
 * @create 2019-10-08
 */
public class SysException extends Exception{
    private String message;

    public SysException(String message) {
        this.message = message;

    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
