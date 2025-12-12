package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import x0.j0;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1039a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1040b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1041c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1042d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1043e;

    /* renamed from: f, reason: collision with root package name */
    public View f1044f;

    /* renamed from: g, reason: collision with root package name */
    public int f1045g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1046h;

    /* renamed from: i, reason: collision with root package name */
    public i.a f1047i;

    /* renamed from: j, reason: collision with root package name */
    public x.d f1048j;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1049k;

    /* renamed from: l, reason: collision with root package name */
    public final a f1050l;

    /* compiled from: MenuPopupHelper.java */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            h.this.onDismiss();
        }
    }

    /* compiled from: MenuPopupHelper.java */
    public static class b {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public h(Context context, e eVar, View view, boolean z10, int i10) {
        this(context, eVar, view, z10, i10, 0);
    }

    public final void a(int i10, int i11, boolean z10, boolean z11) {
        x.d popup = getPopup();
        popup.setShowTitle(z11);
        if (z10) {
            if ((x0.h.getAbsoluteGravity(this.f1045g, j0.getLayoutDirection(this.f1044f)) & 7) == 5) {
                i10 -= this.f1044f.getWidth();
            }
            popup.setHorizontalOffset(i10);
            popup.setVerticalOffset(i11);
            int i12 = (int) ((this.f1039a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.f1048j.dismiss();
        }
    }

    public x.d getPopup() {
        if (this.f1048j == null) {
            Context context = this.f1039a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            b.a(defaultDisplay, point);
            x.d bVar = Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new androidx.appcompat.view.menu.b(this.f1039a, this.f1044f, this.f1042d, this.f1043e, this.f1041c) : new k(this.f1039a, this.f1040b, this.f1044f, this.f1042d, this.f1043e, this.f1041c);
            bVar.addMenu(this.f1040b);
            bVar.setOnDismissListener(this.f1050l);
            bVar.setAnchorView(this.f1044f);
            bVar.setCallback(this.f1047i);
            bVar.setForceShowIcon(this.f1046h);
            bVar.setGravity(this.f1045g);
            this.f1048j = bVar;
        }
        return this.f1048j;
    }

    public boolean isShowing() {
        x.d dVar = this.f1048j;
        return dVar != null && dVar.isShowing();
    }

    public void onDismiss() {
        this.f1048j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1049k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(View view) {
        this.f1044f = view;
    }

    public void setForceShowIcon(boolean z10) {
        this.f1046h = z10;
        x.d dVar = this.f1048j;
        if (dVar != null) {
            dVar.setForceShowIcon(z10);
        }
    }

    public void setGravity(int i10) {
        this.f1045g = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1049k = onDismissListener;
    }

    public void setPresenterCallback(i.a aVar) {
        this.f1047i = aVar;
        x.d dVar = this.f1048j;
        if (dVar != null) {
            dVar.setCallback(aVar);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f1044f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public h(Context context, e eVar, View view, boolean z10, int i10, int i11) {
        this.f1045g = 8388611;
        this.f1050l = new a();
        this.f1039a = context;
        this.f1040b = eVar;
        this.f1044f = view;
        this.f1041c = z10;
        this.f1042d = i10;
        this.f1043e = i11;
    }

    public boolean tryShow(int i10, int i11) {
        if (isShowing()) {
            return true;
        }
        if (this.f1044f == null) {
            return false;
        }
        a(i10, i11, true, true);
        return true;
    }
}
