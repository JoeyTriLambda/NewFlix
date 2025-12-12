package okhttp3.internal.cache2;

import ah.c;
import ah.y;
import ah.z;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import lf.h;
import okhttp3.internal.Util;
import okio.ByteString;
import zf.f;
import zf.i;

/* compiled from: Relay.kt */
/* loaded from: classes2.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN;
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final c buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private y upstream;
    private final c upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* compiled from: Relay.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Relay edit(File file, y yVar, ByteString byteString, long j10) throws IOException {
            i.checkNotNullParameter(file, "file");
            i.checkNotNullParameter(yVar, "upstream");
            i.checkNotNullParameter(byteString, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, yVar, 0L, byteString, j10, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            i.checkNotNullParameter(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            i.checkNotNullExpressionValue(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            c cVar = new c();
            fileOperator.read(0L, cVar, 32L);
            if (!i.areEqual(cVar.readByteString(r1.size()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long j10 = cVar.readLong();
            long j11 = cVar.readLong();
            c cVar2 = new c();
            fileOperator.read(j10 + 32, cVar2, j11);
            return new Relay(randomAccessFile, null, j10, cVar2.readByteString(), 0L, null);
        }
    }

    /* compiled from: Relay.kt */
    public final class RelaySource implements y {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final z timeout;

        public RelaySource(Relay relay) {
            i.checkNotNullParameter(relay, "this$0");
            this.this$0 = relay;
            this.timeout = new z();
            RandomAccessFile file = relay.getFile();
            i.checkNotNull(file);
            FileChannel channel = file.getChannel();
            i.checkNotNullExpressionValue(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = this.this$0;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
                h hVar = h.f16056a;
            }
            if (randomAccessFile == null) {
                return;
            }
            Util.closeQuietly(randomAccessFile);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        
            if (r4 != 2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        
            r10 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
            zf.i.checkNotNull(r2);
            r2.read(r19.sourcePos + 32, r20, r10);
            r19.sourcePos += r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        
            return r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
        
            r0 = r19.this$0.getUpstream();
            zf.i.checkNotNull(r0);
            r14 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        
            if (r14 != (-1)) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c3, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c5, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
            r0 = lf.h.f16056a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ce, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cf, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
        
            r11 = java.lang.Math.min(r14, r21);
            r19.this$0.getUpstreamBuffer().copyTo(r20, 0, r11);
            r19.sourcePos += r11;
            r13 = r19.fileOperator;
            zf.i.checkNotNull(r13);
            r13.write(r19.this$0.getUpstreamPos() + 32, r19.this$0.getUpstreamBuffer().m0clone(), r14);
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x010b, code lost:
        
            r2.getBuffer().write(r2.getUpstreamBuffer(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0124, code lost:
        
            if (r2.getBuffer().size() <= r2.getBufferMaxSize()) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0126, code lost:
        
            r2.getBuffer().skip(r2.getBuffer().size() - r2.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x013a, code lost:
        
            r2.setUpstreamPos(r2.getUpstreamPos() + r14);
            r0 = lf.h.f16056a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0144, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0147, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0148, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x014e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x014f, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0156, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0157, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0159, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
        
            r2.setUpstreamReader(null);
            r2.notifyAll();
            r3 = lf.h.f16056a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
        
            throw r0;
         */
        @Override // ah.y
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(ah.c r20, long r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 374
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(ah.c, long):long");
        }

        @Override // ah.y
        public z timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.a aVar = ByteString.f17101o;
        PREFIX_CLEAN = aVar.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = aVar.encodeUtf8("OkHttp DIRTY :(\n");
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, y yVar, long j10, ByteString byteString, long j11, f fVar) {
        this(randomAccessFile, yVar, j10, byteString, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j10, long j11) throws IOException {
        c cVar = new c();
        cVar.write(byteString);
        cVar.writeLong(j10);
        cVar.writeLong(j11);
        if (!(cVar.size() == 32)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.file;
        i.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        i.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(0L, cVar, 32L);
    }

    private final void writeMetadata(long j10) throws IOException {
        c cVar = new c();
        cVar.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        i.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        i.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j10, cVar, this.metadata.size());
    }

    public final void commit(long j10) throws IOException {
        writeMetadata(j10);
        RandomAccessFile randomAccessFile = this.file;
        i.checkNotNull(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j10, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        i.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            setComplete(true);
            h hVar = h.f16056a;
        }
        y yVar = this.upstream;
        if (yVar != null) {
            Util.closeQuietly(yVar);
        }
        this.upstream = null;
    }

    public final c getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final y getUpstream() {
        return this.upstream;
    }

    public final c getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final y newSource() {
        synchronized (this) {
            if (getFile() == null) {
                return null;
            }
            setSourceCount(getSourceCount() + 1);
            return new RelaySource(this);
        }
    }

    public final void setComplete(boolean z10) {
        this.complete = z10;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i10) {
        this.sourceCount = i10;
    }

    public final void setUpstream(y yVar) {
        this.upstream = yVar;
    }

    public final void setUpstreamPos(long j10) {
        this.upstreamPos = j10;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    private Relay(RandomAccessFile randomAccessFile, y yVar, long j10, ByteString byteString, long j11) {
        this.file = randomAccessFile;
        this.upstream = yVar;
        this.upstreamPos = j10;
        this.metadata = byteString;
        this.bufferMaxSize = j11;
        this.upstreamBuffer = new c();
        this.complete = this.upstream == null;
        this.buffer = new c();
    }
}
