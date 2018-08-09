package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/11/27.
 */

public class Tasking {
    /**
     * msg : 获取数据成功！
     * data : [{"res5":null,"res4":"0","hid":128,"res1":"现代武林传奇 | 少年武士赴死","res3":"0","res2":"2","checkendtime":null,"userid":298,"time1":"2017-06-28 10:32:34","checkdesc":null,"url5":"http://xiaovapppic.xiaovka.com/","url3":"http://xiaovapppic.xiaovka.com/","url4":"http://xiaovapppic.xiaovka.com/","url1":"http://xiaovapppic.xiaovka.com/screens/2D2A1E13-5407-49F4-A8DC-1849818F81EF.jpg","url2":"http://xiaovapp.oss-cn-qingdao.aliyuncs.com/head/888/006%20(2).jpg","checkstarttime":"2017-07-05 18:46:40","id":297,"updatetime":"2017-07-12 13:48:30","checkstate":3}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "TaskNow{" +
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
         * res4 : 0
         * hid : 128
         * res1 : 现代武林传奇 | 少年武士赴死
         * res3 : 0
         * res2 : 2
         * checkendtime : null
         * userid : 298
         * time1 : 2017-06-28 10:32:34
         * checkdesc : null
         * url5 : http://xiaovapppic.xiaovka.com/
         * url3 : http://xiaovapppic.xiaovka.com/
         * url4 : http://xiaovapppic.xiaovka.com/
         * url1 : http://xiaovapppic.xiaovka.com/screens/2D2A1E13-5407-49F4-A8DC-1849818F81EF.jpg
         * url2 : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/head/888/006%20(2).jpg
         * checkstarttime : 2017-07-05 18:46:40
         * id : 297
         * updatetime : 2017-07-12 13:48:30
         * checkstate : 3
         */

        private Object res5;
        private String res4;
        private int hid;
        private String res1;
        private int res3;
        private int res2;
        private Object checkendtime;
        private int userid;
        private String time1;
        private Object checkdesc;
        private String url5;
        private String url3;
        private String url4;
        private String url1;
        private String url2;
        private String checkstarttime;
        private int id;
        private String updatetime;
        private int checkstate;

        @Override
        public String toString() {
            return "DataBean{" +
                    "res5=" + res5 +
                    ", res4='" + res4 + '\'' +
                    ", hid=" + hid +
                    ", res1='" + res1 + '\'' +
                    ", res3=" + res3 +
                    ", res2=" + res2 +
                    ", checkendtime=" + checkendtime +
                    ", userid=" + userid +
                    ", time1='" + time1 + '\'' +
                    ", checkdesc=" + checkdesc +
                    ", url5='" + url5 + '\'' +
                    ", url3='" + url3 + '\'' +
                    ", url4='" + url4 + '\'' +
                    ", url1='" + url1 + '\'' +
                    ", url2='" + url2 + '\'' +
                    ", checkstarttime='" + checkstarttime + '\'' +
                    ", id=" + id +
                    ", updatetime='" + updatetime + '\'' +
                    ", checkstate=" + checkstate +
                    '}';
        }

        public Object getRes5() {
            return res5;
        }

        public void setRes5(Object res5) {
            this.res5 = res5;
        }

        public String getRes4() {
            return res4;
        }

        public void setRes4(String res4) {
            this.res4 = res4;
        }

        public int getHid() {
            return hid;
        }

        public void setHid(int hid) {
            this.hid = hid;
        }

        public String getRes1() {
            return res1;
        }

        public void setRes1(String res1) {
            this.res1 = res1;
        }

        public int getRes3() {
            return res3;
        }

        public void setRes3(int res3) {
            this.res3 = res3;
        }

        public int getRes2() {
            return res2;
        }

        public void setRes2(int res2) {
            this.res2 = res2;
        }

        public Object getCheckendtime() {
            return checkendtime;
        }

        public void setCheckendtime(Object checkendtime) {
            this.checkendtime = checkendtime;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getTime1() {
            return time1;
        }

        public void setTime1(String time1) {
            this.time1 = time1;
        }

        public Object getCheckdesc() {
            return checkdesc;
        }

        public void setCheckdesc(Object checkdesc) {
            this.checkdesc = checkdesc;
        }

        public String getUrl5() {
            return url5;
        }

        public void setUrl5(String url5) {
            this.url5 = url5;
        }

        public String getUrl3() {
            return url3;
        }

        public void setUrl3(String url3) {
            this.url3 = url3;
        }

        public String getUrl4() {
            return url4;
        }

        public void setUrl4(String url4) {
            this.url4 = url4;
        }

        public String getUrl1() {
            return url1;
        }

        public void setUrl1(String url1) {
            this.url1 = url1;
        }

        public String getUrl2() {
            return url2;
        }

        public void setUrl2(String url2) {
            this.url2 = url2;
        }

        public String getCheckstarttime() {
            return checkstarttime;
        }

        public void setCheckstarttime(String checkstarttime) {
            this.checkstarttime = checkstarttime;
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

        public int getCheckstate() {
            return checkstate;
        }

        public void setCheckstate(int checkstate) {
            this.checkstate = checkstate;
        }
    }
}
