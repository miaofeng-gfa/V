package com.veeca.ted.v.bean.mian;

import java.util.List;

/**
 * Created by Ted on 2017/11/25.
 */

public class MyProfit {
    /**
     * data : [{"uid":308,"gettime":null,"xiaovUser":{"sex":null,"updatetime":null,"profession":null,"state":null,"influence":null,"city":null,"id":298,"createtime":null,"username":null,"logintime":null,"age":null,"province":null,"headimgurl":null,"idcardname":null,"bankname":null,"nickname":"一句晚安","idcard":null,"boundid":null,"deleted":null,"country":null,"pwd":null,"res3":null,"res2":null,"res1":"1.00","logincount":null,"zhifubao":null,"res5":null,"res4":null},"bpstime":null,"btype":3,"bps":null,"oof":0.67,"bkey":null,"aid":null,"bsign":null,"bid":null},{"uid":308,"gettime":null,"xiaovUser":{"sex":null,"updatetime":null,"profession":null,"state":null,"influence":null,"city":null,"id":1310,"createtime":null,"username":null,"logintime":null,"age":null,"province":null,"headimgurl":null,"idcardname":null,"bankname":null,"nickname":"ecxsfouyl","idcard":null,"boundid":null,"deleted":null,"country":null,"pwd":null,"res3":null,"res2":null,"res1":"7.80","logincount":null,"zhifubao":null,"res5":null,"res4":null},"bpstime":null,"btype":3,"bps":null,"oof":0.31,"bkey":null,"aid":null,"bsign":null,"bid":null}]
     * success : true
     * msg : 成功！
     */

    private boolean success;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "Profit{" +
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
         * uid : 308
         * gettime : null
         * xiaovUser : {"sex":null,"updatetime":null,"profession":null,"state":null,"influence":null,"city":null,"id":298,"createtime":null,"username":null,"logintime":null,"age":null,"province":null,"headimgurl":null,"idcardname":null,"bankname":null,"nickname":"一句晚安","idcard":null,"boundid":null,"deleted":null,"country":null,"pwd":null,"res3":null,"res2":null,"res1":"1.00","logincount":null,"zhifubao":null,"res5":null,"res4":null}
         * bpstime : null
         * btype : 3
         * bps : null
         * oof : 0.67
         * bkey : null
         * aid : null
         * bsign : null
         * bid : null
         */

        private int uid;
        private Object gettime;
        private XiaovUserBean xiaovUser;
        private Object bpstime;
        private int btype;
        private Object bps;
        private double oof;
        private Object bkey;
        private Object aid;
        private Object bsign;
        private Object bid;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getGettime() {
            return gettime;
        }

        public void setGettime(Object gettime) {
            this.gettime = gettime;
        }

        public XiaovUserBean getXiaovUser() {
            return xiaovUser;
        }

        public void setXiaovUser(XiaovUserBean xiaovUser) {
            this.xiaovUser = xiaovUser;
        }

        public Object getBpstime() {
            return bpstime;
        }

        public void setBpstime(Object bpstime) {
            this.bpstime = bpstime;
        }

        public int getBtype() {
            return btype;
        }

        public void setBtype(int btype) {
            this.btype = btype;
        }

        public Object getBps() {
            return bps;
        }

        public void setBps(Object bps) {
            this.bps = bps;
        }

        public double getOof() {
            return oof;
        }

        public void setOof(double oof) {
            this.oof = oof;
        }

        public Object getBkey() {
            return bkey;
        }

        public void setBkey(Object bkey) {
            this.bkey = bkey;
        }

        public Object getAid() {
            return aid;
        }

        public void setAid(Object aid) {
            this.aid = aid;
        }

        public Object getBsign() {
            return bsign;
        }

        public void setBsign(Object bsign) {
            this.bsign = bsign;
        }

        public Object getBid() {
            return bid;
        }

        public void setBid(Object bid) {
            this.bid = bid;
        }

        public static class XiaovUserBean {
            /**
             * sex : null
             * updatetime : null
             * profession : null
             * state : null
             * influence : null
             * city : null
             * id : 298
             * createtime : null
             * username : null
             * logintime : null
             * age : null
             * province : null
             * headimgurl : null
             * idcardname : null
             * bankname : null
             * nickname : 一句晚安
             * idcard : null
             * boundid : null
             * deleted : null
             * country : null
             * pwd : null
             * res3 : null
             * res2 : null
             * res1 : 1.00
             * logincount : null
             * zhifubao : null
             * res5 : null
             * res4 : null
             */

            private Object sex;
            private Object updatetime;
            private Object profession;
            private Object state;
            private Object influence;
            private Object city;
            private int id;
            private Object createtime;
            private Object username;
            private Object logintime;
            private Object age;
            private Object province;
            private Object headimgurl;
            private Object idcardname;
            private Object bankname;
            private String nickname;
            private Object idcard;
            private Object boundid;
            private Object deleted;
            private Object country;
            private Object pwd;
            private Object res3;
            private Object res2;
            private String res1;
            private Object logincount;
            private Object zhifubao;
            private Object res5;
            private Object res4;

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public Object getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Object updatetime) {
                this.updatetime = updatetime;
            }

            public Object getProfession() {
                return profession;
            }

            public void setProfession(Object profession) {
                this.profession = profession;
            }

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public Object getInfluence() {
                return influence;
            }

            public void setInfluence(Object influence) {
                this.influence = influence;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getCreatetime() {
                return createtime;
            }

            public void setCreatetime(Object createtime) {
                this.createtime = createtime;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getLogintime() {
                return logintime;
            }

            public void setLogintime(Object logintime) {
                this.logintime = logintime;
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getHeadimgurl() {
                return headimgurl;
            }

            public void setHeadimgurl(Object headimgurl) {
                this.headimgurl = headimgurl;
            }

            public Object getIdcardname() {
                return idcardname;
            }

            public void setIdcardname(Object idcardname) {
                this.idcardname = idcardname;
            }

            public Object getBankname() {
                return bankname;
            }

            public void setBankname(Object bankname) {
                this.bankname = bankname;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Object getIdcard() {
                return idcard;
            }

            public void setIdcard(Object idcard) {
                this.idcard = idcard;
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

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getPwd() {
                return pwd;
            }

            public void setPwd(Object pwd) {
                this.pwd = pwd;
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

            public String getRes1() {
                return res1;
            }

            public void setRes1(String res1) {
                this.res1 = res1;
            }

            public Object getLogincount() {
                return logincount;
            }

            public void setLogincount(Object logincount) {
                this.logincount = logincount;
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

            public Object getRes4() {
                return res4;
            }

            public void setRes4(Object res4) {
                this.res4 = res4;
            }
        }
    }
}
