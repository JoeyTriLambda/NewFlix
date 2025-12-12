package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1122b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1123m;

    /* renamed from: n, reason: collision with root package name */
    public int f1124n;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1124n = -1;
        int[] iArr = R.styleable.ButtonBarLayout;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        x0.j0.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f1122b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1122b);
        }
    }

    private void setStacked(boolean z10) {
        if (this.f1123m != z10) {
            if (!z10 || this.f1122b) {
                this.f1123m = z10;
                setOrientation(z10 ? 1 : 0);
                setGravity(z10 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z10 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec;
        boolean z10;
        int i12;
        int paddingBottom;
        int size = View.MeasureSpec.getSize(i10);
        int measuredHeight = 0;
        if (this.f1122b) {
            if (size > this.f1124n && this.f1123m) {
                setStacked(false);
            }
            this.f1124n = size;
        }
        if (this.f1123m || View.MeasureSpec.getMode(i10) != 1073741824) {
            iMakeMeasureSpec = i10;
            z10 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z10 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i11);
        if (this.f1122b && !this.f1123m) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z10 = true;
            }
        }
        if (z10) {
            super.onMeasure(i10, i11);
        }
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            i12 = -1;
            if (i13 >= childCount) {
                i13 = -1;
                break;
            } else if (getChildAt(i13).getVisibility() == 0) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 >= 0) {
            View childAt = getChildAt(i13);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            measuredHeight = 0 + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f1123m) {
                int i14 = i13 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i14 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i14).getVisibility() == 0) {
                        i12 = i14;
                        break;
                    }
                    i14++;
                }
                if (i12 >= 0) {
                    paddingBottom = getChildAt(i12).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                paddingBottom = getPaddingBottom();
            }
            measuredHeight += paddingBottom;
        }
        if (x0.j0.getMinimumHeight(this) != measuredHeight) {
            setMinimumHeight(measuredHeight);
            if (i11 == 0) {
                super.onMeasure(i10, i11);
            }
        }
    }

    public void setAllowStacking(boolean z10) {
        if (this.f1122b != z10) {
            this.f1122b = z10;
            if (!z10 && this.f1123m) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
