package a7;

import a7.c;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* compiled from: CircularRevealFrameLayout.java */
/* loaded from: classes.dex */
public class b extends FrameLayout implements c {
    @Override // a7.c
    public void buildCircularRevealCache() {
        throw null;
    }

    @Override // a7.c
    public void destroyCircularRevealCache() {
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        throw null;
    }

    @Override // a7.c
    public int getCircularRevealScrimColor() {
        throw null;
    }

    @Override // a7.c
    public c.d getRevealInfo() {
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        return super.isOpaque();
    }

    @Override // a7.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        throw null;
    }

    @Override // a7.c
    public void setCircularRevealScrimColor(int i10) {
        throw null;
    }

    @Override // a7.c
    public void setRevealInfo(c.d dVar) {
        throw null;
    }
}
