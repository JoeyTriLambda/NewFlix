package q7;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import v6.a;

/* compiled from: ShapeableDelegate.java */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: c, reason: collision with root package name */
    public l f18033c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f18031a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18032b = false;

    /* renamed from: d, reason: collision with root package name */
    public RectF f18034d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f18035e = new Path();

    public static q create(View view) {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 33 ? new t(view) : i10 >= 22 ? new s(view) : new r();
    }

    public abstract void a(View view);

    public abstract boolean b();

    public final void c() {
        RectF rectF = this.f18034d;
        if (!(rectF.left <= rectF.right && rectF.top <= rectF.bottom) || this.f18033c == null) {
            return;
        }
        m.getInstance().calculatePath(this.f18033c, 1.0f, this.f18034d, this.f18035e);
    }

    public void maybeClip(Canvas canvas, a.InterfaceC0296a interfaceC0296a) {
        if (b()) {
            Path path = this.f18035e;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                ((c1.c) interfaceC0296a).e(canvas);
                canvas.restore();
                return;
            }
        }
        ((c1.c) interfaceC0296a).e(canvas);
    }

    public void onMaskChanged(View view, RectF rectF) {
        this.f18034d = rectF;
        c();
        a(view);
    }

    public void onShapeAppearanceChanged(View view, l lVar) {
        this.f18033c = lVar;
        c();
        a(view);
    }

    public void setForceCompatClippingEnabled(View view, boolean z10) {
        if (z10 != this.f18031a) {
            this.f18031a = z10;
            a(view);
        }
    }

    public void setOffsetZeroCornerEdgeBoundsEnabled(View view, boolean z10) {
        this.f18032b = z10;
        a(view);
    }
}
