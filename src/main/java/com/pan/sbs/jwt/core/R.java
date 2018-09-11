package com.pan.sbs.jwt.core;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @ClassName R
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/5 下午2:21
 * @Version 0.0.1
 * @Remark
 **/
@Data
public class R {

    private Integer code;
    private String data;


    public static R getSuccess(Object o) {
        R r = new R();
        r.setCode(200);
        r.setData(JSON.toJSONString(o));
        return r;
    }

}
