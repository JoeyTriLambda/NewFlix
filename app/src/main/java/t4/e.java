package t4;

import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: TimeWindow.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final long f19417a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19418b;

    /* compiled from: TimeWindow.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f19419a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f19420b = 0;

        public e build() {
            return new e(this.f19419a, this.f19420b);
        }

        public a setEndMs(long j10) {
            this.f19420b = j10;
            return this;
        }

        public a setStartMs(long j10) {
            this.f19419a = j10;
            return this;
        }
    }

    static {
        new a().build();
    }

    public e(long j10, long j11) {
        this.f19417a = j10;
        this.f19418b = j11;
    }

    public static a newBuilder() {
        return new a();
    }

    @Protobuf
    public long getEndMs() {
        return this.f19418b;
    }

    @Protobuf
    public long getStartMs() {
        return this.f19417a;
    }
}
