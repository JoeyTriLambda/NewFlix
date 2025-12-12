package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: t, reason: collision with root package name */
    public int f1947t;

    /* renamed from: u, reason: collision with root package name */
    public int f1948u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.a f1949v;

    public a(Context context) {
        super(context);
        setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f1949v.getAllowsGoneWidget();
    }

    public int getMargin() {
        return this.f1949v.getMargin();
    }

    public int getType() {
        return this.f1947t;
    }

    @Override // androidx.constraintlayout.widget.b
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.f1949v = new androidx.constraintlayout.core.widgets.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f1949v.setAllowsGoneWidget(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f1949v.setMargin(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f1953o = this.f1949v;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.b
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
        int i10 = this.f1947t;
        this.f1948u = i10;
        if (z10) {
            if (i10 == 5) {
                this.f1948u = 1;
            } else if (i10 == 6) {
                this.f1948u = 0;
            }
        } else if (i10 == 5) {
            this.f1948u = 0;
        } else if (i10 == 6) {
            this.f1948u = 1;
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) constraintWidget).setBarrierType(this.f1948u);
        }
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1949v.setAllowsGoneWidget(z10);
    }

    public void setDpMargin(int i10) {
        this.f1949v.setMargin((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f1949v.setMargin(i10);
    }

    public void setType(int i10) {
        this.f1947t = i10;
    }
}
