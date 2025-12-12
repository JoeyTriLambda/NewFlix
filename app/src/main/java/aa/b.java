package aa;

import androidx.recyclerview.widget.RecyclerView;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

/* compiled from: SuperRecyclerView.java */
/* loaded from: classes.dex */
public final class b extends RecyclerView.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuperRecyclerView f382a;

    public b(SuperRecyclerView superRecyclerView) {
        this.f382a = superRecyclerView;
    }

    public final void a() {
        SuperRecyclerView superRecyclerView = this.f382a;
        superRecyclerView.f10259n.setVisibility(8);
        superRecyclerView.f10260o.setVisibility(8);
        superRecyclerView.G = false;
        superRecyclerView.H.setRefreshing(false);
        if (superRecyclerView.f10258m.getAdapter().getItemCount() == 0 && superRecyclerView.A != 0) {
            superRecyclerView.f10261p.setVisibility(0);
        } else if (superRecyclerView.A != 0) {
            superRecyclerView.f10261p.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void onChanged() {
        super.onChanged();
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void onItemRangeChanged(int i10, int i11) {
        super.onItemRangeChanged(i10, i11);
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void onItemRangeInserted(int i10, int i11) {
        super.onItemRangeInserted(i10, i11);
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void onItemRangeRemoved(int i10, int i11) {
        super.onItemRangeRemoved(i10, i11);
        a();
    }
}
