package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/8/4.
 */

public class Task {


    /**
     * msg : 获取成功！
     * userstate : 2
     * data : {"startAge":0,"alsocount":null,"personcount":420,"regional":"不限","pic":null,"title":"桑拿天指南 | 喝碗靓汤补盐分","des2":null,"des3":null,"time1":"2017-06-22 11:19:08","uid":28,"time2":null,"url3":null,"des":null,"rate":null,"url2":null,"alsotime":null,"cpc":0.5,"payment":300,"id":151,"pic2":null,"pic3":null,"res5":"分享奖励","res4":"分享奖励","res6":null,"res1":"0","coverimg":"http://xiaovapp.oss-cn-qingdao.aliyuncs.com/ein/app-c/15.jpg","getmaxmoney":null,"res3":"分享奖励","sex":"0","res2":null,"isjoin":1,"multiple":null,"ratecpc":0.71,"picsample":null,"left1":209.5,"type1":2,"statusr":3,"url":"http://mp.weixin.qq.com/s/WFaloo3Hf0uV2H6cAwBGuw","confirm":null,"endAge":0,"countc":1,"happytime":null,"hinfo":"0","username":"15"}
     * success : true
     * nickname : 熊爸爸的心厨房
     * headimgurl : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/logo/person/7.jpg
     * dataInfoShareLow : 分享文章
     * shareUrl : http://api.xiaovka.com/XiaovCPC/getOpenid.do?userid=1320&token=2306d40c-1546-4761-a3ea-e9ef378b9b3f&hid=151
     * dataInfoShareIn : 文章内容详情
     */

    private String msg;
    private int userstate;
    private DataBean data;
    private boolean success;
    private String nickname;
    private String headimgurl;
    private String dataInfoShareLow;
    private String shareUrl;
    private String dataInfoShareIn;

