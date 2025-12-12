package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: ProfileInstaller.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3850a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final b f3851b = new b();

    /* compiled from: ProfileInstaller.java */
    public class b implements InterfaceC0037c {
        @Override // androidx.profileinstaller.c.InterfaceC0037c
        public void onDiagnosticReceived(int i10, Object obj) {
            Log.d("ProfileInstaller", i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.c.InterfaceC0037c
        public void onResultReceived(int i10, Object obj) {
            String str;
            switch (i10) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i10 == 6 || i10 == 7 || i10 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* compiled from: ProfileInstaller.java */
    /* renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    public interface InterfaceC0037c {
        void onDiagnosticReceived(int i10, Object obj);

        void onResultReceived(int i10, Object obj);
    }

    public static void a(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r16, java.util.concurrent.Executor r17, androidx.profileinstaller.c.InterfaceC0037c r18, boolean r19) throws android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.c.b(android.content.Context, java.util.concurrent.Executor, androidx.profileinstaller.c$c, boolean):void");
    }

    public static void writeProfile(Context context) throws PackageManager.NameNotFoundException, IOException {
        writeProfile(context, new y.a(11), f3850a);
    }

    public static void writeProfile(Context context, Executor executor, InterfaceC0037c interfaceC0037c) throws PackageManager.NameNotFoundException, IOException {
        b(context, executor, interfaceC0037c, false);
    }

    /* compiled from: ProfileInstaller.java */
    public class a implements InterfaceC0037c {
        @Override // androidx.profileinstaller.c.InterfaceC0037c
        public void onDiagnosticReceived(int i10, Object obj) {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0037c
        public void onResultReceived(int i10, Object obj) {
        }
    }
}
