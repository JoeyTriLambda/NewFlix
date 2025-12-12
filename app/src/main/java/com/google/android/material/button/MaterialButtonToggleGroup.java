package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import i7.r;
import i7.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import q7.l;
import x0.j0;
import x0.k;
import y0.d;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: v, reason: collision with root package name */
    public static final int f8896v = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8897b;

    /* renamed from: m, reason: collision with root package name */
    public final e f8898m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashSet<d> f8899n;

    /* renamed from: o, reason: collision with root package name */
    public final a f8900o;

    /* renamed from: p, reason: collision with root package name */
    public Integer[] f8901p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8902q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8903r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8904s;

    /* renamed from: t, reason: collision with root package name */
    public final int f8905t;

    /* renamed from: u, reason: collision with root package name */
    public HashSet f8906u;

    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
        }
    }

    public class b extends x0.a {
        public b() {
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            int i10;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            int i11 = MaterialButtonToggleGroup.f8896v;
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            materialButtonToggleGroup.getClass();
            if (view instanceof MaterialButton) {
                int i12 = 0;
                for (int i13 = 0; i13 < materialButtonToggleGroup.getChildCount(); i13++) {
                    if (materialButtonToggleGroup.getChildAt(i13) == view) {
                        i10 = i12;
                        break;
                    }
                    if ((materialButtonToggleGroup.getChildAt(i13) instanceof MaterialButton) && materialButtonToggleGroup.d(i13)) {
                        i12++;
                    }
                }
                i10 = -1;
            } else {
                i10 = -1;
            }
            dVar.setCollectionItemInfo(d.f.obtain(0, 1, i10, 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public static class c {

        /* renamed from: e, reason: collision with root package name */
        public static final q7.a f8909e = new q7.a(0.0f);

        /* renamed from: a, reason: collision with root package name */
        public final q7.c f8910a;

        /* renamed from: b, reason: collision with root package name */
        public final q7.c f8911b;

        /* renamed from: c, reason: collision with root package name */
        public final q7.c f8912c;

        /* renamed from: d, reason: collision with root package name */
        public final q7.c f8913d;

        public c(q7.c cVar, q7.c cVar2, q7.c cVar3, q7.c cVar4) {
            this.f8910a = cVar;
            this.f8911b = cVar3;
            this.f8912c = cVar4;
            this.f8913d = cVar2;
        }

        public static c bottom(c cVar) {
            q7.c cVar2 = cVar.f8913d;
            q7.c cVar3 = cVar.f8912c;
            q7.a aVar = f8909e;
            return new c(aVar, cVar2, aVar, cVar3);
        }

        public static c end(c cVar, View view) {
            return t.isLayoutRtl(view) ? left(cVar) : right(cVar);
        }

        public static c left(c cVar) {
            q7.c cVar2 = cVar.f8910a;
            q7.a aVar = f8909e;
            return new c(cVar2, cVar.f8913d, aVar, aVar);
        }

        public static c right(c cVar) {
            q7.c cVar2 = cVar.f8911b;
            q7.c cVar3 = cVar.f8912c;
            q7.a aVar = f8909e;
            return new c(aVar, aVar, cVar2, cVar3);
        }

        public static c start(c cVar, View view) {
            return t.isLayoutRtl(view) ? right(cVar) : left(cVar);
        }

        public static c top(c cVar) {
            q7.c cVar2 = cVar.f8910a;
            q7.a aVar = f8909e;
            return new c(cVar2, aVar, cVar.f8911b, aVar);
        }
    }

    public interface d {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    public class e implements MaterialButton.b {
        public e() {
        }

        public void onPressedChanged(MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (d(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && d(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(j0.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f8898m);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton materialButtonC = c(i10);
            int iMin = Math.min(materialButtonC.getStrokeWidth(), c(i10 - 1).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButtonC.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                k.setMarginEnd(layoutParams2, 0);
                k.setMarginStart(layoutParams2, -iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                k.setMarginStart(layoutParams2, 0);
            }
            materialButtonC.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c(firstVisibleChildIndex).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            k.setMarginEnd(layoutParams3, 0);
            k.setMarginStart(layoutParams3, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    public void addOnButtonCheckedListener(d dVar) {
        this.f8899n.add(dVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.isChecked());
        l shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f8897b.add(new c(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
        materialButton.setEnabled(isEnabled());
        j0.setAccessibilityDelegate(materialButton, new b());
    }

    public final void b(int i10, boolean z10) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f8906u);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f8903r && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            if (!this.f8904s || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        }
        e(hashSet);
    }

    public final MaterialButton c(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    public void clearChecked() {
        e(new HashSet());
    }

    public final boolean d(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f8900o);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(c(i10), Integer.valueOf(i10));
        }
        this.f8901p = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(Set<Integer> set) {
        HashSet hashSet = this.f8906u;
        this.f8906u = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = c(i10).getId();
            boolean zContains = set.contains(Integer.valueOf(id2));
            View viewFindViewById = findViewById(id2);
            if (viewFindViewById instanceof MaterialButton) {
                this.f8902q = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f8902q = false;
            }
            if (hashSet.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                boolean zContains2 = set.contains(Integer.valueOf(id2));
                Iterator<d> it = this.f8899n.iterator();
                while (it.hasNext()) {
                    it.next().onButtonChecked(this, id2, zContains2);
                }
            }
        }
        invalidate();
    }

    public final void f() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int i10 = 0;
        while (i10 < childCount) {
            MaterialButton materialButtonC = c(i10);
            if (materialButtonC.getVisibility() != 8) {
                l.a builder = materialButtonC.getShapeAppearanceModel().toBuilder();
                c cVarStart = (c) this.f8897b.get(i10);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z10 = getOrientation() == 0;
                    cVarStart = i10 == firstVisibleChildIndex ? z10 ? c.start(cVarStart, this) : c.top(cVarStart) : i10 == lastVisibleChildIndex ? z10 ? c.end(cVarStart, this) : c.bottom(cVarStart) : null;
                }
                if (cVarStart == null) {
                    builder.setAllCornerSizes(0.0f);
                } else {
                    builder.setTopLeftCornerSize(cVarStart.f8910a).setBottomLeftCornerSize(cVarStart.f8913d).setTopRightCornerSize(cVarStart.f8911b).setBottomRightCornerSize(cVarStart.f8912c);
                }
                materialButtonC.setShapeAppearanceModel(builder.build());
            }
            i10++;
        }
    }

    public int getCheckedButtonId() {
        if (!this.f8903r || this.f8906u.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f8906u.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = c(i10).getId();
            if (this.f8906u.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f8901p;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i11;
    }

    public boolean isSingleSelection() {
        return this.f8903r;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f8905t;
        if (i10 != -1) {
            e(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        y0.d.wrap(accessibilityNodeInfo).setCollectionInfo(d.e.obtain(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        f();
        a();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f8897b.remove(iIndexOfChild);
        }
        f();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            c(i10).setEnabled(z10);
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f8904s = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f8903r != z10) {
            this.f8903r = z10;
            clearChecked();
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            c(i10).setA11yClassName((this.f8903r ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8896v;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8897b = new ArrayList();
        this.f8898m = new e();
        this.f8899n = new LinkedHashSet<>();
        this.f8900o = new a();
        this.f8902q = false;
        this.f8906u = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(getContext(), attributeSet, R.styleable.MaterialButtonToggleGroup, i10, i11, new int[0]);
        setSingleSelection(typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f8905t = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f8904s = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialButtonToggleGroup_android_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
        j0.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
