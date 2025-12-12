package sa;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot.java */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f19211a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19212b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19213c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19214d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19215e;

    /* renamed from: f, reason: collision with root package name */
    public final long f19216f;

    /* renamed from: g, reason: collision with root package name */
    public final long f19217g;

    /* renamed from: h, reason: collision with root package name */
    public final long f19218h;

    /* renamed from: i, reason: collision with root package name */
    public final long f19219i;

    /* renamed from: j, reason: collision with root package name */
    public final long f19220j;

    /* renamed from: k, reason: collision with root package name */
    public final int f19221k;

    /* renamed from: l, reason: collision with root package name */
    public final int f19222l;

    /* renamed from: m, reason: collision with root package name */
    public final int f19223m;

    /* renamed from: n, reason: collision with root package name */
    public final long f19224n;

    public i(int i10, int i11, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, int i12, int i13, int i14, long j18) {
        this.f19211a = i10;
        this.f19212b = i11;
        this.f19213c = j10;
        this.f19214d = j11;
        this.f19215e = j12;
        this.f19216f = j13;
        this.f19217g = j14;
        this.f19218h = j15;
        this.f19219i = j16;
        this.f19220j = j17;
        this.f19221k = i12;
        this.f19222l = i13;
        this.f19223m = i14;
        this.f19224n = j18;
    }

    public void dump(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f19211a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f19212b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((r1 / r0) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f19213c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f19214d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f19221k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f19215e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f19218h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f19222l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f19216f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f19223m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f19217g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f19219i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f19220j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f19211a + ", size=" + this.f19212b + ", cacheHits=" + this.f19213c + ", cacheMisses=" + this.f19214d + ", downloadCount=" + this.f19221k + ", totalDownloadSize=" + this.f19215e + ", averageDownloadSize=" + this.f19218h + ", totalOriginalBitmapSize=" + this.f19216f + ", totalTransformedBitmapSize=" + this.f19217g + ", averageOriginalBitmapSize=" + this.f19219i + ", averageTransformedBitmapSize=" + this.f19220j + ", originalBitmapCount=" + this.f19222l + ", transformedBitmapCount=" + this.f19223m + ", timeStamp=" + this.f19224n + '}';
    }
}
