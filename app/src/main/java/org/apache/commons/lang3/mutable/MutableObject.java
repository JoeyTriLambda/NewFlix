package org.apache.commons.lang3.mutable;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MutableObject<T> implements Mutable<T>, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.value.equals(((MutableObject) obj).value);
        }
        return false;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public T getValue2() {
        return this.value;
    }

    public int hashCode() {
        T t10 = this.value;
        if (t10 == null) {
            return 0;
        }
        return t10.hashCode();
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(T t10) {
        this.value = t10;
    }

    public String toString() {
        T t10 = this.value;
        return t10 == null ? "null" : t10.toString();
    }

    public MutableObject(T t10) {
        this.value = t10;
    }
}
