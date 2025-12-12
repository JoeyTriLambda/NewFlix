package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R;

/* compiled from: LinearLayoutCompat.java */
/* loaded from: classes.dex */
public class m0 extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1447b;

    /* renamed from: m, reason: collision with root package name */
    public int f1448m;

    /* renamed from: n, reason: collision with root package name */
    public int f1449n;

    /* renamed from: o, reason: collision with root package name */
    public int f1450o;

    /* renamed from: p, reason: collision with root package name */
    public int f1451p;

    /* renamed from: q, reason: collision with root package name */
    public int f1452q;

    /* renamed from: r, reason: collision with root package name */
    public float f1453r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1454s;

    /* renamed from: t, reason: collision with root package name */
    public int[] f1455t;

    /* renamed from: u, reason: collision with root package name */
    public int[] f1456u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f1457v;

    /* renamed from: w, reason: collision with root package name */
    public int f1458w;

    /* renamed from: x, reason: collision with root package name */
    public int f1459x;

    /* renamed from: y, reason: collision with root package name */
    public int f1460y;

    /* renamed from: z, reason: collision with root package name */
    public int f1461z;

    /* compiled from: LinearLayoutCompat.java */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i10, int i11) {
            super(i10, i11);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public m0(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas, int i10) {
        this.f1457v.setBounds(getPaddingLeft() + this.f1461z, i10, (getWidth() - getPaddingRight()) - this.f1461z, this.f1459x + i10);
        this.f1457v.draw(canvas);
    }

    public final void b(Canvas canvas, int i10) {
        this.f1457v.setBounds(i10, getPaddingTop() + this.f1461z, this.f1458w + i10, (getHeight() - getPaddingBottom()) - this.f1461z);
        this.f1457v.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.f1448m < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f1448m;
        if (childCount <= i11) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i11);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1448m == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1449n;
        if (this.f1450o == 1 && (i10 = this.f1451p & 112) != 48) {
            if (i10 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1452q) / 2;
            } else if (i10 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1452q;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1448m;
    }

    public Drawable getDividerDrawable() {
        return this.f1457v;
    }

    public int getDividerPadding() {
        return this.f1461z;
    }

    public int getDividerWidth() {
        return this.f1458w;
    }

    public int getGravity() {
        return this.f1451p;
    }

    public int getOrientation() {
        return this.f1450o;
    }

    public int getShowDividers() {
        return this.f1460y;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1453r;
    }

    public boolean hasDividerBeforeChildAt(int i10) {
        if (i10 == 0) {
            return (this.f1460y & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f1460y & 4) != 0;
        }
        if ((this.f1460y & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int right;
        int left;
        int i10;
        if (this.f1457v == null) {
            return;
        }
        int i11 = 0;
        if (this.f1450o == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i11 < virtualChildCount) {
                View childAt = getChildAt(i11);
                if (childAt != null && childAt.getVisibility() != 8 && hasDividerBeforeChildAt(i11)) {
                    a(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.f1459x);
                }
                i11++;
            }
            if (hasDividerBeforeChildAt(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                a(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f1459x : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean zIsLayoutRtl = k1.isLayoutRtl(this);
        while (i11 < virtualChildCount2) {
            View childAt3 = getChildAt(i11);
            if (childAt3 != null && childAt3.getVisibility() != 8 && hasDividerBeforeChildAt(i11)) {
                a aVar = (a) childAt3.getLayoutParams();
                b(canvas, zIsLayoutRtl ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f1458w);
            }
            i11++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                a aVar2 = (a) childAt4.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i10 = this.f1458w;
                    right = left - i10;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i10 = this.f1458w;
                right = left - i10;
            }
            b(canvas, right);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0899  */
    /* JADX WARN: Removed duplicated region for block: B:448:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f1447b = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 >= 0 && i10 < getChildCount()) {
            this.f1448m = i10;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1457v) {
            return;
        }
        this.f1457v = drawable;
        if (drawable != null) {
            this.f1458w = drawable.getIntrinsicWidth();
            this.f1459x = drawable.getIntrinsicHeight();
        } else {
            this.f1458w = 0;
            this.f1459x = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i10) {
        this.f1461z = i10;
    }

    public void setGravity(int i10) {
        if (this.f1451p != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f1451p = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f1451p;
        if ((8388615 & i12) != i11) {
            this.f1451p = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f1454s = z10;
    }

    public void setOrientation(int i10) {
        if (this.f1450o != i10) {
            this.f1450o = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f1460y) {
            requestLayout();
        }
        this.f1460y = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f1451p;
        if ((i12 & 112) != i11) {
            this.f1451p = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f1453r = Math.max(0.0f, f10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public m0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        int i10 = this.f1450o;
        if (i10 == 0) {
            return new a(-2, -2);
        }
        if (i10 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    public m0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1447b = true;
        this.f1448m = -1;
        this.f1449n = 0;
        this.f1451p = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        x0.j0.saveAttributeDataForStyleable(this, context, iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        int i11 = c1VarObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i11 >= 0) {
            setOrientation(i11);
        }
        int i12 = c1VarObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i12 >= 0) {
            setGravity(i12);
        }
        boolean z10 = c1VarObtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z10) {
            setBaselineAligned(z10);
        }
        this.f1453r = c1VarObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1448m = c1VarObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1454s = c1VarObtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(c1VarObtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.f1460y = c1VarObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f1461z = c1VarObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        c1VarObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }
}
