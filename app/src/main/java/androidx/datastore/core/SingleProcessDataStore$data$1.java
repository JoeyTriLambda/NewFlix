package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import i1.j;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import ng.b;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$data$1<T> extends SuspendLambda implements p<b<? super T>, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f2219b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f2220m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2221n;

    /* compiled from: SingleProcessDataStore.kt */
    @d(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<j<T>, c<? super Boolean>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f2222b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ j<T> f2223m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(j<T> jVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.f2223m = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f2223m, cVar);
            anonymousClass1.f2222b = obj;
            return anonymousClass1;
        }

        @Override // yf.p
        public final Object invoke(j<T> jVar, c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(jVar, cVar)).invokeSuspend(h.f16056a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.getCOROUTINE_SUSPENDED();
            f.throwOnFailure(obj);
            j<T> jVar = (j) this.f2222b;
            j<T> jVar2 = this.f2223m;
            boolean z10 = false;
            if (!(jVar2 instanceof i1.b) && !(jVar2 instanceof i1.f) && jVar == jVar2) {
                z10 = true;
            }
            return sf.a.boxBoolean(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$data$1> cVar) {
        super(2, cVar);
        this.f2221n = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.f2221n, cVar);
        singleProcessDataStore$data$1.f2220m = obj;
        return singleProcessDataStore$data$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f2219b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            b bVar = (b) this.f2220m;
            SingleProcessDataStore<T> singleProcessDataStore = this.f2221n;
            j jVar = (j) singleProcessDataStore.f2200h.getValue();
            if (!(jVar instanceof i1.b)) {
                singleProcessDataStore.f2202j.offer(new SingleProcessDataStore.b.a(jVar));
            }
            final ng.a aVarDropWhile = ng.c.dropWhile(singleProcessDataStore.f2200h, new AnonymousClass1(jVar, null));
            ng.a<T> aVar = new ng.a<T>() { // from class: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1

                /* compiled from: Collect.kt */
                /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2 implements b<j<T>> {

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ b f2204b;

                    @d(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: b, reason: collision with root package name */
                        public /* synthetic */ Object f2205b;

                        /* renamed from: m, reason: collision with root package name */
                        public int f2206m;

                        public AnonymousClass1(c cVar) {
                            super(cVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f2205b = obj;
                            this.f2206m |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(b bVar) {
                        this.f2204b = bVar;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ng.b
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(java.lang.Object r5, qf.c r6) throws java.lang.Throwable {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f2206m
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f2206m = r1
                            goto L18
                        L13:
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f2205b
                            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                            int r2 = r0.f2206m
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            lf.f.throwOnFailure(r6)
                            goto L53
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            lf.f.throwOnFailure(r6)
                            i1.j r5 = (i1.j) r5
                            boolean r6 = r5 instanceof i1.h
                            if (r6 != 0) goto L73
                            boolean r6 = r5 instanceof i1.f
                            if (r6 != 0) goto L6c
                            boolean r6 = r5 instanceof i1.b
                            if (r6 == 0) goto L56
                            i1.b r5 = (i1.b) r5
                            java.lang.Object r5 = r5.getValue()
                            r0.f2206m = r3
                            ng.b r6 = r4.f2204b
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L53
                            return r1
                        L53:
                            lf.h r5 = lf.h.f16056a
                            return r5
                        L56:
                            boolean r5 = r5 instanceof i1.k
                            if (r5 == 0) goto L66
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                            java.lang.String r6 = r6.toString()
                            r5.<init>(r6)
                            throw r5
                        L66:
                            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                            r5.<init>()
                            throw r5
                        L6c:
                            i1.f r5 = (i1.f) r5
                            java.lang.Throwable r5 = r5.getFinalException()
                            throw r5
                        L73:
                            i1.h r5 = (i1.h) r5
                            java.lang.Throwable r5 = r5.getReadException()
                            throw r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
                    }
                }

                @Override // ng.a
                public Object collect(b bVar2, c cVar) {
                    Object objCollect = aVarDropWhile.collect(new AnonymousClass2(bVar2), cVar);
                    return objCollect == a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
                }
            };
            this.f2219b = 1;
            if (ng.c.emitAll(bVar, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(b<? super T> bVar, c<? super h> cVar) {
        return ((SingleProcessDataStore$data$1) create(bVar, cVar)).invokeSuspend(h.f16056a);
    }
}
