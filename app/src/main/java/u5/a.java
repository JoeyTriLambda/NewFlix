package u5;

import android.os.Handler;
import java.io.IOException;

/* compiled from: AdaptiveMediaSourceEventListener.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: AdaptiveMediaSourceEventListener.java */
    /* renamed from: u5.a$a, reason: collision with other inner class name */
    public static final class C0284a {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f19998a;

        public C0284a(Handler handler, a aVar) {
            this(handler, aVar, 0L);
        }

        public C0284a copyWithMediaTimeOffsetMs(long j10) {
            return new C0284a(this.f19998a, null, j10);
        }

        public void loadCanceled(k6.f fVar, int i10, int i11, c5.i iVar, int i12, Object obj, long j10, long j11, long j12, long j13, long j14) {
        }

        public void loadCompleted(k6.f fVar, int i10, int i11, c5.i iVar, int i12, Object obj, long j10, long j11, long j12, long j13, long j14) {
        }

        public void loadError(k6.f fVar, int i10, int i11, c5.i iVar, int i12, Object obj, long j10, long j11, long j12, long j13, long j14, IOException iOException, boolean z10) {
        }

        public void loadStarted(k6.f fVar, int i10, int i11, c5.i iVar, int i12, Object obj, long j10, long j11, long j12) {
        }

        public C0284a(Handler handler, a aVar, long j10) {
            this.f19998a = aVar != null ? (Handler) l6.a.checkNotNull(handler) : null;
        }

        public void loadCanceled(k6.f fVar, int i10, long j10, long j11, long j12) {
            loadCanceled(fVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j10, j11, j12);
        }

        public void loadCompleted(k6.f fVar, int i10, long j10, long j11, long j12) {
            loadCompleted(fVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j10, j11, j12);
        }

        public void loadError(k6.f fVar, int i10, long j10, long j11, long j12, IOException iOException, boolean z10) {
            loadError(fVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j10, j11, j12, iOException, z10);
        }

        public void loadStarted(k6.f fVar, int i10, long j10) {
            loadStarted(fVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j10);
        }

        public void downstreamFormatChanged(int i10, c5.i iVar, int i11, Object obj, long j10) {
        }
    }
}
