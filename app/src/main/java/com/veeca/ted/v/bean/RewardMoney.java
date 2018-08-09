package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/28.
 */

public class RewardMoney {
    /**
     * msg : 成功！
     * success : true
     * rewardMoney : 0.63
     */

    private String msg;
    private boolean success;
    private double rewardMoney;

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

    public double getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(double rewardMoney) {
        this.rewardMoney = rewardMoney;
    }
}
