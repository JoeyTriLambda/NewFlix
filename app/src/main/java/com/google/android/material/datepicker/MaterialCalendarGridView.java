package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Iterator;
import x0.j0;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f9020b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9021m;

    public class a extends x0.a {
        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View a(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        int i10;
        int width3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        u adapter = getAdapter();
        d<?> dVar = adapter.f9098m;
        c cVar = adapter.f9100o;
        int iMax = Math.max(adapter.a(), getFirstVisiblePosition());
        int iA3 = adapter.a();
        t tVar = adapter.f9097b;
        int iMin = Math.min((iA3 + tVar.f9092p) - 1, getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        Iterator<w0.d<Long, Long>> it = dVar.getSelectedRanges().iterator();
        while (it.hasNext()) {
            w0.d<Long, Long> next = it.next();
            Long l10 = next.f20843a;
            if (l10 != null) {
                Long l11 = next.f20844b;
                if (l11 != null) {
                    long jLongValue = l10.longValue();
                    long jLongValue2 = l11.longValue();
                    Long lValueOf = Long.valueOf(jLongValue);
                    Long lValueOf2 = Long.valueOf(jLongValue2);
                    if (!(item == null || item2 == null || lValueOf == null || lValueOf2 == null || lValueOf.longValue() > item2.longValue() || lValueOf2.longValue() < item.longValue())) {
                        boolean zIsLayoutRtl = i7.t.isLayoutRtl(this);
                        long jLongValue3 = item.longValue();
                        Calendar calendar = materialCalendarGridView.f9020b;
                        if (jLongValue < jLongValue3) {
                            width = iMax % tVar.f9091o == 0 ? 0 : !zIsLayoutRtl ? materialCalendarGridView.a(iMax - 1).getRight() : materialCalendarGridView.a(iMax - 1).getLeft();
                            iA = iMax;
                        } else {
                            calendar.setTimeInMillis(jLongValue);
                            iA = adapter.a() + (calendar.get(5) - 1);
                            View viewA = materialCalendarGridView.a(iA);
                            width = (viewA.getWidth() / 2) + viewA.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            width2 = (iMin + 1) % tVar.f9091o == 0 ? getWidth() : !zIsLayoutRtl ? materialCalendarGridView.a(iMin).getRight() : materialCalendarGridView.a(iMin).getLeft();
                            iA2 = iMin;
                        } else {
                            calendar.setTimeInMillis(jLongValue2);
                            iA2 = adapter.a() + (calendar.get(5) - 1);
                            View viewA2 = materialCalendarGridView.a(iA2);
                            width2 = (viewA2.getWidth() / 2) + viewA2.getLeft();
                        }
                        int itemId = (int) adapter.getItemId(iA);
                        int i11 = iMax;
                        int i12 = iMin;
                        int itemId2 = (int) adapter.getItemId(iA2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            u uVar = adapter;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View viewA3 = materialCalendarGridView.a(numColumns);
                            int top = viewA3.getTop() + cVar.f9045a.f9037a.top;
                            Iterator<w0.d<Long, Long>> it2 = it;
                            int bottom = viewA3.getBottom() - cVar.f9045a.f9037a.bottom;
                            if (zIsLayoutRtl) {
                                int i13 = iA2 > numColumns2 ? 0 : width2;
                                int width4 = numColumns > iA ? getWidth() : width;
                                i10 = i13;
                                width3 = width4;
                            } else {
                                i10 = numColumns > iA ? 0 : width;
                                width3 = iA2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i10, top, width3, bottom, cVar.f9052h);
                            itemId++;
                            materialCalendarGridView = this;
                            itemId2 = itemId2;
                            adapter = uVar;
                            it = it2;
                        }
                        materialCalendarGridView = this;
                        iMax = i11;
                        iMin = i12;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (!z10) {
            super.onFocusChanged(false, i10, rect);
            return;
        }
        if (i10 == 33) {
            u adapter = getAdapter();
            setSelection((adapter.a() + adapter.f9097b.f9092p) - 1);
        } else if (i10 == 130) {
            setSelection(getAdapter().a());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!this.f9021m) {
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i10) {
        if (i10 < getAdapter().a()) {
            super.setSelection(getAdapter().a());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9020b = a0.e(null);
        if (p.q(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f9021m = p.r(getContext(), R.attr.nestedScrollable);
        j0.setAccessibilityDelegate(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof u)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), u.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public u getAdapter() {
        return (u) super.getAdapter();
    }
}
