package com.distributor.product_service.util;

import lombok.AccessLevel;
import lombok.Getter;
import com.google.gson.GsonBuilder;

@Getter(AccessLevel.PRIVATE)
public class JsonConverter {

    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
        try {
            return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(json, clazz);
        } catch (Exception e) {
            String msg = "Could not convert json : " + json + " to class : " + clazz;
            msg += "Possible reason(s) : " + e.getMessage();
            throw new Exception(msg, e);
        }
    }

    public static String toJson(Object object) throws Exception {
        try {
            return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(object);
        } catch (Exception e) {
            String msg = "Could not convert object : " + object.toString() + " to JSON, possible reason(s) : ";
            msg += e.getMessage();
            throw new Exception(msg, e);
        }
    }
}
