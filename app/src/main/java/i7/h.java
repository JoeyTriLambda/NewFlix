package i7;

import android.content.Context;
import android.view.SubMenu;

/* compiled from: NavigationMenu.java */
/* loaded from: classes.dex */
public final class h extends androidx.appcompat.view.menu.e {
    public h(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) addInternal(i10, i11, i12, charSequence);
        k kVar = new k(getContext(), this, gVar);
        gVar.setSubMenu(kVar);
        return kVar;
    }
}
