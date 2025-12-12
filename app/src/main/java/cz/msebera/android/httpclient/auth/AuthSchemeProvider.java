package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext httpContext);
}
