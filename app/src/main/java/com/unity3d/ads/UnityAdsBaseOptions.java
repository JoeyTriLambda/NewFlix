package com.unity3d.ads;

import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UnityAdsBaseOptions {
    private String OBJECT_ID = "objectId";
    private JSONObject _data = new JSONObject();

    public JSONObject getData() {
        return this._data;
    }

    public void set(String str, String str2) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (str == null || str2 == null) {
            return;
        }
        try {
            this._data.put(str, str2);
        } catch (JSONException e10) {
            DeviceLog.exception("Failed to set Unity Ads options", e10);
        }
    }

    public void setObjectId(String str) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        set(this.OBJECT_ID, str);
    }
}
