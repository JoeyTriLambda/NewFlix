package u3;

import org.apache.commons.lang3.StringUtils;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f19993a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19994b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19995c;

    public g(String str, float f10, float f11) {
        this.f19993a = str;
        this.f19995c = f11;
        this.f19994b = f10;
    }

    public boolean matchesName(String str) {
        String str2 = this.f19993a;
        if (str2.equalsIgnoreCase(str)) {
            return true;
        }
        return str2.endsWith(StringUtils.CR) && str2.substring(0, str2.length() - 1).equalsIgnoreCase(str);
    }
}
