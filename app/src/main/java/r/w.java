package r;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;

/* compiled from: AppLocalesMetadataHolderService.java */
/* loaded from: classes.dex */
public final class w extends Service {

    /* compiled from: AppLocalesMetadataHolderService.java */
    public static class a {
        public static int a() {
            return 512;
        }
    }

    public static ServiceInfo getServiceInfo(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) w.class), Build.VERSION.SDK_INT >= 24 ? a.a() | 128 : 640);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
