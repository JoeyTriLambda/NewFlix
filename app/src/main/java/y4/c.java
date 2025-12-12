package y4;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

/* compiled from: ClientHealthMetricsStore.java */
/* loaded from: classes.dex */
public interface c {
    t4.a loadClientMetrics();

    void recordLogEventDropped(long j10, LogEventDropped.Reason reason, String str);

    void resetClientMetrics();
}
