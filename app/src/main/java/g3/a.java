package g3;

import android.app.Application;

/* compiled from: ProcessUtils.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12634a = new a();

    public final String getProcessName() {
        String processName = Application.getProcessName();
        zf.i.checkNotNullExpressionValue(processName, "getProcessName()");
        return processName;
    }
}
