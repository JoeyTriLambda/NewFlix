package m4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;

/* compiled from: ChasingDots.java */
/* loaded from: classes.dex */
public final class a extends l4.g {

    /* compiled from: ChasingDots.java */
    /* renamed from: m4.a$a, reason: collision with other inner class name */
    public class C0194a extends l4.b {
        public C0194a() {
            setScale(0.0f);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            j4.d dVar = new j4.d(this);
            Float fValueOf = Float.valueOf(0.0f);
            return dVar.scale(fArr, fValueOf, Float.valueOf(1.0f), fValueOf).duration(2000L).easeInOut(fArr).build();
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iWidth = (int) (rectClipSquare.width() * 0.6f);
        l4.f childAt = getChildAt(0);
        int i10 = rectClipSquare.right;
        int i11 = rectClipSquare.top;
        childAt.setDrawBounds(i10 - iWidth, i11, i10, i11 + iWidth);
        l4.f childAt2 = getChildAt(1);
        int i12 = rectClipSquare.right;
        int i13 = rectClipSquare.bottom;
        childAt2.setDrawBounds(i12 - iWidth, i13 - iWidth, i12, i13);
    }

    @Override // l4.g
    public void onChildCreated(l4.f... fVarArr) {
        super.onChildCreated(fVarArr);
        if (Build.VERSION.SDK_INT >= 24) {
            fVarArr[1].setAnimationDelay(1000);
        } else {
            fVarArr[1].setAnimationDelay(-1000);
        }
    }

    @Override // l4.g, l4.f
    public ValueAnimator onCreateAnimation() {
        return new j4.d(this).rotate(new float[]{0.0f, 1.0f}, 0, 360).duration(2000L).interpolator(new LinearInterpolator()).build();
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        return new l4.f[]{new C0194a(), new C0194a()};
    }
}
