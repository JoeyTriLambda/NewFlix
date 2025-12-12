package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    public final Feature[] f7121a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7122b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7123c;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT> {

        /* renamed from: a, reason: collision with root package name */
        public RemoteCall<A, TaskCompletionSource<ResultT>> f7124a;

        /* renamed from: c, reason: collision with root package name */
        public Feature[] f7126c;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7125b = true;

        /* renamed from: d, reason: collision with root package name */
        public int f7127d = 0;

        private Builder() {
        }

        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            Preconditions.checkArgument(this.f7124a != null, "execute parameter required");
            return new zacv(this, this.f7126c, this.f7125b, this.f7127d);
        }

        @KeepForSdk
        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.f7124a = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z10) {
            this.f7125b = z10;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.f7126c = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setMethodKey(int i10) {
            this.f7127d = i10;
            return this;
        }

        public /* synthetic */ Builder(int i10) {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f7121a = null;
        this.f7122b = false;
        this.f7123c = 0;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(0);
    }

    @KeepForSdk
    public abstract void doExecute(A a10, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.f7122b;
    }

    public final int zaa() {
        return this.f7123c;
    }

    public final Feature[] zab() {
        return this.f7121a;
    }

    @KeepForSdk
    public TaskApiCall(Feature[] featureArr, boolean z10, int i10) {
        this.f7121a = featureArr;
        boolean z11 = false;
        if (featureArr != null && z10) {
            z11 = true;
        }
        this.f7122b = z11;
        this.f7123c = i10;
    }
}
