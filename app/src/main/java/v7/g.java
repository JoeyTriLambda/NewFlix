package v7;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import q7.g;

/* compiled from: CutoutDrawable.java */
/* loaded from: classes.dex */
public class g extends q7.g {
    public static final /* synthetic */ int K = 0;
    public a J;

    /* compiled from: CutoutDrawable.java */
    @TargetApi(18)
    public static class b extends g {
        public b(a aVar) {
            super(aVar);
        }

        @Override // q7.g
        public void drawStrokeShape(Canvas canvas) {
            if (this.J.f20540v.isEmpty()) {
                super.drawStrokeShape(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.J.f20540v);
            } else {
                canvas.clipRect(this.J.f20540v, Region.Op.DIFFERENCE);
            }
            super.drawStrokeShape(canvas);
            canvas.restore();
        }
    }

    public g(a aVar) {
        super(aVar);
        this.J = aVar;
    }

    public final void h(float f10, float f11, float f12, float f13) {
        RectF rectF = this.J.f20540v;
        if (f10 == rectF.left && f11 == rectF.top && f12 == rectF.right && f13 == rectF.bottom) {
            return;
        }
        rectF.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.J = new a(this.J);
        return this;
    }

    /* compiled from: CutoutDrawable.java */
    public static final class a extends g.b {

        /* renamed from: v, reason: collision with root package name */
        public final RectF f20540v;

        public a(q7.l lVar, RectF rectF) {
            super(lVar, null);
            this.f20540v = rectF;
        }

        @Override // q7.g.b, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b(this);
            bVar.invalidateSelf();
            return bVar;
        }

        public a(a aVar) {
            super(aVar);
            this.f20540v = aVar.f20540v;
        }
    }
}
