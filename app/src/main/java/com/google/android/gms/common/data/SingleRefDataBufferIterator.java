package com.google.android.gms.common.data;

import ac.c;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {

    /* renamed from: n, reason: collision with root package name */
    public T f7296n;

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            int i10 = this.f7282m;
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Cannot advance the iterator beyond ");
            sb2.append(i10);
            throw new NoSuchElementException(sb2.toString());
        }
        int i11 = this.f7282m + 1;
        this.f7282m = i11;
        if (i11 == 0) {
            T t10 = (T) Preconditions.checkNotNull(this.f7281b.get(0));
            this.f7296n = t10;
            if (!(t10 instanceof DataBufferRef)) {
                String strValueOf = String.valueOf(t10.getClass());
                throw new IllegalStateException(c.p(new StringBuilder(strValueOf.length() + 44), "DataBuffer reference of type ", strValueOf, " is not movable"));
            }
        } else {
            ((DataBufferRef) Preconditions.checkNotNull(this.f7296n)).zaa(this.f7282m);
        }
        return this.f7296n;
    }
}
