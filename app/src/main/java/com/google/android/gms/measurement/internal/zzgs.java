package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgs {

    /* renamed from: a, reason: collision with root package name */
    public final String f8036a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8037b;

    /* renamed from: c, reason: collision with root package name */
    public String f8038c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgm f8039d;

    public zzgs(zzgm zzgmVar, String str, String str2) {
        this.f8039d = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.f8036a = str;
    }

    public final String zza() {
        if (!this.f8037b) {
            this.f8037b = true;
            this.f8038c = this.f8039d.zzg().getString(this.f8036a, null);
        }
        return this.f8038c;
    }

    public final void zza(String str) {
        SharedPreferences.Editor editorEdit = this.f8039d.zzg().edit();
        editorEdit.putString(this.f8036a, str);
        editorEdit.apply();
        this.f8038c = str;
    }
}
