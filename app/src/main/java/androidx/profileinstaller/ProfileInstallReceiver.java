package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.c;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    public class a implements c.InterfaceC0037c {
        public a() {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0037c
        public void onDiagnosticReceived(int i10, Object obj) {
            c.f3851b.onDiagnosticReceived(i10, obj);
        }

        @Override // androidx.profileinstaller.c.InterfaceC0037c
        public void onResultReceived(int i10, Object obj) {
            c.f3851b.onResultReceived(i10, obj);
            ProfileInstallReceiver.this.setResultCode(i10);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException, IOException {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            c.b(context, new y.a(8), new a(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        a aVar = new a();
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        new f2.a(11, aVar, 1, null).run();
                        return;
                    }
                    return;
                }
                y.a aVar2 = new y.a(9);
                a aVar3 = new a();
                try {
                    c.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    aVar2.execute(new f2.a(10, aVar3, 1, null));
                    return;
                } catch (PackageManager.NameNotFoundException e10) {
                    aVar2.execute(new f2.a(7, aVar3, 1, e10));
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            a aVar4 = new a();
            if (Build.VERSION.SDK_INT < 24) {
                aVar4.onResultReceived(13, null);
                return;
            } else {
                Process.sendSignal(Process.myPid(), 10);
                aVar4.onResultReceived(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        a aVar5 = new a();
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            aVar5.onResultReceived(16, null);
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (androidx.profileinstaller.a.a(i10 >= 24 ? context.createDeviceProtectedStorageContext().getCodeCacheDir() : i10 >= 23 ? context.getCodeCacheDir() : context.getCacheDir())) {
            aVar5.onResultReceived(14, null);
        } else {
            aVar5.onResultReceived(15, null);
        }
    }
}
