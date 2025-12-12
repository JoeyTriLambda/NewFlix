package v1;

import ac.c;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
public final class b extends v1.a {

    /* renamed from: a, reason: collision with root package name */
    public final l f20425a;

    /* renamed from: b, reason: collision with root package name */
    public final C0294b f20426b;

    /* compiled from: LoaderManagerImpl.java */
    public static class a<D> extends r<D> {
        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(s<? super D> sVar) {
            super.removeObserver(sVar);
        }

        @Override // androidx.lifecycle.r, androidx.lifecycle.LiveData
        public void setValue(D d10) {
            super.setValue(d10);
        }

        public String toString() {
            StringBuilder sbQ = c.q(64, "LoaderInfo{");
            sbQ.append(Integer.toHexString(System.identityHashCode(this)));
            sbQ.append(" #0 : ");
            w0.b.buildShortClassTag(null, sbQ);
            sbQ.append("}}");
            return sbQ.toString();
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: v1.b$b, reason: collision with other inner class name */
    public static class C0294b extends z {

        /* renamed from: d, reason: collision with root package name */
        public static final a f20427d = new a();

        /* renamed from: c, reason: collision with root package name */
        public final b0.l<a> f20428c = new b0.l<>();

        /* compiled from: LoaderManagerImpl.java */
        /* renamed from: v1.b$b$a */
        public static class a implements a0.b {
            @Override // androidx.lifecycle.a0.b
            public final /* synthetic */ z create(Class cls, u1.a aVar) {
                return b0.b(this, cls, aVar);
            }

            @Override // androidx.lifecycle.a0.b
            public <T extends z> T create(Class<T> cls) {
                return new C0294b();
            }
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            b0.l<a> lVar = this.f20428c;
            if (lVar.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < lVar.size(); i10++) {
                    a aVarValueAt = lVar.valueAt(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(lVar.keyAt(i10));
                    printWriter.print(": ");
                    printWriter.println(aVarValueAt.toString());
                    aVarValueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        @Override // androidx.lifecycle.z
        public void onCleared() {
            super.onCleared();
            b0.l<a> lVar = this.f20428c;
            if (lVar.size() <= 0) {
                lVar.clear();
            } else {
                lVar.valueAt(0).getClass();
                throw null;
            }
        }
    }

    public b(l lVar, d0 d0Var) {
        this.f20425a = lVar;
        this.f20426b = (C0294b) new a0(d0Var, C0294b.f20427d).get(C0294b.class);
    }

    @Override // v1.a
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f20426b.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // v1.a
    public void markForRedelivery() {
        b0.l<a> lVar = this.f20426b.f20428c;
        int size = lVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            lVar.valueAt(i10).getClass();
        }
    }

    public String toString() {
        StringBuilder sbQ = c.q(128, "LoaderManager{");
        sbQ.append(Integer.toHexString(System.identityHashCode(this)));
        sbQ.append(" in ");
        w0.b.buildShortClassTag(this.f20425a, sbQ);
        sbQ.append("}}");
        return sbQ.toString();
    }
}
