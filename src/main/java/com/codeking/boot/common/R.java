package com.codeking.boot.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : codeking
 * @create : 2022/12/20 20:49
 */
@Data
public class R<T> {
    /**
     * A. 如果业务执行结果为成功, 构建R对象时, 只需要调用 success 方法;
     * 如果需要返回数据传递object 参数, 如果无需返回, 可以直接传递null。
     * B. 如果业务执行结果为失败, 构建R对象时, 只需要调用error 方法, 传递错误提示信息即可。
     */
    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据
    private Map map = new HashMap(); //动态数据

    // 泛型方法的使用
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
