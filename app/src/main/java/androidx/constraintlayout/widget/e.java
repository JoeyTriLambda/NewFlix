package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public final class e extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public d f2067b;

    public d getConstraintSet() {
        if (this.f2067b == null) {
            this.f2067b = new d();
        }
        this.f2067b.clone(this);
        return this.f2067b;
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    /* compiled from: Constraints.java */
    public static class a extends ConstraintLayout.a {
        public final float A0;
        public final float B0;
        public final float C0;
        public final float D0;

        /* renamed from: r0, reason: collision with root package name */
        public final float f2068r0;

        /* renamed from: s0, reason: collision with root package name */
        public final boolean f2069s0;

        /* renamed from: t0, reason: collision with root package name */
        public final float f2070t0;

        /* renamed from: u0, reason: collision with root package name */
        public final float f2071u0;

        /* renamed from: v0, reason: collision with root package name */
        public final float f2072v0;

        /* renamed from: w0, reason: collision with root package name */
        public final float f2073w0;

        /* renamed from: x0, reason: collision with root package name */
        public final float f2074x0;

        /* renamed from: y0, reason: collision with root package name */
        public final float f2075y0;

        /* renamed from: z0, reason: collision with root package name */
        public final float f2076z0;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f2068r0 = 1.0f;
            this.f2069s0 = false;
            this.f2070t0 = 0.0f;
            this.f2071u0 = 0.0f;
            this.f2072v0 = 0.0f;
            this.f2073w0 = 0.0f;
            this.f2074x0 = 1.0f;
            this.f2075y0 = 1.0f;
            this.f2076z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2068r0 = 1.0f;
            this.f2069s0 = false;
            this.f2070t0 = 0.0f;
            this.f2071u0 = 0.0f;
            this.f2072v0 = 0.0f;
            this.f2073w0 = 0.0f;
            this.f2074x0 = 1.0f;
            this.f2075y0 = 1.0f;
            this.f2076z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.f2068r0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2068r0);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.f2070t0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2070t0);
                    this.f2069s0 = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.f2072v0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2072v0);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.f2073w0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2073w0);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.f2071u0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2071u0);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.f2074x0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2074x0);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.f2075y0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2075y0);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.f2076z0 = typedArrayObtainStyledAttributes.getFloat(index, this.f2076z0);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.A0 = typedArrayObtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.B0 = typedArrayObtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.C0 = typedArrayObtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.D0 = typedArrayObtainStyledAttributes.getFloat(index, this.D0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
