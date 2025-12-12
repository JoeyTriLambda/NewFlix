package t4;

import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q4.l;

/* compiled from: ClientMetrics.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final e f19399a;

    /* renamed from: b, reason: collision with root package name */
    public final List<c> f19400b;

    /* renamed from: c, reason: collision with root package name */
    public final b f19401c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19402d;

    /* compiled from: ClientMetrics.java */
    /* renamed from: t4.a$a, reason: collision with other inner class name */
    public static final class C0257a {

        /* renamed from: a, reason: collision with root package name */
        public e f19403a = null;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f19404b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public b f19405c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f19406d = "";

        public C0257a addLogSourceMetrics(c cVar) {
            this.f19404b.add(cVar);
            return this;
        }

        public a build() {
            return new a(this.f19403a, Collections.unmodifiableList(this.f19404b), this.f19405c, this.f19406d);
        }

        public C0257a setAppNamespace(String str) {
            this.f19406d = str;
            return this;
        }

        public C0257a setGlobalMetrics(b bVar) {
            this.f19405c = bVar;
            return this;
        }

        public C0257a setWindow(e eVar) {
            this.f19403a = eVar;
            return this;
        }
    }

    static {
        new C0257a().build();
    }

    public a(e eVar, List<c> list, b bVar, String str) {
        this.f19399a = eVar;
        this.f19400b = list;
        this.f19401c = bVar;
        this.f19402d = str;
    }

    public static C0257a newBuilder() {
        return new C0257a();
    }

    @Protobuf
    public String getAppNamespace() {
        return this.f19402d;
    }

    @Protobuf
    public b getGlobalMetricsInternal() {
        return this.f19401c;
    }

    @Protobuf
    public List<c> getLogSourceMetricsList() {
        return this.f19400b;
    }

    @Protobuf
    public e getWindowInternal() {
        return this.f19399a;
    }

    public byte[] toByteArray() {
        return l.encode(this);
    }
}
