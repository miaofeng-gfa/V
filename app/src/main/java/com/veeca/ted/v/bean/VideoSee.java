package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/12/14.
 */

public class VideoSee {

    /**
     * data : [{"uid":1314,"lid":1,"createTime":"2017-12-14 15:12:12","headImg":"http://xiaovapppic.xiaovka.com/android/image/veeca2017120540477.jpg","updateTime":"2017-12-14 15:12:10","nickName":"单身狗","unionid":"11","productImg":"http://xiaovapppic.xiaovka.com/test/103.png","did":1,"openid":"456456465"}]
     * success : true
     * msg : 成功
     */

    private boolean success;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "VideoSee{" +
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
         * uid : 1314
         * lid : 1
         * createTime : 2017-12-14 15:12:12
         * headImg : http://xiaovapppic.xiaovka.com/android/image/veeca2017120540477.jpg
         * updateTime : 2017-12-14 15:12:10
         * nickName : 单身狗
         * unionid : 11
         * productImg : http://xiaovapppic.xiaovka.com/test/103.png
         * did : 1
         * openid : 456456465
         */

        private int uid;
        private int lid;
        private String createTime;
        private String headImg;
        private String updateTime;
        private String nickName;
        private String unionid;
        private String productImg;
        private int did;
        private String openid;

        @Override
        public String toString() {
            return "DataBean{" +
                    "uid=" + uid +
                    ", lid=" + lid +
                    ", createTime='" + createTime + '\'' +
                    ", headImg='" + headImg + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", unionid='" + unionid + '\'' +
                    ", productImg='" + productImg + '\'' +
                    ", did=" + did +
                    ", openid='" + openid + '\'' +
                    '}';
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getLid() {
            return lid;
        }

        public void setLid(int lid) {
            this.lid = lid;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public String getProductImg() {
            return productImg;
        }

        public void setProductImg(String productImg) {
            this.productImg = productImg;
        }

        public int getDid() {
            return did;
        }

        public void setDid(int did) {
            this.did = did;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }
}
