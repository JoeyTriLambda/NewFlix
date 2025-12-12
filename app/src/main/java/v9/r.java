package v9;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class r implements u<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Constructor f20640a;

    public r(Constructor constructor) {
        this.f20640a = constructor;
    }

    @Override // v9.u
    public Object construct() {
        Constructor constructor = this.f20640a;
        try {
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e10) {
            throw x9.a.createExceptionForUnexpectedIllegalAccess(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e12.getTargetException());
        }
    }
}
