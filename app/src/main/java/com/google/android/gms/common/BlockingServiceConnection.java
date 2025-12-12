package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7012a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f7013b = new LinkedBlockingQueue();

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public IBinder getServiceWithTimeout(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f7012a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f7012a = true;
        IBinder iBinder = (IBinder) this.f7013b.poll(j10, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7013b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
