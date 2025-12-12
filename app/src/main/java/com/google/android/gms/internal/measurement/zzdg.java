package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zzdg extends zzbx implements zzdd {
    public zzdg() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzdd asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof zzdd ? (zzdd) iInterfaceQueryLocalInterface : new zzdf(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzdi zzdkVar;
        zzdi zzdkVar2 = null;
        zzdi zzdkVar3 = null;
        zzdi zzdkVar4 = null;
        zzdi zzdkVar5 = null;
        zzdj zzdlVar = null;
        zzdj zzdlVar2 = null;
        zzdj zzdlVar3 = null;
        zzdi zzdkVar6 = null;
        zzdi zzdkVar7 = null;
        zzdi zzdkVar8 = null;
        zzdi zzdkVar9 = null;
        zzdi zzdkVar10 = null;
        zzdi zzdkVar11 = null;
        zzdo zzdnVar = null;
        zzdi zzdkVar12 = null;
        zzdi zzdkVar13 = null;
        zzdi zzdkVar14 = null;
        zzdi zzdkVar15 = null;
        switch (i10) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzdq zzdqVar = (zzdq) zzbw.zza(parcel, zzdq.CREATOR);
                long j10 = parcel.readLong();
                zzbw.zzb(parcel);
                initialize(iObjectWrapperAsInterface, zzdqVar, j10);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                boolean zZzc = zzbw.zzc(parcel);
                boolean zZzc2 = zzbw.zzc(parcel);
                long j11 = parcel.readLong();
                zzbw.zzb(parcel);
                logEvent(string, string2, bundle, zZzc, zZzc2, j11);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzdkVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar = iInterfaceQueryLocalInterface instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface : new zzdk(strongBinder);
                }
                long j12 = parcel.readLong();
                zzbw.zzb(parcel);
                logEventAndBundle(string3, string4, bundle2, zzdkVar, j12);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zZzc3 = zzbw.zzc(parcel);
                long j13 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserProperty(string5, string6, iObjectWrapperAsInterface2, zZzc3, j13);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZzc4 = zzbw.zzc(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar2 = iInterfaceQueryLocalInterface2 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface2 : new zzdk(strongBinder2);
                }
                zzbw.zzb(parcel);
                getUserProperties(string7, string8, zZzc4, zzdkVar2);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar15 = iInterfaceQueryLocalInterface3 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface3 : new zzdk(strongBinder3);
                }
                zzbw.zzb(parcel);
                getMaxUserProperties(string9, zzdkVar15);
                break;
            case 7:
                String string10 = parcel.readString();
                long j14 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserId(string10, j14);
                break;
            case 8:
                Bundle bundle3 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j15 = parcel.readLong();
                zzbw.zzb(parcel);
                setConditionalUserProperty(bundle3, j15);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar14 = iInterfaceQueryLocalInterface4 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface4 : new zzdk(strongBinder4);
                }
                zzbw.zzb(parcel);
                getConditionalUserProperties(string13, string14, zzdkVar14);
                break;
            case 11:
                boolean zZzc5 = zzbw.zzc(parcel);
                long j16 = parcel.readLong();
                zzbw.zzb(parcel);
                setMeasurementEnabled(zZzc5, j16);
                break;
            case 12:
                long j17 = parcel.readLong();
                zzbw.zzb(parcel);
                resetAnalyticsData(j17);
                break;
            case 13:
                long j18 = parcel.readLong();
                zzbw.zzb(parcel);
                setMinimumSessionDuration(j18);
                break;
            case 14:
                long j19 = parcel.readLong();
                zzbw.zzb(parcel);
                setSessionTimeoutDuration(j19);
                break;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j20 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreen(iObjectWrapperAsInterface3, string15, string16, j20);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar13 = iInterfaceQueryLocalInterface5 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface5 : new zzdk(strongBinder5);
                }
                zzbw.zzb(parcel);
                getCurrentScreenName(zzdkVar13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar12 = iInterfaceQueryLocalInterface6 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface6 : new zzdk(strongBinder6);
                }
                zzbw.zzb(parcel);
                getCurrentScreenClass(zzdkVar12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzdnVar = iInterfaceQueryLocalInterface7 instanceof zzdo ? (zzdo) iInterfaceQueryLocalInterface7 : new zzdn(strongBinder7);
                }
                zzbw.zzb(parcel);
                setInstanceIdProvider(zzdnVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar11 = iInterfaceQueryLocalInterface8 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface8 : new zzdk(strongBinder8);
                }
                zzbw.zzb(parcel);
                getCachedAppInstanceId(zzdkVar11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar10 = iInterfaceQueryLocalInterface9 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface9 : new zzdk(strongBinder9);
                }
                zzbw.zzb(parcel);
                getAppInstanceId(zzdkVar10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar9 = iInterfaceQueryLocalInterface10 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface10 : new zzdk(strongBinder10);
                }
                zzbw.zzb(parcel);
                getGmpAppId(zzdkVar9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar8 = iInterfaceQueryLocalInterface11 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface11 : new zzdk(strongBinder11);
                }
                zzbw.zzb(parcel);
                generateEventId(zzdkVar8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j21 = parcel.readLong();
                zzbw.zzb(parcel);
                beginAdUnitExposure(string17, j21);
                break;
            case 24:
                String string18 = parcel.readString();
                long j22 = parcel.readLong();
                zzbw.zzb(parcel);
                endAdUnitExposure(string18, j22);
                break;
            case 25:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j23 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStarted(iObjectWrapperAsInterface4, j23);
                break;
            case 26:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j24 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStopped(iObjectWrapperAsInterface5, j24);
                break;
            case 27:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j25 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreated(iObjectWrapperAsInterface6, bundle5, j25);
                break;
            case 28:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j26 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyed(iObjectWrapperAsInterface7, j26);
                break;
            case 29:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j27 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPaused(iObjectWrapperAsInterface8, j27);
                break;
            case 30:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j28 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumed(iObjectWrapperAsInterface9, j28);
                break;
            case 31:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar7 = iInterfaceQueryLocalInterface12 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface12 : new zzdk(strongBinder12);
                }
                long j29 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceState(iObjectWrapperAsInterface10, zzdkVar7, j29);
                break;
            case 32:
                Bundle bundle6 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar6 = iInterfaceQueryLocalInterface13 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface13 : new zzdk(strongBinder13);
                }
                long j30 = parcel.readLong();
                zzbw.zzb(parcel);
                performAction(bundle6, zzdkVar6, j30);
                break;
            case 33:
                int i12 = parcel.readInt();
                String string19 = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbw.zzb(parcel);
                logHealthData(i12, string19, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12, iObjectWrapperAsInterface13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdlVar3 = iInterfaceQueryLocalInterface14 instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface14 : new zzdl(strongBinder14);
                }
                zzbw.zzb(parcel);
                setEventInterceptor(zzdlVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdlVar2 = iInterfaceQueryLocalInterface15 instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface15 : new zzdl(strongBinder15);
                }
                zzbw.zzb(parcel);
                registerOnMeasurementEventListener(zzdlVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdlVar = iInterfaceQueryLocalInterface16 instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface16 : new zzdl(strongBinder16);
                }
                zzbw.zzb(parcel);
                unregisterOnMeasurementEventListener(zzdlVar);
                break;
            case 37:
                HashMap mapZza = zzbw.zza(parcel);
                zzbw.zzb(parcel);
                initForTests(mapZza);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar5 = iInterfaceQueryLocalInterface17 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface17 : new zzdk(strongBinder17);
                }
                int i13 = parcel.readInt();
                zzbw.zzb(parcel);
                getTestFlag(zzdkVar5, i13);
                break;
            case 39:
                boolean zZzc6 = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                setDataCollectionEnabled(zZzc6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar4 = iInterfaceQueryLocalInterface18 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface18 : new zzdk(strongBinder18);
                }
                zzbw.zzb(parcel);
                isDataCollectionEnabled(zzdkVar4);
                break;
            case 41:
            case 47:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j31 = parcel.readLong();
                zzbw.zzb(parcel);
                clearMeasurementEnabled(j31);
                break;
            case 44:
                Bundle bundle8 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j32 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsent(bundle8, j32);
                break;
            case 45:
                Bundle bundle9 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j33 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsentThirdParty(bundle9, j33);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdkVar3 = iInterfaceQueryLocalInterface19 instanceof zzdi ? (zzdi) iInterfaceQueryLocalInterface19 : new zzdk(strongBinder19);
                }
                zzbw.zzb(parcel);
                getSessionId(zzdkVar3);
                break;
            case 48:
                Intent intent = (Intent) zzbw.zza(parcel, Intent.CREATOR);
                zzbw.zzb(parcel);
                setSgtmDebugInfo(intent);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
