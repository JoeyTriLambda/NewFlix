package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f7568c;

    /* renamed from: d, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f7569d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f7570e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f7571f = null;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f7572g = false;

    /* renamed from: h, reason: collision with root package name */
    public static int f7573h = -1;

    /* renamed from: i, reason: collision with root package name */
    public static Boolean f7574i;

    /* renamed from: m, reason: collision with root package name */
    public static zzq f7578m;

    /* renamed from: n, reason: collision with root package name */
    public static zzr f7579n;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7580a;

    /* renamed from: j, reason: collision with root package name */
    public static final ThreadLocal f7575j = new ThreadLocal();

    /* renamed from: k, reason: collision with root package name */
    public static final ThreadLocal f7576k = new zzd();

    /* renamed from: l, reason: collision with root package name */
    public static final VersionPolicy.IVersions f7577l = new zze();

    /* renamed from: b, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f7567b = new zzf();

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    @KeepForSdk
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
        @KeepForSdk
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z10) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
        @KeepForSdk
        public static class SelectionResult {

            /* renamed from: a, reason: collision with root package name */
            @KeepForSdk
            public int f7581a = 0;

            /* renamed from: b, reason: collision with root package name */
            @KeepForSdk
            public int f7582b = 0;

            /* renamed from: c, reason: collision with root package name */
            @KeepForSdk
            public int f7583c = 0;
        }

        @KeepForSdk
        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    static {
        new zzg();
        new zzh();
        f7568c = new zzi();
        f7569d = new zzj();
        new zzk();
        new zzl();
    }

    public DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.f7580a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00d4 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:45:0x00a6, B:46:0x00ad, B:62:0x00cf, B:64:0x00d4, B:65:0x00d5, B:66:0x00ef), top: B:72:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:45:0x00a6, B:46:0x00ad, B:62:0x00cf, B:64:0x00d4, B:65:0x00d5, B:66:0x00ef), top: B:72:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r8, java.lang.String r9, boolean r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void b(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            f7579n = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to instantiate dynamite loader", e10);
        }
    }

    public static boolean c(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f7574i)) {
            return true;
        }
        boolean zBooleanValue = false;
        if (f7574i == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                zBooleanValue = true;
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            f7574i = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
            if (zBooleanValue && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f7572g = true;
            }
        }
        if (!zBooleanValue) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return zBooleanValue;
    }

    public static zzq d(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = f7578m;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    f7578m = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e A[Catch: all -> 0x0270, TRY_LEAVE, TryCatch #1 {all -> 0x0270, blocks: (B:7:0x0052, B:11:0x0080, B:16:0x0088, B:19:0x008e, B:22:0x00a6, B:96:0x01f7, B:97:0x0201, B:99:0x0203, B:101:0x0205, B:102:0x020c, B:104:0x020e, B:106:0x022c, B:108:0x023a), top: B:140:0x0052, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r21, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0175 A[Catch: all -> 0x01ce, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ce, blocks: (B:3:0x0002, B:60:0x00d9, B:62:0x00df, B:67:0x0100, B:97:0x0167, B:101:0x0175, B:120:0x01c7, B:121:0x01ca, B:116:0x01bf, B:65:0x00e5, B:124:0x01cd, B:4:0x0003, B:7:0x000a, B:8:0x0026, B:58:0x00d6, B:19:0x0047, B:40:0x0098, B:43:0x009b, B:51:0x00b4, B:59:0x00d8, B:57:0x00ba), top: B:137:0x0002, inners: #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7 A[Catch: all -> 0x00b2, TryCatch #6 {, blocks: (B:9:0x0027, B:11:0x0033, B:47:0x00b0, B:14:0x0039, B:16:0x0040, B:18:0x0046, B:21:0x0049, B:23:0x004d, B:26:0x0056, B:28:0x005e, B:31:0x0065, B:38:0x008f, B:39:0x0097, B:34:0x006c, B:36:0x0072, B:37:0x0081, B:42:0x009a, B:45:0x009d, B:46:0x00a7, B:15:0x003c), top: B:138:0x0027, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0167 A[Catch: all -> 0x01ce, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ce, blocks: (B:3:0x0002, B:60:0x00d9, B:62:0x00df, B:67:0x0100, B:97:0x0167, B:101:0x0175, B:120:0x01c7, B:121:0x01ca, B:116:0x01bf, B:65:0x00e5, B:124:0x01cd, B:4:0x0003, B:7:0x000a, B:8:0x0026, B:58:0x00d6, B:19:0x0047, B:40:0x0098, B:43:0x009b, B:51:0x00b4, B:59:0x00d8, B:57:0x00ba), top: B:137:0x0002, inners: #3, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.content.Context r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public Context getModuleContext() {
        return this.f7580a;
    }

    @KeepForSdk
    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.f7580a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10);
        }
    }
}
