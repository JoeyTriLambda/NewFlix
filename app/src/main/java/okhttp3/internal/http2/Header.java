package okhttp3.internal.http2;

import com.unity3d.ads.metadata.MediationMetaData;
import okio.ByteString;
import zf.f;
import zf.i;

/* compiled from: Header.kt */
/* loaded from: classes2.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    /* compiled from: Header.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        ByteString.a aVar = ByteString.f17101o;
        PSEUDO_PREFIX = aVar.encodeUtf8(":");
        RESPONSE_STATUS = aVar.encodeUtf8(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = aVar.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = aVar.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = aVar.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = aVar.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public Header(ByteString byteString, ByteString byteString2) {
        i.checkNotNullParameter(byteString, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(byteString2, "value");
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString2.size() + byteString.size() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            byteString = header.name;
        }
        if ((i10 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString byteString, ByteString byteString2) {
        i.checkNotNullParameter(byteString, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(byteString2, "value");
        return new Header(byteString, byteString2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return i.areEqual(this.name, header.name) && i.areEqual(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Header(String str, String str2) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(str2, "value");
        ByteString.a aVar = ByteString.f17101o;
        this(aVar.encodeUtf8(str), aVar.encodeUtf8(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.f17101o.encodeUtf8(str));
        i.checkNotNullParameter(byteString, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(str, "value");
    }
}
