package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public final class ListenerHolder<L> {

    /* renamed from: a, reason: collision with root package name */
    public volatile L f7103a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ListenerKey<L> f7104b;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static final class ListenerKey<L> {

        /* renamed from: a, reason: collision with root package name */
        public final L f7105a;

        /* renamed from: b, reason: collision with root package name */
        public final String f7106b;

        @KeepForSdk
        public ListenerKey(L l10, String str) {
            this.f7105a = l10;
            this.f7106b = str;
        }

        @KeepForSdk
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.f7105a == listenerKey.f7105a && this.f7106b.equals(listenerKey.f7106b);
        }

        @KeepForSdk
        public int hashCode() {
            return this.f7106b.hashCode() + (System.identityHashCode(this.f7105a) * 31);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public interface Notifier<L> {
    }

    @KeepForSdk
    public ListenerHolder(Object obj, Looper looper, String str) {
        new HandlerExecutor(looper);
        this.f7103a = (L) Preconditions.checkNotNull(obj, "Listener must not be null");
        this.f7104b = new ListenerKey<>(obj, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public void clear() {
        this.f7103a = null;
        this.f7104b = null;
    }

    @KeepForSdk
    public ListenerKey<L> getListenerKey() {
        return this.f7104b;
    }
}
