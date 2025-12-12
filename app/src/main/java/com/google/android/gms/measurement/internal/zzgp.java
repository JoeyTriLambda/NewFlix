package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgp {

    /* renamed from: a, reason: collision with root package name */
    public final String f8021a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8022b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8023c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8024d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgm f8025e;

    public zzgp(zzgm zzgmVar, String str, boolean z10) {
        this.f8025e = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.f8021a = str;
        this.f8022b = z10;
    }

    public final void zza(boolean z10) {
        SharedPreferences.Editor editorEdit = this.f8025e.zzg().edit();
        editorEdit.putBoolean(this.f8021a, z10);
        editorEdit.apply();
        this.f8024d = z10;
    }

    public final boolean zza() {
        if (!this.f8023c) {
            this.f8023c = true;
            this.f8024d = this.f8025e.zzg().getBoolean(this.f8021a, this.f8022b);
        }
        return this.f8024d;
    }
}
