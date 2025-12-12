package n4;

import com.google.android.datatransport.Priority;

/* compiled from: AutoValue_Event.java */
/* loaded from: classes.dex */
public final class a<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f16483a;

    /* renamed from: b, reason: collision with root package name */
    public final T f16484b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f16485c;

    public a(Integer num, T t10, Priority priority) {
        this.f16483a = num;
        if (t10 == null) {
            throw new NullPointerException("Null payload");
        }
        this.f16484b = t10;
        this.f16485c = priority;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f16483a;
        if (num != null ? num.equals(cVar.getCode()) : cVar.getCode() == null) {
            if (this.f16484b.equals(cVar.getPayload()) && this.f16485c.equals(cVar.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // n4.c
    public Integer getCode() {
        return this.f16483a;
    }

    @Override // n4.c
    public T getPayload() {
        return this.f16484b;
    }

    @Override // n4.c
    public Priority getPriority() {
        return this.f16485c;
    }

    public int hashCode() {
        Integer num = this.f16483a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f16484b.hashCode()) * 1000003) ^ this.f16485c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f16483a + ", payload=" + this.f16484b + ", priority=" + this.f16485c + "}";
    }
}
