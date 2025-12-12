package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.i;

/* compiled from: DecorContentParent.java */
/* loaded from: classes.dex */
public interface g0 {
    boolean canShowOverflowMenu();

    void dismissPopups();

    boolean hideOverflowMenu();

    void initFeature(int i10);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setMenu(Menu menu, i.a aVar);

    void setMenuPrepared();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
