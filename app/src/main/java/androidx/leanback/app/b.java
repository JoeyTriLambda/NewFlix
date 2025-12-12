package androidx.leanback.app;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.c;
import androidx.leanback.widget.d;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.m0;
import androidx.leanback.widget.s;
import androidx.leanback.widget.v;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: RowsSupportFragment.java */
/* loaded from: classes.dex */
public class b extends androidx.leanback.app.a {
    public ArrayList<f0> A0;

    /* renamed from: o0, reason: collision with root package name */
    public s.d f2987o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f2988p0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f2990r0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f2993u0;

    /* renamed from: v0, reason: collision with root package name */
    public d f2994v0;

    /* renamed from: w0, reason: collision with root package name */
    public c f2995w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f2996x0;

    /* renamed from: z0, reason: collision with root package name */
    public RecyclerView.q f2998z0;

    /* renamed from: q0, reason: collision with root package name */
    public final boolean f2989q0 = true;

    /* renamed from: s0, reason: collision with root package name */
    public int f2991s0 = Integer.MIN_VALUE;

    /* renamed from: t0, reason: collision with root package name */
    public final boolean f2992t0 = true;

    /* renamed from: y0, reason: collision with root package name */
    public final DecelerateInterpolator f2997y0 = new DecelerateInterpolator(2.0f);
    public final a B0 = new a();

    /* compiled from: RowsSupportFragment.java */
    public class a extends s.b {
        public a() {
        }

        @Override // androidx.leanback.widget.s.b
        public void onAddPresenter(f0 f0Var, int i10) {
            b.this.getClass();
        }

        @Override // androidx.leanback.widget.s.b
        public void onAttachedToWindow(s.d dVar) {
            b bVar = b.this;
            ((m0) dVar.getPresenter()).setRowViewExpanded(dVar.getViewHolder(), bVar.f2989q0);
            m0 m0Var = (m0) dVar.getPresenter();
            m0.b rowViewHolder = m0Var.getRowViewHolder(dVar.getViewHolder());
            m0Var.setEntranceTransitionState(rowViewHolder, bVar.f2992t0);
            m0Var.freeze(rowViewHolder, bVar.f2993u0);
            bVar.getClass();
        }

        @Override // androidx.leanback.widget.s.b
        public void onBind(s.d dVar) {
            b.this.getClass();
        }

        @Override // androidx.leanback.widget.s.b
        public void onCreate(s.d dVar) {
            b bVar = b.this;
            VerticalGridView verticalGridView = bVar.getVerticalGridView();
            if (verticalGridView != null) {
                verticalGridView.setClipChildren(false);
            }
            bVar.getClass();
            m0.b rowViewHolder = ((m0) dVar.getPresenter()).getRowViewHolder(dVar.getViewHolder());
            if (rowViewHolder instanceof v.d) {
                v.d dVar2 = (v.d) rowViewHolder;
                HorizontalGridView gridView = dVar2.getGridView();
                RecyclerView.q qVar = bVar.f2998z0;
                if (qVar == null) {
                    bVar.f2998z0 = gridView.getRecycledViewPool();
                } else {
                    gridView.setRecycledViewPool(qVar);
                }
                s bridgeAdapter = dVar2.getBridgeAdapter();
                ArrayList<f0> arrayList = bVar.A0;
                if (arrayList == null) {
                    bVar.A0 = bridgeAdapter.getPresenterMapper();
                } else {
                    bridgeAdapter.setPresenterMapper(arrayList);
                }
            }
            bVar.f2990r0 = true;
            dVar.setExtraObject(bVar.new C0027b(dVar));
            b.p(dVar, false, true);
            bVar.getClass();
            m0.b rowViewHolder2 = ((m0) dVar.getPresenter()).getRowViewHolder(dVar.getViewHolder());
            rowViewHolder2.setOnItemViewSelectedListener(bVar.f2994v0);
            rowViewHolder2.setOnItemViewClickedListener(bVar.f2995w0);
        }

        @Override // androidx.leanback.widget.s.b
        public void onDetachedFromWindow(s.d dVar) {
            b bVar = b.this;
            s.d dVar2 = bVar.f2987o0;
            if (dVar2 == dVar) {
                b.p(dVar2, false, true);
                bVar.f2987o0 = null;
            }
            bVar.getClass();
        }

        @Override // androidx.leanback.widget.s.b
        public void onUnbind(s.d dVar) {
            b.p(dVar, false, true);
            b.this.getClass();
        }
    }

    /* compiled from: RowsSupportFragment.java */
    /* renamed from: androidx.leanback.app.b$b, reason: collision with other inner class name */
    public final class C0027b implements TimeAnimator.TimeListener {

        /* renamed from: a, reason: collision with root package name */
        public final m0 f3000a;

        /* renamed from: b, reason: collision with root package name */
        public final f0.a f3001b;

