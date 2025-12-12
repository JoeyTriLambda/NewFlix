package d4;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: DiskBasedCache.java */
/* loaded from: classes.dex */
public final class d implements Cache {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f10819a;

    /* renamed from: b, reason: collision with root package name */
    public long f10820b;

    /* renamed from: c, reason: collision with root package name */
    public final c f10821c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10822d;

    /* compiled from: DiskBasedCache.java */
    public interface c {
    }

    public d(c cVar, int i10) {
        this.f10819a = new LinkedHashMap(16, 0.75f, true);
        this.f10820b = 0L;
        this.f10821c = cVar;
        this.f10822d = i10;
    }

    public static String a(String str) {
        int length = str.length() / 2;
        StringBuilder sbR = ac.c.r(String.valueOf(str.substring(0, length).hashCode()));
        sbR.append(String.valueOf(str.substring(length).hashCode()));
        return sbR.toString();
    }

    public static int d(InputStream inputStream) throws IOException {
        int i10 = inputStream.read();
        if (i10 != -1) {
            return i10;
        }
        throw new EOFException();
    }

    public static int e(InputStream inputStream) throws IOException {
        return (d(inputStream) << 24) | (d(inputStream) << 0) | 0 | (d(inputStream) << 8) | (d(inputStream) << 16);
    }

    public static long f(InputStream inputStream) throws IOException {
        return ((d(inputStream) & 255) << 0) | 0 | ((d(inputStream) & 255) << 8) | ((d(inputStream) & 255) << 16) | ((d(inputStream) & 255) << 24) | ((d(inputStream) & 255) << 32) | ((d(inputStream) & 255) << 40) | ((d(inputStream) & 255) << 48) | ((255 & d(inputStream)) << 56);
    }

    public static String g(b bVar) throws IOException {
        return new String(h(bVar, f(bVar)), "UTF-8");
    }

