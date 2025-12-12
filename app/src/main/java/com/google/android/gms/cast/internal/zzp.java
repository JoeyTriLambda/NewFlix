package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public class zzp {

    /* renamed from: a, reason: collision with root package name */
    public final Logger f6863a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6864b;

    /* renamed from: c, reason: collision with root package name */
    public zzar f6865c;

    public zzp(String str, String str2, String str3) throws IllegalArgumentException {
        CastUtils.throwIfInvalidNamespace(str);
        this.f6864b = str;
        this.f6863a = new Logger("MediaControlChannel", null);
    }

    public final long zzd() {
        zzar zzarVar = this.f6865c;
        if (zzarVar != null) {
            return zzarVar.zza();
        }
        this.f6863a.e("Attempt to generate requestId without a sink", new Object[0]);
        return 0L;
    }

    public final String zze() {
        return this.f6864b;
    }

    public void zzf() {
        throw null;
    }

    public final void zzg(String str, long j10, String str2) throws IllegalStateException {
        zzar zzarVar = this.f6865c;
        if (zzarVar != null) {
            zzarVar.zzb(this.f6864b, str, j10, null);
        } else {
            this.f6863a.e("Attempt to send text message without a sink", new Object[0]);
        }
    }

    public final void zzh(zzar zzarVar) {
        this.f6865c = zzarVar;
        if (zzarVar == null) {
            zzf();
        }
    }
}
