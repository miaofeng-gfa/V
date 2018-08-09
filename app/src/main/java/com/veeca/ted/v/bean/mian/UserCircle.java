package com.veeca.ted.v.bean.mian;

import java.util.List;

/**
 * Created by Ted on 2017/7/29.
 */

public class UserCircle {

    /**
     * msg : 成功！
     * data : [{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:09","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":18,"updatetime":"2017-06-21 10:03:11","circlename":"音乐发烧友"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:37","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":14,"updatetime":"2017-06-21 10:02:40","circlename":"网购达人"}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "UserCircle{" +
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
         * res5 : null
         * res4 : null
         * createtime : 2017-06-21 10:03:09
         * res6 : null
         * res1 : null
         * res3 : null
         * res2 : null
         * pid : 0
         * id : 18
         * updatetime : 2017-06-21 10:03:11
         * circlename : 音乐发烧友
         */

        private Object res5;
        private Object res4;
        private String createtime;
        private Object res6;
        private Object res1;
        private Object res3;
        private Object res2;
        private int pid;
        private int id;
        private String updatetime;
        private String circlename;

        @Override
        public String toString() {
            return "DataBean{" +
                    "res5=" + res5 +
                    ", res4=" + res4 +
                    ", createtime='" + createtime + '\'' +
                    ", res6=" + res6 +
                    ", res1=" + res1 +
                    ", res3=" + res3 +
                    ", res2=" + res2 +
                    ", pid=" + pid +
                    ", id=" + id +
                    ", updatetime='" + updatetime + '\'' +
                    ", circlename='" + circlename + '\'' +
                    '}';
        }

        public Object getRes5() {
            return res5;
        }

        public void setRes5(Object res5) {
            this.res5 = res5;
        }

        public Object getRes4() {
            return res4;
        }

        public void setRes4(Object res4) {
            this.res4 = res4;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getRes6() {
            return res6;
        }

        public void setRes6(Object res6) {
            this.res6 = res6;
        }

        public Object getRes1() {
            return res1;
        }

        public void setRes1(Object res1) {
            this.res1 = res1;
        }

        public Object getRes3() {
            return res3;
        }

        public void setRes3(Object res3) {
            this.res3 = res3;
        }

        public Object getRes2() {
            return res2;
        }

        public void setRes2(Object res2) {
            this.res2 = res2;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getCirclename() {
            return circlename;
        }

        public void setCirclename(String circlename) {
            this.circlename = circlename;
        }
    }
}
