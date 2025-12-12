package ah;

/* compiled from: PeekSource.kt */
/* loaded from: classes2.dex */
public final class r implements y {

    /* renamed from: b, reason: collision with root package name */
    public final e f710b;

    /* renamed from: m, reason: collision with root package name */
    public final c f711m;

    /* renamed from: n, reason: collision with root package name */
    public u f712n;

    /* renamed from: o, reason: collision with root package name */
    public int f713o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f714p;

    /* renamed from: q, reason: collision with root package name */
    public long f715q;

    public r(e eVar) {
        zf.i.checkNotNullParameter(eVar, "upstream");
        this.f710b = eVar;
        c buffer = eVar.getBuffer();
        this.f711m = buffer;
        u uVar = buffer.f676b;
        this.f712n = uVar;
        this.f713o = uVar == null ? -1 : uVar.f724b;
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f714p = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @Override // ah.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(ah.c r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            zf.i.checkNotNullParameter(r9, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 < 0) goto Lf
            r5 = 1
            goto L10
        Lf:
            r5 = 0
        L10:
            if (r5 == 0) goto L83
            boolean r5 = r8.f714p
            r5 = r5 ^ r1
            if (r5 == 0) goto L77
            ah.u r5 = r8.f712n
            ah.c r6 = r8.f711m
            if (r5 == 0) goto L2a
            ah.u r7 = r6.f676b
            if (r5 != r7) goto L2b
            int r5 = r8.f713o
            zf.i.checkNotNull(r7)
            int r7 = r7.f724b
            if (r5 != r7) goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L6b
            if (r4 != 0) goto L30
            return r2
        L30:
            long r0 = r8.f715q
            r2 = 1
            long r0 = r0 + r2
            ah.e r2 = r8.f710b
            boolean r0 = r2.request(r0)
            if (r0 != 0) goto L40
            r9 = -1
            return r9
        L40:
            ah.u r0 = r8.f712n
            if (r0 != 0) goto L51
            ah.u r0 = r6.f676b
            if (r0 == 0) goto L51
            r8.f712n = r0
            zf.i.checkNotNull(r0)
            int r0 = r0.f724b
            r8.f713o = r0
        L51:
            long r0 = r6.size()
            long r2 = r8.f715q
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            ah.c r2 = r8.f711m
            long r4 = r8.f715q
            r3 = r9
            r6 = r10
            r2.copyTo(r3, r4, r6)
            long r0 = r8.f715q
            long r0 = r0 + r10
            r8.f715q = r0
            return r10
        L6b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L77:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L83:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            java.lang.String r9 = zf.i.stringPlus(r9, r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ah.r.read(ah.c, long):long");
    }

    @Override // ah.y
    public z timeout() {
        return this.f710b.timeout();
    }
}
