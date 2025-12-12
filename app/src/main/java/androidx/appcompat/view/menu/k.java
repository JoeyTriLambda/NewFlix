package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.q0;
import java.lang.reflect.InvocationTargetException;
import x0.j0;

/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public final class k extends x.d implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public static final int G = R.layout.abc_popup_menu_item_layout;
    public ViewTreeObserver A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean F;

    /* renamed from: m, reason: collision with root package name */
    public final Context f1052m;

    /* renamed from: n, reason: collision with root package name */
    public final e f1053n;

    /* renamed from: o, reason: collision with root package name */
    public final d f1054o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f1055p;

    /* renamed from: q, reason: collision with root package name */
    public final int f1056q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1057r;

    /* renamed from: s, reason: collision with root package name */
    public final int f1058s;

    /* renamed from: t, reason: collision with root package name */
    public final q0 f1059t;

    /* renamed from: w, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1062w;

    /* renamed from: x, reason: collision with root package name */
    public View f1063x;

    /* renamed from: y, reason: collision with root package name */
    public View f1064y;

    /* renamed from: z, reason: collision with root package name */
    public i.a f1065z;

    /* renamed from: u, reason: collision with root package name */
    public final a f1060u = new a();

    /* renamed from: v, reason: collision with root package name */
    public final b f1061v = new b();
    public int E = 0;

    /* compiled from: StandardMenuPopup.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            k kVar = k.this;
            if (!kVar.isShowing() || kVar.f1059t.isModal()) {
                return;
            }
            View view = kVar.f1064y;
            if (view == null || !view.isShown()) {
                kVar.dismiss();
            } else {
                kVar.f1059t.show();
            }
        }
    }

    public k(Context context, e eVar, View view, int i10, int i11, boolean z10) {
        this.f1052m = context;
        this.f1053n = eVar;
        this.f1055p = z10;
        this.f1054o = new d(eVar, LayoutInflater.from(context), z10, G);
        this.f1057r = i10;
        this.f1058s = i11;
        Resources resources = context.getResources();
        this.f1056q = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1063x = view;
        this.f1059t = new q0(context, null, i10, i11);
        eVar.addMenuPresenter(this, context);
    }

    @Override // x.f
    public void dismiss() {
        if (isShowing()) {
            this.f1059t.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean flagActionItems() {
        return false;
    }

    @Override // x.f
    public ListView getListView() {
        return this.f1059t.getListView();
    }

    @Override // x.f
    public boolean isShowing() {
        return !this.B && this.f1059t.isShowing();
    }

    @Override // androidx.appcompat.view.menu.i
    public void onCloseMenu(e eVar, boolean z10) {
        if (eVar != this.f1053n) {
            return;
        }
        dismiss();
        i.a aVar = this.f1065z;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, z10);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.B = true;
        this.f1053n.close();
        ViewTreeObserver viewTreeObserver = this.A;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.A = this.f1064y.getViewTreeObserver();
            }
            this.A.removeGlobalOnLayoutListener(this.f1060u);
            this.A = null;
        }
        this.f1064y.removeOnAttachStateChangeListener(this.f1061v);
        PopupWindow.OnDismissListener onDismissListener = this.f1062w;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
    public boolean onSubMenuSelected(l lVar) {
        if (lVar.hasVisibleItems()) {
            h hVar = new h(this.f1052m, lVar, this.f1064y, this.f1055p, this.f1057r, this.f1058s);
            hVar.setPresenterCallback(this.f1065z);
            hVar.setForceShowIcon(x.d.shouldPreserveIconSpacing(lVar));
            hVar.setOnDismissListener(this.f1062w);
            this.f1062w = null;
            this.f1053n.close(false);
            q0 q0Var = this.f1059t;
            int horizontalOffset = q0Var.getHorizontalOffset();
            int verticalOffset = q0Var.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.E, j0.getLayoutDirection(this.f1063x)) & 7) == 5) {
                horizontalOffset += this.f1063x.getWidth();
            }
            if (hVar.tryShow(horizontalOffset, verticalOffset)) {
                i.a aVar = this.f1065z;
                if (aVar == null) {
                    return true;
                }
                aVar.onOpenSubMenu(lVar);
                return true;
            }
        }
        return false;
    }

    @Override // x.d
    public void setAnchorView(View view) {
        this.f1063x = view;
    }

    @Override // androidx.appcompat.view.menu.i
    public void setCallback(i.a aVar) {
        this.f1065z = aVar;
    }

    @Override // x.d
    public void setForceShowIcon(boolean z10) {
        this.f1054o.setForceShowIcon(z10);
    }

    @Override // x.d
    public void setGravity(int i10) {
        this.E = i10;
    }

    @Override // x.d
    public void setHorizontalOffset(int i10) {
        this.f1059t.setHorizontalOffset(i10);
    }

    @Override // x.d
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1062w = onDismissListener;
    }

    @Override // x.d
    public void setShowTitle(boolean z10) {
        this.F = z10;
    }

    @Override // x.d
    public void setVerticalOffset(int i10) {
        this.f1059t.setVerticalOffset(i10);
    }

    @Override // x.f
    public void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View view;
        boolean z10 = true;
        if (!isShowing()) {
            if (this.B || (view = this.f1063x) == null) {
                z10 = false;
            } else {
                this.f1064y = view;
                q0 q0Var = this.f1059t;
                q0Var.setOnDismissListener(this);
                q0Var.setOnItemClickListener(this);
                q0Var.setModal(true);
                View view2 = this.f1064y;
                boolean z11 = this.A == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.A = viewTreeObserver;
                if (z11) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f1060u);
                }
                view2.addOnAttachStateChangeListener(this.f1061v);
                q0Var.setAnchorView(view2);
                q0Var.setDropDownGravity(this.E);
                boolean z12 = this.C;
                Context context = this.f1052m;
                d dVar = this.f1054o;
                if (!z12) {
                    this.D = x.d.measureIndividualMenuWidth(dVar, null, context, this.f1056q);
                    this.C = true;
                }
                q0Var.setContentWidth(this.D);
                q0Var.setInputMethodMode(2);
                q0Var.setEpicenterBounds(getEpicenterBounds());
                q0Var.show();
                ListView listView = q0Var.getListView();
                listView.setOnKeyListener(this);
                if (this.F) {
                    e eVar = this.f1053n;
                    if (eVar.getHeaderTitle() != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
                        TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                        if (textView != null) {
                            textView.setText(eVar.getHeaderTitle());
                        }
                        frameLayout.setEnabled(false);
                        listView.addHeaderView(frameLayout, null, false);
                    }
                }
                q0Var.setAdapter(dVar);
                q0Var.show();
            }
        }
        if (!z10) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void updateMenuView(boolean z10) {
        this.C = false;
        d dVar = this.f1054o;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    /* compiled from: StandardMenuPopup.java */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            k kVar = k.this;
            ViewTreeObserver viewTreeObserver = kVar.A;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    kVar.A = view.getViewTreeObserver();
                }
                kVar.A.removeGlobalOnLayoutListener(kVar.f1060u);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }

    @Override // x.d
    public void addMenu(e eVar) {
    }

    @Override // androidx.appcompat.view.menu.i
    public void onRestoreInstanceState(Parcelable parcelable) {
    }
}
