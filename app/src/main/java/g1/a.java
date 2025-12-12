package g1;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b0.l;
import g1.b;
import java.util.ArrayList;
import java.util.List;
import x0.j0;
import y0.d;
import y0.e;
import y0.f;

/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a extends x0.a {

    /* renamed from: n, reason: collision with root package name */
    public static final Rect f12504n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final C0146a f12505o = new C0146a();

    /* renamed from: p, reason: collision with root package name */
    public static final b f12506p = new b();

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f12511h;

    /* renamed from: i, reason: collision with root package name */
    public final View f12512i;

    /* renamed from: j, reason: collision with root package name */
    public c f12513j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f12507d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f12508e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f12509f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public final int[] f12510g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f12514k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f12515l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f12516m = Integer.MIN_VALUE;

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: g1.a$a, reason: collision with other inner class name */
    public class C0146a implements b.a<d> {
        public void obtainBounds(d dVar, Rect rect) {
            dVar.getBoundsInParent(rect);
        }
    }

    /* compiled from: ExploreByTouchHelper.java */
    public class b implements b.InterfaceC0147b<l<d>, d> {
        public d get(l<d> lVar, int i10) {
            return lVar.valueAt(i10);
        }

        public int size(l<d> lVar) {
            return lVar.size();
        }
    }

    /* compiled from: ExploreByTouchHelper.java */
    public class c extends e {
        public c() {
        }

        @Override // y0.e
        public d createAccessibilityNodeInfo(int i10) {
            return d.obtain(a.this.c(i10));
        }

        @Override // y0.e
        public d findFocus(int i10) {
            a aVar = a.this;
            int i11 = i10 == 2 ? aVar.f12514k : aVar.f12515l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
        @Override // y0.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean performAction(int r8, int r9, android.os.Bundle r10) {
            /*
                r7 = this;
                g1.a r0 = g1.a.this
                android.view.View r1 = r0.f12512i
                r2 = -1
                if (r8 == r2) goto L64
                r2 = 1
                if (r9 == r2) goto L5f
                r3 = 2
                if (r9 == r3) goto L5a
                r3 = 64
                r4 = 65536(0x10000, float:9.1835E-41)
                r5 = 0
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r9 == r3) goto L2f
                r3 = 128(0x80, float:1.8E-43)
                if (r9 == r3) goto L1f
                boolean r8 = r0.onPerformActionForVirtualView(r8, r9, r10)
                goto L68
            L1f:
                int r9 = r0.f12514k
                if (r9 != r8) goto L2c
                r0.f12514k = r6
                r1.invalidate()
                r0.sendEventForVirtualView(r8, r4)
                goto L2d
            L2c:
                r2 = 0
            L2d:
                r8 = r2
                goto L68
            L2f:
                android.view.accessibility.AccessibilityManager r9 = r0.f12511h
                boolean r10 = r9.isEnabled()
                if (r10 == 0) goto L2c
                boolean r9 = r9.isTouchExplorationEnabled()
                if (r9 != 0) goto L3e
                goto L2c
            L3e:
                int r9 = r0.f12514k
                if (r9 == r8) goto L2c
                if (r9 == r6) goto L4e
                r0.f12514k = r6
                android.view.View r10 = r0.f12512i
                r10.invalidate()
                r0.sendEventForVirtualView(r9, r4)
            L4e:
                r0.f12514k = r8
                r1.invalidate()
                r9 = 32768(0x8000, float:4.5918E-41)
                r0.sendEventForVirtualView(r8, r9)
                goto L2d
            L5a:
                boolean r8 = r0.clearKeyboardFocusForVirtualView(r8)
                goto L68
            L5f:
                boolean r8 = r0.requestKeyboardFocusForVirtualView(r8)
                goto L68
            L64:
                boolean r8 = x0.j0.performAccessibilityAction(r1, r9, r10)
            L68:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g1.a.c.performAction(int, int, android.os.Bundle):boolean");
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f12512i = view;
        this.f12511h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (j0.getImportantForAccessibility(view) == 0) {
            j0.setImportantForAccessibility(view, 1);
        }
    }

    public final d a(int i10) {
        d dVarObtain = d.obtain();
        dVarObtain.setEnabled(true);
        dVarObtain.setFocusable(true);
        dVarObtain.setClassName("android.view.View");
        Rect rect = f12504n;
        dVarObtain.setBoundsInParent(rect);
        dVarObtain.setBoundsInScreen(rect);
        View view = this.f12512i;
        dVarObtain.setParent(view);
        onPopulateNodeForVirtualView(i10, dVarObtain);
        if (dVarObtain.getText() == null && dVarObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f12508e;
        dVarObtain.getBoundsInParent(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = dVarObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        dVarObtain.setPackageName(view.getContext().getPackageName());
        dVarObtain.setSource(view, i10);
        boolean z10 = false;
        if (this.f12514k == i10) {
            dVarObtain.setAccessibilityFocused(true);
            dVarObtain.addAction(128);
        } else {
            dVarObtain.setAccessibilityFocused(false);
            dVarObtain.addAction(64);
        }
        boolean z11 = this.f12515l == i10;
        if (z11) {
            dVarObtain.addAction(2);
        } else if (dVarObtain.isFocusable()) {
            dVarObtain.addAction(1);
        }
        dVarObtain.setFocused(z11);
        int[] iArr = this.f12510g;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f12507d;
        dVarObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            dVarObtain.getBoundsInParent(rect3);
            if (dVarObtain.f21818b != -1) {
                d dVarObtain2 = d.obtain();
                for (int i11 = dVarObtain.f21818b; i11 != -1; i11 = dVarObtain2.f21818b) {
                    dVarObtain2.setParent(view, -1);
                    dVarObtain2.setBoundsInParent(rect);
                    onPopulateNodeForVirtualView(i11, dVarObtain2);
                    dVarObtain2.getBoundsInParent(rect2);
                    rect3.offset(rect2.left, rect2.top);
                }
                dVarObtain2.recycle();
            }
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f12509f;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                dVarObtain.setBoundsInScreen(rect3);
                if (rect3 != null && !rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            z10 = true;
                        }
                    }
                }
                if (z10) {
                    dVarObtain.setVisibleToUser(true);
                }
            }
        }
        return dVarObtain;
    }

    public final boolean b(int i10, Rect rect) {
        d dVar;
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        l lVar = new l();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            lVar.put(((Integer) arrayList.get(i11)).intValue(), a(((Integer) arrayList.get(i11)).intValue()));
        }
        int i12 = this.f12515l;
        d dVar2 = i12 == Integer.MIN_VALUE ? null : (d) lVar.get(i12);
        C0146a c0146a = f12505o;
        b bVar = f12506p;
        View view = this.f12512i;
        if (i10 == 1 || i10 == 2) {
            dVar = (d) g1.b.findNextFocusInRelativeDirection(lVar, bVar, c0146a, dVar2, i10, j0.getLayoutDirection(view) == 1, false);
        } else {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i13 = this.f12515l;
            if (i13 != Integer.MIN_VALUE) {
                c(i13).getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                int width = view.getWidth();
                int height = view.getHeight();
                if (i10 == 17) {
                    rect2.set(width, 0, width, height);
                } else if (i10 == 33) {
                    rect2.set(0, height, width, height);
                } else if (i10 == 66) {
                    rect2.set(-1, 0, -1, height);
                } else {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect2.set(0, -1, width, -1);
                }
            }
            dVar = (d) g1.b.findNextFocusInAbsoluteDirection(lVar, bVar, c0146a, dVar2, rect2, i10);
        }
        return requestKeyboardFocusForVirtualView(dVar != null ? lVar.keyAt(lVar.indexOfValue(dVar)) : Integer.MIN_VALUE);
    }

    public final d c(int i10) {
        if (i10 != -1) {
            return a(i10);
        }
        View view = this.f12512i;
        d dVarObtain = d.obtain(view);
        j0.onInitializeAccessibilityNodeInfo(view, dVarObtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (dVarObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            dVarObtain.addChild(view, ((Integer) arrayList.get(i11)).intValue());
        }
        return dVarObtain;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i10) {
        if (this.f12515l != i10) {
            return false;
        }
        this.f12515l = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i10, false);
        sendEventForVirtualView(i10, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i10;
        AccessibilityManager accessibilityManager = this.f12511h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            int i11 = this.f12516m;
            if (i11 != virtualViewAt) {
                this.f12516m = virtualViewAt;
                sendEventForVirtualView(virtualViewAt, 128);
                sendEventForVirtualView(i11, 256);
            }
            return virtualViewAt != Integer.MIN_VALUE;
        }
        if (action != 10 || (i10 = this.f12516m) == Integer.MIN_VALUE) {
            return false;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f12516m = Integer.MIN_VALUE;
            sendEventForVirtualView(Integer.MIN_VALUE, 128);
            sendEventForVirtualView(i10, 256);
        }
        return true;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return b(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return b(1, null);
            }
            return false;
        }
        int i11 = 66;
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    if (keyCode == 19) {
                        i11 = 33;
                    } else if (keyCode == 21) {
                        i11 = 17;
                    } else if (keyCode != 22) {
                        i11 = 130;
                    }
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z10 = false;
                    while (i10 < repeatCount && b(i11, null)) {
                        i10++;
                        z10 = true;
                    }
                    return z10;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        int i12 = this.f12515l;
        if (i12 != Integer.MIN_VALUE) {
            onPerformActionForVirtualView(i12, 16, null);
        }
        return true;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f12514k;
    }

    @Override // x0.a
    public e getAccessibilityNodeProvider(View view) {
        if (this.f12513j == null) {
            this.f12513j = new c();
        }
        return this.f12513j;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.f12515l;
    }

    public abstract int getVirtualViewAt(float f10, float f11);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        int i11 = this.f12515l;
        if (i11 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i11);
        }
        if (z10) {
            b(i10, rect);
        }
    }

    @Override // x0.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // x0.a
    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        onPopulateNodeForHost(dVar);
    }

    public abstract boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle);

    public abstract void onPopulateNodeForHost(d dVar);

    public abstract void onPopulateNodeForVirtualView(int i10, d dVar);

    public abstract void onVirtualViewKeyboardFocusChanged(int i10, boolean z10);

    public final boolean requestKeyboardFocusForVirtualView(int i10) {
        int i11;
        View view = this.f12512i;
        if ((!view.isFocused() && !view.requestFocus()) || (i11 = this.f12515l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f12515l = i10;
        onVirtualViewKeyboardFocusChanged(i10, true);
        sendEventForVirtualView(i10, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i10, int i11) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i10 == Integer.MIN_VALUE || !this.f12511h.isEnabled() || (parent = (view = this.f12512i).getParent()) == null) {
            return false;
        }
        if (i10 != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i11);
            d dVarC = c(i10);
            accessibilityEventObtain.getText().add(dVarC.getText());
            accessibilityEventObtain.setContentDescription(dVarC.getContentDescription());
            accessibilityEventObtain.setScrollable(dVarC.isScrollable());
            accessibilityEventObtain.setPassword(dVarC.isPassword());
            accessibilityEventObtain.setEnabled(dVarC.isEnabled());
            accessibilityEventObtain.setChecked(dVarC.isChecked());
            onPopulateEventForVirtualView(i10, accessibilityEventObtain);
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(dVarC.getClassName());
            f.setSource(accessibilityEventObtain, view, i10);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i11);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        return parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
    }
}
