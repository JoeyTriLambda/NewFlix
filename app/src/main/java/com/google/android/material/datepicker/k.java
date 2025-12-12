package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class k extends RecyclerView.k {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f9064a = a0.e(null);

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f9065b = a0.e(null);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9066c;

    public k(MaterialCalendar materialCalendar) {
        this.f9066c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar) {
        Long l10;
        if ((recyclerView.getAdapter() instanceof c0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            c0 c0Var = (c0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            MaterialCalendar materialCalendar = this.f9066c;
            for (w0.d<Long, Long> dVar : materialCalendar.f9004j0.getSelectedRanges()) {
                Long l11 = dVar.f20843a;
                if (l11 != null && (l10 = dVar.f20844b) != null) {
                    long jLongValue = l11.longValue();
                    Calendar calendar = this.f9064a;
                    calendar.setTimeInMillis(jLongValue);
                    long jLongValue2 = l10.longValue();
                    Calendar calendar2 = this.f9065b;
                    calendar2.setTimeInMillis(jLongValue2);
                    int i10 = calendar.get(1) - c0Var.f9053d.f9005k0.f9022b.f9090n;
                    int i11 = calendar2.get(1) - c0Var.f9053d.f9005k0.f9022b.f9090n;
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i11);
                    int spanCount = i10 / gridLayoutManager.getSpanCount();
                    int spanCount2 = i11 / gridLayoutManager.getSpanCount();
                    int i12 = spanCount;
                    while (i12 <= spanCount2) {
                        if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i12) != null) {
                            canvas.drawRect((i12 != spanCount || viewFindViewByPosition == null) ? 0 : (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft(), r10.getTop() + materialCalendar.f9009o0.f9048d.f9037a.top, (i12 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft(), r10.getBottom() - materialCalendar.f9009o0.f9048d.f9037a.bottom, materialCalendar.f9009o0.f9052h);
                        }
                        i12++;
                    }
                }
            }
        }
    }
}
