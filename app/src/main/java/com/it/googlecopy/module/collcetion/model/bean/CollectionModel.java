package com.it.googlecopy.module.collcetion.model.bean;

import android.accounts.NetworkErrorException;

import com.google.gson.reflect.TypeToken;
import com.it.googlecopy.base.ModelHttpClientFactory;

/**
 * Created by je on 16-10-11.
 */

public class CollectionModel {
    public static CollectionBean getCollectionData() throws NetworkErrorException {
        return ModelHttpClientFactory.getJsonObjectForTypeToken("http://192.168.1" +
                ".105:8080/demo/keep", new TypeToken<CollectionBean>() {
        }.getType());
    }
}
