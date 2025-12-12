package org.threeten.bp.zone;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class ZoneRulesInitializer {
    public static final ZoneRulesInitializer DO_NOTHING = new DoNothingZoneRulesInitializer();
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    private static final AtomicReference<ZoneRulesInitializer> INITIALIZER = new AtomicReference<>();

    public static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        public void initializeProviders() {
            Iterator it = ServiceLoader.load(ZoneRulesProvider.class, ZoneRulesProvider.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    ZoneRulesProvider.registerProvider((ZoneRulesProvider) it.next());
                } catch (ServiceConfigurationError e10) {
                    if (!(e10.getCause() instanceof SecurityException)) {
                        throw e10;
                    }
                }
            }
        }
    }

    public static void initialize() {
        if (INITIALIZED.getAndSet(true)) {
            throw new IllegalStateException("Already initialized");
        }
        AtomicReference<ZoneRulesInitializer> atomicReference = INITIALIZER;
        ServiceLoaderZoneRulesInitializer serviceLoaderZoneRulesInitializer = new ServiceLoaderZoneRulesInitializer();
        while (!atomicReference.compareAndSet(null, serviceLoaderZoneRulesInitializer) && atomicReference.get() == null) {
        }
        INITIALIZER.get().initializeProviders();
    }

    public static void setInitializer(ZoneRulesInitializer zoneRulesInitializer) {
        boolean z10;
        if (INITIALIZED.get()) {
            throw new IllegalStateException("Already initialized");
        }
        AtomicReference<ZoneRulesInitializer> atomicReference = INITIALIZER;
        while (true) {
            if (atomicReference.compareAndSet(null, zoneRulesInitializer)) {
                z10 = true;
                break;
            } else if (atomicReference.get() != null) {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    public abstract void initializeProviders();

    public static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        public void initializeProviders() {
        }
    }
}
