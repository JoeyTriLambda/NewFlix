package com.google.android.datatransport.cct.internal;

import java.io.IOException;
import p4.g;
import p4.h;
import p4.i;

/* compiled from: AutoBatchedLogRequestEncoder.java */
/* loaded from: classes.dex */
public final class a implements c9.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5622a = new a();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: com.google.android.datatransport.cct.internal.a$a, reason: collision with other inner class name */
    public static final class C0067a implements b9.d<p4.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0067a f5623a = new C0067a();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f5624b = b9.c.of("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f5625c = b9.c.of("model");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f5626d = b9.c.of("hardware");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f5627e = b9.c.of("device");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f5628f = b9.c.of("product");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f5629g = b9.c.of("osBuild");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f5630h = b9.c.of("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        public static final b9.c f5631i = b9.c.of("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        public static final b9.c f5632j = b9.c.of("locale");

        /* renamed from: k, reason: collision with root package name */
        public static final b9.c f5633k = b9.c.of("country");

        /* renamed from: l, reason: collision with root package name */
        public static final b9.c f5634l = b9.c.of("mccMnc");

        /* renamed from: m, reason: collision with root package name */
        public static final b9.c f5635m = b9.c.of("applicationBuild");

        @Override // b9.b
        public void encode(p4.a aVar, b9.e eVar) throws IOException {
            eVar.add(f5624b, aVar.getSdkVersion());
            eVar.add(f5625c, aVar.getModel());
            eVar.add(f5626d, aVar.getHardware());
            eVar.add(f5627e, aVar.getDevice());
            eVar.add(f5628f, aVar.getProduct());
            eVar.add(f5629g, aVar.getOsBuild());
            eVar.add(f5630h, aVar.getManufacturer());
            eVar.add(f5631i, aVar.getFingerprint());
            eVar.add(f5632j, aVar.getLocale());
            eVar.add(f5633k, aVar.getCountry());
            eVar.add(f5634l, aVar.getMccMnc());
            eVar.add(f5635m, aVar.getApplicationBuild());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class b implements b9.d<g> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5636a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f5637b = b9.c.of("logRequest");

        @Override // b9.b
        public void encode(g gVar, b9.e eVar) throws IOException {
            eVar.add(f5637b, gVar.getLogRequests());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class c implements b9.d<ClientInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5638a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f5639b = b9.c.of("clientType");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f5640c = b9.c.of("androidClientInfo");

        @Override // b9.b
        public void encode(ClientInfo clientInfo, b9.e eVar) throws IOException {
            eVar.add(f5639b, clientInfo.getClientType());
            eVar.add(f5640c, clientInfo.getAndroidClientInfo());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class d implements b9.d<h> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f5641a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f5642b = b9.c.of("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f5643c = b9.c.of("eventCode");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f5644d = b9.c.of("eventUptimeMs");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f5645e = b9.c.of("sourceExtension");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f5646f = b9.c.of("sourceExtensionJsonProto3");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f5647g = b9.c.of("timezoneOffsetSeconds");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f5648h = b9.c.of("networkConnectionInfo");

        @Override // b9.b
        public void encode(h hVar, b9.e eVar) throws IOException {
            eVar.add(f5642b, hVar.getEventTimeMs());
            eVar.add(f5643c, hVar.getEventCode());
            eVar.add(f5644d, hVar.getEventUptimeMs());
            eVar.add(f5645e, hVar.getSourceExtension());
            eVar.add(f5646f, hVar.getSourceExtensionJsonProto3());
            eVar.add(f5647g, hVar.getTimezoneOffsetSeconds());
            eVar.add(f5648h, hVar.getNetworkConnectionInfo());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class e implements b9.d<i> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f5649a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f5650b = b9.c.of("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f5651c = b9.c.of("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f5652d = b9.c.of("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f5653e = b9.c.of("logSource");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f5654f = b9.c.of("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f5655g = b9.c.of("logEvent");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f5656h = b9.c.of("qosTier");

        @Override // b9.b
        public void encode(i iVar, b9.e eVar) throws IOException {
            eVar.add(f5650b, iVar.getRequestTimeMs());
            eVar.add(f5651c, iVar.getRequestUptimeMs());
            eVar.add(f5652d, iVar.getClientInfo());
            eVar.add(f5653e, iVar.getLogSource());
            eVar.add(f5654f, iVar.getLogSourceName());
            eVar.add(f5655g, iVar.getLogEvents());
            eVar.add(f5656h, iVar.getQosTier());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class f implements b9.d<NetworkConnectionInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f5657a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f5658b = b9.c.of("networkType");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f5659c = b9.c.of("mobileSubtype");

        @Override // b9.b
        public void encode(NetworkConnectionInfo networkConnectionInfo, b9.e eVar) throws IOException {
            eVar.add(f5658b, networkConnectionInfo.getNetworkType());
            eVar.add(f5659c, networkConnectionInfo.getMobileSubtype());
        }
    }

    @Override // c9.a
    public void configure(c9.b<?> bVar) {
        b bVar2 = b.f5636a;
        bVar.registerEncoder(g.class, bVar2);
        bVar.registerEncoder(p4.c.class, bVar2);
        e eVar = e.f5649a;
        bVar.registerEncoder(i.class, eVar);
        bVar.registerEncoder(p4.e.class, eVar);
        c cVar = c.f5638a;
        bVar.registerEncoder(ClientInfo.class, cVar);
        bVar.registerEncoder(com.google.android.datatransport.cct.internal.b.class, cVar);
        C0067a c0067a = C0067a.f5623a;
        bVar.registerEncoder(p4.a.class, c0067a);
        bVar.registerEncoder(p4.b.class, c0067a);
        d dVar = d.f5641a;
        bVar.registerEncoder(h.class, dVar);
        bVar.registerEncoder(p4.d.class, dVar);
        f fVar = f.f5657a;
        bVar.registerEncoder(NetworkConnectionInfo.class, fVar);
        bVar.registerEncoder(com.google.android.datatransport.cct.internal.c.class, fVar);
    }
}
