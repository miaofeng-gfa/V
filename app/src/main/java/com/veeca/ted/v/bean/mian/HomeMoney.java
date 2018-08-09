package com.veeca.ted.v.bean.mian;

/**
 * Created by Ted on 2017/11/16.
 */

public class HomeMoney {
    private String msg;
    private String staticDataName;
    private float money;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStaticDataName() {
        return staticDataName;
    }

    public void setStaticDataName(String staticDataName) {
        this.staticDataName = staticDataName;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
