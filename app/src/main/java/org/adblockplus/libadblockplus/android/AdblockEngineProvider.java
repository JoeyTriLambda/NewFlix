package org.adblockplus.libadblockplus.android;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public interface AdblockEngineProvider {

    public interface BeforeEngineDisposedListener {
        void onBeforeAdblockEngineDispose();
    }

    public interface EngineCreatedListener {
        void onAdblockEngineCreated(AdblockEngine adblockEngine);
    }

    public interface EngineDisposedListener {
        void onAdblockEngineDisposed();
    }

    AdblockEngineProvider addBeforeEngineDisposedListener(BeforeEngineDisposedListener beforeEngineDisposedListener);

    AdblockEngineProvider addEngineCreatedListener(EngineCreatedListener engineCreatedListener);

    AdblockEngineProvider addEngineDisposedListener(EngineDisposedListener engineDisposedListener);

    void clearBeforeEngineDisposedListeners();

    void clearEngineCreatedListeners();

    void clearEngineDisposedListeners();

    int getCounter();

    AdblockEngine getEngine();

    ReentrantReadWriteLock.ReadLock getReadEngineLock();

    boolean release();

    void removeBeforeEngineDisposedListener(BeforeEngineDisposedListener beforeEngineDisposedListener);

    void removeEngineCreatedListener(EngineCreatedListener engineCreatedListener);

    void removeEngineDisposedListener(EngineDisposedListener engineDisposedListener);

    boolean retain(boolean z10);

    void waitForReady();
}
