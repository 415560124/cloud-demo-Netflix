package com.rhy.commonservice.util.result;

/**
 * @program: cloud-service
 * @description: 通用返回状态码
 * @author: Rhy
 * @create_time: 2020-06-29 10:43
 * @modifier：Rhy
 * @modification_time：2020-06-29 10:43
 **/
public enum ResultCodeEnum {

    SUCCESS(200, ResultMessageEnum.SUCCESS_COMMON.getMessage()),
    FAILED(500, ResultMessageEnum.FAILED_COMMON.getMessage()),
    FAILED_FEIGN(510, ResultMessageEnum.FAILED_COMMON.getMessage()),
    VALIDATE_FAILED(400, ResultMessageEnum.VALIDATE_FAILED_COMMON.getMessage()),
    FORBBIDEN(403, ResultMessageEnum.FORBBIDEN_COMMON.getMessage()),
    USER_ACCOUNT_ERROR(402, ResultMessageEnum.USER_ACCOUNT_ERROR.getMessage()),
    USER_NOT_FOUND(401, ResultMessageEnum.USER_NOT_FOUND.getMessage()),
    GATEWAY_ERROR(522, ResultMessageEnum.GATEWAY_ERROR.getMessage()),
    SERVICE_INSTANCE_NOT_FOUND(523, ResultMessageEnum.SERVICE_INSTANCE_NOT_FOUND.getMessage());
    /**
     * 状态码
     */
    private Long code;
    /**
     * 状态信息
     */
    private String message;
    ResultCodeEnum(long code,String message){
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
