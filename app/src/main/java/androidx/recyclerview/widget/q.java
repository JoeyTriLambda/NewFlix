package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b;
import x0.j0;

/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public final class q implements b.InterfaceC0040b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f4242a;

    public q(RecyclerView recyclerView) {
        this.f4242a = recyclerView;
    }

    public void addView(View view, int i10) {
        RecyclerView recyclerView = this.f4242a;
        recyclerView.addView(view, i10);
        recyclerView.getClass();
        RecyclerView.z zVarC = RecyclerView.C(view);
        recyclerView.onChildAttachedToWindow(view);
        RecyclerView.Adapter adapter = recyclerView.f3936w;
        if (adapter == null || zVarC == null) {
            return;
        }
        adapter.onViewAttachedToWindow(zVarC);
    }

    public void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        RecyclerView.z zVarC = RecyclerView.C(view);
        RecyclerView recyclerView = this.f4242a;
        if (zVarC != null) {
            if (!zVarC.i() && !zVarC.l()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + zVarC + recyclerView.u());
            }
            zVarC.f4050j &= -257;
        }
        recyclerView.attachViewToParent(view, i10, layoutParams);
    }

    public void detachViewFromParent(int i10) {
        RecyclerView.z zVarC;
        View childAt = getChildAt(i10);
        RecyclerView recyclerView = this.f4242a;
        if (childAt != null && (zVarC = RecyclerView.C(childAt)) != null) {
            if (zVarC.i() && !zVarC.l()) {
                throw new IllegalArgumentException("called detach on an already detached child " + zVarC + recyclerView.u());
            }
            zVarC.b(256);
        }
        recyclerView.detachViewFromParent(i10);
    }

    public View getChildAt(int i10) {
        return this.f4242a.getChildAt(i10);
    }

    public int getChildCount() {
        return this.f4242a.getChildCount();
    }

    public RecyclerView.z getChildViewHolder(View view) {
        return RecyclerView.C(view);
    }

    public int indexOfChild(View view) {
        return this.f4242a.indexOfChild(view);
    }

    public void onEnteredHiddenState(View view) {
        RecyclerView.z zVarC = RecyclerView.C(view);
        if (zVarC != null) {
            int i10 = zVarC.f4057q;
            View view2 = zVarC.f4041a;
            if (i10 != -1) {
                zVarC.f4056p = i10;
            } else {
                zVarC.f4056p = j0.getImportantForAccessibility(view2);
            }
            RecyclerView recyclerView = this.f4242a;
            if (!recyclerView.isComputingLayout()) {
                j0.setImportantForAccessibility(view2, 4);
            } else {
                zVarC.f4057q = 4;
                recyclerView.E0.add(zVarC);
            }
        }
    }

    public void onLeftHiddenState(View view) {
        RecyclerView.z zVarC = RecyclerView.C(view);
        if (zVarC != null) {
            int i10 = zVarC.f4056p;
            RecyclerView recyclerView = this.f4242a;
            if (recyclerView.isComputingLayout()) {
                zVarC.f4057q = i10;
                recyclerView.E0.add(zVarC);
            } else {
                j0.setImportantForAccessibility(zVarC.f4041a, i10);
            }
            zVarC.f4056p = 0;
        }
    }

    public void removeAllViews() {
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            RecyclerView recyclerView = this.f4242a;
            if (i10 >= childCount) {
                recyclerView.removeAllViews();
                return;
            }
            View childAt = getChildAt(i10);
            recyclerView.l(childAt);
            childAt.clearAnimation();
            i10++;
        }
    }

    public void removeViewAt(int i10) {
        RecyclerView recyclerView = this.f4242a;
        View childAt = recyclerView.getChildAt(i10);
        if (childAt != null) {
            recyclerView.l(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i10);
    }
}
