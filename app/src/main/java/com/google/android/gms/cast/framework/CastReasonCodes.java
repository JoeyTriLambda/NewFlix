package com.google.android.gms.cast.framework;

import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class CastReasonCodes {

    /* renamed from: a, reason: collision with root package name */
    public final Map f6376a;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CastReasonType {
    }

    public CastReasonCodes(Bundle bundle) {
        this.f6376a = com.google.android.gms.internal.cast.zzah.zza(bundle, "com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES");
    }

    public final int zza(int i10) {
        Integer num;
        Map map = this.f6376a;
        if (map == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(i10);
        if (map.containsKey(numValueOf) && (num = (Integer) map.get(numValueOf)) != null) {
            return num.intValue();
        }
        return 0;
    }
}
