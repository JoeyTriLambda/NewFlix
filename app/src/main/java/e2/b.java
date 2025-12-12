package e2;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import kg.m;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import lf.h;
import zf.f;
import zf.i;

/* compiled from: MeasurementManager.kt */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0135b f11128a = new C0135b(null);

    /* compiled from: MeasurementManager.kt */
    /* renamed from: e2.b$b, reason: collision with other inner class name */
    public static final class C0135b {
        public C0135b(f fVar) {
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final b obtain(Context context) {
            i.checkNotNullParameter(context, "context");
            StringBuilder sb2 = new StringBuilder("AdServicesInfo.version=");
            d2.a aVar = d2.a.f10789a;
            sb2.append(aVar.version());
            Log.d("MeasurementManager", sb2.toString());
            if (aVar.version() >= 5) {
                return new a(context);
            }
            return null;
        }
    }

    public abstract Object deleteRegistrations(e2.a aVar, qf.c<? super h> cVar);

    public abstract Object getMeasurementApiStatus(qf.c<? super Integer> cVar);

    public abstract Object registerSource(Uri uri, InputEvent inputEvent, qf.c<? super h> cVar);

    public abstract Object registerTrigger(Uri uri, qf.c<? super h> cVar);

    public abstract Object registerWebSource(c cVar, qf.c<? super h> cVar2);

    public abstract Object registerWebTrigger(d dVar, qf.c<? super h> cVar);

    /* compiled from: MeasurementManager.kt */
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public final MeasurementManager f11129b;

        public a(MeasurementManager measurementManager) {
            i.checkNotNullParameter(measurementManager, "mMeasurementManager");
            this.f11129b = measurementManager;
        }

        public static final DeletionRequest access$convertDeletionRequest(a aVar, e2.a aVar2) {
            aVar.getClass();
            new DeletionRequest.Builder();
            throw null;
        }

        public static final WebSourceRegistrationRequest access$convertWebSourceRequest(a aVar, c cVar) {
            aVar.getClass();
            throw null;
        }

        public static final WebTriggerRegistrationRequest access$convertWebTriggerRequest(a aVar, d dVar) {
            aVar.getClass();
            throw null;
        }

        @Override // e2.b
        public Object deleteRegistrations(e2.a aVar, qf.c<? super h> cVar) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
            mVar.initCancellability();
            this.f11129b.deleteRegistrations(access$convertDeletionRequest(this, aVar), new y.a(7), androidx.core.os.a.asOutcomeReceiver(mVar));
            Object result = mVar.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar);
            }
            return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
        }

        @Override // e2.b
        public Object getMeasurementApiStatus(qf.c<? super Integer> cVar) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
            mVar.initCancellability();
            this.f11129b.getMeasurementApiStatus(new y.a(2), androidx.core.os.a.asOutcomeReceiver(mVar));
            Object result = mVar.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar);
            }
            return result;
        }

        @Override // e2.b
        public Object registerSource(Uri uri, InputEvent inputEvent, qf.c<? super h> cVar) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
            mVar.initCancellability();
            this.f11129b.registerSource(uri, inputEvent, new y.a(6), androidx.core.os.a.asOutcomeReceiver(mVar));
            Object result = mVar.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar);
            }
            return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
        }

        @Override // e2.b
        public Object registerTrigger(Uri uri, qf.c<? super h> cVar) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
            mVar.initCancellability();
            this.f11129b.registerTrigger(uri, new y.a(3), androidx.core.os.a.asOutcomeReceiver(mVar));
            Object result = mVar.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar);
            }
            return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
        }

        @Override // e2.b
        public Object registerWebSource(c cVar, qf.c<? super h> cVar2) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar2), 1);
            mVar.initCancellability();
            this.f11129b.registerWebSource(access$convertWebSourceRequest(this, cVar), new y.a(5), androidx.core.os.a.asOutcomeReceiver(mVar));
            Object result = mVar.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar2);
            }
            return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
        }

        @Override // e2.b
        public Object registerWebTrigger(d dVar, qf.c<? super h> cVar) {
            m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
            mVar.initCancellability();
            this.f11129b.registerWebTrigger(access$convertWebTriggerRequest(this, dVar), new y.a(4), androidx.core.os.a.asOutcomeReceiver(mVar));
            Object result = mVar.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar);
            }
            return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Context context) {
            i.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService((Class<Object>) MeasurementManager.class);
            i.checkNotNullExpressionValue(systemService, "context.getSystemService…:class.java\n            )");
            this((MeasurementManager) systemService);
        }
    }
}
