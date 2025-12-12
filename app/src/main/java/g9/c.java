package g9;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Set;
import java.util.concurrent.Executor;
import l8.l;
import l8.r;
import t0.n;

/* compiled from: DefaultHeartBeatController.java */
/* loaded from: classes.dex */
public final class c implements f, g {

    /* renamed from: a, reason: collision with root package name */
    public final h9.b<h> f12809a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12810b;

    /* renamed from: c, reason: collision with root package name */
    public final h9.b<o9.h> f12811c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<d> f12812d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f12813e;

    public c() {
        throw null;
    }

    public c(Context context, String str, Set<d> set, h9.b<o9.h> bVar, Executor executor) {
        this.f12809a = new g8.d(context, str);
        this.f12812d = set;
        this.f12813e = executor;
        this.f12811c = bVar;
        this.f12810b = context;
    }

    public static l8.b<c> component() {
        r rVarQualified = r.qualified(k8.a.class, Executor.class);
        return l8.b.builder(c.class, f.class, g.class).add(l.required((Class<?>) Context.class)).add(l.required((Class<?>) g8.f.class)).add(l.setOf(d.class)).add(l.requiredProvider((Class<?>) o9.h.class)).add(l.required((r<?>) rVarQualified)).factory(new n8.d(rVarQualified, 1)).build();
    }

    @Override // g9.f
    public Task<String> getHeartBeatsHeader() {
        if (!n.isUserUnlocked(this.f12810b)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.f12813e, new b(this, 1));
    }

    public Task<Void> registerHeartBeat() {
        if (this.f12812d.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!n.isUserUnlocked(this.f12810b)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.f12813e, new b(this, 0));
    }
}
