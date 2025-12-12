package j4;

import android.util.Property;

/* compiled from: IntProperty.java */
/* loaded from: classes.dex */
public abstract class c<T> extends Property<T, Integer> {
    public c(String str) {
        super(Integer.class, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Integer num) {
        set2((c<T>) obj, num);
    }

    public abstract void setValue(T t10, int i10);

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public final void set2(T t10, Integer num) {
        setValue(t10, num.intValue());
    }
}
