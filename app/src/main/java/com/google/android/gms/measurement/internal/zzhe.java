package com.google.android.gms.measurement.internal;

import b0.b;
import b0.i;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfn;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhe extends i<String, com.google.android.gms.internal.measurement.zzb> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgy f8067a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhe(zzgy zzgyVar) {
        super(20);
        this.f8067a = zzgyVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b0.i
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzb create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        zzgy zzgyVar = this.f8067a;
        zzgyVar.zzak();
        Preconditions.checkNotEmpty(str2);
        if (!zzgyVar.zzl(str2)) {
            return null;
        }
        b bVar = zzgyVar.f8050h;
        if (!bVar.containsKey(str2) || bVar.get(str2) == 0) {
            zzgyVar.p(str2);
        } else {
            zzgyVar.f(str2, (zzfn.zzd) bVar.get(str2));
        }
        return zzgyVar.f8052j.snapshot().get(str2);
    }
}
