package d3;

import android.content.Context;

/* compiled from: Trackers.kt */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final g<Boolean> f10808a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10809b;

    /* renamed from: c, reason: collision with root package name */
    public final g<b3.b> f10810c;

    /* renamed from: d, reason: collision with root package name */
    public final g<Boolean> f10811d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(Context context, i3.c cVar) {
        this(context, cVar, null, null, null, null, 60, null);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
    }

    public final g<Boolean> getBatteryChargingTracker() {
        return this.f10808a;
    }

    public final c getBatteryNotLowTracker() {
        return this.f10809b;
    }

    public final g<b3.b> getNetworkStateTracker() {
        return this.f10810c;
    }

    public final g<Boolean> getStorageNotLowTracker() {
        return this.f10811d;
    }

    public n(Context context, i3.c cVar, g<Boolean> gVar, c cVar2, g<b3.b> gVar2, g<Boolean> gVar3) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
        zf.i.checkNotNullParameter(gVar, "batteryChargingTracker");
        zf.i.checkNotNullParameter(cVar2, "batteryNotLowTracker");
        zf.i.checkNotNullParameter(gVar2, "networkStateTracker");
        zf.i.checkNotNullParameter(gVar3, "storageNotLowTracker");
        this.f10808a = gVar;
        this.f10809b = cVar2;
        this.f10810c = gVar2;
        this.f10811d = gVar3;
    }

    public /* synthetic */ n(Context context, i3.c cVar, g gVar, c cVar2, g gVar2, g gVar3, int i10, zf.f fVar) {
        g aVar;
        c cVar3;
        g gVarNetworkStateTracker;
        g lVar;
        if ((i10 & 4) != 0) {
            Context applicationContext = context.getApplicationContext();
            zf.i.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            aVar = new a(applicationContext, cVar);
        } else {
            aVar = gVar;
        }
        if ((i10 & 8) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            zf.i.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
            cVar3 = new c(applicationContext2, cVar);
        } else {
            cVar3 = cVar2;
        }
        if ((i10 & 16) != 0) {
            Context applicationContext3 = context.getApplicationContext();
            zf.i.checkNotNullExpressionValue(applicationContext3, "context.applicationContext");
            gVarNetworkStateTracker = j.NetworkStateTracker(applicationContext3, cVar);
        } else {
            gVarNetworkStateTracker = gVar2;
        }
        if ((i10 & 32) != 0) {
            Context applicationContext4 = context.getApplicationContext();
            zf.i.checkNotNullExpressionValue(applicationContext4, "context.applicationContext");
            lVar = new l(applicationContext4, cVar);
        } else {
            lVar = gVar3;
        }
        this(context, cVar, aVar, cVar3, gVarNetworkStateTracker, lVar);
    }
}
