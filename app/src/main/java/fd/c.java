package fd;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: EqualSpacingItemDecoration.java */
/* loaded from: classes2.dex */
public final class c extends RecyclerView.k {

    /* renamed from: a, reason: collision with root package name */
    public final int f11539a;

    /* renamed from: b, reason: collision with root package name */
    public int f11540b;

    public c(int i10) {
        this(i10, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.w wVar) {
        int adapterPosition = recyclerView.getChildViewHolder(view).getAdapterPosition();
        int itemCount = wVar.getItemCount();
        RecyclerView.l layoutManager = recyclerView.getLayoutManager();
        if (this.f11540b == -1) {
            this.f11540b = layoutManager instanceof GridLayoutManager ? 2 : layoutManager.canScrollHorizontally() ? 0 : 1;
        }
        int i10 = this.f11540b;
        int i11 = this.f11539a;
        if (i10 == 0) {
            rect.left = i11;
            rect.right = adapterPosition == itemCount - 1 ? i11 : 0;
            rect.top = i11;
            rect.bottom = i11;
            return;
        }
        if (i10 == 1) {
            rect.left = i11;
            rect.right = i11;
            rect.top = i11;
            rect.bottom = adapterPosition == itemCount - 1 ? i11 : 0;
            return;
        }
        if (i10 == 2 && (layoutManager instanceof GridLayoutManager)) {
            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            int i12 = itemCount / spanCount;
            rect.left = i11;
            rect.right = adapterPosition % spanCount == spanCount + (-1) ? i11 : 0;
            rect.top = i11;
            rect.bottom = adapterPosition / spanCount == i12 - 1 ? i11 : 0;
        }
    }

    public c(int i10, int i11) {
        this.f11539a = i10;
        this.f11540b = i11;
    }
}
