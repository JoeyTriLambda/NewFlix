package fd;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: GridSpacingItemDecoration.java */
/* loaded from: classes2.dex */
public final class d extends RecyclerView.k {

    /* renamed from: a, reason: collision with root package name */
    public final int f11541a;

    public d(int i10) {
        this.f11541a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.w wVar) {
        int i10 = this.f11541a;
        rect.left = i10;
        rect.right = i10;
        rect.bottom = i10;
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = i10;
        } else {
            rect.top = 0;
        }
    }
}
