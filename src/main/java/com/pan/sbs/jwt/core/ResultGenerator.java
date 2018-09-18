package com.pan.sbs.jwt.core;


import com.alibaba.fastjson.JSON;

/**
 * 响应结果生成工具
* @Title: ResultGenerator.java  
* @Package com.bjttsf.core
* @ProjectName bc-common-core  
* @Description:   
* @Author ttsf-pzg  
* @Date 2018年7月18日下午1:58:20  
* @Version V1.0
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    

    /**
     * 返回无权限
     * @Title: genUnAuthorizedResult  
     * @Description: 
     * @CreateTime 2018年6月27日上午10:07:03
     * @Author ttsf-pzg
     * @return
     */
    public static Result getUnAuthorizedResult( ) {
    	   return new Result()
                   .setCode(ResultCode.UNAUTHORIZED)
                   .setTimestamp(System.currentTimeMillis());
    }
    
    /**
     * 返回执行成功
     * @Title: genSuccessResult  
     * @Description: 
     * @CreateTime 2018年6月6日下午4:05:21
     * @Author ttsf-pzg
     * @return   
     */
    public static Result getSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setTimestamp(System.currentTimeMillis());
    }
    /**
     * 根据输入类型返回json 对象
     * @Title: genSuccessResult   
     * @Description: 
     * @CreateTime 2018年6月6日下午4:05:49
     * @Author ttsf-pzg
     * @param data 需要输出的josn对象
     * @return   
     */
    public static Result getSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(JSON.toJSONString(data))
                .setTimestamp(System.currentTimeMillis());
    }

    /**
     * 返回执行失败
     * @Title: genFailResult  
     * @Description: 
     * @CreateTime 2018年6月6日下午4:06:46
     * @Author ttsf-pzg
     * @param message
     * @return   
     */
    public static Result getFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message)
                .setTimestamp(System.currentTimeMillis());
    }
    
    /**
     * service-api 参数异常
     */
    private static final String DEFAULT_FAIL_PARM_SERVICE_API="service-api 参数异常！";
    /**
     * service-api 层参数异常
     * @Title: getnFailResultByServiceApiParm  
     * @Description: 
     * @CreateTime 2018年7月23日上午11:05:30
     * @Author ttsf-pzg
     * @return
     */
    public static Result getFailResultByServiceApiParm() {
    	  return new Result()
                  .setCode(ResultCode.FAIL)
                  .setMessage(DEFAULT_FAIL_PARM_SERVICE_API)
                  .setTimestamp(System.currentTimeMillis());
    };
}
