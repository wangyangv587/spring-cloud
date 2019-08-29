package com.shadow.common.exception;

/**
 * @author YangWang
 * @Description
 * @Date 2019/8/28 11:21
 */
public enum  ErrorEnum {

    /** 未知异常 */
    ERROR(99999, "系统暂时无法处理,稍候再试")

    ;

    String msg;

    Integer code;

    ErrorEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public Integer getCode() {
        return this.code;
    }

    @Override
    public String toString() {

        return String.format("{code=%s, msg=%s}", code, msg);
    }
}
