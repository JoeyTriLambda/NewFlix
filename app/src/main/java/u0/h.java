package u0;

import android.content.Context;
import java.util.concurrent.Callable;
import u0.l;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public final class h implements Callable<l.a> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19940b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f19941m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g f19942n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f19943o;

    public h(String str, Context context, g gVar, int i10) {
        this.f19940b = str;
        this.f19941m = context;
        this.f19942n = gVar;
        this.f19943o = i10;
    }

    @Override // java.util.concurrent.Callable
    public l.a call() {
        return l.a(this.f19940b, this.f19941m, this.f19942n, this.f19943o);
    }
}
