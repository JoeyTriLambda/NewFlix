package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.b0;
import androidx.leanback.widget.s;
import androidx.leanback.widget.y;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: BaseRowSupportFragment.java */
/* loaded from: classes.dex */
public abstract class a extends Fragment {

    /* renamed from: h0, reason: collision with root package name */
    public y f2977h0;

    /* renamed from: i0, reason: collision with root package name */
    public VerticalGridView f2978i0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f2981l0;

    /* renamed from: j0, reason: collision with root package name */
    public final s f2979j0 = new s();

    /* renamed from: k0, reason: collision with root package name */
    public int f2980k0 = -1;

    /* renamed from: m0, reason: collision with root package name */
    public final b f2982m0 = new b();

    /* renamed from: n0, reason: collision with root package name */
    public final C0026a f2983n0 = new C0026a();

    /* compiled from: BaseRowSupportFragment.java */
    /* renamed from: androidx.leanback.app.a$a, reason: collision with other inner class name */
    public class C0026a extends b0 {
        public C0026a() {
        }

        @Override // androidx.leanback.widget.b0
        public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.z zVar, int i10, int i11) {
            a aVar = a.this;
            if (aVar.f2982m0.f2985a) {
                return;
            }
            aVar.f2980k0 = i10;
            androidx.leanback.app.b bVar = (androidx.leanback.app.b) aVar;
            s.d dVar = bVar.f2987o0;
            if (dVar == zVar && bVar.f2988p0 == i11) {
                return;
            }
            bVar.f2988p0 = i11;
            if (dVar != null) {
                androidx.leanback.app.b.p(dVar, false, false);
            }
            s.d dVar2 = (s.d) zVar;
            bVar.f2987o0 = dVar2;
            if (dVar2 != null) {
                androidx.leanback.app.b.p(dVar2, true, false);
            }
        }
    }

    /* compiled from: BaseRowSupportFragment.java */
    public class b extends RecyclerView.f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2985a = false;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void onChanged() {
            boolean z10 = this.f2985a;
            a aVar = a.this;
            if (z10) {
                this.f2985a = false;
                aVar.f2979j0.unregisterAdapterDataObserver(this);
            }
            VerticalGridView verticalGridView = aVar.f2978i0;
            if (verticalGridView != null) {
                verticalGridView.setSelectedPosition(aVar.f2980k0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void onItemRangeInserted(int i10, int i11) {
            boolean z10 = this.f2985a;
            a aVar = a.this;
            if (z10) {
                this.f2985a = false;
                aVar.f2979j0.unregisterAdapterDataObserver(this);
            }
            VerticalGridView verticalGridView = aVar.f2978i0;
            if (verticalGridView != null) {
                verticalGridView.setSelectedPosition(aVar.f2980k0);
            }
        }
    }

    public abstract VerticalGridView findGridViewFromRoot(View view);

    public final s getBridgeAdapter() {
        return this.f2979j0;
    }

    public int getSelectedPosition() {
        return this.f2980k0;
    }

    public final VerticalGridView getVerticalGridView() {
        return this.f2978i0;
    }

    public final void o() {
        if (this.f2977h0 == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.f2978i0.getAdapter();
        s sVar = this.f2979j0;
        if (adapter != sVar) {
            this.f2978i0.setAdapter(sVar);
        }
        if (sVar.getItemCount() == 0 && this.f2980k0 >= 0) {
            b bVar = this.f2982m0;
            bVar.f2985a = true;
            a.this.f2979j0.registerAdapterDataObserver(bVar);
        } else {
            int i10 = this.f2980k0;
            if (i10 >= 0) {
                this.f2978i0.setSelectedPosition(i10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.lb_rows_fragment, viewGroup, false);
        this.f2978i0 = findGridViewFromRoot(viewInflate);
        if (this.f2981l0) {
            this.f2981l0 = false;
            onTransitionPrepare();
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b bVar = this.f2982m0;
        if (bVar.f2985a) {
            bVar.f2985a = false;
            a.this.f2979j0.unregisterAdapterDataObserver(bVar);
        }
        this.f2978i0 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentSelectedPosition", this.f2980k0);
    }

    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.f2978i0;
        if (verticalGridView == null) {
            this.f2981l0 = true;
            return false;
        }
        verticalGridView.setAnimateChildLayout(false);
        this.f2978i0.setScrollEnabled(false);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.f2980k0 = bundle.getInt("currentSelectedPosition", -1);
        }
        o();
        this.f2978i0.setOnChildViewHolderSelectedListener(this.f2983n0);
    }

    public final void setAdapter(y yVar) {
        if (this.f2977h0 != yVar) {
            this.f2977h0 = yVar;
            androidx.leanback.app.b bVar = (androidx.leanback.app.b) this;
            s sVar = bVar.f2979j0;
            sVar.setAdapter(bVar.f2977h0);
            sVar.setPresenter(null);
            if (bVar.f2978i0 != null) {
                bVar.o();
            }
            bVar.f2987o0 = null;
            bVar.f2990r0 = false;
            s bridgeAdapter = bVar.getBridgeAdapter();
            if (bridgeAdapter != null) {
                bridgeAdapter.setAdapterListener(bVar.B0);
            }
        }
    }

    public void setSelectedPosition(int i10) {
        setSelectedPosition(i10, true);
    }

    public void setSelectedPosition(int i10, boolean z10) {
        if (this.f2980k0 == i10) {
            return;
        }
        this.f2980k0 = i10;
        VerticalGridView verticalGridView = this.f2978i0;
        if (verticalGridView == null || this.f2982m0.f2985a) {
            return;
        }
        if (z10) {
            verticalGridView.setSelectedPositionSmooth(i10);
        } else {
            verticalGridView.setSelectedPosition(i10);
        }
    }
}
