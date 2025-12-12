package u0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import u0.l;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public final class m {

    /* compiled from: FontsContractCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f19956a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f19957b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f19956a = i10;
            this.f19957b = bVarArr;
        }

        public b[] getFonts() {
            return this.f19957b;
        }

        public int getStatusCode() {
            return this.f19956a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f19958a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19959b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19960c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19961d;

        /* renamed from: e, reason: collision with root package name */
        public final int f19962e;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f19958a = (Uri) w0.h.checkNotNull(uri);
            this.f19959b = i10;
            this.f19960c = i11;
            this.f19961d = z10;
            this.f19962e = i12;
        }

        public int getResultCode() {
            return this.f19962e;
        }

        public int getTtcIndex() {
            return this.f19959b;
        }

        public Uri getUri() {
            return this.f19958a;
        }

        public int getWeight() {
            return this.f19960c;
        }

        public boolean isItalic() {
            return this.f19961d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    public static class c {
        public void onTypefaceRequestFailed(int i10) {
            throw null;
        }

        public void onTypefaceRetrieved(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return o0.e.createFromFontInfo(context, cancellationSignal, bVarArr, 0);
    }

    public static a fetchFonts(Context context, CancellationSignal cancellationSignal, g gVar) throws PackageManager.NameNotFoundException {
        return f.a(context, cancellationSignal, gVar);
    }

    public static Typeface requestFont(Context context, g gVar, int i10, boolean z10, int i11, Handler handler, c cVar) throws InterruptedException {
        u0.c cVar2 = new u0.c(cVar, handler);
        if (z10) {
            b0.i<String, Typeface> iVar = l.f19950a;
            String str = gVar.f19939e + "-" + i10;
            Typeface typeface = l.f19950a.get(str);
            if (typeface != null) {
                handler.post(new u0.a(cVar, typeface));
                return typeface;
            }
            if (i11 == -1) {
                l.a aVarA = l.a(str, context, gVar, i10);
                cVar2.a(aVarA);
                return aVarA.f19954a;
            }
            try {
                try {
                    try {
                        l.a aVar = (l.a) l.f19951b.submit(new h(str, context, gVar, i10)).get(i11, TimeUnit.MILLISECONDS);
                        cVar2.a(aVar);
                        return aVar.f19954a;
                    } catch (InterruptedException e10) {
                        throw e10;
                    } catch (ExecutionException e11) {
                        throw new RuntimeException(e11);
                    }
                } catch (TimeoutException unused) {
                    throw new InterruptedException("timeout");
                }
            } catch (InterruptedException unused2) {
                cVar2.f19930b.post(new u0.b(cVar2.f19929a, -3));
                return null;
            }
        }
        b0.i<String, Typeface> iVar2 = l.f19950a;
        String str2 = gVar.f19939e + "-" + i10;
        Typeface typeface2 = l.f19950a.get(str2);
        if (typeface2 != null) {
            handler.post(new u0.a(cVar, typeface2));
            return typeface2;
        }
        i iVar3 = new i(cVar2);
        synchronized (l.f19952c) {
            b0.k<String, ArrayList<w0.a<l.a>>> kVar = l.f19953d;
            ArrayList<w0.a<l.a>> arrayList = kVar.get(str2);
            if (arrayList != null) {
                arrayList.add(iVar3);
            } else {
                ArrayList<w0.a<l.a>> arrayList2 = new ArrayList<>();
                arrayList2.add(iVar3);
                kVar.put(str2, arrayList2);
                l.f19951b.execute(new o(Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(), new j(str2, context, gVar, i10), new k(str2)));
            }
        }
        return null;
    }
}
