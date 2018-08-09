package com.veeca.ted.v.bean;

import java.util.List;

/**
 * Created by Ted on 2017/8/11.
 */

public class UserV {

    /**
     * data : {"id":1430,"circleList":[{"cweight":35.21,"circleName":"二次元"},{"cweight":14.18,"circleName":"音乐发烧友"},{"cweight":5.09,"circleName":"宠物圈"},{"cweight":12.27,"circleName":"时尚圈"},{"cweight":33.25,"circleName":"酒吧圈"}],"sex":2,"nickname":"熊猫照镜子","age":20,"thirdList":[{"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E4%BF%A1-3%403x.png","tcname":"镜子","tcthirdname":"微信"},{"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E5%8D%9A%403x.png","tcname":"撸半仙儿","tcthirdname":"微博"},{"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/qq%403x.png","tcname":"熊二的大团","tcthirdname":"QQ"}],"province":"浙江","influence":590,"sumEarn":6804.51,"tagList":[{"tag":"手机"},{"tag":"创意"},{"tag":"大胡子"},{"tag":"蓄势待发"},{"tag":"催眠术"},{"tag":"电话亭"},{"tag":"表演"},{"tag":"酷炫"},{"tag":"运动量"},{"tag":"砖块"},{"tag":"小眼"},{"tag":"迷离"},{"tag":"坐骑"},{"tag":"单身"},{"tag":"APP"},{"tag":"原画"},{"tag":"宠物"},{"tag":"纯正"},{"tag":"爱自由"},{"tag":"小说"},{"tag":"银魂"},{"tag":"腐女"},{"tag":"星座"},{"tag":"爱音乐"},{"tag":"摄影"},{"tag":"霓虹"},{"tag":"AKB"},{"tag":"唱歌"}],"headimgurl":"http://xiaovapp.oss-cn-qingdao.aliyuncs.com/head/999/img0008%20(549).jpg","labelList":[{"labelName":"视频","lweight":15.38},{"labelName":"娱乐","lweight":11.11},{"labelName":"音乐","lweight":8.18},{"labelName":"动漫","lweight":35.21},{"labelName":"宠物","lweight":30.12}]}
     * success : true
     * msg : 成功！
     */

    private DataBean data;
    private boolean success;
    private String msg;

