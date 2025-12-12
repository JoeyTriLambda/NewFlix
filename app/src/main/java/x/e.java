package x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b0.k;

/* compiled from: MenuWrapperICS.java */
/* loaded from: classes.dex */
public class e extends b implements Menu {

    /* renamed from: d, reason: collision with root package name */
    public final q0.a f21214d;

    public e(Context context, q0.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f21214d = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(this.f21214d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f21214d.addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr[i14] = a(menuItemArr2[i14]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return b(this.f21214d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        k<q0.b, MenuItem> kVar = this.f21201b;
        if (kVar != null) {
            kVar.clear();
        }
        k<q0.c, SubMenu> kVar2 = this.f21202c;
        if (kVar2 != null) {
            kVar2.clear();
        }
        this.f21214d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f21214d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        return a(this.f21214d.findItem(i10));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return a(this.f21214d.getItem(i10));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f21214d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return this.f21214d.isShortcutKey(i10, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return this.f21214d.performIdentifierAction(i10, i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return this.f21214d.performShortcut(i10, keyEvent, i11);
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        if (this.f21201b != null) {
            int i11 = 0;
            while (i11 < this.f21201b.size()) {
                if (this.f21201b.keyAt(i11).getGroupId() == i10) {
                    this.f21201b.removeAt(i11);
                    i11--;
                }
                i11++;
            }
        }
        this.f21214d.removeGroup(i10);
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        if (this.f21201b != null) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.f21201b.size()) {
                    break;
                }
                if (this.f21201b.keyAt(i11).getItemId() == i10) {
                    this.f21201b.removeAt(i11);
                    break;
                }
                i11++;
            }
        }
        this.f21214d.removeItem(i10);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        this.f21214d.setGroupCheckable(i10, z10, z11);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        this.f21214d.setGroupEnabled(i10, z10);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        this.f21214d.setGroupVisible(i10, z10);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f21214d.setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f21214d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(this.f21214d.add(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return b(this.f21214d.addSubMenu(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(this.f21214d.add(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return b(this.f21214d.addSubMenu(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(this.f21214d.add(i10, i11, i12, i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return b(this.f21214d.addSubMenu(i10, i11, i12, i13));
    }
}
