package org.adblockplus.libadblockplus.sitekey;

import java.util.List;

/* loaded from: classes2.dex */
public interface PublicKeyHolder {
    void clear();

    boolean contains(String str);

    String get(String str);

    String getAny(List<String> list, String str);

    void put(String str, String str2);
}
