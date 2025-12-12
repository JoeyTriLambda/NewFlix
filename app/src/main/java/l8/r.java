package l8;

import java.lang.annotation.Annotation;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Qualified.java */
/* loaded from: classes.dex */
public final class r<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class<? extends Annotation> f15987a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<T> f15988b;

    /* compiled from: Qualified.java */
    public @interface a {
    }

    public r(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f15987a = cls;
        this.f15988b = cls2;
    }

    public static <T> r<T> qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        return new r<>(cls, cls2);
    }

    public static <T> r<T> unqualified(Class<T> cls) {
        return new r<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f15988b.equals(rVar.f15988b)) {
            return this.f15987a.equals(rVar.f15987a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15987a.hashCode() + (this.f15988b.hashCode() * 31);
    }

    public String toString() {
        Class<T> cls = this.f15988b;
        Class<? extends Annotation> cls2 = this.f15987a;
        if (cls2 == a.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + StringUtils.SPACE + cls.getName();
    }
}
