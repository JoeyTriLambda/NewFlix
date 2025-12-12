package androidx.work.impl.background.systemalarm;

import android.content.Context;
import b3.e;
import w2.g;

/* compiled from: ConstraintsCommandHandler.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final String f4544d = g.tagWithPrefix("ConstraintsCmdHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f4545a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4546b;

    /* renamed from: c, reason: collision with root package name */
    public final e f4547c;

    public b(Context context, int i10, d dVar) {
        this.f4545a = context;
        this.f4546b = i10;
        this.f4547c = new e(dVar.f4566p.getTrackers(), (b3.c) null);
    }
}
