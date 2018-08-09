package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/11/6.
 */

public class QunTags {

    /**
     * msg : 成功
     * data : [{"createTime":"2017-11-01 16:23:51","sign":1,"name":"投资","updateTime":"2017-11-01 16:23:52","id":1},{"createTime":"2017-11-01 16:23:51","sign":2,"name":"女神","updateTime":"2017-11-01 16:23:52","id":2},{"createTime":"2017-11-01 16:23:51","sign":3,"name":"达人","updateTime":"2017-11-01 16:23:52","id":3},{"createTime":"2017-11-01 16:23:51","sign":4,"name":"游戏","updateTime":"2017-11-01 16:23:52","id":4}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "QunTags{" +
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

    public static class DataBean {
        /**
         * createTime : 2017-11-01 16:23:51
         * sign : 1
         * name : 投资
         * updateTime : 2017-11-01 16:23:52
         * id : 1
         */

        private String createTime;
        private int sign;
        private String name;
        private String updateTime;
        private int id;

        @Override
        public String toString() {
            return "DataBean{" +
                    "createTime='" + createTime + '\'' +
                    ", sign=" + sign +
                    ", name='" + name + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", id=" + id +
                    '}';
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getSign() {
            return sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
