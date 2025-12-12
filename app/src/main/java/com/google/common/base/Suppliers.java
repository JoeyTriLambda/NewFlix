package com.google.common.base;

import b8.d;
import b8.e;
import b8.g;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Suppliers {

    public static class MemoizingSupplier<T> implements g<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        public final g<T> f9599b;

        /* renamed from: m, reason: collision with root package name */
        public volatile transient boolean f9600m;

        /* renamed from: n, reason: collision with root package name */
        public transient T f9601n;

        public MemoizingSupplier(g<T> gVar) {
            this.f9599b = (g) e.checkNotNull(gVar);
        }

        @Override // b8.g
        public T get() {
            if (!this.f9600m) {
                synchronized (this) {
                    if (!this.f9600m) {
                        T t10 = this.f9599b.get();
                        this.f9601n = t10;
                        this.f9600m = true;
                        return t10;
                    }
                }
            }
            return this.f9601n;
        }

        public String toString() {
            Object string;
            if (this.f9600m) {
                String strValueOf = String.valueOf(this.f9601n);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 25);
                sb2.append("<supplier that returned ");
                sb2.append(strValueOf);
                sb2.append(">");
                string = sb2.toString();
            } else {
                string = this.f9599b;
            }
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 19);
            sb3.append("Suppliers.memoize(");
            sb3.append(strValueOf2);
            sb3.append(")");
            return sb3.toString();
        }
    }

    public static class SupplierOfInstance<T> implements g<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        public final T f9602b;

        public SupplierOfInstance(T t10) {
            this.f9602b = t10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return d.equal(this.f9602b, ((SupplierOfInstance) obj).f9602b);
            }
            return false;
        }

        @Override // b8.g
        public T get() {
            return this.f9602b;
        }

        public int hashCode() {
            return d.hashCode(this.f9602b);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f9602b);
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 22);
            sb2.append("Suppliers.ofInstance(");
            sb2.append(strValueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class a<T> implements g<T> {

        /* renamed from: b, reason: collision with root package name */
        public volatile g<T> f9603b;

        /* renamed from: m, reason: collision with root package name */
        public volatile boolean f9604m;

        /* renamed from: n, reason: collision with root package name */
        public T f9605n;

        public a(g<T> gVar) {
            this.f9603b = (g) e.checkNotNull(gVar);
        }

        @Override // b8.g
        public T get() {
            if (!this.f9604m) {
                synchronized (this) {
                    if (!this.f9604m) {
                        g<T> gVar = this.f9603b;
                        Objects.requireNonNull(gVar);
                        T t10 = gVar.get();
                        this.f9605n = t10;
                        this.f9604m = true;
                        this.f9603b = null;
                        return t10;
                    }
                }
            }
            return this.f9605n;
        }

        public String toString() {
            Object string = this.f9603b;
            if (string == null) {
                String strValueOf = String.valueOf(this.f9605n);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 25);
                sb2.append("<supplier that returned ");
                sb2.append(strValueOf);
                sb2.append(">");
                string = sb2.toString();
            }
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 19);
            sb3.append("Suppliers.memoize(");
            sb3.append(strValueOf2);
            sb3.append(")");
            return sb3.toString();
        }
    }

    public static <T> g<T> memoize(g<T> gVar) {
        return ((gVar instanceof a) || (gVar instanceof MemoizingSupplier)) ? gVar : gVar instanceof Serializable ? new MemoizingSupplier(gVar) : new a(gVar);
    }

    public static <T> g<T> ofInstance(T t10) {
        return new SupplierOfInstance(t10);
    }
}
