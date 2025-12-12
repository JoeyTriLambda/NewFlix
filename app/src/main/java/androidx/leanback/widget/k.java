package androidx.leanback.widget;

import android.graphics.PointF;
import androidx.leanback.widget.j;

/* compiled from: GridLayoutManager.java */
/* loaded from: classes.dex */
public final class k extends j.c {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ j f3280s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar) {
        super();
        this.f3280s = jVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        j jVar = this.f3280s;
        boolean z10 = false;
        int position = jVar.getPosition(jVar.getChildAt(0));
        if ((jVar.f3259z & 262144) == 0 ? i10 < position : i10 > position) {
            z10 = true;
        }
        int i11 = z10 ? -1 : 1;
        return jVar.f3251r == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }
}
