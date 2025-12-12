package u0;

import android.content.Context;
import java.util.concurrent.Callable;
import u0.l;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public final class j implements Callable<l.a> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19945b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f19946m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g f19947n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f19948o;

    public j(String str, Context context, g gVar, int i10) {
        this.f19945b = str;
        this.f19946m = context;
        this.f19947n = gVar;
        this.f19948o = i10;
    }

    @Override // java.util.concurrent.Callable
    public l.a call() {
        try {
            return l.a(this.f19945b, this.f19946m, this.f19947n, this.f19948o);
        } catch (Throwable unused) {
            return new l.a(-3);
        }
    }
}
