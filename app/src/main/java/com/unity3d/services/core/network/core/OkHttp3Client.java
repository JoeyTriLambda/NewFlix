package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kg.g0;
import kg.l;
import kg.m;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: OkHttp3Client.kt */
/* loaded from: classes2.dex */
public final class OkHttp3Client implements HttpClient {
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    /* compiled from: OkHttp3Client.kt */
    @d(c = "com.unity3d.services.core.network.core.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", l = {47}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.network.core.OkHttp3Client$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;
        final /* synthetic */ OkHttp3Client this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequest httpRequest, OkHttp3Client okHttp3Client, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
            this.this$0 = okHttp3Client;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$request, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                Request okHttpRequest = HttpRequestToOkHttpRequestKt.toOkHttpRequest(this.$request);
                OkHttp3Client okHttp3Client = this.this$0;
                long connectTimeout = this.$request.getConnectTimeout();
                long readTimeout = this.$request.getReadTimeout();
                this.label = 1;
                obj = okHttp3Client.makeRequest(okHttpRequest, connectTimeout, readTimeout, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            Response response = (Response) obj;
            int iCode = response.code();
            Map<String, List<String>> multimap = response.headers().toMultimap();
            String string = response.request().url().toString();
            ResponseBody responseBodyBody = response.body();
            String strString = responseBodyBody != null ? responseBodyBody.string() : null;
            if (strString == null) {
                strString = "";
            }
            i.checkNotNullExpressionValue(multimap, "toMultimap()");
            i.checkNotNullExpressionValue(string, "toString()");
            return new HttpResponse(strString, iCode, multimap, string);
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: OkHttp3Client.kt */
    @d(c = "com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1", f = "OkHttp3Client.kt", l = {36}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1, reason: invalid class name */
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
            return OkHttp3Client.this.new AnonymousClass1(this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                OkHttp3Client okHttp3Client = OkHttp3Client.this;
                HttpRequest httpRequest = this.$request;
                this.label = 1;
                obj = okHttp3Client.execute(httpRequest, this);
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

    public OkHttp3Client(ISDKDispatchers iSDKDispatchers, OkHttpClient okHttpClient) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(okHttpClient, "client");
        this.dispatchers = iSDKDispatchers;
        this.client = okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(Request request, long j10, long j11, c<? super Response> cVar) {
        final m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        OkHttpClient.Builder builderNewBuilder = this.client.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builderNewBuilder.connectTimeout(j10, timeUnit).readTimeout(j11, timeUnit).build().newCall(request).enqueue(new Callback() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                i.checkNotNullParameter(call, "call");
                i.checkNotNullParameter(iOException, "e");
                l<Response> lVar = mVar;
                int i10 = Result.f15189m;
                lVar.resumeWith(Result.m59constructorimpl(f.createFailure(iOException)));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                i.checkNotNullParameter(call, "call");
                i.checkNotNullParameter(response, "response");
                mVar.resumeWith(Result.m59constructorimpl(response));
            }
        });
        Object result = mVar.getResult();
        if (result == a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public Object execute(HttpRequest httpRequest, c<? super HttpResponse> cVar) {
        return kg.f.withContext(this.dispatchers.getIo(), new AnonymousClass2(httpRequest, this, null), cVar);
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest httpRequest) {
        i.checkNotNullParameter(httpRequest, "request");
        return (HttpResponse) kg.f.runBlocking(this.dispatchers.getIo(), new AnonymousClass1(httpRequest, null));
    }
}
