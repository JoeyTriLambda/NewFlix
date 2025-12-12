package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang3.StringUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class Wire {

    /* renamed from: id, reason: collision with root package name */
    private final String f10721id;
    private final HttpClientAndroidLog log;

    public Wire(HttpClientAndroidLog httpClientAndroidLog, String str) {
        this.log = httpClientAndroidLog;
        this.f10721id = str;
    }

    private void wire(String str, InputStream inputStream) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i10 = inputStream.read();
            if (i10 == -1) {
                break;
            }
            if (i10 == 13) {
                sb2.append("[\\r]");
            } else if (i10 == 10) {
                sb2.append("[\\n]\"");
                sb2.insert(0, "\"");
                sb2.insert(0, str);
                this.log.debug(this.f10721id + StringUtils.SPACE + sb2.toString());
                sb2.setLength(0);
            } else if (i10 < 32 || i10 > 127) {
                sb2.append("[0x");
                sb2.append(Integer.toHexString(i10));
                sb2.append("]");
            } else {
                sb2.append((char) i10);
            }
        }
        if (sb2.length() > 0) {
            sb2.append('\"');
            sb2.insert(0, '\"');
            sb2.insert(0, str);
            this.log.debug(this.f10721id + StringUtils.SPACE + sb2.toString());
        }
    }

    public boolean enabled() {
        return this.log.isDebugEnabled();
    }

    public void input(InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Input");
        wire("<< ", inputStream);
    }

    public void output(InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Output");
        wire(">> ", inputStream);
    }

    public void input(byte[] bArr, int i10, int i11) throws IOException {
        Args.notNull(bArr, "Input");
        wire("<< ", new ByteArrayInputStream(bArr, i10, i11));
    }

    public void output(byte[] bArr, int i10, int i11) throws IOException {
        Args.notNull(bArr, "Output");
        wire(">> ", new ByteArrayInputStream(bArr, i10, i11));
    }

    public Wire(HttpClientAndroidLog httpClientAndroidLog) {
        this(httpClientAndroidLog, "");
    }

    public void input(byte[] bArr) throws IOException {
        Args.notNull(bArr, "Input");
        wire("<< ", new ByteArrayInputStream(bArr));
    }

    public void output(byte[] bArr) throws IOException {
        Args.notNull(bArr, "Output");
        wire(">> ", new ByteArrayInputStream(bArr));
    }

    public void input(int i10) throws IOException {
        input(new byte[]{(byte) i10});
    }

    public void output(int i10) throws IOException {
        output(new byte[]{(byte) i10});
    }

    public void input(String str) throws IOException {
        Args.notNull(str, "Input");
        input(str.getBytes());
    }

    public void output(String str) throws IOException {
        Args.notNull(str, "Output");
        output(str.getBytes());
    }
}
