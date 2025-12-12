package w2;

import java.util.List;

/* compiled from: InputMerger.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f20877a = g.tagWithPrefix("InputMerger");

    public static e fromClassName(String str) {
        try {
            return (e) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e10) {
            g.get().error(f20877a, "Trouble instantiating + " + str, e10);
            return null;
        }
    }

    public abstract androidx.work.b merge(List<androidx.work.b> list);
}
