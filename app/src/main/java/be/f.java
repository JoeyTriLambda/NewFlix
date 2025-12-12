package be;

import android.util.Base64;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;

/* compiled from: TextUtils.java */
/* loaded from: classes2.dex */
public final class f {
    public static String createSlug(String str) {
        return removeSpecialCharsKeepSpace(str).trim().replace(StringUtils.SPACE, "-");
    }

    public static String cryptoHandler(String str, String str2, String str3, boolean z10) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            if (z10) {
                cipher.init(1, secretKeySpec, ivParameterSpec);
                new String(cipher.doFinal(str.getBytes()));
                return encodeBase64Bytes(cipher.doFinal(str.getBytes()));
            }
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] bArrDecodeBase64Array = decodeBase64Array(str);
            if (bArrDecodeBase64Array == null) {
                return null;
            }
            return new String(cipher.doFinal(bArrDecodeBase64Array));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decodeBase64(String str) {
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decodeBase64Array(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encodeBase64(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encodeBase64Bytes(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String formatSeasonnumber(int i10) {
        return i10 < 10 ? ac.c.f("0", i10) : String.valueOf(i10);
    }

    public static String getBaseUrl(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + "://" + url.getHost();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static String getHashFromMagnet(String str) {
        try {
            return str.split("&")[0].split(":")[r1.length - 1];
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isEmpty(String str) {
        return str.isEmpty();
    }

    public static boolean notNull(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public static String removeSpecialChars(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String removeSpecialCharsKeepSpace(String str) {
        return str.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static String removeTrailingColon(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        return (strTrim == null || !strTrim.endsWith(",")) ? strTrim : strTrim.substring(0, strTrim.length() - 1);
    }

    public static Date stringToDate(String str, String str2) {
        if (str == null) {
            return null;
        }
        return new SimpleDateFormat(str2).parse(str, new ParsePosition(0));
    }
}
