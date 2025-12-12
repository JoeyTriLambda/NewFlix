package okhttp3.internal.http2;

import ah.c;
import ah.d;
import ah.e;
import ah.m;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import lf.h;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import yf.a;
import zf.f;
import zf.i;

/* compiled from: Http2Connection.kt */
/* loaded from: classes2.dex */
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    /* compiled from: Http2Connection.kt */
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public d sink;
        public Socket socket;
        public e source;
        private final TaskRunner taskRunner;

        public Builder(boolean z10, TaskRunner taskRunner) {
            i.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = z10;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, e eVar, d dVar, int i10, Object obj) throws IOException {
            if ((i10 & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i10 & 4) != 0) {
                eVar = m.buffer(m.source(socket));
            }
            if ((i10 & 8) != 0) {
                dVar = m.buffer(m.sink(socket));
            }
            return builder.socket(socket, str, eVar, dVar);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            i.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final d getSink$okhttp() {
            d dVar = this.sink;
            if (dVar != null) {
                return dVar;
            }
            i.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            i.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final e getSource$okhttp() {
            e eVar = this.source;
            if (eVar != null) {
                return eVar;
            }
            i.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener) {
            i.checkNotNullParameter(listener, "listener");
            setListener$okhttp(listener);
            return this;
        }

        public final Builder pingIntervalMillis(int i10) {
            setPingIntervalMillis$okhttp(i10);
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            i.checkNotNullParameter(pushObserver, "pushObserver");
            setPushObserver$okhttp(pushObserver);
            return this;
        }

        public final void setClient$okhttp(boolean z10) {
            this.client = z10;
        }

        public final void setConnectionName$okhttp(String str) {
            i.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener) {
            i.checkNotNullParameter(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i10) {
            this.pingIntervalMillis = i10;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            i.checkNotNullParameter(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(d dVar) {
            i.checkNotNullParameter(dVar, "<set-?>");
            this.sink = dVar;
        }

        public final void setSocket$okhttp(Socket socket) {
            i.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(e eVar) {
            i.checkNotNullParameter(eVar, "<set-?>");
            this.source = eVar;
        }

        public final Builder socket(Socket socket) throws IOException {
            i.checkNotNullParameter(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String str) throws IOException {
            i.checkNotNullParameter(socket, "socket");
            i.checkNotNullParameter(str, "peerName");
            return socket$default(this, socket, str, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String str, e eVar) throws IOException {
            i.checkNotNullParameter(socket, "socket");
            i.checkNotNullParameter(str, "peerName");
            i.checkNotNullParameter(eVar, "source");
            return socket$default(this, socket, str, eVar, null, 8, null);
        }

        public final Builder socket(Socket socket, String str, e eVar, d dVar) throws IOException {
            String strStringPlus;
            i.checkNotNullParameter(socket, "socket");
            i.checkNotNullParameter(str, "peerName");
            i.checkNotNullParameter(eVar, "source");
            i.checkNotNullParameter(dVar, "sink");
            setSocket$okhttp(socket);
            if (getClient$okhttp()) {
                strStringPlus = Util.okHttpName + TokenParser.SP + str;
            } else {
                strStringPlus = i.stringPlus("MockWebServer ", str);
            }
            setConnectionName$okhttp(strStringPlus);
            setSource$okhttp(eVar);
            setSink$okhttp(dVar);
            return this;
        }
    }

    /* compiled from: Http2Connection.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    /* compiled from: Http2Connection.kt */
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                i.checkNotNullParameter(http2Stream, "stream");
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        /* compiled from: Http2Connection.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public void onSettings(Http2Connection http2Connection, Settings settings) {
            i.checkNotNullParameter(http2Connection, "connection");
            i.checkNotNullParameter(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* compiled from: Http2Connection.kt */
    public final class ReaderRunnable implements Http2Reader.Handler, a<h> {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            i.checkNotNullParameter(http2Connection, "this$0");
            i.checkNotNullParameter(http2Reader, "reader");
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10) {
            i.checkNotNullParameter(str, "origin");
            i.checkNotNullParameter(byteString, "protocol");
            i.checkNotNullParameter(str2, "host");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, okhttp3.internal.http2.Settings] */
        /* JADX WARN: Type inference failed for: r13v3 */
        public final void applyAndAckSettings(boolean z10, Settings settings) {
            ?? r13;
            long initialWindowSize;
            int i10;
            Http2Stream[] http2StreamArr;
            i.checkNotNullParameter(settings, "settings");
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Http2Writer writer = this.this$0.getWriter();
            final Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    Settings peerSettings = http2Connection.getPeerSettings();
                    if (z10) {
                        r13 = settings;
                    } else {
                        Settings settings2 = new Settings();
                        settings2.merge(peerSettings);
                        settings2.merge(settings);
                        r13 = settings2;
                    }
                    ref$ObjectRef.f15262b = r13;
                    initialWindowSize = r13.getInitialWindowSize() - peerSettings.getInitialWindowSize();
                    i10 = 0;
                    if (initialWindowSize == 0 || http2Connection.getStreams$okhttp().isEmpty()) {
                        http2StreamArr = null;
                    } else {
                        Object[] array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                        http2StreamArr = (Http2Stream[]) array;
                    }
                    http2Connection.setPeerSettings((Settings) ref$ObjectRef.f15262b);
                    TaskQueue taskQueue = http2Connection.settingsListenerQueue;
                    final String strStringPlus = i.stringPlus(http2Connection.getConnectionName$okhttp(), " onSettings");
                    final boolean z11 = true;
                    taskQueue.schedule(new Task(strStringPlus, z11, http2Connection, ref$ObjectRef) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$lambda-7$lambda-6$$inlined$execute$default$1
                        final /* synthetic */ boolean $cancelable;
                        final /* synthetic */ String $name;
                        final /* synthetic */ Ref$ObjectRef $newPeerSettings$inlined;
                        final /* synthetic */ Http2Connection this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(strStringPlus, z11);
                            this.$name = strStringPlus;
                            this.$cancelable = z11;
                            this.this$0 = http2Connection;
                            this.$newPeerSettings$inlined = ref$ObjectRef;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) this.$newPeerSettings$inlined.f15262b);
                            return -1L;
                        }
                    }, 0L);
                    h hVar = h.f16056a;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) ref$ObjectRef.f15262b);
                } catch (IOException e10) {
                    http2Connection.failConnection(e10);
                }
                h hVar2 = h.f16056a;
            }
            if (http2StreamArr != null) {
                int length = http2StreamArr.length;
                while (i10 < length) {
                    Http2Stream http2Stream = http2StreamArr[i10];
                    i10++;
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                        h hVar3 = h.f16056a;
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z10, int i10, e eVar, int i11) throws IOException {
            i.checkNotNullParameter(eVar, "source");
            if (this.this$0.pushedStream$okhttp(i10)) {
                this.this$0.pushDataLater$okhttp(i10, eVar, i11, z10);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i10);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = i11;
                this.this$0.updateConnectionFlowControl$okhttp(j10);
                eVar.skip(j10);
                return;
            }
            stream.receiveData(eVar, i11);
            if (z10) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i10, ErrorCode errorCode, ByteString byteString) {
            int i11;
            Object[] array;
            i.checkNotNullParameter(errorCode, "errorCode");
            i.checkNotNullParameter(byteString, "debugData");
            byteString.size();
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                i11 = 0;
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                http2Connection.isShutdown = true;
                h hVar = h.f16056a;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) array;
            int length = http2StreamArr.length;
            while (i11 < length) {
                Http2Stream http2Stream = http2StreamArr[i11];
                i11++;
                if (http2Stream.getId() > i10 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z10, int i10, int i11, List<Header> list) {
            i.checkNotNullParameter(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i10)) {
                this.this$0.pushHeadersLater$okhttp(i10, list, z10);
                return;
            }
            final Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i10);
                if (stream != null) {
                    h hVar = h.f16056a;
                    stream.receiveHeaders(Util.toHeaders(list), z10);
                    return;
                }
                if (http2Connection.isShutdown) {
                    return;
                }
                if (i10 <= http2Connection.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i10 % 2 == http2Connection.getNextStreamId$okhttp() % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i10, http2Connection, false, z10, Util.toHeaders(list));
                http2Connection.setLastGoodStreamId$okhttp(i10);
                http2Connection.getStreams$okhttp().put(Integer.valueOf(i10), http2Stream);
                TaskQueue taskQueueNewQueue = http2Connection.taskRunner.newQueue();
                final String str = http2Connection.getConnectionName$okhttp() + '[' + i10 + "] onStream";
                final boolean z11 = true;
                taskQueueNewQueue.schedule(new Task(str, z11, http2Connection, http2Stream) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$lambda-2$$inlined$execute$default$1
                    final /* synthetic */ boolean $cancelable;
                    final /* synthetic */ String $name;
                    final /* synthetic */ Http2Stream $newStream$inlined;
                    final /* synthetic */ Http2Connection this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(str, z11);
                        this.$name = str;
                        this.$cancelable = z11;
                        this.this$0 = http2Connection;
                        this.$newStream$inlined = http2Stream;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        try {
                            this.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
                            return -1L;
                        } catch (IOException e10) {
                            Platform.Companion.get().log(i.stringPlus("Http2Connection.Listener failure for ", this.this$0.getConnectionName$okhttp()), 4, e10);
                            try {
                                this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e10);
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }
                }, 0L);
            }
        }

        @Override // yf.a
        public /* bridge */ /* synthetic */ h invoke() throws Throwable {
            invoke2();
            return h.f16056a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z10, final int i10, final int i11) {
            if (!z10) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                final String strStringPlus = i.stringPlus(this.this$0.getConnectionName$okhttp(), " ping");
                final Http2Connection http2Connection = this.this$0;
                final boolean z11 = true;
                taskQueue.schedule(new Task(strStringPlus, z11, http2Connection, i10, i11) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1
                    final /* synthetic */ boolean $cancelable;
                    final /* synthetic */ String $name;
                    final /* synthetic */ int $payload1$inlined;
                    final /* synthetic */ int $payload2$inlined;
                    final /* synthetic */ Http2Connection this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(strStringPlus, z11);
                        this.$name = strStringPlus;
                        this.$cancelable = z11;
                        this.this$0 = http2Connection;
                        this.$payload1$inlined = i10;
                        this.$payload2$inlined = i11;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() throws IOException {
                        this.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection2) {
                if (i10 == 1) {
                    http2Connection2.intervalPongsReceived++;
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        http2Connection2.awaitPongsReceived++;
                        http2Connection2.notifyAll();
                    }
                    h hVar = h.f16056a;
                } else {
                    http2Connection2.degradedPongsReceived++;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i10, int i11, List<Header> list) {
            i.checkNotNullParameter(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i11, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i10, ErrorCode errorCode) {
            i.checkNotNullParameter(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i10)) {
                this.this$0.pushResetLater$okhttp(i10, errorCode);
                return;
            }
            Http2Stream http2StreamRemoveStream$okhttp = this.this$0.removeStream$okhttp(i10);
            if (http2StreamRemoveStream$okhttp == null) {
                return;
            }
            http2StreamRemoveStream$okhttp.receiveRstStream(errorCode);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z10, final Settings settings) {
            i.checkNotNullParameter(settings, "settings");
            TaskQueue taskQueue = this.this$0.writerQueue;
            final String strStringPlus = i.stringPlus(this.this$0.getConnectionName$okhttp(), " applyAndAckSettings");
            final boolean z11 = true;
            taskQueue.schedule(new Task(strStringPlus, z11, this, z10, settings) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ boolean $clearPrevious$inlined;
                final /* synthetic */ String $name;
                final /* synthetic */ Settings $settings$inlined;
                final /* synthetic */ Http2Connection.ReaderRunnable this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(strStringPlus, z11);
                    this.$name = strStringPlus;
                    this.$cancelable = z11;
                    this.this$0 = this;
                    this.$clearPrevious$inlined = z10;
                    this.$settings$inlined = settings;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
                    return -1L;
                }
            }, 0L);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i10, long j10) {
            if (i10 == 0) {
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j10;
                    http2Connection.notifyAll();
                    h hVar = h.f16056a;
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(i10);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j10);
                    h hVar2 = h.f16056a;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e10 = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException e11) {
                    e10 = e11;
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode3;
                    this.this$0.close$okhttp(errorCode, errorCode3, e10);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
                try {
                    this.this$0.close$okhttp(errorCode2, ErrorCode.CANCEL, null);
                    errorCode = errorCode2;
                } catch (IOException e12) {
                    e10 = e12;
                    ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection http2Connection = this.this$0;
                    http2Connection.close$okhttp(errorCode4, errorCode4, e10);
                    errorCode = http2Connection;
                    errorCode3 = this.reader;
                    Util.closeQuietly((Closeable) errorCode3);
                }
                errorCode3 = this.reader;
                Util.closeQuietly((Closeable) errorCode3);
            } catch (Throwable th3) {
                th = th3;
                this.this$0.close$okhttp(errorCode, errorCode3, e10);
                Util.closeQuietly(this.reader);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i10, int i11, int i12, boolean z10) {
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        settings.set(5, Http2.INITIAL_MAX_FRAME_SIZE);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        i.checkNotNullParameter(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue taskQueueNewQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = taskQueueNewQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = r2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            final String strStringPlus = i.stringPlus(connectionName$okhttp, " ping");
            taskQueueNewQueue.schedule(new Task(strStringPlus, this, nanos) { // from class: okhttp3.internal.http2.Http2Connection$special$$inlined$schedule$1
                final /* synthetic */ String $name;
                final /* synthetic */ long $pingIntervalNanos$inlined;
                final /* synthetic */ Http2Connection this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(strStringPlus, false, 2, null);
                    this.$name = strStringPlus;
                    this.this$0 = this;
                    this.$pingIntervalNanos$inlined = nanos;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() throws IOException {
                    boolean z10;
                    synchronized (this.this$0) {
                        if (this.this$0.intervalPongsReceived < this.this$0.intervalPingsSent) {
                            z10 = true;
                        } else {
                            this.this$0.intervalPingsSent++;
                            z10 = false;
                        }
                    }
                    if (z10) {
                        this.this$0.failConnection(null);
                        return -1L;
                    }
                    this.this$0.writePing(false, 1, 0);
                    return this.$pingIntervalNanos$inlined;
                }
            }, nanos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failConnection(IOException iOException) throws IOException {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z10, TaskRunner taskRunner, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z10, taskRunner);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) throws IOException {
        int i10;
        Object[] array;
        i.checkNotNullParameter(errorCode, "connectionCode");
        i.checkNotNullParameter(errorCode2, "streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!getStreams$okhttp().isEmpty()) {
                array = getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                getStreams$okhttp().clear();
            } else {
                array = null;
            }
            h hVar = h.f16056a;
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            getWriter().close();
        } catch (IOException unused3) {
        }
        try {
            getSocket$okhttp().close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i10) {
        return this.streams.get(Integer.valueOf(i10));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j10) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (j10 >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    public final Http2Stream newStream(List<Header> list, boolean z10) throws IOException {
        i.checkNotNullParameter(list, "requestHeaders");
        return newStream(0, list, z10);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(final int i10, e eVar, final int i11, final boolean z10) throws IOException {
        i.checkNotNullParameter(eVar, "source");
        final c cVar = new c();
        long j10 = i11;
        eVar.require(j10);
        eVar.read(cVar, j10);
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i10 + "] onData";
        final boolean z11 = true;
        taskQueue.schedule(new Task(str, z11, this, i10, cVar, i11, z10) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1
            final /* synthetic */ c $buffer$inlined;
            final /* synthetic */ int $byteCount$inlined;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ boolean $inFinished$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z11);
                this.$name = str;
                this.$cancelable = z11;
                this.this$0 = this;
                this.$streamId$inlined = i10;
                this.$buffer$inlined = cVar;
                this.$byteCount$inlined = i11;
                this.$inFinished$inlined = z10;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    boolean zOnData = this.this$0.pushObserver.onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
                    if (zOnData) {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                    }
                    if (!zOnData && !this.$inFinished$inlined) {
                        return -1L;
                    }
                    synchronized (this.this$0) {
                        this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void pushHeadersLater$okhttp(final int i10, final List<Header> list, final boolean z10) {
        i.checkNotNullParameter(list, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i10 + "] onHeaders";
        final boolean z11 = true;
        taskQueue.schedule(new Task(str, z11, this, i10, list, z10) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ boolean $inFinished$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ List $requestHeaders$inlined;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z11);
                this.$name = str;
                this.$cancelable = z11;
                this.this$0 = this;
                this.$streamId$inlined = i10;
                this.$requestHeaders$inlined = list;
                this.$inFinished$inlined = z10;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean zOnHeaders = this.this$0.pushObserver.onHeaders(this.$streamId$inlined, this.$requestHeaders$inlined, this.$inFinished$inlined);
                if (zOnHeaders) {
                    try {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (!zOnHeaders && !this.$inFinished$inlined) {
                    return -1L;
                }
                synchronized (this.this$0) {
                    this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                }
                return -1L;
            }
        }, 0L);
    }

    public final void pushRequestLater$okhttp(final int i10, final List<Header> list) {
        i.checkNotNullParameter(list, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i10))) {
                writeSynResetLater$okhttp(i10, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i10));
            TaskQueue taskQueue = this.pushQueue;
            final String str = this.connectionName + '[' + i10 + "] onRequest";
            final boolean z10 = true;
            taskQueue.schedule(new Task(str, z10, this, i10, list) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$default$1
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ String $name;
                final /* synthetic */ List $requestHeaders$inlined;
                final /* synthetic */ int $streamId$inlined;
                final /* synthetic */ Http2Connection this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str, z10);
                    this.$name = str;
                    this.$cancelable = z10;
                    this.this$0 = this;
                    this.$streamId$inlined = i10;
                    this.$requestHeaders$inlined = list;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    if (!this.this$0.pushObserver.onRequest(this.$streamId$inlined, this.$requestHeaders$inlined)) {
                        return -1L;
                    }
                    try {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        synchronized (this.this$0) {
                            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                        }
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }, 0L);
        }
    }

    public final void pushResetLater$okhttp(final int i10, final ErrorCode errorCode) {
        i.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i10 + "] onReset";
        final boolean z10 = true;
        taskQueue.schedule(new Task(str, z10, this, i10, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z10);
                this.$name = str;
                this.$cancelable = z10;
                this.this$0 = this;
                this.$streamId$inlined = i10;
                this.$errorCode$inlined = errorCode;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                this.this$0.pushObserver.onReset(this.$streamId$inlined, this.$errorCode$inlined);
                synchronized (this.this$0) {
                    this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                    h hVar = h.f16056a;
                }
                return -1L;
            }
        }, 0L);
    }

    public final Http2Stream pushStream(int i10, List<Header> list, boolean z10) throws IOException {
        i.checkNotNullParameter(list, "requestHeaders");
        if (!this.client) {
            return newStream(i10, list, z10);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i10) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(Integer.valueOf(i10));
        notifyAll();
        return http2StreamRemove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j10 = this.degradedPongsReceived;
            long j11 = this.degradedPingsSent;
            if (j10 < j11) {
                return;
            }
            this.degradedPingsSent = j11 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
            h hVar = h.f16056a;
            TaskQueue taskQueue = this.writerQueue;
            final String strStringPlus = i.stringPlus(this.connectionName, " ping");
            final boolean z10 = true;
            taskQueue.schedule(new Task(strStringPlus, z10, this) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$default$1
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ String $name;
                final /* synthetic */ Http2Connection this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(strStringPlus, z10);
                    this.$name = strStringPlus;
                    this.$cancelable = z10;
                    this.this$0 = this;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() throws IOException {
                    this.this$0.writePing(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i10) {
        this.lastGoodStreamId = i10;
    }

    public final void setNextStreamId$okhttp(int i10) {
        this.nextStreamId = i10;
    }

    public final void setPeerSettings(Settings settings) {
        i.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) throws IOException {
        i.checkNotNullParameter(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                getOkHttpSettings().merge(settings);
                h hVar = h.f16056a;
            }
            getWriter().settings(settings);
        }
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        i.checkNotNullParameter(errorCode, "statusCode");
        synchronized (this.writer) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                ref$IntRef.f15260b = getLastGoodStreamId$okhttp();
                h hVar = h.f16056a;
                getWriter().goAway(ref$IntRef.f15260b, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j10) {
        long j11 = this.readBytesTotal + j10;
        this.readBytesTotal = j11;
        long j12 = j11 - this.readBytesAcknowledged;
        if (j12 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j12);
            this.readBytesAcknowledged += j12;
        }
    }

    public final void writeData(int i10, boolean z10, c cVar, long j10) throws IOException {
        int iMin;
        long j11;
        if (j10 == 0) {
            this.writer.data(z10, i10, cVar, 0);
            return;
        }
        while (j10 > 0) {
            synchronized (this) {
                while (getWriteBytesTotal() >= getWriteBytesMaximum()) {
                    try {
                        if (!getStreams$okhttp().containsKey(Integer.valueOf(i10))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j10, getWriteBytesMaximum() - getWriteBytesTotal()), getWriter().maxDataLength());
                j11 = iMin;
                this.writeBytesTotal = getWriteBytesTotal() + j11;
                h hVar = h.f16056a;
            }
            j10 -= j11;
            this.writer.data(z10 && j10 == 0, i10, cVar, iMin);
        }
    }

    public final void writeHeaders$okhttp(int i10, boolean z10, List<Header> list) throws IOException {
        i.checkNotNullParameter(list, "alternating");
        this.writer.headers(z10, i10, list);
    }

    public final void writePing(boolean z10, int i10, int i11) throws IOException {
        try {
            this.writer.ping(z10, i10, i11);
        } catch (IOException e10) {
            failConnection(e10);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException, IOException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i10, ErrorCode errorCode) throws IOException {
        i.checkNotNullParameter(errorCode, "statusCode");
        this.writer.rstStream(i10, errorCode);
    }

    public final void writeSynResetLater$okhttp(final int i10, final ErrorCode errorCode) {
        i.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i10 + "] writeSynReset";
        final boolean z10 = true;
        taskQueue.schedule(new Task(str, z10, this, i10, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z10);
                this.$name = str;
                this.$cancelable = z10;
                this.this$0 = this;
                this.$streamId$inlined = i10;
                this.$errorCode$inlined = errorCode;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() throws IOException {
                try {
                    this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
                    return -1L;
                } catch (IOException e10) {
                    this.this$0.failConnection(e10);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i10, final long j10) {
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i10 + "] windowUpdate";
        final boolean z10 = true;
        taskQueue.schedule(new Task(str, z10, this, i10, j10) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ String $name;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ long $unacknowledgedBytesRead$inlined;
            final /* synthetic */ Http2Connection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z10);
                this.$name = str;
                this.$cancelable = z10;
                this.this$0 = this;
                this.$streamId$inlined = i10;
                this.$unacknowledgedBytesRead$inlined = j10;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() throws IOException {
                try {
                    this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
                    return -1L;
                } catch (IOException e10) {
                    this.this$0.failConnection(e10);
                    return -1L;
                }
            }
        }, 0L);
    }

    private final Http2Stream newStream(int i10, List<Header> list, boolean z10) throws IOException {
        int nextStreamId$okhttp;
        Http2Stream http2Stream;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.writer) {
            synchronized (this) {
                if (getNextStreamId$okhttp() > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                nextStreamId$okhttp = getNextStreamId$okhttp();
                setNextStreamId$okhttp(getNextStreamId$okhttp() + 2);
                http2Stream = new Http2Stream(nextStreamId$okhttp, this, z12, false, null);
                z11 = !z10 || getWriteBytesTotal() >= getWriteBytesMaximum() || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                if (http2Stream.isOpen()) {
                    getStreams$okhttp().put(Integer.valueOf(nextStreamId$okhttp), http2Stream);
                }
                h hVar = h.f16056a;
            }
            if (i10 == 0) {
                getWriter().headers(z12, nextStreamId$okhttp, list);
            } else {
                if (!(true ^ getClient$okhttp())) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                }
                getWriter().pushPromise(i10, nextStreamId$okhttp, list);
            }
        }
        if (z11) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public final void start(boolean z10) throws IOException {
        start$default(this, z10, null, 2, null);
    }

    public final void start(boolean z10, TaskRunner taskRunner) throws IOException {
        i.checkNotNullParameter(taskRunner, "taskRunner");
        if (z10) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r5 - Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        taskRunner.newQueue().schedule(new TaskQueue.AnonymousClass1(this.connectionName, true, this.readerRunnable), 0L);
    }

    public final void writePing() throws InterruptedException, IOException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
