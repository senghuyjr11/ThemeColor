package com.example.themecolor.utils;

import com.google.gson.Gson;

public class UtilsGson {
    public static String objectToGson(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}
