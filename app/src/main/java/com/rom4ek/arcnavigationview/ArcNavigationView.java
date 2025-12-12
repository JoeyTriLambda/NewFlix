package com.rom4ek.arcnavigationview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.NavigationMenuView;
import i7.m;
import java.lang.reflect.Field;
import l7.c;
import x0.j0;

/* loaded from: classes.dex */
public class ArcNavigationView extends c {
    public a L;
    public int M;
    public int N;
    public Path O;
    public Path P;

    public ArcNavigationView(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.M = 0;
        this.N = 0;
        init(context, attributeSet);
    }

    private void setInsetsColor(int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = m.class.getDeclaredField("b");
            declaredField.setAccessible(true);
            declaredField.set(this, new ColorDrawable(i10));
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    @Override // l7.c, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.O);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void init(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        a aVar = new a(context, attributeSet);
        this.L = aVar;
        aVar.setElevation(j0.getElevation(this));
        setBackgroundColor(0);
        setInsetsColor(0);
        Math.round(a.dpToPx(getContext(), 15));
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i10, int i11) {
        if (view instanceof NavigationMenuView) {
            view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        } else {
            super.measureChild(view, i10, i11);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || this.L == null) {
            return;
        }
        this.M = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.N = measuredWidth;
        if (measuredWidth <= 0 || this.M <= 0) {
            return;
        }
        Path path = new Path();
        this.P = new Path();
        float arcWidth = this.L.getArcWidth();
        DrawerLayout.f fVar = (DrawerLayout.f) getLayoutParams();
        if (this.L.isCropInside()) {
            int i14 = fVar.f2574a;
            if (i14 == 8388611 || i14 == 3) {
                this.P.moveTo(this.N, 0.0f);
                Path path2 = this.P;
                float f10 = this.N;
                float f11 = this.M;
                path2.quadTo(f10 - arcWidth, f11 / 2.0f, f10, f11);
                this.P.close();
                path.moveTo(0.0f, 0.0f);
                path.lineTo(this.N, 0.0f);
                float f12 = this.N;
                float f13 = this.M;
                path.quadTo(f12 - arcWidth, f13 / 2.0f, f12, f13);
                path.lineTo(0.0f, this.M);
                path.close();
            } else if (i14 == 8388613 || i14 == 5) {
                this.P.moveTo(0.0f, 0.0f);
                Path path3 = this.P;
                float f14 = this.M;
                path3.quadTo(arcWidth, f14 / 2.0f, 0.0f, f14);
                this.P.close();
                path.moveTo(this.N, 0.0f);
                path.lineTo(0.0f, 0.0f);
                float f15 = this.M;
                path.quadTo(arcWidth, f15 / 2.0f, 0.0f, f15);
                path.lineTo(this.N, this.M);
                path.close();
            }
        } else {
            int i15 = fVar.f2574a;
            if (i15 == 8388611 || i15 == 3) {
                float f16 = arcWidth / 2.0f;
                this.P.moveTo(this.N - f16, 0.0f);
                Path path4 = this.P;
                float f17 = this.N;
                float f18 = this.M;
                path4.quadTo(f17 + f16, f18 / 2.0f, f17 - f16, f18);
                this.P.close();
                path.moveTo(0.0f, 0.0f);
                path.lineTo(this.N - f16, 0.0f);
                float f19 = this.N;
                float f20 = this.M;
                path.quadTo(f19 + f16, f20 / 2.0f, f19 - f16, f20);
                path.lineTo(0.0f, this.M);
                path.close();
            } else if (i15 == 8388613 || i15 == 5) {
                float f21 = arcWidth / 2.0f;
                this.P.moveTo(f21, 0.0f);
                Path path5 = this.P;
                float f22 = (-arcWidth) / 2.0f;
                float f23 = this.M;
                path5.quadTo(f22, f23 / 2.0f, f21, f23);
                this.P.close();
                path.moveTo(this.N, 0.0f);
                path.lineTo(f21, 0.0f);
                float f24 = this.M;
                path.quadTo(f22, f24 / 2.0f, f21, f24);
                path.lineTo(this.N, this.M);
                path.close();
            }
        }
        this.O = path;
        j0.setElevation(this, this.L.getElevation());
        setOutlineProvider(new pa.a(this));
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt instanceof NavigationMenuView) {
                childAt.setBackground(this.L.getBackgroundDrawable());
                j0.setElevation(childAt, this.L.getElevation());
            }
        }
    }
}
