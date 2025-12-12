package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kg.c1;
import l8.g;
import l8.l;
import l8.r;
import mf.k;
import zf.i;

/* compiled from: Firebase.kt */
@Keep
/* loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* compiled from: Firebase.kt */
    public static final class a<T> implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final a<T> f9865a = new a<>();

        @Override // l8.g
        public final kotlinx.coroutines.b create(l8.d dVar) {
            Object obj = dVar.get(r.qualified(k8.a.class, Executor.class));
            i.checkNotNullExpressionValue(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return c1.from((Executor) obj);
        }
    }

    /* compiled from: Firebase.kt */
    public static final class b<T> implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final b<T> f9866a = new b<>();

        @Override // l8.g
        public final kotlinx.coroutines.b create(l8.d dVar) {
            Object obj = dVar.get(r.qualified(k8.c.class, Executor.class));
            i.checkNotNullExpressionValue(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return c1.from((Executor) obj);
        }
    }

    /* compiled from: Firebase.kt */
    public static final class c<T> implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final c<T> f9867a = new c<>();

        @Override // l8.g
        public final kotlinx.coroutines.b create(l8.d dVar) {
            Object obj = dVar.get(r.qualified(k8.b.class, Executor.class));
            i.checkNotNullExpressionValue(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return c1.from((Executor) obj);
        }
    }

    /* compiled from: Firebase.kt */
    public static final class d<T> implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final d<T> f9868a = new d<>();

        @Override // l8.g
        public final kotlinx.coroutines.b create(l8.d dVar) {
            Object obj = dVar.get(r.qualified(k8.d.class, Executor.class));
            i.checkNotNullExpressionValue(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return c1.from((Executor) obj);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<l8.b<?>> getComponents() {
        l8.b bVarBuild = l8.b.builder(r.qualified(k8.a.class, kotlinx.coroutines.b.class)).add(l.required((r<?>) r.qualified(k8.a.class, Executor.class))).factory(a.f9865a).build();
        i.checkNotNullExpressionValue(bVarBuild, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        l8.b bVarBuild2 = l8.b.builder(r.qualified(k8.c.class, kotlinx.coroutines.b.class)).add(l.required((r<?>) r.qualified(k8.c.class, Executor.class))).factory(b.f9866a).build();
        i.checkNotNullExpressionValue(bVarBuild2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        l8.b bVarBuild3 = l8.b.builder(r.qualified(k8.b.class, kotlinx.coroutines.b.class)).add(l.required((r<?>) r.qualified(k8.b.class, Executor.class))).factory(c.f9867a).build();
        i.checkNotNullExpressionValue(bVarBuild3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        l8.b bVarBuild4 = l8.b.builder(r.qualified(k8.d.class, kotlinx.coroutines.b.class)).add(l.required((r<?>) r.qualified(k8.d.class, Executor.class))).factory(d.f9868a).build();
        i.checkNotNullExpressionValue(bVarBuild4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return k.listOf((Object[]) new l8.b[]{bVarBuild, bVarBuild2, bVarBuild3, bVarBuild4});
    }
}
