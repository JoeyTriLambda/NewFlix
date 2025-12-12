package s1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.b0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Picker.java */
/* loaded from: classes.dex */
public class b extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f18983b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f18984m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<s1.c> f18985n;

    /* renamed from: o, reason: collision with root package name */
    public final float f18986o;

    /* renamed from: p, reason: collision with root package name */
    public final float f18987p;

    /* renamed from: q, reason: collision with root package name */
    public final float f18988q;

    /* renamed from: r, reason: collision with root package name */
    public final int f18989r;

    /* renamed from: s, reason: collision with root package name */
    public final DecelerateInterpolator f18990s;

    /* renamed from: t, reason: collision with root package name */
    public float f18991t;

    /* renamed from: u, reason: collision with root package name */
    public float f18992u;

    /* renamed from: v, reason: collision with root package name */
    public int f18993v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f18994w;

    /* renamed from: x, reason: collision with root package name */
    public final int f18995x;

    /* renamed from: y, reason: collision with root package name */
    public int f18996y;

    /* renamed from: z, reason: collision with root package name */
    public final a f18997z;

    /* compiled from: Picker.java */
    public class a extends b0 {
        public a() {
        }

        @Override // androidx.leanback.widget.b0
        public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.z zVar, int i10, int i11) {
            b bVar = b.this;
            int iIndexOf = bVar.f18984m.indexOf(recyclerView);
            bVar.c(iIndexOf);
            if (zVar != null) {
                bVar.onColumnValueChanged(iIndexOf, bVar.f18985n.get(iIndexOf).getMinValue() + i10);
            }
        }
    }

    /* compiled from: Picker.java */
    /* renamed from: s1.b$b, reason: collision with other inner class name */
    public class C0245b extends RecyclerView.Adapter<c> {

        /* renamed from: d, reason: collision with root package name */
        public final int f18999d;

        /* renamed from: e, reason: collision with root package name */
        public final int f19000e;

        /* renamed from: f, reason: collision with root package name */
        public final int f19001f;

        /* renamed from: g, reason: collision with root package name */
        public final s1.c f19002g;

        public C0245b(int i10, int i11, int i12) {
            this.f18999d = i10;
            this.f19000e = i12;
            this.f19001f = i11;
            this.f19002g = b.this.f18985n.get(i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            s1.c cVar = this.f19002g;
            if (cVar == null) {
                return 0;
            }
            return cVar.getCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(c cVar, int i10) {
            s1.c cVar2;
            TextView textView = cVar.f19004u;
            if (textView != null && (cVar2 = this.f19002g) != null) {
                textView.setText(cVar2.getLabelFor(cVar2.getMinValue() + i10));
            }
            b bVar = b.this;
            ArrayList arrayList = bVar.f18984m;
            int i11 = this.f19000e;
            bVar.b(cVar.f4041a, ((VerticalGridView) arrayList.get(i11)).getSelectedPosition() == i10, i11, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f18999d, viewGroup, false);
            int i11 = this.f19001f;
            return new c(viewInflate, i11 != 0 ? (TextView) viewInflate.findViewById(i11) : (TextView) viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(c cVar) {
            cVar.f4041a.setFocusable(b.this.isActivated());
        }
    }

    /* compiled from: Picker.java */
    public static class c extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final TextView f19004u;

        public c(View view, TextView textView) {
            super(view);
            this.f19004u = textView;
        }
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18984m = new ArrayList();
        this.f18991t = 3.0f;
        this.f18992u = 1.0f;
        this.f18993v = 0;
        this.f18994w = new ArrayList();
        this.f18995x = R.layout.lb_picker_item;
        this.f18996y = 0;
        this.f18997z = new a();
        setEnabled(true);
        setDescendantFocusability(262144);
        this.f18987p = 1.0f;
        this.f18986o = 1.0f;
        this.f18988q = 0.5f;
        this.f18989r = 200;
        this.f18990s = new DecelerateInterpolator(2.5f);
        new AccelerateInterpolator(2.5f);
        this.f18983b = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, (ViewGroup) this, true)).findViewById(R.id.picker);
    }

    public final void a(View view, boolean z10, float f10, DecelerateInterpolator decelerateInterpolator) {
        view.animate().cancel();
        if (z10) {
            view.animate().alpha(f10).setDuration(this.f18989r).setInterpolator(decelerateInterpolator).start();
        } else {
            view.setAlpha(f10);
        }
    }

    public final void b(View view, boolean z10, int i10, boolean z11) {
        boolean z12 = i10 == this.f18993v || !hasFocus();
        DecelerateInterpolator decelerateInterpolator = this.f18990s;
        if (z10) {
            if (z12) {
                a(view, z11, this.f18987p, decelerateInterpolator);
                return;
            } else {
                a(view, z11, this.f18986o, decelerateInterpolator);
                return;
            }
        }
        if (z12) {
            a(view, z11, this.f18988q, decelerateInterpolator);
        } else {
            a(view, z11, 0.0f, decelerateInterpolator);
        }
    }

    public final void c(int i10) {
        VerticalGridView verticalGridView = (VerticalGridView) this.f18984m.get(i10);
        int selectedPosition = verticalGridView.getSelectedPosition();
        int i11 = 0;
        while (i11 < verticalGridView.getAdapter().getItemCount()) {
            View viewFindViewByPosition = verticalGridView.getLayoutManager().findViewByPosition(i11);
            if (viewFindViewByPosition != null) {
                b(viewFindViewByPosition, selectedPosition == i11, i10, true);
            }
            i11++;
        }
    }

    public final void d() {
        for (int i10 = 0; i10 < getColumnsCount(); i10++) {
            e((VerticalGridView) this.f18984m.get(i10));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public final void e(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) o1.a.a(activatedVisibleItemCount, 1.0f, verticalGridView.getVerticalSpacing(), getPickerItemHeightPixels() * activatedVisibleItemCount);
        verticalGridView.setLayoutParams(layoutParams);
    }

    public float getActivatedVisibleItemCount() {
        return this.f18991t;
    }

    public s1.c getColumnAt(int i10) {
        ArrayList<s1.c> arrayList = this.f18985n;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i10);
    }

    public int getColumnsCount() {
        ArrayList<s1.c> arrayList = this.f18985n;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    public final int getPickerItemLayoutId() {
        return this.f18995x;
    }

    public final int getPickerItemTextViewId() {
        return this.f18996y;
    }

    public int getSelectedColumn() {
        return this.f18993v;
    }

    public final CharSequence getSeparator() {
        return (CharSequence) this.f18994w.get(0);
    }

    public final List<CharSequence> getSeparators() {
        return this.f18994w;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public void onColumnValueChanged(int i10, int i11) {
        s1.c cVar = this.f18985n.get(i10);
        if (cVar.getCurrentValue() != i11) {
            cVar.setCurrentValue(i11);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int selectedColumn = getSelectedColumn();
        ArrayList arrayList = this.f18984m;
        if (selectedColumn < arrayList.size()) {
            return ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus(i10, rect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f18984m;
            if (i10 >= arrayList.size()) {
                return;
            }
            if (((VerticalGridView) arrayList.get(i10)).hasFocus()) {
                setSelectedColumn(i10);
            }
            i10++;
        }
    }

    @Override // android.view.View
    public void setActivated(boolean z10) {
        ArrayList arrayList;
        if (z10 == isActivated()) {
            super.setActivated(z10);
            return;
        }
        super.setActivated(z10);
        boolean zHasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z10 && zHasFocus && isFocusable()) {
            requestFocus();
        }
        int i10 = 0;
        while (true) {
            int columnsCount = getColumnsCount();
            arrayList = this.f18984m;
            if (i10 >= columnsCount) {
                break;
            }
            ((VerticalGridView) arrayList.get(i10)).setFocusable(z10);
            i10++;
        }
        d();
        boolean zIsActivated = isActivated();
        for (int i11 = 0; i11 < getColumnsCount(); i11++) {
            VerticalGridView verticalGridView = (VerticalGridView) arrayList.get(i11);
            for (int i12 = 0; i12 < verticalGridView.getChildCount(); i12++) {
                verticalGridView.getChildAt(i12).setFocusable(zIsActivated);
            }
        }
        if (z10 && zHasFocus && selectedColumn >= 0) {
            ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.f18991t != f10) {
            this.f18991t = f10;
            if (isActivated()) {
                d();
            }
        }
    }

    public void setColumnAt(int i10, s1.c cVar) {
        this.f18985n.set(i10, cVar);
        VerticalGridView verticalGridView = (VerticalGridView) this.f18984m.get(i10);
        C0245b c0245b = (C0245b) verticalGridView.getAdapter();
        if (c0245b != null) {
            c0245b.notifyDataSetChanged();
        }
        verticalGridView.setSelectedPosition(cVar.getCurrentValue() - cVar.getMinValue());
    }

    public void setColumnValue(int i10, int i11, boolean z10) {
        s1.c cVar = this.f18985n.get(i10);
        if (cVar.getCurrentValue() != i11) {
            cVar.setCurrentValue(i11);
            VerticalGridView verticalGridView = (VerticalGridView) this.f18984m.get(i10);
            if (verticalGridView != null) {
                int minValue = i11 - this.f18985n.get(i10).getMinValue();
                if (z10) {
                    verticalGridView.setSelectedPositionSmooth(minValue);
                } else {
                    verticalGridView.setSelectedPosition(minValue);
                }
            }
        }
    }

    public void setColumns(List<s1.c> list) {
        ArrayList arrayList = this.f18994w;
        if (arrayList.size() == 0) {
            throw new IllegalStateException("Separators size is: " + arrayList.size() + ". At least one separator must be provided");
        }
        if (arrayList.size() == 1) {
            CharSequence charSequence = (CharSequence) arrayList.get(0);
            arrayList.clear();
            arrayList.add("");
            for (int i10 = 0; i10 < list.size() - 1; i10++) {
                arrayList.add(charSequence);
            }
            arrayList.add("");
        } else if (arrayList.size() != list.size() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " mustequal the size of columns: " + list.size() + " + 1");
        }
        ArrayList arrayList2 = this.f18984m;
        arrayList2.clear();
        ViewGroup viewGroup = this.f18983b;
        viewGroup.removeAllViews();
        ArrayList<s1.c> arrayList3 = new ArrayList<>(list);
        this.f18985n = arrayList3;
        if (this.f18993v > arrayList3.size() - 1) {
            this.f18993v = this.f18985n.size() - 1;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int columnsCount = getColumnsCount();
        if (!TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
            TextView textView = (TextView) layoutInflaterFrom.inflate(R.layout.lb_picker_separator, viewGroup, false);
            textView.setText((CharSequence) arrayList.get(0));
            viewGroup.addView(textView);
        }
        int i11 = 0;
        while (i11 < columnsCount) {
            VerticalGridView verticalGridView = (VerticalGridView) layoutInflaterFrom.inflate(R.layout.lb_picker_column, viewGroup, false);
            e(verticalGridView);
            verticalGridView.setWindowAlignment(0);
            verticalGridView.setHasFixedSize(false);
            verticalGridView.setFocusable(isActivated());
            verticalGridView.setItemViewCacheSize(0);
            arrayList2.add(verticalGridView);
            viewGroup.addView(verticalGridView);
            int i12 = i11 + 1;
            if (!TextUtils.isEmpty((CharSequence) arrayList.get(i12))) {
                TextView textView2 = (TextView) layoutInflaterFrom.inflate(R.layout.lb_picker_separator, viewGroup, false);
                textView2.setText((CharSequence) arrayList.get(i12));
                viewGroup.addView(textView2);
            }
            getContext();
            verticalGridView.setAdapter(new C0245b(getPickerItemLayoutId(), getPickerItemTextViewId(), i11));
            verticalGridView.setOnChildViewHolderSelectedListener(this.f18997z);
            i11 = i12;
        }
    }

    public final void setPickerItemTextViewId(int i10) {
        this.f18996y = i10;
    }

    public void setSelectedColumn(int i10) {
        if (this.f18993v != i10) {
            this.f18993v = i10;
            for (int i11 = 0; i11 < this.f18984m.size(); i11++) {
                c(i11);
            }
        }
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(charSequence));
    }

    public final void setSeparators(List<CharSequence> list) {
        ArrayList arrayList = this.f18994w;
        arrayList.clear();
        arrayList.addAll(list);
    }

    public void setVisibleItemCount(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.f18992u != f10) {
            this.f18992u = f10;
            if (isActivated()) {
                return;
            }
            d();
        }
    }
}
