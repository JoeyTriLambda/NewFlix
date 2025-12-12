package d3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: BroadcastReceiverConstraintTracker.kt */
/* loaded from: classes.dex */
public abstract class e<T> extends g<T> {

    /* renamed from: f, reason: collision with root package name */
    public final a f10793f;

    /* compiled from: BroadcastReceiverConstraintTracker.kt */
    public static final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e<T> f10794a;

        public a(e<T> eVar) {
            this.f10794a = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zf.i.checkNotNullParameter(context, "context");
            zf.i.checkNotNullParameter(intent, "intent");
            this.f10794a.onBroadcastReceive(intent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, i3.c cVar) {
        super(context, cVar);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
        this.f10793f = new a(this);
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Intent intent);

    @Override // d3.g
    public void startTracking() {
        w2.g.get().debug(f.f10795a, getClass().getSimpleName().concat(": registering receiver"));
        getAppContext().registerReceiver(this.f10793f, getIntentFilter());
    }

    @Override // d3.g
    public void stopTracking() {
        w2.g.get().debug(f.f10795a, getClass().getSimpleName().concat(": unregistering receiver"));
        getAppContext().unregisterReceiver(this.f10793f);
    }
}
