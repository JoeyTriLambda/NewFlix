package g1;

import android.graphics.Rect;
import g1.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: FocusStrategy.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: FocusStrategy.java */
    public interface a<T> {
    }

    /* compiled from: FocusStrategy.java */
    /* renamed from: g1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0147b<T, V> {
    }

    /* compiled from: FocusStrategy.java */
    public static class c<T> implements Comparator<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Rect f12518b = new Rect();

        /* renamed from: m, reason: collision with root package name */
        public final Rect f12519m = new Rect();

        /* renamed from: n, reason: collision with root package name */
        public final boolean f12520n;

        /* renamed from: o, reason: collision with root package name */
        public final a<T> f12521o;

        public c(boolean z10, a<T> aVar) {
            this.f12520n = z10;
            this.f12521o = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T t10, T t11) {
            a<T> aVar = this.f12521o;
            Rect rect = this.f12518b;
            ((a.C0146a) aVar).obtainBounds(t10, rect);
            Rect rect2 = this.f12519m;
            ((a.C0146a) aVar).obtainBounds(t11, rect2);
            int i10 = rect.top;
            int i11 = rect2.top;
            if (i10 < i11) {
                return -1;
            }
            if (i10 > i11) {
                return 1;
            }
            int i12 = rect.left;
            int i13 = rect2.left;
            boolean z10 = this.f12520n;
            if (i12 < i13) {
                return z10 ? 1 : -1;
            }
            if (i12 > i13) {
                return z10 ? -1 : 1;
            }
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if (i14 < i15) {
                return -1;
            }
            if (i14 > i15) {
                return 1;
            }
            int i16 = rect.right;
            int i17 = rect2.right;
            if (i16 < i17) {
                return z10 ? 1 : -1;
            }
            if (i16 > i17) {
                return z10 ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = b(r9, r10, r11)
            boolean r1 = b(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L7d
            if (r0 != 0) goto Lf
            goto L7d
        Lf:
            r0 = 1
            java.lang.String r1 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r3 = 130(0x82, float:1.82E-43)
            r4 = 33
            r5 = 66
            r6 = 17
            if (r9 == r6) goto L3d
            if (r9 == r4) goto L36
            if (r9 == r5) goto L2f
            if (r9 != r3) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L45
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r1)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L45
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L45
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L45
        L43:
            r7 = 1
            goto L46
        L45:
            r7 = 0
        L46:
            if (r7 != 0) goto L49
            return r0
        L49:
            if (r9 == r6) goto L7c
            if (r9 != r5) goto L4e
            goto L7c
        L4e:
            int r11 = d(r9, r10, r11)
            if (r9 == r6) goto L6f
            if (r9 == r4) goto L6a
            if (r9 == r5) goto L65
            if (r9 != r3) goto L5f
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L73
        L5f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r1)
            throw r9
        L65:
            int r9 = r12.right
            int r10 = r10.right
            goto L73
        L6a:
            int r9 = r10.top
            int r10 = r12.top
            goto L73
        L6f:
            int r9 = r10.left
            int r10 = r12.left
        L73:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r0, r9)
            if (r11 >= r9) goto L7b
            r2 = 1
        L7b:
            return r2
        L7c:
            return r0
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.b.a(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean b(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static boolean c(int i10, Rect rect, Rect rect2) {
        if (i10 == 17) {
            int i11 = rect.right;
            int i12 = rect2.right;
            return (i11 > i12 || rect.left >= i12) && rect.left > rect2.left;
        }
        if (i10 == 33) {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            return (i13 > i14 || rect.top >= i14) && rect.top > rect2.top;
        }
        if (i10 == 66) {
            int i15 = rect.left;
            int i16 = rect2.left;
            return (i15 < i16 || rect.right <= i16) && rect.right < rect2.right;
        }
        if (i10 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        return (i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom;
    }

    public static int d(int i10, Rect rect, Rect rect2) {
        int i11;
        int i12;
        if (i10 == 17) {
            i11 = rect.left;
            i12 = rect2.right;
        } else if (i10 == 33) {
            i11 = rect.top;
            i12 = rect2.bottom;
        } else if (i10 == 66) {
            i11 = rect2.left;
            i12 = rect.right;
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i11 = rect2.top;
            i12 = rect.bottom;
        }
        return Math.max(0, i11 - i12);
    }

    public static int e(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <L, T> T findNextFocusInAbsoluteDirection(L r17, g1.b.InterfaceC0147b<L, T> r18, g1.b.a<T> r19, T r20, android.graphics.Rect r21, int r22) {
        /*
            r0 = r17
            r1 = r21
            r2 = r22
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>(r1)
            r4 = 17
            r5 = 0
            r6 = 1
            if (r2 == r4) goto L42
            r4 = 33
            if (r2 == r4) goto L39
            r4 = 66
            if (r2 == r4) goto L2f
            r4 = 130(0x82, float:1.82E-43)
            if (r2 != r4) goto L27
            int r4 = r21.height()
            int r4 = r4 + r6
            int r4 = -r4
            r3.offset(r5, r4)
            goto L4a
        L27:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r0.<init>(r1)
            throw r0
        L2f:
            int r4 = r21.width()
            int r4 = r4 + r6
            int r4 = -r4
            r3.offset(r4, r5)
            goto L4a
        L39:
            int r4 = r21.height()
            int r4 = r4 + r6
            r3.offset(r5, r4)
            goto L4a
        L42:
            int r4 = r21.width()
            int r4 = r4 + r6
            r3.offset(r4, r5)
        L4a:
            r4 = r18
            g1.a$b r4 = (g1.a.b) r4
            int r7 = r4.size(r0)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r9 = 0
            r10 = 0
        L59:
            if (r10 >= r7) goto Lb4
            java.lang.Object r11 = r4.get(r0, r10)
            r12 = r20
            if (r11 != r12) goto L64
            goto Lb1
        L64:
            r13 = r19
            g1.a$a r13 = (g1.a.C0146a) r13
            r13.obtainBounds(r11, r8)
            boolean r13 = c(r2, r1, r8)
            if (r13 != 0) goto L72
            goto Laa
        L72:
            boolean r13 = c(r2, r1, r3)
            if (r13 != 0) goto L79
            goto La8
        L79:
            boolean r13 = a(r2, r1, r8, r3)
            if (r13 == 0) goto L80
            goto La8
        L80:
            boolean r13 = a(r2, r1, r3, r8)
            if (r13 == 0) goto L87
            goto Laa
        L87:
            int r13 = d(r2, r1, r8)
            int r14 = e(r2, r1, r8)
            int r15 = r13 * 13
            int r15 = r15 * r13
            int r14 = r14 * r14
            int r14 = r14 + r15
            int r13 = d(r2, r1, r3)
            int r15 = e(r2, r1, r3)
            int r16 = r13 * 13
            int r16 = r16 * r13
            int r15 = r15 * r15
            int r15 = r15 + r16
            if (r14 >= r15) goto Laa
        La8:
            r13 = 1
            goto Lab
        Laa:
            r13 = 0
        Lab:
            if (r13 == 0) goto Lb1
            r3.set(r8)
            r9 = r11
        Lb1:
            int r10 = r10 + 1
            goto L59
        Lb4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.b.findNextFocusInAbsoluteDirection(java.lang.Object, g1.b$b, g1.b$a, java.lang.Object, android.graphics.Rect, int):java.lang.Object");
    }

    public static <L, T> T findNextFocusInRelativeDirection(L l10, InterfaceC0147b<L, T> interfaceC0147b, a<T> aVar, T t10, int i10, boolean z10, boolean z11) {
        a.b bVar = (a.b) interfaceC0147b;
        int size = bVar.size(l10);
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(bVar.get(l10, i11));
        }
        Collections.sort(arrayList, new c(z10, aVar));
        if (i10 == 1) {
            int size2 = arrayList.size();
            int iIndexOf = (t10 == null ? size2 : arrayList.indexOf(t10)) - 1;
            if (iIndexOf >= 0) {
                return (T) arrayList.get(iIndexOf);
            }
            if (!z11 || size2 <= 0) {
                return null;
            }
            return (T) arrayList.get(size2 - 1);
        }
        if (i10 != 2) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        int size3 = arrayList.size();
        int iLastIndexOf = (t10 != null ? arrayList.lastIndexOf(t10) : -1) + 1;
        if (iLastIndexOf < size3) {
            return (T) arrayList.get(iLastIndexOf);
        }
        if (!z11 || size3 <= 0) {
            return null;
        }
        return (T) arrayList.get(0);
    }
}
