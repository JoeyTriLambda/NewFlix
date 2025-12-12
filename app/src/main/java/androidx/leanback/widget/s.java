package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.h;
import androidx.leanback.widget.y;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ItemBridgeAdapter.java */
/* loaded from: classes.dex */
public class s extends RecyclerView.Adapter implements f {

    /* renamed from: d, reason: collision with root package name */
    public y f3355d;

    /* renamed from: e, reason: collision with root package name */
    public e f3356e;

    /* renamed from: f, reason: collision with root package name */
    public g0 f3357f;

    /* renamed from: g, reason: collision with root package name */
    public g f3358g;

    /* renamed from: h, reason: collision with root package name */
    public b f3359h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<f0> f3360i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public final a f3361j = new a();

    /* compiled from: ItemBridgeAdapter.java */
    public class a extends y.b {
        public a() {
        }

        @Override // androidx.leanback.widget.y.b
        public void onChanged() {
            s.this.notifyDataSetChanged();
        }

        @Override // androidx.leanback.widget.y.b
        public void onItemRangeChanged(int i10, int i11) {
            s.this.notifyItemRangeChanged(i10, i11);
        }

        @Override // androidx.leanback.widget.y.b
        public void onItemRangeInserted(int i10, int i11) {
            s.this.notifyItemRangeInserted(i10, i11);
        }

        @Override // androidx.leanback.widget.y.b
        public void onItemRangeRemoved(int i10, int i11) {
            s.this.notifyItemRangeRemoved(i10, i11);
        }
    }

    /* compiled from: ItemBridgeAdapter.java */
    public static class b {
        public void onAddPresenter(f0 f0Var, int i10) {
            throw null;
        }

        public void onAttachedToWindow(d dVar) {
            throw null;
        }

        public void onBind(d dVar) {
            throw null;
        }

        public void onBind(d dVar, List list) {
            onBind(dVar);
        }

        public void onCreate(d dVar) {
            throw null;
        }

        public void onDetachedFromWindow(d dVar) {
            throw null;
        }

        public void onUnbind(d dVar) {
            throw null;
        }
    }

