package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/28.
 */

public class IsFirstMoney {
    /**
     * msg : 成功！
     * success : true
     * usableMoney : 0
     */

    private String msg;
    private boolean success;
    private boolean wx;
    private boolean bank;
    private boolean ali;

    @Override
    public String toString() {
        return "IsFirstMoney{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", wx=" + wx +
                ", bank=" + bank +
                ", ali=" + ali +
                '}';
    }

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

    public boolean isWx() {
        return wx;
    }

    public void setWx(boolean wx) {
        this.wx = wx;
    }

    public boolean isBank() {
        return bank;
    }

    public void setBank(boolean bank) {
        this.bank = bank;
    }

    public boolean isAli() {
        return ali;
    }

    public void setAli(boolean ali) {
        this.ali = ali;
    }
}
