package org.apache.commons.lang3.builder;

/* loaded from: classes2.dex */
final class IDKey {

    /* renamed from: id, reason: collision with root package name */
    private final int f17108id;
    private final Object value;

    public IDKey(Object obj) {
        this.f17108id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f17108id == iDKey.f17108id && this.value == iDKey.value;
    }

    public int hashCode() {
        return this.f17108id;
    }
}
