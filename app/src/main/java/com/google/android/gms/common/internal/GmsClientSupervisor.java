package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f7341a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static zzs f7342b;

    /* renamed from: c, reason: collision with root package name */
    public static HandlerThread f7343c;

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (f7341a) {
            if (f7342b == null) {
                f7342b = new zzs(context.getApplicationContext(), context.getMainLooper());
            }
        }
        return f7342b;
    }

    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (f7341a) {
            HandlerThread handlerThread = f7343c;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f7343c = handlerThread2;
            handlerThread2.start();
            return f7343c;
        }
    }

    public abstract void zza(zzo zzoVar, ServiceConnection serviceConnection, String str);

    public final void zzb(String str, String str2, int i10, ServiceConnection serviceConnection, String str3, boolean z10) {
        zza(new zzo(str, str2, 4225, z10), serviceConnection, str3);
    }

    public abstract boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor);
}
