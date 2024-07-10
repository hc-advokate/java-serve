package com.cc.serve.common.core;

import com.cc.serve.common.constants.HttpStatus;
import com.cc.serve.common.enums.ResultStatus;
import com.cc.serve.common.utils.StringUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class ResultEntity<T> extends HashMap<String, Object> implements Serializable {

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    public ResultEntity() {
    }

    public ResultEntity(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public ResultEntity(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtil.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    public static ResultEntity success() {
        return ResultEntity.success(HttpStatus.SUCCESS_MSG);
    }

    public static ResultEntity success(Object data) {
        return ResultEntity.success(HttpStatus.SUCCESS_MSG, data);
    }

    public static ResultEntity success(String msg) {
        return ResultEntity.success(msg, null);
    }

    public static ResultEntity success(String msg, Object data) {
        return new ResultEntity(HttpStatus.SUCCESS, msg, data);
    }

    public static ResultEntity warn(String msg) {
        return ResultEntity.warn(msg, null);
    }

    public static ResultEntity warn(String msg, Object data) {
        return new ResultEntity(HttpStatus.WARN, msg, data);
    }

    public static ResultEntity error() {
        return ResultEntity.error(HttpStatus.ERROR_MSG);
    }

    public static ResultEntity error(String msg) {
        return ResultEntity.error(msg, null);
    }

    public static ResultEntity error(String msg, Object data) {
        return new ResultEntity(HttpStatus.ERROR, msg, data);
    }

    public static ResultEntity error(int code, String msg, Object data) {
        return new ResultEntity(code, msg, data);
    }

    /**
     * 是否为成功消息
     *
     * @return 结果
     */
    public boolean isSuccess() {
        return Objects.equals(HttpStatus.SUCCESS, this.get(CODE_TAG));
    }

    /**
     * 是否为警告消息
     *
     * @return 结果
     */
    public boolean isWarn() {
        return Objects.equals(HttpStatus.WARN, this.get(CODE_TAG));
    }

    /**
     * 是否为错误消息
     *
     * @return 结果
     */
    public boolean isError() {
        return Objects.equals(HttpStatus.ERROR, this.get(CODE_TAG));
    }

    @Override
    public ResultEntity put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    private int code;
    private String msg;
    private T data;

    public ResultEntity resultSuccess() {
        ResultEntity result = new ResultEntity();
        result.code = ResultStatus.SUCCESS.getCode();
        result.msg = ResultStatus.SUCCESS.getMsg();
        return result;
    }

    public ResultEntity<Object> resultSuccess(Object data) {
        ResultEntity<Object> result = new ResultEntity<Object>();
        result.code = ResultStatus.SUCCESS.getCode();
        result.msg = ResultStatus.SUCCESS.getMsg();
        result.setData(data);
        return result;
    }

    public ResultEntity resultFail(ResultStatus resultStatus) {
        ResultEntity result = new ResultEntity();
        result.code = resultStatus.getCode();
        result.msg = resultStatus.getMsg();
        return result;
    }

    public ResultEntity resultFail(ResultStatus resultStatus, Object data) {
        ResultEntity<Object> result = new ResultEntity<Object>();
        result.code = resultStatus.getCode();
        result.msg = resultStatus.getMsg();
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
