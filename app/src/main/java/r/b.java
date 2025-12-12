package r;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* compiled from: ActionBarDrawerToggle.java */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f18163b;

    public b(c cVar) {
        this.f18163b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar = this.f18163b;
        if (!cVar.f18182e) {
            cVar.getClass();
            return;
        }
        DrawerLayout drawerLayout = cVar.f18179b;
        int drawerLockMode = drawerLayout.getDrawerLockMode(8388611);
        if (drawerLayout.isDrawerVisible(8388611) && drawerLockMode != 2) {
            drawerLayout.closeDrawer(8388611);
        } else if (drawerLockMode != 1) {
            drawerLayout.openDrawer(8388611);
        }
    }
}
