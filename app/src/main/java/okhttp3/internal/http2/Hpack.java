package okhttp3.internal.http2;

import ah.c;
import ah.e;
import ah.m;
import ah.y;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mf.h;
import mf.q;
import okhttp3.internal.Util;
import okio.ByteString;
import org.adblockplus.libadblockplus.HttpClient;
import zf.f;
import zf.i;

/* compiled from: Hpack.kt */
/* loaded from: classes2.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    /* compiled from: Hpack.kt */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final e source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(y yVar, int i10) {
            this(yVar, i10, 0, 4, null);
            i.checkNotNullParameter(yVar, "source");
        }

        private final void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i11 - i10);
                }
            }
        }

        private final void clearDynamicTable() {
            h.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i10) {
            return this.nextHeaderIndex + 1 + i10;
        }

        private final int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    i.checkNotNull(header);
                    int i13 = header.hpackSize;
                    i10 -= i13;
                    this.dynamicTableByteCount -= i13;
                    this.headerCount--;
                    i12++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private final ByteString getName(int i10) throws IOException {
            if (isStaticHeader(i10)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i10].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i10 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    Header header = headerArr[iDynamicTableIndex];
                    i.checkNotNull(header);
                    return header.name;
                }
            }
            throw new IOException(i.stringPlus("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        private final void insertIntoDynamicTable(int i10, Header header) {
            this.headerList.add(header);
            int i11 = header.hpackSize;
            if (i10 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i10)];
                i.checkNotNull(header2);
                i11 -= header2.hpackSize;
            }
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            if (i10 == -1) {
                int i13 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i13 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i14 = this.nextHeaderIndex;
                this.nextHeaderIndex = i14 - 1;
                this.dynamicTable[i14] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i10) + iEvictToRecoverBytes + i10] = header;
            }
            this.dynamicTableByteCount += i11;
        }

        private final boolean isStaticHeader(int i10) {
            return i10 >= 0 && i10 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i10) throws IOException {
            if (isStaticHeader(i10)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i10]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i10 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[iDynamicTableIndex];
                    i.checkNotNull(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException(i.stringPlus("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i10) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i10), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i10) throws IOException {
            this.headerList.add(new Header(getName(i10), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> list = q.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            int i10 = readByte();
            boolean z10 = (i10 & 128) == 128;
            long j10 = readInt(i10, 127);
            if (!z10) {
                return this.source.readByteString(j10);
            }
            c cVar = new c();
            Huffman.INSTANCE.decode(this.source, j10, cVar);
            return cVar.readByteString();
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int iAnd = Util.and(this.source.readByte(), 255);
                if (iAnd == 128) {
                    throw new IOException("index == 0");
                }
                if ((iAnd & 128) == 128) {
                    readIndexedHeader(readInt(iAnd, 127) - 1);
                } else if (iAnd == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((iAnd & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(iAnd, 63) - 1);
                } else if ((iAnd & 32) == 32) {
                    int i10 = readInt(iAnd, 31);
                    this.maxDynamicTableByteCount = i10;
                    if (i10 < 0 || i10 > this.headerTableSizeSetting) {
                        throw new IOException(i.stringPlus("Invalid dynamic table size update ", Integer.valueOf(this.maxDynamicTableByteCount)));
                    }
                    adjustDynamicTableByteCount();
                } else if (iAnd == 16 || iAnd == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(iAnd, 15) - 1);
                }
            }
        }

        public final int readInt(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = readByte();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & 127) << i13;
                i13 += 7;
            }
        }

        public Reader(y yVar, int i10, int i11) {
            i.checkNotNullParameter(yVar, "source");
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i11;
            this.headerList = new ArrayList();
            this.source = m.buffer(yVar);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Reader(y yVar, int i10, int i11, int i12, f fVar) {
            this(yVar, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    /* compiled from: Hpack.kt */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final c out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(int i10, c cVar) {
            this(i10, false, cVar, 2, null);
            i.checkNotNullParameter(cVar, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i11 - i10);
                }
            }
        }

        private final void clearDynamicTable() {
            h.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    i.checkNotNull(header);
                    i10 -= header.hpackSize;
                    int i13 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    i.checkNotNull(header2);
                    this.dynamicTableByteCount = i13 - header2.hpackSize;
                    this.headerCount--;
                    i12++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i14 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i10 = header.hpackSize;
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i10) - i11);
            int i12 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i12 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i13 = this.nextHeaderIndex;
            this.nextHeaderIndex = i13 - 1;
            this.dynamicTable[i13] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i10;
        }

        public final void resizeHeaderTable(int i10) {
            this.headerTableSizeSetting = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.maxDynamicTableByteCount;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString byteString) throws IOException {
            i.checkNotNullParameter(byteString, JsonStorageKeyNames.DATA_KEY);
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(byteString) < byteString.size()) {
                    c cVar = new c();
                    huffman.encode(byteString, cVar);
                    ByteString byteString2 = cVar.readByteString();
                    writeInt(byteString2.size(), 127, 128);
                    this.out.write(byteString2);
                    return;
                }
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r15) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.out.writeByte(i10 | i12);
                return;
            }
            this.out.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.out.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.out.writeByte(i13);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(c cVar) {
            this(0, false, cVar, 3, null);
            i.checkNotNullParameter(cVar, "out");
        }

        public Writer(int i10, boolean z10, c cVar) {
            i.checkNotNullParameter(cVar, "out");
            this.headerTableSizeSetting = i10;
            this.useCompression = z10;
            this.out = cVar;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i10;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i10, boolean z10, c cVar, int i11, f fVar) {
            this((i11 & 1) != 0 ? Hpack.SETTINGS_HEADER_TABLE_SIZE : i10, (i11 & 2) != 0 ? true : z10, cVar);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, HttpHost.DEFAULT_SCHEME_NAME), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header(HttpClient.HEADER_CONTENT_LENGTH, ""), new Header("content-location", ""), new Header("content-range", ""), new Header(HttpClient.HEADER_CONTENT_TYPE, ""), new Header("cookie", ""), new Header(HttpClient.HEADER_DATE, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header(HttpClient.HEADER_LAST_MODIFIED, ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header(HttpClient.HEADER_PROXY_AUTHENTICATE, ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header(HttpClient.HEADER_RETRY_AFTER, ""), new Header("server", ""), new Header(HttpClient.HEADER_SET_COOKIE, ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header(HttpClient.HEADER_VIA, ""), new Header(HttpClient.HEADER_WWW_AUTHENTICATE, "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i10].name)) {
                linkedHashMap.put(headerArr2[i10].name, Integer.valueOf(i10));
            }
            i10 = i11;
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        i.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString byteString) throws IOException {
        i.checkNotNullParameter(byteString, MediationMetaData.KEY_NAME);
        int size = byteString.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            byte b10 = byteString.getByte(i10);
            if (65 <= b10 && b10 <= 90) {
                throw new IOException(i.stringPlus("PROTOCOL_ERROR response malformed: mixed case name: ", byteString.utf8()));
            }
            i10 = i11;
        }
        return byteString;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
