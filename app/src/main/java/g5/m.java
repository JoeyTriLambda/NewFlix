package g5;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: TrackOutput.java */
/* loaded from: classes.dex */
public interface m {

    /* compiled from: TrackOutput.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f12728a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f12729b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12730c;

        /* renamed from: d, reason: collision with root package name */
        public final int f12731d;

        public a(int i10, byte[] bArr, int i11, int i12) {
            this.f12728a = i10;
            this.f12729b = bArr;
            this.f12730c = i11;
            this.f12731d = i12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12728a == aVar.f12728a && this.f12730c == aVar.f12730c && this.f12731d == aVar.f12731d && Arrays.equals(this.f12729b, aVar.f12729b);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f12729b) + (this.f12728a * 31)) * 31) + this.f12730c) * 31) + this.f12731d;
        }
    }

    void format(c5.i iVar);

    int sampleData(f fVar, int i10, boolean z10) throws InterruptedException, IOException;

    void sampleData(l6.l lVar, int i10);

    void sampleMetadata(long j10, int i10, int i11, int i12, a aVar);
}
