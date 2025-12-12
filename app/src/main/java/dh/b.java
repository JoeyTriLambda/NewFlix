package dh;

import com.loopj.android.http.AsyncHttpClient;
import cz.msebera.android.httpclient.cookie.SM;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

/* compiled from: HttpConnection.java */
/* loaded from: classes2.dex */
public final class b implements Connection {

    /* renamed from: a, reason: collision with root package name */
    public final C0133b f11041a = new C0133b();

    /* renamed from: b, reason: collision with root package name */
    public c f11042b = new c();

    /* compiled from: HttpConnection.java */
    public static abstract class a<T extends Connection.a> implements Connection.a<T> {

        /* renamed from: a, reason: collision with root package name */
        public URL f11043a;

        /* renamed from: b, reason: collision with root package name */
        public Connection.Method f11044b;

        /* renamed from: c, reason: collision with root package name */
        public final LinkedHashMap f11045c = new LinkedHashMap();

        /* renamed from: d, reason: collision with root package name */
        public final LinkedHashMap f11046d = new LinkedHashMap();

        public final List<String> a(String str) {
            f.notNull(str);
            for (Map.Entry entry : this.f11045c.entrySet()) {
                if (str.equalsIgnoreCase((String) entry.getKey())) {
                    return (List) entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[Catch: UnsupportedEncodingException -> 0x0089, TryCatch #0 {UnsupportedEncodingException -> 0x0089, blocks: (B:8:0x001b, B:10:0x0027, B:12:0x002f, B:16:0x003a, B:20:0x0046, B:24:0x004b, B:26:0x004e, B:42:0x007b, B:29:0x0055, B:31:0x005b, B:39:0x0071, B:46:0x0081, B:32:0x005e, B:34:0x0064, B:35:0x0067, B:37:0x006d), top: B:51:0x001b }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0081 A[Catch: UnsupportedEncodingException -> 0x0089, TRY_LEAVE, TryCatch #0 {UnsupportedEncodingException -> 0x0089, blocks: (B:8:0x001b, B:10:0x0027, B:12:0x002f, B:16:0x003a, B:20:0x0046, B:24:0x004b, B:26:0x004e, B:42:0x007b, B:29:0x0055, B:31:0x005b, B:39:0x0071, B:46:0x0081, B:32:0x005e, B:34:0x0064, B:35:0x0067, B:37:0x006d), top: B:51:0x001b }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x007d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public T addHeader(java.lang.String r10, java.lang.String r11) throws java.io.UnsupportedEncodingException {
            /*
                r9 = this;
                dh.f.notEmpty(r10)
                if (r11 != 0) goto L7
                java.lang.String r11 = ""
            L7:
                java.util.List r0 = r9.headers(r10)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L1b
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.LinkedHashMap r1 = r9.f11045c
                r1.put(r10, r0)
            L1b:
                java.lang.String r10 = "ISO-8859-1"
                byte[] r10 = r11.getBytes(r10)     // Catch: java.io.UnsupportedEncodingException -> L89
                int r1 = r10.length     // Catch: java.io.UnsupportedEncodingException -> L89
                r2 = 3
                r3 = 0
                r4 = 1
                if (r1 < r2) goto L4a
                r1 = r10[r3]     // Catch: java.io.UnsupportedEncodingException -> L89
                r1 = r1 & 255(0xff, float:3.57E-43)
                r5 = 239(0xef, float:3.35E-43)
                if (r1 != r5) goto L4a
                r1 = r10[r4]     // Catch: java.io.UnsupportedEncodingException -> L89
                r1 = r1 & 255(0xff, float:3.57E-43)
                r5 = 187(0xbb, float:2.62E-43)
                if (r1 != r5) goto L39
                r1 = 1
                goto L3a
            L39:
                r1 = 0
            L3a:
                r5 = 2
                r5 = r10[r5]     // Catch: java.io.UnsupportedEncodingException -> L89
                r5 = r5 & 255(0xff, float:3.57E-43)
                r6 = 191(0xbf, float:2.68E-43)
                if (r5 != r6) goto L45
                r5 = 1
                goto L46
            L45:
                r5 = 0
            L46:
                r1 = r1 & r5
                if (r1 == 0) goto L4a
                goto L4b
            L4a:
                r2 = 0
            L4b:
                int r1 = r10.length     // Catch: java.io.UnsupportedEncodingException -> L89
            L4c:
                if (r2 >= r1) goto L7d
                r5 = r10[r2]     // Catch: java.io.UnsupportedEncodingException -> L89
                r6 = r5 & 128(0x80, float:1.8E-43)
                if (r6 != 0) goto L55
                goto L7b
            L55:
                r6 = r5 & 224(0xe0, float:3.14E-43)
                r7 = 192(0xc0, float:2.69E-43)
                if (r6 != r7) goto L5e
                int r5 = r2 + 1
                goto L6f
            L5e:
                r6 = r5 & 240(0xf0, float:3.36E-43)
                r8 = 224(0xe0, float:3.14E-43)
                if (r6 != r8) goto L67
                int r5 = r2 + 2
                goto L6f
            L67:
                r5 = r5 & 248(0xf8, float:3.48E-43)
                r6 = 240(0xf0, float:3.36E-43)
                if (r5 != r6) goto L7e
                int r5 = r2 + 3
            L6f:
                if (r2 >= r5) goto L7b
                int r2 = r2 + 1
                r6 = r10[r2]     // Catch: java.io.UnsupportedEncodingException -> L89
                r6 = r6 & r7
                r8 = 128(0x80, float:1.8E-43)
                if (r6 == r8) goto L6f
                goto L7e
            L7b:
                int r2 = r2 + r4
                goto L4c
            L7d:
                r3 = 1
            L7e:
                if (r3 != 0) goto L81
                goto L89
            L81:
                java.lang.String r1 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L89
                java.lang.String r2 = "UTF-8"
                r1.<init>(r10, r2)     // Catch: java.io.UnsupportedEncodingException -> L89
                r11 = r1
            L89:
                r0.add(r11)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: dh.b.a.addHeader(java.lang.String, java.lang.String):org.jsoup.Connection$a");
        }

        public T cookie(String str, String str2) {
            f.notEmpty(str, "Cookie name must not be empty");
            f.notNull(str2, "Cookie value must not be null");
            this.f11046d.put(str, str2);
            return this;
        }

        public Map<String, String> cookies() {
            return this.f11046d;
        }

        public boolean hasCookie(String str) {
            f.notEmpty(str, "Cookie name must not be empty");
            return this.f11046d.containsKey(str);
        }

        public boolean hasHeader(String str) {
            f.notEmpty(str, "Header name must not be empty");
            return a(str).size() != 0;
        }

        public boolean hasHeaderWithValue(String str, String str2) {
            f.notEmpty(str);
            f.notEmpty(str2);
            Iterator<String> it = headers(str).iterator();
            while (it.hasNext()) {
                if (str2.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String header(String str) {
            f.notNull(str, "Header name must not be null");
            List<String> listA = a(str);
            if (listA.size() > 0) {
                return e.join(listA, ", ");
            }
            return null;
        }

        public List<String> headers(String str) {
            f.notEmpty(str);
            return a(str);
        }

        public Connection.Method method() {
            return this.f11044b;
        }

        public Map<String, List<String>> multiHeaders() {
            return this.f11045c;
        }

        public T removeHeader(String str) {
            Map.Entry entry;
            f.notEmpty(str, "Header name must not be empty");
            String strLowerCase = eh.b.lowerCase(str);
            LinkedHashMap linkedHashMap = this.f11045c;
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    entry = null;
                    break;
                }
                entry = (Map.Entry) it.next();
                if (eh.b.lowerCase((String) entry.getKey()).equals(strLowerCase)) {
                    break;
                }
            }
            if (entry != null) {
                linkedHashMap.remove(entry.getKey());
            }
            return this;
        }

        public URL url() {
            return this.f11043a;
        }

        @Override // org.jsoup.Connection.a
        public T method(Connection.Method method) {
            f.notNull(method, "Method must not be null");
            this.f11044b = method;
            return this;
        }

        @Override // org.jsoup.Connection.a
        public T url(URL url) {
            f.notNull(url, "URL must not be null");
            this.f11043a = url;
            return this;
        }

        public T header(String str, String str2) throws UnsupportedEncodingException {
            f.notEmpty(str, "Header name must not be empty");
            removeHeader(str);
            addHeader(str, str2);
            return this;
        }
    }

    /* compiled from: HttpConnection.java */
    /* renamed from: dh.b$b, reason: collision with other inner class name */
    public static class C0133b extends a<Connection.c> implements Connection.c {

        /* renamed from: j, reason: collision with root package name */
        public gh.d f11052j;

        /* renamed from: i, reason: collision with root package name */
        public String f11051i = null;

        /* renamed from: k, reason: collision with root package name */
        public boolean f11053k = false;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f11054l = true;

        /* renamed from: m, reason: collision with root package name */
        public final String f11055m = "UTF-8";

        /* renamed from: e, reason: collision with root package name */
        public int f11047e = 30000;

        /* renamed from: f, reason: collision with root package name */
        public final int f11048f = 1048576;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f11049g = true;

        /* renamed from: h, reason: collision with root package name */
        public final ArrayList f11050h = new ArrayList();

        public C0133b() throws UnsupportedEncodingException {
            this.f11044b = Connection.Method.GET;
            addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            this.f11052j = gh.d.htmlParser();
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public Collection<Connection.b> data() {
            return this.f11050h;
        }

        public boolean followRedirects() {
            return this.f11049g;
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        public boolean ignoreContentType() {
            return false;
        }

        public boolean ignoreHttpErrors() {
            return false;
        }

        public int maxBodySize() {
            return this.f11048f;
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        public String postDataCharset() {
            return this.f11055m;
        }

        public Proxy proxy() {
            return null;
        }

        public Connection.c requestBody(String str) {
            this.f11051i = str;
            return this;
        }

        public SSLSocketFactory sslSocketFactory() {
            return null;
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        public boolean validateTLSCertificates() {
            return this.f11054l;
        }

        /* renamed from: parser, reason: merged with bridge method [inline-methods] */
        public C0133b m30parser(gh.d dVar) {
            this.f11052j = dVar;
            this.f11053k = true;
            return this;
        }

        public String requestBody() {
            return this.f11051i;
        }

        public int timeout() {
            return this.f11047e;
        }

        @Override // org.jsoup.Connection.c
        public C0133b timeout(int i10) {
            f.isTrue(i10 >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.f11047e = i10;
            return this;
        }

        @Override // org.jsoup.Connection.c
        public gh.d parser() {
            return this.f11052j;
        }
    }

    public static Connection connect(String str) {
        b bVar = new b();
        bVar.url(str);
        return bVar;
    }

    public Connection.d execute() throws IOException {
        c cVarB = c.b(this.f11041a, null);
        this.f11042b = cVarB;
        return cVarB;
    }

    public Document get() throws IOException {
        this.f11041a.method(Connection.Method.GET);
        execute();
        return this.f11042b.parse();
    }

    public Connection timeout(int i10) {
        this.f11041a.timeout(i10);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection url(String str) {
        String externalForm;
        f.notEmpty(str, "Must supply a valid URL");
        try {
            C0133b c0133b = this.f11041a;
            try {
                URL url = new URL(str);
                try {
                    url = new URL(new URI(url.toExternalForm().replaceAll(StringUtils.SPACE, "%20")).toASCIIString());
                } catch (Exception unused) {
                }
                externalForm = url.toExternalForm();
            } catch (Exception unused2) {
                externalForm = str;
            }
            c0133b.url(new URL(externalForm));
            return this;
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(ac.c.j("Malformed URL: ", str), e10);
        }
    }

    /* compiled from: HttpConnection.java */
    public static class c extends a<Connection.d> implements Connection.d {

        /* renamed from: m, reason: collision with root package name */
        public static SSLSocketFactory f11056m;

        /* renamed from: n, reason: collision with root package name */
        public static final Pattern f11057n = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* renamed from: e, reason: collision with root package name */
        public ByteBuffer f11058e;

        /* renamed from: f, reason: collision with root package name */
        public InputStream f11059f;

        /* renamed from: g, reason: collision with root package name */
        public String f11060g;

        /* renamed from: h, reason: collision with root package name */
        public String f11061h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f11062i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f11063j;

        /* renamed from: k, reason: collision with root package name */
        public final int f11064k;

        /* renamed from: l, reason: collision with root package name */
        public C0133b f11065l;

        public c() {
            this.f11062i = false;
            this.f11063j = false;
            this.f11064k = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:160:0x0409 A[Catch: IOException -> 0x0422, TRY_LEAVE, TryCatch #0 {IOException -> 0x0422, blocks: (B:96:0x0291, B:98:0x029a, B:99:0x02a1, B:101:0x02b7, B:105:0x02c1, B:106:0x02d5, B:108:0x02dd, B:110:0x02e5, B:112:0x02ee, B:113:0x02f2, B:116:0x0315, B:117:0x0322, B:119:0x0328, B:120:0x033e, B:128:0x0351, B:130:0x0357, B:132:0x035d, B:134:0x0365, B:137:0x0372, B:138:0x0381, B:140:0x0384, B:142:0x0390, B:144:0x0394, B:145:0x039b, B:147:0x03a9, B:149:0x03b1, B:151:0x03b9, B:153:0x03c2, B:155:0x03ce, B:159:0x03f0, B:156:0x03d8, B:158:0x03e2, B:152:0x03be, B:160:0x0409, B:126:0x034b, B:163:0x0412, B:164:0x0421), top: B:169:0x0291 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x016f  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x026b  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x029a A[Catch: IOException -> 0x0422, TryCatch #0 {IOException -> 0x0422, blocks: (B:96:0x0291, B:98:0x029a, B:99:0x02a1, B:101:0x02b7, B:105:0x02c1, B:106:0x02d5, B:108:0x02dd, B:110:0x02e5, B:112:0x02ee, B:113:0x02f2, B:116:0x0315, B:117:0x0322, B:119:0x0328, B:120:0x033e, B:128:0x0351, B:130:0x0357, B:132:0x035d, B:134:0x0365, B:137:0x0372, B:138:0x0381, B:140:0x0384, B:142:0x0390, B:144:0x0394, B:145:0x039b, B:147:0x03a9, B:149:0x03b1, B:151:0x03b9, B:153:0x03c2, B:155:0x03ce, B:159:0x03f0, B:156:0x03d8, B:158:0x03e2, B:152:0x03be, B:160:0x0409, B:126:0x034b, B:163:0x0412, B:164:0x0421), top: B:169:0x0291 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static dh.b.c b(dh.b.C0133b r14, dh.b.c r15) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 1063
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dh.b.c.b(dh.b$b, dh.b$c):dh.b$c");
        }

        public static void d(C0133b c0133b, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.b> collectionData = c0133b.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, c0133b.postDataCharset()));
            if (str != null) {
                for (Connection.b bVar : collectionData) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    String strKey = bVar.key();
                    bufferedWriter.write(strKey == null ? null : strKey.replaceAll("\"", "%22"));
                    bufferedWriter.write("\"");
                    if (bVar.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        String strValue = bVar.value();
                        bufferedWriter.write(strValue != null ? strValue.replaceAll("\"", "%22") : null);
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(bVar.contentType() != null ? bVar.contentType() : "application/octet-stream");
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        InputStream inputStream = bVar.inputStream();
                        Pattern pattern = dh.a.f11037a;
                        byte[] bArr = new byte[32768];
                        while (true) {
                            int i10 = inputStream.read(bArr);
                            if (i10 == -1) {
                                break;
                            } else {
                                outputStream.write(bArr, 0, i10);
                            }
                        }
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(bVar.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (c0133b.requestBody() != null) {
                bufferedWriter.write(c0133b.requestBody());
            } else {
                boolean z10 = true;
                for (Connection.b bVar2 : collectionData) {
                    if (z10) {
                        z10 = false;
                    } else {
                        bufferedWriter.append('&');
                    }
                    bufferedWriter.write(URLEncoder.encode(bVar2.key(), c0133b.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(bVar2.value(), c0133b.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        public final void c(HttpURLConnection httpURLConnection, Connection.d dVar) throws IOException {
            this.f11044b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.f11043a = httpURLConnection.getURL();
            httpURLConnection.getResponseCode();
            httpURLConnection.getResponseMessage();
            this.f11061h = httpURLConnection.getContentType();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i10);
                String headerField = httpURLConnection.getHeaderField(i10);
                if (headerFieldKey == null && headerField == null) {
                    break;
                }
                i10++;
                if (headerFieldKey != null && headerField != null) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase(SM.SET_COOKIE)) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                gh.f fVar = new gh.f(str2);
                                String strTrim = fVar.chompTo("=").trim();
                                String strTrim2 = fVar.consumeTo(";").trim();
                                if (strTrim.length() > 0) {
                                    cookie(strTrim, strTrim2);
                                }
                            }
                        }
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        addHeader(str, (String) it.next());
                    }
                }
            }
            if (dVar != null) {
                for (Map.Entry entry2 : ((c) dVar).cookies().entrySet()) {
                    if (!hasCookie((String) entry2.getKey())) {
                        cookie((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
            }
        }

        public String contentType() {
            return this.f11061h;
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:78:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0191  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public org.jsoup.nodes.Document parse() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 440
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dh.b.c.parse():org.jsoup.nodes.Document");
        }

        @Override // dh.b.a
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        public c(c cVar) throws IOException {
            this.f11062i = false;
            this.f11063j = false;
            this.f11064k = 0;
            if (cVar != null) {
                int i10 = cVar.f11064k + 1;
                this.f11064k = i10;
                if (i10 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", cVar.url()));
                }
            }
        }
    }
}
