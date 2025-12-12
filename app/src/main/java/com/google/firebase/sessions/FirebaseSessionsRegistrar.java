package com.google.firebase.sessions;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.sessions.settings.SessionsSettings;
import g8.f;
import i9.c;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.b;
import l8.b;
import l8.d;
import l8.l;
import l8.r;
import m8.g;
import r9.e;
import r9.k;
import r9.o;
import r9.q;
import r9.u;
import zf.i;

/* compiled from: FirebaseSessionsRegistrar.kt */
@Keep
/* loaded from: classes.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {

    @Deprecated
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final a Companion = new a(null);

    @Deprecated
    private static final r<f> firebaseApp = r.unqualified(f.class);

    @Deprecated
    private static final r<c> firebaseInstallationsApi = r.unqualified(c.class);

    @Deprecated
    private static final r<b> backgroundDispatcher = r.qualified(k8.a.class, b.class);

    @Deprecated
    private static final r<b> blockingDispatcher = r.qualified(k8.b.class, b.class);

    @Deprecated
    private static final r<n4.f> transportFactory = r.unqualified(n4.f.class);

    @Deprecated
    private static final r<SessionsSettings> sessionsSettings = r.unqualified(SessionsSettings.class);

    /* compiled from: FirebaseSessionsRegistrar.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-0, reason: not valid java name */
    public static final FirebaseSessions m14getComponents$lambda0(d dVar) {
        Object obj = dVar.get(firebaseApp);
        i.checkNotNullExpressionValue(obj, "container[firebaseApp]");
        Object obj2 = dVar.get(sessionsSettings);
        i.checkNotNullExpressionValue(obj2, "container[sessionsSettings]");
        Object obj3 = dVar.get(backgroundDispatcher);
        i.checkNotNullExpressionValue(obj3, "container[backgroundDispatcher]");
        return new FirebaseSessions((f) obj, (SessionsSettings) obj2, (CoroutineContext) obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-1, reason: not valid java name */
    public static final SessionGenerator m15getComponents$lambda1(d dVar) {
        return new SessionGenerator(u.f18895a, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-2, reason: not valid java name */
    public static final o m16getComponents$lambda2(d dVar) {
        Object obj = dVar.get(firebaseApp);
        i.checkNotNullExpressionValue(obj, "container[firebaseApp]");
        f fVar = (f) obj;
        Object obj2 = dVar.get(firebaseInstallationsApi);
        i.checkNotNullExpressionValue(obj2, "container[firebaseInstallationsApi]");
        c cVar = (c) obj2;
        Object obj3 = dVar.get(sessionsSettings);
        i.checkNotNullExpressionValue(obj3, "container[sessionsSettings]");
        SessionsSettings sessionsSettings2 = (SessionsSettings) obj3;
        h9.b provider = dVar.getProvider(transportFactory);
        i.checkNotNullExpressionValue(provider, "container.getProvider(transportFactory)");
        e eVar = new e(provider);
        Object obj4 = dVar.get(backgroundDispatcher);
        i.checkNotNullExpressionValue(obj4, "container[backgroundDispatcher]");
        return new SessionFirelogPublisherImpl(fVar, cVar, sessionsSettings2, eVar, (CoroutineContext) obj4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-3, reason: not valid java name */
    public static final SessionsSettings m17getComponents$lambda3(d dVar) {
        Object obj = dVar.get(firebaseApp);
        i.checkNotNullExpressionValue(obj, "container[firebaseApp]");
        Object obj2 = dVar.get(blockingDispatcher);
        i.checkNotNullExpressionValue(obj2, "container[blockingDispatcher]");
        Object obj3 = dVar.get(backgroundDispatcher);
        i.checkNotNullExpressionValue(obj3, "container[backgroundDispatcher]");
        Object obj4 = dVar.get(firebaseInstallationsApi);
        i.checkNotNullExpressionValue(obj4, "container[firebaseInstallationsApi]");
        return new SessionsSettings((f) obj, (CoroutineContext) obj2, (CoroutineContext) obj3, (c) obj4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-4, reason: not valid java name */
    public static final k m18getComponents$lambda4(d dVar) {
        Context applicationContext = ((f) dVar.get(firebaseApp)).getApplicationContext();
        i.checkNotNullExpressionValue(applicationContext, "container[firebaseApp].applicationContext");
        Object obj = dVar.get(backgroundDispatcher);
        i.checkNotNullExpressionValue(obj, "container[backgroundDispatcher]");
        return new SessionDatastoreImpl(applicationContext, (CoroutineContext) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-5, reason: not valid java name */
    public static final q m19getComponents$lambda5(d dVar) {
        Object obj = dVar.get(firebaseApp);
        i.checkNotNullExpressionValue(obj, "container[firebaseApp]");
        return new r9.r((f) obj);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<l8.b<? extends Object>> getComponents() {
        b.a aVarName = l8.b.builder(FirebaseSessions.class).name(LIBRARY_NAME);
        r<f> rVar = firebaseApp;
        b.a aVarAdd = aVarName.add(l.required(rVar));
        r<SessionsSettings> rVar2 = sessionsSettings;
        b.a aVarAdd2 = aVarAdd.add(l.required(rVar2));
        r<kotlinx.coroutines.b> rVar3 = backgroundDispatcher;
        b.a aVarAdd3 = l8.b.builder(o.class).name("session-publisher").add(l.required(rVar));
        r<c> rVar4 = firebaseInstallationsApi;
        return mf.k.listOf((Object[]) new l8.b[]{aVarAdd2.add(l.required(rVar3)).factory(new g(7)).eagerInDefaultApp().build(), l8.b.builder(SessionGenerator.class).name("session-generator").factory(new g(8)).build(), aVarAdd3.add(l.required(rVar4)).add(l.required(rVar2)).add(l.requiredProvider(transportFactory)).add(l.required(rVar3)).factory(new g(9)).build(), l8.b.builder(SessionsSettings.class).name("sessions-settings").add(l.required(rVar)).add(l.required(blockingDispatcher)).add(l.required(rVar3)).add(l.required(rVar4)).factory(new g(10)).build(), l8.b.builder(k.class).name("sessions-datastore").add(l.required(rVar)).add(l.required(rVar3)).factory(new g(11)).build(), l8.b.builder(q.class).name("sessions-service-binder").add(l.required(rVar)).factory(new g(12)).build(), o9.g.create(LIBRARY_NAME, "1.2.3")});
    }
}
