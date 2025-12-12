package r4;

import java.util.Arrays;
import r4.e;

/* compiled from: AutoValue_BackendRequest.java */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable<q4.i> f18580a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f18581b;

    /* compiled from: AutoValue_BackendRequest.java */
    /* renamed from: r4.a$a, reason: collision with other inner class name */
    public static final class C0238a extends e.a {

        /* renamed from: a, reason: collision with root package name */
        public Iterable<q4.i> f18582a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f18583b;

        @Override // r4.e.a
        public e build() {
            String str = this.f18582a == null ? " events" : "";
            if (str.isEmpty()) {
                return new a(this.f18582a, this.f18583b);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // r4.e.a
        public e.a setEvents(Iterable<q4.i> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f18582a = iterable;
            return this;
        }

        @Override // r4.e.a
        public e.a setExtras(byte[] bArr) {
            this.f18583b = bArr;
            return this;
        }
    }

    public a() {
        throw null;
    }

    public a(Iterable iterable, byte[] bArr) {
        this.f18580a = iterable;
        this.f18581b = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f18580a.equals(eVar.getEvents())) {
            if (Arrays.equals(this.f18581b, eVar instanceof a ? ((a) eVar).f18581b : eVar.getExtras())) {
                return true;
            }
        }
        return false;
    }

    @Override // r4.e
    public Iterable<q4.i> getEvents() {
        return this.f18580a;
    }

    @Override // r4.e
    public byte[] getExtras() {
        return this.f18581b;
    }

    public int hashCode() {
        return ((this.f18580a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f18581b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f18580a + ", extras=" + Arrays.toString(this.f18581b) + "}";
    }
}
