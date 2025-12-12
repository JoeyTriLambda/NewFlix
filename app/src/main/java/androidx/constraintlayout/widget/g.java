package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.h;

/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public abstract class g extends b {

    /* renamed from: t, reason: collision with root package name */
    public boolean f2080t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2081u;

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.b
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
        applyLayoutFeatures(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.b
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f2080t = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f2081u = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        if (this.f2080t || this.f2081u) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i10 = 0; i10 < this.f1951m; i10++) {
                    View viewById = constraintLayout.getViewById(this.f1950b[i10]);
                    if (viewById != null) {
                        if (this.f2080t) {
                            viewById.setVisibility(visibility);
                        }
                        if (this.f2081u && elevation > 0.0f) {
                            viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        applyLayoutFeatures();
    }

    public void onMeasure(h hVar, int i10, int i11) {
    }
}
