package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpy;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgo {

    /* renamed from: a, reason: collision with root package name */
    public final String f8017a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f8018b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f8019c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgm f8020d;

    public zzgo(zzgm zzgmVar, String str, Bundle bundle) {
        this.f8020d = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.f8017a = str;
        this.f8018b = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011a A[Catch: NumberFormatException | JSONException -> 0x0122, NumberFormatException | JSONException -> 0x0122, TRY_LEAVE, TryCatch #0 {NumberFormatException | JSONException -> 0x0122, blocks: (B:9:0x0025, B:42:0x0091, B:42:0x0091, B:43:0x00a0, B:43:0x00a0, B:45:0x00a6, B:45:0x00a6, B:47:0x00b2, B:47:0x00b2, B:49:0x00c4, B:49:0x00c4, B:50:0x00cd, B:50:0x00cd, B:51:0x00d1, B:51:0x00d1, B:53:0x00d7, B:53:0x00d7, B:55:0x00e3, B:55:0x00e3, B:57:0x00f5, B:57:0x00f5, B:58:0x00fe, B:58:0x00fe, B:59:0x0102, B:59:0x0102, B:60:0x010e, B:60:0x010e, B:61:0x011a, B:61:0x011a, B:20:0x0052, B:23:0x005c, B:26:0x0066, B:29:0x0070, B:32:0x007a), top: B:73:0x0025, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zza() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgo.zza():android.os.Bundle");
    }

    public final void zza(Bundle bundle) {
        Iterator<String> it;
        JSONObject jSONObject;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        zzgm zzgmVar = this.f8020d;
        SharedPreferences.Editor editorEdit = zzgmVar.zzg().edit();
        int size = bundle2.size();
        String str = this.f8017a;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Object obj = bundle2.get(next);
                if (obj != null) {
                    try {
                        jSONObject = new JSONObject();
                        jSONObject.put("n", next);
                    } catch (JSONException e10) {
                        e = e10;
                        it = it2;
                    }
                    if (zzpy.zza()) {
                        it = it2;
                        try {
                        } catch (JSONException e11) {
                            e = e11;
                            zzgmVar.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences", e);
                            it2 = it;
                        }
                        if (zzgmVar.zze().zza(zzbh.F0)) {
                            if (obj instanceof String) {
                                jSONObject.put("v", String.valueOf(obj));
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("v", String.valueOf(obj));
                                jSONObject.put("t", "l");
                            } else if (obj instanceof int[]) {
                                jSONObject.put("v", Arrays.toString((int[]) obj));
                                jSONObject.put("t", "ia");
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", Arrays.toString((long[]) obj));
                                jSONObject.put("t", "la");
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", String.valueOf(obj));
                                jSONObject.put("t", "d");
                            } else {
                                zzgmVar.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                                it2 = it;
                            }
                            jSONArray.put(jSONObject);
                            it2 = it;
                        }
                    } else {
                        it = it2;
                    }
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        zzgmVar.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        it2 = it;
                    }
                    jSONArray.put(jSONObject);
                    it2 = it;
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f8019c = bundle2;
    }
}
