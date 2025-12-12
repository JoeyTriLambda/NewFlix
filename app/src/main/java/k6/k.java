package k6;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import l6.u;

/* compiled from: DefaultHttpDataSource.java */
/* loaded from: classes.dex */
public final class k implements d {

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f14993p = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicReference<byte[]> f14994q = new AtomicReference<>();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14995a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14996b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14997c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14998d;

    /* renamed from: e, reason: collision with root package name */
    public final l f14999e;

    /* renamed from: f, reason: collision with root package name */
    public final l f15000f = new l();

    /* renamed from: g, reason: collision with root package name */
    public final n<? super k> f15001g;

    /* renamed from: h, reason: collision with root package name */
    public f f15002h;

    /* renamed from: i, reason: collision with root package name */
    public HttpURLConnection f15003i;

    /* renamed from: j, reason: collision with root package name */
    public InputStream f15004j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15005k;

    /* renamed from: l, reason: collision with root package name */
    public long f15006l;

    /* renamed from: m, reason: collision with root package name */
    public long f15007m;

    /* renamed from: n, reason: collision with root package name */
    public long f15008n;

    /* renamed from: o, reason: collision with root package name */
    public long f15009o;

    public k(String str, l6.n<String> nVar, n<? super k> nVar2, int i10, int i11, boolean z10, l lVar) {
        this.f14998d = l6.a.checkNotEmpty(str);
        this.f15001g = nVar2;
        this.f14996b = i10;
        this.f14997c = i11;
        this.f14995a = z10;
        this.f14999e = lVar;
    }

