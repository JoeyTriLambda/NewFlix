package l4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: SpriteContainer.java */
/* loaded from: classes.dex */
public abstract class g extends f {
    public final f[] M;
    public int N;

    public g() {
        f[] fVarArrOnCreateChild = onCreateChild();
        this.M = fVarArrOnCreateChild;
        if (fVarArrOnCreateChild != null) {
            for (f fVar : fVarArrOnCreateChild) {
                fVar.setCallback(this);
            }
        }
        onChildCreated(this.M);
    }

    @Override // l4.f, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawChild(canvas);
    }

    public void drawChild(Canvas canvas) {
        f[] fVarArr = this.M;
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                int iSave = canvas.save();
                fVar.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
    }

    public f getChildAt(int i10) {
        f[] fVarArr = this.M;
        if (fVarArr == null) {
            return null;
        }
        return fVarArr[i10];
    }

    public int getChildCount() {
        f[] fVarArr = this.M;
        if (fVarArr == null) {
            return 0;
        }
        return fVarArr.length;
    }

    @Override // l4.f
    public int getColor() {
        return this.N;
    }

    @Override // l4.f, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return j4.a.isRunning(this.M) || super.isRunning();
    }

    @Override // l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (f fVar : this.M) {
            fVar.setBounds(rect);
        }
    }

    @Override // l4.f
    public ValueAnimator onCreateAnimation() {
        return null;
    }

    public abstract f[] onCreateChild();

    @Override // l4.f
    public void setColor(int i10) {
        this.N = i10;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            getChildAt(i11).setColor(i10);
        }
    }

    @Override // l4.f, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        j4.a.start(this.M);
    }

    @Override // l4.f, android.graphics.drawable.Animatable
    public void stop() {
        super.stop();
        j4.a.stop(this.M);
    }

    @Override // l4.f
    public void drawSelf(Canvas canvas) {
    }

    public void onChildCreated(f... fVarArr) {
    }
}
