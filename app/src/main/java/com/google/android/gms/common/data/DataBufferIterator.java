package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferIterator<T> implements Iterator<T> {

    /* renamed from: b, reason: collision with root package name */
    public final DataBuffer<T> f7281b;

    /* renamed from: m, reason: collision with root package name */
    public int f7282m = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.f7281b = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7282m < this.f7281b.getCount() + (-1);
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            int i10 = this.f7282m + 1;
            this.f7282m = i10;
            return this.f7281b.get(i10);
        }
        int i11 = this.f7282m;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i11);
        throw new NoSuchElementException(sb2.toString());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
