package okhttp3;

import ah.z;
import java.io.IOException;

/* compiled from: Call.kt */
/* loaded from: classes2.dex */
public interface Call extends Cloneable {

    /* compiled from: Call.kt */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    z timeout();
}
