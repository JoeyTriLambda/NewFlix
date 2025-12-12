package o8;

import t8.g0;

/* compiled from: CrashlyticsNativeComponent.java */
/* loaded from: classes.dex */
public interface a {
    f getSessionFileProvider(String str);

    boolean hasCrashDataForCurrentSession();

    boolean hasCrashDataForSession(String str);

    void prepareNativeSession(String str, String str2, long j10, g0 g0Var);
}
