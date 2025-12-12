package me;

import com.loopj.android.http.AsyncHttpClient;
import ie.k;
import ie.l;
import io.netas.task.ProtoAsyncTask;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public volatile long f16270b;

    /* renamed from: m, reason: collision with root package name */
    public volatile long f16271m;

    /* renamed from: n, reason: collision with root package name */
    public volatile long f16272n;

    /* renamed from: o, reason: collision with root package name */
    public final long f16273o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f16274p = false;

    /* renamed from: q, reason: collision with root package name */
    public Socket f16275q;

    /* renamed from: r, reason: collision with root package name */
    public final String f16276r;

    /* renamed from: s, reason: collision with root package name */
    public final int f16277s;

    /* renamed from: t, reason: collision with root package name */
    public final int f16278t;

    public a(String str, int i10, long j10, int i11) {
        this.f16273o = 0L;
        this.f16273o = j10;
        this.f16277s = i10;
        this.f16276r = str;
        this.f16278t = i11;
    }

    public static boolean d(InetAddress inetAddress) throws UnknownHostException {
        try {
            InetAddress byAddress = InetAddress.getByAddress(inetAddress.getAddress());
            return !(byAddress.isSiteLocalAddress() || byAddress.isLoopbackAddress());
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public long a() {
        return this.f16271m;
    }

    public final void b(byte b10) {
        long j10 = this.f16273o;
        je.a.a("a", "Send Tunnel Status To Server: %s   on tunnel id:%d ", l.a(b10), Long.valueOf(j10));
        ProtoAsyncTask.getInstance(this.f16278t).a(new l().a(j10, b10), j10);
    }

    public final void c(String str, int i10) throws IOException {
        Socket socket;
        int i11 = this.f16278t;
        long j10 = this.f16273o;
        if (str == null || i10 <= 0) {
            return;
        }
        this.f16274p = true;
        try {
            je.a.a("a", "TCP Client Connecting...");
            InetAddress byName = InetAddress.getByName(str);
            d(byName);
            if (!d(byName)) {
                je.a.b("a", "Hacking? The Host Resolved Ip is " + byName + " on tunnel id:" + j10, new Object[0]);
                throw new IllegalArgumentException("Hacking? The tunnel host resolved ip is internal");
            }
            this.f16275q = new Socket(byName, i10);
            try {
                try {
                    je.a.a("a", "TCP tunnel connected to %s:%s", str, Integer.valueOf(i10));
                    b((byte) 1);
                    while (this.f16274p) {
                        byte[] bArrE = e(this.f16275q);
                        if (bArrE != null) {
                            a(bArrE);
                        } else {
                            je.a.a("a", "read() got -1 -> it might be ok", new Object[0]);
                            b((byte) 3);
                            ProtoAsyncTask.getInstance(i11).a(j10);
                            this.f16274p = false;
                        }
                    }
                    je.a.a("a", "Close Socket On tunnel id:%d", Long.valueOf(j10));
                    socket = this.f16275q;
                    if (socket == null) {
                        return;
                    }
                } catch (Exception e10) {
                    je.a.b("a", "Tunnel Connection Error", e10.getMessage());
                    b((byte) 3);
                    ProtoAsyncTask.getInstance(i11).a(j10);
                    e10.printStackTrace();
                    je.a.a("a", "Close Socket On tunnel id:%d", Long.valueOf(j10));
                    socket = this.f16275q;
                    if (socket == null) {
                        return;
                    }
                }
                socket.close();
            } catch (Throwable th2) {
                je.a.a("a", "Close Socket On tunnel id:%d", Long.valueOf(j10));
                Socket socket2 = this.f16275q;
                if (socket2 != null) {
                    socket2.close();
                }
                throw th2;
            }
        } catch (Exception e11) {
            b((byte) 2);
            je.a.b("a", "TCP Socket init error %s ", e11.getMessage());
            ProtoAsyncTask.getInstance(i11).a(j10);
        }
    }

    public final byte[] e(Socket socket) throws IOException {
        byte[] bArr;
        int i10;
        try {
            int i11 = socket.getInputStream().read();
            if (i11 != -1) {
                int iAvailable = socket.getInputStream().available();
                if (iAvailable > 10000) {
                    iAvailable = AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT;
                }
                bArr = new byte[iAvailable + 1];
                bArr[0] = (byte) i11;
                i10 = socket.getInputStream().read(bArr, 1, iAvailable);
            } else {
                bArr = null;
                i10 = -1;
            }
            if (i10 == -1) {
                return null;
            }
            return bArr;
        } catch (Exception e10) {
            je.a.b("a", "readResponse exception on tunnelid:%d ex: %s ", Long.valueOf(this.f16273o), e10.toString());
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f16272n = 0L;
            this.f16270b = System.currentTimeMillis();
            je.a.a("a", "Starting tunnel client %s:%d on tunnel id:%d", this.f16276r, Integer.valueOf(this.f16277s), Long.valueOf(this.f16273o));
            c(this.f16276r, this.f16277s);
        } catch (Exception unused) {
            je.a.b("a", "Exception on specific tunnel id:%d -  %s:%d ", this.f16276r, Integer.valueOf(this.f16277s), Long.valueOf(this.f16273o));
        }
        this.f16272n = System.currentTimeMillis() - this.f16270b;
        je.a.a("a", "Released Tunnel client thread, activity time: %d ", Long.valueOf(this.f16272n));
    }

    public void a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("Received Message From Peer on tunnel id:");
        long j10 = this.f16273o;
        sb2.append(String.valueOf(j10));
        je.a.a("a", sb2.toString());
        if (bArr == null) {
            return;
        }
        try {
            byte[] bArrA = new k().a(j10, bArr);
            if (bArrA.length > bArr.length + 32) {
                je.a.b("a", "FATAL ERROR AFTER BUILD TUNNEL MESSAGE", new Object[0]);
            }
            ProtoAsyncTask.getInstance(this.f16278t).a(bArrA, j10);
        } catch (Exception e10) {
            je.a.a("a", "Failed Sending Message from peer tunnel id:%d , error: %s", Long.valueOf(j10), e10.getMessage());
        }
    }

    public void b() {
        this.f16274p = false;
    }

    public void b(byte[] bArr) {
        try {
            je.a.a("a", "Send Message To Peer on tunnel id: " + String.valueOf(this.f16273o));
            Socket socket = this.f16275q;
            if (socket != null) {
                socket.getOutputStream().write(bArr);
                this.f16275q.getOutputStream().flush();
            }
            this.f16271m = System.currentTimeMillis();
        } catch (Exception e10) {
            je.a.b("a", "Failed to send tunnel message to peer - socket might be null: %s", e10.toString());
        }
    }
}
