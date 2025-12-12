package hf;

import ne.k;
import ne.q;

/* compiled from: Subject.java */
/* loaded from: classes2.dex */
public abstract class b<T> extends k<T> implements q<T> {
    public final b<T> toSerialized() {
        return this instanceof a ? this : new a(this);
    }
}
