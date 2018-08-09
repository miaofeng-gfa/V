package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/8/7.
 */

public class UserAllCard {

    /**
     * msg : 获取成功！
     * bank : [{"uid":1314,"btime":"2017-08-07 21:47:28","btitle":"招商银行","bnum":"6225758323184761","bid":22,"bicon":"http://xiaovapp.oss-cn-qingdao.aliyuncs.com/logo/%E9%93%B6%E8%A1%8Clogo/%E6%8B%9B%E5%95%86@3x.png"}]
     * success : true
     * zhifubao : 23335921@qq.com
     */

    private String msg;
    private boolean success;
    private String zhifubao;
    private List<BankBean> bank;

    @Override
    public String toString() {
        return "UserAllCard{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", zhifubao='" + zhifubao + '\'' +
                ", bank=" + bank +
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

    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao;
    }

    public List<BankBean> getBank() {
        return bank;
    }

    public void setBank(List<BankBean> bank) {
        this.bank = bank;
    }

    public static class BankBean {
        /**
         * uid : 1314
         * btime : 2017-08-07 21:47:28
         * btitle : 招商银行
         * bnum : 6225758323184761
         * bid : 22
         * bicon : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/logo/%E9%93%B6%E8%A1%8Clogo/%E6%8B%9B%E5%95%86@3x.png
         */

        private int uid;
        private String btime;
        private String btitle;
        private String bnum;
        private int bid;
        private String bicon;

        @Override
        public String toString() {
            return "BankBean{" +
                    "uid=" + uid +
                    ", btime='" + btime + '\'' +
                    ", btitle='" + btitle + '\'' +
                    ", bnum='" + bnum + '\'' +
                    ", bid=" + bid +
                    ", bicon='" + bicon + '\'' +
                    '}';
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getBtime() {
            return btime;
        }

        public void setBtime(String btime) {
            this.btime = btime;
        }

        public String getBtitle() {
            return btitle;
        }

        public void setBtitle(String btitle) {
            this.btitle = btitle;
        }

        public String getBnum() {
            return bnum;
        }

        public void setBnum(String bnum) {
            this.bnum = bnum;
        }

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public String getBicon() {
            return bicon;
        }

        public void setBicon(String bicon) {
            this.bicon = bicon;
        }
    }

}