        /* renamed from: c, reason: collision with root package name */
        public final TimeAnimator f3002c;

        /* renamed from: d, reason: collision with root package name */
        public int f3003d;

        /* renamed from: e, reason: collision with root package name */
        public DecelerateInterpolator f3004e;

        /* renamed from: f, reason: collision with root package name */
        public float f3005f;

        /* renamed from: g, reason: collision with root package name */
        public float f3006g;

        public C0027b(s.d dVar) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.f3002c = timeAnimator;
            this.f3000a = (m0) dVar.getPresenter();
            this.f3001b = dVar.getViewHolder();
            timeAnimator.setTimeListener(this);
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j10, long j11) {
            float interpolation;
            TimeAnimator timeAnimator2 = this.f3002c;
            if (timeAnimator2.isRunning()) {
                int i10 = this.f3003d;
                if (j10 >= i10) {
                    timeAnimator2.end();
                    interpolation = 1.0f;
                } else {
                    interpolation = (float) (j10 / i10);
                }
                DecelerateInterpolator decelerateInterpolator = this.f3004e;
                if (decelerateInterpolator != null) {
                    interpolation = decelerateInterpolator.getInterpolation(interpolation);
                }
                this.f3000a.setSelectLevel(this.f3001b, (interpolation * this.f3006g) + this.f3005f);
            }
        }
    }

    public static void p(s.d dVar, boolean z10, boolean z11) {
        C0027b c0027b = (C0027b) dVar.getExtraObject();
        TimeAnimator timeAnimator = c0027b.f3002c;
        timeAnimator.end();
        float f10 = z10 ? 1.0f : 0.0f;
        f0.a aVar = c0027b.f3001b;
        m0 m0Var = c0027b.f3000a;
        if (z11) {
            m0Var.setSelectLevel(aVar, f10);
        } else if (m0Var.getSelectLevel(aVar) != f10) {
            b bVar = b.this;
            c0027b.f3003d = bVar.f2996x0;
            c0027b.f3004e = bVar.f2997y0;
            float selectLevel = m0Var.getSelectLevel(aVar);
            c0027b.f3005f = selectLevel;
            c0027b.f3006g = f10 - selectLevel;
            timeAnimator.start();
        }
        ((m0) dVar.getPresenter()).setRowViewSelected(dVar.getViewHolder(), z10);
    }

    @Override // androidx.leanback.app.a
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.container_list);
    }

    @Override // androidx.leanback.app.a
    public /* bridge */ /* synthetic */ int getSelectedPosition() {
        return super.getSelectedPosition();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2996x0 = getResources().getInteger(R.integer.lb_browse_rows_anim_duration);
    }

    @Override // androidx.leanback.app.a, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.leanback.app.a, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f2990r0 = false;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.a, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.leanback.app.a
    public boolean onTransitionPrepare() {
        boolean zOnTransitionPrepare = super.onTransitionPrepare();
        if (zOnTransitionPrepare) {
            this.f2993u0 = true;
            VerticalGridView verticalGridView = getVerticalGridView();
            if (verticalGridView != null) {
                int childCount = verticalGridView.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    s.d dVar = (s.d) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i10));
                    m0 m0Var = (m0) dVar.getPresenter();
                    m0Var.freeze(m0Var.getRowViewHolder(dVar.getViewHolder()), true);
                }
            }
        }
        return zOnTransitionPrepare;
    }

    @Override // androidx.leanback.app.a, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getVerticalGridView().setItemAlignmentViewId(R.id.row_content);
        getVerticalGridView().setSaveChildrenPolicy(2);
        setAlignment(this.f2991s0);
        this.f2998z0 = null;
        this.A0 = null;
    }

    public void setAlignment(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            return;
        }
        this.f2991s0 = i10;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffsetWithPadding(true);
            verticalGridView.setWindowAlignmentOffset(this.f2991s0);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setWindowAlignment(0);
        }
    }

    public void setOnItemViewClickedListener(c cVar) {
        this.f2995w0 = cVar;
        if (this.f2990r0) {
            throw new IllegalStateException("Item clicked listener must be set before views are created");
        }
    }

    public void setOnItemViewSelectedListener(d dVar) {
        this.f2994v0 = dVar;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                s.d dVar2 = (s.d) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i10));
                (dVar2 == null ? null : ((m0) dVar2.getPresenter()).getRowViewHolder(dVar2.getViewHolder())).setOnItemViewSelectedListener(this.f2994v0);
            }
        }
    }

    @Override // androidx.leanback.app.a
    public /* bridge */ /* synthetic */ void setSelectedPosition(int i10) {
        super.setSelectedPosition(i10);
    }

    @Override // androidx.leanback.app.a
    public /* bridge */ /* synthetic */ void setSelectedPosition(int i10, boolean z10) {
        super.setSelectedPosition(i10, z10);
    }
}
