package com.comcast.viper.hlsparserj.tags;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class TagFactory {
    private static ConcurrentHashMap<String, Class<?>> tagMap = new ConcurrentHashMap<>();

    public static Tag createTag(String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        Class<?> cls = tagMap.get(str);
        if (cls != null) {
            try {
                objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            objNewInstance = null;
        }
        if (objNewInstance instanceof Tag) {
            return (Tag) objNewInstance;
        }
        return null;
    }

    public static void registerTag(String str, Class<?> cls) {
        tagMap.put(str, cls);
    }
}
