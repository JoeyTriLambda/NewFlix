package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
import x0.j0;
import y0.d;

/* loaded from: classes.dex */
class ClockFaceView extends d implements ClockHandView.b {
    public final ClockHandView G;
    public final Rect H;
    public final RectF I;
    public final Rect J;
    public final SparseArray<TextView> K;
    public final b L;
    public final int[] M;
    public final float[] N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public String[] S;
    public float T;
    public final ColorStateList U;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ClockFaceView clockFaceView = ClockFaceView.this;
            if (!clockFaceView.isShown()) {
                return true;
            }
            clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
            clockFaceView.setRadius(((clockFaceView.getHeight() / 2) - clockFaceView.G.getSelectorRadius()) - clockFaceView.O);
            return true;
        }
    }

    public class b extends x0.a {
        public b() {
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (iIntValue > 0) {
                dVar.setTraversalAfter(ClockFaceView.this.K.get(iIntValue - 1));
            }
            dVar.setCollectionItemInfo(d.f.obtain(0, 1, iIntValue, 1, false, view.isSelected()));
            dVar.setClickable(true);
            dVar.addAction(d.a.f21822g);
        }

        @Override // x0.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            ClockFaceView clockFaceView = ClockFaceView.this;
            view.getHitRect(clockFaceView.H);
            float fCenterX = clockFaceView.H.centerX();
            float fCenterY = clockFaceView.H.centerY();
            clockFaceView.G.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            clockFaceView.G.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public final void c() {
        SparseArray<TextView> sparseArray;
        RectF rectF;
        Rect rect;
        RectF currentSelectorBox = this.G.getCurrentSelectorBox();
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        int i10 = 0;
        while (true) {
            sparseArray = this.K;
            int size = sparseArray.size();
            rectF = this.I;
            rect = this.H;
            if (i10 >= size) {
                break;
            }
            TextView textView2 = sparseArray.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(currentSelectorBox);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f10) {
                    textView = textView2;
                    f10 = fHeight;
                }
            }
            i10++;
        }
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            TextView textView3 = sparseArray.get(i11);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.J);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(currentSelectorBox, rectF) ? null : new RadialGradient(currentSelectorBox.centerX() - rectF.left, currentSelectorBox.centerY() - rectF.top, 0.5f * currentSelectorBox.width(), this.M, this.N, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        y0.d.wrap(accessibilityNodeInfo).setCollectionInfo(d.e.obtain(1, this.S.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        c();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.R / Math.max(Math.max(this.P / displayMetrics.heightPixels, this.Q / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void onRotate(float f10, boolean z10) {
        if (Math.abs(this.T - f10) > 0.001f) {
            this.T = f10;
            c();
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void setRadius(int i10) {
        if (i10 != getRadius()) {
            super.setRadius(i10);
            this.G.setCircleRadius(getRadius());
        }
    }

    public void setValues(String[] strArr, int i10) {
        this.S = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        SparseArray<TextView> sparseArray = this.K;
        int size = sparseArray.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < Math.max(this.S.length, size); i11++) {
            TextView textView = sparseArray.get(i11);
            if (i11 >= this.S.length) {
                removeView(textView);
                sparseArray.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.S[i11]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i12));
                if (i12 > 1) {
                    z10 = true;
                }
                j0.setAccessibilityDelegate(textView, this.L);
                textView.setTextColor(this.U);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.S[i11]));
                }
            }
        }
        ClockHandView clockHandView = this.G;
        if (clockHandView.f9487o && !z10) {
            clockHandView.f9498z = 1;
        }
        clockHandView.f9487o = z10;
        clockHandView.invalidate();
    }

    @Override // com.google.android.material.timepicker.d
    public void updateLayoutParams() {
        super.updateLayoutParams();
        int i10 = 0;
        while (true) {
            SparseArray<TextView> sparseArray = this.K;
            if (i10 >= sparseArray.size()) {
                return;
            }
            sparseArray.get(i10).setVisibility(0);
            i10++;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.H = new Rect();
        this.I = new RectF();
        this.J = new Rect();
        this.K = new SparseArray<>();
        this.N = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateList = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.U = colorStateList;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.G = clockHandView;
        this.O = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateList.getColorForState(new int[]{android.R.attr.state_selected}, colorStateList.getDefaultColor());
        this.M = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.addOnRotateListener(this);
        int defaultColor = s.a.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateList2 = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.L = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        setValues(strArr, 0);
        this.P = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.Q = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.R = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
