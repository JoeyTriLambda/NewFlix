package t4;

import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: StorageMetrics.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final long f19413a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19414b;

    /* compiled from: StorageMetrics.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f19415a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f19416b = 0;

        public d build() {
            return new d(this.f19415a, this.f19416b);
        }

        public a setCurrentCacheSizeBytes(long j10) {
            this.f19415a = j10;
            return this;
        }

        public a setMaxCacheSizeBytes(long j10) {
            this.f19416b = j10;
            return this;
        }
    }

    static {
        new a().build();
    }

    public d(long j10, long j11) {
        this.f19413a = j10;
        this.f19414b = j11;
    }

    public static a newBuilder() {
        return new a();
    }

    @Protobuf
    public long getCurrentCacheSizeBytes() {
        return this.f19413a;
    }

    @Protobuf
    public long getMaxCacheSizeBytes() {
        return this.f19414b;
    }
}
