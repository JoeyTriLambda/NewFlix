package org.adblockplus.libadblockplus;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class Disposer extends WeakReference<Disposable> {
    private final Disposable disposable;
    private volatile boolean disposed;
    static final ReferenceQueue<Disposable> referenceQueue = new ReferenceQueue<>();
    private static final HashSet<Disposer> disposerSet = new HashSet<>();

    public static final class Cleaner implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    ((Disposer) Disposer.referenceQueue.remove()).dispose();
                } catch (Throwable unused) {
                }
            }
        }
    }

    static {
        Thread thread = new Thread(new Cleaner());
        thread.setName(Cleaner.class.getCanonicalName());
        thread.setDaemon(true);
        thread.start();
    }

    public Disposer(Disposable disposable, Disposable disposable2) {
        super(disposable, referenceQueue);
        this.disposed = false;
        this.disposable = disposable2;
        HashSet<Disposer> hashSet = disposerSet;
        synchronized (hashSet) {
            hashSet.add(this);
        }
    }

    public synchronized void dispose() {
        if (!this.disposed) {
            try {
                this.disposable.dispose();
            } catch (Throwable unused) {
            }
            this.disposed = true;
            HashSet<Disposer> hashSet = disposerSet;
            synchronized (hashSet) {
                hashSet.remove(this);
            }
        }
    }
}
