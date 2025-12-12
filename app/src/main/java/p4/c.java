package p4;

import java.util.List;

/* compiled from: AutoValue_BatchedLogRequest.java */
/* loaded from: classes.dex */
public final class c extends g {

    /* renamed from: a, reason: collision with root package name */
    public final List<i> f17568a;

    public c(List<i> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f17568a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.f17568a.equals(((g) obj).getLogRequests());
        }
        return false;
    }

    @Override // p4.g
    public List<i> getLogRequests() {
        return this.f17568a;
    }

    public int hashCode() {
        return this.f17568a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f17568a + "}";
    }
}
