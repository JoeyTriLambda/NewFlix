package be;

import android.content.Context;

/* compiled from: Common.java */
/* loaded from: classes2.dex */
public final class b {
    public static int getHeightInPercent(Context context, int i10) {
        return (context.getResources().getDisplayMetrics().heightPixels * i10) / 100;
    }

    public static int getWidthInPercent(Context context, int i10) {
        return (context.getResources().getDisplayMetrics().widthPixels * i10) / 100;
    }
}
