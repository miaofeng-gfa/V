package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/12/14.
 */

public class VideoUrl {

    /**
     * data : {"subTitle":"窈窕淑女，君子好逑!","title":"小黄人洗漱套装","cover":"http://xiaovapppic.xiaovka.com/test/z4.png","url":"http://www.baidu.com?vid=1&uid=18&pid=1"}
     * success : true
     * msg : 成功
     */

    private DataBean data;
    private boolean success;
    private String msg;

    @Override
    public String toString() {
        return "VideoUrl{" +
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
         * subTitle : 窈窕淑女，君子好逑!
         * title : 小黄人洗漱套装
         * cover : http://xiaovapppic.xiaovka.com/test/z4.png
         * url : http://www.baidu.com?vid=1&uid=18&pid=1
         */

        private String subTitle;
        private String title;
        private String cover;
        private String url;

        @Override
        public String toString() {
            return "DataBean{" +
                    "subTitle='" + subTitle + '\'' +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
