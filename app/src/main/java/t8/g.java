package t8;

import java.util.Arrays;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
/* loaded from: classes.dex */
public final class g extends f0.d.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f19693a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f19694b;

    /* compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
    public static final class a extends f0.d.b.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19695a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f19696b;

        @Override // t8.f0.d.b.a
        public f0.d.b build() {
            String strConcat = this.f19695a == null ? " filename" : "";
            if (this.f19696b == null) {
                strConcat = strConcat.concat(" contents");
            }
            if (strConcat.isEmpty()) {
                return new g(this.f19695a, this.f19696b);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // t8.f0.d.b.a
        public f0.d.b.a setContents(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f19696b = bArr;
            return this;
        }

        @Override // t8.f0.d.b.a
        public f0.d.b.a setFilename(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f19695a = str;
            return this;
        }
    }

    public g(String str, byte[] bArr) {
        this.f19693a = str;
        this.f19694b = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.d.b)) {
            return false;
        }
        f0.d.b bVar = (f0.d.b) obj;
        if (this.f19693a.equals(bVar.getFilename())) {
            if (Arrays.equals(this.f19694b, bVar instanceof g ? ((g) bVar).f19694b : bVar.getContents())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.d.b
    public byte[] getContents() {
        return this.f19694b;
    }

    @Override // t8.f0.d.b
    public String getFilename() {
        return this.f19693a;
    }

    public int hashCode() {
        return ((this.f19693a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19694b);
    }

    public String toString() {
        return "File{filename=" + this.f19693a + ", contents=" + Arrays.toString(this.f19694b) + "}";
    }
}
