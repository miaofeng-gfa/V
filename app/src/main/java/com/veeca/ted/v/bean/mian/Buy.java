package com.veeca.ted.v.bean.mian;

/**
 * Created by Ted on 2017/12/14.
 */

public class Buy {
    private String msg;
    private double data;
    private boolean success;

    @Override
    public String toString() {
        return "Buy{" +
                "msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                ", success=" + success +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
