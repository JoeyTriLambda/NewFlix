package la;

import java.util.ArrayList;

/* compiled from: Animator.java */
/* loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<InterfaceC0190a> f16002b = null;

    /* compiled from: Animator.java */
    /* renamed from: la.a$a, reason: collision with other inner class name */
    public interface InterfaceC0190a {
        void onAnimationCancel(a aVar);

        void onAnimationEnd(a aVar);

        void onAnimationRepeat(a aVar);

        void onAnimationStart(a aVar);
    }

    public void addListener(InterfaceC0190a interfaceC0190a) {
        if (this.f16002b == null) {
            this.f16002b = new ArrayList<>();
        }
        this.f16002b.add(interfaceC0190a);
    }

    @Override // 
    public a clone() {
        try {
            a aVar = (a) super.clone();
            ArrayList<InterfaceC0190a> arrayList = this.f16002b;
            if (arrayList != null) {
                aVar.f16002b = new ArrayList<>();
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    aVar.f16002b.add(arrayList.get(i10));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public void cancel() {
    }
}
