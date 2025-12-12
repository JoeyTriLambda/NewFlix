package i7;

import android.content.Context;

/* compiled from: NavigationSubMenu.java */
/* loaded from: classes.dex */
public final class k extends androidx.appcompat.view.menu.l {
    public k(Context context, h hVar, androidx.appcompat.view.menu.g gVar) {
        super(context, hVar, gVar);
    }

    @Override // androidx.appcompat.view.menu.e
    public void onItemsChanged(boolean z10) {
        super.onItemsChanged(z10);
        ((androidx.appcompat.view.menu.e) getParentMenu()).onItemsChanged(z10);
    }
}