    @Override
    public String toString() {
        return "Task2{" +
                "msg='" + msg + '\'' +
                ", userstate=" + userstate +
                ", data=" + data +
                ", success=" + success +
                ", nickname='" + nickname + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", dataInfoShareLow='" + dataInfoShareLow + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", dataInfoShareIn='" + dataInfoShareIn + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUserstate() {
        return userstate;
    }

    public void setUserstate(int userstate) {
        this.userstate = userstate;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getDataInfoShareLow() {
        return dataInfoShareLow;
    }

    public void setDataInfoShareLow(String dataInfoShareLow) {
        this.dataInfoShareLow = dataInfoShareLow;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getDataInfoShareIn() {
        return dataInfoShareIn;
    }

    public void setDataInfoShareIn(String dataInfoShareIn) {
        this.dataInfoShareIn = dataInfoShareIn;
    }

    public static class DataBean {

        /**
         * startAge : 0
         * alsocount : null
         * personcount : 420
         * regional : 不限
         * pic : null
         * title : 桑拿天指南 | 喝碗靓汤补盐分
         * des2 : null
         * des3 : null
         * time1 : 2017-06-22 11:19:08
         * uid : 28
         * time2 : null
         * url3 : null
         * des : null
         * rate : null
         * url2 : null
         * alsotime : null
         * cpc : 0.5
         * payment : 300
         * id : 151
         * pic2 : null
         * pic3 : null
         * res5 : 分享奖励
         * res4 : 分享奖励
         * res6 : null
         * res1 : 0
         * coverimg : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/ein/app-c/15.jpg
         * getmaxmoney : null
         * res3 : 分享奖励
         * sex : 0
         * res2 : null
         * isjoin : 1
         * multiple : null
         * ratecpc : 0.71
         * picsample : null
         * left1 : 209.5
         * type1 : 2
         * statusr : 3
         * url : http://mp.weixin.qq.com/s/WFaloo3Hf0uV2H6cAwBGuw
         * confirm : null
         * endAge : 0
         * countc : 1
         * happytime : null
         * hinfo : 0
         * username : 15
         */

        private int startAge;
        private int personcount;
        private String regional;
        private String title;
        private String time1;
        private int uid;
        private double cpc;
        private int payment;
        private int id;
        private String res5;
        private String res4;
        private int res1;
        private String coverimg;
        private Object getmaxmoney;
        private String res3;
        private String sex;
        private double res2;
        private int isjoin;
        private double ratecpc;
        private double left1;
        private int type1;
        private int statusr;
        private String url;
        private int endAge;
        private int countc;
        private String hinfo;
        private String username;
        private int rep;

        @Override
        public String toString() {
            return "DataBean{" +
                    "startAge=" + startAge +
                    ", personcount=" + personcount +
                    ", regional='" + regional + '\'' +
                    ", title='" + title + '\'' +
                    ", time1='" + time1 + '\'' +
                    ", uid=" + uid +
                    ", cpc=" + cpc +
                    ", payment=" + payment +
                    ", id=" + id +
                    ", res5='" + res5 + '\'' +
                    ", res4='" + res4 + '\'' +
                    ", res1=" + res1 +
                    ", coverimg='" + coverimg + '\'' +
                    ", getmaxmoney=" + getmaxmoney +
                    ", res3='" + res3 + '\'' +
                    ", sex='" + sex + '\'' +
                    ", res2=" + res2 +
                    ", isjoin=" + isjoin +
                    ", ratecpc=" + ratecpc +
                    ", left1=" + left1 +
                    ", type1=" + type1 +
                    ", statusr=" + statusr +
                    ", url='" + url + '\'' +
                    ", endAge=" + endAge +
                    ", countc=" + countc +
                    ", hinfo='" + hinfo + '\'' +
                    ", username='" + username + '\'' +
                    ", rep=" + rep +
                    '}';
        }

        public int getRep() {
            return rep;
        }

        public void setRep(int rep) {
            this.rep = rep;
        }

        public int getStartAge() {
            return startAge;
        }

        public void setStartAge(int startAge) {
            this.startAge = startAge;
        }

        public int getPersoncount() {
            return personcount;
        }

        public void setPersoncount(int personcount) {
            this.personcount = personcount;
        }

        public String getRegional() {
            return regional;
        }

        public void setRegional(String regional) {
            this.regional = regional;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public double getCpc() {
            return cpc;
        }

        public void setCpc(double cpc) {
            this.cpc = cpc;
        }

        public int getPayment() {
            return payment;
        }

        public void setPayment(int payment) {
            this.payment = payment;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRes5() {
            return res5;
        }

        public void setRes5(String res5) {
            this.res5 = res5;
        }

        public String getRes4() {
            return res4;
        }

        public void setRes4(String res4) {
            this.res4 = res4;
        }

        public int getRes1() {
            return res1;
        }

        public void setRes1(int res1) {
            this.res1 = res1;
        }

        public String getCoverimg() {
            return coverimg;
        }

        public void setCoverimg(String coverimg) {
            this.coverimg = coverimg;
        }

        public Object getGetmaxmoney() {
            return getmaxmoney;
        }

        public void setGetmaxmoney(Object getmaxmoney) {
            this.getmaxmoney = getmaxmoney;
        }

        public String getRes3() {
            return res3;
        }

        public void setRes3(String res3) {
            this.res3 = res3;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public double getRes2() {
            return res2;
        }

        public void setRes2(double res2) {
            this.res2 = res2;
        }

        public int getIsjoin() {
            return isjoin;
        }

        public void setIsjoin(int isjoin) {
            this.isjoin = isjoin;
        }

        public double getRatecpc() {
            return ratecpc;
        }

        public void setRatecpc(double ratecpc) {
            this.ratecpc = ratecpc;
        }

        public double getLeft1() {
            return left1;
        }

        public void setLeft1(double left1) {
            this.left1 = left1;
        }

        public int getType1() {
            return type1;
        }

        public void setType1(int type1) {
            this.type1 = type1;
        }

        public int getStatusr() {
            return statusr;
        }

        public void setStatusr(int statusr) {
            this.statusr = statusr;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getEndAge() {
            return endAge;
        }

        public void setEndAge(int endAge) {
            this.endAge = endAge;
        }

        public int getCountc() {
            return countc;
        }

        public void setCountc(int countc) {
            this.countc = countc;
        }

        public String getHinfo() {
            return hinfo;
        }

        public void setHinfo(String hinfo) {
            this.hinfo = hinfo;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public class Share1{

        /**
         * msg : 成功
         * success : true
         * url : http://api.xiaovka.com/XiaovCPC/getOpenid.do?userid=1320&token=2306d40c-1546-4761-a3ea-e9ef378b9b3f&hid=151
         */

        private String msg;
        private boolean success;
        private String url;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
