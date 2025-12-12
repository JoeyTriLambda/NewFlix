package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.l0;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;

/* compiled from: RowPresenter.java */
/* loaded from: classes.dex */
public abstract class m0 extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final l0 f3294a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3295b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3296c;

    /* compiled from: RowPresenter.java */
    public static class a extends f0.a {

        /* renamed from: b, reason: collision with root package name */
        public final b f3297b;

        public a(k0 k0Var, b bVar) {
            super(k0Var);
            k0Var.addRowView(bVar.f3216a);
            l0.a aVar = bVar.f3299c;
            if (aVar != null) {
                k0Var.addHeaderView(aVar.f3216a);
            }
            this.f3297b = bVar;
            bVar.f3298b = this;
        }
    }

    /* compiled from: RowPresenter.java */
    public static class b extends f0.a {

        /* renamed from: b, reason: collision with root package name */
        public a f3298b;

        /* renamed from: c, reason: collision with root package name */
        public l0.a f3299c;

        /* renamed from: d, reason: collision with root package name */
        public j0 f3300d;

        /* renamed from: e, reason: collision with root package name */
        public Object f3301e;

        /* renamed from: f, reason: collision with root package name */
        public int f3302f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f3303g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3304h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3305i;

        /* renamed from: j, reason: collision with root package name */
        public float f3306j;

        /* renamed from: k, reason: collision with root package name */
        public final q1.a f3307k;

        /* renamed from: l, reason: collision with root package name */
        public d f3308l;

        /* renamed from: m, reason: collision with root package name */
        public c f3309m;

        public b(View view) {
            super(view);
            this.f3302f = 0;
            this.f3306j = 0.0f;
            this.f3307k = q1.a.createDefault(view.getContext());
        }

        public final l0.a getHeaderViewHolder() {
            return this.f3299c;
        }

        public final c getOnItemViewClickedListener() {
            return this.f3309m;
        }

        public final d getOnItemViewSelectedListener() {
            return this.f3308l;
        }

        public View.OnKeyListener getOnKeyListener() {
            return null;
        }

        public final j0 getRow() {
            return this.f3300d;
        }

        public final Object getRowObject() {
            return this.f3301e;
        }

        public final boolean isExpanded() {
            return this.f3304h;
        }

        public final boolean isSelected() {
            return this.f3303g;
        }

        public final void setActivated(boolean z10) {
            this.f3302f = z10 ? 1 : 2;
        }

        public final void setOnItemViewClickedListener(c cVar) {
            this.f3309m = cVar;
        }

        public final void setOnItemViewSelectedListener(d dVar) {
            this.f3308l = dVar;
        }

        public final void syncActivatedStatus(View view) {
            int i10 = this.f3302f;
            if (i10 == 1) {
                view.setActivated(true);
            } else if (i10 == 2) {
                view.setActivated(false);
            }
        }
    }

    public m0() {
        l0 l0Var = new l0();
        this.f3294a = l0Var;
        this.f3295b = true;
        this.f3296c = 1;
        l0Var.setNullItemVisibilityGone(true);
    }

    public final void a(b bVar, View view) {
        int i10 = this.f3296c;
        if (i10 == 1) {
            bVar.setActivated(bVar.isExpanded());
        } else if (i10 == 2) {
            bVar.setActivated(bVar.isSelected());
        } else if (i10 == 3) {
            bVar.setActivated(bVar.isExpanded() && bVar.isSelected());
        }
        bVar.syncActivatedStatus(view);
    }

    public abstract b createRowViewHolder(ViewGroup viewGroup);

    public void dispatchItemSelectedListener(b bVar, boolean z10) {
        d dVar;
        if (!z10 || (dVar = bVar.f3308l) == null) {
            return;
        }
        ((TVListFragmentMain.a) dVar).onItemSelected((f0.a) null, (Object) null, bVar, bVar.getRowObject());
    }

    public final l0 getHeaderPresenter() {
        return this.f3294a;
    }

    public final b getRowViewHolder(f0.a aVar) {
        return aVar instanceof a ? ((a) aVar).f3297b : (b) aVar;
    }

    public final boolean getSelectEffectEnabled() {
        return this.f3295b;
    }

    public final float getSelectLevel(f0.a aVar) {
        return getRowViewHolder(aVar).f3306j;
    }

    public void initializeRowViewHolder(b bVar) {
        bVar.f3305i = true;
        if (isClippingChildren()) {
            return;
        }
        View view = bVar.f3216a;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setClipChildren(false);
        }
        a aVar = bVar.f3298b;
        if (aVar != null) {
            ((ViewGroup) aVar.f3216a).setClipChildren(false);
        }
    }

    public boolean isClippingChildren() {
        return false;
    }

    public boolean isUsingDefaultSelectEffect() {
        return true;
    }

    public void onBindRowViewHolder(b bVar, Object obj) {
        bVar.f3301e = obj;
        bVar.f3300d = obj instanceof j0 ? (j0) obj : null;
        if (bVar.f3299c == null || bVar.getRow() == null) {
            return;
        }
        this.f3294a.onBindViewHolder(bVar.f3299c, obj);
    }

    @Override // androidx.leanback.widget.f0
    public final void onBindViewHolder(f0.a aVar, Object obj) {
        onBindRowViewHolder(getRowViewHolder(aVar), obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    @Override // androidx.leanback.widget.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.leanback.widget.f0.a onCreateViewHolder(android.view.ViewGroup r6) {
        /*
            r5 = this;
            androidx.leanback.widget.m0$b r0 = r5.createRowViewHolder(r6)
            r1 = 0
            r0.f3305i = r1
            r2 = 1
            androidx.leanback.widget.l0 r3 = r5.f3294a
            if (r3 != 0) goto L1d
            boolean r4 = r5.isUsingDefaultSelectEffect()
            if (r4 == 0) goto L1a
            boolean r4 = r5.getSelectEffectEnabled()
            if (r4 == 0) goto L1a
            r4 = 1
            goto L1b
        L1a:
            r4 = 0
        L1b:
            if (r4 == 0) goto L1e
        L1d:
            r1 = 1
        L1e:
            if (r1 == 0) goto L3d
            androidx.leanback.widget.k0 r1 = new androidx.leanback.widget.k0
            android.content.Context r6 = r6.getContext()
            r1.<init>(r6)
            if (r3 == 0) goto L37
            android.view.View r6 = r0.f3216a
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            androidx.leanback.widget.f0$a r6 = r3.onCreateViewHolder(r6)
            androidx.leanback.widget.l0$a r6 = (androidx.leanback.widget.l0.a) r6
            r0.f3299c = r6
        L37:
            androidx.leanback.widget.m0$a r6 = new androidx.leanback.widget.m0$a
            r6.<init>(r1, r0)
            goto L3e
        L3d:
            r6 = r0
        L3e:
            r5.initializeRowViewHolder(r0)
            boolean r0 = r0.f3305i
            if (r0 == 0) goto L46
            return r6
        L46:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r0 = "super.initializeRowViewHolder() must be called"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.m0.onCreateViewHolder(android.view.ViewGroup):androidx.leanback.widget.f0$a");
    }

    public void onRowViewAttachedToWindow(b bVar) {
        l0.a aVar = bVar.f3299c;
        if (aVar != null) {
            this.f3294a.onViewAttachedToWindow(aVar);
        }
    }

    public void onRowViewDetachedFromWindow(b bVar) {
        l0.a aVar = bVar.f3299c;
        if (aVar != null) {
            this.f3294a.onViewDetachedFromWindow(aVar);
        }
        f0.cancelAnimationsRecursive(bVar.f3216a);
    }

    public void onRowViewExpanded(b bVar, boolean z10) {
        if (this.f3294a != null && bVar.f3299c != null) {
            ((k0) bVar.f3298b.f3216a).showHeader(bVar.isExpanded());
        }
        a(bVar, bVar.f3216a);
    }

    public void onRowViewSelected(b bVar, boolean z10) {
        dispatchItemSelectedListener(bVar, z10);
        if (this.f3294a != null && bVar.f3299c != null) {
            ((k0) bVar.f3298b.f3216a).showHeader(bVar.isExpanded());
        }
        a(bVar, bVar.f3216a);
    }

    public void onSelectLevelChanged(b bVar) {
        if (getSelectEffectEnabled()) {
            bVar.f3307k.setActiveLevel(bVar.f3306j);
            l0.a aVar = bVar.f3299c;
            if (aVar != null) {
                this.f3294a.setSelectLevel(aVar, bVar.f3306j);
            }
            if (isUsingDefaultSelectEffect()) {
                ((k0) bVar.f3298b.f3216a).setForegroundColor(bVar.f3307k.getPaint().getColor());
            }
        }
    }

    public void onUnbindRowViewHolder(b bVar) {
        l0.a aVar = bVar.f3299c;
        if (aVar != null) {
            this.f3294a.onUnbindViewHolder(aVar);
        }
        bVar.f3300d = null;
        bVar.f3301e = null;
    }

    @Override // androidx.leanback.widget.f0
    public final void onUnbindViewHolder(f0.a aVar) {
        onUnbindRowViewHolder(getRowViewHolder(aVar));
    }

    @Override // androidx.leanback.widget.f0
    public final void onViewAttachedToWindow(f0.a aVar) {
        onRowViewAttachedToWindow(getRowViewHolder(aVar));
    }

    @Override // androidx.leanback.widget.f0
    public final void onViewDetachedFromWindow(f0.a aVar) {
        onRowViewDetachedFromWindow(getRowViewHolder(aVar));
    }

    public void setEntranceTransitionState(b bVar, boolean z10) {
        l0.a aVar = bVar.f3299c;
        if (aVar == null || aVar.f3216a.getVisibility() == 8) {
            return;
        }
        bVar.f3299c.f3216a.setVisibility(z10 ? 0 : 4);
    }

    public final void setRowViewExpanded(f0.a aVar, boolean z10) {
        b rowViewHolder = getRowViewHolder(aVar);
        rowViewHolder.f3304h = z10;
        onRowViewExpanded(rowViewHolder, z10);
    }

    public final void setRowViewSelected(f0.a aVar, boolean z10) {
        b rowViewHolder = getRowViewHolder(aVar);
        rowViewHolder.f3303g = z10;
        onRowViewSelected(rowViewHolder, z10);
    }

    public final void setSelectLevel(f0.a aVar, float f10) {
        b rowViewHolder = getRowViewHolder(aVar);
        rowViewHolder.f3306j = f10;
        onSelectLevelChanged(rowViewHolder);
    }

    public void freeze(b bVar, boolean z10) {
    }
}
