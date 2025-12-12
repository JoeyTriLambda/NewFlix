package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7052a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7053b;

    /* renamed from: c, reason: collision with root package name */
    public final Api<O> f7054c;

    /* renamed from: d, reason: collision with root package name */
    public final O f7055d;

    /* renamed from: e, reason: collision with root package name */
    public final ApiKey<O> f7056e;

    /* renamed from: f, reason: collision with root package name */
    public final Looper f7057f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7058g;

    /* renamed from: h, reason: collision with root package name */
    public final StatusExceptionMapper f7059h;

    /* renamed from: i, reason: collision with root package name */
    public final GoogleApiManager f7060i;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static class Settings {

        /* renamed from: c, reason: collision with root package name */
        @KeepForSdk
        public static final Settings f7061c = new Builder().build();

        /* renamed from: a, reason: collision with root package name */
        public final StatusExceptionMapper f7062a;

        /* renamed from: b, reason: collision with root package name */
        public final Looper f7063b;

        /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
        @KeepForSdk
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public ApiExceptionMapper f7064a;

            /* renamed from: b, reason: collision with root package name */
            public Looper f7065b;

            @KeepForSdk
            public Builder() {
            }

            @KeepForSdk
            public Settings build() {
                if (this.f7064a == null) {
                    this.f7064a = new ApiExceptionMapper();
                }
                if (this.f7065b == null) {
                    this.f7065b = Looper.getMainLooper();
                }
                return new Settings(this.f7064a, this.f7065b);
            }
        }

        public Settings(StatusExceptionMapper statusExceptionMapper, Looper looper) {
            this.f7062a = statusExceptionMapper;
            this.f7063b = looper;
        }
    }

    public GoogleApi() {
        throw null;
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o6, Settings settings) {
        String str;
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f7052a = context.getApplicationContext();
        if (PlatformVersion.isAtLeastR()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        } else {
            str = null;
        }
        this.f7053b = str;
        this.f7054c = api;
        this.f7055d = o6;
        this.f7057f = settings.f7063b;
        this.f7056e = ApiKey.zaa(api, o6, str);
        new zabv(this);
        GoogleApiManager googleApiManagerZam = GoogleApiManager.zam(this.f7052a);
        this.f7060i = googleApiManagerZam;
        this.f7058g = googleApiManagerZam.zaa();
        this.f7059h = settings.f7062a;
        googleApiManagerZam.zaB(this);
    }

    public final <TResult, A extends Api.AnyClient> Task<TResult> a(int i10, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7060i.zax(this, i10, taskApiCall, taskCompletionSource, this.f7059h);
        return taskCompletionSource.getTask();
    }

    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o6 = this.f7055d;
        builder.zab((!(o6 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o6).getGoogleSignInAccount()) == null) ? o6 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o6).getAccount() : null : googleSignInAccount2.getAccount());
        Set<Scope> setEmptySet = (!(o6 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o6).getGoogleSignInAccount()) == null) ? Collections.emptySet() : googleSignInAccount.getRequestedScopes();
        builder.zaa(setEmptySet);
        Context context = this.f7052a;
        builder.zac(context.getClass().getName());
        builder.setRealClientPackageName(context.getPackageName());
        return builder;
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return a(2, taskApiCall);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return a(0, taskApiCall);
    }

    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.f7111a.getListenerKey(), "Listener has already been released.");
        UnregisterListenerMethod<A, ?> unregisterListenerMethod = registrationMethods.f7112b;
        Preconditions.checkNotNull(unregisterListenerMethod.getListenerKey(), "Listener has already been released.");
        return this.f7060i.zaq(this, registrationMethods.f7111a, unregisterListenerMethod, registrationMethods.f7113c);
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int i10) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.f7060i.zar(this, listenerKey, i10);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t10) {
        t10.zak();
        this.f7060i.zaw(this, 1, t10);
        return t10;
    }

    public final ApiKey<O> getApiKey() {
        return this.f7056e;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.f7052a;
    }

    @KeepForSdk
    public String getContextAttributionTag() {
        return this.f7053b;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.f7057f;
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l10, String str) {
        return ListenerHolders.createListenerHolder(l10, this.f7057f, str);
    }

    public final int zaa() {
        return this.f7058g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Api.Client zab(Looper looper, zabq<O> zabqVar) {
        Api.Client clientBuildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.f7054c.zaa())).buildClient(this.f7052a, looper, createClientSettingsBuilder().build(), (ClientSettings) this.f7055d, (GoogleApiClient.ConnectionCallbacks) zabqVar, (GoogleApiClient.OnConnectionFailedListener) zabqVar);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (clientBuildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (clientBuildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) clientBuildClient).zac(contextAttributionTag);
        }
        return clientBuildClient;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().build());
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return a(1, taskApiCall);
    }
}
