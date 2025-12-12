package b9;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldDescriptor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f4798a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Object> f4799b;

    /* compiled from: FieldDescriptor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f4800a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f4801b = null;

        public a(String str) {
            this.f4800a = str;
        }

        public c build() {
            return new c(this.f4800a, this.f4801b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f4801b)));
        }

        public <T extends Annotation> a withProperty(T t10) {
            if (this.f4801b == null) {
                this.f4801b = new HashMap();
            }
            this.f4801b.put(t10.annotationType(), t10);
            return this;
        }
    }

    public c(String str, Map<Class<?>, Object> map) {
        this.f4798a = str;
        this.f4799b = map;
    }

    public static a builder(String str) {
        return new a(str);
    }

    public static c of(String str) {
        return new c(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f4798a.equals(cVar.f4798a) && this.f4799b.equals(cVar.f4799b);
    }

    public String getName() {
        return this.f4798a;
    }

    public <T extends Annotation> T getProperty(Class<T> cls) {
        return (T) this.f4799b.get(cls);
    }

    public int hashCode() {
        return this.f4799b.hashCode() + (this.f4798a.hashCode() * 31);
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f4798a + ", properties=" + this.f4799b.values() + "}";
    }
}
