package com.malinskiy.superrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ba.a;

/* loaded from: classes.dex */
public class SuperRecyclerView extends FrameLayout {
    public int A;
    public int B;
    public LAYOUT_MANAGER_TYPE C;
    public RecyclerView.p D;
    public RecyclerView.p E;
    public aa.a F;
    public boolean G;
    public SwipeRefreshLayout H;
    public int I;
    public int J;
    public int[] K;

    /* renamed from: b, reason: collision with root package name */
    public int f10257b;

    /* renamed from: m, reason: collision with root package name */
    public RecyclerView f10258m;

    /* renamed from: n, reason: collision with root package name */
    public ViewStub f10259n;

    /* renamed from: o, reason: collision with root package name */
    public ViewStub f10260o;

    /* renamed from: p, reason: collision with root package name */
    public ViewStub f10261p;

    /* renamed from: q, reason: collision with root package name */
    public View f10262q;

    /* renamed from: r, reason: collision with root package name */
    public View f10263r;

    /* renamed from: s, reason: collision with root package name */
    public View f10264s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10265t;

    /* renamed from: u, reason: collision with root package name */
    public int f10266u;

    /* renamed from: v, reason: collision with root package name */
    public int f10267v;

    /* renamed from: w, reason: collision with root package name */
    public int f10268w;

    /* renamed from: x, reason: collision with root package name */
    public int f10269x;

    /* renamed from: y, reason: collision with root package name */
    public int f10270y;

    /* renamed from: z, reason: collision with root package name */
    public int f10271z;

    public enum LAYOUT_MANAGER_TYPE {
        LINEAR,
        GRID,
        STAGGERED_GRID
    }

    public class a extends RecyclerView.p {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            SuperRecyclerView superRecyclerView = SuperRecyclerView.this;
            RecyclerView.p pVar = superRecyclerView.E;
            if (pVar != null) {
                pVar.onScrollStateChanged(recyclerView, i10);
            }
            RecyclerView.p pVar2 = superRecyclerView.D;
            if (pVar2 != null) {
                pVar2.onScrollStateChanged(recyclerView, i10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int iFindLastVisibleItemPosition;
            super.onScrolled(recyclerView, i10, i11);
            SuperRecyclerView superRecyclerView = SuperRecyclerView.this;
            RecyclerView.l layoutManager = superRecyclerView.f10258m.getLayoutManager();
            if (superRecyclerView.C == null) {
                if (layoutManager instanceof GridLayoutManager) {
                    superRecyclerView.C = LAYOUT_MANAGER_TYPE.GRID;
                } else if (layoutManager instanceof LinearLayoutManager) {
                    superRecyclerView.C = LAYOUT_MANAGER_TYPE.LINEAR;
                } else {
                    if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                        throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
                    }
                    superRecyclerView.C = LAYOUT_MANAGER_TYPE.STAGGERED_GRID;
                }
            }
            int iOrdinal = superRecyclerView.C.ordinal();
            if (iOrdinal == 0) {
                iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (iOrdinal == 1) {
                iFindLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (iOrdinal != 2) {
                iFindLastVisibleItemPosition = -1;
            } else {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (superRecyclerView.K == null) {
                    superRecyclerView.K = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findLastVisibleItemPositions(superRecyclerView.K);
                int i12 = Integer.MIN_VALUE;
                for (int i13 : superRecyclerView.K) {
                    if (i13 > i12) {
                        i12 = i13;
                    }
                }
                iFindLastVisibleItemPosition = i12;
            }
            int childCount = layoutManager.getChildCount();
            int itemCount = layoutManager.getItemCount();
            int i14 = itemCount - iFindLastVisibleItemPosition;
            if ((i14 <= superRecyclerView.f10257b || (i14 == 0 && itemCount > childCount)) && !superRecyclerView.G) {
                superRecyclerView.G = true;
                if (superRecyclerView.F != null) {
                    superRecyclerView.f10260o.setVisibility(0);
                    superRecyclerView.F.onMoreAsked(superRecyclerView.f10258m.getAdapter().getItemCount(), superRecyclerView.f10257b, iFindLastVisibleItemPosition);
                }
            }
            RecyclerView.p pVar = superRecyclerView.E;
            if (pVar != null) {
                pVar.onScrolled(recyclerView, i10, i11);
            }
            RecyclerView.p pVar2 = superRecyclerView.D;
            if (pVar2 != null) {
                pVar2.onScrolled(recyclerView, i10, i11);
            }
        }
    }

    public class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.b f10277a;

        public b(a.b bVar) {
            this.f10277a = bVar;
        }

        public boolean canDismiss(int i10) {
            return ((b) this.f10277a).canDismiss(i10);
        }

        public void onDismiss(RecyclerView recyclerView, int[] iArr) {
            ((b) this.f10277a).onDismiss(recyclerView, iArr);
        }
    }

    public SuperRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10257b = 10;
        initAttrs(attributeSet);
        if (isInEditMode()) {
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(this.I, this);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.id.ptr_layout);
        this.H = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(false);
        ViewStub viewStub = (ViewStub) viewInflate.findViewById(android.R.id.progress);
        this.f10259n = viewStub;
        viewStub.setLayoutResource(this.J);
        this.f10262q = this.f10259n.inflate();
        ViewStub viewStub2 = (ViewStub) viewInflate.findViewById(R.id.more_progress);
        this.f10260o = viewStub2;
        viewStub2.setLayoutResource(this.B);
        if (this.B != 0) {
            this.f10263r = this.f10260o.inflate();
        }
        this.f10260o.setVisibility(8);
        ViewStub viewStub3 = (ViewStub) viewInflate.findViewById(R.id.empty);
        this.f10261p = viewStub3;
        viewStub3.setLayoutResource(this.A);
        if (this.A != 0) {
            this.f10264s = this.f10261p.inflate();
        }
        this.f10261p.setVisibility(8);
        initRecyclerView(viewInflate);
    }

