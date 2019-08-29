package com.shadow.common.util;


import cn.hutool.json.JSONUtil;
import com.shadow.common.exception.ShadowException;
import com.shadow.common.exception.ErrorEnum;
import java.util.HashMap;
/**
 * @author YangWang
 * @Description
 * @Date 2019/8/28 11:04
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(ErrorEnum.ERROR);
    }

    public static R error(ShadowException e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMsg());
        return r;
    }

    public static R error(ErrorEnum e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMsg());
        return r;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public R data(Object value) {
        super.put("data", JSONUtil.toJsonStr(value));
        return this;
    }

    public R dataObj(Object value) {
        super.put("data", value);
        return this;
    }
}