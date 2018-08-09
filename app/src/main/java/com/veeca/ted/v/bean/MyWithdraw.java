package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/11/28.
 */

public class MyWithdraw {
    /**
     * msg : 成功！
     * data : [{"fromm":15,"amount":20,"orderid":"20170703183001604298","updatetime":"07-03 18:30","statuss":1}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "TiXian{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", data=" + data +
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public class DataBean {
        /**
         * fromm : 15
         * amount : 20
         * orderid : 20170703183001604298
         * updatetime : 07-03 18:30
         * statuss : 1
         */

        private int fromm;
        private int amount;
        private String orderid;
        private String updatetime;
        private int statuss;

        @Override
        public String toString() {
            return "DataBean{" +
                    "fromm=" + fromm +
                    ", amount=" + amount +
                    ", orderid='" + orderid + '\'' +
                    ", updatetime='" + updatetime + '\'' +
                    ", statuss=" + statuss +
                    '}';
        }

        public int getFromm() {
            return fromm;
        }

        public void setFromm(int fromm) {
            this.fromm = fromm;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public int getStatuss() {
            return statuss;
        }

        public void setStatuss(int statuss) {
            this.statuss = statuss;
        }
    }
}
