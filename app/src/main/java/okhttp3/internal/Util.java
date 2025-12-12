package okhttp3.internal;

import ah.d;
import ah.e;
import ah.p;
import ah.w;
import ah.y;
import android.support.v4.media.session.PlaybackStateCompat;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import cz.msebera.android.httpclient.cookie.SM;
import ig.c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import lf.h;
import mf.q;
import mf.t;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.ByteString;
import org.apache.commons.lang3.time.TimeZones;
import wd.k;
import yf.a;
import yf.l;
import zf.b;
import zf.i;
import zf.n;

/* compiled from: Util.kt */
/* loaded from: classes2.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final p UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.10.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        p.a aVar = p.f705o;
        ByteString.a aVar2 = ByteString.f17101o;
        UNICODE_BOMS = aVar.of(aVar2.decodeHex("efbbbf"), aVar2.decodeHex("feff"), aVar2.decodeHex("fffe"), aVar2.decodeHex("0000ffff"), aVar2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone(TimeZones.GMT_ID);
        i.checkNotNull(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        i.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removePrefix(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e10) {
        i.checkNotNullParameter(list, "<this>");
        if (list.contains(e10)) {
            return;
        }
        list.add(e10);
    }

    public static final int and(byte b10, int i10) {
        return b10 & i10;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        i.checkNotNullParameter(eventListener, "<this>");
        return new k(eventListener, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: asFactory$lambda-8, reason: not valid java name */
    public static final EventListener m223asFactory$lambda8(EventListener eventListener, Call call) {
        i.checkNotNullParameter(eventListener, "$this_asFactory");
        i.checkNotNullParameter(call, "it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        i.checkNotNullParameter(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        i.checkNotNullParameter(obj, "<this>");
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(String str) {
        i.checkNotNullParameter(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        i.checkNotNullParameter(httpUrl, "<this>");
        i.checkNotNullParameter(httpUrl2, "other");
        return i.areEqual(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && i.areEqual(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j10, TimeUnit timeUnit) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        boolean z10 = true;
        if (!(j10 >= 0)) {
            throw new IllegalStateException(i.stringPlus(str, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j10);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException(i.stringPlus(str, " too large.").toString());
        }
        if (millis == 0 && j10 > 0) {
            z10 = false;
        }
        if (z10) {
            return (int) millis;
        }
        throw new IllegalArgumentException(i.stringPlus(str, " too small.").toString());
    }

    public static final void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) throws IOException {
        i.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        i.checkNotNullParameter(strArr, "<this>");
        i.checkNotNullParameter(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        i.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[mf.i.getLastIndex(strArr2)] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i10, int i11) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(str2, "delimiters");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i10), false, 2, (Object) null)) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return delimiterOffset(str, str2, i10, i11);
    }

    public static final boolean discard(y yVar, int i10, TimeUnit timeUnit) {
        i.checkNotNullParameter(yVar, "<this>");
        i.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(yVar, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l<? super T, Boolean> lVar) {
        i.checkNotNullParameter(iterable, "<this>");
        i.checkNotNullParameter(lVar, "predicate");
        List<T> listEmptyList = mf.k.emptyList();
        for (T t10 : iterable) {
            if (lVar.invoke(t10).booleanValue()) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                n.asMutableList(listEmptyList).add(t10);
            }
        }
        return listEmptyList;
    }

    public static final String format(String str, Object... objArr) {
        i.checkNotNullParameter(str, "format");
        i.checkNotNullParameter(objArr, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        i.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
        return str2;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        i.checkNotNullParameter(strArr, "<this>");
        i.checkNotNullParameter(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                int length = strArr.length;
                int i10 = 0;
                while (i10 < length) {
                    String str = strArr[i10];
                    i10++;
                    Iterator it = b.iterator(strArr2);
                    while (it.hasNext()) {
                        if (comparator.compare(str, (String) it.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        i.checkNotNullParameter(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return toLongOrDefault(str, -1L);
    }

    public static final void ignoreIoExceptions(a<h> aVar) {
        i.checkNotNullParameter(aVar, "block");
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        i.checkNotNullParameter(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(mf.k.listOf(Arrays.copyOf(objArr, objArr.length)));
        i.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        i.checkNotNullParameter(strArr, "<this>");
        i.checkNotNullParameter(str, "value");
        i.checkNotNullParameter(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        i.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (i.compare((int) cCharAt, 31) <= 0 || i.compare((int) cCharAt, 127) >= 0) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i10, int i11) {
        i.checkNotNullParameter(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i10, i11);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i10, int i11) {
        i.checkNotNullParameter(str, "<this>");
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                int i13 = i12 - 1;
                char cCharAt = str.charAt(i12);
                if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                    return i12 + 1;
                }
                if (i12 == i10) {
                    break;
                }
                i12 = i13;
            }
        }
        return i10;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i10, i11);
    }

    public static final int indexOfNonWhitespace(String str, int i10) {
        i.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i10;
            }
            i10 = i11;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return indexOfNonWhitespace(str, i10);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        i.checkNotNullParameter(strArr, "<this>");
        i.checkNotNullParameter(strArr2, "other");
        i.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            int length2 = strArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 < length2) {
                    String str2 = strArr2[i11];
                    i11++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(fileSystem, "<this>");
        i.checkNotNullParameter(file, "file");
        w wVarSink = fileSystem.sink(file);
        try {
            try {
                fileSystem.delete(file);
                wf.a.closeFinally(wVarSink, null);
                return true;
            } finally {
            }
        } catch (IOException unused) {
            h hVar = h.f16056a;
            wf.a.closeFinally(wVarSink, null);
            fileSystem.delete(file);
            return false;
        }
    }

    public static final boolean isHealthy(Socket socket, e eVar) throws SocketException {
        i.checkNotNullParameter(socket, "<this>");
        i.checkNotNullParameter(eVar, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z10 = !eVar.exhausted();
                socket.setSoTimeout(soTimeout);
                return z10;
            } catch (Throwable th2) {
                socket.setSoTimeout(soTimeout);
                throw th2;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        return ig.l.equals(str, "Authorization", true) || ig.l.equals(str, "Cookie", true) || ig.l.equals(str, "Proxy-Authorization", true) || ig.l.equals(str, SM.SET_COOKIE, true);
    }

    public static final void notify(Object obj) {
        i.checkNotNullParameter(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        i.checkNotNullParameter(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if (!('A' <= c10 && c10 < 'G')) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static final String peerName(Socket socket) {
        i.checkNotNullParameter(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        i.checkNotNullExpressionValue(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(e eVar, Charset charset) throws IOException {
        i.checkNotNullParameter(eVar, "<this>");
        i.checkNotNullParameter(charset, CookieSpecs.DEFAULT);
        int iSelect = eVar.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            i.checkNotNullExpressionValue(charset2, "UTF_8");
            return charset2;
        }
        if (iSelect == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            i.checkNotNullExpressionValue(charset3, "UTF_16BE");
            return charset3;
        }
        if (iSelect == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            i.checkNotNullExpressionValue(charset4, "UTF_16LE");
            return charset4;
        }
        if (iSelect == 3) {
            return c.f13439a.UTF32_BE();
        }
        if (iSelect == 4) {
            return c.f13439a.UTF32_LE();
        }
        throw new AssertionError();
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        T tCast;
        Object fieldOrNull;
        i.checkNotNullParameter(obj, "instance");
        i.checkNotNullParameter(cls, "fieldType");
        i.checkNotNullParameter(str, "fieldName");
        Class<?> superclass = obj.getClass();
        while (true) {
            tCast = null;
            if (i.areEqual(superclass, Object.class)) {
                if (i.areEqual(str, "delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                tCast = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                i.checkNotNullExpressionValue(superclass, "c.superclass");
            }
        }
        return tCast;
    }

    public static final int readMedium(e eVar) throws IOException {
        i.checkNotNullParameter(eVar, "<this>");
        return and(eVar.readByte(), 255) | (and(eVar.readByte(), 255) << 16) | (and(eVar.readByte(), 255) << 8);
    }

    public static final boolean skipAll(y yVar, int i10, TimeUnit timeUnit) throws IOException {
        i.checkNotNullParameter(yVar, "<this>");
        i.checkNotNullParameter(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = yVar.timeout().hasDeadline() ? yVar.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        yVar.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            ah.c cVar = new ah.c();
            while (yVar.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.clear();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                yVar.timeout().clearDeadline();
            } else {
                yVar.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                yVar.timeout().clearDeadline();
            } else {
                yVar.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (Throwable th2) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                yVar.timeout().clearDeadline();
            } else {
                yVar.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th2;
        }
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z10) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        return new ThreadFactory() { // from class: zg.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.m224threadFactory$lambda1(str, z10, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: threadFactory$lambda-1, reason: not valid java name */
    public static final Thread m224threadFactory$lambda1(String str, boolean z10, Runnable runnable) {
        i.checkNotNullParameter(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }

    public static final void threadName(String str, a<h> aVar) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(aVar, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            zf.h.finallyStart(1);
            threadCurrentThread.setName(name);
            zf.h.finallyEnd(1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        i.checkNotNullParameter(headers, "<this>");
        fg.c cVarUntil = fg.h.until(0, headers.size());
        ArrayList arrayList = new ArrayList(mf.l.collectionSizeOrDefault(cVarUntil, 10));
        Iterator<Integer> it = cVarUntil.iterator();
        while (it.hasNext()) {
            int iNextInt = ((t) it).nextInt();
            arrayList.add(new Header(headers.name(iNextInt), headers.value(iNextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        i.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(long j10) {
        String hexString = Long.toHexString(j10);
        i.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z10) {
        String strHost;
        i.checkNotNullParameter(httpUrl, "<this>");
        if (StringsKt__StringsKt.contains$default((CharSequence) httpUrl.host(), (CharSequence) ":", false, 2, (Object) null)) {
            strHost = "[" + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z10 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return toHostHeader(httpUrl, z10);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        i.checkNotNullParameter(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(q.toMutableList((Collection) list));
        i.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        i.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            return kotlin.collections.a.emptyMap();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        i.checkNotNullExpressionValue(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j10) {
        i.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int toNonNegativeInt(String str, int i10) {
        Long lValueOf;
        if (str == null) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        if (lValueOf == null) {
            return i10;
        }
        long jLongValue = lValueOf.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    public static final String trimSubstring(String str, int i10, int i11) {
        i.checkNotNullParameter(str, "<this>");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i10, i11);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i11));
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return trimSubstring(str, i10, i11);
    }

    public static final void wait(Object obj) throws InterruptedException {
        i.checkNotNullParameter(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(exc, "<this>");
        i.checkNotNullParameter(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            lf.a.addSuppressed(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(d dVar, int i10) throws IOException {
        i.checkNotNullParameter(dVar, "<this>");
        dVar.writeByte((i10 >>> 16) & 255);
        dVar.writeByte((i10 >>> 8) & 255);
        dVar.writeByte(i10 & 255);
    }

    public static final int and(short s10, int i10) {
        return s10 & i10;
    }

    public static final int delimiterOffset(String str, char c10, int i10, int i11) {
        i.checkNotNullParameter(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return delimiterOffset(str, c10, i10, i11);
    }

    public static final String toHexString(int i10) {
        String hexString = Integer.toHexString(i10);
        i.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long and(int i10, long j10) {
        return i10 & j10;
    }

    public static final void closeQuietly(Socket socket) throws IOException {
        i.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!i.areEqual(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) throws IOException {
        i.checkNotNullParameter(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(ah.c cVar, byte b10) throws EOFException {
        i.checkNotNullParameter(cVar, "<this>");
        int i10 = 0;
        while (!cVar.exhausted() && cVar.getByte(0L) == b10) {
            i10++;
            cVar.readByte();
        }
        return i10;
    }
}
