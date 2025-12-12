package y1;

import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import l0.n;
import l0.o;
import l0.p;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public final class c extends o.f {

    /* renamed from: b, reason: collision with root package name */
    public int[] f21840b = null;

    /* renamed from: c, reason: collision with root package name */
    public MediaSessionCompat.Token f21841c;

    @Override // l0.o.f
    public void apply(n nVar) {
        if (Build.VERSION.SDK_INT >= 34) {
            a.d(((p) nVar).getBuilder(), a.b(b.a(a.a(), null, 0, null, Boolean.FALSE), this.f21840b, this.f21841c));
        } else {
            a.d(((p) nVar).getBuilder(), a.b(a.a(), this.f21840b, this.f21841c));
        }
    }

    @Override // l0.o.f
    public RemoteViews makeBigContentView(n nVar) {
        return null;
    }

    @Override // l0.o.f
    public RemoteViews makeContentView(n nVar) {
        return null;
    }

    public c setMediaSession(MediaSessionCompat.Token token) {
        this.f21841c = token;
        return this;
    }

    public c setShowActionsInCompactView(int... iArr) {
        this.f21840b = iArr;
        return this;
    }
}
