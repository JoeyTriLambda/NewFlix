package sc;

import ad.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import java.util.Iterator;
import k6.n;
import tc.d;
import u5.h;

/* compiled from: MediaSourceProvider.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"DefaultLocale"})
    public final String f19245a = String.format("ExoMedia %s (%d) / Android %s / %s", "3.1.2r", 60, Build.VERSION.RELEASE, Build.MODEL);

    /* compiled from: MediaSourceProvider.java */
    /* renamed from: sc.a$a, reason: collision with other inner class name */
    public static class C0250a {

        /* renamed from: a, reason: collision with root package name */
        public final d f19246a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19247b;

        /* renamed from: c, reason: collision with root package name */
        public final String f19248c;

        public C0250a(d dVar, String str, String str2) {
            this.f19246a = dVar;
            this.f19247b = str;
            this.f19248c = str2;
        }
    }

    public static C0250a findByExtension(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Iterator it = mc.a.f16263b.iterator();
        while (it.hasNext()) {
            C0250a c0250a = (C0250a) it.next();
            if (c0250a.f19247b.equalsIgnoreCase(str)) {
                return c0250a;
            }
        }
        return null;
    }

    public static C0250a findByLooseComparison(Uri uri) {
        Iterator it = mc.a.f16263b.iterator();
        while (it.hasNext()) {
            C0250a c0250a = (C0250a) it.next();
            if (c0250a.f19248c != null && uri.toString().matches(c0250a.f19248c)) {
                return c0250a;
            }
        }
        return null;
    }

    public h generate(Context context, Handler handler, Uri uri, n nVar) {
        C0250a c0250aFindByExtension = findByExtension(b.getExtension(uri));
        if (c0250aFindByExtension == null) {
            c0250aFindByExtension = findByLooseComparison(uri);
        }
        return (c0250aFindByExtension != null ? c0250aFindByExtension.f19246a : new tc.b()).build(context, uri, this.f19245a, handler, nVar);
    }
}
