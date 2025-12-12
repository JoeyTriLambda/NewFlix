package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class u extends RecyclerView.i {

    /* renamed from: g, reason: collision with root package name */
    public boolean f4248g = true;

    public abstract boolean animateAdd(RecyclerView.z zVar);

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean animateAppearance(RecyclerView.z zVar, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i10;
        int i11;
        return (cVar == null || ((i10 = cVar.f3958a) == (i11 = cVar2.f3958a) && cVar.f3959b == cVar2.f3959b)) ? animateAdd(zVar) : animateMove(zVar, i10, cVar.f3959b, i11, cVar2.f3959b);
    }

    public abstract boolean animateChange(RecyclerView.z zVar, RecyclerView.z zVar2, int i10, int i11, int i12, int i13);

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean animateChange(RecyclerView.z zVar, RecyclerView.z zVar2, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f3958a;
        int i13 = cVar.f3959b;
        if (zVar2.l()) {
            int i14 = cVar.f3958a;
            i11 = cVar.f3959b;
            i10 = i14;
        } else {
            i10 = cVar2.f3958a;
            i11 = cVar2.f3959b;
        }
        return animateChange(zVar, zVar2, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean animateDisappearance(RecyclerView.z zVar, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i10 = cVar.f3958a;
        int i11 = cVar.f3959b;
        View view = zVar.f4041a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3958a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3959b;
        if (zVar.g() || (i10 == left && i11 == top)) {
            return animateRemove(zVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(zVar, i10, i11, left, top);
    }

    public abstract boolean animateMove(RecyclerView.z zVar, int i10, int i11, int i12, int i13);

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean animatePersistence(RecyclerView.z zVar, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i10 = cVar.f3958a;
        int i11 = cVar2.f3958a;
        if (i10 != i11 || cVar.f3959b != cVar2.f3959b) {
            return animateMove(zVar, i10, cVar.f3959b, i11, cVar2.f3959b);
        }
        dispatchMoveFinished(zVar);
        return false;
    }

    public abstract boolean animateRemove(RecyclerView.z zVar);

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canReuseUpdatedViewHolder(RecyclerView.z zVar) {
        return !this.f4248g || zVar.f();
    }

    public final void dispatchAddFinished(RecyclerView.z zVar) {
        onAddFinished(zVar);
        dispatchAnimationFinished(zVar);
    }

    public final void dispatchAddStarting(RecyclerView.z zVar) {
        onAddStarting(zVar);
    }

    public final void dispatchChangeFinished(RecyclerView.z zVar, boolean z10) {
        onChangeFinished(zVar, z10);
        dispatchAnimationFinished(zVar);
    }

    public final void dispatchChangeStarting(RecyclerView.z zVar, boolean z10) {
        onChangeStarting(zVar, z10);
    }

    public final void dispatchMoveFinished(RecyclerView.z zVar) {
        onMoveFinished(zVar);
        dispatchAnimationFinished(zVar);
    }

    public final void dispatchMoveStarting(RecyclerView.z zVar) {
        onMoveStarting(zVar);
    }

    public final void dispatchRemoveFinished(RecyclerView.z zVar) {
        onRemoveFinished(zVar);
        dispatchAnimationFinished(zVar);
    }

    public final void dispatchRemoveStarting(RecyclerView.z zVar) {
        onRemoveStarting(zVar);
    }

    public void setSupportsChangeAnimations(boolean z10) {
        this.f4248g = z10;
    }

    public void onAddFinished(RecyclerView.z zVar) {
    }

    public void onAddStarting(RecyclerView.z zVar) {
    }

    public void onMoveFinished(RecyclerView.z zVar) {
    }

    public void onMoveStarting(RecyclerView.z zVar) {
    }

    public void onRemoveFinished(RecyclerView.z zVar) {
    }

    public void onRemoveStarting(RecyclerView.z zVar) {
    }

    public void onChangeFinished(RecyclerView.z zVar, boolean z10) {
    }

    public void onChangeStarting(RecyclerView.z zVar, boolean z10) {
    }
}
