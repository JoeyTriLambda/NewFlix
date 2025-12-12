package okhttp3;

import java.util.List;
import mf.k;
import zf.i;

/* compiled from: CookieJar.kt */
/* loaded from: classes2.dex */
public interface CookieJar {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    /* compiled from: CookieJar.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: CookieJar.kt */
        public static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                i.checkNotNullParameter(httpUrl, "url");
                return k.emptyList();
            }

            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                i.checkNotNullParameter(httpUrl, "url");
                i.checkNotNullParameter(list, "cookies");
            }
        }

        private Companion() {
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
