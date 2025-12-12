package ah;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* compiled from: BufferedSource.kt */
/* loaded from: classes2.dex */
public interface e extends y, ReadableByteChannel {
    boolean exhausted() throws IOException;

    c getBuffer();

    long indexOfElement(ByteString byteString) throws IOException;

    InputStream inputStream();

    e peek();

    boolean rangeEquals(long j10, ByteString byteString) throws IOException;

    long readAll(w wVar) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long j10) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long j10) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(c cVar, long j10) throws IOException;

    void readFully(byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    String readString(Charset charset) throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long j10) throws IOException;

    boolean request(long j10) throws IOException;

    void require(long j10) throws IOException;

    int select(p pVar) throws IOException;

    void skip(long j10) throws IOException;
}
