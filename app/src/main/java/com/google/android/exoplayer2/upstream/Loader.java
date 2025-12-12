package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import k6.m;
import l6.s;
import l6.u;

/* loaded from: classes.dex */
public final class Loader implements m {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f6029a;

    /* renamed from: b, reason: collision with root package name */
    public b<? extends c> f6030b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f6031c;

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th2) {
            super("Unexpected " + th2.getClass().getSimpleName() + ": " + th2.getMessage(), th2);
        }
    }

    public interface a<T extends c> {
        void onLoadCanceled(T t10, long j10, long j11, boolean z10);

        void onLoadCompleted(T t10, long j10, long j11);

        int onLoadError(T t10, long j10, long j11, IOException iOException);
    }

    @SuppressLint({"HandlerLeak"})
    public final class b<T extends c> extends Handler implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final T f6032b;

        /* renamed from: m, reason: collision with root package name */
        public final a<T> f6033m;

        /* renamed from: n, reason: collision with root package name */
        public final int f6034n;

        /* renamed from: o, reason: collision with root package name */
        public final long f6035o;

        /* renamed from: p, reason: collision with root package name */
        public IOException f6036p;

        /* renamed from: q, reason: collision with root package name */
        public int f6037q;

        /* renamed from: r, reason: collision with root package name */
        public volatile Thread f6038r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f6039s;

        public b(Looper looper, T t10, a<T> aVar, int i10, long j10) {
            super(looper);
            this.f6032b = t10;
            this.f6033m = aVar;
            this.f6034n = i10;
            this.f6035o = j10;
        }

        public void cancel(boolean z10) {
            this.f6039s = z10;
            this.f6036p = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z10) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f6032b.cancelLoad();
                if (this.f6038r != null) {
                    this.f6038r.interrupt();
                }
            }
            if (z10) {
                Loader.this.f6030b = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f6033m.onLoadCanceled(this.f6032b, jElapsedRealtime, jElapsedRealtime - this.f6035o, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f6039s) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                this.f6036p = null;
                Loader loader = Loader.this;
                loader.f6029a.execute(loader.f6030b);
                return;
            }
            if (i10 == 4) {
                throw ((Error) message.obj);
            }
            Loader.this.f6030b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - this.f6035o;
            if (this.f6032b.isLoadCanceled()) {
                this.f6033m.onLoadCanceled(this.f6032b, jElapsedRealtime, j10, false);
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                this.f6033m.onLoadCanceled(this.f6032b, jElapsedRealtime, j10, false);
                return;
            }
            if (i11 == 2) {
                this.f6033m.onLoadCompleted(this.f6032b, jElapsedRealtime, j10);
                return;
            }
            if (i11 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f6036p = iOException;
            int iOnLoadError = this.f6033m.onLoadError(this.f6032b, jElapsedRealtime, j10, iOException);
            if (iOnLoadError == 3) {
                Loader.this.f6031c = this.f6036p;
            } else if (iOnLoadError != 2) {
                this.f6037q = iOnLoadError != 1 ? 1 + this.f6037q : 1;
                start(Math.min((r1 - 1) * 1000, 5000));
            }
        }

        public void maybeThrowError(int i10) throws IOException {
            IOException iOException = this.f6036p;
            if (iOException != null && this.f6037q > i10) {
                throw iOException;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6038r = Thread.currentThread();
                if (!this.f6032b.isLoadCanceled()) {
                    s.beginSection("load:".concat(this.f6032b.getClass().getSimpleName()));
                    try {
                        this.f6032b.load();
                        s.endSection();
                    } catch (Throwable th2) {
                        s.endSection();
                        throw th2;
                    }
                }
                if (this.f6039s) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e10) {
                if (this.f6039s) {
                    return;
                }
                obtainMessage(3, e10).sendToTarget();
            } catch (Exception e11) {
                Log.e("LoadTask", "Unexpected exception loading stream", e11);
                if (this.f6039s) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e11)).sendToTarget();
            } catch (OutOfMemoryError e12) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e12);
                if (this.f6039s) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e12)).sendToTarget();
            } catch (Error e13) {
                Log.e("LoadTask", "Unexpected error loading stream", e13);
                if (!this.f6039s) {
                    obtainMessage(4, e13).sendToTarget();
                }
                throw e13;
            } catch (InterruptedException unused) {
                l6.a.checkState(this.f6032b.isLoadCanceled());
                if (this.f6039s) {
                    return;
                }
                sendEmptyMessage(2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void start(long j10) {
            Loader loader = Loader.this;
            l6.a.checkState(loader.f6030b == null);
            loader.f6030b = this;
            if (j10 > 0) {
                sendEmptyMessageDelayed(0, j10);
            } else {
                this.f6036p = null;
                loader.f6029a.execute(loader.f6030b);
            }
        }
    }

    public interface c {
        void cancelLoad();

        boolean isLoadCanceled();

        void load() throws InterruptedException, IOException;
    }

    public interface d {
        void onLoaderReleased();
    }

    public static final class e extends Handler implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final d f6041b;

        public e(d dVar) {
            this.f6041b = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f6041b.onLoaderReleased();
        }

        @Override // java.lang.Runnable
        public void run() {
            sendEmptyMessage(0);
        }
    }

    public Loader(String str) {
        this.f6029a = u.newSingleThreadExecutor(str);
    }

    public void cancelLoading() {
        this.f6030b.cancel(false);
    }

    public boolean isLoading() {
        return this.f6030b != null;
    }

    @Override // k6.m
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void release() {
        release(null);
    }

    public <T extends c> long startLoading(T t10, a<T> aVar, int i10) {
        Looper looperMyLooper = Looper.myLooper();
        l6.a.checkState(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new b(looperMyLooper, t10, aVar, i10, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }

    public void maybeThrowError(int i10) throws IOException {
        IOException iOException = this.f6031c;
        if (iOException != null) {
            throw iOException;
        }
        b<? extends c> bVar = this.f6030b;
        if (bVar != null) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = bVar.f6034n;
            }
            bVar.maybeThrowError(i10);
        }
    }

    public boolean release(d dVar) {
        b<? extends c> bVar = this.f6030b;
        ExecutorService executorService = this.f6029a;
        boolean z10 = true;
        if (bVar == null) {
            if (dVar != null) {
                dVar.onLoaderReleased();
            }
            executorService.shutdown();
            return z10;
        }
        bVar.cancel(true);
        if (dVar != null) {
            executorService.execute(new e(dVar));
        }
        z10 = false;
        executorService.shutdown();
        return z10;
    }
}
