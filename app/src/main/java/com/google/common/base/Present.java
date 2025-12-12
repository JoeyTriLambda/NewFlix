package com.google.common.base;

/* loaded from: classes.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;

    /* renamed from: b, reason: collision with root package name */
    public final T f9598b;

    public Present(T t10) {
        this.f9598b = t10;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.f9598b.equals(((Present) obj).f9598b);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.f9598b;
    }

    public int hashCode() {
        return this.f9598b.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f9598b);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 13);
        sb2.append("Optional.of(");
        sb2.append(strValueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
