package com.google.gson.internal.bind;

import com.google.gson.JsonParseException;
import com.google.gson.i;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.t;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import v9.y;

/* loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends w<T> {

    /* renamed from: a, reason: collision with root package name */
    public final u<T> f10134a;

    /* renamed from: b, reason: collision with root package name */
    public final n<T> f10135b;

    /* renamed from: c, reason: collision with root package name */
    public final i f10136c;

    /* renamed from: d, reason: collision with root package name */
    public final y9.a<T> f10137d;

    /* renamed from: e, reason: collision with root package name */
    public final x f10138e;

    /* renamed from: f, reason: collision with root package name */
    public final TreeTypeAdapter<T>.a f10139f = new a();

    /* renamed from: g, reason: collision with root package name */
    public volatile w<T> f10140g;

    public static final class SingleTypeFactory implements x {

        /* renamed from: b, reason: collision with root package name */
        public final y9.a<?> f10141b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f10142m;

        /* renamed from: n, reason: collision with root package name */
        public final Class<?> f10143n;

        /* renamed from: o, reason: collision with root package name */
        public final u<?> f10144o;

        /* renamed from: p, reason: collision with root package name */
        public final n<?> f10145p;

        public SingleTypeFactory(Object obj, y9.a aVar, boolean z10) {
            u<?> uVar = obj instanceof u ? (u) obj : null;
            this.f10144o = uVar;
            n<?> nVar = obj instanceof n ? (n) obj : null;
            this.f10145p = nVar;
            v9.a.checkArgument((uVar == null && nVar == null) ? false : true);
            this.f10141b = aVar;
            this.f10142m = z10;
            this.f10143n = null;
        }

        @Override // com.google.gson.x
        public <T> w<T> create(i iVar, y9.a<T> aVar) {
            y9.a<?> aVar2 = this.f10141b;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f10142m && aVar2.getType() == aVar.getRawType()) : this.f10143n.isAssignableFrom(aVar.getRawType())) {
                return new TreeTypeAdapter(this.f10144o, this.f10145p, iVar, aVar, this);
            }
            return null;
        }
    }

    public final class a implements t, m {
    }

    public TreeTypeAdapter(u<T> uVar, n<T> nVar, i iVar, y9.a<T> aVar, x xVar) {
        this.f10134a = uVar;
        this.f10135b = nVar;
        this.f10136c = iVar;
        this.f10137d = aVar;
        this.f10138e = xVar;
    }

    public static x newFactoryWithMatchRawType(y9.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.getRawType());
    }

    @Override // com.google.gson.w
    public T read(z9.a aVar) throws JsonParseException, IOException {
        n<T> nVar = this.f10135b;
        if (nVar != null) {
            o oVar = y.parse(aVar);
            if (oVar.isJsonNull()) {
                return null;
            }
            return nVar.deserialize(oVar, this.f10137d.getType(), this.f10139f);
        }
        w<T> delegateAdapter = this.f10140g;
        if (delegateAdapter == null) {
            delegateAdapter = this.f10136c.getDelegateAdapter(this.f10138e, this.f10137d);
            this.f10140g = delegateAdapter;
        }
        return delegateAdapter.read(aVar);
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, T t10) throws IOException {
        u<T> uVar = this.f10134a;
        if (uVar != null) {
            if (t10 == null) {
                bVar.nullValue();
                return;
            } else {
                y.write(uVar.serialize(t10, this.f10137d.getType(), this.f10139f), bVar);
                return;
            }
        }
        w<T> delegateAdapter = this.f10140g;
        if (delegateAdapter == null) {
            delegateAdapter = this.f10136c.getDelegateAdapter(this.f10138e, this.f10137d);
            this.f10140g = delegateAdapter;
        }
        delegateAdapter.write(bVar, t10);
    }
}
