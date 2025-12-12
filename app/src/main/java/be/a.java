package be;

import cz.msebera.android.httpclient.message.TokenParser;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: C9296b.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final IvParameterSpec f4868a = new IvParameterSpec("bRRhl2H2j7yXmuk4".getBytes());

    /* renamed from: b, reason: collision with root package name */
    public final SecretKeySpec f4869b = new SecretKeySpec("cLt3Gp39O3yvW7Gw".getBytes(), "AES");

    /* renamed from: c, reason: collision with root package name */
    public final Cipher f4870c;

    public a() {
        try {
            this.f4870c = Cipher.getInstance("AES/CBC/NoPadding");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
        } catch (NoSuchPaddingException e11) {
            e11.printStackTrace();
        }
    }

    public static String m33719a(byte[] bArr) {
        StringBuilder sbR;
        byte b10;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        String string = "";
        for (int i10 = 0; i10 < length; i10++) {
            if ((bArr[i10] & 255) < 16) {
                sbR = ac.c.u(string, "0");
                b10 = bArr[i10];
            } else {
                sbR = ac.c.r(string);
                b10 = bArr[i10];
            }
            sbR.append(Integer.toHexString(b10 & 255));
            string = sbR.toString();
        }
        return string;
    }

    public byte[] mo31918a(String str) throws Exception {
        Cipher cipher = this.f4870c;
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            cipher.init(1, this.f4869b, this.f4868a);
            int length = 16 - (str.length() % 16);
            for (int i10 = 0; i10 < length; i10++) {
                str = str + TokenParser.SP;
            }
            return cipher.doFinal(str.getBytes());
        } catch (Exception e10) {
            throw new Exception("[encrypt] " + e10.getMessage());
        }
    }
}
