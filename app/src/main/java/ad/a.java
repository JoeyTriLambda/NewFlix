package ad;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DeviceUtil.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedList f618a;

    /* compiled from: DeviceUtil.java */
    /* renamed from: ad.a$a, reason: collision with other inner class name */
    public static class C0008a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f619a = true;

        /* renamed from: b, reason: collision with root package name */
        public final String f620b;

        public C0008a(String str) {
            this.f620b = str;
        }

        public String getManufacturer() {
            return this.f620b;
        }

        public String getModel() {
            return null;
        }

        public boolean ignoreModel() {
            return this.f619a;
        }
    }

    static {
        LinkedList linkedList = new LinkedList();
        f618a = linkedList;
        linkedList.add(new C0008a("Amazon"));
    }

    public boolean isDeviceTV(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public boolean isNotCompatible(List<C0008a> list) {
        for (C0008a c0008a : list) {
            if (Build.MANUFACTURER.equalsIgnoreCase(c0008a.getManufacturer()) && (c0008a.ignoreModel() || Build.DEVICE.equalsIgnoreCase(c0008a.getModel()))) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsExoPlayer(Context context) {
        if (!isNotCompatible(f618a)) {
            return true;
        }
        if (!Build.MANUFACTURER.equalsIgnoreCase("Amazon")) {
            return false;
        }
        isDeviceTV(context);
        return true;
    }
}
