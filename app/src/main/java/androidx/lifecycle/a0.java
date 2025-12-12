package androidx.lifecycle;

import android.app.Application;
import u1.a;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f3482a;

    /* renamed from: b, reason: collision with root package name */
    public final b f3483b;

    /* renamed from: c, reason: collision with root package name */
    public final u1.a f3484c;

    /* compiled from: ViewModelProvider.kt */
    public static class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final C0031a.C0032a f3485b;

        /* compiled from: ViewModelProvider.kt */
        /* renamed from: androidx.lifecycle.a0$a$a, reason: collision with other inner class name */
        public static final class C0031a {

            /* compiled from: ViewModelProvider.kt */
            /* renamed from: androidx.lifecycle.a0$a$a$a, reason: collision with other inner class name */
            public static final class C0032a implements a.b<Application> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0032a f3486a = new C0032a();
            }

            public C0031a(zf.f fVar) {
            }
        }

        static {
            new C0031a(null);
            f3485b = C0031a.C0032a.f3486a;
        }
    }

    /* compiled from: ViewModelProvider.kt */
    public interface b {
        <T extends z> T create(Class<T> cls);

        <T extends z> T create(Class<T> cls, u1.a aVar);
    }

    /* compiled from: ViewModelProvider.kt */
    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final a.C0033a f3487a;

        /* compiled from: ViewModelProvider.kt */
        public static final class a {

            /* compiled from: ViewModelProvider.kt */
            /* renamed from: androidx.lifecycle.a0$c$a$a, reason: collision with other inner class name */
            public static final class C0033a implements a.b<String> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0033a f3488a = new C0033a();
            }

            public a(zf.f fVar) {
            }
        }

        static {
            new a(null);
            f3487a = a.C0033a.f3488a;
        }
    }

    /* compiled from: ViewModelProvider.kt */
    public static class d {
        public void onRequery(z zVar) {
            zf.i.checkNotNullParameter(zVar, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(d0 d0Var, b bVar) {
        this(d0Var, bVar, null, 4, null);
        zf.i.checkNotNullParameter(d0Var, "store");
        zf.i.checkNotNullParameter(bVar, "factory");
    }

    public <T extends z> T get(Class<T> cls) {
        zf.i.checkNotNullParameter(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public a0(d0 d0Var, b bVar, u1.a aVar) {
        zf.i.checkNotNullParameter(d0Var, "store");
        zf.i.checkNotNullParameter(bVar, "factory");
        zf.i.checkNotNullParameter(aVar, "defaultCreationExtras");
        this.f3482a = d0Var;
        this.f3483b = bVar;
        this.f3484c = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends z> T get(String str, Class<T> cls) {
        T t10;
        zf.i.checkNotNullParameter(str, "key");
        zf.i.checkNotNullParameter(cls, "modelClass");
        d0 d0Var = this.f3482a;
        T t11 = (T) d0Var.get(str);
        boolean zIsInstance = cls.isInstance(t11);
        b bVar = this.f3483b;
        if (zIsInstance) {
            d dVar = bVar instanceof d ? (d) bVar : null;
            if (dVar != null) {
                zf.i.checkNotNull(t11);
                dVar.onRequery(t11);
            }
            zf.i.checkNotNull(t11, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t11;
        }
        u1.d dVar2 = new u1.d(this.f3484c);
        dVar2.set(c.f3487a, str);
        try {
            t10 = (T) bVar.create(cls, dVar2);
        } catch (AbstractMethodError unused) {
            t10 = (T) bVar.create(cls);
        }
        d0Var.put(str, t10);
        return t10;
    }

    public /* synthetic */ a0(d0 d0Var, b bVar, u1.a aVar, int i10, zf.f fVar) {
        this(d0Var, bVar, (i10 & 4) != 0 ? a.C0283a.f19972b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(e0 e0Var, b bVar) {
        this(e0Var.getViewModelStore(), bVar, c0.defaultCreationExtras(e0Var));
        zf.i.checkNotNullParameter(e0Var, "owner");
        zf.i.checkNotNullParameter(bVar, "factory");
    }
}
