package l8;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements h9.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15948a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15949b;

    public /* synthetic */ e(Object obj, int i10) {
        this.f15948a = i10;
        this.f15949b = obj;
    }

    @Override // h9.b
    public final Object get() throws ClassNotFoundException {
        int i10 = this.f15948a;
        Object obj = this.f15949b;
        switch (i10) {
            case 0:
                String str = (String) obj;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
                    return null;
                } catch (IllegalAccessException e10) {
                    throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e10);
                } catch (InstantiationException e11) {
                    throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e11);
                } catch (NoSuchMethodException e12) {
                    throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e12);
                } catch (InvocationTargetException e13) {
                    throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e13);
                }
            case 1:
                return (ComponentRegistrar) obj;
            default:
                Object obj2 = com.google.firebase.installations.a.f9802m;
                return new k9.a((g8.f) obj);
        }
    }
}
