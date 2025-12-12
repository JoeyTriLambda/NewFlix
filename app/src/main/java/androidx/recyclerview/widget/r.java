package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;
import java.util.ArrayList;

/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public final class r implements a.InterfaceC0039a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f4243a;

    public r(RecyclerView recyclerView) {
        this.f4243a = recyclerView;
    }

    public final void a(a.b bVar) {
        int i10 = bVar.f4108a;
        RecyclerView recyclerView = this.f4243a;
        if (i10 == 1) {
            recyclerView.f3938x.onItemsAdded(recyclerView, bVar.f4109b, bVar.f4111d);
            return;
        }
        if (i10 == 2) {
            recyclerView.f3938x.onItemsRemoved(recyclerView, bVar.f4109b, bVar.f4111d);
        } else if (i10 == 4) {
            recyclerView.f3938x.onItemsUpdated(recyclerView, bVar.f4109b, bVar.f4111d, bVar.f4110c);
        } else {
            if (i10 != 8) {
                return;
            }
            recyclerView.f3938x.onItemsMoved(recyclerView, bVar.f4109b, bVar.f4111d, 1);
        }
    }

    public RecyclerView.z findViewHolder(int i10) {
        RecyclerView recyclerView = this.f4243a;
        RecyclerView.z zVarZ = recyclerView.z(i10, true);
        if (zVarZ == null || recyclerView.f3922p.i(zVarZ.f4041a)) {
            return null;
        }
        return zVarZ;
    }

    public void markViewHoldersUpdated(int i10, int i11, Object obj) {
        int i12;
        int i13;
        RecyclerView recyclerView = this.f4243a;
        int iG = recyclerView.f3922p.g();
        int i14 = i11 + i10;
        for (int i15 = 0; i15 < iG; i15++) {
            View viewF = recyclerView.f3922p.f(i15);
            RecyclerView.z zVarC = RecyclerView.C(viewF);
            if (zVarC != null && !zVarC.l() && (i13 = zVarC.f4043c) >= i10 && i13 < i14) {
                zVarC.b(2);
                zVarC.a(obj);
                ((RecyclerView.m) viewF.getLayoutParams()).f3984c = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f3916m;
        ArrayList<RecyclerView.z> arrayList = rVar.f3994c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                recyclerView.f3935v0 = true;
                return;
            }
            RecyclerView.z zVar = arrayList.get(size);
            if (zVar != null && (i12 = zVar.f4043c) >= i10 && i12 < i14) {
                zVar.b(2);
                rVar.d(size);
            }
        }
    }

    public void offsetPositionsForAdd(int i10, int i11) {
        RecyclerView recyclerView = this.f4243a;
        int iG = recyclerView.f3922p.g();
        for (int i12 = 0; i12 < iG; i12++) {
            RecyclerView.z zVarC = RecyclerView.C(recyclerView.f3922p.f(i12));
            if (zVarC != null && !zVarC.l() && zVarC.f4043c >= i10) {
                zVarC.j(i11, false);
                recyclerView.f3927r0.f4022f = true;
            }
        }
        ArrayList<RecyclerView.z> arrayList = recyclerView.f3916m.f3994c;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView.z zVar = arrayList.get(i13);
            if (zVar != null && zVar.f4043c >= i10) {
                zVar.j(i11, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f3933u0 = true;
    }

    public void offsetPositionsForMove(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        RecyclerView recyclerView = this.f4243a;
        int iG = recyclerView.f3922p.g();
        int i19 = -1;
        if (i10 < i11) {
            i13 = i10;
            i12 = i11;
            i14 = -1;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i20 = 0; i20 < iG; i20++) {
            RecyclerView.z zVarC = RecyclerView.C(recyclerView.f3922p.f(i20));
            if (zVarC != null && (i18 = zVarC.f4043c) >= i13 && i18 <= i12) {
                if (i18 == i10) {
                    zVarC.j(i11 - i10, false);
                } else {
                    zVarC.j(i14, false);
                }
                recyclerView.f3927r0.f4022f = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f3916m;
        rVar.getClass();
        if (i10 < i11) {
            i16 = i10;
            i15 = i11;
        } else {
            i15 = i10;
            i16 = i11;
            i19 = 1;
        }
        ArrayList<RecyclerView.z> arrayList = rVar.f3994c;
        int size = arrayList.size();
        for (int i21 = 0; i21 < size; i21++) {
            RecyclerView.z zVar = arrayList.get(i21);
            if (zVar != null && (i17 = zVar.f4043c) >= i16 && i17 <= i15) {
                if (i17 == i10) {
                    zVar.j(i11 - i10, false);
                } else {
                    zVar.j(i19, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.f3933u0 = true;
    }

    public void offsetPositionsForRemovingInvisible(int i10, int i11) {
        RecyclerView recyclerView = this.f4243a;
        recyclerView.H(i10, i11, true);
        recyclerView.f3933u0 = true;
        recyclerView.f3927r0.f4019c += i11;
    }

    public void offsetPositionsForRemovingLaidOutOrNewView(int i10, int i11) {
        RecyclerView recyclerView = this.f4243a;
        recyclerView.H(i10, i11, false);
        recyclerView.f3933u0 = true;
    }

    public void onDispatchFirstPass(a.b bVar) {
        a(bVar);
    }

    public void onDispatchSecondPass(a.b bVar) {
        a(bVar);
    }
}
