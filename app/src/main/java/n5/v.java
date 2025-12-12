package n5;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* compiled from: TsPayloadReader.java */
/* loaded from: classes.dex */
public interface v {

    /* compiled from: TsPayloadReader.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f16721a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f16722b;

        public a(String str, int i10, byte[] bArr) {
            this.f16721a = str;
            this.f16722b = bArr;
        }
    }

    /* compiled from: TsPayloadReader.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f16723a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16724b;

        /* renamed from: c, reason: collision with root package name */
        public final List<a> f16725c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f16726d;

        public b(int i10, String str, List<a> list, byte[] bArr) {
            this.f16723a = i10;
            this.f16724b = str;
            this.f16725c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f16726d = bArr;
        }
    }

    /* compiled from: TsPayloadReader.java */
    public interface c {
        SparseArray<v> createInitialPayloadReaders();

        v createPayloadReader(int i10, b bVar);
    }

    /* compiled from: TsPayloadReader.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f16727a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16728b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16729c;

        /* renamed from: d, reason: collision with root package name */
        public int f16730d;

        /* renamed from: e, reason: collision with root package name */
        public String f16731e;

        public d(int i10, int i11) {
            this(Integer.MIN_VALUE, i10, i11);
        }

        public void generateNewId() {
            int i10 = this.f16730d;
            this.f16730d = i10 == Integer.MIN_VALUE ? this.f16728b : i10 + this.f16729c;
            this.f16731e = this.f16727a + this.f16730d;
        }

        public String getFormatId() {
            if (this.f16730d != Integer.MIN_VALUE) {
                return this.f16731e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public int getTrackId() {
            int i10 = this.f16730d;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public d(int i10, int i11, int i12) {
            String str;
            if (i10 != Integer.MIN_VALUE) {
                str = i10 + "/";
            } else {
                str = "";
            }
            this.f16727a = str;
            this.f16728b = i11;
            this.f16729c = i12;
            this.f16730d = Integer.MIN_VALUE;
        }
    }

    void consume(l6.l lVar, boolean z10);

    void init(l6.r rVar, g5.g gVar, d dVar);

    void seek();
}
