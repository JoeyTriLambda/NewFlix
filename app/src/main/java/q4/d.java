package q4;

import com.google.android.datatransport.Priority;
import java.util.Arrays;
import q4.o;

/* compiled from: AutoValue_TransportContext.java */
/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: a, reason: collision with root package name */
    public final String f17844a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f17845b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f17846c;

    /* compiled from: AutoValue_TransportContext.java */
    public static final class a extends o.a {

        /* renamed from: a, reason: collision with root package name */
        public String f17847a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f17848b;

        /* renamed from: c, reason: collision with root package name */
        public Priority f17849c;

        @Override // q4.o.a
        public o build() {
            String strConcat = this.f17847a == null ? " backendName" : "";
            if (this.f17849c == null) {
                strConcat = strConcat.concat(" priority");
            }
            if (strConcat.isEmpty()) {
                return new d(this.f17847a, this.f17848b, this.f17849c);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // q4.o.a
        public o.a setBackendName(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f17847a = str;
            return this;
        }

        @Override // q4.o.a
        public o.a setExtras(byte[] bArr) {
            this.f17848b = bArr;
            return this;
        }

        @Override // q4.o.a
        public o.a setPriority(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f17849c = priority;
            return this;
        }
    }

    public d(String str, byte[] bArr, Priority priority) {
        this.f17844a = str;
        this.f17845b = bArr;
        this.f17846c = priority;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f17844a.equals(oVar.getBackendName())) {
            if (Arrays.equals(this.f17845b, oVar instanceof d ? ((d) oVar).f17845b : oVar.getExtras()) && this.f17846c.equals(oVar.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // q4.o
    public String getBackendName() {
        return this.f17844a;
    }

    @Override // q4.o
    public byte[] getExtras() {
        return this.f17845b;
    }

    @Override // q4.o
    public Priority getPriority() {
        return this.f17846c;
    }

    public int hashCode() {
        return ((((this.f17844a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f17845b)) * 1000003) ^ this.f17846c.hashCode();
    }
}
