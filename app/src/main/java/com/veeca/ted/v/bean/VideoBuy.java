package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/12/14.
 */

public class VideoBuy {

    /**
     * data : [{"headImgUrl":"http://xiaovapppic.xiaovka.com/head/888/006%20(486).jpg","time":"2017-12-14 15:13:54","nickName":"1号","img":"http://xiaovapppic.xiaovka.com/test/103.png","contPrice":121}]
     * success : true
     * msg : 成功
     */

    private boolean success;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "VideoBuy{" +
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
         * headImgUrl : http://xiaovapppic.xiaovka.com/head/888/006%20(486).jpg
         * time : 2017-12-14 15:13:54
         * nickName : 1号
         * img : http://xiaovapppic.xiaovka.com/test/103.png
         * contPrice : 121.0
         */

        private String headImgUrl;
        private String time;
        private String nickName;
        private String img;
        private double contPrice;

        @Override
        public String toString() {
            return "DataBean{" +
                    "headImgUrl='" + headImgUrl + '\'' +
                    ", time='" + time + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", img='" + img + '\'' +
                    ", contPrice=" + contPrice +
                    '}';
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public double getContPrice() {
            return contPrice;
        }

        public void setContPrice(double contPrice) {
            this.contPrice = contPrice;
        }
    }
}
