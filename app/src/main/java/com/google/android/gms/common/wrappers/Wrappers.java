package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class Wrappers {

    /* renamed from: b, reason: collision with root package name */
    public static final Wrappers f7520b = new Wrappers();

    /* renamed from: a, reason: collision with root package name */
    public PackageManagerWrapper f7521a = null;

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        return f7520b.zza(context);
    }

    public final synchronized PackageManagerWrapper zza(Context context) {
        if (this.f7521a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7521a = new PackageManagerWrapper(context);
        }
        return this.f7521a;
    }
}
