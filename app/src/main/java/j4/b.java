package j4;

import android.util.Property;

/* compiled from: FloatProperty.java */
/* loaded from: classes.dex */
public abstract class b<T> extends Property<T, Float> {
    public b(String str) {
        super(Float.class, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f10) {
        set2((b<T>) obj, f10);
    }

    public abstract void setValue(T t10, float f10);

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public final void set2(T t10, Float f10) {
        setValue(t10, f10.floatValue());
    }
}
