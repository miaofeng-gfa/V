package com.veeca.ted.v.bean.mian;

/**
 * Created by Ted on 2017/11/24.
 */

public class Influence {
    /**
     * msg : 获取成功！
     * data : null
     * success : true
     * ginum : null
     * influence : 564
     */

    private String msg;
    private double data;
    private boolean success;
    private int ginum;
    private int influence;

    @Override
    public String toString() {
        return "Influence{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", ginum=" + ginum +
                ", influence=" + influence +
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

    public int getGinum() {
        return ginum;
    }

    public void setGinum(int ginum) {
        this.ginum = ginum;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }
}
