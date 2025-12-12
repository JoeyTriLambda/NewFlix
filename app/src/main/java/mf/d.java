package mf;

import java.util.AbstractSet;
import java.util.Set;

/* compiled from: AbstractMutableSet.kt */
/* loaded from: classes2.dex */
public abstract class d<E> extends AbstractSet<E> implements Set<E>, ag.a {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