    public static void d(HttpURLConnection httpURLConnection, long j10) throws IllegalAccessException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10 = u.f15907a;
        if (i10 == 19 || i10 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j10 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j10 <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a() {
        HttpURLConnection httpURLConnection = this.f15003i;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e10);
            }
            this.f15003i = null;
        }
    }

    public final HttpURLConnection b(URL url, byte[] bArr, long j10, long j11, boolean z10, boolean z11) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f14996b);
        httpURLConnection.setReadTimeout(this.f14997c);
        l lVar = this.f14999e;
        if (lVar != null) {
            for (Map.Entry<String, String> entry : lVar.getSnapshot().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.f15000f.getSnapshot().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j10 != 0 || j11 != -1) {
            String string = "bytes=" + j10 + "-";
            if (j11 != -1) {
                StringBuilder sbR = ac.c.r(string);
                sbR.append((j10 + j11) - 1);
                string = sbR.toString();
            }
            httpURLConnection.setRequestProperty("Range", string);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f14998d);
        if (!z10) {
            httpURLConnection.setRequestProperty("Accept-Encoding", HTTP.IDENTITY_CODING);
        }
        httpURLConnection.setInstanceFollowRedirects(z11);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public final long bytesRemaining() {
        long j10 = this.f15007m;
        return j10 == -1 ? j10 : j10 - this.f15009o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.net.HttpURLConnection c(k6.f r20) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r20
            java.net.URL r1 = new java.net.URL
            android.net.Uri r2 = r0.f14959a
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            byte[] r2 = r0.f14960b
            long r12 = r0.f14962d
            long r14 = r0.f14963e
            r3 = 1
            boolean r16 = r0.isFlagSet(r3)
            r11 = r19
            boolean r0 = r11.f14995a
            if (r0 != 0) goto L2a
            r8 = 1
            r0 = r19
            r3 = r12
            r5 = r14
            r7 = r16
            java.net.HttpURLConnection r0 = r0.b(r1, r2, r3, r5, r7, r8)
            return r0
        L2a:
            r0 = 0
        L2b:
            int r10 = r0 + 1
            r3 = 20
            if (r0 > r3) goto La3
            r0 = 0
            r3 = r19
            r4 = r1
            r5 = r2
            r6 = r12
            r8 = r14
            r17 = r12
            r12 = r10
            r10 = r16
            r11 = r0
            java.net.HttpURLConnection r0 = r3.b(r4, r5, r6, r8, r10, r11)
            int r3 = r0.getResponseCode()
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 == r4) goto L62
            r4 = 301(0x12d, float:4.22E-43)
            if (r3 == r4) goto L62
            r4 = 302(0x12e, float:4.23E-43)
            if (r3 == r4) goto L62
            r4 = 303(0x12f, float:4.25E-43)
            if (r3 == r4) goto L62
            if (r2 != 0) goto L61
            r2 = 307(0x133, float:4.3E-43)
            if (r3 == r2) goto L62
            r2 = 308(0x134, float:4.32E-43)
            if (r3 != r2) goto L61
            goto L62
        L61:
            return r0
        L62:
            java.lang.String r2 = "Location"
            java.lang.String r2 = r0.getHeaderField(r2)
            r0.disconnect()
            if (r2 == 0) goto L9b
            java.net.URL r0 = new java.net.URL
            r0.<init>(r1, r2)
            java.lang.String r1 = r0.getProtocol()
            java.lang.String r2 = "https"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L93
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L87
            goto L93
        L87:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r2 = "Unsupported protocol redirect: "
            java.lang.String r1 = ac.c.j(r2, r1)
            r0.<init>(r1)
            throw r0
        L93:
            r2 = 0
            r11 = r19
            r1 = r0
            r0 = r12
            r12 = r17
            goto L2b
        L9b:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)
            throw r0
        La3:
            r12 = r10
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException
            java.lang.String r1 = "Too many redirects: "
            java.lang.String r1 = ac.c.f(r1, r12)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.k.c(k6.f):java.net.HttpURLConnection");
    }

    @Override // k6.d
    public void close() throws HttpDataSource$HttpDataSourceException {
        n<? super k> nVar = this.f15001g;
        try {
            if (this.f15004j != null) {
                d(this.f15003i, bytesRemaining());
                try {
                    this.f15004j.close();
                } catch (IOException e10) {
                    throw new HttpDataSource$HttpDataSourceException(e10, this.f15002h, 3);
                }
            }
        } finally {
            this.f15004j = null;
            a();
            if (this.f15005k) {
                this.f15005k = false;
                if (nVar != null) {
                    ((h) nVar).onTransferEnd(this);
                }
            }
        }
    }

    public final void e() throws IOException {
        if (this.f15008n == this.f15006l) {
            return;
        }
        AtomicReference<byte[]> atomicReference = f14994q;
        byte[] andSet = atomicReference.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j10 = this.f15008n;
            long j11 = this.f15006l;
            if (j10 == j11) {
                atomicReference.set(andSet);
                return;
            }
            int i10 = this.f15004j.read(andSet, 0, (int) Math.min(j11 - j10, andSet.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (i10 == -1) {
                throw new EOFException();
            }
            this.f15008n += i10;
            n<? super k> nVar = this.f15001g;
            if (nVar != null) {
                ((h) nVar).onBytesTransferred(this, i10);
            }
        }
    }

    @Override // k6.d
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f15003i;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    @Override // k6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long open(k6.f r20) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.k.open(k6.f):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[Catch: IOException -> 0x0046, TryCatch #0 {IOException -> 0x0046, blocks: (B:2:0x0000, B:5:0x0007, B:7:0x0010, B:10:0x001b, B:11:0x0021, B:13:0x0029, B:16:0x0030, B:17:0x0035, B:18:0x0036, B:20:0x0040), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: IOException -> 0x0046, TryCatch #0 {IOException -> 0x0046, blocks: (B:2:0x0000, B:5:0x0007, B:7:0x0010, B:10:0x001b, B:11:0x0021, B:13:0x0029, B:16:0x0030, B:17:0x0035, B:18:0x0036, B:20:0x0040), top: B:25:0x0000 }] */
    @Override // k6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            r8.e()     // Catch: java.io.IOException -> L46
            if (r11 != 0) goto L7
            r9 = 0
            goto L45
        L7:
            long r0 = r8.f15007m     // Catch: java.io.IOException -> L46
            r2 = -1
            r4 = -1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L21
            long r5 = r8.f15009o     // Catch: java.io.IOException -> L46
            long r0 = r0 - r5
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L1b
        L19:
            r9 = -1
            goto L45
        L1b:
            long r5 = (long) r11     // Catch: java.io.IOException -> L46
            long r0 = java.lang.Math.min(r5, r0)     // Catch: java.io.IOException -> L46
            int r11 = (int) r0     // Catch: java.io.IOException -> L46
        L21:
            java.io.InputStream r0 = r8.f15004j     // Catch: java.io.IOException -> L46
            int r9 = r0.read(r9, r10, r11)     // Catch: java.io.IOException -> L46
            if (r9 != r4) goto L36
            long r9 = r8.f15007m     // Catch: java.io.IOException -> L46
            int r11 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r11 != 0) goto L30
            goto L19
        L30:
            java.io.EOFException r9 = new java.io.EOFException     // Catch: java.io.IOException -> L46
            r9.<init>()     // Catch: java.io.IOException -> L46
            throw r9     // Catch: java.io.IOException -> L46
        L36:
            long r10 = r8.f15009o     // Catch: java.io.IOException -> L46
            long r0 = (long) r9     // Catch: java.io.IOException -> L46
            long r10 = r10 + r0
            r8.f15009o = r10     // Catch: java.io.IOException -> L46
            k6.n<? super k6.k> r10 = r8.f15001g     // Catch: java.io.IOException -> L46
            if (r10 == 0) goto L45
            k6.h r10 = (k6.h) r10     // Catch: java.io.IOException -> L46
            r10.onBytesTransferred(r8, r9)     // Catch: java.io.IOException -> L46
        L45:
            return r9
        L46:
            r9 = move-exception
            com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException r10 = new com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException
            k6.f r11 = r8.f15002h
            r0 = 2
            r10.<init>(r9, r11, r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.k.read(byte[], int, int):int");
    }

    public void setRequestProperty(String str, String str2) {
        l6.a.checkNotNull(str);
        l6.a.checkNotNull(str2);
        this.f15000f.set(str, str2);
    }
}
