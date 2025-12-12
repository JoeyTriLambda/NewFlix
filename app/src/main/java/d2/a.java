package d2;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* compiled from: AdServicesInfo.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10789a = new a();

    /* compiled from: AdServicesInfo.kt */
    /* renamed from: d2.a$a, reason: collision with other inner class name */
    public static final class C0124a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0124a f10790a = new C0124a();

        public final int getAdServicesVersion() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int version() {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0124a.f10790a.getAdServicesVersion();
        }
        return 0;
    }
}
