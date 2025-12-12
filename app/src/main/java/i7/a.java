package i7;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: ContextUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
