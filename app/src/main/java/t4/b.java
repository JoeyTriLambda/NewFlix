package t4;

import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: GlobalMetrics.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final d f19407a;

    /* compiled from: GlobalMetrics.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public d f19408a = null;

        public b build() {
            return new b(this.f19408a);
        }

        public a setStorageMetrics(d dVar) {
            this.f19408a = dVar;
            return this;
        }
    }

    static {
        new a().build();
    }

    public b(d dVar) {
        this.f19407a = dVar;
    }

    public static a newBuilder() {
        return new a();
    }

    @Protobuf
    public d getStorageMetricsInternal() {
        return this.f19407a;
    }
}
