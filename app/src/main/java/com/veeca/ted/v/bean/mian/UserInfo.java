package com.veeca.ted.v.bean.mian;

/**
 * Created by Ted on 2017/11/16.
 */

public class UserInfo {

    /**
     * msg : 成功！
     * data : {"country":null,"city":null,"logincount":null,"influence":854,"province":"北京","qrCode":null,"nickname":"啊啊啊啊","headimgurl":"http://xiaovapppic.xiaovka.com/android/image/veeca2017090626785.jpg","id":1320,"state":2,"rep":1,"idcardname":"蔡昊楠","zhifubao":null,"res5":null,"profession":null,"res4":null,"createtime":"2017-07-25 18:19:23","logintime":null,"res1":"1","res3":null,"res2":null,"sex":1,"boundid":null,"deleted":null,"idcard":"230522199109262012","bankname":null,"updatetime":"2017-11-08 15:20:27","pwd":null,"age":26,"username":"15600036108"}
     * success : true
     * myInfluenceChar : 我的影响力
     */

    private String msg;
    private DataBean data;
    private boolean success;
    private String myInfluenceChar;

    @Override
    public String toString() {
        return "UserInfo{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", myInfluenceChar='" + myInfluenceChar + '\'' +
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

    public String getMyInfluenceChar() {
        return myInfluenceChar;
    }

    public void setMyInfluenceChar(String myInfluenceChar) {
        this.myInfluenceChar = myInfluenceChar;
    }

    public static class DataBean {
        /**
         * country : null
         * city : null
         * logincount : null
         * influence : 854
         * province : 北京
         * qrCode : null
         * nickname : 啊啊啊啊
         * headimgurl : http://xiaovapppic.xiaovka.com/android/image/veeca2017090626785.jpg
         * id : 1320
         * state : 2
         * rep : 1
         * idcardname : 蔡昊楠
         * zhifubao : null
         * res5 : null
         * profession : null
         * res4 : null
         * createtime : 2017-07-25 18:19:23
         * logintime : null
         * res1 : 1
         * res3 : null
         * res2 : null
         * sex : 1
         * boundid : null
         * deleted : null
         * idcard : 230522199109262012
         * bankname : null
         * updatetime : 2017-11-08 15:20:27
         * pwd : null
         * age : 26
         * username : 15600036108
         */

        private Object country;
        private Object city;
        private Object logincount;
        private String influence;
        private String province;
        private String qrCode;
        private String nickname;
        private String headimgurl;
        private int id;
        private int state;
        private int rep;
        private String idcardname;
        private Object zhifubao;
        private Object res5;
        private Object profession;
        private Object res4;
        private String createtime;
        private Object logintime;
        private String res1;
        private Object res3;
        private Object res2;
        private int sex;
        private Object boundid;
        private Object deleted;
        private String idcard;
        private Object bankname;
        private String updatetime;
        private Object pwd;
        private int age;
        private String username;

        @Override
        public String toString() {
            return "DataBean{" +
                    "country=" + country +
                    ", city=" + city +
                    ", logincount=" + logincount +
                    ", influence=" + influence +
                    ", province='" + province + '\'' +
                    ", qrCode=" + qrCode +
                    ", nickname='" + nickname + '\'' +
                    ", headimgurl='" + headimgurl + '\'' +
                    ", id=" + id +
                    ", state=" + state +
                    ", rep=" + rep +
                    ", idcardname='" + idcardname + '\'' +
                    ", zhifubao=" + zhifubao +
                    ", res5=" + res5 +
                    ", profession=" + profession +
                    ", res4=" + res4 +
                    ", createtime='" + createtime + '\'' +
                    ", logintime=" + logintime +
                    ", res1='" + res1 + '\'' +
                    ", res3=" + res3 +
                    ", res2=" + res2 +
                    ", sex=" + sex +
                    ", boundid=" + boundid +
                    ", deleted=" + deleted +
                    ", idcard='" + idcard + '\'' +
                    ", bankname=" + bankname +
                    ", updatetime='" + updatetime + '\'' +
                    ", pwd=" + pwd +
                    ", age=" + age +
                    ", username='" + username + '\'' +
                    '}';
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getLogincount() {
            return logincount;
        }

        public void setLogincount(Object logincount) {
            this.logincount = logincount;
        }

        public String getInfluence() {
            return influence;
        }

        public void setInfluence(String influence) {
            this.influence = influence;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getRep() {
            return rep;
        }

        public void setRep(int rep) {
            this.rep = rep;
        }

        public String getIdcardname() {
            return idcardname;
        }

        public void setIdcardname(String idcardname) {
            this.idcardname = idcardname;
        }

        public Object getZhifubao() {
            return zhifubao;
        }

        public void setZhifubao(Object zhifubao) {
            this.zhifubao = zhifubao;
        }

        public Object getRes5() {
            return res5;
        }

        public void setRes5(Object res5) {
            this.res5 = res5;
        }

        public Object getProfession() {
            return profession;
        }

        public void setProfession(Object profession) {
            this.profession = profession;
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

        public Object getLogintime() {
            return logintime;
        }

        public void setLogintime(Object logintime) {
            this.logintime = logintime;
        }

        public String getRes1() {
            return res1;
        }

        public void setRes1(String res1) {
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

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public Object getBoundid() {
            return boundid;
        }

        public void setBoundid(Object boundid) {
            this.boundid = boundid;
        }

        public Object getDeleted() {
            return deleted;
        }

        public void setDeleted(Object deleted) {
            this.deleted = deleted;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public Object getBankname() {
            return bankname;
        }

        public void setBankname(Object bankname) {
            this.bankname = bankname;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public Object getPwd() {
            return pwd;
        }

        public void setPwd(Object pwd) {
            this.pwd = pwd;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
