package com.veeca.ted.v.bean;

/**
 * Created by Ted on 2017/8/24.
 */

public class Version {


    /**
     * msg : 成功！
     * data : {"fromm":1,"download":"http://www.baidu.com","isForce":0,"id":1,"versionName":"1.1.4","versionCode":2}
     * success : true
     */

    private String msg;
    private DataBean data;
    private boolean success;

    @Override
    public String toString() {
        return "Version{" +
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
         * fromm : 1
         * download : http://www.baidu.com
         * isForce : 0
         * id : 1
         * versionName : 1.1.4
         * versionCode : 2
         */

        private int fromm;
        private String download;
        private int isForce;
        private int id;
        private String versionName;
        private int versionCode;

        @Override
        public String toString() {
            return "DataBean{" +
                    "fromm=" + fromm +
                    ", download='" + download + '\'' +
                    ", isForce=" + isForce +
                    ", id=" + id +
                    ", versionName='" + versionName + '\'' +
                    ", versionCode=" + versionCode +
                    '}';
        }

        public int getFromm() {
            return fromm;
        }

        public void setFromm(int fromm) {
            this.fromm = fromm;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public int getIsForce() {
            return isForce;
        }

        public void setIsForce(int isForce) {
            this.isForce = isForce;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }
    }
}
