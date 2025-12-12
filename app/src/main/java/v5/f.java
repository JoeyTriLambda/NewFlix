package v5;

import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import u5.a;
import u5.l;
import v5.g;

/* compiled from: ChunkSampleStream.java */
/* loaded from: classes.dex */
public final class f<T extends g> implements u5.k, u5.l, Loader.a<c>, Loader.d {
    public long A;
    public long B;
    public boolean C;

    /* renamed from: b, reason: collision with root package name */
    public final int f20488b;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f20489m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean[] f20490n;

    /* renamed from: o, reason: collision with root package name */
    public final T f20491o;

    /* renamed from: p, reason: collision with root package name */
    public final l.a<f<T>> f20492p;

    /* renamed from: q, reason: collision with root package name */
    public final a.C0284a f20493q;

    /* renamed from: r, reason: collision with root package name */
    public final int f20494r;

    /* renamed from: s, reason: collision with root package name */
    public final Loader f20495s = new Loader("Loader:ChunkSampleStream");

    /* renamed from: t, reason: collision with root package name */
    public final e f20496t = new e();

    /* renamed from: u, reason: collision with root package name */
    public final LinkedList<v5.a> f20497u;

    /* renamed from: v, reason: collision with root package name */
    public final List<v5.a> f20498v;

    /* renamed from: w, reason: collision with root package name */
    public final u5.j f20499w;

    /* renamed from: x, reason: collision with root package name */
    public final u5.j[] f20500x;

    /* renamed from: y, reason: collision with root package name */
    public final b f20501y;

    /* renamed from: z, reason: collision with root package name */
    public c5.i f20502z;

    public f(int i10, int[] iArr, T t10, l.a<f<T>> aVar, k6.b bVar, long j10, int i11, a.C0284a c0284a) {
        this.f20488b = i10;
        this.f20489m = iArr;
        this.f20491o = t10;
        this.f20492p = aVar;
        this.f20493q = c0284a;
        this.f20494r = i11;
        LinkedList<v5.a> linkedList = new LinkedList<>();
        this.f20497u = linkedList;
        this.f20498v = Collections.unmodifiableList(linkedList);
        int i12 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.f20500x = new u5.j[length];
        this.f20490n = new boolean[length];
        int i13 = length + 1;
        int[] iArr2 = new int[i13];
        u5.j[] jVarArr = new u5.j[i13];
        u5.j jVar = new u5.j(bVar);
        this.f20499w = jVar;
        iArr2[0] = i10;
        jVarArr[0] = jVar;
        while (i12 < length) {
            u5.j jVar2 = new u5.j(bVar);
            this.f20500x[i12] = jVar2;
            int i14 = i12 + 1;
            jVarArr[i14] = jVar2;
            iArr2[i14] = iArr[i12];
            i12 = i14;
        }
        this.f20501y = new b(iArr2, jVarArr);
        this.A = j10;
        this.B = j10;
    }

    public final void a(int i10) {
        LinkedList<v5.a> linkedList = this.f20497u;
        if (linkedList.isEmpty()) {
            return;
        }
        while (linkedList.size() > 1 && linkedList.get(1).getFirstSampleIndex(0) <= i10) {
            linkedList.removeFirst();
        }
        v5.a first = linkedList.getFirst();
        c5.i iVar = first.f20468c;
        if (!iVar.equals(this.f20502z)) {
            this.f20493q.downstreamFormatChanged(this.f20488b, iVar, first.f20469d, first.f20470e, first.f20471f);
        }
        this.f20502z = iVar;
    }

    public final boolean b() {
        return this.A != -9223372036854775807L;
    }

    @Override // u5.l
    public boolean continueLoading(long j10) {
        if (!this.C) {
            Loader loader = this.f20495s;
            if (!loader.isLoading()) {
                LinkedList<v5.a> linkedList = this.f20497u;
                v5.a last = linkedList.isEmpty() ? null : linkedList.getLast();
                long j11 = this.A;
                if (j11 == -9223372036854775807L) {
                    j11 = j10;
                }
                T t10 = this.f20491o;
                e eVar = this.f20496t;
                t10.getNextChunk(last, j11, eVar);
                boolean z10 = eVar.f20487b;
                c cVar = eVar.f20486a;
                eVar.clear();
                if (z10) {
                    this.A = -9223372036854775807L;
                    this.C = true;
                    return true;
                }
                if (cVar == null) {
                    return false;
                }
                if (cVar instanceof v5.a) {
                    this.A = -9223372036854775807L;
                    v5.a aVar = (v5.a) cVar;
                    aVar.init(this.f20501y);
                    linkedList.add(aVar);
                }
                this.f20493q.loadStarted(cVar.f20466a, cVar.f20467b, this.f20488b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, loader.startLoading(cVar, this, this.f20494r));
                return true;
            }
        }
        return false;
    }

