package w2;

import android.os.Build;
import f3.t;
import java.util.Set;
import java.util.UUID;
import mf.z;

/* compiled from: WorkRequest.kt */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f20885a;

    /* renamed from: b, reason: collision with root package name */
    public final t f20886b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<String> f20887c;

    /* compiled from: WorkRequest.kt */
    public static abstract class a<B extends a<B, ?>, W extends o> {

        /* renamed from: a, reason: collision with root package name */
        public UUID f20888a;

        /* renamed from: b, reason: collision with root package name */
        public t f20889b;

        /* renamed from: c, reason: collision with root package name */
        public final Set<String> f20890c;

        public a(Class<? extends androidx.work.c> cls) {
            zf.i.checkNotNullParameter(cls, "workerClass");
            UUID uuidRandomUUID = UUID.randomUUID();
            zf.i.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            this.f20888a = uuidRandomUUID;
            String string = this.f20888a.toString();
            zf.i.checkNotNullExpressionValue(string, "id.toString()");
            String name = cls.getName();
            zf.i.checkNotNullExpressionValue(name, "workerClass.name");
            this.f20889b = new t(string, name);
            String name2 = cls.getName();
            zf.i.checkNotNullExpressionValue(name2, "workerClass.name");
            this.f20890c = z.mutableSetOf(name2);
        }

        public final W build() {
            W w10 = (W) buildInternal$work_runtime_release();
            w2.b bVar = this.f20889b.f11435j;
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = (i10 >= 24 && bVar.hasContentUriTriggers()) || bVar.requiresBatteryNotLow() || bVar.requiresCharging() || (i10 >= 23 && bVar.requiresDeviceIdle());
            t tVar = this.f20889b;
            if (tVar.f11442q) {
                if (!(!z10)) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
                if (!(tVar.f11432g <= 0)) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            zf.i.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            setId(uuidRandomUUID);
            return w10;
        }

        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return false;
        }

        public final UUID getId$work_runtime_release() {
            return this.f20888a;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.f20890c;
        }

        public abstract B getThisObject$work_runtime_release();

        public final t getWorkSpec$work_runtime_release() {
            return this.f20889b;
        }

        public final B setId(UUID uuid) {
            zf.i.checkNotNullParameter(uuid, "id");
            this.f20888a = uuid;
            String string = uuid.toString();
            zf.i.checkNotNullExpressionValue(string, "id.toString()");
            this.f20889b = new t(string, this.f20889b);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setInputData(androidx.work.b bVar) {
            zf.i.checkNotNullParameter(bVar, "inputData");
            this.f20889b.f11430e = bVar;
            return (B) getThisObject$work_runtime_release();
        }
    }

    /* compiled from: WorkRequest.kt */
    public static final class b {
        public b(zf.f fVar) {
        }
    }

    static {
        new b(null);
    }

    public o(UUID uuid, t tVar, Set<String> set) {
        zf.i.checkNotNullParameter(uuid, "id");
        zf.i.checkNotNullParameter(tVar, "workSpec");
        zf.i.checkNotNullParameter(set, "tags");
        this.f20885a = uuid;
        this.f20886b = tVar;
        this.f20887c = set;
    }

    public UUID getId() {
        return this.f20885a;
    }

    public final String getStringId() {
        String string = getId().toString();
        zf.i.checkNotNullExpressionValue(string, "id.toString()");
        return string;
    }

    public final Set<String> getTags() {
        return this.f20887c;
    }

    public final t getWorkSpec() {
        return this.f20886b;
    }
}
