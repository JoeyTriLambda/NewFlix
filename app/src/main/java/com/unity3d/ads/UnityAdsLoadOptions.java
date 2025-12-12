package com.unity3d.ads;

import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class UnityAdsLoadOptions extends UnityAdsBaseOptions {
    private String AD_MARKUP = "adMarkup";

    public void setAdMarkup(String str) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        set(this.AD_MARKUP, str);
    }
}
