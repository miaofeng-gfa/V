package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/28.
 */

public class FriendMoney {
    /**
     * msg : 成功！
     * success : true
     * friendMoney : null
     */

    private String msg;
    private boolean success;
    private double friendMoney;

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

    public double getFriendMoney() {
        return friendMoney;
    }

    public void setFriendMoney(double friendMoney) {
        this.friendMoney = friendMoney;
    }
}
