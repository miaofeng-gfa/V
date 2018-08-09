package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/12/8.
 */

public class VInfo {

    /**
     * msg : 获取成功！
     * xiaovFlockRec : {"flowNum":95410,"fansNum":4857,"successNum":12,"num":1,"photo":"http://xiaovapppic.xiaovka.com/ein/fake-c/1/1.png|http://xiaovapppic.xiaovka.com/ein/fake-c/1/2.png|http://xiaovapppic.xiaovka.com/ein/fake-c/1/3.png|http://xiaovapppic.xiaovka.com/ein/fake-c/1/4.png","updateTime":null,"sort":null,"rid":93,"rec":null,"headImgUrl":"http://xiaovapppic.xiaovka.com/ein/todayvka/2/39.png","createTime":null,"cpc":88,"name":"邓紫怡","lable":"时尚|美妆|美食|可爱|汽车","startTime":"2017-11-28 10:32:55","endTime":null,"position":"花椒时尚-美妆主播","status":1}
     * success : true
     * biddingList : [{"uid":1939,"money":55.61,"num":1,"nickname":"阿俊同学","headimgurl":"http://xiaovapppic.xiaovka.com/head/20000/001%20(308).jpg","wxaccount":"13806040928","updatetime":"2017-11-30 17:16:38"},{"uid":1940,"money":25.23,"num":1,"nickname":"吴建军","headimgurl":"http://xiaovapppic.xiaovka.com/head/20000/001%20(313).jpg","wxaccount":"13584122022","updatetime":"2017-11-30 17:16:38"},{"uid":1941,"money":20,"num":1,"nickname":"青春无悔","headimgurl":"http://xiaovapppic.xiaovka.com/head/20000/2/002%20(638).jpg","wxaccount":"13761794404","updatetime":"2017-11-30 17:16:38"},{"uid":1942,"money":11,"num":1,"nickname":"D.B.M.N.","headimgurl":"http://xiaovapppic.xiaovka.com/head/20000/2/002%20(712).jpg","wxaccount":"13588899988","updatetime":"2017-11-30 17:16:38"},{"uid":1943,"money":6,"num":1,"nickname":"江湖夜雨不熄燈","headimgurl":"http://xiaovapppic.xiaovka.com/head/20000/2/002%20(782).jpg","wxaccount":"18093636777","updatetime":"2017-11-30 17:16:38"}]
     * count : 8
     */

    private String msg;
    private XiaovFlockRecBean xiaovFlockRec;
    private boolean success;
    private int count;
    private List<BiddingListBean> biddingList;

    @Override
    public String toString() {
        return "VInfo{" +
                "msg='" + msg + '\'' +
                ", xiaovFlockRec=" + xiaovFlockRec +
                ", success=" + success +
                ", count=" + count +
                ", biddingList=" + biddingList +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public XiaovFlockRecBean getXiaovFlockRec() {
        return xiaovFlockRec;
    }

    public void setXiaovFlockRec(XiaovFlockRecBean xiaovFlockRec) {
        this.xiaovFlockRec = xiaovFlockRec;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BiddingListBean> getBiddingList() {
        return biddingList;
    }

    public void setBiddingList(List<BiddingListBean> biddingList) {
        this.biddingList = biddingList;
    }

    public static class XiaovFlockRecBean {
        /**
         * flowNum : 95410
         * fansNum : 4857
         * successNum : 12
         * num : 1
         * photo : http://xiaovapppic.xiaovka.com/ein/fake-c/1/1.png|http://xiaovapppic.xiaovka.com/ein/fake-c/1/2.png|http://xiaovapppic.xiaovka.com/ein/fake-c/1/3.png|http://xiaovapppic.xiaovka.com/ein/fake-c/1/4.png
         * updateTime : null
         * sort : null
         * rid : 93
         * rec : null
         * headImgUrl : http://xiaovapppic.xiaovka.com/ein/todayvka/2/39.png
         * createTime : null
         * cpc : 88
         * name : 邓紫怡
         * lable : 时尚|美妆|美食|可爱|汽车
         * startTime : 2017-11-28 10:32:55
         * endTime : null
         * position : 花椒时尚-美妆主播
         * status : 1
         */

        private int flowNum;
        private int fansNum;
        private int successNum;
        private int num;
        private String photo;
        private Object updateTime;
        private Object sort;
        private int rid;
        private Object rec;
        private String headImgUrl;
        private Object createTime;
        private String cpc;
        private String name;
        private String lable;
        private String startTime;
        private Object endTime;
        private String position;
        private int status;

        @Override
        public String toString() {
            return "XiaovFlockRecBean{" +
                    "flowNum=" + flowNum +
                    ", fansNum=" + fansNum +
                    ", successNum=" + successNum +
                    ", num=" + num +
                    ", photo='" + photo + '\'' +
                    ", updateTime=" + updateTime +
                    ", sort=" + sort +
                    ", rid=" + rid +
                    ", rec=" + rec +
                    ", headImgUrl='" + headImgUrl + '\'' +
                    ", createTime=" + createTime +
                    ", cpc=" + cpc +
                    ", name='" + name + '\'' +
                    ", lable='" + lable + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", endTime=" + endTime +
                    ", position='" + position + '\'' +
                    ", status=" + status +
                    '}';
        }

        public int getFlowNum() {
            return flowNum;
        }

        public void setFlowNum(int flowNum) {
            this.flowNum = flowNum;
        }

        public int getFansNum() {
            return fansNum;
        }

        public void setFansNum(int fansNum) {
            this.fansNum = fansNum;
        }

        public int getSuccessNum() {
            return successNum;
        }

        public void setSuccessNum(int successNum) {
            this.successNum = successNum;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public Object getRec() {
            return rec;
        }

        public void setRec(Object rec) {
            this.rec = rec;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getCpc() {
            return cpc;
        }

        public void setCpc(String cpc) {
            this.cpc = cpc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLable() {
            return lable;
        }

        public void setLable(String lable) {
            this.lable = lable;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public static class BiddingListBean {
        /**
         * uid : 1939
         * money : 55.61
         * num : 1
         * nickname : 阿俊同学
         * headimgurl : http://xiaovapppic.xiaovka.com/head/20000/001%20(308).jpg
         * wxaccount : 13806040928
         * updatetime : 2017-11-30 17:16:38
         */

        private int uid;
        private double money;
        private int num;
        private String nickname;
        private String headimgurl;
        private String wxaccount;
        private String updatetime;

        @Override
        public String toString() {
            return "BiddingListBean{" +
                    "uid=" + uid +
                    ", money=" + money +
                    ", num=" + num +
                    ", nickname='" + nickname + '\'' +
                    ", headimgurl='" + headimgurl + '\'' +
                    ", wxaccount='" + wxaccount + '\'' +
                    ", updatetime='" + updatetime + '\'' +
                    '}';
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
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

        public String getWxaccount() {
            return wxaccount;
        }

        public void setWxaccount(String wxaccount) {
            this.wxaccount = wxaccount;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }
}