    public static byte[] h(b bVar, long j10) throws IOException {
        long j11 = bVar.f10831b - bVar.f10832m;
        if (j10 >= 0 && j10 <= j11) {
            int i10 = (int) j10;
            if (i10 == j10) {
                byte[] bArr = new byte[i10];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j10 + ", maxLength=" + j11);
    }

    public static void i(BufferedOutputStream bufferedOutputStream, int i10) throws IOException {
        bufferedOutputStream.write((i10 >> 0) & 255);
        bufferedOutputStream.write((i10 >> 8) & 255);
        bufferedOutputStream.write((i10 >> 16) & 255);
        bufferedOutputStream.write((i10 >> 24) & 255);
    }

    public static void j(BufferedOutputStream bufferedOutputStream, long j10) throws IOException {
        bufferedOutputStream.write((byte) (j10 >>> 0));
        bufferedOutputStream.write((byte) (j10 >>> 8));
        bufferedOutputStream.write((byte) (j10 >>> 16));
        bufferedOutputStream.write((byte) (j10 >>> 24));
        bufferedOutputStream.write((byte) (j10 >>> 32));
        bufferedOutputStream.write((byte) (j10 >>> 40));
        bufferedOutputStream.write((byte) (j10 >>> 48));
        bufferedOutputStream.write((byte) (j10 >>> 56));
    }

    public static void k(String str, BufferedOutputStream bufferedOutputStream) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        j(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    public final void b() {
        long j10 = this.f10820b;
        int i10 = this.f10822d;
        if (j10 < i10) {
            return;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j11 = this.f10820b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.f10819a.entrySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            a aVar = (a) ((Map.Entry) it.next()).getValue();
            if (getFileForKey(aVar.f10824b).delete()) {
                this.f10820b -= aVar.f10823a;
            } else {
                String str = aVar.f10824b;
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, a(str));
            }
            it.remove();
            i11++;
            if (this.f10820b < i10 * 0.9f) {
                break;
            }
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i11), Long.valueOf(this.f10820b - j11), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public final void c(String str, a aVar) {
        LinkedHashMap linkedHashMap = this.f10819a;
        if (linkedHashMap.containsKey(str)) {
            this.f10820b = (aVar.f10823a - ((a) linkedHashMap.get(str)).f10823a) + this.f10820b;
        } else {
            this.f10820b += aVar.f10823a;
        }
        linkedHashMap.put(str, aVar);
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        File[] fileArrListFiles = ((n) this.f10821c).get().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        this.f10819a.clear();
        this.f10820b = 0L;
        VolleyLog.d("Cache cleared.", new Object[0]);
    }

    @Override // com.android.volley.Cache
    public synchronized Cache.Entry get(String str) {
        a aVar = (a) this.f10819a.get(str);
        if (aVar == null) {
            return null;
        }
        File fileForKey = getFileForKey(str);
        try {
            b bVar = new b(new BufferedInputStream(new FileInputStream(fileForKey)), fileForKey.length());
            try {
                a aVarA = a.a(bVar);
                if (TextUtils.equals(str, aVarA.f10824b)) {
                    return aVar.b(h(bVar, bVar.f10831b - bVar.f10832m));
                }
                VolleyLog.d("%s: key=%s, found=%s", fileForKey.getAbsolutePath(), str, aVarA.f10824b);
                a aVar2 = (a) this.f10819a.remove(str);
                if (aVar2 != null) {
                    this.f10820b -= aVar2.f10823a;
                }
                return null;
            } finally {
                bVar.close();
            }
        } catch (IOException e10) {
            VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e10.toString());
            remove(str);
            return null;
        }
    }

    public File getFileForKey(String str) {
        return new File(((n) this.f10821c).get(), a(str));
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        File file = ((n) this.f10821c).get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                VolleyLog.e("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                long length = file2.length();
                b bVar = new b(new BufferedInputStream(new FileInputStream(file2)), length);
                try {
                    a aVarA = a.a(bVar);
                    aVarA.f10823a = length;
                    c(aVarA.f10824b, aVarA);
                    bVar.close();
                } catch (Throwable th2) {
                    bVar.close();
                    throw th2;
                }
            } catch (IOException unused) {
                file2.delete();
            }
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String str, boolean z10) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z10) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        BufferedOutputStream bufferedOutputStream;
        a aVar;
        long j10 = this.f10820b;
        byte[] bArr = entry.data;
        long length = j10 + bArr.length;
        int i10 = this.f10822d;
        if (length <= i10 || bArr.length <= i10 * 0.9f) {
            File fileForKey = getFileForKey(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
                aVar = new a(str, entry);
            } catch (IOException unused) {
                if (!fileForKey.delete()) {
                    VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
                }
                if (!((n) this.f10821c).get().exists()) {
                    VolleyLog.d("Re-initializing cache after external clearing.", new Object[0]);
                    this.f10819a.clear();
                    this.f10820b = 0L;
                    initialize();
                }
            }
            if (!aVar.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(entry.data);
            bufferedOutputStream.close();
            aVar.f10823a = fileForKey.length();
            c(str, aVar);
            b();
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String str) {
        boolean zDelete = getFileForKey(str).delete();
        a aVar = (a) this.f10819a.remove(str);
        if (aVar != null) {
            this.f10820b -= aVar.f10823a;
        }
        if (!zDelete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, a(str));
        }
    }

    /* compiled from: DiskBasedCache.java */
    public static class b extends FilterInputStream {

        /* renamed from: b, reason: collision with root package name */
        public final long f10831b;

        /* renamed from: m, reason: collision with root package name */
        public long f10832m;

        public b(BufferedInputStream bufferedInputStream, long j10) {
            super(bufferedInputStream);
            this.f10831b = j10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = super.read();
            if (i10 != -1) {
                this.f10832m++;
            }
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = super.read(bArr, i10, i11);
            if (i12 != -1) {
                this.f10832m += i12;
            }
            return i12;
        }
    }

