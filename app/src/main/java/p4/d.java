package p4;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import java.util.Arrays;
import p4.h;

/* compiled from: AutoValue_LogEvent.java */
/* loaded from: classes.dex */
public final class d extends h {

    /* renamed from: a, reason: collision with root package name */
    public final long f17569a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f17570b;

    /* renamed from: c, reason: collision with root package name */
    public final long f17571c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f17572d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17573e;

    /* renamed from: f, reason: collision with root package name */
    public final long f17574f;

    /* renamed from: g, reason: collision with root package name */
    public final NetworkConnectionInfo f17575g;

    /* compiled from: AutoValue_LogEvent.java */
    public static final class a extends h.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f17576a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f17577b;

        /* renamed from: c, reason: collision with root package name */
        public Long f17578c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f17579d;

        /* renamed from: e, reason: collision with root package name */
        public String f17580e;

        /* renamed from: f, reason: collision with root package name */
        public Long f17581f;

        /* renamed from: g, reason: collision with root package name */
        public NetworkConnectionInfo f17582g;

        @Override // p4.h.a
        public h build() {
            String strB = this.f17576a == null ? " eventTimeMs" : "";
            if (this.f17578c == null) {
                strB = strB.concat(" eventUptimeMs");
            }
            if (this.f17581f == null) {
                strB = ac.c.B(strB, " timezoneOffsetSeconds");
            }
            if (strB.isEmpty()) {
                return new d(this.f17576a.longValue(), this.f17577b, this.f17578c.longValue(), this.f17579d, this.f17580e, this.f17581f.longValue(), this.f17582g);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // p4.h.a
        public h.a setEventCode(Integer num) {
            this.f17577b = num;
            return this;
        }

        @Override // p4.h.a
        public h.a setEventTimeMs(long j10) {
            this.f17576a = Long.valueOf(j10);
            return this;
        }

        @Override // p4.h.a
        public h.a setEventUptimeMs(long j10) {
            this.f17578c = Long.valueOf(j10);
            return this;
        }

        @Override // p4.h.a
        public h.a setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
            this.f17582g = networkConnectionInfo;
            return this;
        }

        @Override // p4.h.a
        public h.a setTimezoneOffsetSeconds(long j10) {
            this.f17581f = Long.valueOf(j10);
            return this;
        }
    }

    public d(long j10, Integer num, long j11, byte[] bArr, String str, long j12, NetworkConnectionInfo networkConnectionInfo) {
        this.f17569a = j10;
        this.f17570b = num;
        this.f17571c = j11;
        this.f17572d = bArr;
        this.f17573e = str;
        this.f17574f = j12;
        this.f17575g = networkConnectionInfo;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f17569a == hVar.getEventTimeMs() && ((num = this.f17570b) != null ? num.equals(hVar.getEventCode()) : hVar.getEventCode() == null) && this.f17571c == hVar.getEventUptimeMs()) {
            if (Arrays.equals(this.f17572d, hVar instanceof d ? ((d) hVar).f17572d : hVar.getSourceExtension()) && ((str = this.f17573e) != null ? str.equals(hVar.getSourceExtensionJsonProto3()) : hVar.getSourceExtensionJsonProto3() == null) && this.f17574f == hVar.getTimezoneOffsetSeconds()) {
                NetworkConnectionInfo networkConnectionInfo = this.f17575g;
                if (networkConnectionInfo == null) {
                    if (hVar.getNetworkConnectionInfo() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(hVar.getNetworkConnectionInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p4.h
    public Integer getEventCode() {
        return this.f17570b;
    }

    @Override // p4.h
    public long getEventTimeMs() {
        return this.f17569a;
    }

    @Override // p4.h
    public long getEventUptimeMs() {
        return this.f17571c;
    }

    @Override // p4.h
    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.f17575g;
    }

    @Override // p4.h
    public byte[] getSourceExtension() {
        return this.f17572d;
    }

    @Override // p4.h
    public String getSourceExtensionJsonProto3() {
        return this.f17573e;
    }

    @Override // p4.h
    public long getTimezoneOffsetSeconds() {
        return this.f17574f;
    }

    public int hashCode() {
        long j10 = this.f17569a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f17570b;
        int iHashCode = (i10 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j11 = this.f17571c;
        int iHashCode2 = (((iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f17572d)) * 1000003;
        String str = this.f17573e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j12 = this.f17574f;
        int i11 = (iHashCode3 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f17575g;
        return i11 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f17569a + ", eventCode=" + this.f17570b + ", eventUptimeMs=" + this.f17571c + ", sourceExtension=" + Arrays.toString(this.f17572d) + ", sourceExtensionJsonProto3=" + this.f17573e + ", timezoneOffsetSeconds=" + this.f17574f + ", networkConnectionInfo=" + this.f17575g + "}";
    }
}
