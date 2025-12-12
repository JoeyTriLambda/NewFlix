package u0;

import android.util.Base64;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f19935a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19936b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19937c;

    /* renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f19938d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19939e;

    public g(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f19935a = (String) w0.h.checkNotNull(str);
        this.f19936b = (String) w0.h.checkNotNull(str2);
        this.f19937c = (String) w0.h.checkNotNull(str3);
        this.f19938d = (List) w0.h.checkNotNull(list);
        this.f19939e = str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> getCertificates() {
        return this.f19938d;
    }

    public int getCertificatesArrayResId() {
        return 0;
    }

    public String getProviderAuthority() {
        return this.f19935a;
    }

    public String getProviderPackage() {
        return this.f19936b;
    }

    public String getQuery() {
        return this.f19937c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f19935a + ", mProviderPackage: " + this.f19936b + ", mQuery: " + this.f19937c + ", mCertificates:");
        int i10 = 0;
        while (true) {
            List<List<byte[]>> list = this.f19938d;
            if (i10 >= list.size()) {
                sb2.append("}mCertificatesArray: 0");
                return sb2.toString();
            }
            sb2.append(" [");
            List<byte[]> list2 = list.get(i10);
            for (int i11 = 0; i11 < list2.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list2.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
            i10++;
        }
    }
}
