package com.lhb.study.util.frame;

/**
 * 结果返回基类
 * @author lianghuaibin
 * @since 2017/3/21
 */
public abstract class AbstractResult {

    private boolean isSuccess;
    private String code = "0000";
    private String msg;
    private String desc;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
