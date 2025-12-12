package q4;

import android.annotation.SuppressLint;
import com.google.android.datatransport.Priority;

/* compiled from: ForcedSender.java */
/* loaded from: classes.dex */
public final class k {
    @SuppressLint({"DiscouragedApi"})
    public static void sendBlocking(n4.e<?> eVar, Priority priority) {
        if (!(eVar instanceof q)) {
            u4.a.w("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", eVar);
        } else {
            s.getInstance().getUploader().logAndUpdateState(((q) eVar).f17871a.withPriority(priority), 1);
        }
    }
}
