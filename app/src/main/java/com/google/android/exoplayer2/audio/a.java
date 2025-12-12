package com.google.android.exoplayer2.audio;

import android.os.Handler;
import c5.i;

/* compiled from: AudioRendererEventListener.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: AudioRendererEventListener.java */
    /* renamed from: com.google.android.exoplayer2.audio.a$a, reason: collision with other inner class name */
    public static final class C0068a {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f5753a;

        /* renamed from: b, reason: collision with root package name */
        public final a f5754b;

        /* compiled from: AudioRendererEventListener.java */
        /* renamed from: com.google.android.exoplayer2.audio.a$a$a, reason: collision with other inner class name */
        public class RunnableC0069a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e5.d f5755b;

            public RunnableC0069a(e5.d dVar) {
                this.f5755b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0068a.this.f5754b.onAudioEnabled(this.f5755b);
            }
        }

        /* compiled from: AudioRendererEventListener.java */
        /* renamed from: com.google.android.exoplayer2.audio.a$a$b */
        public class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f5757b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ long f5758m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ long f5759n;

            public b(String str, long j10, long j11) {
                this.f5757b = str;
                this.f5758m = j10;
                this.f5759n = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0068a.this.f5754b.onAudioDecoderInitialized(this.f5757b, this.f5758m, this.f5759n);
            }
        }

        /* compiled from: AudioRendererEventListener.java */
        /* renamed from: com.google.android.exoplayer2.audio.a$a$c */
        public class c implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f5761b;

            public c(i iVar) {
                this.f5761b = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0068a.this.f5754b.onAudioInputFormatChanged(this.f5761b);
            }
        }

        /* compiled from: AudioRendererEventListener.java */
        /* renamed from: com.google.android.exoplayer2.audio.a$a$d */
        public class d implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f5763b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ long f5764m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ long f5765n;

            public d(int i10, long j10, long j11) {
                this.f5763b = i10;
                this.f5764m = j10;
                this.f5765n = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0068a.this.f5754b.onAudioTrackUnderrun(this.f5763b, this.f5764m, this.f5765n);
            }
        }

        /* compiled from: AudioRendererEventListener.java */
        /* renamed from: com.google.android.exoplayer2.audio.a$a$e */
        public class e implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e5.d f5767b;

            public e(e5.d dVar) {
                this.f5767b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                e5.d dVar = this.f5767b;
                dVar.ensureUpdated();
                C0068a.this.f5754b.onAudioDisabled(dVar);
            }
        }

        /* compiled from: AudioRendererEventListener.java */
        /* renamed from: com.google.android.exoplayer2.audio.a$a$f */
        public class f implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f5769b;

            public f(int i10) {
                this.f5769b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0068a.this.f5754b.onAudioSessionId(this.f5769b);
            }
        }

        public C0068a(Handler handler, a aVar) {
            this.f5753a = aVar != null ? (Handler) l6.a.checkNotNull(handler) : null;
            this.f5754b = aVar;
        }

        public void audioSessionId(int i10) {
            if (this.f5754b != null) {
                this.f5753a.post(new f(i10));
            }
        }

        public void audioTrackUnderrun(int i10, long j10, long j11) {
            if (this.f5754b != null) {
                this.f5753a.post(new d(i10, j10, j11));
            }
        }

        public void decoderInitialized(String str, long j10, long j11) {
            if (this.f5754b != null) {
                this.f5753a.post(new b(str, j10, j11));
            }
        }

        public void disabled(e5.d dVar) {
            if (this.f5754b != null) {
                this.f5753a.post(new e(dVar));
            }
        }

        public void enabled(e5.d dVar) {
            if (this.f5754b != null) {
                this.f5753a.post(new RunnableC0069a(dVar));
            }
        }

        public void inputFormatChanged(i iVar) {
            if (this.f5754b != null) {
                this.f5753a.post(new c(iVar));
            }
        }
    }

    void onAudioDecoderInitialized(String str, long j10, long j11);

    void onAudioDisabled(e5.d dVar);

    void onAudioEnabled(e5.d dVar);

    void onAudioInputFormatChanged(i iVar);

    void onAudioSessionId(int i10);

    void onAudioTrackUnderrun(int i10, long j10, long j11);
}
