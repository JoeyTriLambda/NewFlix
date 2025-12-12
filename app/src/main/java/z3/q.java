package z3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    public static b0.l<WeakReference<Interpolator>> f22595b;

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f22594a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f22596c = JsonReader.a.of("t", "s", "e", "o", "i", "h", "to", "ti");

    public static <T> b4.a<T> a(JsonReader jsonReader, p3.d dVar, float f10, h0<T> h0Var, boolean z10) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t10;
        WeakReference<Interpolator> weakReference;
        Interpolator interpolatorCreate;
        if (!z10) {
            return new b4.a<>(h0Var.parse(jsonReader, f10));
        }
        jsonReader.beginObject();
        PointF pointFB = null;
        PointF pointFB2 = null;
        T t11 = null;
        T t12 = null;
        PointF pointFB3 = null;
        PointF pointFB4 = null;
        boolean z11 = false;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(f22596c)) {
                case 0:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t12 = h0Var.parse(jsonReader, f10);
                    break;
                case 2:
                    t11 = h0Var.parse(jsonReader, f10);
                    break;
                case 3:
                    pointFB = p.b(jsonReader, f10);
                    break;
                case 4:
                    pointFB2 = p.b(jsonReader, f10);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                case 6:
                    pointFB4 = p.b(jsonReader, f10);
                    break;
                case 7:
                    pointFB3 = p.b(jsonReader, f10);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z11) {
            interpolator2 = f22594a;
            t10 = t12;
        } else {
            if (pointFB == null || pointFB2 == null) {
                interpolator = f22594a;
            } else {
                float f11 = -f10;
                pointFB.x = a4.g.clamp(pointFB.x, f11, f10);
                pointFB.y = a4.g.clamp(pointFB.y, -100.0f, 100.0f);
                pointFB2.x = a4.g.clamp(pointFB2.x, f11, f10);
                float fClamp = a4.g.clamp(pointFB2.y, -100.0f, 100.0f);
                pointFB2.y = fClamp;
                int iHashFor = a4.h.hashFor(pointFB.x, pointFB.y, pointFB2.x, fClamp);
                synchronized (q.class) {
                    if (f22595b == null) {
                        f22595b = new b0.l<>();
                    }
                    weakReference = f22595b.get(iHashFor);
                }
                interpolator = weakReference != null ? weakReference.get() : null;
                if (weakReference == null || interpolator == null) {
                    pointFB.x /= f10;
                    pointFB.y /= f10;
                    float f12 = pointFB2.x / f10;
                    pointFB2.x = f12;
                    float f13 = pointFB2.y / f10;
                    pointFB2.y = f13;
                    try {
                        interpolatorCreate = z0.a.create(pointFB.x, pointFB.y, f12, f13);
                    } catch (IllegalArgumentException e10) {
                        interpolatorCreate = e10.getMessage().equals("The Path cannot loop back on itself.") ? z0.a.create(Math.min(pointFB.x, 1.0f), pointFB.y, Math.max(pointFB2.x, 0.0f), pointFB2.y) : new LinearInterpolator();
                    }
                    interpolator = interpolatorCreate;
                    try {
                        b(iHashFor, new WeakReference(interpolator));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            interpolator2 = interpolator;
            t10 = t11;
        }
        b4.a<T> aVar = new b4.a<>(dVar, t12, t10, interpolator2, fNextDouble, null);
        aVar.f4767m = pointFB4;
        aVar.f4768n = pointFB3;
        return aVar;
    }

    public static void b(int i10, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f22595b.put(i10, weakReference);
        }
    }
}
