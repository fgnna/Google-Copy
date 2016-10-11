package com.it.googlecopy.module.collcetion.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by je on 16-10-6.
 */

public class CollectionBean implements Serializable{



    private int ret_code;
    /**
     * imgUrl : http://bbs.crsky.com/1236983883/Mon_1209/25_187069_a86b07318a78665.jpg
     * avaterUrl : http://tupian.qqjay.com/tou3/2016/0726/8529f425cf23fd5afaa376c166b58e29.jpg
     * title : 这个自拍好看吗！！！！！！
     * userName : 是个好人
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
        private String imgUrl;
        private String avaterUrl;
        private String title;
        private String userName;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getAvaterUrl() {
            return avaterUrl;
        }

        public void setAvaterUrl(String avaterUrl) {
            this.avaterUrl = avaterUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
