package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import e2.b;
import e2.d;
import e8.c;
import kg.h0;
import kg.s0;
import lf.h;
import zf.f;
import zf.i;

/* compiled from: MeasurementManagerFutures.kt */
/* loaded from: classes.dex */
public abstract class MeasurementManagerFutures {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3816a = new a(null);

    /* compiled from: MeasurementManagerFutures.kt */
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {

        /* renamed from: b, reason: collision with root package name */
        public final b f3817b;

        public Api33Ext5JavaImpl(b bVar) {
            i.checkNotNullParameter(bVar, "mMeasurementManager");
            this.f3817b = bVar;
        }

        public c<h> deleteRegistrationsAsync(e2.a aVar) {
            i.checkNotNullParameter(aVar, "deletionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(kg.h.async$default(h0.CoroutineScope(s0.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public c<Integer> getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(kg.h.async$default(h0.CoroutineScope(s0.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null), 3, null), null, 1, null);
        }

        public c<h> registerSourceAsync(Uri uri, InputEvent inputEvent) {
            i.checkNotNullParameter(uri, "attributionSource");
            return CoroutineAdapterKt.asListenableFuture$default(kg.h.async$default(h0.CoroutineScope(s0.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, uri, inputEvent, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public c<h> registerTriggerAsync(Uri uri) {
            i.checkNotNullParameter(uri, "trigger");
            return CoroutineAdapterKt.asListenableFuture$default(kg.h.async$default(h0.CoroutineScope(s0.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, uri, null), 3, null), null, 1, null);
        }

        public c<h> registerWebSourceAsync(e2.c cVar) {
            i.checkNotNullParameter(cVar, "request");
            return CoroutineAdapterKt.asListenableFuture$default(kg.h.async$default(h0.CoroutineScope(s0.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, null), 3, null), null, 1, null);
        }

        public c<h> registerWebTriggerAsync(d dVar) {
            i.checkNotNullParameter(dVar, "request");
            return CoroutineAdapterKt.asListenableFuture$default(kg.h.async$default(h0.CoroutineScope(s0.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, null), 3, null), null, 1, null);
        }
    }

    /* compiled from: MeasurementManagerFutures.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final MeasurementManagerFutures from(Context context) {
            i.checkNotNullParameter(context, "context");
            b bVarObtain = b.f11128a.obtain(context);
            if (bVarObtain != null) {
                return new Api33Ext5JavaImpl(bVarObtain);
            }
            return null;
        }
    }

    public static final MeasurementManagerFutures from(Context context) {
        return f3816a.from(context);
    }

    public abstract c<Integer> getMeasurementApiStatusAsync();

    public abstract c<h> registerTriggerAsync(Uri uri);
}
