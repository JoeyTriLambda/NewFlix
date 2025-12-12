package com.google.android.gms.cast.internal.media;

import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f6805a = new Logger("MetadataUtils");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f6806b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f6807c;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        f6806b = strArr;
        f6807c = "yyyyMMdd'T'HHmmss".concat(String.valueOf(strArr[0]));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Calendar zzb(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.media.zza.zzb(java.lang.String):java.util.Calendar");
    }

    public static JSONArray zzc(List list) {
        list.getClass();
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(((WebImage) it.next()).toJson());
        }
        return jSONArray;
    }

    public static void zzd(List list, JSONArray jSONArray) {
        try {
            list.clear();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i10)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }
}
