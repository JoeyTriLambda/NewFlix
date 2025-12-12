package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.e;

/* compiled from: PopupMenu.java */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1502a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.appcompat.view.menu.e f1503b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.appcompat.view.menu.h f1504c;

    /* renamed from: d, reason: collision with root package name */
    public c f1505d;

    /* compiled from: PopupMenu.java */
    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            r0.this.getClass();
        }
    }

    /* compiled from: PopupMenu.java */
    public interface c {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public r0(Context context, View view) {
        this(context, view, 0);
    }

    public void dismiss() {
        this.f1504c.dismiss();
    }

    public Menu getMenu() {
        return this.f1503b;
    }

    public MenuInflater getMenuInflater() {
        return new w.g(this.f1502a);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.f1505d = cVar;
    }

    public void show() {
        this.f1504c.show();
    }

    public r0(Context context, View view, int i10) {
        this(context, view, i10, R.attr.popupMenuStyle, 0);
    }

    public r0(Context context, View view, int i10, int i11, int i12) {
        this.f1502a = context;
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        this.f1503b = eVar;
        eVar.setCallback(new a());
        androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context, eVar, view, false, i11, i12);
        this.f1504c = hVar;
        hVar.setGravity(i10);
        hVar.setOnDismissListener(new b());
    }

    /* compiled from: PopupMenu.java */
    public class a implements e.a {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            c cVar = r0.this.f1505d;
            if (cVar != null) {
                return cVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
        }
    }
}
