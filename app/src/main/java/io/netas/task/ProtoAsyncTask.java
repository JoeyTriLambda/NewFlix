package io.netas.task;

import ac.c;
import android.net.SSLCertificateSocketFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.Keep;
import ie.b;
import ie.d;
import ie.e;
import ie.f;
import ie.g;
import ie.h;
import ie.i;
import ie.k;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes2.dex */
public class ProtoAsyncTask extends AsyncTask<String, Void, Long> {

    /* renamed from: m, reason: collision with root package name */
    public static boolean f13509m = false;

    /* renamed from: n, reason: collision with root package name */
    public static byte f13510n;

    /* renamed from: o, reason: collision with root package name */
    public static volatile ConcurrentHashMap f13511o = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f13512a;

    /* renamed from: b, reason: collision with root package name */
    public volatile long f13513b;

    /* renamed from: d, reason: collision with root package name */
    public final int f13515d;

    /* renamed from: j, reason: collision with root package name */
    public Socket f13521j;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f13514c = 0;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<Long, me.a> f13516e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f13517f = false;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f13518g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f13519h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f13520i = 4;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f13522k = true;

    /* renamed from: l, reason: collision with root package name */
    public byte f13523l = 0;

    public class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f13524b;

        public a(byte[] bArr) {
            this.f13524b = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (ProtoAsyncTask.this.f13521j == null) {
                    je.a.b("ProtoAsyncTask", "Failed to send tunnel message to server - socket is null", new Object[0]);
                    return;
                }
                synchronized (this) {
                    ProtoAsyncTask.this.f13521j.getOutputStream().write(this.f13524b);
                    ProtoAsyncTask.this.f13521j.getOutputStream().flush();
                }
            } catch (Exception e10) {
                je.a.b("ProtoAsyncTask", "Failed to send tunnel message %s", e10.getMessage());
            }
        }
    }

    public ProtoAsyncTask(int i10) {
        this.f13515d = i10;
    }

    public static String b(int i10) {
        switch (i10) {
            case 1:
                return "REGISTER";
            case 2:
            default:
                return null;
            case 3:
                return "PING";
            case 4:
                return "PONG";
            case 5:
                return "OPEN_TUNNEL";
            case 6:
                return "TUNNEL_STATUS";
            case 7:
                return "TUNNEL_MESSAGE";
            case 8:
                return "CLOSE_TUNNEL";
            case 9:
                return "STATUS_UPDATE";
            case 10:
                return "GOODBYE_MESSAGE";
        }
    }

    @Keep
    public static ProtoAsyncTask getInstance(int i10) {
        ProtoAsyncTask protoAsyncTask = (ProtoAsyncTask) f13511o.get(Integer.valueOf(i10));
        if (protoAsyncTask != null) {
            je.a.a("ProtoAsyncTask", "call getInstance with existing instance=%d", Integer.valueOf(i10));
            return protoAsyncTask;
        }
        ProtoAsyncTask protoAsyncTask2 = new ProtoAsyncTask(i10);
        je.a.a("ProtoAsyncTask", "call getInstance for new instance=%d", Integer.valueOf(i10));
        f13511o.put(Integer.valueOf(i10), protoAsyncTask2);
        return protoAsyncTask2;
    }

    public int a() {
        HashMap<Long, me.a> map = this.f13516e;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public final void c(int i10, String str, long j10) {
        HashMap<Long, me.a> map = this.f13516e;
        je.a.a("ProtoAsyncTask", "Open new Tunnel for host:%s port:%d tunnelId:%d  - map include %d opened tunnels ", str, Integer.valueOf(i10), Long.valueOf(j10), Integer.valueOf(map.size()));
        if (map.containsKey(Long.valueOf(j10))) {
            je.a.b("ProtoAsyncTask", "Can't Open additonal Tunnel for same tunnel id :%d ", Long.valueOf(j10));
            return;
        }
        me.a aVar = new me.a(str, i10, j10, this.f13515d);
        map.put(Long.valueOf(j10), aVar);
        new Thread(aVar).start();
    }

    public final void d(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                SNIHostName sNIHostName = new SNIHostName(str);
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(sNIHostName);
                SSLParameters sSLParameters = ((SSLSocket) this.f13521j).getSSLParameters();
                sSLParameters.setServerNames(arrayList);
                ((SSLSocket) this.f13521j).setSSLParameters(sSLParameters);
            } else {
                ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0)).setHostname(this.f13521j, str);
            }
        } catch (Exception e10) {
            je.a.b("ProtoAsyncTask", "Failed to attachServerName2SSLSocket: %s - ex: %s ", str, e10.getMessage());
        }
    }

    public final void e(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, boolean z11, String str8, String str9, String[] strArr) throws InterruptedException, IOException {
        String[] strArrSplit;
        int i10;
        if (strArr == null) {
            return;
        }
        int i11 = 1;
        this.f13517f = true;
        f13509m = z11;
        while (this.f13517f) {
            for (String str10 : strArr) {
                for (int i12 = 0; i12 < this.f13520i; i12++) {
                    try {
                        strArrSplit = str10.split(":");
                        InetAddress byName = InetAddress.getByName(strArrSplit[0]);
                        i10 = strArrSplit.length > i11 ? Integer.parseInt(strArrSplit[i11]) : 6000;
                        try {
                            je.a.a("ProtoAsyncTask", "TCP Client Connecting... %s:%s", strArrSplit[0], Integer.valueOf(i10));
                            if (this.f13522k) {
                                je.a.a("ProtoAsyncTask", "Trying to create SSL socket... %s:%s", byName.toString(), Integer.valueOf(i10));
                                this.f13521j = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(byName, i10);
                                d(strArrSplit[0]);
                            } else {
                                je.a.a("ProtoAsyncTask", "Trying to create regular socket... %s:%s", byName.toString(), Integer.valueOf(i10));
                                Socket socket = new Socket(byName, i10);
                                this.f13521j = socket;
                                socket.setSoTimeout(2000);
                            }
                        } catch (Exception e10) {
                            e = e10;
                            i11 = 1;
                            Object[] objArr = new Object[i11];
                            objArr[0] = e.getMessage();
                            je.a.b("ProtoAsyncTask", "TCP Socket init error: %s ", objArr);
                            try {
                                TimeUnit.SECONDS.sleep(i12 * 10);
                                i11 = 1;
                            } catch (InterruptedException e11) {
                                i11 = 1;
                                je.a.b("ProtoAsyncTask", "sleep exception error: %s ", e11.getMessage());
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                    }
                    try {
                        try {
                            je.a.a("ProtoAsyncTask", "Send Register Message to %s:%s with params: pub = %s, isWifi = %b", strArrSplit[0], Integer.valueOf(i10), str5, Boolean.valueOf(f13509m));
                            d(new h(str, str2, str3, str4, str5, str6, str7, z10, f13509m, f13510n, str8, str9).c());
                            this.f13521j.setSoTimeout(5000);
                            byte[] bArrF = f(this.f13521j);
                            this.f13521j.setSoTimeout(0);
                            if (bArrF != null) {
                                g gVar = new g(bArrF, new ie.a(bArrF).a());
                                if (!gVar.c()) {
                                    je.a.b("ProtoAsyncTask", "Wrong State - Received Message type: " + gVar.b() + "msg: " + Arrays.toString(bArrF), new Object[0]);
                                    throw new Exception("Wrong State - Received Message type: " + gVar.b() + "msg: " + Arrays.toString(bArrF));
                                }
                                je.a.a("ProtoAsyncTask", "Received Register Reply Message from server", new Object[0]);
                                while (this.f13517f) {
                                    byte[] bArrF2 = f(this.f13521j);
                                    if (bArrF2 != null) {
                                        a(bArrF2);
                                    }
                                }
                            }
                            this.f13521j.close();
                        } catch (Exception e13) {
                            je.a.b("ProtoAsyncTask", "Register or Fatal Error %s", e13.getMessage());
                            this.f13521j.close();
                        }
                        TimeUnit.SECONDS.sleep(i12 * 10);
                        i11 = 1;
                    } catch (Throwable th2) {
                        this.f13521j.close();
                        TimeUnit.SECONDS.sleep(i12 * 10);
                        throw th2;
                    }
                }
            }
        }
        je.a.d("ProtoAsyncTask", "Finish client-server protocol on async task ", new Object[0]);
    }

    public final byte[] f(Socket socket) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int i10 = dataInputStream.readInt();
        int i11 = dataInputStream.readInt();
        if (i10 == -1 || i11 == -1) {
            return null;
        }
        byte[] bArrArray = ByteBuffer.allocate(i11).putInt(i10).putInt(i11).array();
        int i12 = 8;
        for (int i13 = 0; i12 < i11 && i13 < 10; i13++) {
            i12 += socket.getInputStream().read(bArrArray, i12, i11 - i12);
        }
        if (i12 != i11) {
            throw new Exception(c.g("Error actual read length ", i12, " !=  expected length ", i11));
        }
        this.f13518g = SystemClock.uptimeMillis();
        return bArrArray;
    }

    public void i() {
        this.f13520i = 0;
        this.f13512a = false;
        this.f13517f = false;
    }

    public long a(TimeUnit timeUnit) {
        if (this.f13512a) {
            return TimeUnit.MILLISECONDS.convert(System.currentTimeMillis() - this.f13513b, timeUnit);
        }
        return 0L;
    }

    public void b() {
        je.a.a("ProtoAsyncTask", "Goodby :( ", new Object[0]);
        i();
        cancel(true);
    }

    public void c(byte[] bArr) {
        new a(bArr).start();
    }

    public void d(byte[] bArr) {
        int i10 = this.f13515d;
        try {
            je.a.a("ProtoAsyncTask", "Send Message To Server %d - Type: %s len:%d ", Integer.valueOf(i10), b(new ie.a(bArr).b()), Integer.valueOf(bArr.length));
            b(bArr);
        } catch (Exception e10) {
            je.a.b("ProtoAsyncTask", "Failed to Send Protocol Message To Server %d - ex: %s ", Integer.valueOf(i10), e10.getMessage());
        }
    }

    public boolean e() {
        if (!this.f13517f) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.f13518g > DateUtils.MILLIS_PER_MINUTE) {
            this.f13518g = jUptimeMillis;
            int i10 = this.f13515d;
            try {
                e eVar = new e();
                byte[] bArrC = eVar.c();
                je.a.a("ProtoAsyncTask", "Send Message To Server %d - Type: %s len:%d ", Integer.valueOf(i10), b(eVar.b()), Integer.valueOf(bArrC.length));
                c(bArrC);
                this.f13519h = eVar.d();
            } catch (Exception unused) {
                je.a.b("ProtoAsyncTask", "Failed to send ping message server %d - socket might be null", Integer.valueOf(i10));
            }
        }
        long j10 = jUptimeMillis - this.f13514c;
        long j11 = DateUtils.MILLIS_PER_HOUR;
        if (j10 > DateUtils.MILLIS_PER_HOUR) {
            je.a.a("ProtoAsyncTask", "Clean Old Session Current: %d , last: %d", Long.valueOf(jUptimeMillis), Long.valueOf(this.f13514c));
            je.a.a("ProtoAsyncTask", "check for non active tunnels....", new Object[0]);
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            for (Map.Entry<Long, me.a> entry : this.f13516e.entrySet()) {
                if (jUptimeMillis2 - entry.getValue().a() > j11) {
                    je.a.d("ProtoAsyncTask", "Kill old tunnel %d session after an hour of no activity", entry.getKey());
                    a(entry.getKey().longValue());
                    j11 = DateUtils.MILLIS_PER_HOUR;
                }
            }
            this.f13514c = jUptimeMillis;
        }
        byte b10 = this.f13523l;
        byte b11 = f13510n;
        if (b10 != b11) {
            this.f13523l = b11;
            int i11 = this.f13515d;
            try {
                i iVar = new i();
                byte[] bArrA = iVar.a(f13510n);
                je.a.a("ProtoAsyncTask", "Send Message To Server %d - Type: %s len:%d ", Integer.valueOf(i11), b(iVar.b()), Integer.valueOf(bArrA.length));
                c(bArrA);
            } catch (Exception unused2) {
                je.a.b("ProtoAsyncTask", "Failed to send status update message server %d - socket might be null", Integer.valueOf(i11));
            }
        }
        return true;
    }

    public static void b(boolean z10) {
        f13509m = z10;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(String... strArr) throws Throwable {
        boolean z10;
        long jCurrentTimeMillis;
        if (strArr.length < 6) {
            je.a.b("ProtoAsyncTask", "Can't start server registration! num of params is %d => less than expected 4", Integer.valueOf(strArr.length));
            jCurrentTimeMillis = 0;
        } else {
            this.f13513b = System.currentTimeMillis();
            this.f13512a = true;
            je.a.c("ProtoAsyncTask", "Starting client protocol %s", Arrays.toString(strArr));
            try {
                z10 = false;
            } catch (Throwable th2) {
                th = th2;
                z10 = false;
            }
            try {
                e(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], Boolean.parseBoolean(strArr[7]), Boolean.parseBoolean(strArr[8]), strArr[9], strArr[10], (String[]) Arrays.copyOfRange(strArr, 11, strArr.length));
                this.f13512a = false;
                je.a.c("ProtoAsyncTask", "Released client thread", new Object[0]);
                jCurrentTimeMillis = System.currentTimeMillis() - this.f13513b;
            } catch (Throwable th3) {
                th = th3;
                this.f13512a = z10;
                throw th;
            }
        }
        return Long.valueOf(jCurrentTimeMillis);
    }

    public boolean c() {
        if (this.f13521j != null) {
            return !r0.isClosed();
        }
        return false;
    }

    public boolean d() {
        return this.f13512a;
    }

    public void a(long j10) {
        HashMap<Long, me.a> map = this.f13516e;
        if (!map.containsKey(Long.valueOf(j10))) {
            je.a.a("ProtoAsyncTask", "Can't Close non existed tunnel id:%d ", Long.valueOf(j10));
            return;
        }
        je.a.a("ProtoAsyncTask", "Close tunnel id:%d", Long.valueOf(j10));
        me.a aVar = map.get(Long.valueOf(j10));
        Objects.requireNonNull(aVar);
        aVar.b();
        map.remove(Long.valueOf(j10));
    }

    public void b(byte[] bArr) {
        try {
            if (this.f13521j == null) {
                je.a.b("ProtoAsyncTask", "Failed to send tunnel message to server - socket is null", new Object[0]);
                return;
            }
            synchronized (this) {
                this.f13521j.getOutputStream().write(bArr);
                this.f13521j.getOutputStream().flush();
            }
        } catch (Exception e10) {
            je.a.b("ProtoAsyncTask", "Failed to send tunnel message %s", e10.getMessage());
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l10) {
        je.a.c("ProtoAsyncTask", "Executed Proto async task for %ss", Double.valueOf(l10.longValue() / 1000.0d));
    }

    public static void a(boolean z10) {
        f13510n = z10 ? (byte) 1 : (byte) 0;
    }

    public void a(byte[] bArr) {
        try {
            if (bArr.length < 8) {
                return;
            }
            ie.a aVar = new ie.a(bArr);
            je.a.a("ProtoAsyncTask", "Received Message From Server %d - Type: %s", Integer.valueOf(this.f13515d), b(aVar.b()));
            int iB = aVar.b();
            if (iB == 3) {
                e eVar = new e(bArr);
                if (eVar.e()) {
                    d(new f().a(eVar.d()));
                    return;
                }
                return;
            }
            if (iB == 4) {
                new f(bArr).b(this.f13519h);
                return;
            }
            if (iB == 5) {
                d dVar = new d(bArr);
                if (dVar.f()) {
                    c(dVar.d(), dVar.c(), dVar.e());
                    return;
                }
                return;
            }
            if (iB == 7) {
                k kVar = new k(bArr);
                if (kVar.e()) {
                    long jD = kVar.d();
                    byte[] bArrC = kVar.c();
                    HashMap<Long, me.a> map = this.f13516e;
                    if (map.containsKey(Long.valueOf(jD))) {
                        me.a aVar2 = map.get(Long.valueOf(jD));
                        Objects.requireNonNull(aVar2);
                        aVar2.b(bArrC);
                    } else {
                        je.a.b("ProtoAsyncTask", "Can't send data to non existed tunnel id:%d ", Long.valueOf(jD));
                    }
                }
            } else {
                if (iB == 8) {
                    b bVar = new b(bArr);
                    if (bVar.d()) {
                        a(bVar.c());
                        return;
                    }
                    return;
                }
                if (iB != 10) {
                    return;
                }
            }
            if (new ie.c(bArr).c()) {
                b();
            }
        } catch (Exception e10) {
            je.a.b("ProtoAsyncTask", "handleMessageFromServer error %s, %s ", e10.getMessage(), e10.toString());
        }
    }

    public void a(byte[] bArr, long j10) {
        if (je.a.a("ProtoAsyncTask", 5)) {
            je.a.a("ProtoAsyncTask", "Send tunnel id:%d len:%d Message To Server - Type: %s ", Long.valueOf(j10), Integer.valueOf(bArr.length), b(new ie.a(bArr).b()));
        }
        b(bArr);
    }
}
