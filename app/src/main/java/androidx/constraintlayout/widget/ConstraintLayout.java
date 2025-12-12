package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import h0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static j0.b C;
    public final SparseArray<ConstraintWidget> A;
    public final b B;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<View> f1879b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<androidx.constraintlayout.widget.b> f1880m;

    /* renamed from: n, reason: collision with root package name */
    public final androidx.constraintlayout.core.widgets.d f1881n;

    /* renamed from: o, reason: collision with root package name */
    public int f1882o;

    /* renamed from: p, reason: collision with root package name */
    public int f1883p;

    /* renamed from: q, reason: collision with root package name */
    public int f1884q;

    /* renamed from: r, reason: collision with root package name */
    public int f1885r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1886s;

    /* renamed from: t, reason: collision with root package name */
    public int f1887t;

    /* renamed from: u, reason: collision with root package name */
    public d f1888u;

    /* renamed from: v, reason: collision with root package name */
    public c f1889v;

    /* renamed from: w, reason: collision with root package name */
    public int f1890w;

    /* renamed from: x, reason: collision with root package name */
    public HashMap<String, Integer> f1891x;

    /* renamed from: y, reason: collision with root package name */
    public int f1892y;

    /* renamed from: z, reason: collision with root package name */
    public int f1893z;

    public class b implements b.InterfaceC0158b {

        /* renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f1938a;

        /* renamed from: b, reason: collision with root package name */
        public int f1939b;

        /* renamed from: c, reason: collision with root package name */
        public int f1940c;

        /* renamed from: d, reason: collision with root package name */
        public int f1941d;

        /* renamed from: e, reason: collision with root package name */
        public int f1942e;

        /* renamed from: f, reason: collision with root package name */
        public int f1943f;

        /* renamed from: g, reason: collision with root package name */
        public int f1944g;

        public b(ConstraintLayout constraintLayout) {
            this.f1938a = constraintLayout;
        }

        public static boolean a(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
            }
            return false;
        }

        public void captureLayoutInfo(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f1939b = i12;
            this.f1940c = i13;
            this.f1941d = i14;
            this.f1942e = i15;
            this.f1943f = i10;
            this.f1944g = i11;
        }

        public final void didMeasures() {
            ConstraintLayout constraintLayout = this.f1938a;
            int childCount = constraintLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = constraintLayout.getChildAt(i10);
                if (childAt instanceof f) {
                    ((f) childAt).updatePostMeasure(constraintLayout);
                }
            }
            int size = constraintLayout.f1880m.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    constraintLayout.f1880m.get(i11).updatePostMeasure(constraintLayout);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e3  */
        @android.annotation.SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void measure(androidx.constraintlayout.core.widgets.ConstraintWidget r18, h0.b.a r19) {
            /*
                Method dump skipped, instructions count: 711
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.measure(androidx.constraintlayout.core.widgets.ConstraintWidget, h0.b$a):void");
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1879b = new SparseArray<>();
        this.f1880m = new ArrayList<>(4);
        this.f1881n = new androidx.constraintlayout.core.widgets.d();
        this.f1882o = 0;
        this.f1883p = 0;
        this.f1884q = Integer.MAX_VALUE;
        this.f1885r = Integer.MAX_VALUE;
        this.f1886s = true;
        this.f1887t = 257;
        this.f1888u = null;
        this.f1889v = null;
        this.f1890w = -1;
        this.f1891x = new HashMap<>();
        this.f1892y = -1;
        this.f1893z = -1;
        this.A = new SparseArray<>();
        this.B = new b(this);
        a(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static j0.b getSharedValues() {
        if (C == null) {
            C = new j0.b();
        }
        return C;
    }

    public final void a(AttributeSet attributeSet, int i10) {
        androidx.constraintlayout.core.widgets.d dVar = this.f1881n;
        dVar.setCompanionWidget(this);
        dVar.setMeasurer(this.B);
        this.f1879b.put(getId(), this);
        this.f1888u = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i10, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f1882o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1882o);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f1883p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1883p);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1884q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1884q);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1885r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1885r);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1887t = typedArrayObtainStyledAttributes.getInt(index, this.f1887t);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1889v = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar2 = new d();
                        this.f1888u = dVar2;
                        dVar2.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1888u = null;
                    }
                    this.f1890w = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        dVar.setOptimizationLevel(this.f1887t);
    }

    public void applyConstraintsFromLayoutParams(boolean z10, View view, ConstraintWidget constraintWidget, a aVar, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i10;
        aVar.validate();
        constraintWidget.setVisibility(view.getVisibility());
        if (aVar.f1905f0) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget(view);
        if (view instanceof androidx.constraintlayout.widget.b) {
            ((androidx.constraintlayout.widget.b) view).resolveRtl(constraintWidget, this.f1881n.isRtl());
        }
        if (aVar.f1901d0) {
            androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
            int i11 = aVar.f1921n0;
            int i12 = aVar.f1923o0;
            float f10 = aVar.f1925p0;
            if (f10 != -1.0f) {
                fVar.setGuidePercent(f10);
                return;
            } else if (i11 != -1) {
                fVar.setGuideBegin(i11);
                return;
            } else {
                if (i12 != -1) {
                    fVar.setGuideEnd(i12);
                    return;
                }
                return;
            }
        }
        int i13 = aVar.f1907g0;
        int i14 = aVar.f1909h0;
        int i15 = aVar.f1911i0;
        int i16 = aVar.f1913j0;
        int i17 = aVar.f1915k0;
        int i18 = aVar.f1917l0;
        float f11 = aVar.f1919m0;
        int i19 = aVar.f1924p;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.TOP;
        if (i19 != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(i19);
            if (constraintWidget6 != null) {
                constraintWidget.connectCircularConstraint(constraintWidget6, aVar.f1928r, aVar.f1926q);
            }
            type = type5;
            type2 = type4;
        } else {
            if (i13 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i13);
                if (constraintWidget7 != null) {
                    type = type5;
                    type2 = type4;
                    constraintWidget.immediateConnect(type4, constraintWidget7, type4, ((ViewGroup.MarginLayoutParams) aVar).leftMargin, i17);
                } else {
                    type = type5;
                    type2 = type4;
                }
            } else {
                type = type5;
                type2 = type4;
                if (i14 != -1 && (constraintWidget2 = sparseArray.get(i14)) != null) {
                    constraintWidget.immediateConnect(type2, constraintWidget2, type3, ((ViewGroup.MarginLayoutParams) aVar).leftMargin, i17);
                }
            }
            if (i15 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i15);
                if (constraintWidget8 != null) {
                    constraintWidget.immediateConnect(type3, constraintWidget8, type2, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, i18);
                }
            } else if (i16 != -1 && (constraintWidget3 = sparseArray.get(i16)) != null) {
                constraintWidget.immediateConnect(type3, constraintWidget3, type3, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, i18);
            }
            int i20 = aVar.f1910i;
            if (i20 != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(i20);
                if (constraintWidget9 != null) {
                    constraintWidget.immediateConnect(type6, constraintWidget9, type6, ((ViewGroup.MarginLayoutParams) aVar).topMargin, aVar.f1934x);
                }
            } else {
                int i21 = aVar.f1912j;
                if (i21 != -1 && (constraintWidget4 = sparseArray.get(i21)) != null) {
                    constraintWidget.immediateConnect(type6, constraintWidget4, type, ((ViewGroup.MarginLayoutParams) aVar).topMargin, aVar.f1934x);
                }
            }
            int i22 = aVar.f1914k;
            if (i22 != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(i22);
                if (constraintWidget10 != null) {
                    constraintWidget.immediateConnect(type, constraintWidget10, type6, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, aVar.f1936z);
                }
            } else {
                int i23 = aVar.f1916l;
                if (i23 != -1 && (constraintWidget5 = sparseArray.get(i23)) != null) {
                    constraintWidget.immediateConnect(type, constraintWidget5, type, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, aVar.f1936z);
                }
            }
            int i24 = aVar.f1918m;
            if (i24 != -1) {
                b(constraintWidget, aVar, sparseArray, i24, ConstraintAnchor.Type.BASELINE);
            } else {
                int i25 = aVar.f1920n;
                if (i25 != -1) {
                    b(constraintWidget, aVar, sparseArray, i25, type6);
                } else {
                    int i26 = aVar.f1922o;
                    if (i26 != -1) {
                        b(constraintWidget, aVar, sparseArray, i26, type);
                    }
                }
            }
            if (f11 >= 0.0f) {
                constraintWidget.setHorizontalBiasPercent(f11);
            }
            float f12 = aVar.F;
            if (f12 >= 0.0f) {
                constraintWidget.setVerticalBiasPercent(f12);
            }
        }
        if (z10 && ((i10 = aVar.T) != -1 || aVar.U != -1)) {
            constraintWidget.setOrigin(i10, aVar.U);
        }
        boolean z11 = aVar.f1895a0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (z11) {
            constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour3);
            constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) aVar).width);
            if (((ViewGroup.MarginLayoutParams) aVar).width == -2) {
                constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour2);
            }
        } else if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
            if (aVar.W) {
                constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour4);
            } else {
                constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
            }
            constraintWidget.getAnchor(type2).f1686g = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            constraintWidget.getAnchor(type3).f1686g = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
        } else {
            constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour4);
            constraintWidget.setWidth(0);
        }
        if (aVar.f1897b0) {
            constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour3);
            constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) aVar).height);
            if (((ViewGroup.MarginLayoutParams) aVar).height == -2) {
                constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
            }
        } else if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
            if (aVar.X) {
                constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour4);
            } else {
                constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour);
            }
            constraintWidget.getAnchor(type6).f1686g = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            constraintWidget.getAnchor(type).f1686g = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
        } else {
            constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour4);
            constraintWidget.setHeight(0);
        }
        constraintWidget.setDimensionRatio(aVar.G);
        constraintWidget.setHorizontalWeight(aVar.H);
        constraintWidget.setVerticalWeight(aVar.I);
        constraintWidget.setHorizontalChainStyle(aVar.J);
        constraintWidget.setVerticalChainStyle(aVar.K);
        constraintWidget.setWrapBehaviorInParent(aVar.Z);
        constraintWidget.setHorizontalMatchStyle(aVar.L, aVar.N, aVar.P, aVar.R);
        constraintWidget.setVerticalMatchStyle(aVar.M, aVar.O, aVar.Q, aVar.S);
    }

    public final void b(ConstraintWidget constraintWidget, a aVar, SparseArray<ConstraintWidget> sparseArray, int i10, ConstraintAnchor.Type type) {
        View view = this.f1879b.get(i10);
        ConstraintWidget constraintWidget2 = sparseArray.get(i10);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof a)) {
            return;
        }
        aVar.f1899c0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
        if (type == type2) {
            a aVar2 = (a) view.getLayoutParams();
            aVar2.f1899c0 = true;
            aVar2.f1927q0.setHasBaseline(true);
        }
        constraintWidget.getAnchor(type2).connect(constraintWidget2.getAnchor(type), aVar.D, aVar.C, true);
        constraintWidget.setHasBaseline(true);
        constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
        constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1880m;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.get(i10).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i12 = Integer.parseInt(strArrSplit[0]);
                        int i13 = Integer.parseInt(strArrSplit[1]);
                        int i14 = Integer.parseInt(strArrSplit[2]);
                        int i15 = (int) ((i12 / 1080.0f) * width);
                        int i16 = (int) ((i13 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i15;
                        float f11 = i16;
                        float f12 = i15 + ((int) ((i14 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float f13 = i16 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, f13, paint);
                        canvas.drawLine(f12, f13, f10, f13, paint);
                        canvas.drawLine(f10, f13, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, f13, paint);
                        canvas.drawLine(f10, f13, f12, f11, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        this.f1886s = true;
        this.f1892y = -1;
        this.f1893z = -1;
        super.forceLayout();
    }

    public Object getDesignInformation(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.f1891x;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f1891x.get(str);
    }

    public int getMaxHeight() {
        return this.f1885r;
    }

    public int getMaxWidth() {
        return this.f1884q;
    }

    public int getMinHeight() {
        return this.f1883p;
    }

    public int getMinWidth() {
        return this.f1882o;
    }

    public int getOptimizationLevel() {
        return this.f1881n.getOptimizationLevel();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        androidx.constraintlayout.core.widgets.d dVar = this.f1881n;
        if (dVar.f1718k == null) {
            int id3 = getId();
            if (id3 != -1) {
                dVar.f1718k = getContext().getResources().getResourceEntryName(id3);
            } else {
                dVar.f1718k = "parent";
            }
        }
        if (dVar.getDebugName() == null) {
            dVar.setDebugName(dVar.f1718k);
            Log.v("ConstraintLayout", " setDebugName " + dVar.getDebugName());
        }
        Iterator<ConstraintWidget> it = dVar.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.getCompanionWidget();
            if (view != null) {
                if (next.f1718k == null && (id2 = view.getId()) != -1) {
                    next.f1718k = getContext().getResources().getResourceEntryName(id2);
                }
                if (next.getDebugName() == null) {
                    next.setDebugName(next.f1718k);
                    Log.v("ConstraintLayout", " setDebugName " + next.getDebugName());
                }
            }
        }
        dVar.getSceneString(sb2);
        return sb2.toString();
    }

    public View getViewById(int i10) {
        return this.f1879b.get(i10);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.f1881n;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof a) {
            return ((a) view.getLayoutParams()).f1927q0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof a) {
            return ((a) view.getLayoutParams()).f1927q0;
        }
        return null;
    }

    public boolean isRtl() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            a aVar = (a) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = aVar.f1927q0;
            if ((childAt.getVisibility() != 8 || aVar.f1901d0 || aVar.f1903e0 || zIsInEditMode) && !aVar.f1905f0) {
                int x10 = constraintWidget.getX();
                int y10 = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x10;
                int height = constraintWidget.getHeight() + y10;
                childAt.layout(x10, y10, width, height);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x10, y10, width, height);
                }
            }
        }
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1880m;
        int size = arrayList.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                arrayList.get(i15).updatePostLayout(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        String resourceName;
        int id2;
        ConstraintWidget constraintWidget;
        boolean z10 = true;
        if (!this.f1886s) {
            int childCount = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                if (getChildAt(i12).isLayoutRequested()) {
                    this.f1886s = true;
                    break;
                }
                i12++;
            }
        }
        boolean zIsRtl = isRtl();
        androidx.constraintlayout.core.widgets.d dVar = this.f1881n;
        dVar.setRtl(zIsRtl);
        if (this.f1886s) {
            this.f1886s = false;
            int childCount2 = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount2) {
                    z10 = false;
                    break;
                } else if (getChildAt(i13).isLayoutRequested()) {
                    break;
                } else {
                    i13++;
                }
            }
            if (z10) {
                boolean zIsInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i14 = 0; i14 < childCount3; i14++) {
                    ConstraintWidget viewWidget = getViewWidget(getChildAt(i14));
                    if (viewWidget != null) {
                        viewWidget.reset();
                    }
                }
                if (zIsInEditMode) {
                    for (int i15 = 0; i15 < childCount3; i15++) {
                        View childAt = getChildAt(i15);
                        try {
                            resourceName = getResources().getResourceName(childAt.getId());
                            setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                            int iIndexOf = resourceName.indexOf(47);
                            if (iIndexOf != -1) {
                                resourceName = resourceName.substring(iIndexOf + 1);
                            }
                            id2 = childAt.getId();
                        } catch (Resources.NotFoundException unused) {
                        }
                        if (id2 != 0) {
                            View viewFindViewById = this.f1879b.get(id2);
                            if (viewFindViewById == null && (viewFindViewById = findViewById(id2)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
                                onViewAdded(viewFindViewById);
                            }
                            if (viewFindViewById != this) {
                                constraintWidget = viewFindViewById == null ? null : ((a) viewFindViewById.getLayoutParams()).f1927q0;
                            }
                            constraintWidget.setDebugName(resourceName);
                        }
                        constraintWidget = dVar;
                        constraintWidget.setDebugName(resourceName);
                    }
                }
                if (this.f1890w != -1) {
                    for (int i16 = 0; i16 < childCount3; i16++) {
                        View childAt2 = getChildAt(i16);
                        if (childAt2.getId() == this.f1890w && (childAt2 instanceof e)) {
                            this.f1888u = ((e) childAt2).getConstraintSet();
                        }
                    }
                }
                d dVar2 = this.f1888u;
                if (dVar2 != null) {
                    dVar2.a(this);
                }
                dVar.removeAllChildren();
                ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1880m;
                int size = arrayList.size();
                if (size > 0) {
                    for (int i17 = 0; i17 < size; i17++) {
                        arrayList.get(i17).updatePreLayout(this);
                    }
                }
                for (int i18 = 0; i18 < childCount3; i18++) {
                    View childAt3 = getChildAt(i18);
                    if (childAt3 instanceof f) {
                        ((f) childAt3).updatePreLayout(this);
                    }
                }
                SparseArray<ConstraintWidget> sparseArray = this.A;
                sparseArray.clear();
                sparseArray.put(0, dVar);
                sparseArray.put(getId(), dVar);
                for (int i19 = 0; i19 < childCount3; i19++) {
                    View childAt4 = getChildAt(i19);
                    sparseArray.put(childAt4.getId(), getViewWidget(childAt4));
                }
                for (int i20 = 0; i20 < childCount3; i20++) {
                    View childAt5 = getChildAt(i20);
                    ConstraintWidget viewWidget2 = getViewWidget(childAt5);
                    if (viewWidget2 != null) {
                        a aVar = (a) childAt5.getLayoutParams();
                        dVar.add(viewWidget2);
                        applyConstraintsFromLayoutParams(zIsInEditMode, childAt5, viewWidget2, aVar, sparseArray);
                    }
                }
            }
            if (z10) {
                dVar.updateHierarchy();
            }
        }
        resolveSystem(dVar, this.f1887t, i10, i11);
        resolveMeasuredDimension(i10, i11, dVar.getWidth(), dVar.getHeight(), dVar.isWidthMeasuredTooSmall(), dVar.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.core.widgets.f)) {
            a aVar = (a) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.f fVar = new androidx.constraintlayout.core.widgets.f();
            aVar.f1927q0 = fVar;
            aVar.f1901d0 = true;
            fVar.setOrientation(aVar.V);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) view;
            bVar.validateParams();
            ((a) view.getLayoutParams()).f1903e0 = true;
            ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1880m;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        this.f1879b.put(view.getId(), view);
        this.f1886s = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1879b.remove(view.getId());
        this.f1881n.remove(getViewWidget(view));
        this.f1880m.remove(view);
        this.f1886s = true;
    }

    public void parseLayoutDescription(int i10) {
        this.f1889v = new c(getContext(), this, i10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1886s = true;
        this.f1892y = -1;
        this.f1893z = -1;
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        b bVar = this.B;
        int i14 = bVar.f1942e;
        int iResolveSizeAndState = View.resolveSizeAndState(i12 + bVar.f1941d, i10, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i13 + i14, i11, 0) & 16777215;
        int iMin = Math.min(this.f1884q, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f1885r, iResolveSizeAndState2);
        if (z10) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z11) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f1892y = iMin;
        this.f1893z = iMin2;
    }

    public void resolveSystem(androidx.constraintlayout.core.widgets.d dVar, int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i13 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.B.captureLayoutInfo(i11, i12, iMax, iMax2, paddingWidth, i13);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        int iMax5 = (iMax3 > 0 || iMax4 > 0) ? isRtl() ? iMax4 : iMax3 : Math.max(0, getPaddingLeft());
        int i14 = size - paddingWidth;
        int i15 = size2 - i13;
        setSelfDimensionBehaviour(dVar, mode, i14, mode2, i15);
        dVar.measure(i10, mode, i14, mode2, i15, this.f1892y, this.f1893z, iMax5, iMax);
    }

    public void setConstraintSet(d dVar) {
        this.f1888u = dVar;
    }

    public void setDesignInformation(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1891x == null) {
                this.f1891x = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f1891x.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i10) {
        int id2 = getId();
        SparseArray<View> sparseArray = this.f1879b;
        sparseArray.remove(id2);
        super.setId(i10);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.f1885r) {
            return;
        }
        this.f1885r = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.f1884q) {
            return;
        }
        this.f1884q = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.f1883p) {
            return;
        }
        this.f1883p = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.f1882o) {
            return;
        }
        this.f1882o = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(j0.a aVar) {
        c cVar = this.f1889v;
        if (cVar != null) {
            cVar.setOnConstraintsChanged(aVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1887t = i10;
        this.f1881n.setOptimizationLevel(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.d r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = r8.B
            int r1 = r0.f1942e
            int r0 = r0.f1941d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r3 = r8.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 0
            if (r10 == r5) goto L30
            if (r10 == 0) goto L25
            if (r10 == r4) goto L1c
            r10 = r2
        L1a:
            r11 = 0
            goto L39
        L1c:
            int r10 = r8.f1884q
            int r10 = r10 - r0
            int r11 = java.lang.Math.min(r10, r11)
            r10 = r2
            goto L39
        L25:
            if (r3 != 0) goto L2e
            int r10 = r8.f1882o
            int r11 = java.lang.Math.max(r7, r10)
            goto L38
        L2e:
            r10 = r6
            goto L1a
        L30:
            if (r3 != 0) goto L38
            int r10 = r8.f1882o
            int r11 = java.lang.Math.max(r7, r10)
        L38:
            r10 = r6
        L39:
            if (r12 == r5) goto L54
            if (r12 == 0) goto L49
            if (r12 == r4) goto L41
        L3f:
            r13 = 0
            goto L5d
        L41:
            int r12 = r8.f1885r
            int r12 = r12 - r1
            int r13 = java.lang.Math.min(r12, r13)
            goto L5d
        L49:
            if (r3 != 0) goto L52
            int r12 = r8.f1883p
            int r13 = java.lang.Math.max(r7, r12)
            goto L5c
        L52:
            r2 = r6
            goto L3f
        L54:
            if (r3 != 0) goto L5c
            int r12 = r8.f1883p
            int r13 = java.lang.Math.max(r7, r12)
        L5c:
            r2 = r6
        L5d:
            int r12 = r9.getWidth()
            if (r11 != r12) goto L69
            int r12 = r9.getHeight()
            if (r13 == r12) goto L6c
        L69:
            r9.invalidateMeasures()
        L6c:
            r9.setX(r7)
            r9.setY(r7)
            int r12 = r8.f1884q
            int r12 = r12 - r0
            r9.setMaxWidth(r12)
            int r12 = r8.f1885r
            int r12 = r12 - r1
            r9.setMaxHeight(r12)
            r9.setMinWidth(r7)
            r9.setMinHeight(r7)
            r9.setHorizontalDimensionBehaviour(r10)
            r9.setWidth(r11)
            r9.setVerticalDimensionBehaviour(r2)
            r9.setHeight(r13)
            int r10 = r8.f1882o
            int r10 = r10 - r0
            r9.setMinWidth(r10)
            int r10 = r8.f1883p
            int r10 = r10 - r1
            r9.setMinHeight(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.d, int, int, int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
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
        return new a(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1879b = new SparseArray<>();
        this.f1880m = new ArrayList<>(4);
        this.f1881n = new androidx.constraintlayout.core.widgets.d();
        this.f1882o = 0;
        this.f1883p = 0;
        this.f1884q = Integer.MAX_VALUE;
        this.f1885r = Integer.MAX_VALUE;
        this.f1886s = true;
        this.f1887t = 257;
        this.f1888u = null;
        this.f1889v = null;
        this.f1890w = -1;
        this.f1891x = new HashMap<>();
        this.f1892y = -1;
        this.f1893z = -1;
        this.A = new SparseArray<>();
        this.B = new b(this);
        a(attributeSet, i10);
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public int f1894a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f1895a0;

        /* renamed from: b, reason: collision with root package name */
        public int f1896b;

        /* renamed from: b0, reason: collision with root package name */
        public boolean f1897b0;

        /* renamed from: c, reason: collision with root package name */
        public float f1898c;

        /* renamed from: c0, reason: collision with root package name */
        public boolean f1899c0;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1900d;

        /* renamed from: d0, reason: collision with root package name */
        public boolean f1901d0;

        /* renamed from: e, reason: collision with root package name */
        public int f1902e;

        /* renamed from: e0, reason: collision with root package name */
        public boolean f1903e0;

        /* renamed from: f, reason: collision with root package name */
        public int f1904f;

        /* renamed from: f0, reason: collision with root package name */
        public boolean f1905f0;

        /* renamed from: g, reason: collision with root package name */
        public int f1906g;

        /* renamed from: g0, reason: collision with root package name */
        public int f1907g0;

        /* renamed from: h, reason: collision with root package name */
        public int f1908h;

        /* renamed from: h0, reason: collision with root package name */
        public int f1909h0;

        /* renamed from: i, reason: collision with root package name */
        public int f1910i;

        /* renamed from: i0, reason: collision with root package name */
        public int f1911i0;

        /* renamed from: j, reason: collision with root package name */
        public int f1912j;

        /* renamed from: j0, reason: collision with root package name */
        public int f1913j0;

        /* renamed from: k, reason: collision with root package name */
        public int f1914k;

        /* renamed from: k0, reason: collision with root package name */
        public int f1915k0;

        /* renamed from: l, reason: collision with root package name */
        public int f1916l;

        /* renamed from: l0, reason: collision with root package name */
        public int f1917l0;

        /* renamed from: m, reason: collision with root package name */
        public int f1918m;

        /* renamed from: m0, reason: collision with root package name */
        public float f1919m0;

        /* renamed from: n, reason: collision with root package name */
        public int f1920n;

        /* renamed from: n0, reason: collision with root package name */
        public int f1921n0;

        /* renamed from: o, reason: collision with root package name */
        public int f1922o;

        /* renamed from: o0, reason: collision with root package name */
        public int f1923o0;

        /* renamed from: p, reason: collision with root package name */
        public int f1924p;

        /* renamed from: p0, reason: collision with root package name */
        public float f1925p0;

        /* renamed from: q, reason: collision with root package name */
        public int f1926q;

        /* renamed from: q0, reason: collision with root package name */
        public ConstraintWidget f1927q0;

        /* renamed from: r, reason: collision with root package name */
        public float f1928r;

        /* renamed from: s, reason: collision with root package name */
        public int f1929s;

        /* renamed from: t, reason: collision with root package name */
        public int f1930t;

        /* renamed from: u, reason: collision with root package name */
        public int f1931u;

        /* renamed from: v, reason: collision with root package name */
        public int f1932v;

        /* renamed from: w, reason: collision with root package name */
        public final int f1933w;

        /* renamed from: x, reason: collision with root package name */
        public int f1934x;

        /* renamed from: y, reason: collision with root package name */
        public final int f1935y;

        /* renamed from: z, reason: collision with root package name */
        public int f1936z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0018a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f1937a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1937a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1894a = -1;
            this.f1896b = -1;
            this.f1898c = -1.0f;
            this.f1900d = true;
            this.f1902e = -1;
            this.f1904f = -1;
            this.f1906g = -1;
            this.f1908h = -1;
            this.f1910i = -1;
            this.f1912j = -1;
            this.f1914k = -1;
            this.f1916l = -1;
            this.f1918m = -1;
            this.f1920n = -1;
            this.f1922o = -1;
            this.f1924p = -1;
            this.f1926q = 0;
            this.f1928r = 0.0f;
            this.f1929s = -1;
            this.f1930t = -1;
            this.f1931u = -1;
            this.f1932v = -1;
            this.f1933w = Integer.MIN_VALUE;
            this.f1934x = Integer.MIN_VALUE;
            this.f1935y = Integer.MIN_VALUE;
            this.f1936z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1895a0 = true;
            this.f1897b0 = true;
            this.f1899c0 = false;
            this.f1901d0 = false;
            this.f1903e0 = false;
            this.f1905f0 = false;
            this.f1907g0 = -1;
            this.f1909h0 = -1;
            this.f1911i0 = -1;
            this.f1913j0 = -1;
            this.f1915k0 = Integer.MIN_VALUE;
            this.f1917l0 = Integer.MIN_VALUE;
            this.f1919m0 = 0.5f;
            this.f1927q0 = new ConstraintWidget();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = C0018a.f1937a.get(index);
                switch (i11) {
                    case 1:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1924p);
                        this.f1924p = resourceId;
                        if (resourceId == -1) {
                            this.f1924p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f1926q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1926q);
                        break;
                    case 4:
                        float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f1928r) % 360.0f;
                        this.f1928r = f10;
                        if (f10 < 0.0f) {
                            this.f1928r = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f1894a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1894a);
                        break;
                    case 6:
                        this.f1896b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1896b);
                        break;
                    case 7:
                        this.f1898c = typedArrayObtainStyledAttributes.getFloat(index, this.f1898c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1902e);
                        this.f1902e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1902e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1904f);
                        this.f1904f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1904f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1906g);
                        this.f1906g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1906g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1908h);
                        this.f1908h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1908h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1910i);
                        this.f1910i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1910i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1912j);
                        this.f1912j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1912j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1914k);
                        this.f1914k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1914k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1916l);
                        this.f1916l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1916l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1918m);
                        this.f1918m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1918m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1929s);
                        this.f1929s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1929s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1930t);
                        this.f1930t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1930t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1931u);
                        this.f1931u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1931u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1932v);
                        this.f1932v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1932v = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f1933w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1933w);
                        break;
                    case 22:
                        this.f1934x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1934x);
                        break;
                    case 23:
                        this.f1935y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1935y);
                        break;
                    case 24:
                        this.f1936z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1936z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.W = typedArrayObtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case 28:
                        this.X = typedArrayObtainStyledAttributes.getBoolean(index, this.X);
                        break;
                    case 29:
                        this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 30:
                        this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 31:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.L = i12;
                        if (i12 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.M = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    case 36:
                        try {
                            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.S));
                        this.M = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                d.f(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                                break;
                            case 46:
                                this.I = typedArrayObtainStyledAttributes.getFloat(index, this.I);
                                break;
                            case 47:
                                this.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                break;
                            case 50:
                                this.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                                break;
                            case 51:
                                this.Y = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1920n);
                                this.f1920n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f1920n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1922o);
                                this.f1922o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f1922o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        d.e(this, typedArrayObtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        d.e(this, typedArrayObtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 67:
                                        this.f1900d = typedArrayObtainStyledAttributes.getBoolean(index, this.f1900d);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            validate();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public void validate() {
            this.f1901d0 = false;
            this.f1895a0 = true;
            this.f1897b0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.W) {
                this.f1895a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.X) {
                this.f1897b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f1895a0 = false;
                if (i10 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.W = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f1897b0 = false;
                if (i11 == 0 && this.M == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.X = true;
                }
            }
            if (this.f1898c == -1.0f && this.f1894a == -1 && this.f1896b == -1) {
                return;
            }
            this.f1901d0 = true;
            this.f1895a0 = true;
            this.f1897b0 = true;
            if (!(this.f1927q0 instanceof androidx.constraintlayout.core.widgets.f)) {
                this.f1927q0 = new androidx.constraintlayout.core.widgets.f();
            }
            ((androidx.constraintlayout.core.widgets.f) this.f1927q0).setOrientation(this.V);
        }

        public a(int i10, int i11) {
            super(i10, i11);
            this.f1894a = -1;
            this.f1896b = -1;
            this.f1898c = -1.0f;
            this.f1900d = true;
            this.f1902e = -1;
            this.f1904f = -1;
            this.f1906g = -1;
            this.f1908h = -1;
            this.f1910i = -1;
            this.f1912j = -1;
            this.f1914k = -1;
            this.f1916l = -1;
            this.f1918m = -1;
            this.f1920n = -1;
            this.f1922o = -1;
            this.f1924p = -1;
            this.f1926q = 0;
            this.f1928r = 0.0f;
            this.f1929s = -1;
            this.f1930t = -1;
            this.f1931u = -1;
            this.f1932v = -1;
            this.f1933w = Integer.MIN_VALUE;
            this.f1934x = Integer.MIN_VALUE;
            this.f1935y = Integer.MIN_VALUE;
            this.f1936z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1895a0 = true;
            this.f1897b0 = true;
            this.f1899c0 = false;
            this.f1901d0 = false;
            this.f1903e0 = false;
            this.f1905f0 = false;
            this.f1907g0 = -1;
            this.f1909h0 = -1;
            this.f1911i0 = -1;
            this.f1913j0 = -1;
            this.f1915k0 = Integer.MIN_VALUE;
            this.f1917l0 = Integer.MIN_VALUE;
            this.f1919m0 = 0.5f;
            this.f1927q0 = new ConstraintWidget();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1894a = -1;
            this.f1896b = -1;
            this.f1898c = -1.0f;
            this.f1900d = true;
            this.f1902e = -1;
            this.f1904f = -1;
            this.f1906g = -1;
            this.f1908h = -1;
            this.f1910i = -1;
            this.f1912j = -1;
            this.f1914k = -1;
            this.f1916l = -1;
            this.f1918m = -1;
            this.f1920n = -1;
            this.f1922o = -1;
            this.f1924p = -1;
            this.f1926q = 0;
            this.f1928r = 0.0f;
            this.f1929s = -1;
            this.f1930t = -1;
            this.f1931u = -1;
            this.f1932v = -1;
            this.f1933w = Integer.MIN_VALUE;
            this.f1934x = Integer.MIN_VALUE;
            this.f1935y = Integer.MIN_VALUE;
            this.f1936z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1895a0 = true;
            this.f1897b0 = true;
            this.f1899c0 = false;
            this.f1901d0 = false;
            this.f1903e0 = false;
            this.f1905f0 = false;
            this.f1907g0 = -1;
            this.f1909h0 = -1;
            this.f1911i0 = -1;
            this.f1913j0 = -1;
            this.f1915k0 = Integer.MIN_VALUE;
            this.f1917l0 = Integer.MIN_VALUE;
            this.f1919m0 = 0.5f;
            this.f1927q0 = new ConstraintWidget();
        }
    }
}
