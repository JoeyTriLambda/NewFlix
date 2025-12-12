package be;

import android.content.Context;

/* compiled from: FVToast.java */
/* loaded from: classes2.dex */
public final class d {
    public static void makeToast(Context context, String str, boolean z10) {
        try {
            ic.a.Success(context, str, null, z10 ? 48 : 80, 0);
        } catch (Exception unused) {
        }
    }

    public static void makeToastLong(Context context, String str, boolean z10) {
        try {
            ic.a.Success(context, str, null, z10 ? 48 : 80, 1);
        } catch (Exception unused) {
        }
    }
}
