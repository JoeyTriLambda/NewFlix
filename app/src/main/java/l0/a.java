package l0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public final class a extends m0.a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f15632a = 0;

    /* compiled from: ActivityCompat.java */
    /* renamed from: l0.a$a, reason: collision with other inner class name */
    public class RunnableC0184a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f15633b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Activity f15634m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f15635n;

        public RunnableC0184a(Activity activity, String[] strArr, int i10) {
            this.f15633b = strArr;
            this.f15634m = activity;
            this.f15635n = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            String[] strArr = this.f15633b;
            int[] iArr = new int[strArr.length];
            Activity activity = this.f15634m;
            PackageManager packageManager = activity.getPackageManager();
            String packageName = activity.getPackageName();
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(strArr[i10], packageName);
            }
            ((e) activity).onRequestPermissionsResult(this.f15635n, strArr, iArr);
        }
    }

    /* compiled from: ActivityCompat.java */
    public static class b {
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void b(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }

        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* compiled from: ActivityCompat.java */
    public static class c {
        public static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* compiled from: ActivityCompat.java */
    public static class d {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* compiled from: ActivityCompat.java */
    public interface e {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    public interface f {
        void validateRequestPermissionsRequestCode(int i10);
    }

    public static void finishAffinity(Activity activity) {
        activity.finishAffinity();
    }

    public static void recreate(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new androidx.activity.d(activity, 4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity activity, String[] strArr, int i10) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (TextUtils.isEmpty(strArr[i11])) {
                throw new IllegalArgumentException(ac.c.o(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i11], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i11));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < strArr.length; i13++) {
                if (!hashSet.contains(Integer.valueOf(i13))) {
                    strArr2[i12] = strArr[i13];
                    i12++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof f) {
                ((f) activity).validateRequestPermissionsRequestCode(i10);
            }
            b.b(activity, strArr, i10);
        } else if (activity instanceof e) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0184a(activity, strArr2, i10));
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i10 >= 32) {
            return d.a(activity, str);
        }
        if (i10 == 31) {
            return c.b(activity, str);
        }
        if (i10 >= 23) {
            return b.c(activity, str);
        }
        return false;
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i10, Bundle bundle) {
        activity.startActivityForResult(intent, i10, bundle);
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }
}
