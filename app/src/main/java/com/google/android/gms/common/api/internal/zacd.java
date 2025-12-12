package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zacd<T> implements OnCompleteListener<T> {

    /* renamed from: a, reason: collision with root package name */
    public final GoogleApiManager f7210a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7211b;

    /* renamed from: c, reason: collision with root package name */
    public final ApiKey<?> f7212c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7213d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7214e;

    @VisibleForTesting
    public zacd(GoogleApiManager googleApiManager, int i10, ApiKey apiKey, long j10, long j11) {
        this.f7210a = googleApiManager;
        this.f7211b = i10;
        this.f7212c = apiKey;
        this.f7213d = j10;
        this.f7214e = j11;
    }

    public static ConnectionTelemetryConfiguration a(zabq<?> zabqVar, BaseGmsClient<?> baseGmsClient, int i10) {
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled()) {
            return null;
        }
        int[] methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist();
        if (methodInvocationMethodKeyAllowlist == null) {
            int[] methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist();
            if (methodInvocationMethodKeyDisallowlist != null && ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i10)) {
                return null;
            }
        } else if (!ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i10)) {
            return null;
        }
        if (zabqVar.f7195l < telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return telemetryConfiguration;
        }
        return null;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<T> task) {
        zabq zabqVar;
        int version;
        int i10;
        int i11;
        int i12;
        int errorCode;
        int i13;
        long j10;
        long j11;
        int iElapsedRealtime;
        GoogleApiManager googleApiManager = this.f7210a;
        if (googleApiManager.a()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zabqVar = (zabq) googleApiManager.f7097u.get(this.f7212c)) != null && (zabqVar.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVar.zaf();
                long j12 = this.f7213d;
                boolean methodTimingTelemetryEnabled = j12 > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    methodTimingTelemetryEnabled &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    version = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationA = a(zabqVar, baseGmsClient, this.f7211b);
                        if (connectionTelemetryConfigurationA == null) {
                            return;
                        }
                        boolean z10 = connectionTelemetryConfigurationA.getMethodTimingTelemetryEnabled() && j12 > 0;
                        maxMethodInvocationsInBatch = connectionTelemetryConfigurationA.getMaxMethodInvocationsLogged();
                        methodTimingTelemetryEnabled = z10;
                    }
                    i10 = batchPeriodMillis;
                    i11 = maxMethodInvocationsInBatch;
                } else {
                    version = 0;
                    i10 = 5000;
                    i11 = 100;
                }
                if (task.isSuccessful()) {
                    i13 = 0;
                    errorCode = 0;
                } else {
                    if (task.isCanceled()) {
                        i12 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            int statusCode = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            errorCode = connectionResult == null ? -1 : connectionResult.getErrorCode();
                            i13 = statusCode;
                        } else {
                            i12 = 101;
                        }
                    }
                    i13 = i12;
                    errorCode = -1;
                }
                if (methodTimingTelemetryEnabled) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f7214e);
                    j10 = j12;
                    j11 = jCurrentTimeMillis;
                } else {
                    j10 = 0;
                    j11 = 0;
                    iElapsedRealtime = -1;
                }
                com.google.android.gms.internal.base.zaq zaqVar = googleApiManager.f7101y;
                zaqVar.sendMessage(zaqVar.obtainMessage(18, new zace(new MethodInvocation(this.f7211b, i13, errorCode, j10, j11, null, null, gCoreServiceId, iElapsedRealtime), version, i10, i11)));
            }
        }
    }
}
