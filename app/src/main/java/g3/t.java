package g3;

import android.content.Context;
import android.os.PowerManager;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: WakeLocks.kt */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12666a;

    static {
        String strTagWithPrefix = w2.g.tagWithPrefix("WakeLocks");
        zf.i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"WakeLocks\")");
        f12666a = strTagWithPrefix;
    }

    public static final void checkWakeLocks() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        u uVar = u.f12667a;
        synchronized (uVar) {
            linkedHashMap.putAll(uVar.getWakeLocks());
            lf.h hVar = lf.h.f16056a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            boolean z10 = false;
            if (wakeLock != null && wakeLock.isHeld()) {
                z10 = true;
            }
            if (z10) {
                w2.g.get().warning(f12666a, "WakeLock held for " + str);
            }
        }
    }

    public static final PowerManager.WakeLock newWakeLock(Context context, String str) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        zf.i.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String strJ = ac.c.j("WorkManager: ", str);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, strJ);
        u uVar = u.f12667a;
        synchronized (uVar) {
            uVar.getWakeLocks().put(wakeLockNewWakeLock, strJ);
        }
        zf.i.checkNotNullExpressionValue(wakeLockNewWakeLock, "wakeLock");
        return wakeLockNewWakeLock;
    }
}
