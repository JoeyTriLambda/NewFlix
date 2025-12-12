package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzk extends zzj {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7528b;

    public zzk(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f7528b = bArr;
    }

    @Override // com.google.android.gms.common.zzj
    public final byte[] b() {
        return this.f7528b;
    }
}
