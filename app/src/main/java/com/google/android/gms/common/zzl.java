package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
abstract class zzl extends zzj {

    /* renamed from: c, reason: collision with root package name */
    public static final WeakReference f7529c = new WeakReference(null);

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f7530b;

    public zzl(byte[] bArr) {
        super(bArr);
        this.f7530b = f7529c;
    }

    @Override // com.google.android.gms.common.zzj
    public final byte[] b() {
        byte[] bArrZzb;
        synchronized (this) {
            bArrZzb = (byte[]) this.f7530b.get();
            if (bArrZzb == null) {
                bArrZzb = zzb();
                this.f7530b = new WeakReference(bArrZzb);
            }
        }
        return bArrZzb;
    }

    public abstract byte[] zzb();
}
