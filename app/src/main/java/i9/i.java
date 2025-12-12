package i9;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final long f13351b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f13352c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d, reason: collision with root package name */
    public static i f13353d;

    /* renamed from: a, reason: collision with root package name */
    public final m9.a f13354a;

    public i(m9.a aVar) {
        this.f13354a = aVar;
    }

    public static i getInstance() {
        return getInstance(m9.b.getInstance());
    }

    public long currentTimeInMillis() {
        return ((m9.b) this.f13354a).currentTimeMillis();
    }

    public long currentTimeInSecs() {
        return TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis());
    }

    public long getRandomDelayForSyncPrevention() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean isAuthTokenExpired(com.google.firebase.installations.local.b bVar) {
        if (TextUtils.isEmpty(bVar.getAuthToken())) {
            return true;
        }
        return bVar.getExpiresInSecs() + bVar.getTokenCreationEpochInSecs() < currentTimeInSecs() + f13351b;
    }

    public static i getInstance(m9.a aVar) {
        if (f13353d == null) {
            f13353d = new i(aVar);
        }
        return f13353d;
    }
}
