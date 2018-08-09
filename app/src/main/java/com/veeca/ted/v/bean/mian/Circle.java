package com.veeca.ted.v.bean.mian;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ted on 2017/7/28.
 */

public class Circle {

    /**
     * msg : 成功！
     * data : [{"res5":null,"res4":null,"createtime":"2017-06-09 15:16:38","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":1,"updatetime":"2017-06-09 15:16:41","circlename":"八卦圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:17:29","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":2,"updatetime":"2017-06-09 15:17:32","circlename":"博客圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:17:47","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":3,"updatetime":"2017-06-09 15:17:50","circlename":"车友圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:18:01","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":4,"updatetime":"2017-06-09 15:18:04","circlename":"宠物圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:18:14","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":5,"updatetime":"2017-06-09 15:18:17","circlename":"精英俱乐部"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:18:27","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":6,"updatetime":"2017-06-09 15:18:31","circlename":"广告圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:18:46","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":7,"updatetime":"2017-06-09 15:18:49","circlename":"兼职圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:19:01","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":8,"updatetime":"2017-06-09 15:19:03","circlename":"美容圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:19:11","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":9,"updatetime":"2017-06-09 15:19:14","circlename":"媒体圈"},{"res5":null,"res4":null,"createtime":"2017-06-09 15:19:30","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":10,"updatetime":"2017-06-09 15:19:32","circlename":"模特圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:20","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":11,"updatetime":"2017-06-21 10:02:23","circlename":"女神圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:27","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":12,"updatetime":"2017-06-21 10:02:30","circlename":"时尚圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:32","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":13,"updatetime":"2017-06-21 10:02:34","circlename":"科技发烧友"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:37","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":14,"updatetime":"2017-06-21 10:02:40","circlename":"网购达人"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:46","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":15,"updatetime":"2017-06-21 10:02:49","circlename":"网红圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:02:52","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":16,"updatetime":"2017-06-21 10:02:55","circlename":"微商圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:03","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":17,"updatetime":"2017-06-21 10:03:06","circlename":"校友圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:09","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":18,"updatetime":"2017-06-21 10:03:11","circlename":"音乐发烧友"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:13","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":19,"updatetime":"2017-06-21 10:03:16","circlename":"游戏圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:19","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":20,"updatetime":"2017-06-21 10:03:22","circlename":"段子手"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:25","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":21,"updatetime":"2017-06-21 10:03:27","circlename":"高端白领圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:30","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":22,"updatetime":"2017-06-21 10:03:33","circlename":"宝妈圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:36","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":23,"updatetime":"2017-06-21 10:03:40","circlename":"保险圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:43","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":24,"updatetime":"2017-06-21 10:03:45","circlename":"炒股圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:48","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":25,"updatetime":"2017-06-21 10:03:51","circlename":"程序员"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:53","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":26,"updatetime":"2017-06-21 10:03:56","circlename":"吃货圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:03:58","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":27,"updatetime":"2017-06-21 10:04:01","circlename":"创业圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:04","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":28,"updatetime":"2017-06-21 10:04:10","circlename":"读友圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:12","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":29,"updatetime":"2017-06-21 10:04:15","circlename":"二次元"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:20","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":30,"updatetime":"2017-06-21 10:04:22","circlename":"单身圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:26","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":31,"updatetime":"2017-06-21 10:04:29","circlename":"佛道圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:31","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":32,"updatetime":"2017-06-21 10:04:34","circlename":"大学生/高校圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:37","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":33,"updatetime":"2017-06-21 10:04:44","circlename":"高中生"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:46","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":34,"updatetime":"2017-06-21 10:04:50","circlename":"海归圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:52","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":35,"updatetime":"2017-06-21 10:04:54","circlename":"海外华人"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:04:58","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":36,"updatetime":"2017-06-21 10:05:00","circlename":"基金圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:03","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":37,"updatetime":"2017-06-21 10:05:06","circlename":"极客圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:11","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":38,"updatetime":"2017-06-21 10:05:13","circlename":"健身圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:16","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":39,"updatetime":"2017-06-21 10:05:20","circlename":"酒吧圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:23","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":40,"updatetime":"2017-06-21 10:05:26","circlename":"乐队圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:29","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":41,"updatetime":"2017-06-21 10:05:31","circlename":"驴友圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:34","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":42,"updatetime":"2017-06-21 10:05:37","circlename":"美剧圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:39","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":43,"updatetime":"2017-06-21 10:05:42","circlename":"牌友圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:45","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":44,"updatetime":"2017-06-21 10:05:48","circlename":"跑步圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:50","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":45,"updatetime":"2017-06-21 10:05:53","circlename":"品酒圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:05:58","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":46,"updatetime":"2017-06-21 10:06:02","circlename":"骑行圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:05","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":47,"updatetime":"2017-06-21 10:06:07","circlename":"企业家圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:10","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":48,"updatetime":"2017-06-21 10:06:12","circlename":"球迷圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:17","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":49,"updatetime":"2017-06-21 10:06:20","circlename":"商会圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:23","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":50,"updatetime":"2017-06-21 10:06:25","circlename":"设计师"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:28","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":51,"updatetime":"2017-06-21 10:06:30","circlename":"摄影圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:33","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":52,"updatetime":"2017-06-21 10:06:37","circlename":"时尚买手"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:39","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":53,"updatetime":"2017-06-21 10:06:43","circlename":"收藏圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:46","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":54,"updatetime":"2017-06-21 10:06:49","circlename":"淘宝客"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:52","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":55,"updatetime":"2017-06-21 10:06:55","circlename":"投资圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:06:58","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":56,"updatetime":"2017-06-21 10:07:00","circlename":"威客圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:06","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":57,"updatetime":"2017-06-21 10:07:08","circlename":"演艺圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:11","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":58,"updatetime":"2017-06-21 10:07:14","circlename":"外企圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:16","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":59,"updatetime":"2017-06-21 10:07:18","circlename":"业主圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:21","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":60,"updatetime":"2017-06-21 10:07:23","circlename":"银行圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:26","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":61,"updatetime":"2017-06-21 10:07:30","circlename":"月光族"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:33","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":62,"updatetime":"2017-06-21 10:07:35","circlename":"孕妇圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:38","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":63,"updatetime":"2017-06-21 10:07:40","circlename":"直销圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:45","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":64,"updatetime":"2017-06-21 10:07:50","circlename":"主播圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:53","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":65,"updatetime":"2017-06-21 10:07:57","circlename":"自拍狂"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:07:59","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":66,"updatetime":"2017-06-21 10:08:02","circlename":"K歌圈"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:08:06","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":67,"updatetime":"2017-06-21 10:08:09","circlename":"宅男宅女"},{"res5":null,"res4":null,"createtime":"2017-06-21 10:08:20","res6":null,"res1":null,"res3":null,"res2":null,"pid":0,"id":68,"updatetime":"2017-06-21 10:08:23","circlename":"理财圈"}]
     * success : true
     */

    private String msg;
    private boolean success;
    private List<DataBean> data;

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
         * createtime : 2017-06-09 15:16:38
         * res6 : null
         * res1 : null
         * res3 : null
         * res2 : null
         * pid : 0
         * id : 1
         * updatetime : 2017-06-09 15:16:41
         * circlename : 八卦圈
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
        private String circlename;

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

        public String getCirclename() {
            return circlename;
        }

        public void setCirclename(String circlename) {
            this.circlename = circlename;
        }
    }



}
