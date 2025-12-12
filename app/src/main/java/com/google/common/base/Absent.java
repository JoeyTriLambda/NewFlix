package com.google.common.base;

/* loaded from: classes.dex */
final class Absent<T> extends Optional<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final Absent<Object> f9595b = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
