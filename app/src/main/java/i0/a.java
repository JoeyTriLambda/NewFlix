package i0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

/* compiled from: Debug.java */
@SuppressLint({"LogConditional"})
/* loaded from: classes.dex */
public final class a {
    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getName(Context context, int i10) {
        if (i10 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i10);
        } catch (Exception unused) {
            return ac.c.f("?", i10);
        }
    }
}
