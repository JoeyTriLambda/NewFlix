package org.threeten.bp.zone;

import ac.c;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes2.dex */
public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList<ZoneRulesProvider> PROVIDERS = new CopyOnWriteArrayList<>();
    private static final ConcurrentMap<String, ZoneRulesProvider> ZONES = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        ZoneRulesInitializer.initialize();
    }

    public static Set<String> getAvailableZoneIds() {
        return Collections.unmodifiableSet(ZONES.keySet());
    }

    private static ZoneRulesProvider getProvider(String str) {
        ConcurrentMap<String, ZoneRulesProvider> concurrentMap = ZONES;
        ZoneRulesProvider zoneRulesProvider = concurrentMap.get(str);
        if (zoneRulesProvider != null) {
            return zoneRulesProvider;
        }
        if (concurrentMap.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        throw new ZoneRulesException(c.j("Unknown time-zone ID: ", str));
    }

    public static ZoneRules getRules(String str, boolean z10) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        return getProvider(str).provideRules(str, z10);
    }

    public static NavigableMap<String, ZoneRules> getVersions(String str) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        return getProvider(str).provideVersions(str);
    }

    public static boolean refresh() {
        Iterator<ZoneRulesProvider> it = PROVIDERS.iterator();
        boolean zProvideRefresh = false;
        while (it.hasNext()) {
            zProvideRefresh |= it.next().provideRefresh();
        }
        return zProvideRefresh;
    }

    public static void registerProvider(ZoneRulesProvider zoneRulesProvider) {
        Jdk8Methods.requireNonNull(zoneRulesProvider, "provider");
        registerProvider0(zoneRulesProvider);
        PROVIDERS.add(zoneRulesProvider);
    }

    private static void registerProvider0(ZoneRulesProvider zoneRulesProvider) {
        for (String str : zoneRulesProvider.provideZoneIds()) {
            Jdk8Methods.requireNonNull(str, "zoneId");
            if (ZONES.putIfAbsent(str, zoneRulesProvider) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + zoneRulesProvider);
            }
        }
    }

    public boolean provideRefresh() {
        return false;
    }

    public abstract ZoneRules provideRules(String str, boolean z10);

    public abstract NavigableMap<String, ZoneRules> provideVersions(String str);

    public abstract Set<String> provideZoneIds();
}