    @Override
    public String toString() {
        return "UserV{" +
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
         * id : 1430
         * circleList : [{"cweight":35.21,"circleName":"二次元"},{"cweight":14.18,"circleName":"音乐发烧友"},{"cweight":5.09,"circleName":"宠物圈"},{"cweight":12.27,"circleName":"时尚圈"},{"cweight":33.25,"circleName":"酒吧圈"}]
         * sex : 2
         * nickname : 熊猫照镜子
         * age : 20
         * thirdList : [{"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E4%BF%A1-3%403x.png","tcname":"镜子","tcthirdname":"微信"},{"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E5%8D%9A%403x.png","tcname":"撸半仙儿","tcthirdname":"微博"},{"tcthirdimg":"http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/qq%403x.png","tcname":"熊二的大团","tcthirdname":"QQ"}]
         * province : 浙江
         * influence : 590
         * sumEarn : 6804.51
         * tagList : [{"tag":"手机"},{"tag":"创意"},{"tag":"大胡子"},{"tag":"蓄势待发"},{"tag":"催眠术"},{"tag":"电话亭"},{"tag":"表演"},{"tag":"酷炫"},{"tag":"运动量"},{"tag":"砖块"},{"tag":"小眼"},{"tag":"迷离"},{"tag":"坐骑"},{"tag":"单身"},{"tag":"APP"},{"tag":"原画"},{"tag":"宠物"},{"tag":"纯正"},{"tag":"爱自由"},{"tag":"小说"},{"tag":"银魂"},{"tag":"腐女"},{"tag":"星座"},{"tag":"爱音乐"},{"tag":"摄影"},{"tag":"霓虹"},{"tag":"AKB"},{"tag":"唱歌"}]
         * headimgurl : http://xiaovapp.oss-cn-qingdao.aliyuncs.com/head/999/img0008%20(549).jpg
         * labelList : [{"labelName":"视频","lweight":15.38},{"labelName":"娱乐","lweight":11.11},{"labelName":"音乐","lweight":8.18},{"labelName":"动漫","lweight":35.21},{"labelName":"宠物","lweight":30.12}]
         */

        private int id;
        private int sex;
        private String nickname;
        private String age;
        private String province;
        private int influence;
        private float sumEarn;
        private String headimgurl;
        private List<CircleListBean> circleList;
        private List<ThirdListBean> thirdList;
        private List<TagListBean> tagList;
        private List<LabelListBean> labelList;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", sex=" + sex +
                    ", nickname='" + nickname + '\'' +
                    ", age=" + age +
                    ", province='" + province + '\'' +
                    ", influence=" + influence +
                    ", sumEarn=" + sumEarn +
                    ", headimgurl='" + headimgurl + '\'' +
                    ", circleList=" + circleList +
                    ", thirdList=" + thirdList +
                    ", tagList=" + tagList +
                    ", labelList=" + labelList +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public int getInfluence() {
            return influence;
        }

        public void setInfluence(int influence) {
            this.influence = influence;
        }

        public float getSumEarn() {
            return sumEarn;
        }

        public void setSumEarn(float sumEarn) {
            this.sumEarn = sumEarn;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public List<CircleListBean> getCircleList() {
            return circleList;
        }

        public void setCircleList(List<CircleListBean> circleList) {
            this.circleList = circleList;
        }

        public List<ThirdListBean> getThirdList() {
            return thirdList;
        }

        public void setThirdList(List<ThirdListBean> thirdList) {
            this.thirdList = thirdList;
        }

        public List<TagListBean> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagListBean> tagList) {
            this.tagList = tagList;
        }

        public List<LabelListBean> getLabelList() {
            return labelList;
        }

        public void setLabelList(List<LabelListBean> labelList) {
            this.labelList = labelList;
        }

        public static class CircleListBean {
            /**
             * cweight : 35.21
             * circleName : 二次元
             */

            private float cweight;
            private String circleName;

            public float getCweight() {
                return cweight;
            }

            public void setCweight(float cweight) {
                this.cweight = cweight;
            }

            public String getCircleName() {
                return circleName;
            }

            public void setCircleName(String circleName) {
                this.circleName = circleName;
            }
        }

        public static class ThirdListBean {
            /**
             * tcthirdimg : http://xiaovweb.oss-cn-qingdao.aliyuncs.com/appui/%E5%BE%AE%E4%BF%A1-3%403x.png
             * tcname : 镜子
             * tcthirdname : 微信
             */

            private String tcthirdimg;
            private String tcname;
            private String tcthirdname;

            public String getTcthirdimg() {
                return tcthirdimg;
            }

            public void setTcthirdimg(String tcthirdimg) {
                this.tcthirdimg = tcthirdimg;
            }

            public String getTcname() {
                return tcname;
            }

            public void setTcname(String tcname) {
                this.tcname = tcname;
            }

            public String getTcthirdname() {
                return tcthirdname;
            }

            public void setTcthirdname(String tcthirdname) {
                this.tcthirdname = tcthirdname;
            }
        }

        public static class TagListBean {
            /**
             * tag : 手机
             */

            private String tag;

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }

        public static class LabelListBean {
            /**
             * labelName : 视频
             * lweight : 15.38
             */

            private String labelName;
            private float lweight;

            public String getLabelName() {
                return labelName;
            }

            public void setLabelName(String labelName) {
                this.labelName = labelName;
            }

            public float getLweight() {
                return lweight;
            }

            public void setLweight(float lweight) {
                this.lweight = lweight;
            }
        }
    }
}
