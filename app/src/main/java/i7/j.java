package i7;

import android.view.View;
import i7.i;
import y0.d;

/* compiled from: NavigationMenuPresenter.java */
/* loaded from: classes.dex */
public final class j extends x0.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13300d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f13301e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i.c f13302f;

    public j(i.c cVar, int i10, boolean z10) {
        this.f13302f = cVar;
        this.f13300d = i10;
        this.f13301e = z10;
    }

    @Override // x0.a
    public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        int i10 = this.f13300d;
        int i11 = 0;
        int i12 = i10;
        while (true) {
            i.c cVar = this.f13302f;
            if (i11 >= i10) {
                cVar.getClass();
                dVar.setCollectionItemInfo(d.f.obtain(i12, 1, 1, 1, this.f13301e, view.isSelected()));
                return;
            } else {
                i iVar = i.this;
                if (iVar.f13279p.getItemViewType(i11) == 2 || iVar.f13279p.getItemViewType(i11) == 3) {
                    i12--;
                }
                i11++;
            }
        }
    }
}
