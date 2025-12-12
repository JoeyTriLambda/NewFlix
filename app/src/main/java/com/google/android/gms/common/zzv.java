package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzv extends zzx {

    /* renamed from: e, reason: collision with root package name */
    public final Callable f7553e;

    public /* synthetic */ zzv(zze zzeVar) {
        super(false, null, null);
        this.f7553e = zzeVar;
    }

    @Override // com.google.android.gms.common.zzx
    public final String a() {
        try {
            return (String) this.f7553e.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
