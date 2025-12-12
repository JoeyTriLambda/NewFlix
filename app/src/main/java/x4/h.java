package x4;

import a2.x;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import q4.o;
import z4.a;

/* compiled from: Uploader.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21531a;

    /* renamed from: b, reason: collision with root package name */
    public final r4.d f21532b;

    /* renamed from: c, reason: collision with root package name */
    public final y4.d f21533c;

    /* renamed from: d, reason: collision with root package name */
    public final l f21534d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f21535e;

    /* renamed from: f, reason: collision with root package name */
    public final z4.a f21536f;

    /* renamed from: g, reason: collision with root package name */
    public final a5.a f21537g;

    /* renamed from: h, reason: collision with root package name */
    public final a5.a f21538h;

    /* renamed from: i, reason: collision with root package name */
    public final y4.c f21539i;

    public h(Context context, r4.d dVar, y4.d dVar2, l lVar, Executor executor, z4.a aVar, a5.a aVar2, a5.a aVar3, y4.c cVar) {
        this.f21531a = context;
        this.f21532b = dVar;
        this.f21533c = dVar2;
        this.f21534d = lVar;
        this.f21535e = executor;
        this.f21536f = aVar;
        this.f21537g = aVar2;
        this.f21538h = aVar3;
        this.f21539i = cVar;
    }

    public q4.i createMetricsEvent(r4.k kVar) {
        y4.c cVar = this.f21539i;
        Objects.requireNonNull(cVar);
        return kVar.decorate(q4.i.builder().setEventMillis(this.f21537g.getTime()).setUptimeMillis(this.f21538h.getTime()).setTransportName("GDT_CLIENT_METRICS").setEncodedPayload(new q4.h(n4.b.of("proto"), ((t4.a) this.f21536f.runCriticalSection(new c1.c(cVar, 4))).toByteArray())).build());
    }

    public BackendResponse logAndUpdateState(final o oVar, int i10) {
        BackendResponse backendResponseSend;
        r4.k kVar = this.f21532b.get(oVar.getBackendName());
        BackendResponse backendResponseOk = BackendResponse.ok(0L);
        long j10 = 0;
        while (true) {
            final int i11 = 0;
            a.InterfaceC0331a interfaceC0331a = new a.InterfaceC0331a(this) { // from class: x4.e

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ h f21521m;

                {
                    this.f21521m = this;
                }

                @Override // z4.a.InterfaceC0331a
                public final Object execute() {
                    int i12 = i11;
                    o oVar2 = oVar;
                    h hVar = this.f21521m;
                    switch (i12) {
                        case 0:
                            return Boolean.valueOf(hVar.f21533c.hasPendingEventsFor(oVar2));
                        default:
                            return hVar.f21533c.loadBatch(oVar2);
                    }
                }
            };
            z4.a aVar = this.f21536f;
            if (!((Boolean) aVar.runCriticalSection(interfaceC0331a)).booleanValue()) {
                aVar.runCriticalSection(new g(this, j10, oVar));
                return backendResponseOk;
            }
            final int i12 = 1;
            Iterable iterable = (Iterable) aVar.runCriticalSection(new a.InterfaceC0331a(this) { // from class: x4.e

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ h f21521m;

                {
                    this.f21521m = this;
                }

                @Override // z4.a.InterfaceC0331a
                public final Object execute() {
                    int i122 = i12;
                    o oVar2 = oVar;
                    h hVar = this.f21521m;
                    switch (i122) {
                        case 0:
                            return Boolean.valueOf(hVar.f21533c.hasPendingEventsFor(oVar2));
                        default:
                            return hVar.f21533c.loadBatch(oVar2);
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return backendResponseOk;
            }
            if (kVar == null) {
                u4.a.d("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                backendResponseSend = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((y4.j) it.next()).getEvent());
                }
                if (oVar.shouldUploadClientHealthMetrics()) {
                    arrayList.add(createMetricsEvent(kVar));
                }
                backendResponseSend = kVar.send(r4.e.builder().setEvents(arrayList).setExtras(oVar.getExtras()).build());
            }
            backendResponseOk = backendResponseSend;
            if (backendResponseOk.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                aVar.runCriticalSection(new f(this, iterable, oVar, j10));
                this.f21534d.schedule(oVar, i10 + 1, true);
                return backendResponseOk;
            }
            aVar.runCriticalSection(new x(2, this, iterable));
            int i13 = 3;
            if (backendResponseOk.getStatus() == BackendResponse.Status.OK) {
                long jMax = Math.max(j10, backendResponseOk.getNextRequestWaitMillis());
                if (oVar.shouldUploadClientHealthMetrics()) {
                    aVar.runCriticalSection(new c1.c(this, i13));
                }
                j10 = jMax;
            } else if (backendResponseOk.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String transportName = ((y4.j) it2.next()).getEvent().getTransportName();
                    if (map.containsKey(transportName)) {
                        map.put(transportName, Integer.valueOf(((Integer) map.get(transportName)).intValue() + 1));
                    } else {
                        map.put(transportName, 1);
                    }
                }
                aVar.runCriticalSection(new x(i13, this, map));
            }
        }
    }

    public void upload(final o oVar, final int i10, final Runnable runnable) {
        this.f21535e.execute(new Runnable() { // from class: x4.c
            @Override // java.lang.Runnable
            public final void run() {
                final o oVar2 = oVar;
                final int i11 = i10;
                Runnable runnable2 = runnable;
                final h hVar = this.f21513b;
                z4.a aVar = hVar.f21536f;
                try {
                    try {
                        y4.d dVar = hVar.f21533c;
                        Objects.requireNonNull(dVar);
                        aVar.runCriticalSection(new c1.c(dVar, 2));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) hVar.f21531a.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            hVar.logAndUpdateState(oVar2, i11);
                        } else {
                            aVar.runCriticalSection(new a.InterfaceC0331a() { // from class: x4.d
                                @Override // z4.a.InterfaceC0331a
                                public final Object execute() {
                                    hVar.f21534d.schedule(oVar2, i11 + 1);
                                    return null;
                                }
                            });
                        }
                    } catch (SynchronizationException unused) {
                        hVar.f21534d.schedule(oVar2, i11 + 1);
                    }
                } finally {
                    runnable2.run();
                }
            }
        });
    }
}
