package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.p0;
import androidx.appcompat.widget.q0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import x0.j0;

/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class b extends x.d implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int M = R.layout.abc_cascading_menu_item_layout;
    public View A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public boolean H;
    public i.a I;
    public ViewTreeObserver J;
    public PopupWindow.OnDismissListener K;
    public boolean L;

    /* renamed from: m, reason: collision with root package name */
    public final Context f944m;

    /* renamed from: n, reason: collision with root package name */
    public final int f945n;

    /* renamed from: o, reason: collision with root package name */
    public final int f946o;

    /* renamed from: p, reason: collision with root package name */
    public final int f947p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f948q;

    /* renamed from: r, reason: collision with root package name */
    public final Handler f949r;

    /* renamed from: z, reason: collision with root package name */
    public View f957z;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f950s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f951t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final a f952u = new a();

    /* renamed from: v, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0014b f953v = new ViewOnAttachStateChangeListenerC0014b();

    /* renamed from: w, reason: collision with root package name */
    public final c f954w = new c();

    /* renamed from: x, reason: collision with root package name */
    public int f955x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f956y = 0;
    public boolean G = false;

    /* compiled from: CascadingMenuPopup.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            b bVar = b.this;
            if (bVar.isShowing()) {
                ArrayList arrayList = bVar.f951t;
                if (arrayList.size() <= 0 || ((d) arrayList.get(0)).f965a.isModal()) {
                    return;
                }
                View view = bVar.A;
                if (view == null || !view.isShown()) {
                    bVar.dismiss();
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f965a.show();
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    public class c implements p0 {

        /* compiled from: CascadingMenuPopup.java */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f961b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MenuItem f962m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ e f963n;

            public a(d dVar, MenuItem menuItem, e eVar) {
                this.f961b = dVar;
                this.f962m = menuItem;
                this.f963n = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f961b;
                if (dVar != null) {
                    c cVar = c.this;
                    b.this.L = true;
                    dVar.f966b.close(false);
                    b.this.L = false;
                }
                MenuItem menuItem = this.f962m;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    this.f963n.performItemAction(menuItem, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.p0
        public void onItemHoverEnter(e eVar, MenuItem menuItem) {
            b bVar = b.this;
            bVar.f949r.removeCallbacksAndMessages(null);
            ArrayList arrayList = bVar.f951t;
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (eVar == ((d) arrayList.get(i10)).f966b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            bVar.f949r.postAtTime(new a(i11 < arrayList.size() ? (d) arrayList.get(i11) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.p0
        public void onItemHoverExit(e eVar, MenuItem menuItem) {
            b.this.f949r.removeCallbacksAndMessages(eVar);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final q0 f965a;

        /* renamed from: b, reason: collision with root package name */
        public final e f966b;

        /* renamed from: c, reason: collision with root package name */
        public final int f967c;

        public d(q0 q0Var, e eVar, int i10) {
            this.f965a = q0Var;
            this.f966b = eVar;
            this.f967c = i10;
        }

        public ListView getListView() {
            return this.f965a.getListView();
        }
    }

    public b(Context context, View view, int i10, int i11, boolean z10) {
        this.f944m = context;
        this.f957z = view;
        this.f946o = i10;
        this.f947p = i11;
        this.f948q = z10;
        this.B = j0.getLayoutDirection(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f945n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f949r = new Handler();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(androidx.appcompat.view.menu.e r17) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.a(androidx.appcompat.view.menu.e):void");
    }

    @Override // x.d
    public void addMenu(e eVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        eVar.addMenuPresenter(this, this.f944m);
        if (isShowing()) {
            a(eVar);
        } else {
            this.f950s.add(eVar);
        }
    }

    @Override // x.d
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // x.f
    public void dismiss() {
        ArrayList arrayList = this.f951t;
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d dVar = dVarArr[size];
            if (dVar.f965a.isShowing()) {
                dVar.f965a.dismiss();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean flagActionItems() {
        return false;
    }

    @Override // x.f
    public ListView getListView() {
        ArrayList arrayList = this.f951t;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).getListView();
    }

    @Override // x.f
    public boolean isShowing() {
        ArrayList arrayList = this.f951t;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).f965a.isShowing();
    }

    @Override // androidx.appcompat.view.menu.i
    public void onCloseMenu(e eVar, boolean z10) {
        ArrayList arrayList = this.f951t;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (eVar == ((d) arrayList.get(i10)).f966b) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            return;
        }
        int i11 = i10 + 1;
        if (i11 < arrayList.size()) {
            ((d) arrayList.get(i11)).f966b.close(false);
        }
        d dVar = (d) arrayList.remove(i10);
        dVar.f966b.removeMenuPresenter(this);
        boolean z11 = this.L;
        q0 q0Var = dVar.f965a;
        if (z11) {
            q0Var.setExitTransition(null);
            q0Var.setAnimationStyle(0);
        }
        q0Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.B = ((d) arrayList.get(size2 - 1)).f967c;
        } else {
            this.B = j0.getLayoutDirection(this.f957z) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z10) {
                ((d) arrayList.get(0)).f966b.close(false);
                return;
            }
            return;
        }
        dismiss();
        i.a aVar = this.I;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.J;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.J.removeGlobalOnLayoutListener(this.f952u);
            }
            this.J = null;
        }
        this.A.removeOnAttachStateChangeListener(this.f953v);
        this.K.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        ArrayList arrayList = this.f951t;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i10);
            if (!dVar.f965a.isShowing()) {
                break;
            } else {
                i10++;
            }
        }
        if (dVar != null) {
            dVar.f966b.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean onSubMenuSelected(l lVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Iterator it = this.f951t.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (lVar == dVar.f966b) {
                dVar.getListView().requestFocus();
                return true;
            }
        }
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        addMenu(lVar);
        i.a aVar = this.I;
        if (aVar != null) {
            aVar.onOpenSubMenu(lVar);
        }
        return true;
    }

    @Override // x.d
    public void setAnchorView(View view) {
        if (this.f957z != view) {
            this.f957z = view;
            this.f956y = x0.h.getAbsoluteGravity(this.f955x, j0.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void setCallback(i.a aVar) {
        this.I = aVar;
    }

    @Override // x.d
    public void setForceShowIcon(boolean z10) {
        this.G = z10;
    }

    @Override // x.d
    public void setGravity(int i10) {
        if (this.f955x != i10) {
            this.f955x = i10;
            this.f956y = x0.h.getAbsoluteGravity(i10, j0.getLayoutDirection(this.f957z));
        }
    }

    @Override // x.d
    public void setHorizontalOffset(int i10) {
        this.C = true;
        this.E = i10;
    }

    @Override // x.d
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.K = onDismissListener;
    }

    @Override // x.d
    public void setShowTitle(boolean z10) {
        this.H = z10;
    }

    @Override // x.d
    public void setVerticalOffset(int i10) {
        this.D = true;
        this.F = i10;
    }

    @Override // x.f
    public void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.f950s;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((e) it.next());
        }
        arrayList.clear();
        View view = this.f957z;
        this.A = view;
        if (view != null) {
            boolean z10 = this.J == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.J = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f952u);
            }
            this.A.addOnAttachStateChangeListener(this.f953v);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void updateMenuView(boolean z10) {
        Iterator it = this.f951t.iterator();
        while (it.hasNext()) {
            x.d.toMenuAdapter(((d) it.next()).getListView().getAdapter()).notifyDataSetChanged();
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0014b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0014b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            b bVar = b.this;
            ViewTreeObserver viewTreeObserver = bVar.J;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    bVar.J = view.getViewTreeObserver();
                }
                bVar.J.removeGlobalOnLayoutListener(bVar.f952u);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void onRestoreInstanceState(Parcelable parcelable) {
    }
}
