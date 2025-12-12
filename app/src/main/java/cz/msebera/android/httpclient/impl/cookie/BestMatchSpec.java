package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: classes2.dex */
public class BestMatchSpec extends DefaultCookieSpec {
    public BestMatchSpec(String[] strArr, boolean z10) {
        super(strArr, z10);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.DefaultCookieSpec
    public String toString() {
        return "best-match";
    }

    public BestMatchSpec() {
        this(null, false);
    }
}
