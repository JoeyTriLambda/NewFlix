package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.io.InputStream;
import k6.d;
import k6.e;
import k6.f;
import l6.u;

/* compiled from: ParsingLoadable.java */
/* loaded from: classes.dex */
public final class a<T> implements Loader.c {

    /* renamed from: a, reason: collision with root package name */
    public final f f6042a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6043b;

    /* renamed from: c, reason: collision with root package name */
    public final d f6044c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0074a<? extends T> f6045d;

    /* renamed from: e, reason: collision with root package name */
    public volatile T f6046e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f6047f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f6048g;

    /* compiled from: ParsingLoadable.java */
    /* renamed from: com.google.android.exoplayer2.upstream.a$a, reason: collision with other inner class name */
    public interface InterfaceC0074a<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public a(d dVar, Uri uri, int i10, InterfaceC0074a<? extends T> interfaceC0074a) {
        this.f6044c = dVar;
        this.f6042a = new f(uri, 1);
        this.f6043b = i10;
        this.f6045d = interfaceC0074a;
    }

    public long bytesLoaded() {
        return this.f6048g;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.f6047f = true;
    }

    public final T getResult() {
        return this.f6046e;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean isLoadCanceled() {
        return this.f6047f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws InterruptedException, IOException {
        e eVar = new e(this.f6044c, this.f6042a);
        try {
            eVar.open();
            this.f6046e = this.f6045d.parse(this.f6044c.getUri(), eVar);
        } finally {
            this.f6048g = eVar.bytesRead();
            u.closeQuietly(eVar);
        }
    }
}
