package j5;

import g5.e;
import g5.f;
import g5.g;
import g5.i;
import g5.j;
import g5.m;
import java.io.IOException;
import l6.l;
import l6.u;

/* compiled from: Mp3Extractor.java */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: n, reason: collision with root package name */
    public static final int f14596n = u.getIntegerCodeForString("Xing");

    /* renamed from: o, reason: collision with root package name */
    public static final int f14597o = u.getIntegerCodeForString("Info");

    /* renamed from: p, reason: collision with root package name */
    public static final int f14598p = u.getIntegerCodeForString("VBRI");

    /* renamed from: a, reason: collision with root package name */
    public final int f14599a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14600b;

    /* renamed from: c, reason: collision with root package name */
    public final l f14601c;

    /* renamed from: d, reason: collision with root package name */
    public final j f14602d;

    /* renamed from: e, reason: collision with root package name */
    public final i f14603e;

    /* renamed from: f, reason: collision with root package name */
    public g f14604f;

    /* renamed from: g, reason: collision with root package name */
    public m f14605g;

    /* renamed from: h, reason: collision with root package name */
    public int f14606h;

    /* renamed from: i, reason: collision with root package name */
    public q5.a f14607i;

    /* renamed from: j, reason: collision with root package name */
    public a f14608j;

    /* renamed from: k, reason: collision with root package name */
    public long f14609k;

    /* renamed from: l, reason: collision with root package name */
    public long f14610l;

    /* renamed from: m, reason: collision with root package name */
    public int f14611m;

    /* compiled from: Mp3Extractor.java */
    public interface a extends g5.l {
        long getTimeUs(long j10);
    }

    public b(int i10) {
        this(i10, -9223372036854775807L);
    }

    public final j5.a a(f fVar) throws InterruptedException, IOException {
        l lVar = this.f14601c;
        g5.b bVar = (g5.b) fVar;
        bVar.peekFully(lVar.f15881a, 0, 4);
        lVar.setPosition(0);
        int i10 = lVar.readInt();
        j jVar = this.f14602d;
        j.populateHeader(i10, jVar);
        return new j5.a(bVar.getPosition(), jVar.f12724f, bVar.getLength());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(g5.f r18, boolean r19) throws java.lang.InterruptedException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.b.b(g5.f, boolean):boolean");
    }

    @Override // g5.e
    public void init(g gVar) {
        this.f14604f = gVar;
        this.f14605g = gVar.track(0, 1);
        this.f14604f.endTracks();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012d  */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(g5.f r33, g5.k r34) throws java.lang.InterruptedException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.b.read(g5.f, g5.k):int");
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f14606h = 0;
        this.f14609k = -9223372036854775807L;
        this.f14610l = 0L;
        this.f14611m = 0;
    }

    @Override // g5.e
    public boolean sniff(f fVar) throws InterruptedException, IOException {
        return b(fVar, true);
    }

    public b(int i10, long j10) {
        this.f14599a = i10;
        this.f14600b = j10;
        this.f14601c = new l(10);
        this.f14602d = new j();
        this.f14603e = new i();
        this.f14609k = -9223372036854775807L;
    }

    @Override // g5.e
    public void release() {
    }
}
