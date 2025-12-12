package i0;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* compiled from: MotionHelper.java */
/* loaded from: classes.dex */
public final class c extends androidx.constraintlayout.widget.b implements MotionLayout.c {

    /* renamed from: t, reason: collision with root package name */
    public boolean f13098t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13099u;

    /* renamed from: v, reason: collision with root package name */
    public float f13100v;

    /* renamed from: w, reason: collision with root package name */
    public View[] f13101w;

    public float getProgress() {
        return this.f13100v;
    }

    @Override // androidx.constraintlayout.widget.b
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f13098t = typedArrayObtainStyledAttributes.getBoolean(index, this.f13098t);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f13099u = typedArrayObtainStyledAttributes.getBoolean(index, this.f13099u);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return false;
    }

    public boolean isUseOnHide() {
        return this.f13099u;
    }

    public boolean isUsedOnShow() {
        return this.f13098t;
    }

    public void setProgress(View view, float f10) {
    }

    public void setProgress(float f10) {
        this.f13100v = f10;
        int i10 = 0;
        if (this.f1951m > 0) {
            this.f13101w = getViews((ConstraintLayout) getParent());
            while (i10 < this.f1951m) {
                setProgress(this.f13101w[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof c)) {
                setProgress(childAt, f10);
            }
            i10++;
        }
    }

    public void onPreDraw(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
    public void onTransitionStarted(MotionLayout motionLayout, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.c
    public void onTransitionChange(MotionLayout motionLayout, int i10, int i11, float f10) {
    }
}
