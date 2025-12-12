package q4;

import java.util.Arrays;

/* compiled from: EncodedPayload.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final n4.b f17862a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f17863b;

    public h(n4.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f17862a = bVar;
        this.f17863b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f17862a.equals(hVar.f17862a)) {
            return Arrays.equals(this.f17863b, hVar.f17863b);
        }
        return false;
    }

    public byte[] getBytes() {
        return this.f17863b;
    }

    public n4.b getEncoding() {
        return this.f17862a;
    }

    public int hashCode() {
        return ((this.f17862a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f17863b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f17862a + ", bytes=[...]}";
    }
}
