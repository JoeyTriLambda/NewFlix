package x6;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: CarouselOrientationHelper.java */
/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f21630b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f21630b = carouselLayoutManager;
    }

    @Override // x6.f
    public final int a() {
        return this.f21630b.getHeight();
    }

    @Override // x6.f
    public final int b() {
        return a();
    }

    @Override // x6.f
    public final int c() {
        return this.f21630b.getPaddingLeft();
    }

    @Override // x6.f
    public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
        float f10 = rectF2.top;
        float f11 = rectF3.top;
        if (f10 < f11 && rectF2.bottom > f11) {
            float f12 = f11 - f10;
            rectF.top += f12;
            rectF3.top += f12;
        }
        float f13 = rectF2.bottom;
        float f14 = rectF3.bottom;
        if (f13 <= f14 || rectF2.top >= f14) {
            return;
        }
        float f15 = f13 - f14;
        rectF.bottom = Math.max(rectF.bottom - f15, rectF.top);
        rectF2.bottom = Math.max(rectF2.bottom - f15, rectF2.top);
    }

    @Override // x6.f
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.f21630b;
        return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
    }

    @Override // x6.f
    public final int e() {
        return 0;
    }

    @Override // x6.f
    public final int f() {
        return 0;
    }

    @Override // x6.f
    public float getMaskMargins(RecyclerView.m mVar) {
        return ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // x6.f
    public RectF getMaskRect(float f10, float f11, float f12, float f13) {
        return new RectF(0.0f, f12, f11, f10 - f12);
    }

    @Override // x6.f
    public void layoutDecoratedWithMargins(View view, int i10, int i11) {
        int iC = c();
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f21630b.layoutDecoratedWithMargins(view, iC, i10, this.f21630b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + iC, i11);
    }

    @Override // x6.f
    public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
        if (rectF2.bottom <= rectF3.top) {
            float fFloor = ((float) Math.floor(rectF.bottom)) - 1.0f;
            rectF.bottom = fFloor;
            rectF.top = Math.min(rectF.top, fFloor);
        }
        if (rectF2.top >= rectF3.bottom) {
            float fCeil = ((float) Math.ceil(rectF.top)) + 1.0f;
            rectF.top = fCeil;
            rectF.bottom = Math.max(fCeil, rectF.bottom);
        }
    }

    @Override // x6.f
    public void offsetChild(View view, Rect rect, float f10, float f11) {
        view.offsetTopAndBottom((int) (f11 - (rect.top + f10)));
    }
}
