package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import java.util.Map;

/* compiled from: ViewsStateBundle.java */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    public int f3191a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3192b = 100;

    /* renamed from: c, reason: collision with root package name */
    public b0.i<String, SparseArray<Parcelable>> f3193c;

    public void applyPolicyChanges() {
        int i10 = this.f3191a;
        if (i10 == 2) {
            if (this.f3192b <= 0) {
                throw new IllegalArgumentException();
            }
            b0.i<String, SparseArray<Parcelable>> iVar = this.f3193c;
            if (iVar == null || iVar.maxSize() != this.f3192b) {
                this.f3193c = new b0.i<>(this.f3192b);
                return;
            }
            return;
        }
        if (i10 != 3 && i10 != 1) {
            this.f3193c = null;
            return;
        }
        b0.i<String, SparseArray<Parcelable>> iVar2 = this.f3193c;
        if (iVar2 == null || iVar2.maxSize() != Integer.MAX_VALUE) {
            this.f3193c = new b0.i<>(Integer.MAX_VALUE);
        }
    }

    public void clear() {
        b0.i<String, SparseArray<Parcelable>> iVar = this.f3193c;
        if (iVar != null) {
            iVar.evictAll();
        }
    }

    public final int getLimitNumber() {
        return this.f3192b;
    }

    public final int getSavePolicy() {
        return this.f3191a;
    }

    public final void loadFromBundle(Bundle bundle) {
        b0.i<String, SparseArray<Parcelable>> iVar = this.f3193c;
        if (iVar == null || bundle == null) {
            return;
        }
        iVar.evictAll();
        for (String str : bundle.keySet()) {
            this.f3193c.put(str, bundle.getSparseParcelableArray(str));
        }
    }

    public final void loadView(View view, int i10) {
        if (this.f3193c != null) {
            SparseArray<Parcelable> sparseArrayRemove = this.f3193c.remove(Integer.toString(i10));
            if (sparseArrayRemove != null) {
                view.restoreHierarchyState(sparseArrayRemove);
            }
        }
    }

    public void remove(int i10) {
        b0.i<String, SparseArray<Parcelable>> iVar = this.f3193c;
        if (iVar == null || iVar.size() == 0) {
            return;
        }
        this.f3193c.remove(Integer.toString(i10));
    }

    public final Bundle saveAsBundle() {
        b0.i<String, SparseArray<Parcelable>> iVar = this.f3193c;
        if (iVar == null || iVar.size() == 0) {
            return null;
        }
        Map<String, SparseArray<Parcelable>> mapSnapshot = this.f3193c.snapshot();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, SparseArray<Parcelable>> entry : mapSnapshot.entrySet()) {
            bundle.putSparseParcelableArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public final void saveOffscreenView(View view, int i10) {
        int i11 = this.f3191a;
        if (i11 == 1) {
            remove(i10);
        } else if (i11 == 2 || i11 == 3) {
            saveViewUnchecked(view, i10);
        }
    }

    public final Bundle saveOnScreenView(Bundle bundle, View view, int i10) {
        if (this.f3191a != 0) {
            String string = Integer.toString(i10);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(string, sparseArray);
        }
        return bundle;
    }

    public final void saveViewUnchecked(View view, int i10) {
        if (this.f3193c != null) {
            String string = Integer.toString(i10);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            this.f3193c.put(string, sparseArray);
        }
    }

    public final void setLimitNumber(int i10) {
        this.f3192b = i10;
        applyPolicyChanges();
    }

    public final void setSavePolicy(int i10) {
        this.f3191a = i10;
        applyPolicyChanges();
    }
}
