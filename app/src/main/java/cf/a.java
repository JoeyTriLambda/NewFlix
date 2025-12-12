package cf;

import io.reactivex.internal.util.NotificationLite;
import ne.q;
import se.o;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes2.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f5271a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f5272b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f5273c;

    /* renamed from: d, reason: collision with root package name */
    public int f5274d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: cf.a$a, reason: collision with other inner class name */
    public interface InterfaceC0063a<T> extends o<T> {
    }

    public a(int i10) {
        this.f5271a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f5272b = objArr;
        this.f5273c = objArr;
    }

    public <U> boolean accept(q<? super U> qVar) {
        int i10;
        Object[] objArr;
        Object[] objArr2 = this.f5272b;
        while (true) {
            int i11 = 0;
            if (objArr2 == null) {
                return false;
            }
            while (true) {
                i10 = this.f5271a;
                if (i11 >= i10 || (objArr = objArr2[i11]) == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr, qVar)) {
                    return true;
                }
                i11++;
            }
            objArr2 = objArr2[i10];
        }
    }

    public void add(T t10) {
        int i10 = this.f5274d;
        int i11 = this.f5271a;
        if (i10 == i11) {
            Object[] objArr = new Object[i11 + 1];
            this.f5273c[i11] = objArr;
            this.f5273c = objArr;
            i10 = 0;
        }
        this.f5273c[i10] = t10;
        this.f5274d = i10 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        r0 = r0[r2];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void forEachWhile(cf.a.InterfaceC0063a<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f5272b
        L2:
            if (r0 == 0) goto L20
            r1 = 0
        L5:
            int r2 = r4.f5271a
            if (r1 >= r2) goto L1b
            r3 = r0[r1]
            if (r3 != 0) goto Le
            goto L1b
        Le:
            r2 = r5
            hf.a r2 = (hf.a) r2
            boolean r2 = r2.test(r3)
            if (r2 == 0) goto L18
            return
        L18:
            int r1 = r1 + 1
            goto L5
        L1b:
            r0 = r0[r2]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L2
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.a.forEachWhile(cf.a$a):void");
    }

    public void setFirst(T t10) {
        this.f5272b[0] = t10;
    }
}
