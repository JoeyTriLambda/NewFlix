package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import g8.f;
import i9.c;
import java.util.Arrays;
import java.util.List;
import l8.b;
import l8.l;
import n8.d;
import n8.g;
import o8.a;

/* loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9760a = 0;

    static {
        FirebaseSessionsDependencies.addDependency(SessionSubscriber.Name.CRASHLYTICS);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b<?>> getComponents() {
        return Arrays.asList(b.builder(g.class).name("fire-cls").add(l.required((Class<?>) f.class)).add(l.required((Class<?>) c.class)).add(l.deferred(a.class)).add(l.deferred(i8.a.class)).add(l.deferred(p9.a.class)).factory(new d(this, 0)).eagerInDefaultApp().build(), o9.g.create("fire-cls", "18.6.3"));
    }
}
