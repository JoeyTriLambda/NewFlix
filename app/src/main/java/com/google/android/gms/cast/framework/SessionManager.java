package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class SessionManager {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f6393c = new Logger("SessionManager");

    /* renamed from: a, reason: collision with root package name */
    public final zzay f6394a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6395b;

    public SessionManager(zzay zzayVar, Context context) {
        this.f6394a = zzayVar;
        this.f6395b = context;
    }

    public <T extends Session> void addSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class<T> cls) throws NullPointerException {
        if (sessionManagerListener == null) {
            throw new NullPointerException("SessionManagerListener can't be null");
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            this.f6394a.zzi(new zzbj(sessionManagerListener, cls));
        } catch (RemoteException e10) {
            f6393c.d(e10, "Unable to call %s on %s.", "addSessionManagerListener", "zzay");
        }
    }

    public void endCurrentSession(boolean z10) {
        Logger logger = f6393c;
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            logger.i("End session for %s", this.f6395b.getPackageName());
            this.f6394a.zzj(true, z10);
        } catch (RemoteException e10) {
            logger.d(e10, "Unable to call %s on %s.", "endCurrentSession", "zzay");
        }
    }

    public CastSession getCurrentCastSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Session currentSession = getCurrentSession();
        if (currentSession == null || !(currentSession instanceof CastSession)) {
            return null;
        }
        return (CastSession) currentSession;
    }

    public Session getCurrentSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return (Session) ObjectWrapper.unwrap(this.f6394a.zzf());
        } catch (RemoteException e10) {
            f6393c.d(e10, "Unable to call %s on %s.", "getWrappedCurrentSession", "zzay");
            return null;
        }
    }

    public <T extends Session> void removeSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sessionManagerListener == null) {
            return;
        }
        try {
            this.f6394a.zzl(new zzbj(sessionManagerListener, cls));
        } catch (RemoteException e10) {
            f6393c.d(e10, "Unable to call %s on %s.", "removeSessionManagerListener", "zzay");
        }
    }

    public final IObjectWrapper zzb() {
        try {
            return this.f6394a.zzg();
        } catch (RemoteException e10) {
            f6393c.d(e10, "Unable to call %s on %s.", "getWrappedThis", "zzay");
            return null;
        }
    }
}
