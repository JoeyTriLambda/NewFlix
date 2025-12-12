package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgr {

    /* renamed from: a, reason: collision with root package name */
    public final String f8031a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8032b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8033c;

    /* renamed from: d, reason: collision with root package name */
    public long f8034d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgm f8035e;

    public zzgr(zzgm zzgmVar, String str, long j10) {
        this.f8035e = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.f8031a = str;
        this.f8032b = j10;
    }

    public final long zza() {
        if (!this.f8033c) {
            this.f8033c = true;
            this.f8034d = this.f8035e.zzg().getLong(this.f8031a, this.f8032b);
        }
        return this.f8034d;
    }

    public final void zza(long j10) {
        SharedPreferences.Editor editorEdit = this.f8035e.zzg().edit();
        editorEdit.putLong(this.f8031a, j10);
        editorEdit.apply();
        this.f8034d = j10;
    }
}
