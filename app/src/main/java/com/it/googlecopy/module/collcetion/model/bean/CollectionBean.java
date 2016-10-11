package com.it.googlecopy.module.collcetion.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by je on 16-10-6.
 */

public class CollectionBean implements Serializable {


    int ret_code;
    /**
     * imgUrl : http://bbs.crsky.com/1236983883/Mon_1209/25_187069_a86b07318a78665.jpg
     * avaterUrl : http://tupian.qqjay.com/tou3/2016/0726/8529f425cf23fd5afaa376c166b58e29.jpg
     * title : 这个自拍好看吗！！！！！！
     * userName : 是个好人
     */

   public List<DataBean> data;


    public static class DataBean {
       public String imgUrl;
       public String avaterUrl;
        public String title;
        public String userName;


    }
}
