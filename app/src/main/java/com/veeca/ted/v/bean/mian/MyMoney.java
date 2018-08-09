package com.veeca.ted.v.bean.mian;

import java.util.List;

/**
 * Created by Ted on 2017/11/25.
 */

public class MyMoney {
    /**
     * msg : 成功！
     * data : [{"gettime":"06-19 12:41","oof":0.5,"title":"看漫画的最高境界 | 烂作也好看到爆"},{"gettime":"08-02 21:19","oof":0.63,"title":"桑拿天 | 畅快吃个凉拌鱼"},{"gettime":"08-07 18:08","oof":0.5,"title":"桑拿天指南 | 喝碗靓汤补盐分"}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "ShangJin{" +
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
         * gettime : 06-19 12:41
         * oof : 0.5
         * title : 看漫画的最高境界 | 烂作也好看到爆
         */

        private String gettime;
        private double oof;
        private String title;

        @Override
        public String toString() {
            return "DataBean{" +
                    "gettime='" + gettime + '\'' +
                    ", oof=" + oof +
                    ", title='" + title + '\'' +
                    '}';
        }

        public String getGettime() {
            return gettime;
        }

        public void setGettime(String gettime) {
            this.gettime = gettime;
        }

        public double getOof() {
            return oof;
        }

        public void setOof(double oof) {
            this.oof = oof;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
