package v5;

import java.io.IOException;
import java.util.Arrays;
import l6.u;
import okhttp3.internal.http2.Http2;

/* compiled from: DataChunk.java */
/* loaded from: classes.dex */
public abstract class j extends c {

    /* renamed from: i, reason: collision with root package name */
    public byte[] f20513i;

    /* renamed from: j, reason: collision with root package name */
    public int f20514j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f20515k;

    public j(k6.d dVar, k6.f fVar, int i10, c5.i iVar, int i11, Object obj, byte[] bArr) {
        super(dVar, fVar, i10, iVar, i11, obj, -9223372036854775807L, -9223372036854775807L);
        this.f20513i = bArr;
    }

    @Override // v5.c
    public long bytesLoaded() {
        return this.f20514j;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.f20515k = true;
    }

    public abstract void consume(byte[] bArr, int i10) throws IOException;

    public byte[] getDataHolder() {
        return this.f20513i;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean isLoadCanceled() {
        return this.f20515k;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws InterruptedException, IOException {
        try {
            this.f20473h.open(this.f20466a);
            int i10 = 0;
            this.f20514j = 0;
            while (i10 != -1 && !this.f20515k) {
                byte[] bArr = this.f20513i;
                if (bArr == null) {
                    this.f20513i = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
                } else if (bArr.length < this.f20514j + Http2.INITIAL_MAX_FRAME_SIZE) {
                    this.f20513i = Arrays.copyOf(bArr, bArr.length + Http2.INITIAL_MAX_FRAME_SIZE);
                }
                i10 = this.f20473h.read(this.f20513i, this.f20514j, Http2.INITIAL_MAX_FRAME_SIZE);
                if (i10 != -1) {
                    this.f20514j += i10;
                }
            }
            if (!this.f20515k) {
                consume(this.f20513i, this.f20514j);
            }
        } finally {
            u.closeQuietly(this.f20473h);
        }
    }
}
