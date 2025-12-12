package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.mapper.HttpRequestToWebRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: LegacyHttpClient.kt */
/* loaded from: classes2.dex */
public final class LegacyHttpClient implements HttpClient {
    private final ISDKDispatchers dispatchers;

    /* compiled from: LegacyHttpClient.kt */
    @d(c = "com.unity3d.services.core.network.core.LegacyHttpClient$execute$2", f = "LegacyHttpClient.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.network.core.LegacyHttpClient$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequest httpRequest, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
            WebRequest webRequest = HttpRequestToWebRequestKt.toWebRequest(this.$request);
            String strMakeRequest = webRequest.makeRequest();
            int responseCode = webRequest.getResponseCode();
            Map<String, List<String>> headers = webRequest.getHeaders();
            String string = webRequest.getUrl().toString();
            if (strMakeRequest == null) {
                strMakeRequest = "";
            }
            i.checkNotNullExpressionValue(headers, "headers");
            i.checkNotNullExpressionValue(string, "toString()");
            return new HttpResponse(strMakeRequest, responseCode, headers, string);
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: LegacyHttpClient.kt */
    @d(c = "com.unity3d.services.core.network.core.LegacyHttpClient$executeBlocking$1", f = "LegacyHttpClient.kt", l = {26}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.network.core.LegacyHttpClient$executeBlocking$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpRequest httpRequest, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return LegacyHttpClient.this.new AnonymousClass1(this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                LegacyHttpClient legacyHttpClient = LegacyHttpClient.this;
                HttpRequest httpRequest = this.$request;
                this.label = 1;
                obj = legacyHttpClient.execute(httpRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return obj;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public LegacyHttpClient(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public Object execute(HttpRequest httpRequest, c<? super HttpResponse> cVar) {
        return kg.f.withContext(this.dispatchers.getIo(), new AnonymousClass2(httpRequest, null), cVar);
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest httpRequest) {
        i.checkNotNullParameter(httpRequest, "request");
        return (HttpResponse) kg.f.runBlocking(this.dispatchers.getIo(), new AnonymousClass1(httpRequest, null));
    }
}
