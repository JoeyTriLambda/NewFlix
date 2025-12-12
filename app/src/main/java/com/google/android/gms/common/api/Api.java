package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class Api<O extends ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractClientBuilder<?, O> f7045a;

    /* renamed from: b, reason: collision with root package name */
    public final ClientKey<?> f7046b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7047c;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @VisibleForTesting
    @KeepForSdk
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @KeepForSdk
        @Deprecated
        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o6, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return (T) buildClient(context, looper, clientSettings, (ClientSettings) o6, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        @KeepForSdk
        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o6, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public interface AnyClient {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    public interface ApiOptions {

        /* renamed from: g, reason: collision with root package name */
        public static final NoOptions f7048g = new NoOptions(0);

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        public interface HasOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }

            public /* synthetic */ NoOptions(int i10) {
            }
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @VisibleForTesting
    @KeepForSdk
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        @KeepForSdk
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public interface Client extends AnyClient {
        @KeepForSdk
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void disconnect(String str);

        @KeepForSdk
        Feature[] getAvailableFeatures();

        @KeepForSdk
        String getEndpointPackageName();

        @KeepForSdk
        String getLastDisconnectMessage();

        @KeepForSdk
        int getMinApkVersion();

        @KeepForSdk
        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        @KeepForSdk
        Set<Scope> getScopesForConnectionlessNonSignIn();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean requiresGooglePlayServices();

        @KeepForSdk
        boolean requiresSignIn();
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @VisibleForTesting
    @KeepForSdk
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @KeepForSdk
    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.f7047c = str;
        this.f7045a = abstractClientBuilder;
        this.f7046b = clientKey;
    }

    public final AbstractClientBuilder<?, O> zaa() {
        return this.f7045a;
    }

    public final AnyClientKey<?> zab() {
        return this.f7046b;
    }

    public final BaseClientBuilder<?, O> zac() {
        return this.f7045a;
    }

    public final String zad() {
        return this.f7047c;
    }
}
