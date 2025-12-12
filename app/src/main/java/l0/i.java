package l0;

import android.os.Bundle;
import android.os.IBinder;

/* compiled from: BundleCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class i {
    public static IBinder getBinder(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
