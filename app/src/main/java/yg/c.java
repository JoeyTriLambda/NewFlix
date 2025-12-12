package yg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import zf.i;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public DatagramSocket f22541a;

    public c() {
        DatagramSocket datagramSocket = this.f22541a;
        if (datagramSocket != null) {
            datagramSocket.isConnected();
        }
    }

    public final byte[] a() throws IOException {
        byte[] bArr = new byte[2048];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, 2048);
        DatagramSocket datagramSocket = this.f22541a;
        if (datagramSocket != null) {
            datagramSocket.receive(datagramPacket);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, datagramPacket.getLength());
        i.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }
}
