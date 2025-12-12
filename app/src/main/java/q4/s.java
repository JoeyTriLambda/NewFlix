package q4;

import android.content.Context;
import java.util.Collections;
import q4.e;

/* compiled from: TransportRuntime.java */
/* loaded from: classes.dex */
public final class s implements r {

    /* renamed from: e, reason: collision with root package name */
    public static volatile t f17876e;

    /* renamed from: a, reason: collision with root package name */
    public final a5.a f17877a;

    /* renamed from: b, reason: collision with root package name */
    public final a5.a f17878b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.d f17879c;

    /* renamed from: d, reason: collision with root package name */
    public final x4.h f17880d;

    public s(a5.a aVar, a5.a aVar2, w4.d dVar, x4.h hVar, x4.j jVar) {
        this.f17877a = aVar;
        this.f17878b = aVar2;
        this.f17879c = dVar;
        this.f17880d = hVar;
        jVar.ensureContextsScheduled();
    }

    public static s getInstance() {
        t tVar = f17876e;
        if (tVar != null) {
            return ((e) tVar).f17860v.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (f17876e == null) {
            synchronized (s.class) {
                if (f17876e == null) {
                    f17876e = ((e.a) ((e.a) e.builder()).m236setApplicationContext(context)).build();
                }
            }
        }
    }

    public x4.h getUploader() {
        return this.f17880d;
    }

    public n4.f newFactory(f fVar) {
        return new p(fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).getSupportedEncodings()) : Collections.singleton(n4.b.of("proto")), o.builder().setBackendName(fVar.getName()).setExtras(fVar.getExtras()).build(), this);
    }

    public void send(n nVar, n4.g gVar) {
        this.f17879c.schedule(nVar.getTransportContext().withPriority(nVar.a().getPriority()), i.builder().setEventMillis(this.f17877a.getTime()).setUptimeMillis(this.f17878b.getTime()).setTransportName(nVar.getTransportName()).setEncodedPayload(new h(nVar.getEncoding(), nVar.getPayload())).setCode(nVar.a().getCode()).build(), gVar);
    }
}
