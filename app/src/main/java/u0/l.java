package u0;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final b0.i<String, Typeface> f19950a = new b0.i<>(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f19951b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f19952c;

    /* renamed from: d, reason: collision with root package name */
    public static final b0.k<String, ArrayList<w0.a<a>>> f19953d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f19951b = threadPoolExecutor;
        f19952c = new Object();
        f19953d = new b0.k<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static u0.l.a a(java.lang.String r8, android.content.Context r9, u0.g r10, int r11) {
        /*
            b0.i<java.lang.String, android.graphics.Typeface> r0 = u0.l.f19950a
            java.lang.Object r1 = r0.get(r8)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            u0.l$a r8 = new u0.l$a
            r8.<init>(r1)
            return r8
        L10:
            r1 = 0
            u0.m$a r10 = u0.f.a(r9, r1, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L69
            int r2 = r10.getStatusCode()
            r3 = 1
            r4 = -3
            if (r2 == 0) goto L26
            int r2 = r10.getStatusCode()
            if (r2 == r3) goto L24
            goto L3f
        L24:
            r2 = -2
            goto L48
        L26:
            u0.m$b[] r2 = r10.getFonts()
            if (r2 == 0) goto L47
            int r5 = r2.length
            if (r5 != 0) goto L30
            goto L47
        L30:
            int r3 = r2.length
            r5 = 0
            r6 = 0
        L33:
            if (r6 >= r3) goto L46
            r7 = r2[r6]
            int r7 = r7.getResultCode()
            if (r7 == 0) goto L43
            if (r7 >= 0) goto L41
        L3f:
            r2 = -3
            goto L48
        L41:
            r2 = r7
            goto L48
        L43:
            int r6 = r6 + 1
            goto L33
        L46:
            r3 = 0
        L47:
            r2 = r3
        L48:
            if (r2 == 0) goto L50
            u0.l$a r8 = new u0.l$a
            r8.<init>(r2)
            return r8
        L50:
            u0.m$b[] r10 = r10.getFonts()
            android.graphics.Typeface r9 = o0.e.createFromFontInfo(r9, r1, r10, r11)
            if (r9 == 0) goto L63
            r0.put(r8, r9)
            u0.l$a r8 = new u0.l$a
            r8.<init>(r9)
            return r8
        L63:
            u0.l$a r8 = new u0.l$a
            r8.<init>(r4)
            return r8
        L69:
            u0.l$a r8 = new u0.l$a
            r9 = -1
            r8.<init>(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.l.a(java.lang.String, android.content.Context, u0.g, int):u0.l$a");
    }

    /* compiled from: FontRequestWorker.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f19954a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19955b;

        public a(int i10) {
            this.f19954a = null;
            this.f19955b = i10;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f19954a = typeface;
            this.f19955b = 0;
        }
    }
}
