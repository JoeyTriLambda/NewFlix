package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class Cast {

    /* renamed from: a, reason: collision with root package name */
    public static final Api<CastOptions> f6137a = new Api<>("Cast.API", new zze(), com.google.android.gms.cast.internal.zzak.f6816a);

    /* renamed from: b, reason: collision with root package name */
    public static final zzm f6138b = new zzm();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface CastApi {
        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static final class CastOptions implements Api.ApiOptions.HasOptions {

        /* renamed from: b, reason: collision with root package name */
        public final CastDevice f6139b;

        /* renamed from: m, reason: collision with root package name */
        public final Listener f6140m;

        /* renamed from: n, reason: collision with root package name */
        public final Bundle f6141n;

        /* renamed from: o, reason: collision with root package name */
        public final String f6142o = UUID.randomUUID().toString();

        /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public final CastDevice f6143a;

            /* renamed from: b, reason: collision with root package name */
            public final Listener f6144b;

            /* renamed from: c, reason: collision with root package name */
            public Bundle f6145c;

            public Builder(CastDevice castDevice, Listener listener) {
                Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
                Preconditions.checkNotNull(listener, "CastListener parameter cannot be null");
                this.f6143a = castDevice;
                this.f6144b = listener;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public final Builder zzc(Bundle bundle) {
                this.f6145c = bundle;
                return this;
            }
        }

        public /* synthetic */ CastOptions(Builder builder) {
            this.f6139b = builder.f6143a;
            this.f6140m = builder.f6144b;
            this.f6141n = builder.f6145c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CastOptions)) {
                return false;
            }
            CastOptions castOptions = (CastOptions) obj;
            return Objects.equal(this.f6139b, castOptions.f6139b) && Objects.checkBundlesEquality(this.f6141n, castOptions.f6141n) && Objects.equal(this.f6142o, castOptions.f6142o);
        }

        public int hashCode() {
            return Objects.hashCode(this.f6139b, this.f6141n, 0, this.f6142o);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private Cast() {
    }

    @ShowFirstParty
    public static zzr zza(Context context, CastOptions castOptions) {
        return new zzbt(context, castOptions);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Listener {
        public void onApplicationStatusChanged() {
        }

        public void onDeviceNameChanged() {
        }

        public void onVolumeChanged() {
        }

        public void onActiveInputStateChanged(int i10) {
        }

        public void onApplicationDisconnected(int i10) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onStandbyStateChanged(int i10) {
        }
    }
}
