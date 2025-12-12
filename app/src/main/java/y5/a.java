package y5;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Aes128DataSource.java */
/* loaded from: classes.dex */
public final class a implements k6.d {

    /* renamed from: a, reason: collision with root package name */
    public final k6.d f21910a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f21911b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f21912c;

    /* renamed from: d, reason: collision with root package name */
    public CipherInputStream f21913d;

    public a(k6.d dVar, byte[] bArr, byte[] bArr2) {
        this.f21910a = dVar;
        this.f21911b = bArr;
        this.f21912c = bArr2;
    }

    @Override // k6.d
    public void close() throws IOException {
        this.f21913d = null;
        this.f21910a.close();
    }

    @Override // k6.d
    public Uri getUri() {
        return this.f21910a.getUri();
    }

    @Override // k6.d
    public long open(k6.f fVar) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f21911b, "AES"), new IvParameterSpec(this.f21912c));
                this.f21913d = new CipherInputStream(new k6.e(this.f21910a, fVar), cipher);
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e10) {
                throw new RuntimeException(e10);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // k6.d
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        l6.a.checkState(this.f21913d != null);
        int i12 = this.f21913d.read(bArr, i10, i11);
        if (i12 < 0) {
            return -1;
        }
        return i12;
    }
}
