package q4;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import java.io.IOException;

/* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
/* loaded from: classes.dex */
public final class a implements c9.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f17800a = new a();

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    /* renamed from: q4.a$a, reason: collision with other inner class name */
    public static final class C0228a implements b9.d<t4.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0228a f17801a = new C0228a();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17802b = b9.c.builder("window").withProperty(com.google.firebase.encoders.proto.a.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f17803c = b9.c.builder("logSourceMetrics").withProperty(com.google.firebase.encoders.proto.a.builder().tag(2).build()).build();

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f17804d = b9.c.builder("globalMetrics").withProperty(com.google.firebase.encoders.proto.a.builder().tag(3).build()).build();

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f17805e = b9.c.builder("appNamespace").withProperty(com.google.firebase.encoders.proto.a.builder().tag(4).build()).build();

        @Override // b9.b
        public void encode(t4.a aVar, b9.e eVar) throws IOException {
            eVar.add(f17802b, aVar.getWindowInternal());
            eVar.add(f17803c, aVar.getLogSourceMetricsList());
            eVar.add(f17804d, aVar.getGlobalMetricsInternal());
            eVar.add(f17805e, aVar.getAppNamespace());
        }
    }

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    public static final class b implements b9.d<t4.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f17806a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17807b = b9.c.builder("storageMetrics").withProperty(com.google.firebase.encoders.proto.a.builder().tag(1).build()).build();

        @Override // b9.b
        public void encode(t4.b bVar, b9.e eVar) throws IOException {
            eVar.add(f17807b, bVar.getStorageMetricsInternal());
        }
    }

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    public static final class c implements b9.d<LogEventDropped> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f17808a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17809b = b9.c.builder("eventsDroppedCount").withProperty(com.google.firebase.encoders.proto.a.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f17810c = b9.c.builder("reason").withProperty(com.google.firebase.encoders.proto.a.builder().tag(3).build()).build();

        @Override // b9.b
        public void encode(LogEventDropped logEventDropped, b9.e eVar) throws IOException {
            eVar.add(f17809b, logEventDropped.getEventsDroppedCount());
            eVar.add(f17810c, logEventDropped.getReason());
        }
    }

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    public static final class d implements b9.d<t4.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f17811a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17812b = b9.c.builder("logSource").withProperty(com.google.firebase.encoders.proto.a.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f17813c = b9.c.builder("logEventDropped").withProperty(com.google.firebase.encoders.proto.a.builder().tag(2).build()).build();

        @Override // b9.b
        public void encode(t4.c cVar, b9.e eVar) throws IOException {
            eVar.add(f17812b, cVar.getLogSource());
            eVar.add(f17813c, cVar.getLogEventDroppedList());
        }
    }

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    public static final class e implements b9.d<l> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f17814a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17815b = b9.c.of("clientMetrics");

        @Override // b9.b
        public void encode(l lVar, b9.e eVar) throws IOException {
            eVar.add(f17815b, lVar.getClientMetrics());
        }
    }

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    public static final class f implements b9.d<t4.d> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f17816a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17817b = b9.c.builder("currentCacheSizeBytes").withProperty(com.google.firebase.encoders.proto.a.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f17818c = b9.c.builder("maxCacheSizeBytes").withProperty(com.google.firebase.encoders.proto.a.builder().tag(2).build()).build();

        @Override // b9.b
        public void encode(t4.d dVar, b9.e eVar) throws IOException {
            eVar.add(f17817b, dVar.getCurrentCacheSizeBytes());
            eVar.add(f17818c, dVar.getMaxCacheSizeBytes());
        }
    }

    /* compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    public static final class g implements b9.d<t4.e> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f17819a = new g();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f17820b = b9.c.builder("startMs").withProperty(com.google.firebase.encoders.proto.a.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f17821c = b9.c.builder("endMs").withProperty(com.google.firebase.encoders.proto.a.builder().tag(2).build()).build();

        @Override // b9.b
        public void encode(t4.e eVar, b9.e eVar2) throws IOException {
            eVar2.add(f17820b, eVar.getStartMs());
            eVar2.add(f17821c, eVar.getEndMs());
        }
    }

    @Override // c9.a
    public void configure(c9.b<?> bVar) {
        bVar.registerEncoder(l.class, e.f17814a);
        bVar.registerEncoder(t4.a.class, C0228a.f17801a);
        bVar.registerEncoder(t4.e.class, g.f17819a);
        bVar.registerEncoder(t4.c.class, d.f17811a);
        bVar.registerEncoder(LogEventDropped.class, c.f17808a);
        bVar.registerEncoder(t4.b.class, b.f17806a);
        bVar.registerEncoder(t4.d.class, f.f17816a);
    }
}
