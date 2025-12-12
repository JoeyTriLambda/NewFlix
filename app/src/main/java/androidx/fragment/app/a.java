package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.g0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.y;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class a extends g0 implements y.l {

    /* renamed from: p, reason: collision with root package name */
    public final y f2737p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2738q;

    /* renamed from: r, reason: collision with root package name */
    public int f2739r;

    public a(y yVar) {
        yVar.getFragmentFactory();
        if (yVar.getHost() != null) {
            yVar.getHost().f2928m.getClassLoader();
        }
        this.f2739r = -1;
        this.f2737p = yVar;
    }

    @Override // androidx.fragment.app.g0
    public final void b(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.Y;
        if (str2 != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.J;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb2 = new StringBuilder("Can't change tag of fragment ");
                sb2.append(fragment);
                sb2.append(": was ");
                throw new IllegalStateException(ac.c.p(sb2, fragment.J, " now ", str));
            }
            fragment.J = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.H;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.H + " now " + i10);
            }
            fragment.H = i10;
            fragment.I = i10;
        }
        a(new g0.a(i11, fragment));
        fragment.D = this.f2737p;
    }

    public final void c(int i10) {
        if (this.f2815g) {
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            ArrayList<g0.a> arrayList = this.f2809a;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                g0.a aVar = arrayList.get(i11);
                Fragment fragment = aVar.f2825b;
                if (fragment != null) {
                    fragment.C += i10;
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2825b + " to " + aVar.f2825b.C);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.g0
    public int commit() {
        return d(false);
    }

    @Override // androidx.fragment.app.g0
    public int commitAllowingStateLoss() {
        return d(true);
    }

    @Override // androidx.fragment.app.g0
    public void commitNow() {
        disallowAddToBackStack();
        this.f2737p.x(this, false);
    }

    @Override // androidx.fragment.app.g0
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f2737p.x(this, true);
    }

    public final int d(boolean z10) {
        if (this.f2738q) {
            throw new IllegalStateException("commit already called");
        }
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new m0());
            dump("  ", printWriter);
            printWriter.close();
        }
        this.f2738q = true;
        boolean z11 = this.f2815g;
        y yVar = this.f2737p;
        if (z11) {
            this.f2739r = yVar.f2946i.getAndIncrement();
        } else {
            this.f2739r = -1;
        }
        yVar.u(this, z10);
        return this.f2739r;
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    @Override // androidx.fragment.app.y.l
    public boolean generateOps(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2815g) {
            return true;
        }
        y yVar = this.f2737p;
        if (yVar.f2941d == null) {
            yVar.f2941d = new ArrayList<>();
        }
        yVar.f2941d.add(this);
        return true;
    }

    public String getName() {
        return this.f2816h;
    }

    @Override // androidx.fragment.app.g0
    public g0 remove(Fragment fragment) {
        y yVar = fragment.D;
        if (yVar == null || yVar == this.f2737p) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sbQ = ac.c.q(128, "BackStackEntry{");
        sbQ.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2739r >= 0) {
            sbQ.append(" #");
            sbQ.append(this.f2739r);
        }
        if (this.f2816h != null) {
            sbQ.append(StringUtils.SPACE);
            sbQ.append(this.f2816h);
        }
        sbQ.append("}");
        return sbQ.toString();
    }

    public void dump(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2816h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2739r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2738q);
            if (this.f2814f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2814f));
            }
            if (this.f2810b != 0 || this.f2811c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2810b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2811c));
            }
            if (this.f2812d != 0 || this.f2813e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2812d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2813e));
            }
            if (this.f2817i != 0 || this.f2818j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2817i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2818j);
            }
            if (this.f2819k != 0 || this.f2820l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2819k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2820l);
            }
        }
        ArrayList<g0.a> arrayList = this.f2809a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            g0.a aVar = arrayList.get(i10);
            switch (aVar.f2824a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f2824a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(StringUtils.SPACE);
            printWriter.println(aVar.f2825b);
            if (z10) {
                if (aVar.f2827d != 0 || aVar.f2828e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2827d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2828e));
                }
                if (aVar.f2829f != 0 || aVar.f2830g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2829f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2830g));
                }
            }
        }
    }

    public void runOnCommitRunnables() {
    }
}
