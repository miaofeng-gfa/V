package com.veeca.ted.v.bean.mian;

/**
 * Created by Administrator on 2018-03-19.
 */

public class FriendCount {

    private String msg;
    private int count1;
    private int count2;
    private boolean success;
    private int count;

    @Override
    public String toString() {
        return "FriendCount{" +
                "msg='" + msg + '\'' +
                ", count1=" + count1 +
                ", count2=" + count2 +
                ", success=" + success +
                ", count=" + count +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
