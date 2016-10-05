package com.it.googlecopy.module.home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by je on 16-10-4.
 */

public class HomeItem implements Serializable{




    private int ret_code;
    /**
     * avaterUrl : http://tupian.qqjay.com/tou3/2016/0726/8529f425cf23fd5afaa376c166b58e29.jpg
     * userName : 是个好人
     * communityName : AndroidDeveloper
     * title : 这个自拍好看吗！！！！！！
     * imgUrl : http://img1.imgtn.bdimg.com/it/u=1298960379,3758980022&fm=11&gp=0.jpg
     * isLike : false
     * likeCount : 20
     */

    private List<DataBean> data;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String avaterUrl;
        private String userName;
        private String communityName;
        private String title;
        private String imgUrl;
        private boolean isLike;
        private int likeCount;

        public String getAvaterUrl() {
            return avaterUrl;
        }

        public void setAvaterUrl(String avaterUrl) {
            this.avaterUrl = avaterUrl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public boolean isIsLike() {
            return isLike;
        }

        public void setIsLike(boolean isLike) {
            this.isLike = isLike;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }
    }
}
