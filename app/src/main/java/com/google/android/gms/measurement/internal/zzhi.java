package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhi {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f8082a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8083b;

    public zzhi(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.f8082a = context.getResources();
        if (TextUtils.isEmpty(str)) {
            this.f8083b = zza(context);
        } else {
            this.f8083b = str;
        }
    }

    public final String zza(String str) {
        String str2 = this.f8083b;
        Resources resources = this.f8082a;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }
}
