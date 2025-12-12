package flix.com.vision.helpers;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;

/* loaded from: classes2.dex */
public class CenterLayoutManager extends LinearLayoutManager {

    public static class a extends m {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.m
        public int calculateDtToFit(int i10, int i11, int i12, int i13, int i14) {
            return (((i13 - i12) / 2) + i12) - (((i11 - i10) / 2) + i10);
        }
    }

    public CenterLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int getExtraLayoutSpace(RecyclerView.w wVar) {
        return 2000;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.w wVar, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }
}
