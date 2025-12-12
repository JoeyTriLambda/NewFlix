package com.google.firebase.sessions;

import g8.c;
import g8.h;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.FunctionReferenceImpl;
import r9.l;
import r9.t;
import zf.f;
import zf.i;

/* compiled from: SessionGenerator.kt */
/* loaded from: classes.dex */
public final class SessionGenerator {

    /* renamed from: f, reason: collision with root package name */
    public static final a f9941f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final t f9942a;

    /* renamed from: b, reason: collision with root package name */
    public final yf.a<UUID> f9943b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9944c;

    /* renamed from: d, reason: collision with root package name */
    public int f9945d;

    /* renamed from: e, reason: collision with root package name */
    public l f9946e;

    /* compiled from: SessionGenerator.kt */
    /* renamed from: com.google.firebase.sessions.SessionGenerator$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements yf.a<UUID> {

        /* renamed from: u, reason: collision with root package name */
        public static final AnonymousClass1 f9947u = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        @Override // yf.a
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    /* compiled from: SessionGenerator.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final SessionGenerator getInstance() {
            Object obj = h.getApp(c.f12778a).get(SessionGenerator.class);
            i.checkNotNullExpressionValue(obj, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) obj;
        }
    }

    public SessionGenerator(t tVar, yf.a<UUID> aVar) {
        i.checkNotNullParameter(tVar, "timeProvider");
        i.checkNotNullParameter(aVar, "uuidGenerator");
        this.f9942a = tVar;
        this.f9943b = aVar;
        this.f9944c = a();
        this.f9945d = -1;
    }

    public final String a() {
        String string = this.f9943b.invoke().toString();
        i.checkNotNullExpressionValue(string, "uuidGenerator().toString()");
        String lowerCase = ig.l.replace$default(string, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final l generateNewSession() {
        int i10 = this.f9945d + 1;
        this.f9945d = i10;
        this.f9946e = new l(i10 == 0 ? this.f9944c : a(), this.f9944c, this.f9945d, this.f9942a.currentTimeUs());
        return getCurrentSession();
    }

    public final l getCurrentSession() {
        l lVar = this.f9946e;
        if (lVar != null) {
            return lVar;
        }
        i.throwUninitializedPropertyAccessException("currentSession");
        return null;
    }

    public /* synthetic */ SessionGenerator(t tVar, yf.a aVar, int i10, f fVar) {
        this(tVar, (i10 & 2) != 0 ? AnonymousClass1.f9947u : aVar);
    }
}
