package n8;

import java.util.ArrayList;
import l8.p;

/* compiled from: AnalyticsDeferredProxy.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public volatile p8.a f16756a;

    /* renamed from: b, reason: collision with root package name */
    public volatile q8.b f16757b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f16758c;

    public b(h9.a<i8.a> aVar) {
        this(aVar, new q8.c(), new p8.f());
    }

    public p8.a getAnalyticsEventLogger() {
        return new a(this);
    }

    public q8.b getDeferredBreadcrumbSource() {
        return new a(this);
    }

    public b(h9.a<i8.a> aVar, q8.b bVar, p8.a aVar2) {
        this.f16757b = bVar;
        this.f16758c = new ArrayList();
        this.f16756a = aVar2;
        ((p) aVar).whenAvailable(new a(this));
    }
}
