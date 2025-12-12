package i7;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import x0.j0;

/* compiled from: FlowLayout.java */
/* loaded from: classes.dex */
public class d extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public int f13271b;

    /* renamed from: m, reason: collision with root package name */
    public int f13272m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13273n;

    /* renamed from: o, reason: collision with root package name */
    public int f13274o;

    public int getItemSpacing() {
        return this.f13272m;
    }

    public int getLineSpacing() {
        return this.f13271b;
    }

    public int getRowCount() {
        return this.f13274o;
    }

    public int getRowIndex(View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.f13273n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            this.f13274o = 0;
            return;
        }
        this.f13274o = 1;
        boolean z11 = j0.getLayoutDirection(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = (i12 - i10) - paddingLeft;
        int measuredWidth = paddingRight;
        int i15 = paddingTop;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = x0.k.getMarginStart(marginLayoutParams);
                    marginEnd = x0.k.getMarginEnd(marginLayoutParams);
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth + marginStart;
                if (!this.f13273n && measuredWidth2 > i14) {
                    i15 = this.f13271b + paddingTop;
                    this.f13274o++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f13274o - 1));
                int i17 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i17;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z11) {
                    childAt.layout(i14 - measuredWidth3, i15, (i14 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i17, i15, measuredWidth3, measuredHeight);
                }
                measuredWidth += childAt.getMeasuredWidth() + marginStart + marginEnd + this.f13272m;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i15 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i15 - getPaddingRight();
        int i16 = paddingTop;
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = marginLayoutParams.leftMargin + 0;
                    i13 = marginLayoutParams.rightMargin + 0;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                if (childAt.getMeasuredWidth() + paddingLeft + i14 > paddingRight && !isSingleLine()) {
                    paddingLeft = getPaddingLeft();
                    i16 = this.f13271b + paddingTop;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i14;
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                if (measuredWidth > i17) {
                    i17 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i14 + i13 + this.f13272m + paddingLeft;
                if (i18 == getChildCount() - 1) {
                    i17 += i13;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i17;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i12 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i12 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i12) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i10) {
        this.f13272m = i10;
    }

    public void setLineSpacing(int i10) {
        this.f13271b = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f13273n = z10;
    }
}
