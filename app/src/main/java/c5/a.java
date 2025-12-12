package c5;

import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;

/* compiled from: BaseRenderer.java */
/* loaded from: classes.dex */
public abstract class a implements o, p {

    /* renamed from: b, reason: collision with root package name */
    public final int f5023b;

    /* renamed from: m, reason: collision with root package name */
    public q f5024m;

    /* renamed from: n, reason: collision with root package name */
    public int f5025n;

    /* renamed from: o, reason: collision with root package name */
    public int f5026o;

    /* renamed from: p, reason: collision with root package name */
    public u5.k f5027p;

    /* renamed from: q, reason: collision with root package name */
    public long f5028q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5029r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5030s;

    public a(int i10) {
        this.f5023b = i10;
    }

    @Override // c5.o
    public final void disable() {
        l6.a.checkState(this.f5026o == 1);
        this.f5026o = 0;
        this.f5027p = null;
        this.f5030s = false;
        onDisabled();
    }

    @Override // c5.o
    public final void enable(q qVar, i[] iVarArr, u5.k kVar, long j10, boolean z10, long j11) throws ExoPlaybackException {
        l6.a.checkState(this.f5026o == 0);
        this.f5024m = qVar;
        this.f5026o = 1;
        onEnabled(z10);
        replaceStream(iVarArr, kVar, j11);
        onPositionReset(j10, z10);
    }

    public final q getConfiguration() {
        return this.f5024m;
    }

    public final int getIndex() {
        return this.f5025n;
    }

    @Override // c5.o
    public l6.h getMediaClock() {
        return null;
    }

    @Override // c5.o
    public final int getState() {
        return this.f5026o;
    }

    @Override // c5.o
    public final u5.k getStream() {
        return this.f5027p;
    }

    @Override // c5.o
    public final int getTrackType() {
        return this.f5023b;
    }

    @Override // c5.o
    public final boolean hasReadStreamToEnd() {
        return this.f5029r;
    }

    @Override // c5.o
    public final boolean isCurrentStreamFinal() {
        return this.f5030s;
    }

    public final boolean isSourceReady() {
        return this.f5029r ? this.f5030s : this.f5027p.isReady();
    }

    @Override // c5.o
    public final void maybeThrowStreamError() throws IOException {
        this.f5027p.maybeThrowError();
    }

    public abstract void onDisabled();

    public abstract void onPositionReset(long j10, boolean z10) throws ExoPlaybackException;

    public final int readSource(j jVar, e5.e eVar, boolean z10) {
        int data = this.f5027p.readData(jVar, eVar, z10);
        if (data == -4) {
            if (eVar.isEndOfStream()) {
                this.f5029r = true;
                return this.f5030s ? -4 : -3;
            }
            eVar.f11143o += this.f5028q;
        } else if (data == -5) {
            i iVar = jVar.f5130a;
            long j10 = iVar.H;
            if (j10 != Long.MAX_VALUE) {
                jVar.f5130a = iVar.copyWithSubsampleOffsetUs(j10 + this.f5028q);
            }
        }
        return data;
    }

    @Override // c5.o
    public final void replaceStream(i[] iVarArr, u5.k kVar, long j10) throws ExoPlaybackException {
        l6.a.checkState(!this.f5030s);
        this.f5027p = kVar;
        this.f5029r = false;
        this.f5028q = j10;
        onStreamChanged(iVarArr, j10);
    }

    @Override // c5.o
    public final void resetPosition(long j10) throws ExoPlaybackException {
        this.f5030s = false;
        this.f5029r = false;
        onPositionReset(j10, false);
    }

    @Override // c5.o
    public final void setCurrentStreamFinal() {
        this.f5030s = true;
    }

    @Override // c5.o
    public final void setIndex(int i10) {
        this.f5025n = i10;
    }

    public void skipSource(long j10) {
        this.f5027p.skipData(j10 - this.f5028q);
    }

    @Override // c5.o
    public final void start() throws ExoPlaybackException {
        l6.a.checkState(this.f5026o == 1);
        this.f5026o = 2;
        onStarted();
    }

    @Override // c5.o
    public final void stop() throws ExoPlaybackException {
        l6.a.checkState(this.f5026o == 2);
        this.f5026o = 1;
        onStopped();
    }

    @Override // c5.p
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    @Override // c5.o
    public final p getCapabilities() {
        return this;
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() throws ExoPlaybackException {
    }

    public void onEnabled(boolean z10) throws ExoPlaybackException {
    }

    @Override // c5.d.a
    public void handleMessage(int i10, Object obj) throws ExoPlaybackException {
    }

    public void onStreamChanged(i[] iVarArr, long j10) throws ExoPlaybackException {
    }
}
