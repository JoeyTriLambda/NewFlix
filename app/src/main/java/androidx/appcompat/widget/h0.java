package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;

/* compiled from: DecorToolbar.java */
/* loaded from: classes.dex */
public interface h0 {
    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    int getDisplayOptions();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setCollapsible(boolean z10);

    void setDisplayOptions(int i10);

    void setEmbeddedTabView(v0 v0Var);

    void setHomeButtonEnabled(boolean z10);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setLogo(int i10);

    void setMenu(Menu menu, i.a aVar);

    void setMenuCallbacks(i.a aVar, e.a aVar2);

    void setMenuPrepared();

    void setNavigationContentDescription(int i10);

    void setNavigationIcon(int i10);

    void setNavigationIcon(Drawable drawable);

    void setSubtitle(CharSequence charSequence);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i10);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    x0.r0 setupAnimatorToVisibility(int i10, long j10);

    boolean showOverflowMenu();
}
