package o3;

import android.content.Context;
import android.graphics.Typeface;
import b0.k;

/* compiled from: TypefaceHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final k<String, Typeface> f16994a = new k<>();

    public static Typeface get(Context context, String str) {
        k<String, Typeface> kVar = f16994a;
        synchronized (kVar) {
            if (kVar.containsKey(str)) {
                return kVar.get(str);
            }
            try {
                Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", str));
                kVar.put(str, typefaceCreateFromAsset);
                return typefaceCreateFromAsset;
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }
}
