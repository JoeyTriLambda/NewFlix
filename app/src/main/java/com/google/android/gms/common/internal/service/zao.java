package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zao extends GoogleApi<TelemetryLoggingOptions> implements TelemetryLoggingClient {

    /* renamed from: j, reason: collision with root package name */
    public static final Api<TelemetryLoggingOptions> f7371j = new Api<>("ClientTelemetry.API", new zan(), new Api.ClientKey());

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, f7371j, telemetryLoggingOptions, GoogleApi.Settings.f7061c);
    }

    @Override // com.google.android.gms.common.internal.TelemetryLoggingClient
    public final Task<Void> log(final TelemetryData telemetryData) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(com.google.android.gms.internal.base.zad.zaa);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.internal.service.zam
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                Api<TelemetryLoggingOptions> api = zao.f7371j;
                ((zai) ((zap) obj).getService()).zae(telemetryData);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(builder.build());
    }
}
