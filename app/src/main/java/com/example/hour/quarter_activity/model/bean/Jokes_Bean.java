package com.example.hour.quarter_activity.model.bean;

import java.util.List;

/**
 * Created by 王帅彪 on 2018/1/24.
 */

public class Jokes_Bean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"55","createTime":"2017-12-14T20:35:31","imgUrls":"https://www.zhaoapi.cn/images/quarter/15132549316771513254929922373.jpg","jid":952,"praiseNum":null,"shareNum":null,"uid":823,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"1234567890","createTime":"2017-12-14T20:09:19","imgUrls":"https://www.zhaoapi.cn/images/quarter/1513253359021com_example_mydagger2_96x96.png|https://www.zhaoapi.cn/images/quarter/1513253359021com_example_myijkvoide_96x96.png|https://www.zhaoapi.cn/images/quarter/1513253359021com_liu_asus_ikjplayer_96x96.png|https://www.zhaoapi.cn/images/quarter/1513253359021com_hxe_platform_96x96.png|https://www.zhaoapi.cn/images/quarter/1513253359021com_bignox_app_store_hd_96x96.png|https://www.zhaoapi.cn/images/quarter/1513253359021com_android_systemui_tests_96x96.png","jid":951,"praiseNum":null,"shareNum":null,"uid":73,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513166551600e.png","nickname":"蒋顺聪","praiseNum":"null"}},{"commentNum":null,"content":"55","createTime":"2017-12-14T19:48:39","imgUrls":"https://www.zhaoapi.cn/images/quarter/15132521199431513252116331940.jpg","jid":950,"praiseNum":null,"shareNum":null,"uid":823,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"你好世界！！！","createTime":"2017-12-14T19:46:45","imgUrls":null,"jid":949,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"？？？？","createTime":"2017-12-14T19:42:19","imgUrls":"https://www.zhaoapi.cn/images/quarter/1513251739178PictureSelector_20171214_145542.JPEG","jid":948,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"哦哦哦哦哦哦哦哦哦","createTime":"2017-12-14T19:40:05","imgUrls":null,"jid":947,"praiseNum":null,"shareNum":null,"uid":95,"user":{"age":null,"fans":"null","follow":false,"icon":"http://120.27.23.105/images/95.jpg","nickname":"ES113OD%%29778%@FJ177EKHIKSD","praiseNum":"null"}},{"commentNum":null,"content":"52855","createTime":"2017-12-14T19:39:31","imgUrls":"https://www.zhaoapi.cn/images/quarter/1513251571225PictureSelector_20171214_145542.JPEG","jid":946,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"52855","createTime":"2017-12-14T19:39:14","imgUrls":"https://www.zhaoapi.cn/images/quarter/1513251554068PictureSelector_20171214_145542.JPEG","jid":945,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"52855","createTime":"2017-12-14T19:38:23","imgUrls":null,"jid":944,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}},{"commentNum":null,"content":"111111","createTime":"2017-12-14T19:34:59","imgUrls":null,"jid":943,"praiseNum":null,"shareNum":null,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 55
         * createTime : 2017-12-14T20:35:31
         * imgUrls : https://www.zhaoapi.cn/images/quarter/15132549316771513254929922373.jpg
         * jid : 952
         * praiseNum : null
         * shareNum : null
         * uid : 823
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private Object icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
