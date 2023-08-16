package com.example;

import com.BusinessCode;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/17
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class HygResponse<T> {

    private String statusCode = "000000";
    private String statusText = "success";
    private T data;

    public HygResponse() {
        this.statusCode = BusinessCode.SUCCESS.getCode();
        this.statusText = "success";
        this.data = null;
    }

    public HygResponse(String statusCode, String statusText, T t, String currentTimeMillis) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.data = t;
    }

    public HygResponse(String statusCode, String statusText) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.data = null;
    }

    public HygResponse(String statusCode, String statusText, T t) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.data = t;
    }

    public HygResponse(BusinessCode businessCode) {
        this.statusCode = businessCode.getCode();
        this.statusText = businessCode.getDesc();
        this.data = null;
    }

    public HygResponse(BusinessCode businessCode, T data) {
        this.statusCode = businessCode.getCode();
        this.statusText = businessCode.getDesc();
        this.data = data;
    }

    public static HygResponse Success() {
        return new HygResponse(BusinessCode.SUCCESS);
    }

    public static HygResponse Success(Object data) {
        return new HygResponse(BusinessCode.SUCCESS, data);
    }

    public static HygResponse Error() {
        return new HygResponse(BusinessCode.FATAL);
    }

    public static HygResponse Error(String errMsg) {
        return new HygResponse(BusinessCode.FATAL.getCode(), errMsg);
    }

    public static HygResponse Error(BusinessCode businessCode, String errMsg) {
        return new HygResponse(businessCode.getCode(), errMsg);
    }

    public boolean successful() {
        return this.statusCode.equals(BusinessCode.SUCCESS.getCode());
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public T getData() {
        return this.data;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public void setData(T data) {
        this.data = data;
    }


}
