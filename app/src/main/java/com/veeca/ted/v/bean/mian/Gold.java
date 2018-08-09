package com.veeca.ted.v.bean.mian;

/**
 * Created by Ted on 2017/11/25.
 */

public class Gold {
    /**
     * msg : 获取成功！
     * data : 130
     * success : true
     */

    private String msg;
    private String data;
    private boolean success;

    @Override
    public String toString() {
        return "VBI{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
