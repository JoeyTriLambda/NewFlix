package r8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import t8.f0;

/* compiled from: BytesBackedNativeSessionFile.java */
/* loaded from: classes.dex */
public final class g implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f18692a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18693b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18694c;

    public g(String str, String str2, byte[] bArr) {
        this.f18693b = str;
        this.f18694c = str2;
        this.f18692a = bArr;
    }

    @Override // r8.j0
    public f0.d.b asFilePayload() throws IOException {
        byte[] byteArray;
        byte[] bArr = this.f18692a;
        if (bArr == null || bArr.length == 0) {
            byteArray = null;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException unused) {
            }
        }
        if (byteArray == null) {
            return null;
        }
        return f0.d.b.builder().setContents(byteArray).setFilename(this.f18693b).build();
    }

    @Override // r8.j0
    public String getReportsEndpointFilename() {
        return this.f18694c;
    }

    @Override // r8.j0
    public InputStream getStream() {
        byte[] bArr = this.f18692a;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(bArr);
    }
}
