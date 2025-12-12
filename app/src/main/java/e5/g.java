package e5;

import e5.e;
import e5.f;
import java.lang.Exception;
import java.util.LinkedList;

/* compiled from: SimpleDecoder.java */
/* loaded from: classes.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a, reason: collision with root package name */
    public final a f11146a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11147b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedList<I> f11148c = new LinkedList<>();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList<O> f11149d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    public final I[] f11150e;

    /* renamed from: f, reason: collision with root package name */
    public final O[] f11151f;

    /* renamed from: g, reason: collision with root package name */
    public int f11152g;

    /* renamed from: h, reason: collision with root package name */
    public int f11153h;

    /* renamed from: i, reason: collision with root package name */
    public I f11154i;

    /* renamed from: j, reason: collision with root package name */
    public E f11155j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11156k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11157l;

    /* compiled from: SimpleDecoder.java */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.getClass();
            do {
                try {
                } catch (InterruptedException e10) {
                    throw new IllegalStateException(e10);
                }
            } while (gVar.a());
        }
    }

    public g(I[] iArr, O[] oArr) {
        this.f11150e = iArr;
        this.f11152g = iArr.length;
        for (int i10 = 0; i10 < this.f11152g; i10++) {
            ((I[]) this.f11150e)[i10] = createInputBuffer();
        }
        this.f11151f = oArr;
        this.f11153h = oArr.length;
        for (int i11 = 0; i11 < this.f11153h; i11++) {
            ((O[]) this.f11151f)[i11] = createOutputBuffer();
        }
        a aVar = new a();
        this.f11146a = aVar;
        aVar.start();
    }

    public final boolean a() throws InterruptedException {
        synchronized (this.f11147b) {
            while (!this.f11157l) {
                try {
                    if (!this.f11148c.isEmpty() && this.f11153h > 0) {
                        break;
                    }
                    this.f11147b.wait();
                } finally {
                }
            }
            if (this.f11157l) {
                return false;
            }
            I iRemoveFirst = this.f11148c.removeFirst();
            O[] oArr = this.f11151f;
            int i10 = this.f11153h - 1;
            this.f11153h = i10;
            O o6 = oArr[i10];
            boolean z10 = this.f11156k;
            this.f11156k = false;
            if (iRemoveFirst.isEndOfStream()) {
                o6.addFlag(4);
            } else {
                if (iRemoveFirst.isDecodeOnly()) {
                    o6.addFlag(Integer.MIN_VALUE);
                }
                E e10 = (E) decode(iRemoveFirst, o6, z10);
                this.f11155j = e10;
                if (e10 != null) {
                    synchronized (this.f11147b) {
                    }
                    return false;
                }
            }
            synchronized (this.f11147b) {
                if (this.f11156k || o6.isDecodeOnly()) {
                    b(o6);
                } else {
                    this.f11149d.addLast(o6);
                }
                iRemoveFirst.clear();
                int i11 = this.f11152g;
                this.f11152g = i11 + 1;
                this.f11150e[i11] = iRemoveFirst;
            }
            return true;
        }
    }

    public final void b(O o6) {
        o6.clear();
        int i10 = this.f11153h;
        this.f11153h = i10 + 1;
        this.f11151f[i10] = o6;
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E decode(I i10, O o6, boolean z10);

    @Override // e5.c
    public final void flush() {
        synchronized (this.f11147b) {
            this.f11156k = true;
            I i10 = this.f11154i;
            if (i10 != null) {
                i10.clear();
                int i11 = this.f11152g;
                this.f11152g = i11 + 1;
                this.f11150e[i11] = i10;
                this.f11154i = null;
            }
            while (!this.f11148c.isEmpty()) {
                I iRemoveFirst = this.f11148c.removeFirst();
                iRemoveFirst.clear();
                int i12 = this.f11152g;
                this.f11152g = i12 + 1;
                this.f11150e[i12] = iRemoveFirst;
            }
            while (!this.f11149d.isEmpty()) {
                b(this.f11149d.removeFirst());
            }
        }
    }

    @Override // e5.c
    public void release() throws InterruptedException {
        synchronized (this.f11147b) {
            this.f11157l = true;
            this.f11147b.notify();
        }
        try {
            this.f11146a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public void releaseOutputBuffer(O o6) {
        synchronized (this.f11147b) {
            b(o6);
            if (!this.f11148c.isEmpty() && this.f11153h > 0) {
                this.f11147b.notify();
            }
        }
    }

    public final void setInitialInputBufferSize(int i10) throws IllegalStateException {
        int i11 = this.f11152g;
        I[] iArr = this.f11150e;
        l6.a.checkState(i11 == iArr.length);
        for (I i12 : iArr) {
            i12.ensureSpaceForWrite(i10);
        }
    }

    @Override // e5.c
    public final I dequeueInputBuffer() throws Exception {
        I i10;
        synchronized (this.f11147b) {
            try {
                E e10 = this.f11155j;
                if (e10 != null) {
                    throw e10;
                }
                l6.a.checkState(this.f11154i == null);
                int i11 = this.f11152g;
                if (i11 == 0) {
                    i10 = null;
                } else {
                    I[] iArr = this.f11150e;
                    int i12 = i11 - 1;
                    this.f11152g = i12;
                    i10 = iArr[i12];
                }
                this.f11154i = i10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    @Override // e5.c
    public final O dequeueOutputBuffer() throws Exception {
        synchronized (this.f11147b) {
            try {
                E e10 = this.f11155j;
                if (e10 != null) {
                    throw e10;
                }
                if (this.f11149d.isEmpty()) {
                    return null;
                }
                return this.f11149d.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // e5.c
    public final void queueInputBuffer(I i10) throws Exception {
        synchronized (this.f11147b) {
            try {
                E e10 = this.f11155j;
                if (e10 != null) {
                    throw e10;
                }
                boolean z10 = true;
                l6.a.checkArgument(i10 == this.f11154i);
                this.f11148c.addLast(i10);
                if (this.f11148c.isEmpty() || this.f11153h <= 0) {
                    z10 = false;
                }
                if (z10) {
                    this.f11147b.notify();
                }
                this.f11154i = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
