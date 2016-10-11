package com.it.googlecopy.module.home.model;

import android.accounts.NetworkErrorException;

import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;
import com.it.googlecopy.base.ModelHttpClientFactory;
import com.it.googlecopy.module.home.model.bean.HomeItem;

import java.lang.reflect.Type;

/**
 * 首页数据加载类
 * Created by je on 16-10-10.
 */

public class HomeModel
{

    public static HomeItem getHomeData() throws NetworkErrorException
    {
        return ModelHttpClientFactory.getJsonObjectForTypeToken("http://192.168.1.105:8080/demo/query",
                new TypeToken<HomeItem>() {}.getType());
    }
}
