package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
abstract class AbstractMultipartForm {
    private static final ByteArrayBuffer CR_LF;
    private static final ByteArrayBuffer FIELD_SEP;
    private static final ByteArrayBuffer TWO_DASHES;
    final String boundary;
    final Charset charset;

    static {
        Charset charset = MIME.DEFAULT_CHARSET;
        FIELD_SEP = encode(charset, ": ");
        CR_LF = encode(charset, "\r\n");
        TWO_DASHES = encode(charset, "--");
    }

    public AbstractMultipartForm(Charset charset, String str) {
        Args.notNull(str, "Multipart boundary");
        this.charset = charset == null ? MIME.DEFAULT_CHARSET : charset;
        this.boundary = str;
    }

    private static ByteArrayBuffer encode(Charset charset, String str) {
        ByteBuffer byteBufferEncode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(byteBufferEncode.remaining());
        byteArrayBuffer.append(byteBufferEncode.array(), byteBufferEncode.position(), byteBufferEncode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    public static void writeField(MinimalField minimalField, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public void doWriteTo(OutputStream outputStream, boolean z10) throws IOException {
        ByteArrayBuffer byteArrayBufferEncode = encode(this.charset, this.boundary);
        for (FormBodyPart formBodyPart : getBodyParts()) {
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(byteArrayBufferEncode, outputStream);
            ByteArrayBuffer byteArrayBuffer = CR_LF;
            writeBytes(byteArrayBuffer, outputStream);
            formatMultipartHeader(formBodyPart, outputStream);
            writeBytes(byteArrayBuffer, outputStream);
            if (z10) {
                formBodyPart.getBody().writeTo(outputStream);
            }
            writeBytes(byteArrayBuffer, outputStream);
        }
        ByteArrayBuffer byteArrayBuffer2 = TWO_DASHES;
        writeBytes(byteArrayBuffer2, outputStream);
        writeBytes(byteArrayBufferEncode, outputStream);
        writeBytes(byteArrayBuffer2, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public abstract void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException;

    public abstract List<FormBodyPart> getBodyParts();

    public long getTotalLength() {
        Iterator<FormBodyPart> it = getBodyParts().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            long contentLength = it.next().getBody().getContentLength();
            if (contentLength < 0) {
                return -1L;
            }
            j10 += contentLength;
        }
        try {
            doWriteTo(new ByteArrayOutputStream(), false);
            return j10 + r0.toByteArray().length;
        } catch (IOException unused) {
            return -1L;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        doWriteTo(outputStream, true);
    }

    private static void writeBytes(String str, Charset charset, OutputStream outputStream) throws IOException {
        writeBytes(encode(charset, str), outputStream);
    }

    private static void writeBytes(String str, OutputStream outputStream) throws IOException {
        writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
    }

    public AbstractMultipartForm(String str) {
        this(null, str);
    }

    public static void writeField(MinimalField minimalField, Charset charset, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), charset, outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), charset, outputStream);
        writeBytes(CR_LF, outputStream);
    }
}
