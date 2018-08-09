package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Administrator on 2018-03-19.
 */

public class FriMoneyThir {

    private String msg;
    private List<DataThri>  data;
    private Boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<DataThri> getData() {
        return data;
    }

    public void setData(List<DataThri> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FriMoneyThir{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static class DataThri{
        private  String d;
        private double num;

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public double getNum() {
            return num;
        }

        public void setNum(double num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "DataThri{" +
                    "d='" + d + '\'' +
                    ", num=" + num +
                    '}';
        }
    }



}