    public d(c cVar) {
        this(cVar, 5242880);
    }

    /* compiled from: DiskBasedCache.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f10823a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10824b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10825c;

        /* renamed from: d, reason: collision with root package name */
        public final long f10826d;

        /* renamed from: e, reason: collision with root package name */
        public final long f10827e;

        /* renamed from: f, reason: collision with root package name */
        public final long f10828f;

        /* renamed from: g, reason: collision with root package name */
        public final long f10829g;

        /* renamed from: h, reason: collision with root package name */
        public final List<Header> f10830h;

        public a(String str, String str2, long j10, long j11, long j12, long j13, List<Header> list) {
            this.f10824b = str;
            this.f10825c = "".equals(str2) ? null : str2;
            this.f10826d = j10;
            this.f10827e = j11;
            this.f10828f = j12;
            this.f10829g = j13;
            this.f10830h = list;
        }

        public static a a(b bVar) throws IOException {
            if (d.e(bVar) != 538247942) {
                throw new IOException();
            }
            String strG = d.g(bVar);
            String strG2 = d.g(bVar);
            long jF = d.f(bVar);
            long jF2 = d.f(bVar);
            long jF3 = d.f(bVar);
            long jF4 = d.f(bVar);
            int iE = d.e(bVar);
            if (iE < 0) {
                throw new IOException(ac.c.f("readHeaderList size=", iE));
            }
            List listEmptyList = iE == 0 ? Collections.emptyList() : new ArrayList();
            for (int i10 = 0; i10 < iE; i10++) {
                listEmptyList.add(new Header(d.g(bVar).intern(), d.g(bVar).intern()));
            }
            return new a(strG, strG2, jF, jF2, jF3, jF4, listEmptyList);
        }

        public final Cache.Entry b(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.f10825c;
            entry.serverDate = this.f10826d;
            entry.lastModified = this.f10827e;
            entry.ttl = this.f10828f;
            entry.softTtl = this.f10829g;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            List<Header> list = this.f10830h;
            for (Header header : list) {
                treeMap.put(header.getName(), header.getValue());
            }
            entry.responseHeaders = treeMap;
            entry.allResponseHeaders = Collections.unmodifiableList(list);
            return entry;
        }

        public final boolean c(BufferedOutputStream bufferedOutputStream) throws IOException {
            try {
                d.i(bufferedOutputStream, 538247942);
                d.k(this.f10824b, bufferedOutputStream);
                String str = this.f10825c;
                if (str == null) {
                    str = "";
                }
                d.k(str, bufferedOutputStream);
                d.j(bufferedOutputStream, this.f10826d);
                d.j(bufferedOutputStream, this.f10827e);
                d.j(bufferedOutputStream, this.f10828f);
                d.j(bufferedOutputStream, this.f10829g);
                List<Header> list = this.f10830h;
                if (list != null) {
                    d.i(bufferedOutputStream, list.size());
                    for (Header header : list) {
                        d.k(header.getName(), bufferedOutputStream);
                        d.k(header.getValue(), bufferedOutputStream);
                    }
                } else {
                    d.i(bufferedOutputStream, 0);
                }
                bufferedOutputStream.flush();
                return true;
            } catch (IOException e10) {
                VolleyLog.d("%s", e10.toString());
                return false;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.android.volley.Header>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v2 */
        public a(String str, Cache.Entry entry) {
            String str2 = entry.etag;
            long j10 = entry.serverDate;
            long j11 = entry.lastModified;
            long j12 = entry.ttl;
            long j13 = entry.softTtl;
            List arrayList = entry.allResponseHeaders;
            if (arrayList == 0) {
                Map<String, String> map = entry.responseHeaders;
                arrayList = new ArrayList(map.size());
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
            this(str, str2, j10, j11, j12, j13, arrayList);
        }
    }
}
