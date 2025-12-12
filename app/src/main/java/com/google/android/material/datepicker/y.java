package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SmoothCalendarLayoutManager.java */
/* loaded from: classes.dex */
public class y extends LinearLayoutManager {

    /* compiled from: SmoothCalendarLayoutManager.java */
    public class a extends androidx.recyclerview.widget.m {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.m
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public y(Context context, int i10) {
        super(context, i10, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.w wVar, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }
}
