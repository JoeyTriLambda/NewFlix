package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.d;
import androidx.appcompat.view.menu.i;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, i.a {

    /* renamed from: b, reason: collision with root package name */
    public final e f1009b;

    /* renamed from: m, reason: collision with root package name */
    public androidx.appcompat.app.d f1010m;

    /* renamed from: n, reason: collision with root package name */
    public c f1011n;

    public f(e eVar) {
        this.f1009b = eVar;
    }

    public void dismiss() {
        androidx.appcompat.app.d dVar = this.f1010m;
        if (dVar != null) {
            dVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f1009b.performItemAction((g) this.f1011n.getAdapter().getItem(i10), 0);
    }

    @Override // androidx.appcompat.view.menu.i.a
    public void onCloseMenu(e eVar, boolean z10) {
        if (z10 || eVar == this.f1009b) {
            dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1011n.onCloseMenu(this.f1009b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        e eVar = this.f1009b;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1010m.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1010m.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                eVar.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return eVar.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.view.menu.i.a
    public boolean onOpenSubMenu(e eVar) {
        return false;
    }

    public void show(IBinder iBinder) {
        e eVar = this.f1009b;
        d.a aVar = new d.a(eVar.getContext());
        c cVar = new c(aVar.getContext(), R.layout.abc_list_menu_item_layout);
        this.f1011n = cVar;
        cVar.setCallback(this);
        eVar.addMenuPresenter(this.f1011n);
        aVar.setAdapter(this.f1011n.getAdapter(), this);
        View headerView = eVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(eVar.getHeaderIcon()).setTitle(eVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        androidx.appcompat.app.d dVarCreate = aVar.create();
        this.f1010m = dVarCreate;
        dVarCreate.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1010m.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1010m.show();
    }
}
