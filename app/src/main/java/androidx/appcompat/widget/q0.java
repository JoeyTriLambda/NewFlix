package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public final class q0 extends o0 implements p0 {
    public static final Method P;
    public p0 O;

    /* compiled from: MenuPopupWindow.java */
    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    public static class b {
        public static void a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    public static class c extends j0 {
        public androidx.appcompat.view.menu.g A;

        /* renamed from: x, reason: collision with root package name */
        public final int f1495x;

        /* renamed from: y, reason: collision with root package name */
        public final int f1496y;

        /* renamed from: z, reason: collision with root package name */
        public p0 f1497z;

        /* compiled from: MenuPopupWindow.java */
        public static class a {
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z10) {
            super(context, z10);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f1495x = 21;
                this.f1496y = 22;
            } else {
                this.f1495x = 22;
                this.f1496y = 21;
            }
        }

        @Override // androidx.appcompat.widget.j0, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.j0, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.j0, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.j0, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.j0
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i10, int i11, int i12, int i13, int i14) {
            return super.measureHeightOfChildrenCompat(i10, i11, i12, i13, i14);
        }

        @Override // androidx.appcompat.widget.j0
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i10) {
            return super.onForwardedEvent(motionEvent, i10);
        }

        @Override // androidx.appcompat.widget.j0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.d dVar;
            int headersCount;
            int iPointToPosition;
            int i10;
            if (this.f1497z != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.g item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i10 = iPointToPosition - headersCount) < 0 || i10 >= dVar.getCount()) ? null : dVar.getItem(i10);
                androidx.appcompat.view.menu.g gVar = this.A;
                if (gVar != item) {
                    androidx.appcompat.view.menu.e adapterMenu = dVar.getAdapterMenu();
                    if (gVar != null) {
                        this.f1497z.onItemHoverExit(adapterMenu, gVar);
                    }
                    this.A = item;
                    if (item != null) {
                        this.f1497z.onItemHoverEnter(adapterMenu, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f1495x) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i10 != this.f1496y) {
                return super.onKeyDown(i10, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) adapter).getAdapterMenu().close(false);
            return true;
        }

        @Override // androidx.appcompat.widget.j0, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(p0 p0Var) {
            this.f1497z = p0Var;
        }

        @Override // androidx.appcompat.widget.j0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                P = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public q0(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.appcompat.widget.o0
    public final j0 a(Context context, boolean z10) {
        c cVar = new c(context, z10);
        cVar.setHoverListener(this);
        return cVar;
    }

    @Override // androidx.appcompat.widget.p0
    public void onItemHoverEnter(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        p0 p0Var = this.O;
        if (p0Var != null) {
            p0Var.onItemHoverEnter(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.p0
    public void onItemHoverExit(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        p0 p0Var = this.O;
        if (p0Var != null) {
            p0Var.onItemHoverExit(eVar, menuItem);
        }
    }

    public void setEnterTransition(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.K, (Transition) obj);
        }
    }

    public void setExitTransition(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.K, (Transition) obj);
        }
    }

    public void setHoverListener(p0 p0Var) {
        this.O = p0Var;
    }

    public void setTouchModal(boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        s sVar = this.K;
        if (i10 > 28) {
            b.a(sVar, z10);
            return;
        }
        Method method = P;
        if (method != null) {
            try {
                method.invoke(sVar, Boolean.valueOf(z10));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
