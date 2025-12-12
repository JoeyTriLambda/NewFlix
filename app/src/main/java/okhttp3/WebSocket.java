package okhttp3;

import okio.ByteString;

/* compiled from: WebSocket.kt */
/* loaded from: classes2.dex */
public interface WebSocket {

    /* compiled from: WebSocket.kt */
    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i10, String str);

    long queueSize();

    Request request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
