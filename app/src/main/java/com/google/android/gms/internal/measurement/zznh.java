package com.google.android.gms.internal.measurement;

import ac.c;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zznh extends IllegalArgumentException {
    public zznh(int i10, int i11) {
        super(c.g("Unpaired surrogate at index ", i10, " of ", i11));
    }
}