    /* compiled from: ItemBridgeAdapter.java */
    public final class c implements View.OnFocusChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public View.OnFocusChangeListener f3363b;

        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            s sVar = s.this;
            if (sVar.f3356e != null) {
                view = (View) view.getParent();
            }
            g gVar = sVar.f3358g;
            if (gVar != null) {
                ((h.a) gVar).onItemFocused(view, z10);
            }
            View.OnFocusChangeListener onFocusChangeListener = this.f3363b;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z10);
            }
        }
    }

    /* compiled from: ItemBridgeAdapter.java */
    public class d extends RecyclerView.z implements androidx.leanback.widget.e {

        /* renamed from: u, reason: collision with root package name */
        public final f0 f3365u;

        /* renamed from: v, reason: collision with root package name */
        public final f0.a f3366v;

        /* renamed from: w, reason: collision with root package name */
        public final c f3367w;

        /* renamed from: x, reason: collision with root package name */
        public Object f3368x;

        /* renamed from: y, reason: collision with root package name */
        public Object f3369y;

        public d(s sVar, f0 f0Var, View view, f0.a aVar) {
            super(view);
            this.f3367w = sVar.new c();
            this.f3365u = f0Var;
            this.f3366v = aVar;
        }

        public final Object getExtraObject() {
            return this.f3369y;
        }

        @Override // androidx.leanback.widget.e
        public Object getFacet(Class<?> cls) {
            return this.f3366v.getFacet(cls);
        }

        public final f0 getPresenter() {
            return this.f3365u;
        }

        public final f0.a getViewHolder() {
            return this.f3366v;
        }

        public void setExtraObject(Object obj) {
            this.f3369y = obj;
        }
    }

    /* compiled from: ItemBridgeAdapter.java */
    public static abstract class e {
        public abstract View createWrapper(View view);

        public abstract void wrap(View view, View view2);
    }

    public void clear() {
        setAdapter(null);
    }

    @Override // androidx.leanback.widget.f
    public androidx.leanback.widget.e getFacetProvider(int i10) {
        return this.f3360i.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        y yVar = this.f3355d;
        if (yVar != null) {
            return yVar.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.f3355d.getId(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        g0 presenterSelector = this.f3357f;
        if (presenterSelector == null) {
            presenterSelector = this.f3355d.getPresenterSelector();
        }
        f0 presenter = presenterSelector.getPresenter(this.f3355d.get(i10));
        int iIndexOf = this.f3360i.indexOf(presenter);
        if (iIndexOf < 0) {
            this.f3360i.add(presenter);
            iIndexOf = this.f3360i.indexOf(presenter);
            onAddPresenter(presenter, iIndexOf);
            b bVar = this.f3359h;
            if (bVar != null) {
                bVar.onAddPresenter(presenter, iIndexOf);
            }
        }
        return iIndexOf;
    }

    public ArrayList<f0> getPresenterMapper() {
        return this.f3360i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.z zVar, int i10) {
        d dVar = (d) zVar;
        Object obj = this.f3355d.get(i10);
        dVar.f3368x = obj;
        dVar.f3365u.onBindViewHolder(dVar.f3366v, obj);
        onBind(dVar);
        b bVar = this.f3359h;
        if (bVar != null) {
            bVar.onBind(dVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.z onCreateViewHolder(ViewGroup viewGroup, int i10) {
        f0.a aVarOnCreateViewHolder;
        View viewCreateWrapper;
        f0 f0Var = this.f3360i.get(i10);
        e eVar = this.f3356e;
        if (eVar != null) {
            viewCreateWrapper = eVar.createWrapper(viewGroup);
            aVarOnCreateViewHolder = f0Var.onCreateViewHolder(viewGroup);
            this.f3356e.wrap(viewCreateWrapper, aVarOnCreateViewHolder.f3216a);
        } else {
            aVarOnCreateViewHolder = f0Var.onCreateViewHolder(viewGroup);
            viewCreateWrapper = aVarOnCreateViewHolder.f3216a;
        }
        d dVar = new d(this, f0Var, viewCreateWrapper, aVarOnCreateViewHolder);
        onCreate(dVar);
        b bVar = this.f3359h;
        if (bVar != null) {
            bVar.onCreate(dVar);
        }
        View view = dVar.f3366v.f3216a;
        if (view != null) {
            View.OnFocusChangeListener onFocusChangeListener = view.getOnFocusChangeListener();
            c cVar = dVar.f3367w;
            cVar.f3363b = onFocusChangeListener;
            view.setOnFocusChangeListener(cVar);
        }
        g gVar = this.f3358g;
        if (gVar != null) {
            ((h.a) gVar).onInitializeView(viewCreateWrapper);
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.z zVar) {
        onViewRecycled(zVar);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.z zVar) {
        d dVar = (d) zVar;
        onAttachedToWindow(dVar);
        b bVar = this.f3359h;
        if (bVar != null) {
            bVar.onAttachedToWindow(dVar);
        }
        dVar.f3365u.onViewAttachedToWindow(dVar.f3366v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.z zVar) {
        d dVar = (d) zVar;
        dVar.f3365u.onViewDetachedFromWindow(dVar.f3366v);
        onDetachedFromWindow(dVar);
        b bVar = this.f3359h;
        if (bVar != null) {
            bVar.onDetachedFromWindow(dVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.z zVar) {
        d dVar = (d) zVar;
        dVar.f3365u.onUnbindViewHolder(dVar.f3366v);
        onUnbind(dVar);
        b bVar = this.f3359h;
        if (bVar != null) {
            bVar.onUnbind(dVar);
        }
        dVar.f3368x = null;
    }

    public void setAdapter(y yVar) {
        y yVar2 = this.f3355d;
        if (yVar == yVar2) {
            return;
        }
        a aVar = this.f3361j;
        if (yVar2 != null) {
            yVar2.unregisterObserver(aVar);
        }
        this.f3355d = yVar;
        if (yVar == null) {
            notifyDataSetChanged();
            return;
        }
        yVar.registerObserver(aVar);
        if (hasStableIds() != this.f3355d.hasStableIds()) {
            setHasStableIds(this.f3355d.hasStableIds());
        }
        notifyDataSetChanged();
    }

    public void setAdapterListener(b bVar) {
        this.f3359h = bVar;
    }

    public void setPresenter(g0 g0Var) {
        this.f3357f = g0Var;
        notifyDataSetChanged();
    }

    public void setPresenterMapper(ArrayList<f0> arrayList) {
        this.f3360i = arrayList;
    }

    public void setWrapper(e eVar) {
        this.f3356e = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.z zVar, int i10, List list) {
        d dVar = (d) zVar;
        Object obj = this.f3355d.get(i10);
        dVar.f3368x = obj;
        dVar.f3365u.onBindViewHolder(dVar.f3366v, obj, list);
        onBind(dVar);
        b bVar = this.f3359h;
        if (bVar != null) {
            bVar.onBind(dVar, list);
        }
    }

    public void onAttachedToWindow(d dVar) {
    }

    public void onBind(d dVar) {
    }

    public void onCreate(d dVar) {
    }

    public void onDetachedFromWindow(d dVar) {
    }

    public void onUnbind(d dVar) {
    }

    public void onAddPresenter(f0 f0Var, int i10) {
    }
}
