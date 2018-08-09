package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/11/30.
 */

public class TaskState {
    /**
     * msg : 成功
     * checkdesc : null
     * success : true
     * checkstatus : 1
     * time : 3052822
     */

    private String msg;
    private String checkdesc;
    private boolean success;
    private int checkstatus;
    private int time;

    @Override
    public String toString() {
        return "TaskState2{" +
                "msg='" + msg + '\'' +
                ", checkdesc=" + checkdesc +
                ", success=" + success +
                ", checkstatus=" + checkstatus +
                ", time=" + time +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCheckdesc() {
        return checkdesc;
    }

    public void setCheckdesc(String checkdesc) {
        this.checkdesc = checkdesc;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(int checkstatus) {
        this.checkstatus = checkstatus;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
