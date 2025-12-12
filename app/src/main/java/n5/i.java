package n5;

import java.util.Arrays;
import n5.v;

/* compiled from: H262Reader.java */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: n, reason: collision with root package name */
    public static final double[] f16546n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f16547a;

    /* renamed from: b, reason: collision with root package name */
    public g5.m f16548b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16549c;

    /* renamed from: d, reason: collision with root package name */
    public long f16550d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f16551e = new boolean[4];

    /* renamed from: f, reason: collision with root package name */
    public final a f16552f = new a(128);

    /* renamed from: g, reason: collision with root package name */
    public long f16553g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16554h;

    /* renamed from: i, reason: collision with root package name */
    public long f16555i;

    /* renamed from: j, reason: collision with root package name */
    public long f16556j;

    /* renamed from: k, reason: collision with root package name */
    public long f16557k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16558l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16559m;

    /* compiled from: H262Reader.java */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final byte[] f16560e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        public boolean f16561a;

        /* renamed from: b, reason: collision with root package name */
        public int f16562b;

        /* renamed from: c, reason: collision with root package name */
        public int f16563c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f16564d;

        public a(int i10) {
            this.f16564d = new byte[i10];
        }

        public void onData(byte[] bArr, int i10, int i11) {
            if (this.f16561a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f16564d;
                int length = bArr2.length;
                int i13 = this.f16562b;
                if (length < i13 + i12) {
                    this.f16564d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy(bArr, i10, this.f16564d, this.f16562b, i12);
                this.f16562b += i12;
            }
        }

        public boolean onStartCode(int i10, int i11) {
            if (this.f16561a) {
                int i12 = this.f16562b - i11;
                this.f16562b = i12;
                if (this.f16563c != 0 || i10 != 181) {
                    this.f16561a = false;
                    return true;
                }
                this.f16563c = i12;
            } else if (i10 == 179) {
                this.f16561a = true;
            }
            onData(f16560e, 0, 3);
            return false;
        }

        public void reset() {
            this.f16561a = false;
            this.f16562b = 0;
            this.f16563c = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0108  */
    @Override // n5.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consume(l6.l r28) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.i.consume(l6.l):void");
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16547a = dVar.getFormatId();
        this.f16548b = gVar.track(dVar.getTrackId(), 2);
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16555i = j10;
    }

    @Override // n5.h
    public void seek() {
        l6.j.clearPrefixFlags(this.f16551e);
        this.f16552f.reset();
        this.f16553g = 0L;
        this.f16554h = false;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
