package com.veeca.ted.v.bean.mian;

import java.util.List;

/**
 * Created by Administrator on 2018-03-18.
 */

public class FriendsMoney {

    private  String msg;
    private  int count1;
    private  int count2;
    private  Boolean success;
    private   double setScale;
    private  List<DataBean> registerList;
    private  List<DataBean> notRegisterList;


    @Override
    public String toString() {
        return "FriendsMoney{" +
                "msg='" + msg + '\'' +
                ", count1=" + count1 +
                ", count2=" + count2 +
                ", success=" + success +
                ", setScale=" + setScale +
                ", registerList=" + registerList +
                ", notRegisterList=" + notRegisterList +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public double getSetScale() {
        return setScale;
    }

    public void setSetScale(double setScale) {
        this.setScale = setScale;
    }

    public List<DataBean> getRegisterList() {
        return registerList;
    }

    public void setRegisterList(List<DataBean> registerList) {
        this.registerList = registerList;
    }

    public List<DataBean> getNotRegisterList() {
        return notRegisterList;
    }

    public void setNotRegisterList(List<DataBean> notRegisterList) {
        this.notRegisterList = notRegisterList;
    }

    public static class DataBean2 {

    }

    public static class DataBean {
        private  String unionid;
        private  String nickname;
        private  String headimgurl;
        private  int clicktm;

        @Override
        public String toString() {
            return "DataBean{" +
                    "unionid='" + unionid + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", headimgurl='" + headimgurl + '\'' +
                    ", clicktm=" + clicktm +
                    '}';
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
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

        public int getClicktm() {
            return clicktm;
        }

        public void setClicktm(int clicktm) {
            this.clicktm = clicktm;
        }
    }

}
