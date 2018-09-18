package com.pan.sbs.jwt.core;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 统一API响应结果封装
* @Title: Result.java  
* @Package com.bjttsf.core
* @ProjectName bc-common-core  
* @Description:   
* @Author ttsf-pzg  
* @Date 2018年7月18日下午1:58:02  
* @Version V1.0
 */
public class Result implements Serializable {
    private int code;

	private String message;
    private Object data;
    private Long timestamp;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
		this.code = code;
	}
    
    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

	public Long getTimestamp() {
		return timestamp;
	}

	public Result setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
		return this;
	}
}
