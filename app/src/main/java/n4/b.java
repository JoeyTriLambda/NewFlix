package n4;

/* compiled from: Encoding.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f16486a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f16486a = str;
    }

    public static b of(String str) {
        return new b(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f16486a.equals(((b) obj).f16486a);
    }

    public String getName() {
        return this.f16486a;
    }

    public int hashCode() {
        return this.f16486a.hashCode() ^ 1000003;
    }

    public String toString() {
        return ac.c.o(new StringBuilder("Encoding{name=\""), this.f16486a, "\"}");
    }
}
