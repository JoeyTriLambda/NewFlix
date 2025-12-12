package okhttp3;

import okio.ByteString;
import zf.i;

/* compiled from: WebSocketListener.kt */
/* loaded from: classes2.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i10, String str) {
        i.checkNotNullParameter(webSocket, "webSocket");
        i.checkNotNullParameter(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i10, String str) {
        i.checkNotNullParameter(webSocket, "webSocket");
        i.checkNotNullParameter(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        i.checkNotNullParameter(webSocket, "webSocket");
        i.checkNotNullParameter(th2, "t");
    }

    public void onMessage(WebSocket webSocket, String str) {
        i.checkNotNullParameter(webSocket, "webSocket");
        i.checkNotNullParameter(str, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        i.checkNotNullParameter(webSocket, "webSocket");
        i.checkNotNullParameter(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        i.checkNotNullParameter(webSocket, "webSocket");
        i.checkNotNullParameter(byteString, "bytes");
    }
}
