package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/28.
 */

public class UsableMoney {
    /**
     * msg : 成功！
     * success : true
     * usableMoney : 0
     */

    private String msg;
    private boolean success;
    private double usableMoney;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getUsableMoney() {
        return usableMoney;
    }

    public void setUsableMoney(double usableMoney) {
        this.usableMoney = usableMoney;
    }
}
