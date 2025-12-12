package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class StringResourceValueReader {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f7363a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7364b;

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.f7363a = resources;
        this.f7364b = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @KeepForSdk
    public String getString(String str) {
        Resources resources = this.f7363a;
        int identifier = resources.getIdentifier(str, "string", this.f7364b);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }
}
