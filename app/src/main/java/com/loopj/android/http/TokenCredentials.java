package com.loopj.android.http;

import cz.msebera.android.httpclient.auth.BasicUserPrincipal;
import cz.msebera.android.httpclient.auth.Credentials;
import java.security.Principal;

/* loaded from: classes.dex */
public class TokenCredentials implements Credentials {
    private Principal userPrincipal;

    public TokenCredentials(String str) {
        this.userPrincipal = new BasicUserPrincipal(str);
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public String getPassword() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public Principal getUserPrincipal() {
        return this.userPrincipal;
    }
}
