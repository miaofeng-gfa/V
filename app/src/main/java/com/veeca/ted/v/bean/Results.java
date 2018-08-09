package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/15.
 */

public class Results {
    private String msg;
    private boolean success;
    private int state;

    @Override
    public String toString() {
        return "Results{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", state=" + state +
                '}';
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
}
