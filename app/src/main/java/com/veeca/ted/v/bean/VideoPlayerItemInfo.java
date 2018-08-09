package com.veeca.ted.v.bean;

import java.util.List;

/**
 * ============================================================
 * Copyright：JackChan和他的朋友们有限公司版权所有 (c) 2017
 * Author：   JackChan
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChan1999
 * GitBook：  https://www.gitbook.com/@alleniverson
 * CSDN博客： http://blog.csdn.net/axi295309066
 * 个人博客： https://jackchan1999.github.io/
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：VideoPlayer
 * Package_Name：com.jackchan.videoplayer
 * Version：1.0
 * time：2017/5/24 18:05
 * des ：列表实体类
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/24 18:05
 * updateDes：${TODO}
 * ============================================================
 */

public class VideoPlayerItemInfo {


    /**
     * data : [{"uid":21322,"videoPriceSum":28,"title":"多功能小麦煮面器","cover":"http://xiaovapppic.xiaovka.com/test/100.png","nickName":"小小默默","transpond":200,"playNum":200,"pid":5,"vid":5,"video":"http://xiaovapppic.xiaovka.com/video/1907.mp4","contPrice":4}]
     * success : true
     * msg : 成功
     */

    private boolean success;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "VideoPlayerItemInfo{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 21322
         * videoPriceSum : 28
         * title : 多功能小麦煮面器
         * cover : http://xiaovapppic.xiaovka.com/test/100.png
         * nickName : 小小默默
         * transpond : 200
         * playNum : 200
         * pid : 5
         * vid : 5
         * video : http://xiaovapppic.xiaovka.com/video/1907.mp4
         * contPrice : 4
         */

        private int uid;
        private double videoPriceSum;
        private String title;
        private String cover;
        private String nickName;
        private int transpond;
        private int playNum;
        private int pid;
        private int vid;
        private String video;
        private double contPrice;
        private double sellPrice;

        @Override
        public String toString() {
            return "DataBean{" +
                    "uid=" + uid +
                    ", videoPriceSum=" + videoPriceSum +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", transpond=" + transpond +
                    ", playNum=" + playNum +
                    ", pid=" + pid +
                    ", vid=" + vid +
                    ", video='" + video + '\'' +
                    ", contPrice=" + contPrice +
                    '}';
        }

        public double getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(double sellPrice) {
            this.sellPrice = sellPrice;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public double getVideoPriceSum() {
            return videoPriceSum;
        }

        public void setVideoPriceSum(double videoPriceSum) {
            this.videoPriceSum = videoPriceSum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getTranspond() {
            return transpond;
        }

        public void setTranspond(int transpond) {
            this.transpond = transpond;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public double getContPrice() {
            return contPrice;
        }

        public void setContPrice(double contPrice) {
            this.contPrice = contPrice;
        }
    }
}
