package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.annotation.Obsolete;
import java.util.Date;

/* loaded from: classes2.dex */
public interface SetCookie extends Cookie {
    @Obsolete
    void setComment(String str);

    void setDomain(String str);

    void setExpiryDate(Date date);

    void setPath(String str);

    void setSecure(boolean z10);

    void setValue(String str);

    @Obsolete
    void setVersion(int i10);
}
