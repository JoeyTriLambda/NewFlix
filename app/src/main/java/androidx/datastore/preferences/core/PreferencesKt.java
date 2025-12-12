package androidx.datastore.preferences.core;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import l1.a;
import lf.f;
import lf.h;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: Preferences.kt */
/* loaded from: classes.dex */
public final class PreferencesKt {

    /* compiled from: Preferences.kt */
    @d(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.preferences.core.PreferencesKt$edit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<a, c<? super a>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f2313b;

        /* renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f2314m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ p<MutablePreferences, c<? super h>, Object> f2315n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(p<? super MutablePreferences, ? super c<? super h>, ? extends Object> pVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.f2315n = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f2315n, cVar);
            anonymousClass2.f2314m = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f2313b;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MutablePreferences mutablePreferences = (MutablePreferences) this.f2314m;
                f.throwOnFailure(obj);
                return mutablePreferences;
            }
            f.throwOnFailure(obj);
            MutablePreferences mutablePreferences2 = ((a) this.f2314m).toMutablePreferences();
            this.f2314m = mutablePreferences2;
            this.f2313b = 1;
            return this.f2315n.invoke(mutablePreferences2, this) == coroutine_suspended ? coroutine_suspended : mutablePreferences2;
        }

        @Override // yf.p
        public final Object invoke(a aVar, c<? super a> cVar) {
            return ((AnonymousClass2) create(aVar, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public static final Object edit(i1.d<a> dVar, p<? super MutablePreferences, ? super c<? super h>, ? extends Object> pVar, c<? super a> cVar) {
        return dVar.updateData(new AnonymousClass2(pVar, null), cVar);
    }
}
