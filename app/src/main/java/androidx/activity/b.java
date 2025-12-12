package androidx.activity;

import android.window.BackEvent;

/* compiled from: BackEventCompat.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f802a;

    /* renamed from: b, reason: collision with root package name */
    public final float f803b;

    /* renamed from: c, reason: collision with root package name */
    public final float f804c;

    /* renamed from: d, reason: collision with root package name */
    public final int f805d;

    /* compiled from: BackEventCompat.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
    }

    public b(float f10, float f11, float f12, int i10) {
        this.f802a = f10;
        this.f803b = f11;
        this.f804c = f12;
        this.f805d = i10;
    }

    public final float getProgress() {
        return this.f804c;
    }

    public final int getSwipeEdge() {
        return this.f805d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BackEventCompat{touchX=");
        sb2.append(this.f802a);
        sb2.append(", touchY=");
        sb2.append(this.f803b);
        sb2.append(", progress=");
        sb2.append(this.f804c);
        sb2.append(", swipeEdge=");
        return ac.c.l(sb2, this.f805d, '}');
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        zf.i.checkNotNullParameter(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f801a;
        this(aVar.touchX(backEvent), aVar.touchY(backEvent), aVar.progress(backEvent), aVar.swipeEdge(backEvent));
    }
}
