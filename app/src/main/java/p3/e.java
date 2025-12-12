package p3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import z3.t;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f17443a = new HashMap();

    /* compiled from: LottieCompositionFactory.java */
    public class a implements h<p3.d> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17444a;

        public a(String str) {
            this.f17444a = str;
        }

        @Override // p3.h
        public void onResult(p3.d dVar) {
            e.f17443a.remove(this.f17444a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class b implements h<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17445a;

        public b(String str) {
            this.f17445a = str;
        }

        @Override // p3.h
        public void onResult(Throwable th2) {
            e.f17443a.remove(this.f17445a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class c implements Callable<l<p3.d>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f17446b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f17447m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f17448n;

        public c(Context context, String str, String str2) {
            this.f17446b = context;
            this.f17447m = str;
            this.f17448n = str2;
        }

        @Override // java.util.concurrent.Callable
        public l<p3.d> call() {
            return y3.b.fetchSync(this.f17446b, this.f17447m, this.f17448n);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class d implements Callable<l<p3.d>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f17449b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f17450m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f17451n;

        public d(Context context, String str, String str2) {
            this.f17449b = context;
            this.f17450m = str;
            this.f17451n = str2;
        }

        @Override // java.util.concurrent.Callable
        public l<p3.d> call() {
            return e.fromAssetSync(this.f17449b, this.f17450m, this.f17451n);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: p3.e$e, reason: collision with other inner class name */
    public class CallableC0220e implements Callable<l<p3.d>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f17452b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Context f17453m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f17454n;

        public CallableC0220e(WeakReference weakReference, Context context, int i10) {
            this.f17452b = weakReference;
            this.f17453m = context;
            this.f17454n = i10;
        }

        @Override // java.util.concurrent.Callable
        public l<p3.d> call() {
            Context context = (Context) this.f17452b.get();
            if (context == null) {
                context = this.f17453m;
            }
            return e.fromRawResSync(context, this.f17454n);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class f implements Callable<l<p3.d>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputStream f17455b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f17456m;

        public f(InputStream inputStream, String str) {
            this.f17455b = inputStream;
            this.f17456m = str;
        }

        @Override // java.util.concurrent.Callable
        public l<p3.d> call() {
            return e.fromJsonInputStreamSync(this.f17455b, this.f17456m);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class g implements Callable<l<p3.d>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p3.d f17457b;

        public g(p3.d dVar) {
            this.f17457b = dVar;
        }

        @Override // java.util.concurrent.Callable
        public l<p3.d> call() {
            return new l<>(this.f17457b);
        }
    }

    public static n<p3.d> a(String str, Callable<l<p3.d>> callable) {
        p3.d dVar = str == null ? null : u3.f.getInstance().get(str);
        if (dVar != null) {
            return new n<>(new g(dVar));
        }
        HashMap map = f17443a;
        if (str != null && map.containsKey(str)) {
            return (n) map.get(str);
        }
        n<p3.d> nVar = new n<>(callable);
        if (str != null) {
            nVar.addListener(new a(str));
            nVar.addFailureListener(new b(str));
            map.put(str, nVar);
        }
        return nVar;
    }

    public static l<p3.d> b(JsonReader jsonReader, String str, boolean z10) throws IOException {
        try {
            try {
                p3.d dVar = t.parse(jsonReader);
                if (str != null) {
                    u3.f.getInstance().put(str, dVar);
                }
                l<p3.d> lVar = new l<>(dVar);
                if (z10) {
                    a4.h.closeQuietly(jsonReader);
                }
                return lVar;
            } catch (Exception e10) {
                l<p3.d> lVar2 = new l<>(e10);
                if (z10) {
                    a4.h.closeQuietly(jsonReader);
                }
                return lVar2;
            }
        } catch (Throwable th2) {
            if (z10) {
                a4.h.closeQuietly(jsonReader);
            }
            throw th2;
        }
    }

    public static l<p3.d> c(ZipInputStream zipInputStream, String str) throws IOException {
        p3.g next;
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            p3.d value = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    value = b(JsonReader.of(ah.m.buffer(ah.m.source(zipInputStream))), null, false).getValue();
                } else if (name.contains(".png") || name.contains(".webp")) {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (value == null) {
                return new l<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<p3.g> it = value.getImages().values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.getFileName().equals(str2)) {
                        break;
                    }
                }
                if (next != null) {
                    next.setBitmap(a4.h.resizeBitmapIfNeeded((Bitmap) entry.getValue(), next.getWidth(), next.getHeight()));
                }
            }
            for (Map.Entry<String, p3.g> entry2 : value.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new l<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            if (str != null) {
                u3.f.getInstance().put(str, value);
            }
            return new l<>(value);
        } catch (IOException e10) {
            return new l<>((Throwable) e10);
        }
    }

    public static String d(Context context, int i10) {
        StringBuilder sb2 = new StringBuilder("rawRes");
        sb2.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sb2.append(i10);
        return sb2.toString();
    }

    public static n<p3.d> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static l<p3.d> fromAssetSync(Context context, String str, String str2) {
        try {
            return str.endsWith(".zip") ? fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2) : fromJsonInputStreamSync(context.getAssets().open(str), str2);
        } catch (IOException e10) {
            return new l<>((Throwable) e10);
        }
    }

    public static n<p3.d> fromJsonInputStream(InputStream inputStream, String str) {
        return a(str, new f(inputStream, str));
    }

    public static l<p3.d> fromJsonInputStreamSync(InputStream inputStream, String str) throws IOException {
        try {
            return fromJsonReaderSync(JsonReader.of(ah.m.buffer(ah.m.source(inputStream))), str);
        } finally {
            a4.h.closeQuietly(inputStream);
        }
    }

    public static l<p3.d> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return b(jsonReader, str, true);
    }

    public static n<p3.d> fromRawRes(Context context, int i10) {
        return fromRawRes(context, i10, d(context, i10));
    }

    public static l<p3.d> fromRawResSync(Context context, int i10) {
        return fromRawResSync(context, i10, d(context, i10));
    }

    public static n<p3.d> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static l<p3.d> fromZipStreamSync(ZipInputStream zipInputStream, String str) throws IOException {
        try {
            return c(zipInputStream, str);
        } finally {
            a4.h.closeQuietly(zipInputStream);
        }
    }

    public static n<p3.d> fromRawRes(Context context, int i10, String str) {
        return a(str, new CallableC0220e(new WeakReference(context), context.getApplicationContext(), i10));
    }

    public static l<p3.d> fromRawResSync(Context context, int i10, String str) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i10), str);
        } catch (Resources.NotFoundException e10) {
            return new l<>((Throwable) e10);
        }
    }

    public static n<p3.d> fromUrl(Context context, String str, String str2) {
        return a(str2, new c(context, str, str2));
    }

    public static n<p3.d> fromAsset(Context context, String str, String str2) {
        return a(str2, new d(context.getApplicationContext(), str, str2));
    }
}
