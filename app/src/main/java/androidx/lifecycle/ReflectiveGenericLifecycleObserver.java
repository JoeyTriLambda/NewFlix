package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements j {

    /* renamed from: b, reason: collision with root package name */
    public final Object f3453b;

    /* renamed from: m, reason: collision with root package name */
    public final a.C0030a f3454m;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3453b = obj;
        this.f3454m = a.f3475c.b(obj.getClass());
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HashMap map = this.f3454m.f3478a;
        List list = (List) map.get(event);
        Object obj = this.f3453b;
        a.C0030a.a(list, lVar, event, obj);
        a.C0030a.a((List) map.get(Lifecycle.Event.ON_ANY), lVar, event, obj);
    }
}
