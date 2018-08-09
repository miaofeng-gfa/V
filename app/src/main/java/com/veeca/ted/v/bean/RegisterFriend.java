package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Administrator on 2018-03-20.
 */

public class RegisterFriend {
    private Boolean success;
    private String msg;
    private List<RegisterFriend.DataBean> data;

    @Override
    public String toString() {
        return "RegisterFriend{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean{
        private String res1;
        private String nickname;
        private String headimgurl;
        private int pid;
        private int id;

        @Override
        public String toString() {
            return "DataBean{" +
                    "res1='" + res1 + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", headimgurl='" + headimgurl + '\'' +
                    ", pid=" + pid +
                    ", id=" + id +
                    '}';
        }

        public String getRes1() {
            return res1;
        }

        public void setRes1(String res1) {
            this.res1 = res1;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
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
    }
}
