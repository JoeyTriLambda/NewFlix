package ma;

import android.view.View;

/* compiled from: ViewHelper.java */
/* loaded from: classes.dex */
public final class a {
    public static void setAlpha(View view, float f10) {
        if (na.a.f16768y) {
            na.a.wrap(view).setAlpha(f10);
        } else {
            view.setAlpha(f10);
        }
    }

    public static void setTranslationX(View view, float f10) {
        if (na.a.f16768y) {
            na.a.wrap(view).setTranslationX(f10);
        } else {
            view.setTranslationX(f10);
        }
    }
}
