package com.veeca.ted.v.bean.mian;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ted on 2017/11/22.
 */

public class UserBind {
    /**
     * msg : 成功！
     * data : [{"res5":null,"res4":null,"createtime":"2017-07-31 17:14:35","tcname":"一路向北","res6":null,"res1":null,"tcimg":"http://wx.qlogo.cn/mmopen/Jiavz9UrH80kkSlttyI5OiaRkMP2bqRLmianC6b6xVrwfaXVS8f8lXBlu1HlQMzLvNLhRnQdoNOAgb3QEKyIcyjEjGCNbfLicGYk/0","res3":null,"res2":null,"tcthirdname":"微信","type":0,"tcstate":1,"time1":"2017-07-31 17:14:35","uid":298,"tcaccount":null,"tcfans":null,"tcauthimgurl":"http://xiaovapppic.xiaovka.com/screens/EB79E25E-971C-4C90-BB4B-DB35A80A255A.jpg","tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E4%BF%A1-3%403x.png","tcunionid":null,"id":5097,"tcid":"oxuuOxJO9U8XnehpNH58PRjL3uUE","updatetime":"2017-07-31 17:53:04"},{"res5":null,"res4":null,"createtime":"2017-07-31 17:19:54","tcname":"一路向北","res6":null,"res1":null,"tcimg":"http://qzapp.qlogo.cn/qzapp/1106159646/8E2FDD83777126D3803BC17D68866310/100","res3":null,"res2":null,"tcthirdname":"QQ","type":1,"tcstate":0,"time1":"2017-07-31 17:19:54","uid":298,"tcaccount":null,"tcfans":null,"tcauthimgurl":null,"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/qq%403x.png","tcunionid":"","id":5098,"tcid":"8E2FDD83777126D3803BC17D68866310","updatetime":"2017-07-31 17:19:54"},{"res5":null,"res4":null,"createtime":"2017-07-31 17:41:16","tcname":"solerliang","res6":null,"res1":null,"tcimg":"http://tva4.sinaimg.cn/crop.31.39.233.233.50/006fvEGEjw8ex7oyphy3cj308c08c745.jpg","res3":null,"res2":null,"tcthirdname":"微博","type":2,"tcstate":2,"time1":"2017-07-31 17:41:16","uid":298,"tcaccount":null,"tcfans":15,"tcauthimgurl":null,"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E5%8D%9A%403x.png","tcunionid":"","id":5099,"tcid":"5725986604","updatetime":"2017-07-31 17:41:16"}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "UserBind{" +
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

    public static class DataBean implements Serializable {
        /**
         * res5 : null
         * res4 : null
         * createtime : 2017-07-31 17:14:35
         * tcname : 一路向北
         * res6 : null
         * res1 : null
         * tcimg : http://wx.qlogo.cn/mmopen/Jiavz9UrH80kkSlttyI5OiaRkMP2bqRLmianC6b6xVrwfaXVS8f8lXBlu1HlQMzLvNLhRnQdoNOAgb3QEKyIcyjEjGCNbfLicGYk/0
         * res3 : null
         * res2 : null
         * tcthirdname : 微信
         * type : 0
         * tcstate : 1
         * time1 : 2017-07-31 17:14:35
         * uid : 298
         * tcaccount : null
         * tcfans : null
         * tcauthimgurl : http://xiaovapppic.xiaovka.com/screens/EB79E25E-971C-4C90-BB4B-DB35A80A255A.jpg
         * tcthirdimg : http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E4%BF%A1-3%403x.png
         * tcunionid : null
         * id : 5097
         * tcid : oxuuOxJO9U8XnehpNH58PRjL3uUE
         * updatetime : 2017-07-31 17:53:04
         */

        private Object res5;
        private Object res4;
        private String createtime;
        private String tcname;
        private Object res6;
        private Object res1;
        private String tcimg;
        private Object res3;
        private Object res2;
        private String tcthirdname;
        private int type;
        private int tcstate;
        private String time1;
        private int uid;
        private String tcaccount;
        private int tcfans;
        private String tcauthimgurl;
        private String tcthirdimg;
        private Object tcunionid;
        private int id;
        private String tcid;
        private String updatetime;

        @Override
        public String toString() {
            return "DataBean{" +
                    "res5=" + res5 +
                    ", res4=" + res4 +
                    ", createtime='" + createtime + '\'' +
                    ", tcname='" + tcname + '\'' +
                    ", res6=" + res6 +
                    ", res1=" + res1 +
                    ", tcimg='" + tcimg + '\'' +
                    ", res3=" + res3 +
                    ", res2=" + res2 +
                    ", tcthirdname='" + tcthirdname + '\'' +
                    ", type=" + type +
                    ", tcstate=" + tcstate +
                    ", time1='" + time1 + '\'' +
                    ", uid=" + uid +
                    ", tcaccount='" + tcaccount + '\'' +
                    ", tcfans=" + tcfans +
                    ", tcauthimgurl='" + tcauthimgurl + '\'' +
                    ", tcthirdimg='" + tcthirdimg + '\'' +
                    ", tcunionid=" + tcunionid +
                    ", id=" + id +
                    ", tcid='" + tcid + '\'' +
                    ", updatetime='" + updatetime + '\'' +
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

        public String getTcname() {
            return tcname;
        }

        public void setTcname(String tcname) {
            this.tcname = tcname;
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

        public String getTcimg() {
            return tcimg;
        }

        public void setTcimg(String tcimg) {
            this.tcimg = tcimg;
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

        public String getTcthirdname() {
            return tcthirdname;
        }

        public void setTcthirdname(String tcthirdname) {
            this.tcthirdname = tcthirdname;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getTcstate() {
            return tcstate;
        }

        public void setTcstate(int tcstate) {
            this.tcstate = tcstate;
        }

        public String getTime1() {
            return time1;
        }

        public void setTime1(String time1) {
            this.time1 = time1;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getTcaccount() {
            return tcaccount;
        }

        public void setTcaccount(String tcaccount) {
            this.tcaccount = tcaccount;
        }

        public int getTcfans() {
            return tcfans;
        }

        public void setTcfans(int tcfans) {
            this.tcfans = tcfans;
        }

        public String getTcauthimgurl() {
            return tcauthimgurl;
        }

        public void setTcauthimgurl(String tcauthimgurl) {
            this.tcauthimgurl = tcauthimgurl;
        }

        public String getTcthirdimg() {
            return tcthirdimg;
        }

        public void setTcthirdimg(String tcthirdimg) {
            this.tcthirdimg = tcthirdimg;
        }

        public Object getTcunionid() {
            return tcunionid;
        }

        public void setTcunionid(Object tcunionid) {
            this.tcunionid = tcunionid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTcid() {
            return tcid;
        }

        public void setTcid(String tcid) {
            this.tcid = tcid;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }
}
