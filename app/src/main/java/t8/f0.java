package t8;

import com.google.auto.value.AutoValue;
import java.nio.charset.Charset;
import java.util.List;
import t8.a0;
import t8.b;
import t8.c;
import t8.d;
import t8.e;
import t8.f;
import t8.g;
import t8.h;
import t8.i;
import t8.k;
import t8.l;
import t8.m;
import t8.n;
import t8.o;
import t8.p;
import t8.q;
import t8.r;
import t8.s;
import t8.t;
import t8.u;
import t8.v;
import t8.w;
import t8.x;
import t8.y;
import t8.z;

/* compiled from: CrashlyticsReport.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f19692a = Charset.forName("UTF-8");

    /* compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class a {

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        /* renamed from: t8.f0$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0261a {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            /* renamed from: t8.f0$a$a$a, reason: collision with other inner class name */
            public static abstract class AbstractC0262a {
                public abstract AbstractC0261a build();

                public abstract AbstractC0262a setArch(String str);

                public abstract AbstractC0262a setBuildId(String str);

                public abstract AbstractC0262a setLibraryName(String str);
            }

            public static AbstractC0262a builder() {
                return new d.a();
            }

            public abstract String getArch();

            public abstract String getBuildId();

            public abstract String getLibraryName();
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class b {
            public abstract a build();

            public abstract b setBuildIdMappingForArch(List<AbstractC0261a> list);

            public abstract b setImportance(int i10);

            public abstract b setPid(int i10);

            public abstract b setProcessName(String str);

            public abstract b setPss(long j10);

            public abstract b setReasonCode(int i10);

            public abstract b setRss(long j10);

            public abstract b setTimestamp(long j10);

            public abstract b setTraceFile(String str);
        }

        public static b builder() {
            return new c.a();
        }

        public abstract List<AbstractC0261a> getBuildIdMappingForArch();

        public abstract int getImportance();

        public abstract int getPid();

        public abstract String getProcessName();

        public abstract long getPss();

        public abstract int getReasonCode();

        public abstract long getRss();

        public abstract long getTimestamp();

        public abstract String getTraceFile();
    }

    /* compiled from: CrashlyticsReport.java */
    @AutoValue.Builder
    public static abstract class b {
        public abstract f0 build();

        public abstract b setAppExitInfo(a aVar);

        public abstract b setAppQualitySessionId(String str);

        public abstract b setBuildVersion(String str);

        public abstract b setDisplayVersion(String str);

        public abstract b setFirebaseInstallationId(String str);

        public abstract b setGmpAppId(String str);

        public abstract b setInstallationUuid(String str);

        public abstract b setNdkPayload(d dVar);

        public abstract b setPlatform(int i10);

        public abstract b setSdkVersion(String str);

        public abstract b setSession(e eVar);
    }

    /* compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class c {

        /* compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class a {
            public abstract c build();

            public abstract a setKey(String str);

            public abstract a setValue(String str);
        }

        public static a builder() {
            return new e.a();
        }

        public abstract String getKey();

        public abstract String getValue();
    }

    /* compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class d {

        /* compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class a {
            public abstract d build();

            public abstract a setFiles(List<b> list);

            public abstract a setOrgId(String str);
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class b {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract b build();

                public abstract a setContents(byte[] bArr);

                public abstract a setFilename(String str);
            }

            public static a builder() {
                return new g.a();
            }

            public abstract byte[] getContents();

            public abstract String getFilename();
        }

        public static a builder() {
            return new f.a();
        }

        public abstract List<b> getFiles();

        public abstract String getOrgId();
    }

    /* compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class e {

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class a {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            /* renamed from: t8.f0$e$a$a, reason: collision with other inner class name */
            public static abstract class AbstractC0263a {
                public abstract a build();

                public abstract AbstractC0263a setDevelopmentPlatform(String str);

                public abstract AbstractC0263a setDevelopmentPlatformVersion(String str);

                public abstract AbstractC0263a setDisplayVersion(String str);

                public abstract AbstractC0263a setIdentifier(String str);

                public abstract AbstractC0263a setInstallationUuid(String str);

                public abstract AbstractC0263a setVersion(String str);
            }

            /* compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class b {
                public abstract String getClsId();
            }

            public static AbstractC0263a builder() {
                return new i.a();
            }

            public abstract String getDevelopmentPlatform();

            public abstract String getDevelopmentPlatformVersion();

            public abstract String getDisplayVersion();

            public abstract String getIdentifier();

            public abstract String getInstallationUuid();

            public abstract b getOrganization();

            public abstract String getVersion();
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class b {
            public abstract e build();

            public abstract b setApp(a aVar);

            public abstract b setAppQualitySessionId(String str);

            public abstract b setCrashed(boolean z10);

            public abstract b setDevice(c cVar);

            public abstract b setEndedAt(Long l10);

            public abstract b setEvents(List<d> list);

            public abstract b setGenerator(String str);

            public abstract b setGeneratorType(int i10);

            public abstract b setIdentifier(String str);

            public b setIdentifierFromUtf8Bytes(byte[] bArr) {
                return setIdentifier(new String(bArr, f0.f19692a));
            }

            public abstract b setOs(AbstractC0278e abstractC0278e);

            public abstract b setStartedAt(long j10);

            public abstract b setUser(f fVar);
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class c {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract c build();

                public abstract a setArch(int i10);

                public abstract a setCores(int i10);

                public abstract a setDiskSpace(long j10);

                public abstract a setManufacturer(String str);

                public abstract a setModel(String str);

                public abstract a setModelClass(String str);

                public abstract a setRam(long j10);

                public abstract a setSimulator(boolean z10);

                public abstract a setState(int i10);
            }

            public static a builder() {
                return new k.a();
            }

            public abstract int getArch();

            public abstract int getCores();

            public abstract long getDiskSpace();

            public abstract String getManufacturer();

            public abstract String getModel();

            public abstract String getModelClass();

            public abstract long getRam();

            public abstract int getState();

            public abstract boolean isSimulator();
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class d {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class a {

                /* compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                /* renamed from: t8.f0$e$d$a$a, reason: collision with other inner class name */
                public static abstract class AbstractC0264a {
                    public abstract a build();

                    public abstract AbstractC0264a setAppProcessDetails(List<c> list);

                    public abstract AbstractC0264a setBackground(Boolean bool);

                    public abstract AbstractC0264a setCurrentProcessDetails(c cVar);

                    public abstract AbstractC0264a setCustomAttributes(List<c> list);

                    public abstract AbstractC0264a setExecution(b bVar);

                    public abstract AbstractC0264a setInternalKeys(List<c> list);

                    public abstract AbstractC0264a setUiOrientation(int i10);
                }

                /* compiled from: CrashlyticsReport.java */
                @AutoValue
                public static abstract class b {

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue
                    /* renamed from: t8.f0$e$d$a$b$a, reason: collision with other inner class name */
                    public static abstract class AbstractC0265a {

                        /* compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        /* renamed from: t8.f0$e$d$a$b$a$a, reason: collision with other inner class name */
                        public static abstract class AbstractC0266a {
                            public abstract AbstractC0265a build();

                            public abstract AbstractC0266a setBaseAddress(long j10);

                            public abstract AbstractC0266a setName(String str);

                            public abstract AbstractC0266a setSize(long j10);

                            public abstract AbstractC0266a setUuid(String str);

                            public AbstractC0266a setUuidFromUtf8Bytes(byte[] bArr) {
                                return setUuid(new String(bArr, f0.f19692a));
                            }
                        }

                        public static AbstractC0266a builder() {
                            return new o.a();
                        }

                        public abstract long getBaseAddress();

                        public abstract String getName();

                        public abstract long getSize();

                        public abstract String getUuid();

                        public byte[] getUuidUtf8Bytes() {
                            String uuid = getUuid();
                            if (uuid != null) {
                                return uuid.getBytes(f0.f19692a);
                            }
                            return null;
                        }
                    }

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue.Builder
                    /* renamed from: t8.f0$e$d$a$b$b, reason: collision with other inner class name */
                    public static abstract class AbstractC0267b {
                        public abstract b build();

                        public abstract AbstractC0267b setAppExitInfo(a aVar);

                        public abstract AbstractC0267b setBinaries(List<AbstractC0265a> list);

                        public abstract AbstractC0267b setException(c cVar);

                        public abstract AbstractC0267b setSignal(AbstractC0269d abstractC0269d);

                        public abstract AbstractC0267b setThreads(List<AbstractC0271e> list);
                    }

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class c {

                        /* compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        /* renamed from: t8.f0$e$d$a$b$c$a, reason: collision with other inner class name */
                        public static abstract class AbstractC0268a {
                            public abstract c build();

                            public abstract AbstractC0268a setCausedBy(c cVar);

                            public abstract AbstractC0268a setFrames(List<AbstractC0271e.AbstractC0273b> list);

                            public abstract AbstractC0268a setOverflowCount(int i10);

                            public abstract AbstractC0268a setReason(String str);

                            public abstract AbstractC0268a setType(String str);
                        }

                        public static AbstractC0268a builder() {
                            return new p.a();
                        }

                        public abstract c getCausedBy();

                        public abstract List<AbstractC0271e.AbstractC0273b> getFrames();

                        public abstract int getOverflowCount();

                        public abstract String getReason();

                        public abstract String getType();
                    }

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue
                    /* renamed from: t8.f0$e$d$a$b$d, reason: collision with other inner class name */
                    public static abstract class AbstractC0269d {

                        /* compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        /* renamed from: t8.f0$e$d$a$b$d$a, reason: collision with other inner class name */
                        public static abstract class AbstractC0270a {
                            public abstract AbstractC0269d build();

                            public abstract AbstractC0270a setAddress(long j10);

                            public abstract AbstractC0270a setCode(String str);

                            public abstract AbstractC0270a setName(String str);
                        }

                        public static AbstractC0270a builder() {
                            return new q.a();
                        }

                        public abstract long getAddress();

                        public abstract String getCode();

                        public abstract String getName();
                    }

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue
                    /* renamed from: t8.f0$e$d$a$b$e, reason: collision with other inner class name */
                    public static abstract class AbstractC0271e {

                        /* compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        /* renamed from: t8.f0$e$d$a$b$e$a, reason: collision with other inner class name */
                        public static abstract class AbstractC0272a {
                            public abstract AbstractC0271e build();

                            public abstract AbstractC0272a setFrames(List<AbstractC0273b> list);

                            public abstract AbstractC0272a setImportance(int i10);

                            public abstract AbstractC0272a setName(String str);
                        }

                        /* compiled from: CrashlyticsReport.java */
                        @AutoValue
                        /* renamed from: t8.f0$e$d$a$b$e$b, reason: collision with other inner class name */
                        public static abstract class AbstractC0273b {

                            /* compiled from: CrashlyticsReport.java */
                            @AutoValue.Builder
                            /* renamed from: t8.f0$e$d$a$b$e$b$a, reason: collision with other inner class name */
                            public static abstract class AbstractC0274a {
                                public abstract AbstractC0273b build();

                                public abstract AbstractC0274a setFile(String str);

                                public abstract AbstractC0274a setImportance(int i10);

                                public abstract AbstractC0274a setOffset(long j10);

                                public abstract AbstractC0274a setPc(long j10);

                                public abstract AbstractC0274a setSymbol(String str);
                            }

                            public static AbstractC0274a builder() {
                                return new s.a();
                            }

                            public abstract String getFile();

                            public abstract int getImportance();

                            public abstract long getOffset();

                            public abstract long getPc();

                            public abstract String getSymbol();
                        }

                        public static AbstractC0272a builder() {
                            return new r.a();
                        }

                        public abstract List<AbstractC0273b> getFrames();

                        public abstract int getImportance();

                        public abstract String getName();
                    }

                    public static AbstractC0267b builder() {
                        return new n.a();
                    }

                    public abstract a getAppExitInfo();

                    public abstract List<AbstractC0265a> getBinaries();

                    public abstract c getException();

                    public abstract AbstractC0269d getSignal();

                    public abstract List<AbstractC0271e> getThreads();
                }

                /* compiled from: CrashlyticsReport.java */
                @AutoValue
                public static abstract class c {

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue.Builder
                    /* renamed from: t8.f0$e$d$a$c$a, reason: collision with other inner class name */
                    public static abstract class AbstractC0275a {
                        public abstract c build();

                        public abstract AbstractC0275a setDefaultProcess(boolean z10);

                        public abstract AbstractC0275a setImportance(int i10);

                        public abstract AbstractC0275a setPid(int i10);

                        public abstract AbstractC0275a setProcessName(String str);
                    }

                    public static AbstractC0275a builder() {
                        return new t.a();
                    }

                    public abstract int getImportance();

                    public abstract int getPid();

                    public abstract String getProcessName();

                    public abstract boolean isDefaultProcess();
                }

                public static AbstractC0264a builder() {
                    return new m.a();
                }

                public abstract List<c> getAppProcessDetails();

                public abstract Boolean getBackground();

                public abstract c getCurrentProcessDetails();

                public abstract List<c> getCustomAttributes();

                public abstract b getExecution();

                public abstract List<c> getInternalKeys();

                public abstract int getUiOrientation();

                public abstract AbstractC0264a toBuilder();
            }

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class b {
                public abstract d build();

                public abstract b setApp(a aVar);

                public abstract b setDevice(c cVar);

                public abstract b setLog(AbstractC0276d abstractC0276d);

                public abstract b setRollouts(f fVar);

                public abstract b setTimestamp(long j10);

                public abstract b setType(String str);
            }

            /* compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class c {

                /* compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                    public abstract c build();

                    public abstract a setBatteryLevel(Double d10);

                    public abstract a setBatteryVelocity(int i10);

                    public abstract a setDiskUsed(long j10);

                    public abstract a setOrientation(int i10);

                    public abstract a setProximityOn(boolean z10);

                    public abstract a setRamUsed(long j10);
                }

                public static a builder() {
                    return new u.a();
                }

                public abstract Double getBatteryLevel();

                public abstract int getBatteryVelocity();

                public abstract long getDiskUsed();

                public abstract int getOrientation();

                public abstract long getRamUsed();

                public abstract boolean isProximityOn();
            }

            /* compiled from: CrashlyticsReport.java */
            @AutoValue
            /* renamed from: t8.f0$e$d$d, reason: collision with other inner class name */
            public static abstract class AbstractC0276d {

                /* compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                /* renamed from: t8.f0$e$d$d$a */
                public static abstract class a {
                    public abstract AbstractC0276d build();

                    public abstract a setContent(String str);
                }

                public static a builder() {
                    return new v.a();
                }

                public abstract String getContent();
            }

            /* compiled from: CrashlyticsReport.java */
            @AutoValue
            /* renamed from: t8.f0$e$d$e, reason: collision with other inner class name */
            public static abstract class AbstractC0277e {

                /* compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                /* renamed from: t8.f0$e$d$e$a */
                public static abstract class a {
                    public abstract AbstractC0277e build();

                    public abstract a setParameterKey(String str);

                    public abstract a setParameterValue(String str);

                    public abstract a setRolloutVariant(b bVar);

                    public abstract a setTemplateVersion(long j10);
                }

                /* compiled from: CrashlyticsReport.java */
                @AutoValue
                /* renamed from: t8.f0$e$d$e$b */
                public static abstract class b {

                    /* compiled from: CrashlyticsReport.java */
                    @AutoValue.Builder
                    /* renamed from: t8.f0$e$d$e$b$a */
                    public static abstract class a {
                        public abstract b build();

                        public abstract a setRolloutId(String str);

                        public abstract a setVariantId(String str);
                    }

                    public static a builder() {
                        return new x.a();
                    }

                    public abstract String getRolloutId();

                    public abstract String getVariantId();
                }

                public static a builder() {
                    return new w.a();
                }

                public abstract String getParameterKey();

                public abstract String getParameterValue();

                public abstract b getRolloutVariant();

                public abstract long getTemplateVersion();
            }

            /* compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class f {

                /* compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                    public abstract f build();

                    public abstract a setRolloutAssignments(List<AbstractC0277e> list);
                }

                public static a builder() {
                    return new y.a();
                }

                public abstract List<AbstractC0277e> getRolloutAssignments();
            }

            public static b builder() {
                return new l.a();
            }

            public abstract a getApp();

            public abstract c getDevice();

            public abstract AbstractC0276d getLog();

            public abstract f getRollouts();

            public abstract long getTimestamp();

            public abstract String getType();

            public abstract b toBuilder();
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        /* renamed from: t8.f0$e$e, reason: collision with other inner class name */
        public static abstract class AbstractC0278e {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            /* renamed from: t8.f0$e$e$a */
            public static abstract class a {
                public abstract AbstractC0278e build();

                public abstract a setBuildVersion(String str);

                public abstract a setJailbroken(boolean z10);

                public abstract a setPlatform(int i10);

                public abstract a setVersion(String str);
            }

            public static a builder() {
                return new z.a();
            }

            public abstract String getBuildVersion();

            public abstract int getPlatform();

            public abstract String getVersion();

            public abstract boolean isJailbroken();
        }

        /* compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class f {

            /* compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract f build();

                public abstract a setIdentifier(String str);
            }

            public static a builder() {
                return new a0.a();
            }

            public abstract String getIdentifier();
        }

        public static b builder() {
            return new h.a().setCrashed(false);
        }

        public abstract a getApp();

        public abstract String getAppQualitySessionId();

        public abstract c getDevice();

        public abstract Long getEndedAt();

        public abstract List<d> getEvents();

        public abstract String getGenerator();

        public abstract int getGeneratorType();

        public abstract String getIdentifier();

        public byte[] getIdentifierUtf8Bytes() {
            return getIdentifier().getBytes(f0.f19692a);
        }

        public abstract AbstractC0278e getOs();

        public abstract long getStartedAt();

        public abstract f getUser();

        public abstract boolean isCrashed();

        public abstract b toBuilder();
    }

    public static b builder() {
        return new b.a();
    }

    public abstract a getAppExitInfo();

    public abstract String getAppQualitySessionId();

    public abstract String getBuildVersion();

    public abstract String getDisplayVersion();

    public abstract String getFirebaseInstallationId();

    public abstract String getGmpAppId();

    public abstract String getInstallationUuid();

    public abstract d getNdkPayload();

    public abstract int getPlatform();

    public abstract String getSdkVersion();

    public abstract e getSession();

    public abstract b toBuilder();

    public f0 withAppQualitySessionId(String str) {
        b appQualitySessionId = toBuilder().setAppQualitySessionId(str);
        if (getSession() != null) {
            appQualitySessionId.setSession(getSession().toBuilder().setAppQualitySessionId(str).build());
        }
        return appQualitySessionId.build();
    }

    public f0 withApplicationExitInfo(a aVar) {
        return aVar == null ? this : toBuilder().setAppExitInfo(aVar).build();
    }

    public f0 withEvents(List<e.d> list) {
        if (getSession() != null) {
            return toBuilder().setSession(getSession().toBuilder().setEvents(list).build()).build();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public f0 withFirebaseInstallationId(String str) {
        return toBuilder().setFirebaseInstallationId(str).build();
    }

    public f0 withNdkPayload(d dVar) {
        return toBuilder().setSession(null).setNdkPayload(dVar).build();
    }

    public f0 withSessionEndFields(long j10, boolean z10, String str) {
        b builder = toBuilder();
        if (getSession() != null) {
            e.b builder2 = getSession().toBuilder();
            builder2.setEndedAt(Long.valueOf(j10));
            builder2.setCrashed(z10);
            if (str != null) {
                builder2.setUser(e.f.builder().setIdentifier(str).build());
            }
            builder.setSession(builder2.build());
        }
        return builder.build();
    }
}
