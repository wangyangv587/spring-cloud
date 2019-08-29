package com.shadow.common.exception;

/**
 * @author YangWang
 * @Description
 * @Date 2019/8/28 11:25
 */
public class ShadowException extends RuntimeException {

    private static final long serialVersionUID = 6753562208746484626L;

    private Integer code;
    private String msg;

    public ShadowException() {
    }

    public ShadowException(ErrorEnum e) {
        super(e.getMsg());
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public ShadowException(ErrorEnum e, Throwable paramThrowable) {
        super(paramThrowable);
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public ShadowException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {

        return code;
    }

    public String getMsg() {

        return msg;
    }

}
