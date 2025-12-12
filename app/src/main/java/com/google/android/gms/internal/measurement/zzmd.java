package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzmd extends zzml {
    private final /* synthetic */ zzlz zza;

    @Override // com.google.android.gms.internal.measurement.zzml, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzmb(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzmd(zzlz zzlzVar) {
        super(zzlzVar);
        this.zza = zzlzVar;
    }
}
