package androidx.activity;

import a2.f;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.u;
import androidx.work.c;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.mon.app_bandwidth_monetizer_sdk.AppBandwidthMonetizerSdkHelper;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.operation.load.LoadOperationState;
import com.unity3d.services.ads.operation.show.ShowOperationState;
import f3.t;
import f3.u;
import flix.com.vision.activities.AnimeDetailActivity;
import flix.com.vision.activities.DramaDetailActivity;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.YouTubePlayerActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import l0.f;
import r.x;
import x2.e0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f806b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f807m;

    public /* synthetic */ d(Object obj, int i10) {
        this.f806b = i10;
        this.f807m = obj;
    }

    private final void a() {
        ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f807m;
        zf.i.checkNotNullParameter(constraintTrackingWorker, "this$0");
        if (constraintTrackingWorker.f4644s.isCancelled()) {
            return;
        }
        String string = constraintTrackingWorker.getInputData().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        w2.g gVar = w2.g.get();
        zf.i.checkNotNullExpressionValue(gVar, "get()");
        if (string == null || string.length() == 0) {
            gVar.error(j3.a.f14582a, "No worker to delegate to.");
            h3.a<c.a> aVar = constraintTrackingWorker.f4644s;
            zf.i.checkNotNullExpressionValue(aVar, "future");
            aVar.set(c.a.failure());
            return;
        }
        androidx.work.c cVarCreateWorkerWithDefaultFallback = constraintTrackingWorker.getWorkerFactory().createWorkerWithDefaultFallback(constraintTrackingWorker.getApplicationContext(), string, constraintTrackingWorker.f4641p);
        constraintTrackingWorker.f4645t = cVarCreateWorkerWithDefaultFallback;
        if (cVarCreateWorkerWithDefaultFallback == null) {
            gVar.debug(j3.a.f14582a, "No worker to delegate to.");
            h3.a<c.a> aVar2 = constraintTrackingWorker.f4644s;
            zf.i.checkNotNullExpressionValue(aVar2, "future");
            aVar2.set(c.a.failure());
            return;
        }
        e0 e0Var = e0.getInstance(constraintTrackingWorker.getApplicationContext());
        zf.i.checkNotNullExpressionValue(e0Var, "getInstance(applicationContext)");
        u uVarWorkSpecDao = e0Var.getWorkDatabase().workSpecDao();
        String string2 = constraintTrackingWorker.getId().toString();
        zf.i.checkNotNullExpressionValue(string2, "id.toString()");
        t workSpec = uVarWorkSpecDao.getWorkSpec(string2);
        if (workSpec == null) {
            h3.a<c.a> aVar3 = constraintTrackingWorker.f4644s;
            zf.i.checkNotNullExpressionValue(aVar3, "future");
            aVar3.set(c.a.failure());
            return;
        }
        d3.n trackers = e0Var.getTrackers();
        zf.i.checkNotNullExpressionValue(trackers, "workManagerImpl.trackers");
        b3.e eVar = new b3.e(trackers, constraintTrackingWorker);
        eVar.replace(mf.j.listOf(workSpec));
        String string3 = constraintTrackingWorker.getId().toString();
        zf.i.checkNotNullExpressionValue(string3, "id.toString()");
        if (!eVar.areAllConstraintsMet(string3)) {
            gVar.debug(j3.a.f14582a, "Constraints not met for delegate " + string + ". Requesting retry.");
            h3.a<c.a> aVar4 = constraintTrackingWorker.f4644s;
            zf.i.checkNotNullExpressionValue(aVar4, "future");
            aVar4.set(c.a.retry());
            return;
        }
        gVar.debug(j3.a.f14582a, "Constraints met for delegate " + string);
        try {
            androidx.work.c cVar = constraintTrackingWorker.f4645t;
            zf.i.checkNotNull(cVar);
            e8.c<c.a> cVarStartWork = cVar.startWork();
            zf.i.checkNotNullExpressionValue(cVarStartWork, "delegate!!.startWork()");
            cVarStartWork.addListener(new x(10, constraintTrackingWorker, cVarStartWork), constraintTrackingWorker.getBackgroundExecutor());
        } catch (Throwable th2) {
            gVar.debug(j3.a.f14582a, ac.c.k("Delegated worker ", string, " threw exception in startWork."), th2);
            synchronized (constraintTrackingWorker.f4642q) {
                if (!constraintTrackingWorker.f4643r) {
                    h3.a<c.a> aVar5 = constraintTrackingWorker.f4644s;
                    zf.i.checkNotNullExpressionValue(aVar5, "future");
                    aVar5.set(c.a.failure());
                } else {
                    gVar.debug(j3.a.f14582a, "Constraints were unmet, Retrying.");
                    h3.a<c.a> aVar6 = constraintTrackingWorker.f4644s;
                    zf.i.checkNotNullExpressionValue(aVar6, "future");
                    aVar6.set(c.a.retry());
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        Object obj3 = this.f807m;
        int i10 = 5;
        boolean z10 = true;
        switch (this.f806b) {
            case 0:
                ((ComponentActivity) obj3).invalidateMenu();
                return;
            case 1:
                ComponentActivity.f fVar = (ComponentActivity.f) obj3;
                Runnable runnable = fVar.f768m;
                if (runnable != null) {
                    runnable.run();
                    fVar.f768m = null;
                    return;
                }
                return;
            case 2:
                h.a((h) obj3);
                return;
            case 3:
            case 12:
            case 14:
            default:
                ((YouTubePlayerActivity) obj3).f11882s = false;
                return;
            case 4:
                Activity activity = (Activity) obj3;
                int i11 = l0.a.f15632a;
                if (activity.isFinishing()) {
                    return;
                }
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 28) {
                    Class<?> cls = l0.f.f15640a;
                    activity.recreate();
                } else {
                    Class<?> cls2 = l0.f.f15640a;
                    boolean z11 = i12 == 26 || i12 == 27;
                    Method method = l0.f.f15645f;
                    if ((z11 && method == null) || (l0.f.f15644e == null && l0.f.f15643d == null)) {
                        z10 = false;
                    } else {
                        try {
                            obj = l0.f.f15642c.get(activity);
                        } catch (Throwable unused) {
                        }
                        if (obj == null || (obj2 = l0.f.f15641b.get(activity)) == null) {
                            z10 = false;
                        } else {
                            Application application = activity.getApplication();
                            f.b bVar = new f.b(activity);
                            application.registerActivityLifecycleCallbacks(bVar);
                            Handler handler = l0.f.f15646g;
                            handler.post(new l0.d(bVar, obj));
                            try {
                                if (i12 == 26 || i12 == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj2, obj, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new l0.e(application, bVar));
                            } catch (Throwable th2) {
                                handler.post(new l0.e(application, bVar));
                                throw th2;
                            }
                        }
                    }
                }
                if (z10) {
                    return;
                }
                activity.recreate();
                return;
            case 5:
                androidx.lifecycle.u uVar = (androidx.lifecycle.u) obj3;
                u.b bVar2 = androidx.lifecycle.u.f3506t;
                zf.i.checkNotNullParameter(uVar, "this$0");
                uVar.dispatchPauseIfNeeded$lifecycle_process_release();
                uVar.dispatchStopIfNeeded$lifecycle_process_release();
                return;
            case 6:
                ((a2.a) obj3).l();
                return;
            case 7:
                ((f.c) obj3).f129n = -1;
                return;
            case 8:
                ((g2.j) obj3).onAutoCloseCallback$room_runtime_release();
                return;
            case 9:
                a();
                return;
            case 10:
                x4.j jVar = (x4.j) obj3;
                jVar.getClass();
                jVar.f21552d.runCriticalSection(new c1.c(jVar, i10));
                return;
            case 11:
                ((CarouselLayoutManager) obj3).E();
                return;
            case 13:
                ((k7.c) obj3).startListeningForBackCallbacksWithPriorityOverlay();
                return;
            case 15:
                SideSheetBehavior.d dVar = (SideSheetBehavior.d) obj3;
                dVar.f9276b = false;
                SideSheetBehavior sideSheetBehavior = dVar.f9278d;
                g1.c cVar = sideSheetBehavior.f9265t;
                if (cVar != null && cVar.continueSettling(true)) {
                    dVar.a(dVar.f9275a);
                    return;
                } else {
                    if (sideSheetBehavior.f9264s == 2) {
                        sideSheetBehavior.c(dVar.f9275a);
                        return;
                    }
                    return;
                }
            case 16:
                ((v7.e) obj3).o(true);
                return;
            case 17:
                v7.k kVar = (v7.k) obj3;
                boolean zIsPopupShowing = kVar.f20547h.isPopupShowing();
                kVar.o(zIsPopupShowing);
                kVar.f20552m = zIsPopupShowing;
                return;
            case 18:
                ((TextInputLayout) obj3).f9424o.requestLayout();
                return;
            case 19:
                Object obj4 = com.google.firebase.installations.a.f9802m;
                ((com.google.firebase.installations.a) obj3).b(false);
                return;
            case 20:
                AppBandwidthMonetizerSdkHelper appBandwidthMonetizerSdkHelper = (AppBandwidthMonetizerSdkHelper) obj3;
                zf.i.checkNotNullParameter(appBandwidthMonetizerSdkHelper, "this$0");
                fa.a currentProxyStats = appBandwidthMonetizerSdkHelper.getCurrentProxyStats();
                if (currentProxyStats != null) {
                    appBandwidthMonetizerSdkHelper.f10288i.postValue(currentProxyStats);
                    return;
                }
                return;
            case 21:
                ((IUnityAdsTokenListener) obj3).onUnityAdsTokenReady(null);
                return;
            case 22:
                ((LoadOperationState) obj3).lambda$onUnityAdsAdLoaded$1();
                return;
            case 23:
                ((ShowOperationState) obj3).lambda$onUnityAdsShowClick$1();
                return;
            case 24:
                ((IUnityAdsInitializationListener) obj3).onInitializationComplete();
                return;
            case 25:
                int i13 = AnimeDetailActivity.f11584e0;
                ((AnimeDetailActivity) obj3).extractDominantColor();
                return;
            case 26:
                int i14 = DramaDetailActivity.f11610b0;
                ((DramaDetailActivity) obj3).extractDominantColor();
                return;
            case 27:
                SearchActivityTV searchActivityTV = (SearchActivityTV) obj3;
                searchActivityTV.X.clearFocus();
                searchActivityTV.U.requestFocus();
                return;
            case 28:
                UserTorrentsActivity userTorrentsActivity = (UserTorrentsActivity) obj3;
                ArrayList<hd.o> arrayList = userTorrentsActivity.W;
                if (arrayList.size() > 0) {
                    kc.d dVar2 = userTorrentsActivity.V;
                    if (dVar2 != null) {
                        try {
                            dVar2.dismiss();
                        } catch (Exception unused2) {
                        }
                    }
                    userTorrentsActivity.d(arrayList);
                    return;
                }
                return;
        }
    }
}
