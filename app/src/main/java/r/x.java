package r;

import android.app.job.JobParameters;
import android.content.Context;
import android.database.SQLException;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.work.c;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.gmascar.managers.BiddingBaseManager;
import com.unity3d.services.ads.operation.show.ShowOperationState;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.bvp.BetterVideoPlayer;
import g2.l;
import h9.a;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import m8.f;
import n0.g;
import org.greenrobot.eventbus.util.AsyncExecutor;
import r.y;
import x2.k0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18342b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f18343m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f18344n;

    public /* synthetic */ x(int i10, Object obj, Object obj2) {
        this.f18342b = i10;
        this.f18343m = obj;
        this.f18344n = obj2;
    }

    private final void a() {
        a.InterfaceC0161a<T> interfaceC0161a;
        l8.p pVar = (l8.p) this.f18343m;
        h9.b<T> bVar = (h9.b) this.f18344n;
        if (pVar.f15986b != l8.p.f15984d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (pVar) {
            interfaceC0161a = pVar.f15985a;
            pVar.f15985a = null;
            pVar.f15986b = bVar;
        }
        interfaceC0161a.handle(bVar);
    }

    private final void b() {
        l8.o oVar = (l8.o) this.f18343m;
        h9.b bVar = (h9.b) this.f18344n;
        synchronized (oVar) {
            if (oVar.f15982b == null) {
                oVar.f15981a.add(bVar);
            } else {
                oVar.f15982b.add(bVar.get());
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        switch (this.f18342b) {
            case 0:
                y.a aVar = (y.a) this.f18343m;
                Runnable runnable = (Runnable) this.f18344n;
                aVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    aVar.scheduleNext();
                }
            case 1:
                ((g.e) this.f18343m).onFontRetrieved((Typeface) this.f18344n);
                return;
            case 2:
            default:
                ((AsyncExecutor) this.f18343m).lambda$execute$0((AsyncExecutor.RunnableEx) this.f18344n);
                return;
            case 3:
                String str = (String) this.f18343m;
                Violation violation = (Violation) this.f18344n;
                FragmentStrictMode.b bVar = FragmentStrictMode.f2912a;
                zf.i.checkNotNullParameter(violation, "$violation");
                Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
                throw violation;
            case 4:
                ProfileInstallerInitializer profileInstallerInitializer = (ProfileInstallerInitializer) this.f18343m;
                Context context = (Context) this.f18344n;
                profileInstallerInitializer.getClass();
                (Build.VERSION.SDK_INT >= 28 ? ProfileInstallerInitializer.b.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new f2.d(context, 0), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case 5:
                g2.l lVar = (g2.l) this.f18343m;
                String[] strArr = (String[]) this.f18344n;
                int i10 = l.b.f12607b;
                zf.i.checkNotNullParameter(lVar, "this$0");
                zf.i.checkNotNullParameter(strArr, "$tables");
                lVar.getInvalidationTracker().notifyObserversByTableNames((String[]) Arrays.copyOf(strArr, strArr.length));
                return;
            case 6:
                Runnable runnable2 = (Runnable) this.f18344n;
                g2.s sVar = (g2.s) this.f18343m;
                zf.i.checkNotNullParameter(runnable2, "$command");
                zf.i.checkNotNullParameter(sVar, "this$0");
                try {
                    runnable2.run();
                    return;
                } finally {
                    sVar.scheduleNext();
                }
            case 7:
                k0 k0Var = (k0) this.f18343m;
                e8.c cVar = (e8.c) this.f18344n;
                if (k0Var.B.isCancelled()) {
                    cVar.cancel(true);
                    return;
                }
                return;
            case 8:
                List list = (List) this.f18343m;
                d3.g gVar = (d3.g) this.f18344n;
                zf.i.checkNotNullParameter(list, "$listenersList");
                zf.i.checkNotNullParameter(gVar, "this$0");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((b3.a) it.next()).onConstraintChanged(gVar.f10800e);
                }
                return;
            case 9:
                g3.v vVar = (g3.v) this.f18343m;
                h3.a aVar2 = (h3.a) this.f18344n;
                if (vVar.f12670b.isCancelled()) {
                    aVar2.cancel(true);
                    return;
                } else {
                    aVar2.setFuture(vVar.f12673o.getForegroundInfoAsync());
                    return;
                }
            case 10:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f18343m;
                e8.c<? extends c.a> cVar2 = (e8.c) this.f18344n;
                zf.i.checkNotNullParameter(constraintTrackingWorker, "this$0");
                zf.i.checkNotNullParameter(cVar2, "$innerFuture");
                synchronized (constraintTrackingWorker.f4642q) {
                    if (constraintTrackingWorker.f4643r) {
                        h3.a<c.a> aVar3 = constraintTrackingWorker.f4644s;
                        zf.i.checkNotNullExpressionValue(aVar3, "future");
                        aVar3.set(c.a.retry());
                    } else {
                        constraintTrackingWorker.f4644s.setFuture(cVar2);
                    }
                    lf.h hVar = lf.h.f16056a;
                }
                return;
            case 11:
                JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.f18343m;
                JobParameters jobParameters = (JobParameters) this.f18344n;
                int i11 = JobInfoSchedulerService.f5689b;
                jobInfoSchedulerService.jobFinished(jobParameters, false);
                return;
            case 12:
                a();
                return;
            case 13:
                b();
                return;
            case 14:
                ((f9.b) ((Map.Entry) this.f18343m).getKey()).handle((f9.a) this.f18344n);
                return;
            case 15:
                m8.a aVar4 = (m8.a) this.f18343m;
                Runnable runnable3 = (Runnable) this.f18344n;
                Process.setThreadPriority(aVar4.f16204n);
                StrictMode.ThreadPolicy threadPolicy = aVar4.f16205o;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable3.run();
                return;
            case 16:
                Callable callable = (Callable) this.f18343m;
                f.b bVar2 = (f.b) this.f18344n;
                try {
                    ((f.a) bVar2).set(callable.call());
                    return;
                } catch (Exception e10) {
                    ((f.a) bVar2).setException(e10);
                    return;
                }
            case 17:
                x8.c cVar3 = (x8.c) this.f18343m;
                CountDownLatch countDownLatch = (CountDownLatch) this.f18344n;
                cVar3.getClass();
                try {
                    q4.k.sendBlocking(cVar3.f21656h, Priority.HIGHEST);
                } catch (SQLException unused) {
                }
                countDownLatch.countDown();
                return;
            case 18:
                ((BiddingBaseManager) this.f18343m).lambda$onUnityAdsTokenReady$0((String) this.f18344n);
                return;
            case 19:
                ((ShowOperationState) this.f18343m).lambda$onUnityAdsShowComplete$3((UnityAds.UnityAdsShowCompletionState) this.f18344n);
                return;
            case 20:
                ((ShowOperationState) this.f18343m).lambda$onUnityAdsShowStart$2((String) this.f18344n);
                return;
            case 21:
                MainActivity mainActivity = (MainActivity) this.f18343m;
                kc.d dVar = (kc.d) this.f18344n;
                int i12 = MainActivity.f11697v0;
                mainActivity.askToUpdateIfAny(true, null);
                if (dVar != null) {
                    dVar.dismiss();
                    return;
                }
                return;
            case 22:
                MainActivityLeanback mainActivityLeanback = (MainActivityLeanback) this.f18343m;
                kc.d dVar2 = (kc.d) this.f18344n;
                int i13 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.askToUpdateIfAny(true, null);
                if (dVar2 != null) {
                    dVar2.dismiss();
                    return;
                }
                return;
            case 23:
                TVListFragmentMain tVListFragmentMain = (TVListFragmentMain) this.f18343m;
                androidx.leanback.widget.u uVar = (androidx.leanback.widget.u) this.f18344n;
                androidx.leanback.widget.a aVar5 = tVListFragmentMain.P0;
                if (aVar5.size() > 0) {
                    aVar5.add(1, uVar);
                    return;
                } else {
                    aVar5.add(0, uVar);
                    return;
                }
            case 24:
                AdultVideoPlayerActivity adultVideoPlayerActivity = (AdultVideoPlayerActivity) this.f18343m;
                BetterVideoPlayer betterVideoPlayer = (BetterVideoPlayer) this.f18344n;
                int i14 = AdultVideoPlayerActivity.f11962b0;
                adultVideoPlayerActivity.getClass();
                if (betterVideoPlayer.isPlaying()) {
                    return;
                }
                adultVideoPlayerActivity.Show();
                return;
        }
    }

    public /* synthetic */ x(Runnable runnable, g2.s sVar) {
        this.f18342b = 6;
        this.f18344n = runnable;
        this.f18343m = sVar;
    }
}
