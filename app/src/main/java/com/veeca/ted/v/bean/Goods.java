package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/12/12.
 */

public class Goods {
    /**
     * data : {"sellPrice":9.9,"buyPer":0.0333,"title":"小黄人洗漱套装","sales":200,"img":"http://xiaovapppic.xiaovka.com/test/103.png","offPrice":38,"vid":1,"sellPoints":"比3个月底价低120元","contPrice":3,"video":"http://xiaovapppic.xiaovka.com/video/1903.mp4"}
     * success : true
     * msg : 成功
     */

    private DataBean data;
    private boolean success;
    private String msg;

    @Override
    public String toString() {
        return "Goods{" +
                "data=" + data +
                ", success=" + success +
                ", msg='" + msg + '\'' +
                '}';
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * sellPrice : 9.9
         * buyPer : 0.0333
         * title : 小黄人洗漱套装
         * sales : 200
         * img : http://xiaovapppic.xiaovka.com/test/103.png
         * offPrice : 38
         * vid : 1
         * sellPoints : 比3个月底价低120元
         * contPrice : 3
         * video : http://xiaovapppic.xiaovka.com/video/1903.mp4
         */

        private double sellPrice;
        private double buyPer;
        private String title;
        private int sales;
        private String img;
        private double offPrice;
        private int vid;
        private String sellPoints;
        private double contPrice;
        private String video;

        @Override
        public String toString() {
            return "DataBean{" +
                    "sellPrice=" + sellPrice +
                    ", buyPer=" + buyPer +
                    ", title='" + title + '\'' +
                    ", sales=" + sales +
                    ", img='" + img + '\'' +
                    ", offPrice=" + offPrice +
                    ", vid=" + vid +
                    ", sellPoints='" + sellPoints + '\'' +
                    ", contPrice=" + contPrice +
                    ", video='" + video + '\'' +
                    '}';
        }

        public double getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(double sellPrice) {
            this.sellPrice = sellPrice;
        }

        public double getBuyPer() {
            return buyPer;
        }

        public void setBuyPer(double buyPer) {
            this.buyPer = buyPer;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSales() {
            return sales;
        }

        public void setSales(int sales) {
            this.sales = sales;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public double getOffPrice() {
            return offPrice;
        }

        public void setOffPrice(double offPrice) {
            this.offPrice = offPrice;
        }

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public String getSellPoints() {
            return sellPoints;
        }

        public void setSellPoints(String sellPoints) {
            this.sellPoints = sellPoints;
        }

        public double getContPrice() {
            return contPrice;
        }

        public void setContPrice(double contPrice) {
            this.contPrice = contPrice;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }
    }
}
