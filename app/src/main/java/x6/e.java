package x6;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: CarouselOrientationHelper.java */
/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f21631b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f21631b = carouselLayoutManager;
    }

    @Override // x6.f
    public final int a() {
        CarouselLayoutManager carouselLayoutManager = this.f21631b;
        return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
    }

    @Override // x6.f
    public final int b() {
        if (this.f21631b.z()) {
            return 0;
        }
        return d();
    }

    @Override // x6.f
    public final int c() {
        return 0;
    }

    @Override // x6.f
    public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
        float f10 = rectF2.left;
        float f11 = rectF3.left;
        if (f10 < f11 && rectF2.right > f11) {
            float f12 = f11 - f10;
            rectF.left += f12;
            rectF2.left += f12;
        }
        float f13 = rectF2.right;
        float f14 = rectF3.right;
        if (f13 <= f14 || rectF2.left >= f14) {
            return;
        }
        float f15 = f13 - f14;
        rectF.right = Math.max(rectF.right - f15, rectF.left);
        rectF2.right = Math.max(rectF2.right - f15, rectF2.left);
    }

    @Override // x6.f
    public final int d() {
        return this.f21631b.getWidth();
    }

    @Override // x6.f
    public final int e() {
        if (this.f21631b.z()) {
            return d();
        }
        return 0;
    }

    @Override // x6.f
    public final int f() {
        return this.f21631b.getPaddingTop();
    }

    @Override // x6.f
    public float getMaskMargins(RecyclerView.m mVar) {
        return ((ViewGroup.MarginLayoutParams) mVar).rightMargin + ((ViewGroup.MarginLayoutParams) mVar).leftMargin;
    }

    @Override // x6.f
    public RectF getMaskRect(float f10, float f11, float f12, float f13) {
        return new RectF(f13, 0.0f, f11 - f13, f10);
    }

    @Override // x6.f
    public void layoutDecoratedWithMargins(View view, int i10, int i11) {
        int iF = f();
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f21631b.layoutDecoratedWithMargins(view, i10, iF, i11, this.f21631b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + iF);
    }

    @Override // x6.f
    public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
        if (rectF2.right <= rectF3.left) {
            float fFloor = ((float) Math.floor(rectF.right)) - 1.0f;
            rectF.right = fFloor;
            rectF.left = Math.min(rectF.left, fFloor);
        }
        if (rectF2.left >= rectF3.right) {
            float fCeil = ((float) Math.ceil(rectF.left)) + 1.0f;
            rectF.left = fCeil;
            rectF.right = Math.max(fCeil, rectF.right);
        }
    }

    @Override // x6.f
    public void offsetChild(View view, Rect rect, float f10, float f11) {
        view.offsetLeftAndRight((int) (f11 - (rect.left + f10)));
    }
}
