package x0;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f21299a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f21300b;

    /* renamed from: c, reason: collision with root package name */
    public final View f21301c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21302d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f21303e;

    public r(View view) {
        this.f21301c = view;
    }

    public final boolean a(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent viewParentB;
        int i15;
        int i16;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (viewParentB = b(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f21301c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i15 = iArr[0];
            i16 = iArr[1];
        } else {
            i15 = 0;
            i16 = 0;
        }
        if (iArr2 == null) {
            if (this.f21303e == null) {
                this.f21303e = new int[2];
            }
            int[] iArr4 = this.f21303e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        o0.onNestedScroll(viewParentB, this.f21301c, i10, i11, i12, i13, i14, iArr3);
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i15;
            iArr[1] = iArr[1] - i16;
        }
        return true;
    }

    public final ViewParent b(int i10) {
        if (i10 == 0) {
            return this.f21299a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f21300b;
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        ViewParent viewParentB;
        if (!isNestedScrollingEnabled() || (viewParentB = b(0)) == null) {
            return false;
        }
        return o0.onNestedFling(viewParentB, this.f21301c, f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        ViewParent viewParentB;
        if (!isNestedScrollingEnabled() || (viewParentB = b(0)) == null) {
            return false;
        }
        return o0.onNestedPreFling(viewParentB, this.f21301c, f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i10, i11, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return a(i10, i11, i12, i13, iArr, 0, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f21302d;
    }

    public void setNestedScrollingEnabled(boolean z10) {
        if (this.f21302d) {
            j0.stopNestedScroll(this.f21301c);
        }
        this.f21302d = z10;
    }

    public boolean startNestedScroll(int i10) {
        return startNestedScroll(i10, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent viewParentB;
        int i13;
        int i14;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (viewParentB = b(i12)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f21301c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i13 = iArr2[0];
            i14 = iArr2[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr == null) {
            if (this.f21303e == null) {
                this.f21303e = new int[2];
            }
            iArr3 = this.f21303e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        o0.onNestedPreScroll(viewParentB, this.f21301c, i10, i11, iArr3, i12);
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i13;
            iArr2[1] = iArr2[1] - i14;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public void dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        a(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean hasNestedScrollingParent(int i10) {
        return b(i10) != null;
    }

    public boolean startNestedScroll(int i10, int i11) {
        if (hasNestedScrollingParent(i11)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.f21301c;
        View view2 = view;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (o0.onStartNestedScroll(parent, view2, view, i10, i11)) {
                if (i11 == 0) {
                    this.f21299a = parent;
                } else if (i11 == 1) {
                    this.f21300b = parent;
                }
                o0.onNestedScrollAccepted(parent, view2, view, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i10) {
        ViewParent viewParentB = b(i10);
        if (viewParentB != null) {
            o0.onStopNestedScroll(viewParentB, this.f21301c, i10);
            if (i10 == 0) {
                this.f21299a = null;
            } else {
                if (i10 != 1) {
                    return;
                }
                this.f21300b = null;
            }
        }
    }
}
