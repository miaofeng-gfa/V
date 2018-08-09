package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/11/28.
 */

public class Syt {
    @Override
    public String toString() {
        return "Syt{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", mySalaryChar='" + mySalaryChar + '\'' +
                ", datafriend=" + datafriend +
                ", data=" + data +
                '}';
    }

    /**
     * msg : 成功！
     * datafriend : [{"s":"0","d":"17-08-06"},{"s":"0","d":"17-08-07"},{"s":"0","d":"17-08-08"},{"s":"0","d":"17-08-09"},{"s":"0","d":"17-08-10"},{"s":"0","d":"17-08-11"},{"s":"0","d":"17-08-12"}]
     * data : [{"s":"0","d":"17-08-06"},{"s":0.5,"d":"17-08-07"},{"s":"0","d":"17-08-08"},{"s":"0","d":"17-08-09"},{"s":"0","d":"17-08-10"},{"s":"0","d":"17-08-11"},{"s":"0","d":"17-08-12"}]
     * success : true
     * mySalaryChar : 薪水
     */

    private String msg;
    private boolean success;
    private String mySalaryChar;
    private List<DatafriendBean> datafriend;
    private List<DataBean> data;

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

    public String getMySalaryChar() {
        return mySalaryChar;
    }

    public void setMySalaryChar(String mySalaryChar) {
        this.mySalaryChar = mySalaryChar;
    }

    public List<DatafriendBean> getDatafriend() {
        return datafriend;
    }

    public void setDatafriend(List<DatafriendBean> datafriend) {
        this.datafriend = datafriend;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public class DatafriendBean {
        /**
         * s : 0
         * d : 17-08-06
         */

        private double s;
        private String d;

        @Override
        public String toString() {
            return "DatafriendBean{" +
                    "s=" + s +
                    ", d='" + d + '\'' +
                    '}';
        }

        public double getS() {
            return s;
        }

        public void setS(double s) {
            this.s = s;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }
    }

    public class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "s=" + s +
                    ", d='" + d + '\'' +
                    '}';
        }

        /**
         * s : 0
         * d : 17-08-06
         */

        private double s;
        private String d;

        public double getS() {
            return s;
        }

        public void setS(double s) {
            this.s = s;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }
    }
}
