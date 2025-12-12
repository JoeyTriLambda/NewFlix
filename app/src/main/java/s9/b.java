package s9;

import android.content.Context;
import android.os.Bundle;
import kotlin.time.DurationUnit;
import lf.h;
import s9.d;
import zf.f;
import zf.i;

/* compiled from: LocalOverrideSettings.kt */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f19176a;

    /* compiled from: LocalOverrideSettings.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
    }

    public b(Context context) {
        i.checkNotNullParameter(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f19176a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // s9.d
    public Double getSamplingRate() {
        Bundle bundle = this.f19176a;
        if (bundle.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(bundle.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // s9.d
    public Boolean getSessionEnabled() {
        Bundle bundle = this.f19176a;
        if (bundle.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(bundle.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // s9.d
    /* renamed from: getSessionRestartTimeout-FghU774 */
    public jg.a mo20getSessionRestartTimeoutFghU774() {
        Bundle bundle = this.f19176a;
        if (bundle.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return jg.a.m33boximpl(jg.c.toDuration(bundle.getInt("firebase_sessions_sessions_restart_timeout"), DurationUnit.SECONDS));
        }
        return null;
    }

    @Override // s9.d
    public Object updateSettings(qf.c<? super h> cVar) {
        return d.a.updateSettings(this, cVar);
    }
}
