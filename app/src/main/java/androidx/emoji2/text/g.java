package androidx.emoji2.text;

import android.webkit.ValueCallback;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.f;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.load.LoadOperationState;
import com.unity3d.services.ads.operation.show.ShowOperationState;
import com.unity3d.services.core.webview.WebView;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import r8.o0;
import r8.p0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2617b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2618m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f2619n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f2620o;

    public /* synthetic */ g(int i10, Object obj, Object obj2, Object obj3) {
        this.f2617b = i10;
        this.f2618m = obj;
        this.f2619n = obj2;
        this.f2620o = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f2617b;
        Object obj = this.f2620o;
        Object obj2 = this.f2619n;
        Object obj3 = this.f2618m;
        switch (i10) {
            case 0:
                EmojiCompatInitializer.b bVar = (EmojiCompatInitializer.b) obj3;
                f.h hVar = (f.h) obj2;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) obj;
                bVar.getClass();
                try {
                    l lVarCreate = c.create(bVar.f2590a);
                    if (lVarCreate == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    lVarCreate.setLoadingExecutor(threadPoolExecutor);
                    lVarCreate.getMetadataRepoLoader().load(new h(hVar, threadPoolExecutor));
                    return;
                } catch (Throwable th2) {
                    hVar.onFailed(th2);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                g2.m mVar = (g2.m) obj3;
                zf.i.checkNotNullParameter(mVar, "this$0");
                zf.i.checkNotNullParameter((String) obj2, "$sql");
                zf.i.checkNotNullParameter((List) obj, "$inputArguments");
                mVar.getClass();
                throw null;
            case 2:
                Callable callable = (Callable) obj3;
                Executor executor = (Executor) obj2;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj;
                ExecutorService executorService = p0.f18742a;
                try {
                    ((Task) callable.call()).continueWith(executor, new o0(1, taskCompletionSource));
                    return;
                } catch (Exception e10) {
                    taskCompletionSource.setException(e10);
                    return;
                }
            case 3:
                ((LoadOperationState) obj3).lambda$onUnityAdsFailedToLoad$0((UnityAds.UnityAdsLoadError) obj2, (String) obj);
                return;
            case 4:
                ((ShowOperationState) obj3).lambda$onUnityAdsShowFailure$0((UnityAds.UnityAdsShowError) obj2, (String) obj);
                return;
            case 5:
                ((IUnityAdsInitializationListener) obj3).onInitializationFailed((UnityAds.UnityAdsInitializationError) obj2, (String) obj);
                return;
            default:
                WebView.evaluateJavascript$lambda$1((WebView) obj3, (String) obj2, (ValueCallback) obj);
                return;
        }
    }
}
