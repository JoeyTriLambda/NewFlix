package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class Equivalence<T> {

    public static final class Equals extends Equivalence<Object> implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final Equals f9596b = new Equals();
        private static final long serialVersionUID = 1;

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    public static final class Identity extends Equivalence<Object> implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final Identity f9597b = new Identity();
        private static final long serialVersionUID = 1;

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.f9596b;
    }

    public static Equivalence<Object> identity() {
        return Identity.f9597b;
    }

    public abstract boolean doEquivalent(T t10, T t11);

    public abstract int doHash(T t10);

    public final boolean equivalent(T t10, T t11) {
        if (t10 == t11) {
            return true;
        }
        if (t10 == null || t11 == null) {
            return false;
        }
        return doEquivalent(t10, t11);
    }

    public final int hash(T t10) {
        if (t10 == null) {
            return 0;
        }
        return doHash(t10);
    }
}
