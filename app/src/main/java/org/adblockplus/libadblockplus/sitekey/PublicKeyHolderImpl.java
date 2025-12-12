package org.adblockplus.libadblockplus.sitekey;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class PublicKeyHolderImpl implements PublicKeyHolder {
    private Map<String, String> map = Collections.synchronizedMap(new HashMap());

    public static String stripPadding(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(str);
        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '=') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    @Override // org.adblockplus.libadblockplus.sitekey.PublicKeyHolder
    public void clear() {
        this.map.clear();
    }

    @Override // org.adblockplus.libadblockplus.sitekey.PublicKeyHolder
    public boolean contains(String str) {
        return this.map.containsKey(str);
    }

    @Override // org.adblockplus.libadblockplus.sitekey.PublicKeyHolder
    public String get(String str) {
        return this.map.get(str);
    }

    @Override // org.adblockplus.libadblockplus.sitekey.PublicKeyHolder
    public String getAny(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str2 = get(it.next());
            if (str2 != null) {
                return str2;
            }
        }
        return str;
    }

    @Override // org.adblockplus.libadblockplus.sitekey.PublicKeyHolder
    public void put(String str, String str2) {
        this.map.put(str, str2);
    }
}
