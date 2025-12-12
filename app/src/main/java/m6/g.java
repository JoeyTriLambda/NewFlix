package m6;

import android.os.Handler;
import android.view.Surface;
import c5.i;

/* compiled from: VideoRendererEventListener.java */
/* loaded from: classes.dex */
public interface g {

    /* compiled from: VideoRendererEventListener.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f16175a;

        /* renamed from: b, reason: collision with root package name */
        public final g f16176b;

        /* compiled from: VideoRendererEventListener.java */
        /* renamed from: m6.g$a$a, reason: collision with other inner class name */
        public class RunnableC0195a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e5.d f16177b;

            public RunnableC0195a(e5.d dVar) {
                this.f16177b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16176b.onVideoEnabled(this.f16177b);
            }
        }

        /* compiled from: VideoRendererEventListener.java */
        public class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f16179b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ long f16180m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ long f16181n;

            public b(String str, long j10, long j11) {
                this.f16179b = str;
                this.f16180m = j10;
                this.f16181n = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16176b.onVideoDecoderInitialized(this.f16179b, this.f16180m, this.f16181n);
            }
        }

        /* compiled from: VideoRendererEventListener.java */
        public class c implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f16183b;

            public c(i iVar) {
                this.f16183b = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16176b.onVideoInputFormatChanged(this.f16183b);
            }
        }

        /* compiled from: VideoRendererEventListener.java */
        public class d implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f16185b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ long f16186m;

            public d(int i10, long j10) {
                this.f16185b = i10;
                this.f16186m = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16176b.onDroppedFrames(this.f16185b, this.f16186m);
            }
        }

        /* compiled from: VideoRendererEventListener.java */
        public class e implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f16188b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ int f16189m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ int f16190n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ float f16191o;

            public e(int i10, int i11, int i12, float f10) {
                this.f16188b = i10;
                this.f16189m = i11;
                this.f16190n = i12;
                this.f16191o = f10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16176b.onVideoSizeChanged(this.f16188b, this.f16189m, this.f16190n, this.f16191o);
            }
        }

        /* compiled from: VideoRendererEventListener.java */
        public class f implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Surface f16193b;

            public f(Surface surface) {
                this.f16193b = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16176b.onRenderedFirstFrame(this.f16193b);
            }
        }

        /* compiled from: VideoRendererEventListener.java */
        /* renamed from: m6.g$a$g, reason: collision with other inner class name */
        public class RunnableC0196g implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e5.d f16195b;

            public RunnableC0196g(e5.d dVar) {
                this.f16195b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                e5.d dVar = this.f16195b;
                dVar.ensureUpdated();
                a.this.f16176b.onVideoDisabled(dVar);
            }
        }

        public a(Handler handler, g gVar) {
            this.f16175a = gVar != null ? (Handler) l6.a.checkNotNull(handler) : null;
            this.f16176b = gVar;
        }

        public void decoderInitialized(String str, long j10, long j11) {
            if (this.f16176b != null) {
                this.f16175a.post(new b(str, j10, j11));
            }
        }

        public void disabled(e5.d dVar) {
            if (this.f16176b != null) {
                this.f16175a.post(new RunnableC0196g(dVar));
            }
        }

        public void droppedFrames(int i10, long j10) {
            if (this.f16176b != null) {
                this.f16175a.post(new d(i10, j10));
            }
        }

        public void enabled(e5.d dVar) {
            if (this.f16176b != null) {
                this.f16175a.post(new RunnableC0195a(dVar));
            }
        }

        public void inputFormatChanged(i iVar) {
            if (this.f16176b != null) {
                this.f16175a.post(new c(iVar));
            }
        }

        public void renderedFirstFrame(Surface surface) {
            if (this.f16176b != null) {
                this.f16175a.post(new f(surface));
            }
        }

        public void videoSizeChanged(int i10, int i11, int i12, float f10) {
            if (this.f16176b != null) {
                this.f16175a.post(new e(i10, i11, i12, f10));
            }
        }
    }

    void onDroppedFrames(int i10, long j10);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j10, long j11);

    void onVideoDisabled(e5.d dVar);

    void onVideoEnabled(e5.d dVar);

    void onVideoInputFormatChanged(i iVar);

    void onVideoSizeChanged(int i10, int i11, int i12, float f10);
}
