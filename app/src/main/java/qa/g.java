package qa;

import android.content.Context;
import android.content.SharedPreferences;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: PowerSpinnerPersistence.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile g f18047a;

    /* renamed from: b, reason: collision with root package name */
    public static SharedPreferences f18048b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f18049c = new a(null);

    /* compiled from: PowerSpinnerPersistence.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final g getInstance(Context context) {
            zf.i.checkNotNullParameter(context, "context");
            g gVar = g.f18047a;
            if (gVar == null) {
                synchronized (this) {
                    gVar = g.f18047a;
                    if (gVar == null) {
                        gVar = new g(null);
                        g.f18047a = gVar;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.skydoves.powerspinenr", 0);
                        zf.i.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
                        g.f18048b = sharedPreferences;
                    }
                }
            }
            return gVar;
        }
    }

    public g(zf.f fVar) {
    }

    public final int getSelectedIndex(String str) {
        zf.i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        SharedPreferences sharedPreferences = f18048b;
        if (sharedPreferences == null) {
            zf.i.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        return sharedPreferences.getInt("INDEX" + str, -1);
    }

    public final void persistSelectedIndex(String str, int i10) {
        zf.i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        SharedPreferences sharedPreferences = f18048b;
        if (sharedPreferences == null) {
            zf.i.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        sharedPreferences.edit().putInt("INDEX" + str, i10).apply();
    }
}
