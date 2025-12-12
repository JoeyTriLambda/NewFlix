package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {

    /* renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public final RegisterListenerMethod<A, L> f7111a;

    /* renamed from: b, reason: collision with root package name */
    public final UnregisterListenerMethod<A, L> f7112b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f7113c;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {

        /* renamed from: a, reason: collision with root package name */
        public RemoteCall<A, TaskCompletionSource<Void>> f7114a;

        /* renamed from: b, reason: collision with root package name */
        public RemoteCall<A, TaskCompletionSource<Boolean>> f7115b;

        /* renamed from: d, reason: collision with root package name */
        public ListenerHolder<L> f7117d;

        /* renamed from: e, reason: collision with root package name */
        public Feature[] f7118e;

        /* renamed from: g, reason: collision with root package name */
        public int f7120g;

        /* renamed from: c, reason: collision with root package name */
        public final zacj f7116c = zacj.f7228b;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f7119f = true;

        private Builder() {
        }

        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            Preconditions.checkArgument(this.f7114a != null, "Must set register function");
            Preconditions.checkArgument(this.f7115b != null, "Must set unregister function");
            Preconditions.checkArgument(this.f7117d != null, "Must set holder");
            return new RegistrationMethods<>(new zack(this, this.f7117d, this.f7118e, this.f7119f, this.f7120g), new zacl(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.f7117d.getListenerKey(), "Key must not be null")), this.f7116c);
        }

        @KeepForSdk
        public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.f7114a = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setFeatures(Feature... featureArr) {
            this.f7118e = featureArr;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> setMethodKey(int i10) {
            this.f7120g = i10;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.f7115b = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
            this.f7117d = listenerHolder;
            return this;
        }

        public /* synthetic */ Builder(int i10) {
        }
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        this.f7111a = registerListenerMethod;
        this.f7112b = unregisterListenerMethod;
        this.f7113c = runnable;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>(0);
    }
}
