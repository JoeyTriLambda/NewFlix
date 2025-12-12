package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(StringBuilder sb2, HashMap<String, String> map) {
        sb2.append("{");
        boolean z10 = true;
        for (String str : map.keySet()) {
            if (!z10) {
                sb2.append(",");
            }
            String str2 = map.get(str);
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\"");
            }
            z10 = false;
        }
        sb2.append("}");
    }
}
