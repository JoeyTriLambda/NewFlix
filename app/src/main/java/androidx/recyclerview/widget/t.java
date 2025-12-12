package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public final class t {
    public static int a(RecyclerView.w wVar, o oVar, View view, View view2, RecyclerView.l lVar, boolean z10) {
        if (lVar.getChildCount() == 0 || wVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(lVar.getPosition(view) - lVar.getPosition(view2)) + 1;
        }
        return Math.min(oVar.getTotalSpace(), oVar.getDecoratedEnd(view2) - oVar.getDecoratedStart(view));
    }

    public static int b(RecyclerView.w wVar, o oVar, View view, View view2, RecyclerView.l lVar, boolean z10, boolean z11) {
        if (lVar.getChildCount() == 0 || wVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z11 ? Math.max(0, (wVar.getItemCount() - Math.max(lVar.getPosition(view), lVar.getPosition(view2))) - 1) : Math.max(0, Math.min(lVar.getPosition(view), lVar.getPosition(view2)));
        if (z10) {
            return Math.round((iMax * (Math.abs(oVar.getDecoratedEnd(view2) - oVar.getDecoratedStart(view)) / (Math.abs(lVar.getPosition(view) - lVar.getPosition(view2)) + 1))) + (oVar.getStartAfterPadding() - oVar.getDecoratedStart(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.w wVar, o oVar, View view, View view2, RecyclerView.l lVar, boolean z10) {
        if (lVar.getChildCount() == 0 || wVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return wVar.getItemCount();
        }
        return (int) (((oVar.getDecoratedEnd(view2) - oVar.getDecoratedStart(view)) / (Math.abs(lVar.getPosition(view) - lVar.getPosition(view2)) + 1)) * wVar.getItemCount());
    }
}
