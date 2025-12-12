package v1;

import androidx.lifecycle.e0;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {
    public static <T extends l & e0> a getInstance(T t10) {
        return new b(t10, t10.getViewModelStore());
    }

    @Deprecated
    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void markForRedelivery();
}
