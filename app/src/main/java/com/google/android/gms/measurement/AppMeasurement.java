package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zzin;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zzix;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@ShowFirstParty
@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {

    /* renamed from: b, reason: collision with root package name */
    public static volatile AppMeasurement f7604b;

    /* renamed from: a, reason: collision with root package name */
    public final zza f7605a;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    @ShowFirstParty
    @KeepForSdk
    public static class ConditionalUserProperty {

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public boolean mActive;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mAppId;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mOrigin;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mTriggerEventName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggeredTimestamp;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzin.zza(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzin.zza(bundle, "origin", String.class, null);
            this.mName = (String) zzin.zza(bundle, MediationMetaData.KEY_NAME, String.class, null);
            this.mValue = zzin.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzin.zza(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) zzin.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzin.zza(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) zzin.zza(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzin.zza(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) zzin.zza(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzin.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzin.zza(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) zzin.zza(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) zzin.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzin.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzin.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zziu {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzix {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    public static abstract class zza implements zzkn {
        private zza() {
        }

        public /* synthetic */ zza(int i10) {
            this();
        }
    }

    public AppMeasurement(zzho zzhoVar) {
        this.f7605a = new zzb(zzhoVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    @Keep
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurement getInstance(Context context) {
        if (f7604b == null) {
            synchronized (AppMeasurement.class) {
                if (f7604b == null) {
                    zzkn zzknVar = (zzkn) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (zzknVar != null) {
                        f7604b = new AppMeasurement(zzknVar);
                    } else {
                        f7604b = new AppMeasurement(zzho.zza(context, new zzdq(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return f7604b;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.f7605a.zzb(str);
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f7605a.zza(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.f7605a.zzc(str);
    }

    @Keep
    public long generateEventId() {
        return this.f7605a.zzf();
    }

    @Keep
    public String getAppInstanceId() {
        return this.f7605a.zzg();
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> listZza = this.f7605a.zza(str, str2);
        ArrayList arrayList = new ArrayList(listZza == null ? 0 : listZza.size());
        Iterator<Bundle> it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.f7605a.zzh();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.f7605a.zzi();
    }

    @Keep
    public String getGmpAppId() {
        return this.f7605a.zzj();
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.f7605a.zza(str);
    }

    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z10) {
        return this.f7605a.zza(str, str2, z10);
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.f7605a.zzb(str, str2, bundle);
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString(MediationMetaData.KEY_NAME, str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzin.zza(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        this.f7605a.zza(bundle);
    }

    public AppMeasurement(zzkn zzknVar) {
        this.f7605a = new com.google.android.gms.measurement.zza(zzknVar);
    }
}
