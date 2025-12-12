package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzmc extends zzlz {
    public zzmc(int i10) {
        super(i10);
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zzd() {
        if (!zze()) {
            for (int i10 = 0; i10 < zza(); i10++) {
                Map.Entry entryZzb = zzb(i10);
                if (((zzjl) entryZzb.getKey()).zze()) {
                    entryZzb.setValue(Collections.unmodifiableList((List) entryZzb.getValue()));
                }
            }
            for (Map.Entry entry : zzb()) {
                if (((zzjl) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzd();
    }
}
