package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.Session;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public interface SessionManagerListener<T extends Session> {
    void onSessionEnded(T t10, int i10);

    void onSessionEnding(T t10);

    void onSessionResumeFailed(T t10, int i10);

    void onSessionResumed(T t10, boolean z10);

    void onSessionResuming(T t10, String str);

    void onSessionStartFailed(T t10, int i10);

    void onSessionStarted(T t10, String str);

    void onSessionStarting(T t10);

    void onSessionSuspended(T t10, int i10);
}
