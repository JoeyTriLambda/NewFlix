package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.g;

/* loaded from: classes.dex */
public class Flow extends g {

    /* renamed from: v, reason: collision with root package name */
    public e f1848v;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.g, androidx.constraintlayout.widget.b
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.f1848v = new e();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f1848v.setOrientation(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f1848v.setPadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f1848v.setPaddingStart(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f1848v.setPaddingEnd(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f1848v.setPaddingLeft(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f1848v.setPaddingTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f1848v.setPaddingRight(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f1848v.setPaddingBottom(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f1848v.setWrapMode(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f1848v.setHorizontalStyle(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f1848v.setVerticalStyle(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f1848v.setFirstHorizontalStyle(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f1848v.setLastHorizontalStyle(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f1848v.setFirstVerticalStyle(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f1848v.setLastVerticalStyle(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f1848v.setHorizontalBias(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f1848v.setFirstHorizontalBias(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f1848v.setLastHorizontalBias(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f1848v.setFirstVerticalBias(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f1848v.setLastVerticalBias(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f1848v.setVerticalBias(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f1848v.setHorizontalAlign(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f1848v.setVerticalAlign(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f1848v.setHorizontalGap(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f1848v.setVerticalGap(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f1848v.setMaxElementsWrap(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f1953o = this.f1848v;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        onMeasure(this.f1848v, i10, i11);
    }

    @Override // androidx.constraintlayout.widget.b
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
        this.f1848v.applyRtl(z10);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f1848v.setFirstHorizontalBias(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f1848v.setFirstHorizontalStyle(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f1848v.setFirstVerticalBias(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f1848v.setFirstVerticalStyle(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f1848v.setHorizontalAlign(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f1848v.setHorizontalBias(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f1848v.setHorizontalGap(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f1848v.setHorizontalStyle(i10);
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f1848v.setLastHorizontalBias(f10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f1848v.setLastHorizontalStyle(i10);
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f1848v.setLastVerticalBias(f10);
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f1848v.setLastVerticalStyle(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f1848v.setMaxElementsWrap(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f1848v.setOrientation(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f1848v.setPadding(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f1848v.setPaddingBottom(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f1848v.setPaddingLeft(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f1848v.setPaddingRight(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f1848v.setPaddingTop(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f1848v.setVerticalAlign(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f1848v.setVerticalBias(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f1848v.setVerticalGap(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f1848v.setVerticalStyle(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f1848v.setWrapMode(i10);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.g
    public void onMeasure(h hVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (hVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            hVar.measure(mode, size, mode2, size2);
            setMeasuredDimension(hVar.getMeasuredWidth(), hVar.getMeasuredHeight());
        }
    }
}
