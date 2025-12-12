package p4;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;
import p4.i;

/* compiled from: AutoValue_LogRequest.java */
/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: a, reason: collision with root package name */
    public final long f17583a;

    /* renamed from: b, reason: collision with root package name */
    public final long f17584b;

    /* renamed from: c, reason: collision with root package name */
    public final ClientInfo f17585c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f17586d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17587e;

    /* renamed from: f, reason: collision with root package name */
    public final List<h> f17588f;

    /* renamed from: g, reason: collision with root package name */
    public final QosTier f17589g;

    /* compiled from: AutoValue_LogRequest.java */
    public static final class a extends i.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f17590a;

        /* renamed from: b, reason: collision with root package name */
        public Long f17591b;

        /* renamed from: c, reason: collision with root package name */
        public ClientInfo f17592c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f17593d;

        /* renamed from: e, reason: collision with root package name */
        public String f17594e;

        /* renamed from: f, reason: collision with root package name */
        public List<h> f17595f;

        /* renamed from: g, reason: collision with root package name */
        public QosTier f17596g;

        @Override // p4.i.a
        public i build() {
            String strConcat = this.f17590a == null ? " requestTimeMs" : "";
            if (this.f17591b == null) {
                strConcat = strConcat.concat(" requestUptimeMs");
            }
            if (strConcat.isEmpty()) {
                return new e(this.f17590a.longValue(), this.f17591b.longValue(), this.f17592c, this.f17593d, this.f17594e, this.f17595f, this.f17596g);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // p4.i.a
        public i.a setClientInfo(ClientInfo clientInfo) {
            this.f17592c = clientInfo;
            return this;
        }

        @Override // p4.i.a
        public i.a setLogEvents(List<h> list) {
            this.f17595f = list;
            return this;
        }

        @Override // p4.i.a
        public i.a setQosTier(QosTier qosTier) {
            this.f17596g = qosTier;
            return this;
        }

        @Override // p4.i.a
        public i.a setRequestTimeMs(long j10) {
            this.f17590a = Long.valueOf(j10);
            return this;
        }

        @Override // p4.i.a
        public i.a setRequestUptimeMs(long j10) {
            this.f17591b = Long.valueOf(j10);
            return this;
        }
    }

    public e() {
        throw null;
    }

    public e(long j10, long j11, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.f17583a = j10;
        this.f17584b = j11;
        this.f17585c = clientInfo;
        this.f17586d = num;
        this.f17587e = str;
        this.f17588f = list;
        this.f17589g = qosTier;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<h> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f17583a == iVar.getRequestTimeMs() && this.f17584b == iVar.getRequestUptimeMs() && ((clientInfo = this.f17585c) != null ? clientInfo.equals(iVar.getClientInfo()) : iVar.getClientInfo() == null) && ((num = this.f17586d) != null ? num.equals(iVar.getLogSource()) : iVar.getLogSource() == null) && ((str = this.f17587e) != null ? str.equals(iVar.getLogSourceName()) : iVar.getLogSourceName() == null) && ((list = this.f17588f) != null ? list.equals(iVar.getLogEvents()) : iVar.getLogEvents() == null)) {
            QosTier qosTier = this.f17589g;
            if (qosTier == null) {
                if (iVar.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier.equals(iVar.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    @Override // p4.i
    public ClientInfo getClientInfo() {
        return this.f17585c;
    }

    @Override // p4.i
    public List<h> getLogEvents() {
        return this.f17588f;
    }

    @Override // p4.i
    public Integer getLogSource() {
        return this.f17586d;
    }

    @Override // p4.i
    public String getLogSourceName() {
        return this.f17587e;
    }

    @Override // p4.i
    public QosTier getQosTier() {
        return this.f17589g;
    }

    @Override // p4.i
    public long getRequestTimeMs() {
        return this.f17583a;
    }

    @Override // p4.i
    public long getRequestUptimeMs() {
        return this.f17584b;
    }

    public int hashCode() {
        long j10 = this.f17583a;
        long j11 = this.f17584b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        ClientInfo clientInfo = this.f17585c;
        int iHashCode = (i10 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f17586d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f17587e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<h> list = this.f17588f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f17589g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f17583a + ", requestUptimeMs=" + this.f17584b + ", clientInfo=" + this.f17585c + ", logSource=" + this.f17586d + ", logSourceName=" + this.f17587e + ", logEvents=" + this.f17588f + ", qosTier=" + this.f17589g + "}";
    }
}
