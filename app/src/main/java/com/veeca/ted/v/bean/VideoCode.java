package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/12/13.
 */

public class VideoCode {

    /**
     * msg : 成功
     * data : {"vid":1,"cover":"http://xiaovapppic.xiaovka.com/test/z4.png","uid":21322,"headImgUrl":"http://xiaovapp.oss-cn-qingdao.aliyuncs.com/android/image/veeca2017081509104.jpg","playNum":500,"nickName":"小小默默","pid":1,"video":"http://xiaovapppic.xiaovka.com/video/1903.mp4","title":"小黄人洗漱套装","videoSales":10,"transpond":300,"\u201cbuyPer\u201d":0.0333}
     * success : true
     */

    private String msg;
    private DataBean data;
    private boolean success;

    @Override
    public String toString() {
        return "VideoCode{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public static class DataBean {
        /**
         * vid : 1
         * cover : http://xiaovapppic.xiaovka.com/test/z4.png
         * uid : 21322
         * headImgUrl : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/android/image/veeca2017081509104.jpg
         * playNum : 500
         * nickName : 小小默默
         * pid : 1
         * video : http://xiaovapppic.xiaovka.com/video/1903.mp4
         * title : 小黄人洗漱套装
         * videoSales : 10
         * transpond : 300
         * “buyPer” : 0.0333
         */

        private int vid;
        private String cover;
        private int uid;
        private String headImgUrl;
        private int playNum;
        private String nickName;
        private int pid;
        private String video;
        private String title;
        private int videoSales;
        private int transpond;
        private double buyPer;

        @Override
        public String toString() {
            return "DataBean{" +
                    "vid=" + vid +
                    ", cover='" + cover + '\'' +
                    ", uid=" + uid +
                    ", headImgUrl='" + headImgUrl + '\'' +
                    ", playNum=" + playNum +
                    ", nickName='" + nickName + '\'' +
                    ", pid=" + pid +
                    ", video='" + video + '\'' +
                    ", title='" + title + '\'' +
                    ", videoSales=" + videoSales +
                    ", transpond=" + transpond +
                    ", buyPer=" + buyPer +
                    '}';
        }

        public double getBuyPer() {
            return buyPer;
        }

        public void setBuyPer(double buyPer) {
            this.buyPer = buyPer;
        }

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getVideoSales() {
            return videoSales;
        }

        public void setVideoSales(int videoSales) {
            this.videoSales = videoSales;
        }

        public int getTranspond() {
            return transpond;
        }

        public void setTranspond(int transpond) {
            this.transpond = transpond;
        }

    }
}
