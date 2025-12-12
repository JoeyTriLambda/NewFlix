package androidx.recyclerview.widget;

import androidx.recyclerview.widget.n;
import java.util.ArrayList;

/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public final class a implements n.a {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0039a f4105d;

    /* renamed from: a, reason: collision with root package name */
    public final w0.f f4102a = new w0.f(30);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f4103b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f4104c = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public int f4107f = 0;

    /* renamed from: e, reason: collision with root package name */
    public final n f4106e = new n(this);

    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0039a {
    }

    /* compiled from: AdapterHelper.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f4108a;

        /* renamed from: b, reason: collision with root package name */
        public int f4109b;

        /* renamed from: c, reason: collision with root package name */
        public Object f4110c;

        /* renamed from: d, reason: collision with root package name */
        public int f4111d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f4108a = i10;
            this.f4109b = i11;
            this.f4111d = i12;
            this.f4110c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f4108a;
            if (i10 != bVar.f4108a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f4111d - this.f4109b) == 1 && this.f4111d == bVar.f4109b && this.f4109b == bVar.f4111d) {
                return true;
            }
            if (this.f4111d != bVar.f4111d || this.f4109b != bVar.f4109b) {
                return false;
            }
            Object obj2 = this.f4110c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f4110c)) {
                    return false;
                }
            } else if (bVar.f4110c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4108a * 31) + this.f4109b) * 31) + this.f4111d;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append("[");
            int i10 = this.f4108a;
            sb2.append(i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb2.append(",s:");
            sb2.append(this.f4109b);
            sb2.append("c:");
            sb2.append(this.f4111d);
            sb2.append(",p:");
            sb2.append(this.f4110c);
            sb2.append("]");
            return sb2.toString();
        }
    }

    public a(r rVar) {
        this.f4105d = rVar;
    }

    public final boolean a(int i10) {
        ArrayList<b> arrayList = this.f4104c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = arrayList.get(i11);
            int i12 = bVar.f4108a;
            if (i12 == 8) {
                if (f(bVar.f4111d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f4109b;
                int i14 = bVar.f4111d + i13;
                while (i13 < i14) {
                    if (f(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public int applyPendingUpdatesToPosition(int i10) {
        ArrayList<b> arrayList = this.f4103b;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = arrayList.get(i11);
            int i12 = bVar.f4108a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f4109b;
                    if (i13 <= i10) {
                        int i14 = bVar.f4111d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f4109b;
                    if (i15 == i10) {
                        i10 = bVar.f4111d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f4111d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f4109b <= i10) {
                i10 += bVar.f4111d;
            }
        }
        return i10;
    }

    public final void b() {
        ArrayList<b> arrayList = this.f4104c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((r) this.f4105d).onDispatchSecondPass(arrayList.get(i10));
        }
        j(arrayList);
        this.f4107f = 0;
    }

    public final void c() {
        b();
        ArrayList<b> arrayList = this.f4103b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = arrayList.get(i10);
            int i11 = bVar.f4108a;
            InterfaceC0039a interfaceC0039a = this.f4105d;
            if (i11 == 1) {
                r rVar = (r) interfaceC0039a;
                rVar.onDispatchSecondPass(bVar);
                rVar.offsetPositionsForAdd(bVar.f4109b, bVar.f4111d);
            } else if (i11 == 2) {
                r rVar2 = (r) interfaceC0039a;
                rVar2.onDispatchSecondPass(bVar);
                rVar2.offsetPositionsForRemovingInvisible(bVar.f4109b, bVar.f4111d);
            } else if (i11 == 4) {
                r rVar3 = (r) interfaceC0039a;
                rVar3.onDispatchSecondPass(bVar);
                rVar3.markViewHoldersUpdated(bVar.f4109b, bVar.f4111d, bVar.f4110c);
            } else if (i11 == 8) {
                r rVar4 = (r) interfaceC0039a;
                rVar4.onDispatchSecondPass(bVar);
                rVar4.offsetPositionsForMove(bVar.f4109b, bVar.f4111d);
            }
        }
        j(arrayList);
        this.f4107f = 0;
    }

    public final void d(b bVar) {
        int i10;
        int i11 = bVar.f4108a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iK = k(bVar.f4109b, i11);
        int i12 = bVar.f4109b;
        int i13 = bVar.f4108a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f4111d; i15++) {
            int iK2 = k((i10 * i15) + bVar.f4109b, bVar.f4108a);
            int i16 = bVar.f4108a;
            if (i16 == 2 ? iK2 == iK : i16 == 4 && iK2 == iK + 1) {
                i14++;
            } else {
                b bVarObtainUpdateOp = obtainUpdateOp(i16, iK, i14, bVar.f4110c);
                e(bVarObtainUpdateOp, i12);
                recycleUpdateOp(bVarObtainUpdateOp);
                if (bVar.f4108a == 4) {
                    i12 += i14;
                }
                iK = iK2;
                i14 = 1;
            }
        }
        Object obj = bVar.f4110c;
        recycleUpdateOp(bVar);
        if (i14 > 0) {
            b bVarObtainUpdateOp2 = obtainUpdateOp(bVar.f4108a, iK, i14, obj);
            e(bVarObtainUpdateOp2, i12);
            recycleUpdateOp(bVarObtainUpdateOp2);
        }
    }

    public final void e(b bVar, int i10) {
        InterfaceC0039a interfaceC0039a = this.f4105d;
        ((r) interfaceC0039a).onDispatchFirstPass(bVar);
        int i11 = bVar.f4108a;
        if (i11 == 2) {
            ((r) interfaceC0039a).offsetPositionsForRemovingInvisible(i10, bVar.f4111d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            ((r) interfaceC0039a).markViewHoldersUpdated(i10, bVar.f4111d, bVar.f4110c);
        }
    }

    public final int f(int i10, int i11) {
        ArrayList<b> arrayList = this.f4104c;
        int size = arrayList.size();
        while (i11 < size) {
            b bVar = arrayList.get(i11);
            int i12 = bVar.f4108a;
            if (i12 == 8) {
                int i13 = bVar.f4109b;
                if (i13 == i10) {
                    i10 = bVar.f4111d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f4111d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f4109b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f4111d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f4111d;
                }
            }
            i11++;
        }
        return i10;
    }

    public final boolean g() {
        return this.f4103b.size() > 0;
    }

    public final void h(b bVar) {
        this.f4104c.add(bVar);
        int i10 = bVar.f4108a;
        InterfaceC0039a interfaceC0039a = this.f4105d;
        if (i10 == 1) {
            ((r) interfaceC0039a).offsetPositionsForAdd(bVar.f4109b, bVar.f4111d);
            return;
        }
        if (i10 == 2) {
            ((r) interfaceC0039a).offsetPositionsForRemovingLaidOutOrNewView(bVar.f4109b, bVar.f4111d);
        } else if (i10 == 4) {
            ((r) interfaceC0039a).markViewHoldersUpdated(bVar.f4109b, bVar.f4111d, bVar.f4110c);
        } else if (i10 == 8) {
            ((r) interfaceC0039a).offsetPositionsForMove(bVar.f4109b, bVar.f4111d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.i():void");
    }

    public final void j(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            recycleUpdateOp((b) arrayList.get(i10));
        }
        arrayList.clear();
    }

    public final int k(int i10, int i11) {
        int i12;
        int i13;
        ArrayList<b> arrayList = this.f4104c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            b bVar = arrayList.get(size);
            int i14 = bVar.f4108a;
            if (i14 == 8) {
                int i15 = bVar.f4109b;
                int i16 = bVar.f4111d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f4109b = i15 + 1;
                            bVar.f4111d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f4109b = i15 - 1;
                            bVar.f4111d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f4111d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f4111d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f4109b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f4109b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f4109b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f4111d;
                    } else if (i14 == 2) {
                        i10 += bVar.f4111d;
                    }
                } else if (i11 == 1) {
                    bVar.f4109b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f4109b = i17 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            b bVar2 = arrayList.get(size2);
            if (bVar2.f4108a == 8) {
                int i18 = bVar2.f4111d;
                if (i18 == bVar2.f4109b || i18 < 0) {
                    arrayList.remove(size2);
                    recycleUpdateOp(bVar2);
                }
            } else if (bVar2.f4111d <= 0) {
                arrayList.remove(size2);
                recycleUpdateOp(bVar2);
            }
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b obtainUpdateOp(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f4102a.acquire();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f4108a = i10;
        bVar.f4109b = i11;
        bVar.f4111d = i12;
        bVar.f4110c = obj;
        return bVar;
    }

    public void recycleUpdateOp(b bVar) {
        bVar.f4110c = null;
        this.f4102a.release(bVar);
    }
}
