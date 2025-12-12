package xa;

import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: LoaderView.java */
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public int f21676a;

    /* renamed from: b, reason: collision with root package name */
    public int f21677b;

    /* renamed from: c, reason: collision with root package name */
    public int f21678c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21679d = 150;

    /* renamed from: e, reason: collision with root package name */
    public final int f21680e = 150;

    /* renamed from: f, reason: collision with root package name */
    public PointF f21681f;

    /* renamed from: g, reason: collision with root package name */
    public va.a f21682g;

    public abstract void draw(Canvas canvas);

    public int getDesiredHeight() {
        return this.f21680e;
    }

    public int getDesiredWidth() {
        return this.f21679d;
    }

    public abstract void initializeObjects();

    public void setColor(int i10) {
        this.f21676a = i10;
    }

    public void setInvalidateListener(va.a aVar) {
        this.f21682g = aVar;
    }

    public void setSize(int i10, int i11) {
        this.f21677b = i10;
        this.f21678c = i11;
        this.f21681f = new PointF(i10 / 2.0f, i11 / 2.0f);
    }

    public abstract void setUpAnimation();
}
