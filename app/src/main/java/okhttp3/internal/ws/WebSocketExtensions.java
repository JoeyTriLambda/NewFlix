package okhttp3.internal.ws;

import ig.k;
import ig.l;
import java.io.IOException;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import zf.f;
import zf.i;

/* compiled from: WebSocketExtensions.kt */
/* loaded from: classes2.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* compiled from: WebSocketExtensions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final WebSocketExtensions parse(Headers headers) throws IOException {
            i.checkNotNullParameter(headers, "responseHeaders");
            int size = headers.size();
            int i10 = 0;
            boolean z10 = false;
            Integer intOrNull = null;
            boolean z11 = false;
            Integer intOrNull2 = null;
            boolean z12 = false;
            boolean z13 = false;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (l.equals(headers.name(i10), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strValue = headers.value(i10);
                    int i12 = 0;
                    while (i12 < strValue.length()) {
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i12, 0, 4, (Object) null);
                        int iDelimiterOffset = Util.delimiterOffset(strValue, ';', i12, iDelimiterOffset$default);
                        String strTrimSubstring = Util.trimSubstring(strValue, i12, iDelimiterOffset);
                        int i13 = iDelimiterOffset + 1;
                        if (l.equals(strTrimSubstring, "permessage-deflate", true)) {
                            if (z10) {
                                z13 = true;
                            }
                            i12 = i13;
                            while (i12 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, ';', i12, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, '=', i12, iDelimiterOffset2);
                                String strTrimSubstring2 = Util.trimSubstring(strValue, i12, iDelimiterOffset3);
                                String strRemoveSurrounding = iDelimiterOffset3 < iDelimiterOffset2 ? StringsKt__StringsKt.removeSurrounding(Util.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2), "\"") : null;
                                i12 = iDelimiterOffset2 + 1;
                                if (l.equals(strTrimSubstring2, "client_max_window_bits", true)) {
                                    if (intOrNull != null) {
                                        z13 = true;
                                    }
                                    intOrNull = strRemoveSurrounding == null ? null : k.toIntOrNull(strRemoveSurrounding);
                                    if (intOrNull == null) {
                                        z13 = true;
                                    }
                                } else if (l.equals(strTrimSubstring2, "client_no_context_takeover", true)) {
                                    if (z11) {
                                        z13 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z13 = true;
                                    }
                                    z11 = true;
                                } else if (l.equals(strTrimSubstring2, "server_max_window_bits", true)) {
                                    if (intOrNull2 != null) {
                                        z13 = true;
                                    }
                                    intOrNull2 = strRemoveSurrounding == null ? null : k.toIntOrNull(strRemoveSurrounding);
                                    if (intOrNull2 == null) {
                                        z13 = true;
                                    }
                                } else if (l.equals(strTrimSubstring2, "server_no_context_takeover", true)) {
                                    if (z12) {
                                        z13 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z13 = true;
                                    }
                                    z12 = true;
                                } else {
                                    z13 = true;
                                }
                            }
                            z10 = true;
                        } else {
                            i12 = i13;
                            z13 = true;
                        }
                    }
                }
                i10 = i11;
            }
            return new WebSocketExtensions(z10, intOrNull, z11, intOrNull2, z12, z13);
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = webSocketExtensions.perMessageDeflate;
        }
        if ((i10 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            z11 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z14 = z11;
        if ((i10 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            z12 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z15 = z12;
        if ((i10 & 32) != 0) {
            z13 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z10, num3, z14, num4, z15, z13);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13) {
        return new WebSocketExtensions(z10, num, z11, num2, z12, z13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && i.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && i.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.perMessageDeflate;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (iHashCode + i11) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i12 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i13 = r23;
        if (r23 != 0) {
            i13 = 1;
        }
        int i14 = (iHashCode2 + i13) * 31;
        boolean z11 = this.unknownValues;
        return i14 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z10) {
        return z10 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13) {
        this.perMessageDeflate = z10;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z11;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z12;
        this.unknownValues = z13;
    }

    public /* synthetic */ WebSocketExtensions(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, f fVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? false : z11, (i10 & 8) == 0 ? num2 : null, (i10 & 16) != 0 ? false : z12, (i10 & 32) != 0 ? false : z13);
    }
}
