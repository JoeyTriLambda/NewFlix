package cz.msebera.android.httpclient.impl.client;

/* loaded from: classes2.dex */
class SystemClock implements Clock {
    @Override // cz.msebera.android.httpclient.impl.client.Clock
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
