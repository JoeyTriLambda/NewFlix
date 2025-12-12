package o0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import n0.g;
import u0.m;

/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final l f16891a;

    /* renamed from: b, reason: collision with root package name */
    public static final b0.i<String, Typeface> f16892b;

    /* compiled from: TypefaceCompat.java */
    public static class a extends m.c {

        /* renamed from: a, reason: collision with root package name */
        public final g.e f16893a;

        public a(g.e eVar) {
            this.f16893a = eVar;
        }

        @Override // u0.m.c
        public void onTypefaceRequestFailed(int i10) {
            g.e eVar = this.f16893a;
            if (eVar != null) {
                eVar.onFontRetrievalFailed(i10);
            }
        }

        @Override // u0.m.c
        public void onTypefaceRetrieved(Typeface typeface) {
            g.e eVar = this.f16893a;
            if (eVar != null) {
                eVar.onFontRetrieved(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f16891a = new k();
        } else if (i10 >= 28) {
            f16891a = new i();
        } else if (i10 >= 26) {
            f16891a = new h();
        } else if (i10 < 24 || !g.isUsable()) {
            f16891a = new f();
        } else {
            f16891a = new g();
        }
        f16892b = new b0.i<>(16);
    }

    public static String a(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface create(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, m.b[] bVarArr, int i10) {
        return f16891a.createFromFontInfo(context, cancellationSignal, bVarArr, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface createFromResourcesFamilyXml(android.content.Context r13, n0.d.b r14, android.content.res.Resources r15, int r16, java.lang.String r17, int r18, int r19, n0.g.e r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r14
            r1 = r20
            r2 = r21
            boolean r3 = r0 instanceof n0.d.e
            if (r3 == 0) goto L66
            n0.d$e r0 = (n0.d.e) r0
            java.lang.String r3 = r0.getSystemFontFamilyName()
            r4 = 0
            if (r3 == 0) goto L2c
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L19
            goto L2c
        L19:
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r4)
            android.graphics.Typeface r5 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r4)
            if (r3 == 0) goto L2c
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L2c
            goto L2d
        L2c:
            r3 = 0
        L2d:
            if (r3 == 0) goto L35
            if (r1 == 0) goto L34
            r1.callbackSuccessAsync(r3, r2)
        L34:
            return r3
        L35:
            r3 = 1
            if (r22 == 0) goto L3f
            int r5 = r0.getFetchStrategy()
            if (r5 != 0) goto L43
            goto L41
        L3f:
            if (r1 != 0) goto L43
        L41:
            r9 = 1
            goto L44
        L43:
            r9 = 0
        L44:
            if (r22 == 0) goto L4c
            int r3 = r0.getTimeout()
            r10 = r3
            goto L4e
        L4c:
            r3 = -1
            r10 = -1
        L4e:
            android.os.Handler r11 = n0.g.e.getHandler(r21)
            o0.e$a r12 = new o0.e$a
            r12.<init>(r1)
            u0.g r7 = r0.getRequest()
            r6 = r13
            r8 = r19
            android.graphics.Typeface r0 = u0.m.requestFont(r6, r7, r8, r9, r10, r11, r12)
            r5 = r15
            r6 = r19
            goto L7e
        L66:
            o0.l r3 = o0.e.f16891a
            n0.d$c r0 = (n0.d.c) r0
            r4 = r13
            r5 = r15
            r6 = r19
            android.graphics.Typeface r0 = r3.createFromFontFamilyFilesResourceEntry(r13, r0, r15, r6)
            if (r1 == 0) goto L7e
            if (r0 == 0) goto L7a
            r1.callbackSuccessAsync(r0, r2)
            goto L7e
        L7a:
            r3 = -3
            r1.callbackFailAsync(r3, r2)
        L7e:
            if (r0 == 0) goto L89
            b0.i<java.lang.String, android.graphics.Typeface> r1 = o0.e.f16892b
            java.lang.String r2 = a(r15, r16, r17, r18, r19)
            r1.put(r2, r0)
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.e.createFromResourcesFamilyXml(android.content.Context, n0.d$b, android.content.res.Resources, int, java.lang.String, int, int, n0.g$e, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceCreateFromResourcesFontFile = f16891a.createFromResourcesFontFile(context, resources, i10, str, i12);
        if (typefaceCreateFromResourcesFontFile != null) {
            f16892b.put(a(resources, i10, str, i11, i12), typefaceCreateFromResourcesFontFile);
        }
        return typefaceCreateFromResourcesFontFile;
    }

    public static Typeface findFromCache(Resources resources, int i10, String str, int i11, int i12) {
        return f16892b.get(a(resources, i10, str, i11, i12));
    }
}
