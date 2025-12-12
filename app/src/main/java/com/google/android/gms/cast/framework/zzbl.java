package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbl extends zzbb {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SessionProvider f6789a;

    @Override // com.google.android.gms.cast.framework.zzbc
    public final IObjectWrapper zzb(String str) {
        Session sessionCreateSession = this.f6789a.createSession(str);
        if (sessionCreateSession == null) {
            return null;
        }
        return sessionCreateSession.zzn();
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final String zzc() {
        return this.f6789a.getCategory();
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final boolean zzd() {
        return this.f6789a.isSessionRecoverable();
    }
}
