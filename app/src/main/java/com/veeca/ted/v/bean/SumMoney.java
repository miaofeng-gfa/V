package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/28.
 */

public class SumMoney {
    /**
     * msg : 成功！
     * sumMoney : 0.63
     * success : true
     */

    private String msg;
    private float sumMoney;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(float sumMoney) {
        this.sumMoney = sumMoney;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
