package sa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class k extends Handler {
    public k(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        sendMessageDelayed(obtainMessage(), 1000L);
    }
}
