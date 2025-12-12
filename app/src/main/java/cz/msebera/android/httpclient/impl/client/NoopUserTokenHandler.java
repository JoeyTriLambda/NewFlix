package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.protocol.HttpContext;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class NoopUserTokenHandler implements UserTokenHandler {
    public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();

    @Override // cz.msebera.android.httpclient.client.UserTokenHandler
    public Object getUserToken(HttpContext httpContext) {
        return null;
    }
}
