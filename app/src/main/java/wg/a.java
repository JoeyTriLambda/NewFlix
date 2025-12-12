package wg;

import xg.o;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f21149a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21150b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21151c;

    /* renamed from: d, reason: collision with root package name */
    public final c f21152d;

    /* renamed from: e, reason: collision with root package name */
    public final yg.b f21153e;

    public a(int i10, String str, int i11, c cVar, yg.b bVar) {
        zf.i.checkNotNullParameter(str, "host");
        zf.i.checkNotNullParameter(cVar, "listener");
        zf.i.checkNotNullParameter(bVar, "socketRepository");
        this.f21149a = i10;
        this.f21150b = str;
        this.f21151c = i11;
        this.f21152d = cVar;
        this.f21153e = bVar;
    }

    public abstract void a();

    public abstract void a(o oVar);

    public abstract void a(byte[] bArr, long j10);

    public abstract void b();
}
