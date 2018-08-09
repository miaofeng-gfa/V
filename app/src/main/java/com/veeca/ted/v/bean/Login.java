package com.veeca.ted.v.bean;

// FIXME generate failure  field _$Data218

/**
 * Created by Ted on 2017/7/25.
 */

public class Login {

    private boolean success;
    private String msg;
    private boolean status;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Login{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private int id;
        private String userid;
        private String token;
        private String access_token;
        private String refresh_token;
        private String devid;
        private String updatetime;
        private Object res1;
        private Object res2;
        private Object res3;
        private Object res4;
        private Object res5;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public String getDevid() {
            return devid;
        }

        public void setDevid(String devid) {
            this.devid = devid;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public Object getRes1() {
            return res1;
        }

        public void setRes1(Object res1) {
            this.res1 = res1;
        }

        public Object getRes2() {
            return res2;
        }

        public void setRes2(Object res2) {
            this.res2 = res2;
        }

        public Object getRes3() {
            return res3;
        }

        public void setRes3(Object res3) {
            this.res3 = res3;
        }

        public Object getRes4() {
            return res4;
        }

        public void setRes4(Object res4) {
            this.res4 = res4;
        }

        public Object getRes5() {
            return res5;
        }

        public void setRes5(Object res5) {
            this.res5 = res5;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", userid='" + userid + '\'' +
                    ", token='" + token + '\'' +
                    ", access_token='" + access_token + '\'' +
                    ", refresh_token='" + refresh_token + '\'' +
                    ", devid='" + devid + '\'' +
                    ", updatetime='" + updatetime + '\'' +
                    ", res1=" + res1 +
                    ", res2=" + res2 +
                    ", res3=" + res3 +
                    ", res4=" + res4 +
                    ", res5=" + res5 +
                    '}';
        }
    }

}