    public void discardEmbeddedTracksTo(long j10) {
        int i10 = 0;
        while (true) {
            u5.j[] jVarArr = this.f20500x;
            if (i10 >= jVarArr.length) {
                return;
            }
            jVarArr[i10].discardTo(j10, true, this.f20490n[i10]);
            i10++;
        }
    }

    @Override // u5.l
    public long getBufferedPositionUs() {
        if (this.C) {
            return Long.MIN_VALUE;
        }
        if (b()) {
            return this.A;
        }
        long jMax = this.B;
        LinkedList<v5.a> linkedList = this.f20497u;
        v5.a last = linkedList.getLast();
        if (!last.isLoadCompleted()) {
            last = linkedList.size() > 1 ? linkedList.get(linkedList.size() - 2) : null;
        }
        if (last != null) {
            jMax = Math.max(jMax, last.f20472g);
        }
        return Math.max(jMax, this.f20499w.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.f20491o;
    }

    @Override // u5.l
    public long getNextLoadPositionUs() {
        if (b()) {
            return this.A;
        }
        if (this.C) {
            return Long.MIN_VALUE;
        }
        return this.f20497u.getLast().f20472g;
    }

    @Override // u5.k
    public boolean isReady() {
        return this.C || (!b() && this.f20499w.hasNextSample());
    }

    @Override // u5.k
    public void maybeThrowError() throws IOException {
        Loader loader = this.f20495s;
        loader.maybeThrowError();
        if (loader.isLoading()) {
            return;
        }
        this.f20491o.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void onLoaderReleased() {
        this.f20499w.reset();
        for (u5.j jVar : this.f20500x) {
            jVar.reset();
        }
    }

    @Override // u5.k
    public int readData(c5.j jVar, e5.e eVar, boolean z10) throws IllegalStateException {
        if (b()) {
            return -3;
        }
        u5.j jVar2 = this.f20499w;
        a(jVar2.getReadIndex());
        int i10 = this.f20499w.read(jVar, eVar, z10, this.C, this.B);
        if (i10 == -4) {
            jVar2.discardToRead();
        }
        return i10;
    }

    public void release() {
        if (this.f20495s.release(this)) {
            return;
        }
        this.f20499w.discardToEnd();
        for (u5.j jVar : this.f20500x) {
            jVar.discardToEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void seekToUs(long r7) {
        /*
            r6 = this;
            r6.B = r7
            boolean r0 = r6.b()
            u5.j r1 = r6.f20499w
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L1f
            long r4 = r6.getNextLoadPositionUs()
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 >= 0) goto L16
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            boolean r0 = r1.advanceTo(r7, r2, r0)
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            u5.j[] r4 = r6.f20500x
            if (r0 == 0) goto L3d
            int r0 = r1.getReadIndex()
            r6.a(r0)
            r1.discardToRead()
            int r0 = r4.length
            r1 = 0
        L30:
            if (r1 >= r0) goto L60
            r5 = r4[r1]
            r5.rewind()
            r5.discardTo(r7, r2, r3)
            int r1 = r1 + 1
            goto L30
        L3d:
            r6.A = r7
            r6.C = r3
            java.util.LinkedList<v5.a> r7 = r6.f20497u
            r7.clear()
            com.google.android.exoplayer2.upstream.Loader r7 = r6.f20495s
            boolean r8 = r7.isLoading()
            if (r8 == 0) goto L52
            r7.cancelLoading()
            goto L60
        L52:
            r1.reset()
            int r7 = r4.length
        L56:
            if (r3 >= r7) goto L60
            r8 = r4[r3]
            r8.reset()
            int r3 = r3 + 1
            goto L56
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.f.seekToUs(long):void");
    }

    public f<T>.a selectEmbeddedTrack(long j10, int i10) {
        int i11 = 0;
        while (true) {
            u5.j[] jVarArr = this.f20500x;
            if (i11 >= jVarArr.length) {
                throw new IllegalStateException();
            }
            if (this.f20489m[i11] == i10) {
                boolean[] zArr = this.f20490n;
                l6.a.checkState(!zArr[i11]);
                zArr[i11] = true;
                jVarArr[i11].rewind();
                jVarArr[i11].advanceTo(j10, true, true);
                return new a(this, jVarArr[i11], i11);
            }
            i11++;
        }
    }

    @Override // u5.k
    public void skipData(long j10) {
        boolean z10 = this.C;
        u5.j jVar = this.f20499w;
        if (!z10 || j10 <= jVar.getLargestQueuedTimestampUs()) {
            jVar.advanceTo(j10, true, true);
        } else {
            jVar.advanceToEnd();
        }
        jVar.discardToRead();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCanceled(c cVar, long j10, long j11, boolean z10) {
        this.f20493q.loadCanceled(cVar.f20466a, cVar.f20467b, this.f20488b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, j10, j11, cVar.bytesLoaded());
        if (z10) {
            return;
        }
        this.f20499w.reset();
        for (u5.j jVar : this.f20500x) {
            jVar.reset();
        }
        this.f20492p.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCompleted(c cVar, long j10, long j11) {
        this.f20491o.onChunkLoadCompleted(cVar);
        this.f20493q.loadCompleted(cVar.f20466a, cVar.f20467b, this.f20488b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, j10, j11, cVar.bytesLoaded());
        this.f20492p.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int onLoadError(c cVar, long j10, long j11, IOException iOException) {
        boolean z10;
        long jBytesLoaded = cVar.bytesLoaded();
        boolean z11 = cVar instanceof v5.a;
        LinkedList<v5.a> linkedList = this.f20497u;
        if (this.f20491o.onChunkLoadError(cVar, !z11 || jBytesLoaded == 0 || linkedList.size() > 1, iOException)) {
            if (z11) {
                v5.a aVarRemoveLast = linkedList.removeLast();
                l6.a.checkState(aVarRemoveLast == cVar);
                this.f20499w.discardUpstreamSamples(aVarRemoveLast.getFirstSampleIndex(0));
                int i10 = 0;
                while (true) {
                    u5.j[] jVarArr = this.f20500x;
                    if (i10 >= jVarArr.length) {
                        break;
                    }
                    u5.j jVar = jVarArr[i10];
                    i10++;
                    jVar.discardUpstreamSamples(aVarRemoveLast.getFirstSampleIndex(i10));
                }
                if (linkedList.isEmpty()) {
                    this.A = this.B;
                }
            }
            z10 = true;
        } else {
            z10 = false;
        }
        this.f20493q.loadError(cVar.f20466a, cVar.f20467b, this.f20488b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, j10, j11, jBytesLoaded, iOException, z10);
        if (!z10) {
            return 0;
        }
        this.f20492p.onContinueLoadingRequested(this);
        return 2;
    }

    /* compiled from: ChunkSampleStream.java */
    public final class a implements u5.k {

        /* renamed from: b, reason: collision with root package name */
        public final f<T> f20503b;

        /* renamed from: m, reason: collision with root package name */
        public final u5.j f20504m;

        /* renamed from: n, reason: collision with root package name */
        public final int f20505n;

        public a(f<T> fVar, u5.j jVar, int i10) {
            this.f20503b = fVar;
            this.f20504m = jVar;
            this.f20505n = i10;
        }

        @Override // u5.k
        public boolean isReady() {
            f fVar = f.this;
            return fVar.C || (!fVar.b() && this.f20504m.hasNextSample());
        }

        @Override // u5.k
        public int readData(c5.j jVar, e5.e eVar, boolean z10) {
            f fVar = f.this;
            if (fVar.b()) {
                return -3;
            }
            return this.f20504m.read(jVar, eVar, z10, fVar.C, fVar.B);
        }

        public void release() {
            f fVar = f.this;
            boolean[] zArr = fVar.f20490n;
            int i10 = this.f20505n;
            l6.a.checkState(zArr[i10]);
            fVar.f20490n[i10] = false;
        }

        @Override // u5.k
        public void skipData(long j10) {
            boolean z10 = f.this.C;
            u5.j jVar = this.f20504m;
            if (!z10 || j10 <= jVar.getLargestQueuedTimestampUs()) {
                jVar.advanceTo(j10, true, true);
            } else {
                jVar.advanceToEnd();
            }
        }

        @Override // u5.k
        public void maybeThrowError() throws IOException {
        }
    }
}
