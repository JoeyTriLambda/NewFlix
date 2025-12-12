package ah;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* compiled from: BufferedSink.kt */
/* loaded from: classes2.dex */
public interface d extends w, WritableByteChannel {
    d emit() throws IOException;

    d emitCompleteSegments() throws IOException;

    @Override // ah.w, java.io.Flushable
    void flush() throws IOException;

    c getBuffer();

    d write(ByteString byteString) throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i10, int i11) throws IOException;

    long writeAll(y yVar) throws IOException;

    d writeByte(int i10) throws IOException;

    d writeDecimalLong(long j10) throws IOException;

    d writeHexadecimalUnsignedLong(long j10) throws IOException;

    d writeInt(int i10) throws IOException;

    d writeShort(int i10) throws IOException;

    d writeUtf8(String str) throws IOException;

    d writeUtf8(String str, int i10, int i11) throws IOException;
}
