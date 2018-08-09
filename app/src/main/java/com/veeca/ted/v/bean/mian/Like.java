package com.veeca.ted.v.bean.mian;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ted on 2017/7/28.
 */

public class Like {

    /**
     * msg : 成功！
     * data : [{"res5":null,"res4":null,"createtime":"2017-06-09 15:06:07","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":1,"updatetime":"2017-06-09 15:06:10","labelname":"家居"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:06:44","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":2,"updatetime":"2017-06-09 15:06:48","labelname":"母婴"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:07:03","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":3,"updatetime":"2017-06-09 15:07:06","labelname":"交友"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:07:13","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":4,"updatetime":"2017-06-09 15:07:17","labelname":"旅游"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:07:31","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":5,"updatetime":"2017-06-09 15:07:34","labelname":"教育"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:07:41","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":6,"updatetime":"2017-06-09 15:07:45","labelname":"时尚"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:07:56","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":7,"updatetime":"2017-06-09 15:07:59","labelname":"游戏"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:08:40","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":8,"updatetime":"2017-06-09 15:08:42","labelname":"房产"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:08:54","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":9,"updatetime":"2017-06-09 15:08:56","labelname":"金融"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:09:10","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":10,"updatetime":"2017-06-09 15:09:13","labelname":"数码"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:48:02","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":11,"updatetime":"2017-06-21 09:48:05","labelname":"家电"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:48:16","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":12,"updatetime":"2017-06-21 09:48:19","labelname":"健康"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:48:29","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":13,"updatetime":"2017-06-21 09:48:32","labelname":"图书"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:48:44","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":14,"updatetime":"2017-06-21 09:48:46","labelname":"体育"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:48:58","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":15,"updatetime":"2017-06-21 09:49:01","labelname":"互联网"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:49:11","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":16,"updatetime":"2017-06-21 09:49:14","labelname":"航空"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:49:24","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":17,"updatetime":"2017-06-21 09:49:26","labelname":"汽车"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:49:38","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":18,"updatetime":"2017-06-21 09:49:40","labelname":"美食"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:49:50","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":19,"updatetime":"2017-06-21 09:49:52","labelname":"健身"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:50:09","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":20,"updatetime":"2017-06-21 09:50:11","labelname":"美容"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:50:24","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":21,"updatetime":"2017-06-21 09:50:27","labelname":"婚嫁"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:50:40","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":22,"updatetime":"2017-06-21 09:50:42","labelname":"医疗"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:50:56","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":23,"updatetime":"2017-06-21 09:50:58","labelname":"服饰"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:51:10","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":24,"updatetime":"2017-06-21 09:51:12","labelname":"动漫"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:51:21","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":25,"updatetime":"2017-06-21 09:51:23","labelname":"宠物"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:51:34","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":26,"updatetime":"2017-06-21 09:51:37","labelname":"影视"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:51:47","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":27,"updatetime":"2017-06-21 09:51:50","labelname":"求职"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:52:00","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":28,"updatetime":"2017-06-21 09:52:03","labelname":"摄影"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:52:15","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":29,"updatetime":"2017-06-21 09:52:17","labelname":"养生"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:52:28","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":30,"updatetime":"2017-06-21 09:52:32","labelname":"新闻"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:52:43","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":31,"updatetime":"2017-06-21 09:52:46","labelname":"搞笑"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:52:55","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":32,"updatetime":"2017-06-21 09:52:57","labelname":"明星"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:53:06","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":33,"updatetime":"2017-06-21 09:53:08","labelname":"创业"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:53:27","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":34,"updatetime":"2017-06-21 09:53:30","labelname":"广告"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:53:41","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":35,"updatetime":"2017-06-21 09:53:42","labelname":"购物"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:53:52","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":36,"updatetime":"2017-06-21 09:53:54","labelname":"娱乐"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:54:05","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":37,"updatetime":"2017-06-21 09:54:07","labelname":"情感"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:54:26","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":38,"updatetime":"2017-06-21 09:54:28","labelname":"校园"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:54:38","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":39,"updatetime":"2017-06-21 09:54:41","labelname":"法律"},{"res5":null,"res4":null,"createtime":"2017-06-21 09:54:54","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":40,"updatetime":"2017-06-21 09:54:56","labelname":"视频"},{"res5":null,"res4":null,"createtime":"2017-07-21 10:25:29","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":41,"updatetime":"2017-07-21 10:25:31","labelname":"音乐"},{"res5":null,"res4":null,"createtime":"2017-07-21 10:25:55","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":42,"updatetime":"2017-07-21 10:25:58","labelname":"收藏"},{"res5":null,"res4":null,"createtime":"2017-07-21 10:26:09","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":43,"updatetime":"2017-07-21 10:26:11","labelname":"公益"},{"res5":null,"res4":null,"createtime":"2017-07-21 10:26:22","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":44,"updatetime":"2017-07-21 10:26:24","labelname":"艺术"}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "Like{" +
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

    public static class DataBean implements Serializable {
        /**
         * res5 : null
         * res4 : null
         * createtime : 2017-06-09 15:06:07
         * res6 : null
         * res1 : null
         * res3 : null
         * res2 : null
         * pid : 0
         * id : 1
         * updatetime : 2017-06-09 15:06:10
         * labelname : 家居
         */

        private Object res5;
        private Object res4;
        private String createtime;
        private Object res6;
        private Object res1;
        private Object res3;
        private Object res2;
        private int pid;
        private int id;
        private String updatetime;
        private String labelname;

        @Override
        public String toString() {
            return "DataBean{" +
                    "res5=" + res5 +
                    ", res4=" + res4 +
                    ", createtime='" + createtime + '\'' +
                    ", res6=" + res6 +
                    ", res1=" + res1 +
                    ", res3=" + res3 +
                    ", res2=" + res2 +
                    ", pid=" + pid +
                    ", id=" + id +
                    ", updatetime='" + updatetime + '\'' +
                    ", labelname='" + labelname + '\'' +
                    '}';
        }

        public Object getRes5() {
            return res5;
        }

        public void setRes5(Object res5) {
            this.res5 = res5;
        }

        public Object getRes4() {
            return res4;
        }

        public void setRes4(Object res4) {
            this.res4 = res4;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getRes6() {
            return res6;
        }

        public void setRes6(Object res6) {
            this.res6 = res6;
        }

        public Object getRes1() {
            return res1;
        }

        public void setRes1(Object res1) {
            this.res1 = res1;
        }

        public Object getRes3() {
            return res3;
        }

        public void setRes3(Object res3) {
            this.res3 = res3;
        }

        public Object getRes2() {
            return res2;
        }

        public void setRes2(Object res2) {
            this.res2 = res2;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getLabelname() {
            return labelname;
        }

        public void setLabelname(String labelname) {
            this.labelname = labelname;
        }
    }
}
