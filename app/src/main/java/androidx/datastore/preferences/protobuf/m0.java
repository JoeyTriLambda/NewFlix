package androidx.datastore.preferences.protobuf;

import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: MessageLiteToString.java */
/* loaded from: classes.dex */
public final class m0 {
    public static final String a(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt)) {
                sb2.append("_");
            }
            sb2.append(Character.toLowerCase(cCharAt));
        }
        return sb2.toString();
    }

    public static final void b(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb2, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb2, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            sb2.append(TokenParser.SP);
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(e1.a(ByteString.copyFromUtf8((String) obj)));
            sb2.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb2.append(": \"");
            sb2.append(e1.a((ByteString) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb2.append(" {");
            c((GeneratedMessageLite) obj, sb2, i10 + 2);
            sb2.append(StringUtils.LF);
            while (i11 < i10) {
                sb2.append(TokenParser.SP);
                i11++;
            }
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj.toString());
            return;
        }
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i13 = i10 + 2;
        b(sb2, i13, "key", entry.getKey());
        b(sb2, i13, "value", entry.getValue());
        sb2.append(StringUtils.LF);
        while (i11 < i10) {
            sb2.append(TokenParser.SP);
            i11++;
        }
        sb2.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(androidx.datastore.preferences.protobuf.k0 r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.c(androidx.datastore.preferences.protobuf.k0, java.lang.StringBuilder, int):void");
    }
}