    public void addItemDecoration(RecyclerView.k kVar) {
        this.f10258m.addItemDecoration(kVar);
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f10258m.getAdapter();
    }

    public View getEmptyView() {
        return this.f10264s;
    }

    public View getMoreProgressView() {
        return this.f10263r;
    }

    public View getProgressView() {
        return this.f10262q;
    }

    public RecyclerView getRecyclerView() {
        return this.f10258m;
    }

    public SwipeRefreshLayout getSwipeToRefresh() {
        return this.H;
    }

    public void initAttrs(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.superrecyclerview);
        try {
            this.I = typedArrayObtainStyledAttributes.getResourceId(R.styleable.superrecyclerview_mainLayoutId, R.layout.layout_progress_recyclerview);
            this.f10265t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.superrecyclerview_recyclerClipToPadding, false);
            this.f10266u = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.superrecyclerview_recyclerPadding, -1.0f);
            this.f10267v = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.superrecyclerview_recyclerPaddingTop, 0.0f);
            this.f10268w = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.superrecyclerview_recyclerPaddingBottom, 0.0f);
            this.f10269x = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.superrecyclerview_recyclerPaddingLeft, 0.0f);
            this.f10270y = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.superrecyclerview_recyclerPaddingRight, 0.0f);
            this.f10271z = typedArrayObtainStyledAttributes.getInt(R.styleable.superrecyclerview_scrollbarStyle, -1);
            this.A = typedArrayObtainStyledAttributes.getResourceId(R.styleable.superrecyclerview_layout_empty, 0);
            this.B = typedArrayObtainStyledAttributes.getResourceId(R.styleable.superrecyclerview_layout_moreProgress, R.layout.layout_more_progress);
            this.J = typedArrayObtainStyledAttributes.getResourceId(R.styleable.superrecyclerview_layout_progress, R.layout.layout_progress);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void initRecyclerView(View view) {
        View viewFindViewById = view.findViewById(android.R.id.list);
        if (!(viewFindViewById instanceof RecyclerView)) {
            throw new IllegalArgumentException("SuperRecyclerView works with a RecyclerView!");
        }
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.f10258m = recyclerView;
        recyclerView.setClipToPadding(this.f10265t);
        this.f10258m.addOnScrollListener(new a());
        if (ca.a.compareFloats(this.f10266u, -1.0f)) {
            this.f10258m.setPadding(this.f10269x, this.f10267v, this.f10270y, this.f10268w);
        } else {
            RecyclerView recyclerView2 = this.f10258m;
            int i10 = this.f10266u;
            recyclerView2.setPadding(i10, i10, i10, i10);
        }
        int i11 = this.f10271z;
        if (i11 != -1) {
            this.f10258m.setScrollBarStyle(i11);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.f10258m.setAdapter(adapter);
        this.f10259n.setVisibility(8);
        this.f10258m.setVisibility(0);
        this.H.setRefreshing(false);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new aa.b(this));
        }
        if (this.A != 0) {
            this.f10261p.setVisibility((adapter == null || adapter.getItemCount() <= 0) ? 0 : 8);
        }
    }

    public void setLayoutManager(RecyclerView.l lVar) {
        this.f10258m.setLayoutManager(lVar);
    }

    public void setLoadingMore(boolean z10) {
        this.G = z10;
    }

    public void setNumberBeforeMoreIsCalled(int i10) {
        this.f10257b = i10;
    }

    public void setOnMoreListener(aa.a aVar) {
        this.F = aVar;
    }

    public void setOnScrollListener(RecyclerView.p pVar) {
        this.E = pVar;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f10258m.setOnTouchListener(onTouchListener);
    }

    public void setRefreshListener(SwipeRefreshLayout.f fVar) {
        this.H.setEnabled(true);
        this.H.setOnRefreshListener(fVar);
    }

    public void setRefreshing(boolean z10) {
        this.H.setRefreshing(z10);
    }

    public void setupMoreListener(aa.a aVar, int i10) {
        this.F = aVar;
        this.f10257b = i10;
    }

    public void setupSwipeToDismiss(a.b bVar) {
        ba.a aVar = new ba.a(this.f10258m, new b(bVar));
        this.D = aVar.makeScrollListener();
        this.f10258m.setOnTouchListener(aVar);
    }
}
