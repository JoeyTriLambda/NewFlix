package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* compiled from: TooltipCompat.java */
/* loaded from: classes.dex */
public final class f1 {

    /* compiled from: TooltipCompat.java */
    public static class a {
        public static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            h1.setTooltipText(view, charSequence);
        }
    }
}
