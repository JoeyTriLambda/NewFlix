package org.threeten.bp.zone;

import ac.c;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes2.dex */
public final class TzdbZoneRulesProvider extends ZoneRulesProvider {
    private List<String> regionIds;
    private final ConcurrentNavigableMap<String, Version> versions = new ConcurrentSkipListMap();
    private Set<String> loadedUrls = new CopyOnWriteArraySet();

    public static class Version {
        private final String[] regionArray;
        private final AtomicReferenceArray<Object> ruleData;
        private final short[] ruleIndices;
        private final String versionId;

        public Version(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.ruleData = atomicReferenceArray;
            this.versionId = str;
            this.regionArray = strArr;
            this.ruleIndices = sArr;
        }

        public ZoneRules createRule(short s10) throws Exception {
            Object obj = this.ruleData.get(s10);
            if (obj instanceof byte[]) {
                obj = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) obj)));
                this.ruleData.set(s10, obj);
            }
            return (ZoneRules) obj;
        }

        public ZoneRules getRules(String str) {
            int iBinarySearch = Arrays.binarySearch(this.regionArray, str);
            if (iBinarySearch < 0) {
                return null;
            }
            try {
                return createRule(this.ruleIndices[iBinarySearch]);
            } catch (Exception e10) {
                StringBuilder sbV = c.v("Invalid binary time-zone data: TZDB:", str, ", version: ");
                sbV.append(this.versionId);
                throw new ZoneRulesException(sbV.toString(), e10);
            }
        }

        public String toString() {
            return this.versionId;
        }
    }

    public TzdbZoneRulesProvider() {
        if (!load(ZoneRulesProvider.class.getClassLoader())) {
            throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
        }
    }

    private boolean load(ClassLoader classLoader) throws IOException {
        URL url = null;
        try {
            Enumeration<URL> resources = classLoader.getResources("org/threeten/bp/TZDB.dat");
            boolean zLoad = false;
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                try {
                    zLoad |= load(urlNextElement);
                    url = urlNextElement;
                } catch (Exception e10) {
                    e = e10;
                    url = urlNextElement;
                    throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e);
                }
            }
            return zLoad;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private Iterable<Version> loadData(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        if (!"TZDB".equals(dataInputStream.readUTF())) {
            throw new StreamCorruptedException("File format not recognised");
        }
        int i10 = dataInputStream.readShort();
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = dataInputStream.readUTF();
        }
        int i12 = dataInputStream.readShort();
        String[] strArr2 = new String[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            strArr2[i13] = dataInputStream.readUTF();
        }
        this.regionIds = Arrays.asList(strArr2);
        int i14 = dataInputStream.readShort();
        Object[] objArr = new Object[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            byte[] bArr = new byte[dataInputStream.readShort()];
            dataInputStream.readFully(bArr);
            objArr[i15] = bArr;
        }
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
        HashSet hashSet = new HashSet(i10);
        for (int i16 = 0; i16 < i10; i16++) {
            int i17 = dataInputStream.readShort();
            String[] strArr3 = new String[i17];
            short[] sArr = new short[i17];
            for (int i18 = 0; i18 < i17; i18++) {
                strArr3[i18] = strArr2[dataInputStream.readShort()];
                sArr[i18] = dataInputStream.readShort();
            }
            hashSet.add(new Version(strArr[i16], strArr3, sArr, atomicReferenceArray));
        }
        return hashSet;
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    public ZoneRules provideRules(String str, boolean z10) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        ZoneRules rules = this.versions.lastEntry().getValue().getRules(str);
        if (rules != null) {
            return rules;
        }
        throw new ZoneRulesException(c.j("Unknown time-zone ID: ", str));
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    public NavigableMap<String, ZoneRules> provideVersions(String str) {
        TreeMap treeMap = new TreeMap();
        for (Version version : this.versions.values()) {
            ZoneRules rules = version.getRules(str);
            if (rules != null) {
                treeMap.put(version.versionId, rules);
            }
        }
        return treeMap;
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    public Set<String> provideZoneIds() {
        return new HashSet(this.regionIds);
    }

    public String toString() {
        return "TZDB";
    }

    public TzdbZoneRulesProvider(URL url) {
        try {
            if (load(url)) {
                return;
            }
            throw new ZoneRulesException("No time-zone rules found: " + url);
        } catch (Exception e10) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e10);
        }
    }

    private boolean load(URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        boolean zLoad = false;
        if (this.loadedUrls.add(url.toExternalForm())) {
            try {
                inputStreamOpenStream = url.openStream();
            } catch (Throwable th2) {
                th = th2;
                inputStreamOpenStream = null;
            }
            try {
                zLoad = false | load(inputStreamOpenStream);
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                throw th;
            }
        }
        return zLoad;
    }

    private boolean load(InputStream inputStream) throws IOException {
        boolean z10 = false;
        for (Version version : loadData(inputStream)) {
            Version versionPutIfAbsent = this.versions.putIfAbsent(version.versionId, version);
            if (versionPutIfAbsent != null && !versionPutIfAbsent.versionId.equals(version.versionId)) {
                throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + version.versionId);
            }
            z10 = true;
        }
        return z10;
    }

    public TzdbZoneRulesProvider(InputStream inputStream) {
        try {
            load(inputStream);
        } catch (Exception e10) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e10);
        }
    }
}
