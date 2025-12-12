package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class RemoteCreator<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f7564a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7565b;

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    @KeepForSdk
    public RemoteCreator(String str) {
        this.f7564a = str;
    }

    @KeepForSdk
    public abstract T getRemoteCreator(IBinder iBinder);

    @KeepForSdk
    public final T getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        if (this.f7565b == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.f7565b = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.f7564a).newInstance());
            } catch (ClassNotFoundException e10) {
                throw new RemoteCreatorException("Could not load creator class.", e10);
            } catch (IllegalAccessException e11) {
                throw new RemoteCreatorException("Could not access creator.", e11);
            } catch (InstantiationException e12) {
                throw new RemoteCreatorException("Could not instantiate creator.", e12);
            }
        }
        return (T) this.f7565b;
    }
}
