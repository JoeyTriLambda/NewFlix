package androidx.datastore.preferences.core;

import i1.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l1.a;
import lf.f;
import lf.h;
import qf.c;
import yf.p;
import zf.i;

/* compiled from: PreferenceDataStoreFactory.kt */
/* loaded from: classes.dex */
public final class PreferenceDataStore implements d<a> {

    /* renamed from: a, reason: collision with root package name */
    public final d<a> f2307a;

    /* compiled from: PreferenceDataStoreFactory.kt */
    @sf.d(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.preferences.core.PreferenceDataStore$updateData$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<a, c<? super a>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f2308b;

        /* renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f2309m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ p<a, c<? super a>, Object> f2310n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(p<? super a, ? super c<? super a>, ? extends Object> pVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.f2310n = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f2310n, cVar);
            anonymousClass2.f2309m = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f2308b;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                a aVar = (a) this.f2309m;
                this.f2308b = 1;
                obj = this.f2310n.invoke(aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            a aVar2 = (a) obj;
            ((MutablePreferences) aVar2).freeze$datastore_preferences_core();
            return aVar2;
        }

        @Override // yf.p
        public final Object invoke(a aVar, c<? super a> cVar) {
            return ((AnonymousClass2) create(aVar, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public PreferenceDataStore(d<a> dVar) {
        i.checkNotNullParameter(dVar, "delegate");
        this.f2307a = dVar;
    }

    @Override // i1.d
    public ng.a<a> getData() {
        return this.f2307a.getData();
    }

    @Override // i1.d
    public Object updateData(p<? super a, ? super c<? super a>, ? extends Object> pVar, c<? super a> cVar) {
        return this.f2307a.updateData(new AnonymousClass2(pVar, null), cVar);
    }
}
