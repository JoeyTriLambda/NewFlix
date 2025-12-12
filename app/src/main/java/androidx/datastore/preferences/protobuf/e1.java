package androidx.datastore.preferences.protobuf;

import cz.msebera.android.httpclient.message.TokenParser;

/* compiled from: TextFormatEscaper.java */
/* loaded from: classes.dex */
public final class e1 {

    /* compiled from: TextFormatEscaper.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteString f2447a;

        public a(ByteString byteString) {
            this.f2447a = byteString;
        }

        public byte byteAt(int i10) {
            return this.f2447a.byteAt(i10);
        }

        public int size() {
            return this.f2447a.size();
        }
    }

    public static String a(ByteString byteString) {
        a aVar = new a(byteString);
        StringBuilder sb2 = new StringBuilder(aVar.size());
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            byte bByteAt = aVar.byteAt(i10);
            if (bByteAt == 34) {
                sb2.append("\\\"");
            } else if (bByteAt == 39) {
                sb2.append("\\'");
            } else if (bByteAt != 92) {
                switch (bByteAt) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bByteAt < 32 || bByteAt > 126) {
                            sb2.append(TokenParser.ESCAPE);
                            sb2.append((char) (((bByteAt >>> 6) & 3) + 48));
                            sb2.append((char) (((bByteAt >>> 3) & 7) + 48));
                            sb2.append((char) ((bByteAt & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bByteAt);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }
}
