package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Administrator on 2018-03-20.
 */

public class NoRegisterFriend {

    private Boolean success;
    private String msg;
    private List<NoRegisterFriend.DataBean> data;

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

    @Override
    public String toString() {
        return "NoRegisterFriend{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean{
        private String nickname;
        private String headimgurl;
        private String unionid;
        private int clicktm;

        @Override
        public String toString() {
            return "DataBean{" +
                    "nickname='" + nickname + '\'' +
                    ", headimgurl='" + headimgurl + '\'' +
                    ", unionid=" + unionid +
                    ", clicktm=" + clicktm +
                    '}';
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

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public int getClicktm() {
            return clicktm;
        }

        public void setClicktm(int clicktm) {
            this.clicktm = clicktm;
        }
    }


}
