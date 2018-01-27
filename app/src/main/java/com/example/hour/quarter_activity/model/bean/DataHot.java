package com.example.hour.quarter_activity.model.bean;

import java.util.List;

/**
 * Created by wangguojian on 2018/1/25.
 */

public class DataHot {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516881375072110.jpg","createTime":"2018-01-25T19:56:15","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516881375072minion_09.mp4","wid":254,"workDesc":"测试3"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516881359368110.jpg","createTime":"2018-01-25T19:55:59","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516881359368minion_09.mp4","wid":253,"workDesc":"测试2"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516881341415110.jpg","createTime":"2018-01-25T19:55:41","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516881341415minion_09.mp4","wid":252,"workDesc":"测试"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516880990944110.jpg","createTime":"2018-01-25T19:49:50","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516880990944minion_09.mp4","wid":251,"workDesc":"测试"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516364021918QQ截图20180118200412.png","createTime":"2018-01-19T20:13:41","favoriteNum":0,"latitude":"0","localUri":null,"longitude":"0","playNum":0,"praiseNum":0,"uid":1217,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516364021918QQ截图20180118200334.png","wid":250,"workDesc":"哈哈哈"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1515587806806151496296995.jpg","createTime":"2018-01-10T20:36:46","favoriteNum":1,"latitude":"41.6729118196","localUri":null,"longitude":"89.6484375000","playNum":0,"praiseNum":1,"uid":71,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516808172920temp.png","nickname":"12","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1515587806806Video_00200.wmv","wid":249,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1515587623180151496296995.jpg","createTime":"2018-01-10T20:33:43","favoriteNum":0,"latitude":"41.6729118196","localUri":null,"longitude":"89.6484375000","playNum":0,"praiseNum":0,"uid":1217,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1515587623180Video_00200.wmv","wid":248,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514709891571cover.jpg","createTime":"2017-12-31T16:44:51","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":3,"praiseNum":0,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15147098915711514709865656.mp4","wid":247,"workDesc":" "},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514704790621column_2.png","createTime":"2017-12-31T15:19:50","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10622,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514704790621PictureSelector_20171231_151914.mp4","wid":246,"workDesc":"11"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514623018680cover.jpg","createTime":"2017-12-30T16:36:58","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":0,"praiseNum":0,"uid":88,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/88.jpg","nickname":"解杰\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514623018680videowallpaper_1005.mp4","wid":245,"workDesc":"一个个来"}]
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
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/1516881375072110.jpg
         * createTime : 2018-01-25T19:56:15
         * favoriteNum : 0
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 0
         * praiseNum : 0
         * uid : 1497
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1516881375072minion_09.mp4
         * wid : 254
         * workDesc : 测试3
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
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

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15160825477571516082546650.png
             * nickname : 哈哈
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
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
