package flix.com.vision.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class StickyRecyclerView extends RecyclerView {
    public StickyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i10, int i11) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        int i12 = Resources.getSystem().getDisplayMetrics().widthPixels;
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition());
        View viewFindViewByPosition2 = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
        int width = (i12 - viewFindViewByPosition.getWidth()) / 2;
        int width2 = viewFindViewByPosition2.getWidth() + ((i12 - viewFindViewByPosition2.getWidth()) / 2);
        int left = viewFindViewByPosition.getLeft();
        int right = viewFindViewByPosition2.getRight();
        int i13 = left - width;
        int i14 = width2 - right;
        if (Math.abs(i10) >= 1000) {
            if (i10 > 0) {
                smoothScrollBy(i13, 0);
            } else {
                smoothScrollBy(-i14, 0);
            }
            return true;
        }
        int i15 = i12 / 2;
        if (left > i15) {
            smoothScrollBy(-i14, 0);
        } else if (right >= i15 && i10 > 0) {
            smoothScrollBy(-i14, 0);
        } else {
            smoothScrollBy(i13, 0);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
        if (i10 == 0) {
            try {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
                int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
                View viewFindViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition());
                View viewFindViewByPosition2 = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
                int width = (i11 - viewFindViewByPosition.getWidth()) / 2;
                int width2 = ((i11 - viewFindViewByPosition2.getWidth()) / 2) + viewFindViewByPosition2.getWidth();
                int left = viewFindViewByPosition.getLeft();
                int right = viewFindViewByPosition2.getRight();
                int i12 = left - width;
                int i13 = width2 - right;
                if (left > i11 / 2) {
                    smoothScrollBy(-i13, 0);
                } else if (right < i11 / 2) {
                    smoothScrollBy(i12, 0);
                }
            } catch (Exception unused) {
            }
        }
    }
}
