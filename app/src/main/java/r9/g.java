package r9;

/* compiled from: SessionDatastore.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f18860a;

    public g(String str) {
        this.f18860a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && zf.i.areEqual(this.f18860a, ((g) obj).f18860a);
    }

    public final String getSessionId() {
        return this.f18860a;
    }

    public int hashCode() {
        String str = this.f18860a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return ac.c.n(new StringBuilder("FirebaseSessionsData(sessionId="), this.f18860a, ')');
    }
}
