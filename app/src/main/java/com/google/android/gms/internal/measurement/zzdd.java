package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public interface zzdd extends IInterface {
    void beginAdUnitExposure(String str, long j10) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j10) throws RemoteException;

    void endAdUnitExposure(String str, long j10) throws RemoteException;

    void generateEventId(zzdi zzdiVar) throws RemoteException;

    void getAppInstanceId(zzdi zzdiVar) throws RemoteException;

    void getCachedAppInstanceId(zzdi zzdiVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzdi zzdiVar) throws RemoteException;

    void getCurrentScreenClass(zzdi zzdiVar) throws RemoteException;

    void getCurrentScreenName(zzdi zzdiVar) throws RemoteException;

    void getGmpAppId(zzdi zzdiVar) throws RemoteException;

    void getMaxUserProperties(String str, zzdi zzdiVar) throws RemoteException;

    void getSessionId(zzdi zzdiVar) throws RemoteException;

    void getTestFlag(zzdi zzdiVar, int i10) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z10, zzdi zzdiVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzdq zzdqVar, long j10) throws RemoteException;

    void isDataCollectionEnabled(zzdi zzdiVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzdi zzdiVar, long j10) throws RemoteException;

    void logHealthData(int i10, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j10) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdi zzdiVar, long j10) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void performAction(Bundle bundle, zzdi zzdiVar, long j10) throws RemoteException;

    void registerOnMeasurementEventListener(zzdj zzdjVar) throws RemoteException;

    void resetAnalyticsData(long j10) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j10) throws RemoteException;

    void setConsent(Bundle bundle, long j10) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j10) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j10) throws RemoteException;

    void setDataCollectionEnabled(boolean z10) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzdj zzdjVar) throws RemoteException;

    void setInstanceIdProvider(zzdo zzdoVar) throws RemoteException;

    void setMeasurementEnabled(boolean z10, long j10) throws RemoteException;

    void setMinimumSessionDuration(long j10) throws RemoteException;

    void setSessionTimeoutDuration(long j10) throws RemoteException;

    void setSgtmDebugInfo(Intent intent) throws RemoteException;

    void setUserId(String str, long j10) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z10, long j10) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzdj zzdjVar) throws RemoteException;
}
