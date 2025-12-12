package flix.com.vision.helpers;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class CenterZoomLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int scrollHorizontallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (getOrientation() != 0) {
            return 0;
        }
        int iScrollHorizontallyBy = super.scrollHorizontallyBy(i10, rVar, wVar);
        float width = getWidth() / 2.0f;
        float f10 = 0.9f * width;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            float fMin = (((Math.min(f10, Math.abs(width - ((getDecoratedLeft(childAt) + getDecoratedRight(childAt)) / 2.0f))) - 0.0f) * (-0.14999998f)) / (f10 - 0.0f)) + 1.0f;
            childAt.setScaleX(fMin);
            childAt.setScaleY(fMin);
        }
        return iScrollHorizontallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int scrollVerticallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (getOrientation() != 1) {
            return 0;
        }
        int iScrollVerticallyBy = super.scrollVerticallyBy(i10, rVar, wVar);
        float height = getHeight() / 2.0f;
        float f10 = 0.9f * height;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            float fMin = (((Math.min(f10, Math.abs(height - ((getDecoratedTop(childAt) + getDecoratedBottom(childAt)) / 2.0f))) - 0.0f) * (-0.14999998f)) / (f10 - 0.0f)) + 1.0f;
            childAt.setScaleX(fMin);
            childAt.setScaleY(fMin);
        }
        return iScrollVerticallyBy;
    }
}
