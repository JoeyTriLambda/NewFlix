package v5;

import com.google.android.exoplayer2.upstream.Loader;

/* compiled from: Chunk.java */
/* loaded from: classes.dex */
public abstract class c implements Loader.c {

    /* renamed from: a, reason: collision with root package name */
    public final k6.f f20466a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20467b;

    /* renamed from: c, reason: collision with root package name */
    public final c5.i f20468c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20469d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f20470e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20471f;

    /* renamed from: g, reason: collision with root package name */
    public final long f20472g;

    /* renamed from: h, reason: collision with root package name */
    public final k6.d f20473h;

    public c(k6.d dVar, k6.f fVar, int i10, c5.i iVar, int i11, Object obj, long j10, long j11) {
        this.f20473h = (k6.d) l6.a.checkNotNull(dVar);
        this.f20466a = (k6.f) l6.a.checkNotNull(fVar);
        this.f20467b = i10;
        this.f20468c = iVar;
        this.f20469d = i11;
        this.f20470e = obj;
        this.f20471f = j10;
        this.f20472g = j11;
    }

    public abstract long bytesLoaded();
}
