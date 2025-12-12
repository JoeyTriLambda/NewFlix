package b6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b6.f;
import c5.j;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.Collections;
import java.util.List;

/* compiled from: TextRenderer.java */
/* loaded from: classes.dex */
public final class i extends c5.a implements Handler.Callback {
    public c5.i A;
    public e B;
    public g C;
    public h D;
    public h E;
    public int F;

    /* renamed from: t, reason: collision with root package name */
    public final Handler f4785t;

    /* renamed from: u, reason: collision with root package name */
    public final a f4786u;

    /* renamed from: v, reason: collision with root package name */
    public final f f4787v;

    /* renamed from: w, reason: collision with root package name */
    public final j f4788w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4789x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4790y;

    /* renamed from: z, reason: collision with root package name */
    public int f4791z;

    /* compiled from: TextRenderer.java */
    public interface a {
        void onCues(List<b6.a> list);
    }

    public i(a aVar, Looper looper) {
        this(aVar, looper, f.f4781a);
    }

    public final long a() {
        int i10 = this.F;
        if (i10 == -1 || i10 >= this.D.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.D.getEventTime(this.F);
    }

    public final void b() {
        this.C = null;
        this.F = -1;
        h hVar = this.D;
        if (hVar != null) {
            hVar.release();
            this.D = null;
        }
        h hVar2 = this.E;
        if (hVar2 != null) {
            hVar2.release();
            this.E = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.f4786u.onCues((List) message.obj);
        return true;
    }

    @Override // c5.o
    public boolean isEnded() {
        return this.f4790y;
    }

    @Override // c5.o
    public boolean isReady() {
        return true;
    }

    @Override // c5.a
    public void onDisabled() {
        this.A = null;
        List<b6.a> listEmptyList = Collections.emptyList();
        Handler handler = this.f4785t;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.f4786u.onCues(listEmptyList);
        }
        b();
        this.B.release();
        this.B = null;
        this.f4791z = 0;
    }

    @Override // c5.a
    public void onPositionReset(long j10, boolean z10) {
        List<b6.a> listEmptyList = Collections.emptyList();
        Handler handler = this.f4785t;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.f4786u.onCues(listEmptyList);
        }
        this.f4789x = false;
        this.f4790y = false;
        if (this.f4791z == 0) {
            b();
            this.B.flush();
            return;
        }
        b();
        this.B.release();
        this.B = null;
        this.f4791z = 0;
        this.B = ((f.a) this.f4787v).createDecoder(this.A);
    }

    @Override // c5.a
    public void onStreamChanged(c5.i[] iVarArr, long j10) throws ExoPlaybackException {
        c5.i iVar = iVarArr[0];
        this.A = iVar;
        if (this.B != null) {
            this.f4791z = 1;
        } else {
            this.B = ((f.a) this.f4787v).createDecoder(iVar);
        }
    }

    @Override // c5.o
    public void render(long j10, long j11) throws Exception {
        boolean z10;
        j jVar = this.f4788w;
        if (this.f4790y) {
            return;
        }
        if (this.E == null) {
            this.B.setPositionUs(j10);
            try {
                this.E = this.B.dequeueOutputBuffer();
            } catch (SubtitleDecoderException e10) {
                throw ExoPlaybackException.createForRenderer(e10, getIndex());
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.D != null) {
            long jA = a();
            z10 = false;
            while (jA <= j10) {
                this.F++;
                jA = a();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        h hVar = this.E;
        if (hVar != null) {
            if (hVar.isEndOfStream()) {
                if (!z10 && a() == Long.MAX_VALUE) {
                    if (this.f4791z == 2) {
                        b();
                        this.B.release();
                        this.B = null;
                        this.f4791z = 0;
                        this.B = ((f.a) this.f4787v).createDecoder(this.A);
                    } else {
                        b();
                        this.f4790y = true;
                    }
                }
            } else if (this.E.f11145m <= j10) {
                h hVar2 = this.D;
                if (hVar2 != null) {
                    hVar2.release();
                }
                h hVar3 = this.E;
                this.D = hVar3;
                this.E = null;
                this.F = hVar3.getNextEventTimeIndex(j10);
                z10 = true;
            }
        }
        if (z10) {
            List<b6.a> cues = this.D.getCues(j10);
            Handler handler = this.f4785t;
            if (handler != null) {
                handler.obtainMessage(0, cues).sendToTarget();
            } else {
                this.f4786u.onCues(cues);
            }
        }
        if (this.f4791z == 2) {
            return;
        }
        while (!this.f4789x) {
            try {
                if (this.C == null) {
                    g gVarDequeueInputBuffer = this.B.dequeueInputBuffer();
                    this.C = gVarDequeueInputBuffer;
                    if (gVarDequeueInputBuffer == null) {
                        return;
                    }
                }
                if (this.f4791z == 1) {
                    this.C.setFlags(4);
                    this.B.queueInputBuffer(this.C);
                    this.C = null;
                    this.f4791z = 2;
                    return;
                }
                int source = readSource(jVar, this.C, false);
                if (source == -4) {
                    if (this.C.isEndOfStream()) {
                        this.f4789x = true;
                    } else {
                        g gVar = this.C;
                        gVar.f4782q = jVar.f5130a.H;
                        gVar.flip();
                    }
                    this.B.queueInputBuffer(this.C);
                    this.C = null;
                } else if (source == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e11) {
                throw ExoPlaybackException.createForRenderer(e11, getIndex());
            }
        }
    }

    @Override // c5.p
    public int supportsFormat(c5.i iVar) {
        if (((f.a) this.f4787v).supportsFormat(iVar)) {
            return 4;
        }
        return l6.i.isText(iVar.f5120q) ? 1 : 0;
    }

    public i(a aVar, Looper looper, f fVar) {
        super(3);
        this.f4786u = (a) l6.a.checkNotNull(aVar);
        this.f4785t = looper == null ? null : new Handler(looper, this);
        this.f4787v = fVar;
        this.f4788w = new j();
    }
}
