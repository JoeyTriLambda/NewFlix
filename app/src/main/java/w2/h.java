package w2;

import android.os.Build;
import androidx.work.OverwritingInputMerger;
import w2.o;

/* compiled from: OneTimeWorkRequest.kt */
/* loaded from: classes.dex */
public final class h extends o {

    /* renamed from: d, reason: collision with root package name */
    public static final b f20881d = new b(null);

    /* compiled from: OneTimeWorkRequest.kt */
    public static final class a extends o.a<a, h> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<? extends androidx.work.c> cls) {
            super(cls);
            zf.i.checkNotNullParameter(cls, "workerClass");
            getWorkSpec$work_runtime_release().f11429d = OverwritingInputMerger.class.getName();
        }

        @Override // w2.o.a
        public a getThisObject$work_runtime_release() {
            return this;
        }

        @Override // w2.o.a
        public h buildInternal$work_runtime_release() {
            if ((getBackoffCriteriaSet$work_runtime_release() && Build.VERSION.SDK_INT >= 23 && getWorkSpec$work_runtime_release().f11435j.requiresDeviceIdle()) ? false : true) {
                return new h(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        }
    }

    /* compiled from: OneTimeWorkRequest.kt */
    public static final class b {
        public b(zf.f fVar) {
        }

        public final h from(Class<? extends androidx.work.c> cls) {
            zf.i.checkNotNullParameter(cls, "workerClass");
            return new a(cls).build();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(a aVar) {
        super(aVar.getId$work_runtime_release(), aVar.getWorkSpec$work_runtime_release(), aVar.getTags$work_runtime_release());
        zf.i.checkNotNullParameter(aVar, "builder");
    }

    public static final h from(Class<? extends androidx.work.c> cls) {
        return f20881d.from(cls);
    }
}
