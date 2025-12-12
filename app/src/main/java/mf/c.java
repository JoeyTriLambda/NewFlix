package mf;

import java.util.AbstractList;
import java.util.List;

/* compiled from: AbstractMutableList.kt */
/* loaded from: classes2.dex */
public abstract class c<E> extends AbstractList<E> implements List<E>, ag.b {
    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i10) {
        return removeAt(i10);
    }

    public abstract E removeAt(int i10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
