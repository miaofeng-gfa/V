package com.veeca.ted.v.bean.mian;

import java.util.List;

/**
 * Created by Ted on 2017/11/16.
 */

public class AllCircle {


    /**
     * msg : 成功！
     * data : [{"sctitle":"二次元","scicon":"http://xiaovapp.oss-cn-qingdao","scid":1},{"sctitle":"博客圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":2},{"sctitle":"车友圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":3},{"sctitle":"射鸡师圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":4},{"sctitle":"宠物圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":5},{"sctitle":"孕妇圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":6},{"sctitle":"单身圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":7},{"sctitle":"大学生","scicon":"http://xiaovapp.oss-cn-qingdao","scid":8},{"sctitle":"媒体圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":9},{"sctitle":"海归圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":10},{"sctitle":"月光族","scicon":"http://xiaovapp.oss-cn-qingdao","scid":11},{"sctitle":"时尚圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":12},{"sctitle":"时尚买手","scicon":"http://xiaovapp.oss-cn-qingdao","scid":13},{"sctitle":"科技发烧友","scicon":"http://xiaovapp.oss-cn-qingdao","scid":14},{"sctitle":"美剧圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":15},{"sctitle":"驴友圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":16},{"sctitle":"微商圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":17},{"sctitle":"主播圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":18},{"sctitle":"游戏圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":19},{"sctitle":"跑步圈","scicon":"http://xiaovapp.oss-cn-qingdao","scid":20}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "AllCircle{" +
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

    public static class DataBean {
        /**
         * sctitle : 二次元
         * scicon : http://xiaovapp.oss-cn-qingdao
         * scid : 1
         */

        private String sctitle;
        private String scicon;
        private int scid;

        @Override
        public String toString() {
            return "DataBean{" +
                    "sctitle='" + sctitle + '\'' +
                    ", scicon='" + scicon + '\'' +
                    ", scid=" + scid +
                    '}';
        }

        public String getSctitle() {
            return sctitle;
        }

        public void setSctitle(String sctitle) {
            this.sctitle = sctitle;
        }

        public String getScicon() {
            return scicon;
        }

        public void setScicon(String scicon) {
            this.scicon = scicon;
        }

        public int getScid() {
            return scid;
        }

        public void setScid(int scid) {
            this.scid = scid;
        }
    }
}
