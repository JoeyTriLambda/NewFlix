package u0;

import android.graphics.Typeface;
import u0.m;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m.c f19925b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Typeface f19926m;

    public a(m.c cVar, Typeface typeface) {
        this.f19925b = cVar;
        this.f19926m = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19925b.onTypefaceRetrieved(this.f19926m);
    }
}
