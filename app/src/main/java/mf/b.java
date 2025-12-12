package mf;

import java.util.AbstractCollection;
import java.util.Collection;

/* compiled from: AbstractMutableCollection.kt */
/* loaded from: classes2.dex */
public abstract class b<E> extends AbstractCollection<E> implements Collection<E>, ag.a {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
