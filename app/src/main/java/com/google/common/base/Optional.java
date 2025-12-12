package com.google.common.base;

import b8.e;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.f9595b;
    }

    public static <T> Optional<T> of(T t10) {
        return new Present(e.checkNotNull(t10));
    }

    public abstract T get();

    public abstract boolean isPresent();
}
