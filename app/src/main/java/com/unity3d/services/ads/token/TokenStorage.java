package com.unity3d.services.ads.token;

import lf.h;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: TokenStorage.kt */
/* loaded from: classes2.dex */
public interface TokenStorage {
    void appendTokens(JSONArray jSONArray) throws JSONException;

    void createTokens(JSONArray jSONArray) throws JSONException;

    void deleteTokens();

    h getNativeGeneratedToken();

    String getToken();

    void setInitToken(String str);
}
