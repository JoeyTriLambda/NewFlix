package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* renamed from: b, reason: collision with root package name */
    public boolean f7294b;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<Integer> f7295m;

    public final int a(int i10) {
        if (i10 >= 0 && i10 < this.f7295m.size()) {
            return this.f7295m.get(i10).intValue();
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("Position ");
        sb2.append(i10);
        sb2.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final void b() {
        synchronized (this) {
            if (!this.f7294b) {
                int count = ((DataHolder) Preconditions.checkNotNull(null)).getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.f7295m = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    getPrimaryDataMarkerColumn();
                    throw null;
                }
                this.f7294b = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public final T get(int i10) {
        int iIntValue;
        int iIntValue2;
        b();
        int iA = a(i10);
        int i11 = 0;
        if (i10 >= 0 && i10 != this.f7295m.size()) {
            if (i10 == this.f7295m.size() - 1) {
                iIntValue = ((DataHolder) Preconditions.checkNotNull(null)).getCount();
                iIntValue2 = this.f7295m.get(i10).intValue();
            } else {
                iIntValue = this.f7295m.get(i10 + 1).intValue();
                iIntValue2 = this.f7295m.get(i10).intValue();
            }
            i11 = iIntValue - iIntValue2;
            if (i11 == 1) {
                ((DataHolder) Preconditions.checkNotNull(null)).getWindowIndex(a(i10));
                if (getChildDataMarkerColumn() != null) {
                    throw null;
                }
                i11 = 1;
            }
        }
        return getEntry(iA, i11);
    }

    @KeepForSdk
    public String getChildDataMarkerColumn() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        b();
        return this.f7295m.size();
    }

    @KeepForSdk
    public abstract T getEntry(int i10, int i11);

    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();
}
