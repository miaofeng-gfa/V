package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/8/7.
 */

public class TaskV {

    /**
     * msg : 获取成功！
     * joinCount : 1
     * success : true
     * xiaovShareList : [{"res5":null,"res4":"0.50","hid":null,"res1":"uohgfqxtn","res3":"1","res2":"http://xiaovapp.oss-cn-qingdao.aliyuncs.com/head/999/img0001%20(53).png","checkendtime":null,"userid":null,"time1":null,"checkdesc":null,"url5":null,"url3":null,"url4":null,"url1":null,"url2":null,"checkstarttime":null,"id":null,"updatetime":null,"checkstate":null}]
     */

    private String msg;
    private int joinCount;
    private boolean success;
    private List<XiaovShareListBean> xiaovShareList;

    @Override
    public String toString() {
        return "TaskV{" +
                "msg='" + msg + '\'' +
                ", joinCount=" + joinCount +
                ", success=" + success +
                ", xiaovShareList=" + xiaovShareList +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(int joinCount) {
        this.joinCount = joinCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<XiaovShareListBean> getXiaovShareList() {
        return xiaovShareList;
    }

    public void setXiaovShareList(List<XiaovShareListBean> xiaovShareList) {
        this.xiaovShareList = xiaovShareList;
    }

    public static class XiaovShareListBean {
        /**
         * res5 : null
         * res4 : 0.50
         * hid : null
         * res1 : uohgfqxtn
         * res3 : 1
         * res2 : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/head/999/img0001%20(53).png
         * checkendtime : null
         * userid : null
         * time1 : null
         * checkdesc : null
         * url5 : null
         * url3 : null
         * url4 : null
         * url1 : null
         * url2 : null
         * checkstarttime : null
         * id : null
         * updatetime : null
         * checkstate : null
         */

        private Object res5;
        private double res4;
        private Object hid;
        private String res1;
        private String res3;
        private String res2;
        private Object checkendtime;
        private Object userid;
        private Object time1;
        private Object checkdesc;
        private Object url5;
        private Object url3;
        private Object url4;
        private Object url1;
        private Object url2;
        private Object checkstarttime;
        private Object id;
        private Object updatetime;
        private Object checkstate;

        public Object getRes5() {
            return res5;
        }

        public void setRes5(Object res5) {
            this.res5 = res5;
        }

        public double getRes4() {
            return res4;
        }

        public void setRes4(double res4) {
            this.res4 = res4;
        }

        public Object getHid() {
            return hid;
        }

        public void setHid(Object hid) {
            this.hid = hid;
        }

        public String getRes1() {
            return res1;
        }

        public void setRes1(String res1) {
            this.res1 = res1;
        }

        public String getRes3() {
            return res3;
        }

        public void setRes3(String res3) {
            this.res3 = res3;
        }

        public String getRes2() {
            return res2;
        }

        public void setRes2(String res2) {
            this.res2 = res2;
        }

        public Object getCheckendtime() {
            return checkendtime;
        }

        public void setCheckendtime(Object checkendtime) {
            this.checkendtime = checkendtime;
        }

        public Object getUserid() {
            return userid;
        }

        public void setUserid(Object userid) {
            this.userid = userid;
        }

        public Object getTime1() {
            return time1;
        }

        public void setTime1(Object time1) {
            this.time1 = time1;
        }

        public Object getCheckdesc() {
            return checkdesc;
        }

        public void setCheckdesc(Object checkdesc) {
            this.checkdesc = checkdesc;
        }

        public Object getUrl5() {
            return url5;
        }

        public void setUrl5(Object url5) {
            this.url5 = url5;
        }

        public Object getUrl3() {
            return url3;
        }

        public void setUrl3(Object url3) {
            this.url3 = url3;
        }

        public Object getUrl4() {
            return url4;
        }

        public void setUrl4(Object url4) {
            this.url4 = url4;
        }

        public Object getUrl1() {
            return url1;
        }

        public void setUrl1(Object url1) {
            this.url1 = url1;
        }

        public Object getUrl2() {
            return url2;
        }

        public void setUrl2(Object url2) {
            this.url2 = url2;
        }

        public Object getCheckstarttime() {
            return checkstarttime;
        }

        public void setCheckstarttime(Object checkstarttime) {
            this.checkstarttime = checkstarttime;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }

        public Object getCheckstate() {
            return checkstate;
        }

        public void setCheckstate(Object checkstate) {
            this.checkstate = checkstate;
        }
    }
}
