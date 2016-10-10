package com.it.googlecopy.module.home.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by je on 16-10-4.
 */

public class HomeItem {




    public int ret_code;
    /**
     * avaterUrl : http://tupian.qqjay.com/tou3/2016/0726/8529f425cf23fd5afaa376c166b58e29.jpg
     * userName : 是个好人
     * communityName : AndroidDeveloper
     * title : 这个自拍好看吗！！！！！！
     * imgUrl : http://img1.imgtn.bdimg.com/it/u=1298960379,3758980022&fm=11&gp=0.jpg
     * isLike : false
     * likeCount : 20
     */

    public List<DataBean> data;


    public static class DataBean implements Serializable{
        public String avaterUrl;
        public String userName;
        public String communityName;
        public String title;
        public String imgUrl;
        public boolean isLike;
        public int likeCount;

        @Override
        public String toString() {
            return "DataBean{" +
                    "avaterUrl='" + avaterUrl + '\'' +
                    ", userName='" + userName + '\'' +
                    ", communityName='" + communityName + '\'' +
                    ", title='" + title + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", isLike=" + isLike +
                    ", likeCount=" + likeCount +
                    '}';
        }
    }
}
