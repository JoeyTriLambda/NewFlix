package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzo {
    private static final Logger zza = new Logger("FeatureUsageAnalytics");
    private static final String zzb = "21.4.0";
    private static zzo zzc;
    private final zzg zzd;
    private final SharedPreferences zze;
    private final String zzf;
    private long zzl;
    private final Clock zzk = DefaultClock.getInstance();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Handler zzh = new zzed(Looper.getMainLooper());
    private final Runnable zzg = new Runnable() { // from class: com.google.android.gms.internal.cast.zzn
        @Override // java.lang.Runnable
        public final void run() {
            zzo.zzc(this.zza);
        }
    };

    private zzo(SharedPreferences sharedPreferences, zzg zzgVar, String str) {
        this.zze = sharedPreferences;
        this.zzd = zzgVar;
        this.zzf = str;
    }

    public static synchronized zzo zza(SharedPreferences sharedPreferences, zzg zzgVar, String str) {
        if (zzc == null) {
            zzc = new zzo(sharedPreferences, zzgVar, str);
        }
        return zzc;
    }

    public static String zzb(String str, String str2) {
        return String.format("%s%s", str, str2);
    }

    public static /* synthetic */ void zzc(zzo zzoVar) {
        if (zzoVar.zzi.isEmpty()) {
            return;
        }
        long j10 = true != zzoVar.zzj.equals(zzoVar.zzi) ? DateUtils.MILLIS_PER_DAY : 172800000L;
        long jZzf = zzoVar.zzf();
        long j11 = zzoVar.zzl;
        if (j11 == 0 || jZzf - j11 >= j10) {
            zza.d("Upload the feature usage report.", new Object[0]);
            zznd zzndVarZza = zzne.zza();
            zzndVarZza.zzb(zzb);
            zzndVarZza.zza(zzoVar.zzf);
            zzne zzneVar = (zzne) zzndVarZza.zzq();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(zzoVar.zzi);
            zzmx zzmxVarZza = zzmy.zza();
            zzmxVarZza.zza(arrayList);
            zzmxVarZza.zzb(zzneVar);
            zzmy zzmyVar = (zzmy) zzmxVarZza.zzq();
            zznn zznnVarZzc = zzno.zzc();
            zznnVarZzc.zzc(zzmyVar);
            zzoVar.zzd.zze((zzno) zznnVarZzc.zzq(), 243);
            SharedPreferences sharedPreferences = zzoVar.zze;
            Set set = zzoVar.zzj;
            Set set2 = zzoVar.zzi;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!set.equals(set2)) {
                zzoVar.zzj.clear();
                zzoVar.zzj.addAll(zzoVar.zzi);
                Iterator it = zzoVar.zzj.iterator();
                while (it.hasNext()) {
                    String string = Integer.toString(((zzml) it.next()).zza());
                    String strZzh = zzoVar.zzh(string);
                    String strZzb = zzb("feature_usage_timestamp_reported_feature_", string);
                    if (!TextUtils.equals(strZzh, strZzb)) {
                        long j12 = zzoVar.zze.getLong(strZzh, 0L);
                        editorEdit.remove(strZzh);
                        if (j12 != 0) {
                            editorEdit.putLong(strZzb, j12);
                        }
                    }
                }
            }
            zzoVar.zzl = jZzf;
            editorEdit.putLong("feature_usage_last_report_time", jZzf).apply();
        }
    }

    public static void zzd(zzml zzmlVar) {
        zzo zzoVar;
        if (!zzg.zza || (zzoVar = zzc) == null) {
            return;
        }
        zzoVar.zze.edit().putLong(zzoVar.zzh(Integer.toString(zzmlVar.zza())), zzoVar.zzf()).apply();
        zzoVar.zzi.add(zzmlVar);
        zzoVar.zzj();
    }

    private final long zzf() {
        return ((Clock) Preconditions.checkNotNull(this.zzk)).currentTimeMillis();
    }

    private static zzml zzg(String str) throws NumberFormatException {
        zzml zzmlVar;
        try {
            int i10 = Integer.parseInt(str);
            zzml zzmlVar2 = zzml.DEVELOPER_FEATURE_FLAG_UNKNOWN;
            switch (i10) {
                case 0:
                    zzmlVar = zzml.DEVELOPER_FEATURE_FLAG_UNKNOWN;
                    break;
                case 1:
                    zzmlVar = zzml.CAF_CAST_BUTTON;
                    break;
                case 2:
                    zzmlVar = zzml.CAF_EXPANDED_CONTROLLER;
                    break;
                case 3:
                    zzmlVar = zzml.CAF_MINI_CONTROLLER;
                    break;
                case 4:
                    zzmlVar = zzml.CAF_CONTAINER_CONTROLLER;
                    break;
                case 5:
                    zzmlVar = zzml.CAST_CONTEXT;
                    break;
                case 6:
                    zzmlVar = zzml.IMAGE_CACHE;
                    break;
                case 7:
                    zzmlVar = zzml.IMAGE_PICKER;
                    break;
                case 8:
                    zzmlVar = zzml.AD_BREAK_PARSER;
                    break;
                case 9:
                    zzmlVar = zzml.UI_STYLE;
                    break;
                case 10:
                    zzmlVar = zzml.HARDWARE_VOLUME_BUTTON;
                    break;
                case 11:
                    zzmlVar = zzml.NON_CAST_DEVICE_PROVIDER;
                    break;
                case 12:
                    zzmlVar = zzml.PAUSE_CONTROLLER;
                    break;
                case 13:
                    zzmlVar = zzml.SEEK_CONTROLLER;
                    break;
                case 14:
                    zzmlVar = zzml.STREAM_VOLUME;
                    break;
                case 15:
                    zzmlVar = zzml.UI_MEDIA_CONTROLLER;
                    break;
                case 16:
                    zzmlVar = zzml.PLAYBACK_RATE_CONTROLLER;
                    break;
                case 17:
                    zzmlVar = zzml.PRECACHE;
                    break;
                case 18:
                    zzmlVar = zzml.INSTRUCTIONS_VIEW;
                    break;
                case 19:
                    zzmlVar = zzml.OPTION_SUSPEND_SESSIONS_WHEN_BACKGROUNDED;
                    break;
                case 20:
                    zzmlVar = zzml.OPTION_STOP_RECEIVER_APPLICATION_WHEN_ENDING_SESSION;
                    break;
                case 21:
                    zzmlVar = zzml.OPTION_DISABLE_DISCOVERY_AUTOSTART;
                    break;
                case 22:
                    zzmlVar = zzml.OPTION_DISABLE_ANALYTICS_LOGGING;
                    break;
                case 23:
                    zzmlVar = zzml.OPTION_PHYSICAL_VOLUME_BUTTONS_WILL_CONTROL_DEVICE_VOLUME;
                    break;
                case 24:
                    zzmlVar = zzml.CAF_EXPANDED_CONTROLLER_HIDE_STREAM_POSITION_CONTROLS_FOR_LIVE_CONTENT;
                    break;
                case 25:
                    zzmlVar = zzml.CAF_EXPANDED_CONTROLLER_WITH_LIVE_CONTENT;
                    break;
                case 26:
                    zzmlVar = zzml.REMOTE_MEDIA_CLIENT_LOAD_MEDIA_WITH_OPTIONS;
                    break;
                case 27:
                    zzmlVar = zzml.REMOTE_MEDIA_CLIENT_QUEUE_LOAD_ITEMS_WITH_OPTIONS;
                    break;
                case 28:
                    zzmlVar = zzml.REMOTE_MEDIA_CLIENT_LOAD_MEDIA_WITH_LOAD_REQUEST_DATA;
                    break;
                case 29:
                    zzmlVar = zzml.LAUNCH_OPTION_ANDROID_RECEIVER_COMPATIBLE;
                    break;
                case 30:
                    zzmlVar = zzml.CAST_CONTEXT_SET_LAUNCH_CREDENTIALS_DATA;
                    break;
                case 31:
                    zzmlVar = zzml.START_DISCOVERY_AFTER_FIRST_TAP_ON_CAST_BUTTON;
                    break;
                case 32:
                    zzmlVar = zzml.CAST_UNAVAILABLE_BUTTON_VISIBLE;
                    break;
                case 33:
                    zzmlVar = zzml.CAST_DEFAULT_MEDIA_ROUTER_DIALOG;
                    break;
                case 34:
                    zzmlVar = zzml.CAST_CUSTOM_MEDIA_ROUTER_DIALOG;
                    break;
                case 35:
                    zzmlVar = zzml.CAST_OUTPUT_SWITCHER_ENABLED;
                    break;
                case 36:
                    zzmlVar = zzml.CAST_TRANSFER_TO_LOCAL_ENABLED;
                    break;
                case 37:
                    zzmlVar = zzml.CAST_BUTTON_IS_TRIGGERED_DEFAULT_CAST_DIALOG_FALSE;
                    break;
                case 38:
                    zzmlVar = zzml.CAST_BUTTON_DELEGATE;
                    break;
                case 39:
                    zzmlVar = zzml.CAST_BUTTON_DELEGATE_PRESENT_LNA_PERMISSION_CUSTOM_DIALOG;
                    break;
                case 40:
                    zzmlVar = zzml.CAST_BUTTON_DELEGATE_PRESENT_CAST_STATE_CUSTOM_DIALOG;
                    break;
                case 41:
                    zzmlVar = zzml.CAST_TRANSFER_TO_LOCAL_USED;
                    break;
                case 42:
                    zzmlVar = zzml.MEDIA_REQUEST_ITEM_MAP_HLS_SEGMENT_FORMAT_TO_STRING;
                    break;
                case 43:
                    zzmlVar = zzml.MEDIA_REQUEST_ITEM_MAP_HLS_SEGMENT_FORMAT_STRING_TO_ENUM;
                    break;
                case 44:
                    zzmlVar = zzml.HLS_SEGMENT_MAP_HLS_SEGMENT_FORMAT_TO_STRING;
                    break;
                case 45:
                    zzmlVar = zzml.HLS_SEGMENT_MAP_HLS_SEGMENT_FORMAT_STRING_TO_ENUM;
                    break;
                case 46:
                    zzmlVar = zzml.HLS_VIDEO_SEGMENT_MAP_HLS_VIDEO_SEGMENT_FORMAT_TO_STRING;
                    break;
                case 47:
                    zzmlVar = zzml.HLS_VIDEO_SEGMENT_MAP_HLS_VIDEO_SEGMENT_FORMAT_STRING_TO_ENUM;
                    break;
                case 48:
                    zzmlVar = zzml.CAST_SLIDER_SET_AD_BLOCK_POSITIONS;
                    break;
                case 49:
                    zzmlVar = zzml.CAF_NOTIFICATION_SERVICE;
                    break;
                case 50:
                    zzmlVar = zzml.HARDWARE_VOLUME_BUTTON_PRESS;
                    break;
                case 51:
                    zzmlVar = zzml.CAST_SDK_DEFAULT_DEVICE_DIALOG;
                    break;
                case 52:
                    zzmlVar = zzml.CAST_SDK_CUSTOM_DEVICE_DIALOG;
                    break;
                case 53:
                    zzmlVar = zzml.PERSISTENT_CAST_BUTTON_DISCOVERY_DISABLED_WITH_CONFLICT_TYPES;
                    break;
                case 54:
                    zzmlVar = zzml.CAST_DEVICE_DIALOG_FACTORY_INSTANTIATED;
                    break;
                case 55:
                    zzmlVar = zzml.CAF_MEDIA_NOTIFICATION_PROXY;
                    break;
                default:
                    zzmlVar = null;
                    break;
            }
            return zzmlVar;
        } catch (NumberFormatException unused) {
            return zzml.DEVELOPER_FEATURE_FLAG_UNKNOWN;
        }
    }

    private final String zzh(String str) {
        SharedPreferences sharedPreferences = this.zze;
        String strZzb = zzb("feature_usage_timestamp_reported_feature_", str);
        return sharedPreferences.contains(strZzb) ? strZzb : zzb("feature_usage_timestamp_detected_feature_", str);
    }

    private final void zzi(Set set) {
        if (set.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.zze.edit();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    private final void zzj() {
        this.zzh.post(this.zzg);
    }

    public final void zze() throws NumberFormatException {
        zzml zzmlVarZzg;
        SharedPreferences sharedPreferences = this.zze;
        Set set = this.zzi;
        String string = sharedPreferences.getString("feature_usage_sdk_version", null);
        String string2 = sharedPreferences.getString("feature_usage_package_name", null);
        set.clear();
        this.zzj.clear();
        this.zzl = 0L;
        if (!zzb.equals(string) || !this.zzf.equals(string2)) {
            HashSet hashSet = new HashSet();
            for (String str : this.zze.getAll().keySet()) {
                if (str.startsWith("feature_usage_timestamp_")) {
                    hashSet.add(str);
                }
            }
            hashSet.add("feature_usage_last_report_time");
            zzi(hashSet);
            this.zze.edit().putString("feature_usage_sdk_version", zzb).putString("feature_usage_package_name", this.zzf).apply();
            return;
        }
        this.zzl = this.zze.getLong("feature_usage_last_report_time", 0L);
        long jZzf = zzf();
        HashSet hashSet2 = new HashSet();
        for (String str2 : this.zze.getAll().keySet()) {
            if (str2.startsWith("feature_usage_timestamp_")) {
                long j10 = this.zze.getLong(str2, 0L);
                if (j10 != 0 && jZzf - j10 > 1209600000) {
                    hashSet2.add(str2);
                } else if (str2.startsWith("feature_usage_timestamp_reported_feature_")) {
                    zzml zzmlVarZzg2 = zzg(str2.substring(41));
                    if (zzmlVarZzg2 != null) {
                        this.zzj.add(zzmlVarZzg2);
                        this.zzi.add(zzmlVarZzg2);
                    }
                } else if (str2.startsWith("feature_usage_timestamp_detected_feature_") && (zzmlVarZzg = zzg(str2.substring(41))) != null) {
                    this.zzi.add(zzmlVarZzg);
                }
            }
        }
        zzi(hashSet2);
        Preconditions.checkNotNull(this.zzh);
        Preconditions.checkNotNull(this.zzg);
        zzj();
    }
}
