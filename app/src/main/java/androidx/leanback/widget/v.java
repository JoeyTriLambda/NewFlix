package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;
import androidx.leanback.widget.b;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.l0;
import androidx.leanback.widget.m0;
import androidx.leanback.widget.r0;
import androidx.leanback.widget.s;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import java.util.HashMap;

/* compiled from: ListRowPresenter.java */
/* loaded from: classes.dex */
public final class v extends m0 {

    /* renamed from: n, reason: collision with root package name */
    public static int f3374n;

    /* renamed from: o, reason: collision with root package name */
    public static int f3375o;

    /* renamed from: p, reason: collision with root package name */
    public static int f3376p;

    /* renamed from: d, reason: collision with root package name */
    public final int f3377d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3378e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3379f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3380g;

    /* renamed from: h, reason: collision with root package name */
    public int f3381h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3382i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3383j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap<f0, Integer> f3384k;

    /* renamed from: l, reason: collision with root package name */
    public r0 f3385l;

    /* renamed from: m, reason: collision with root package name */
    public t f3386m;

    /* compiled from: ListRowPresenter.java */
    public class a implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f3387a;

        public a(d dVar) {
            this.f3387a = dVar;
        }

        public void onChildSelected(ViewGroup viewGroup, View view, int i10, long j10) {
            v.this.getClass();
            v.b(this.f3387a, view, true);
        }
    }

    /* compiled from: ListRowPresenter.java */
    public class b implements b.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f3389a;

        public b(d dVar) {
            this.f3389a = dVar;
        }

        public boolean onUnhandledKey(KeyEvent keyEvent) {
            d dVar = this.f3389a;
            return dVar.getOnKeyListener() != null && dVar.getOnKeyListener().onKey(dVar.f3216a, keyEvent.getKeyCode(), keyEvent);
        }
    }

    /* compiled from: ListRowPresenter.java */
    public class c extends s {

        /* renamed from: k, reason: collision with root package name */
        public final d f3390k;

        /* compiled from: ListRowPresenter.java */
        public class a implements View.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s.d f3392b;

            public a(s.d dVar) {
                this.f3392b = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                HorizontalGridView horizontalGridView = cVar.f3390k.f3394n;
                s.d dVar = this.f3392b;
                s.d dVar2 = (s.d) horizontalGridView.getChildViewHolder(dVar.f4041a);
                if (cVar.f3390k.getOnItemViewClickedListener() != null) {
                    androidx.leanback.widget.c onItemViewClickedListener = cVar.f3390k.getOnItemViewClickedListener();
                    f0.a aVar = dVar.f3366v;
                    Object obj = dVar2.f3368x;
                    d dVar3 = cVar.f3390k;
                    ((c1.c) onItemViewClickedListener).b(aVar, obj, dVar3, (u) dVar3.f3300d);
                }
            }
        }

        public c(d dVar) {
            this.f3390k = dVar;
        }

        @Override // androidx.leanback.widget.s
        public void onAddPresenter(f0 f0Var, int i10) {
            this.f3390k.getGridView().getRecycledViewPool().setMaxRecycledViews(i10, v.this.getRecycledPoolSize(f0Var));
        }

        @Override // androidx.leanback.widget.s
        public void onAttachedToWindow(s.d dVar) {
            View view = dVar.f4041a;
            v vVar = v.this;
            d dVar2 = this.f3390k;
            vVar.applySelectLevelToChild(dVar2, view);
            dVar2.syncActivatedStatus(dVar.f4041a);
        }

        @Override // androidx.leanback.widget.s
        public void onBind(s.d dVar) {
            if (this.f3390k.getOnItemViewClickedListener() != null) {
                dVar.f3366v.f3216a.setOnClickListener(new a(dVar));
            }
        }

        @Override // androidx.leanback.widget.s
        public void onCreate(s.d dVar) {
            View view = dVar.f4041a;
            if (view instanceof ViewGroup) {
                androidx.leanback.transition.b.setTransitionGroup((ViewGroup) view, true);
            }
            r0 r0Var = v.this.f3385l;
            if (r0Var != null) {
                r0Var.onViewCreated(dVar.f4041a);
            }
        }

        @Override // androidx.leanback.widget.s
        public void onUnbind(s.d dVar) {
            if (this.f3390k.getOnItemViewClickedListener() != null) {
                dVar.f3366v.f3216a.setOnClickListener(null);
            }
        }
    }

    /* compiled from: ListRowPresenter.java */
    public static class d extends m0.b {

        /* renamed from: n, reason: collision with root package name */
        public final HorizontalGridView f3394n;

        /* renamed from: o, reason: collision with root package name */
        public c f3395o;

        /* renamed from: p, reason: collision with root package name */
        public final int f3396p;

        /* renamed from: q, reason: collision with root package name */
        public final int f3397q;

        /* renamed from: r, reason: collision with root package name */
        public final int f3398r;

        /* renamed from: s, reason: collision with root package name */
        public final int f3399s;

        public d(View view, HorizontalGridView horizontalGridView, v vVar) {
            super(view);
            new n();
            this.f3394n = horizontalGridView;
            this.f3396p = horizontalGridView.getPaddingTop();
            this.f3397q = horizontalGridView.getPaddingBottom();
            this.f3398r = horizontalGridView.getPaddingLeft();
            this.f3399s = horizontalGridView.getPaddingRight();
        }

        public final s getBridgeAdapter() {
            return this.f3395o;
        }

        public final HorizontalGridView getGridView() {
            return this.f3394n;
        }
    }

    public v(int i10) {
        this(i10, false);
    }

    public static void b(d dVar, View view, boolean z10) {
        if (view == null) {
            if (!z10 || dVar.getOnItemViewSelectedListener() == null) {
                return;
            }
            ((TVListFragmentMain.a) dVar.getOnItemViewSelectedListener()).onItemSelected((f0.a) null, (Object) null, (m0.b) dVar, (Object) dVar.f3300d);
            return;
        }
        if (dVar.f3303g) {
            s.d dVar2 = (s.d) dVar.f3394n.getChildViewHolder(view);
            if (!z10 || dVar.getOnItemViewSelectedListener() == null) {
                return;
            }
            ((TVListFragmentMain.a) dVar.getOnItemViewSelectedListener()).onItemSelected(dVar2.f3366v, dVar2.f3368x, (m0.b) dVar, (Object) dVar.f3300d);
        }
    }

    public static void d(d dVar) {
        if (dVar.f3304h && dVar.f3303g) {
            HorizontalGridView horizontalGridView = dVar.f3394n;
            s.d dVar2 = (s.d) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
            b(dVar, dVar2 == null ? null : dVar2.f4041a, false);
        }
    }

    public void applySelectLevelToChild(d dVar, View view) {
        r0 r0Var = this.f3385l;
        if (r0Var == null || !r0Var.needsOverlay()) {
            return;
        }
        this.f3385l.setOverlayColor(view, dVar.f3307k.getPaint().getColor());
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.f3382i;
    }

    public final void c(d dVar) {
        int i10;
        if (dVar.isExpanded()) {
            l0.a headerViewHolder = dVar.getHeaderViewHolder();
            spaceUnderBaseline = (dVar.isSelected() ? f3375o : dVar.f3396p) - (headerViewHolder != null ? getHeaderPresenter() != null ? getHeaderPresenter().getSpaceUnderBaseline(headerViewHolder) : headerViewHolder.f3216a.getPaddingBottom() : 0);
            i10 = f3376p;
        } else {
            boolean zIsSelected = dVar.isSelected();
            int i11 = dVar.f3397q;
            if (zIsSelected) {
                i10 = f3374n;
                spaceUnderBaseline = i10 - i11;
            } else {
                i10 = i11;
            }
        }
        dVar.getGridView().setPadding(dVar.f3398r, spaceUnderBaseline, dVar.f3399s, i10);
    }

    @Override // androidx.leanback.widget.m0
    public m0.b createRowViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (f3374n == 0) {
            f3374n = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_selected_row_top_padding);
            f3375o = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_expanded_selected_row_top_padding);
            f3376p = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_expanded_row_no_hovercard_bottom_padding);
        }
        w wVar = new w(viewGroup.getContext());
        HorizontalGridView gridView = wVar.getGridView();
        if (this.f3381h < 0) {
            TypedArray typedArrayObtainStyledAttributes = gridView.getContext().obtainStyledAttributes(R.styleable.LeanbackTheme);
            this.f3381h = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsFadingEdgeLength, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        gridView.setFadingLeftEdgeLength(this.f3381h);
        return new d(wVar, wVar.getGridView(), this);
    }

    public r0.b createShadowOverlayOptions() {
        return r0.b.f3352c;
    }

    @Override // androidx.leanback.widget.m0
    public void dispatchItemSelectedListener(m0.b bVar, boolean z10) {
        d dVar = (d) bVar;
        HorizontalGridView horizontalGridView = dVar.f3394n;
        s.d dVar2 = (s.d) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
        if (dVar2 == null) {
            super.dispatchItemSelectedListener(bVar, z10);
        } else {
            if (!z10 || bVar.getOnItemViewSelectedListener() == null) {
                return;
            }
            ((TVListFragmentMain.a) bVar.getOnItemViewSelectedListener()).onItemSelected(dVar2.getViewHolder(), dVar2.f3368x, (m0.b) dVar, (Object) dVar.getRow());
        }
    }

    public final void enableChildRoundedCorners(boolean z10) {
        this.f3382i = z10;
    }

    @Override // androidx.leanback.widget.m0
    public void freeze(m0.b bVar, boolean z10) {
        d dVar = (d) bVar;
        dVar.f3394n.setScrollEnabled(!z10);
        dVar.f3394n.setAnimateChildLayout(!z10);
    }

    public int getExpandedRowHeight() {
        return 0;
    }

    public int getRecycledPoolSize(f0 f0Var) {
        HashMap<f0, Integer> map = this.f3384k;
        if (map.containsKey(f0Var)) {
            return map.get(f0Var).intValue();
        }
        return 24;
    }

    public int getRowHeight() {
        return 0;
    }

    public final boolean getShadowEnabled() {
        return this.f3380g;
    }

    @Override // androidx.leanback.widget.m0
    public void initializeRowViewHolder(m0.b bVar) {
        super.initializeRowViewHolder(bVar);
        d dVar = (d) bVar;
        Context context = bVar.f3216a.getContext();
        if (this.f3385l == null) {
            r0 r0VarBuild = new r0.a().needsOverlay(isUsingDefaultListSelectEffect() && getSelectEffectEnabled()).needsShadow(isUsingDefaultShadow() && getShadowEnabled()).needsRoundedCorner(isUsingOutlineClipping(context) && areChildRoundedCornersEnabled()).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.f3383j).options(createShadowOverlayOptions()).build(context);
            this.f3385l = r0VarBuild;
            if (r0VarBuild.needsWrapper()) {
                this.f3386m = new t(this.f3385l);
            }
        }
        c cVar = new c(dVar);
        dVar.f3395o = cVar;
        cVar.setWrapper(this.f3386m);
        r0 r0Var = this.f3385l;
        HorizontalGridView horizontalGridView = dVar.f3394n;
        r0Var.prepareParentForShadow(horizontalGridView);
        h.setupBrowseItemFocusHighlight(dVar.f3395o, this.f3378e, this.f3379f);
        horizontalGridView.setFocusDrawingOrderEnabled(this.f3385l.getShadowType() != 3);
        horizontalGridView.setOnChildSelectedListener(new a(dVar));
        horizontalGridView.setOnUnhandledKeyListener(new b(dVar));
        horizontalGridView.setNumRows(this.f3377d);
    }

    public boolean isUsingDefaultListSelectEffect() {
        return true;
    }

    @Override // androidx.leanback.widget.m0
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public boolean isUsingDefaultShadow() {
        return r0.supportsShadow();
    }

    public boolean isUsingOutlineClipping(Context context) {
        return !r1.a.getInstance(context).isOutlineClippingDisabled();
    }

    public boolean isUsingZOrder(Context context) {
        return !r1.a.getInstance(context).preferStaticShadows();
    }

    @Override // androidx.leanback.widget.m0
    public void onBindRowViewHolder(m0.b bVar, Object obj) {
        super.onBindRowViewHolder(bVar, obj);
        d dVar = (d) bVar;
        u uVar = (u) obj;
        dVar.f3395o.setAdapter(uVar.getAdapter());
        c cVar = dVar.f3395o;
        HorizontalGridView horizontalGridView = dVar.f3394n;
        horizontalGridView.setAdapter(cVar);
        horizontalGridView.setContentDescription(uVar.getContentDescription());
    }

    @Override // androidx.leanback.widget.m0
    public void onRowViewExpanded(m0.b bVar, boolean z10) {
        super.onRowViewExpanded(bVar, z10);
        d dVar = (d) bVar;
        if (getRowHeight() != getExpandedRowHeight()) {
            dVar.getGridView().setRowHeight(z10 ? getExpandedRowHeight() : getRowHeight());
        }
        c(dVar);
        d(dVar);
    }

    @Override // androidx.leanback.widget.m0
    public void onRowViewSelected(m0.b bVar, boolean z10) {
        super.onRowViewSelected(bVar, z10);
        d dVar = (d) bVar;
        c(dVar);
        d(dVar);
    }

    @Override // androidx.leanback.widget.m0
    public void onSelectLevelChanged(m0.b bVar) {
        super.onSelectLevelChanged(bVar);
        d dVar = (d) bVar;
        int childCount = dVar.f3394n.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            applySelectLevelToChild(dVar, dVar.f3394n.getChildAt(i10));
        }
    }

    @Override // androidx.leanback.widget.m0
    public void onUnbindRowViewHolder(m0.b bVar) {
        d dVar = (d) bVar;
        dVar.f3394n.setAdapter(null);
        dVar.f3395o.clear();
        super.onUnbindRowViewHolder(bVar);
    }

    @Override // androidx.leanback.widget.m0
    public void setEntranceTransitionState(m0.b bVar, boolean z10) {
        super.setEntranceTransitionState(bVar, z10);
        ((d) bVar).f3394n.setChildrenVisibility(z10 ? 0 : 4);
    }

    public v(int i10, boolean z10) {
        boolean z11 = true;
        this.f3377d = 1;
        this.f3380g = true;
        this.f3381h = -1;
        this.f3382i = true;
        this.f3383j = true;
        this.f3384k = new HashMap<>();
        if (i10 != 0) {
            if ((i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? 0 : R.fraction.lb_focus_zoom_factor_xsmall : R.fraction.lb_focus_zoom_factor_large : R.fraction.lb_focus_zoom_factor_medium : R.fraction.lb_focus_zoom_factor_small) <= 0) {
                z11 = false;
            }
        }
        if (!z11) {
            throw new IllegalArgumentException("Unhandled zoom factor");
        }
        this.f3378e = i10;
        this.f3379f = z10;
    }
}
