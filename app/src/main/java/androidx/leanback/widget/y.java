package androidx.leanback.widget;

import android.database.Observable;

/* compiled from: ObjectAdapter.java */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public final a f3412a = new a();

    /* renamed from: b, reason: collision with root package name */
    public g0 f3413b;

    /* compiled from: ObjectAdapter.java */
    public static final class a extends Observable<b> {
        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((b) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemRangeChanged(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((b) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11);
            }
        }

        public void notifyItemRangeInserted(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((b) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i10, i11);
            }
        }

        public void notifyItemRangeRemoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((b) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i10, i11);
            }
        }
    }

    public y(f0 f0Var) {
        setPresenterSelector(new s0(f0Var));
    }

    public abstract Object get(int i10);

    public long getId(int i10) {
        return -1L;
    }

    public final g0 getPresenterSelector() {
        return this.f3413b;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final void notifyChanged() {
        this.f3412a.notifyChanged();
    }

    public final void notifyItemRangeChanged(int i10, int i11) {
        this.f3412a.notifyItemRangeChanged(i10, i11);
    }

    public final void notifyItemRangeInserted(int i10, int i11) {
        this.f3412a.notifyItemRangeInserted(i10, i11);
    }

    public final void notifyItemRangeRemoved(int i10, int i11) {
        this.f3412a.notifyItemRangeRemoved(i10, i11);
    }

    public final void registerObserver(b bVar) {
        this.f3412a.registerObserver(bVar);
    }

    public final void setPresenterSelector(g0 g0Var) {
        if (g0Var == null) {
            throw new IllegalArgumentException("Presenter selector must not be null");
        }
        g0 g0Var2 = this.f3413b;
        boolean z10 = g0Var2 != null;
        boolean z11 = z10 && g0Var2 != g0Var;
        this.f3413b = g0Var;
        if (z11) {
            onPresenterSelectorChanged();
        }
        if (z10) {
            notifyChanged();
        }
    }

    public abstract int size();

    public final void unregisterObserver(b bVar) {
        this.f3412a.unregisterObserver(bVar);
    }

    /* compiled from: ObjectAdapter.java */
    public static abstract class b {
        public void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public void onChanged() {
        }
    }

    public void onPresenterSelectorChanged() {
    }
}
