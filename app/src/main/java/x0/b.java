package x0;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21227a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0310b f21228b;

    /* compiled from: ActionProvider.java */
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: x0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0310b {
    }

    public b(Context context) {
        this.f21227a = context;
    }

    public Context getContext() {
        return this.f21227a;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void reset() {
        this.f21228b = null;
    }

    public void setVisibilityListener(InterfaceC0310b interfaceC0310b) {
        if (this.f21228b != null && interfaceC0310b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f21228b = interfaceC0310b;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public void setSubUiVisibilityListener(a aVar) {
    }
}
