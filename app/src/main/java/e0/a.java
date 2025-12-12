package e0;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import cz.msebera.android.httpclient.protocol.HTTP;

/* compiled from: Easing.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11112b;

    /* renamed from: a, reason: collision with root package name */
    public String f11113a = HTTP.IDENTITY_CODING;

    static {
        new a();
        f11112b = new String[]{CookieSpecs.STANDARD, "accelerate", "decelerate", "linear"};
    }

    public String toString() {
        return this.f11113a;
    }
}
