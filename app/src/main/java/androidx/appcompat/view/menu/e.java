package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import x0.m0;

/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class e implements q0.a {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f984y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f985a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f986b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f987c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f988d;

    /* renamed from: e, reason: collision with root package name */
    public a f989e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<g> f990f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<g> f991g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f992h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<g> f993i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<g> f994j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f995k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f997m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f998n;

    /* renamed from: o, reason: collision with root package name */
    public View f999o;

    /* renamed from: v, reason: collision with root package name */
    public g f1006v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1008x;

    /* renamed from: l, reason: collision with root package name */
    public int f996l = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1000p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1001q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1002r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1003s = false;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList<g> f1004t = new ArrayList<>();

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<i>> f1005u = new CopyOnWriteArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    public boolean f1007w = false;

    /* compiled from: MenuBuilder.java */
    public interface a {
        boolean onMenuItemSelected(e eVar, MenuItem menuItem);

        void onMenuModeChange(e eVar);
    }

    /* compiled from: MenuBuilder.java */
    public interface b {
        boolean invokeItem(g gVar);
    }

    public e(Context context) {
        boolean z10 = false;
        this.f985a = context;
        Resources resources = context.getResources();
        this.f986b = resources;
        this.f990f = new ArrayList<>();
        this.f991g = new ArrayList<>();
        this.f992h = true;
        this.f993i = new ArrayList<>();
        this.f994j = new ArrayList<>();
        this.f995k = true;
        if (resources.getConfiguration().keyboard != 1 && m0.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(context), context)) {
            z10 = true;
        }
        this.f988d = z10;
    }

    public boolean a(e eVar, MenuItem menuItem) {
        a aVar = this.f989e;
        return aVar != null && aVar.onMenuItemSelected(eVar, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f985a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    public MenuItem addInternal(int i10, int i11, int i12, CharSequence charSequence) {
        int i13;
        int i14 = ((-65536) & i12) >> 16;
        if (i14 < 0 || i14 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i15 = (f984y[i14] << 16) | (65535 & i12);
        g gVar = new g(this, i10, i11, i12, i15, charSequence, this.f996l);
        ArrayList<g> arrayList = this.f990f;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                i13 = 0;
                break;
            }
            if (arrayList.get(size).getOrdering() <= i15) {
                i13 = size + 1;
                break;
            }
        }
        arrayList.add(i13, gVar);
        onItemsChanged(true);
        return gVar;
    }

    public void addMenuPresenter(i iVar) {
        addMenuPresenter(iVar, this.f985a);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final g b(int i10, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f1004t;
        arrayList.clear();
        c(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zIsQwertyMode = isQwertyMode();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            char alphabeticShortcut = zIsQwertyMode ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zIsQwertyMode && alphabeticShortcut == '\b' && i10 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.util.ArrayList r17, int r18, android.view.KeyEvent r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r16.isQwertyMode()
            int r4 = r19.getModifiers()
            android.view.KeyCharacterMap$KeyData r5 = new android.view.KeyCharacterMap$KeyData
            r5.<init>()
            boolean r6 = r2.getKeyData(r5)
            r7 = 67
            if (r6 != 0) goto L1e
            if (r1 == r7) goto L1e
            return
        L1e:
            r6 = r16
            java.util.ArrayList<androidx.appcompat.view.menu.g> r8 = r6.f990f
            int r9 = r8.size()
            r10 = 0
            r11 = 0
        L28:
            if (r11 >= r9) goto L8b
            java.lang.Object r12 = r8.get(r11)
            androidx.appcompat.view.menu.g r12 = (androidx.appcompat.view.menu.g) r12
            boolean r13 = r12.hasSubMenu()
            if (r13 == 0) goto L3f
            android.view.SubMenu r13 = r12.getSubMenu()
            androidx.appcompat.view.menu.e r13 = (androidx.appcompat.view.menu.e) r13
            r13.c(r0, r1, r2)
        L3f:
            if (r3 == 0) goto L46
            char r13 = r12.getAlphabeticShortcut()
            goto L4a
        L46:
            char r13 = r12.getNumericShortcut()
        L4a:
            if (r3 == 0) goto L51
            int r14 = r12.getAlphabeticModifiers()
            goto L55
        L51:
            int r14 = r12.getNumericModifiers()
        L55:
            r15 = 69647(0x1100f, float:9.7596E-41)
            r7 = r4 & r15
            r14 = r14 & r15
            if (r7 != r14) goto L5f
            r7 = 1
            goto L60
        L5f:
            r7 = 0
        L60:
            if (r7 == 0) goto L86
            if (r13 == 0) goto L86
            char[] r7 = r5.meta
            char r14 = r7[r10]
            if (r13 == r14) goto L7a
            r14 = 2
            char r7 = r7[r14]
            if (r13 == r7) goto L7a
            if (r3 == 0) goto L86
            r7 = 8
            if (r13 != r7) goto L86
            r7 = 67
            if (r1 != r7) goto L88
            goto L7c
        L7a:
            r7 = 67
        L7c:
            boolean r13 = r12.isEnabled()
            if (r13 == 0) goto L88
            r0.add(r12)
            goto L88
        L86:
            r7 = 67
        L88:
            int r11 = r11 + 1
            goto L28
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.c(java.util.ArrayList, int, android.view.KeyEvent):void");
    }

    public void changeMenuMode() {
        a aVar = this.f989e;
        if (aVar != null) {
            aVar.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f1006v;
        if (gVar != null) {
            collapseItemActionView(gVar);
        }
        this.f990f.clear();
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.f998n = null;
        this.f997m = null;
        this.f999o = null;
        onItemsChanged(false);
    }

    public final void close(boolean z10) {
        if (this.f1003s) {
            return;
        }
        this.f1003s = true;
        CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
        Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                iVar.onCloseMenu(this, z10);
            }
        }
        this.f1003s = false;
    }

    public boolean collapseItemActionView(g gVar) {
        CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
        boolean zCollapseItemActionView = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f1006v == gVar) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<i> next = it.next();
                i iVar = next.get();
                if (iVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    zCollapseItemActionView = iVar.collapseItemActionView(this, gVar);
                    if (zCollapseItemActionView) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (zCollapseItemActionView) {
                this.f1006v = null;
            }
        }
        return zCollapseItemActionView;
    }

    public final void d(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        if (view != null) {
            this.f999o = view;
            this.f997m = null;
            this.f998n = null;
        } else {
            if (i10 > 0) {
                this.f997m = this.f986b.getText(i10);
            } else if (charSequence != null) {
                this.f997m = charSequence;
            }
            if (i11 > 0) {
                this.f998n = m0.a.getDrawable(getContext(), i11);
            } else if (drawable != null) {
                this.f998n = drawable;
            }
            this.f999o = null;
        }
        onItemsChanged(false);
    }

    public boolean expandItemActionView(g gVar) {
        CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
        boolean zExpandItemActionView = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                zExpandItemActionView = iVar.expandItemActionView(this, gVar);
                if (zExpandItemActionView) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (zExpandItemActionView) {
            this.f1006v = gVar;
        }
        return zExpandItemActionView;
    }

    public int findGroupIndex(int i10) {
        return findGroupIndex(i10, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f990f.get(i11);
            if (gVar.getItemId() == i10) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f990f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public void flagActionItems() {
        ArrayList<g> visibleItems = getVisibleItems();
        if (this.f995k) {
            CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
            Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
            boolean zFlagActionItems = false;
            while (it.hasNext()) {
                WeakReference<i> next = it.next();
                i iVar = next.get();
                if (iVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    zFlagActionItems |= iVar.flagActionItems();
                }
            }
            ArrayList<g> arrayList = this.f993i;
            ArrayList<g> arrayList2 = this.f994j;
            if (zFlagActionItems) {
                arrayList.clear();
                arrayList2.clear();
                int size = visibleItems.size();
                for (int i10 = 0; i10 < size; i10++) {
                    g gVar = visibleItems.get(i10);
                    if (gVar.isActionButton()) {
                        arrayList.add(gVar);
                    } else {
                        arrayList2.add(gVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(getVisibleItems());
            }
            this.f995k = false;
        }
    }

    public ArrayList<g> getActionItems() {
        flagActionItems();
        return this.f993i;
    }

    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return this.f985a;
    }

    public g getExpandedItem() {
        return this.f1006v;
    }

    public Drawable getHeaderIcon() {
        return this.f998n;
    }

    public CharSequence getHeaderTitle() {
        return this.f997m;
    }

    public View getHeaderView() {
        return this.f999o;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f990f.get(i10);
    }

    public ArrayList<g> getNonActionItems() {
        flagActionItems();
        return this.f994j;
    }

    public ArrayList<g> getVisibleItems() {
        boolean z10 = this.f992h;
        ArrayList<g> arrayList = this.f991g;
        if (!z10) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList<g> arrayList2 = this.f990f;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = arrayList2.get(i10);
            if (gVar.isVisible()) {
                arrayList.add(gVar);
            }
        }
        this.f992h = false;
        this.f995k = true;
        return arrayList;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1008x) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f990f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.f1007w;
    }

    public boolean isQwertyMode() {
        return this.f987c;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return b(i10, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.f988d;
    }

    public void onItemsChanged(boolean z10) {
        if (this.f1000p) {
            this.f1001q = true;
            if (z10) {
                this.f1002r = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f992h = true;
            this.f995k = true;
        }
        CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                iVar.updateMenuView(z10);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return performItemAction(findItem(i10), i11);
    }

    public boolean performItemAction(MenuItem menuItem, int i10) {
        return performItemAction(menuItem, null, i10);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        g gVarB = b(i10, keyEvent);
        boolean zPerformItemAction = gVarB != null ? performItemAction(gVarB, i11) : false;
        if ((i11 & 2) != 0) {
            close(true);
        }
        return zPerformItemAction;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int iFindGroupIndex = findGroupIndex(i10);
        if (iFindGroupIndex >= 0) {
            ArrayList<g> arrayList = this.f990f;
            int size = arrayList.size() - iFindGroupIndex;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || arrayList.get(iFindGroupIndex).getGroupId() != i10) {
                    break;
                }
                if (iFindGroupIndex >= 0 && iFindGroupIndex < arrayList.size()) {
                    arrayList.remove(iFindGroupIndex);
                }
                i11 = i12;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        int iFindItemIndex = findItemIndex(i10);
        if (iFindItemIndex >= 0) {
            ArrayList<g> arrayList = this.f990f;
            if (iFindItemIndex >= arrayList.size()) {
                return;
            }
            arrayList.remove(iFindItemIndex);
            onItemsChanged(true);
        }
    }

    public void removeMenuPresenter(i iVar) {
        CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
        Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar2 = next.get();
            if (iVar2 == null || iVar2 == iVar) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void restorePresenterStates(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<i> next = it.next();
                i iVar = next.get();
                if (iVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    int id2 = iVar.getId();
                    if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                        iVar.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        Parcelable parcelableOnSaveInstanceState;
        CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                int id2 = iVar.getId();
                if (id2 > 0 && (parcelableOnSaveInstanceState = iVar.onSaveInstanceState()) != null) {
                    sparseArray.put(id2, parcelableOnSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public void setCallback(a aVar) {
        this.f989e = aVar;
    }

    public e setDefaultShowAsAction(int i10) {
        this.f996l = i10;
        return this;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        ArrayList<g> arrayList = this.f990f;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.setExclusiveCheckable(z11);
                gVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f1007w = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        ArrayList<g> arrayList = this.f990f;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        ArrayList<g> arrayList = this.f990f;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            if (gVar.getGroupId() == i10) {
                int i12 = gVar.f1035x;
                int i13 = (i12 & (-9)) | (z10 ? 0 : 8);
                gVar.f1035x = i13;
                if (i12 != i13) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            onItemsChanged(true);
        }
    }

    public e setHeaderIconInt(Drawable drawable) {
        d(0, null, 0, drawable, null);
        return this;
    }

    public e setHeaderTitleInt(CharSequence charSequence) {
        d(0, charSequence, 0, null, null);
        return this;
    }

    public e setHeaderViewInt(View view) {
        d(0, null, 0, null, view);
        return this;
    }

    public void setOverrideVisibleItems(boolean z10) {
        this.f1008x = z10;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f987c = z10;
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f990f.size();
    }

    public void startDispatchingItemsChanged() {
        this.f1000p = false;
        if (this.f1001q) {
            this.f1001q = false;
            onItemsChanged(this.f1002r);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (this.f1000p) {
            return;
        }
        this.f1000p = true;
        this.f1001q = false;
        this.f1002r = false;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return addInternal(0, 0, 0, this.f986b.getString(i10));
    }

    public void addMenuPresenter(i iVar, Context context) {
        this.f1005u.add(new WeakReference<>(iVar));
        iVar.initForMenu(context, this);
        this.f995k = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f986b.getString(i10));
    }

    public int findGroupIndex(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f990f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, i iVar, int i10) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zInvoke = gVar.invoke();
        x0.b supportActionProvider = gVar.getSupportActionProvider();
        boolean z10 = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (gVar.hasCollapsibleActionView()) {
            zInvoke |= gVar.expandActionView();
            if (zInvoke) {
                close(true);
            }
        } else if (gVar.hasSubMenu() || z10) {
            if ((i10 & 4) == 0) {
                close(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.setSubMenu(new l(getContext(), this, gVar));
            }
            l lVar = (l) gVar.getSubMenu();
            if (z10) {
                supportActionProvider.onPrepareSubMenu(lVar);
            }
            CopyOnWriteArrayList<WeakReference<i>> copyOnWriteArrayList = this.f1005u;
            if (!copyOnWriteArrayList.isEmpty()) {
                zOnSubMenuSelected = iVar != null ? iVar.onSubMenuSelected(lVar) : false;
                Iterator<WeakReference<i>> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference<i> next = it.next();
                    i iVar2 = next.get();
                    if (iVar2 == null) {
                        copyOnWriteArrayList.remove(next);
                    } else if (!zOnSubMenuSelected) {
                        zOnSubMenuSelected = iVar2.onSubMenuSelected(lVar);
                    }
                }
            }
            zInvoke |= zOnSubMenuSelected;
            if (!zInvoke) {
                close(true);
            }
        } else if ((i10 & 1) == 0) {
            close(true);
        }
        return zInvoke;
    }

    public e setHeaderIconInt(int i10) {
        d(0, null, i10, null, null);
        return this;
    }

    public e setHeaderTitleInt(int i10) {
        d(i10, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return addInternal(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        g gVar = (g) addInternal(i10, i11, i12, charSequence);
        l lVar = new l(this.f985a, this, gVar);
        gVar.setSubMenu(lVar);
        return lVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return addInternal(i10, i11, i12, this.f986b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f986b.getString(i13));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public e getRootMenu() {
        return this;
    }
}
