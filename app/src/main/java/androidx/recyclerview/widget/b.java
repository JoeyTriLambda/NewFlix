package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0040b f4112a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4113b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4114c = new ArrayList();

    /* compiled from: ChildHelper.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f4115a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f4116b;

        public final void a(int i10) {
            if (i10 < 64) {
                this.f4115a &= ~(1 << i10);
                return;
            }
            a aVar = this.f4116b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        public final int b(int i10) {
            a aVar = this.f4116b;
            if (aVar == null) {
                return i10 >= 64 ? Long.bitCount(this.f4115a) : Long.bitCount(this.f4115a & ((1 << i10) - 1));
            }
            if (i10 < 64) {
                return Long.bitCount(this.f4115a & ((1 << i10) - 1));
            }
            return Long.bitCount(this.f4115a) + aVar.b(i10 - 64);
        }

        public final void c() {
            if (this.f4116b == null) {
                this.f4116b = new a();
            }
        }

        public final boolean d(int i10) {
            if (i10 < 64) {
                return (this.f4115a & (1 << i10)) != 0;
            }
            c();
            return this.f4116b.d(i10 - 64);
        }

        public final void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f4116b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f4115a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f4115a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f4116b != null) {
                c();
                this.f4116b.e(0, z11);
            }
        }

        public final boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f4116b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f4115a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f4115a = j12;
            long j13 = j10 - 1;
            this.f4115a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f4116b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f4116b.f(0);
            }
            return z10;
        }

        public final void g() {
            this.f4115a = 0L;
            a aVar = this.f4116b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public final void h(int i10) {
            if (i10 < 64) {
                this.f4115a |= 1 << i10;
            } else {
                c();
                this.f4116b.h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f4116b == null) {
                return Long.toBinaryString(this.f4115a);
            }
            return this.f4116b.toString() + "xx" + Long.toBinaryString(this.f4115a);
        }
    }

    /* compiled from: ChildHelper.java */
    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0040b {
    }

    public b(q qVar) {
        this.f4112a = qVar;
    }

    public final void a(View view, boolean z10, int i10) {
        InterfaceC0040b interfaceC0040b = this.f4112a;
        int childCount = i10 < 0 ? ((q) interfaceC0040b).getChildCount() : e(i10);
        this.f4113b.e(childCount, z10);
        if (z10) {
            this.f4114c.add(view);
            ((q) interfaceC0040b).onEnteredHiddenState(view);
        }
        ((q) interfaceC0040b).addView(view, childCount);
    }

    public final void b(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        InterfaceC0040b interfaceC0040b = this.f4112a;
        int childCount = i10 < 0 ? ((q) interfaceC0040b).getChildCount() : e(i10);
        this.f4113b.e(childCount, z10);
        if (z10) {
            this.f4114c.add(view);
            ((q) interfaceC0040b).onEnteredHiddenState(view);
        }
        ((q) interfaceC0040b).attachViewToParent(view, childCount, layoutParams);
    }

    public final View c(int i10) {
        return ((q) this.f4112a).getChildAt(e(i10));
    }

    public final int d() {
        return ((q) this.f4112a).getChildCount() - this.f4114c.size();
    }

    public final int e(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int childCount = ((q) this.f4112a).getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            a aVar = this.f4113b;
            int iB = i10 - (i11 - aVar.b(i11));
            if (iB == 0) {
                while (aVar.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iB;
        }
        return -1;
    }

    public final View f(int i10) {
        return ((q) this.f4112a).getChildAt(i10);
    }

    public final int g() {
        return ((q) this.f4112a).getChildCount();
    }

    public final int h(View view) {
        int iIndexOfChild = ((q) this.f4112a).indexOfChild(view);
        if (iIndexOfChild == -1) {
            return -1;
        }
        a aVar = this.f4113b;
        if (aVar.d(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - aVar.b(iIndexOfChild);
    }

    public final boolean i(View view) {
        return this.f4114c.contains(view);
    }

    public final void j(View view) {
        if (this.f4114c.remove(view)) {
            ((q) this.f4112a).onLeftHiddenState(view);
        }
    }

    public String toString() {
        return this.f4113b.toString() + ", hidden list:" + this.f4114c.size();
    }
}
