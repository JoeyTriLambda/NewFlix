package retrofit2;

import java.lang.reflect.Method;
import kg.m;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import lf.f;
import lf.h;
import org.apache.commons.lang3.ClassUtils;
import qf.c;
import sf.d;
import yf.l;
import zf.i;

/* compiled from: KotlinExtensions.kt */
/* loaded from: classes2.dex */
public final class KotlinExtensions {

    /* compiled from: KotlinExtensions.kt */
    @d(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    /* renamed from: retrofit2.KotlinExtensions$suspendAndThrow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinExtensions.suspendAndThrow(null, this);
        }
    }

    public static final <T> Object await(final Call<T> call, c<? super T> cVar) {
        final m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.invokeOnCancellation(new l<Throwable, h>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th2) {
                i.checkParameterIsNotNull(call2, "call");
                i.checkParameterIsNotNull(th2, "t");
                kg.l lVar = mVar;
                int i10 = Result.f15189m;
                lVar.resumeWith(Result.m59constructorimpl(f.createFailure(th2)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.checkParameterIsNotNull(call2, "call");
                i.checkParameterIsNotNull(response, "response");
                if (!response.isSuccessful()) {
                    kg.l lVar = mVar;
                    HttpException httpException = new HttpException(response);
                    int i10 = Result.f15189m;
                    lVar.resumeWith(Result.m59constructorimpl(f.createFailure(httpException)));
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    mVar.resumeWith(Result.m59constructorimpl(tBody));
                    return;
                }
                Object objTag = call2.request().tag(Invocation.class);
                if (objTag == null) {
                    i.throwNpe();
                }
                i.checkExpressionValueIsNotNull(objTag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) objTag).method();
                StringBuilder sb2 = new StringBuilder("Response from ");
                i.checkExpressionValueIsNotNull(method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                i.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
                sb2.append(declaringClass.getName());
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                sb2.append(method.getName());
                sb2.append(" was null but response body type was declared as non-null");
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb2.toString());
                kg.l lVar2 = mVar;
                int i11 = Result.f15189m;
                lVar2.resumeWith(Result.m59constructorimpl(f.createFailure(kotlinNullPointerException)));
            }
        });
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result;
    }

    public static final <T> Object awaitNullable(final Call<T> call, c<? super T> cVar) {
        final m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.invokeOnCancellation(new l<Throwable, h>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th2) {
                i.checkParameterIsNotNull(call2, "call");
                i.checkParameterIsNotNull(th2, "t");
                kg.l lVar = mVar;
                int i10 = Result.f15189m;
                lVar.resumeWith(Result.m59constructorimpl(f.createFailure(th2)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.checkParameterIsNotNull(call2, "call");
                i.checkParameterIsNotNull(response, "response");
                if (response.isSuccessful()) {
                    mVar.resumeWith(Result.m59constructorimpl(response.body()));
                    return;
                }
                kg.l lVar = mVar;
                HttpException httpException = new HttpException(response);
                int i10 = Result.f15189m;
                lVar.resumeWith(Result.m59constructorimpl(f.createFailure(httpException)));
            }
        });
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result;
    }

    public static final <T> Object awaitResponse(final Call<T> call, c<? super Response<T>> cVar) {
        final m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.invokeOnCancellation(new l<Throwable, h>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th2) {
                i.checkParameterIsNotNull(call2, "call");
                i.checkParameterIsNotNull(th2, "t");
                kg.l lVar = mVar;
                int i10 = Result.f15189m;
                lVar.resumeWith(Result.m59constructorimpl(f.createFailure(th2)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.checkParameterIsNotNull(call2, "call");
                i.checkParameterIsNotNull(response, "response");
                mVar.resumeWith(Result.m59constructorimpl(response));
            }
        });
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        i.checkParameterIsNotNull(retrofit, "$this$create");
        i.reifiedOperationMarker(4, "T");
        return (T) retrofit.create(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object suspendAndThrow(final java.lang.Exception r4, qf.c<?> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            lf.f.throwOnFailure(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            lf.f.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.b r5 = kg.s0.getDefault()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            r5.dispatch(r2, r3)
            java.lang.Object r4 = rf.a.getCOROUTINE_SUSPENDED()
            java.lang.Object r5 = rf.a.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L59
            sf.f.probeCoroutineSuspended(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            lf.h r4 = lf.h.f16056a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, qf.c):java.lang.Object");
    }
}
