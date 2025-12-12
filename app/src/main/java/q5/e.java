package q5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c5.i;
import c5.j;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import java.util.Arrays;

/* compiled from: MetadataRenderer.java */
/* loaded from: classes.dex */
public final class e extends c5.a implements Handler.Callback {
    public int A;
    public int B;
    public b C;
    public boolean D;

    /* renamed from: t, reason: collision with root package name */
    public final c f17889t;

    /* renamed from: u, reason: collision with root package name */
    public final a f17890u;

    /* renamed from: v, reason: collision with root package name */
    public final Handler f17891v;

    /* renamed from: w, reason: collision with root package name */
    public final j f17892w;

    /* renamed from: x, reason: collision with root package name */
    public final d f17893x;

    /* renamed from: y, reason: collision with root package name */
    public final q5.a[] f17894y;

    /* renamed from: z, reason: collision with root package name */
    public final long[] f17895z;

    /* compiled from: MetadataRenderer.java */
    public interface a {
        void onMetadata(q5.a aVar);
    }

    public e(a aVar, Looper looper, c cVar) {
        super(4);
        this.f17890u = (a) l6.a.checkNotNull(aVar);
        this.f17891v = looper == null ? null : new Handler(looper, this);
        this.f17889t = (c) l6.a.checkNotNull(cVar);
        this.f17892w = new j();
        this.f17893x = new d();
        this.f17894y = new q5.a[5];
        this.f17895z = new long[5];
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.f17890u.onMetadata((q5.a) message.obj);
        return true;
    }

    @Override // c5.o
    public boolean isEnded() {
        return this.D;
    }

    @Override // c5.o
    public boolean isReady() {
        return true;
    }

    @Override // c5.a
    public void onDisabled() {
        Arrays.fill(this.f17894y, (Object) null);
        this.A = 0;
        this.B = 0;
        this.C = null;
    }

    @Override // c5.a
    public void onPositionReset(long j10, boolean z10) {
        Arrays.fill(this.f17894y, (Object) null);
        this.A = 0;
        this.B = 0;
        this.D = false;
    }

    @Override // c5.a
    public void onStreamChanged(i[] iVarArr, long j10) throws ExoPlaybackException {
        this.C = this.f17889t.createDecoder(iVarArr[0]);
    }

    @Override // c5.o
    public void render(long j10, long j11) throws ExoPlaybackException {
        boolean z10 = this.D;
        long[] jArr = this.f17895z;
        q5.a[] aVarArr = this.f17894y;
        if (!z10 && this.B < 5) {
            d dVar = this.f17893x;
            dVar.clear();
            j jVar = this.f17892w;
            if (readSource(jVar, dVar, false) == -4) {
                if (dVar.isEndOfStream()) {
                    this.D = true;
                } else if (!dVar.isDecodeOnly()) {
                    dVar.f17888q = jVar.f5130a.H;
                    dVar.flip();
                    try {
                        int i10 = (this.A + this.B) % 5;
                        aVarArr[i10] = this.C.decode(dVar);
                        jArr[i10] = dVar.f11143o;
                        this.B++;
                    } catch (MetadataDecoderException e10) {
                        throw ExoPlaybackException.createForRenderer(e10, getIndex());
                    }
                }
            }
        }
        if (this.B > 0) {
            int i11 = this.A;
            if (jArr[i11] <= j10) {
                q5.a aVar = aVarArr[i11];
                Handler handler = this.f17891v;
                if (handler != null) {
                    handler.obtainMessage(0, aVar).sendToTarget();
                } else {
                    this.f17890u.onMetadata(aVar);
                }
                int i12 = this.A;
                aVarArr[i12] = null;
                this.A = (i12 + 1) % 5;
                this.B--;
            }
        }
    }

    @Override // c5.p
    public int supportsFormat(i iVar) {
        return this.f17889t.supportsFormat(iVar) ? 4 : 0;
    }
}
