package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.webview.WebView;
import com.unity3d.services.core.webview.WebViewApp;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.b;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: InitializeStateReset.kt */
@d(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1", f = "InitializeStateReset.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InitializeStateReset$doWork$2$success$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
    final /* synthetic */ WebViewApp $currentApp;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* compiled from: InitializeStateReset.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1$1", f = "InitializeStateReset.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        final /* synthetic */ WebViewApp $currentApp;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WebViewApp webViewApp, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$currentApp = webViewApp;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$currentApp, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
            WebView webView = this.$currentApp.getWebView();
            if (webView != null) {
                webView.destroy();
            }
            this.$currentApp.setWebView(null);
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateReset$doWork$2$success$1(InitializeStateReset initializeStateReset, WebViewApp webViewApp, c<? super InitializeStateReset$doWork$2$success$1> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateReset;
        this.$currentApp = webViewApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new InitializeStateReset$doWork$2$success$1(this.this$0, this.$currentApp, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            b main = this.this$0.dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentApp, null);
            this.label = 1;
            if (kg.f.withContext(main, anonymousClass1, this) == coroutine_suspended) {
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
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((InitializeStateReset$doWork$2$success$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
