package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
/* loaded from: classes2.dex */
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
