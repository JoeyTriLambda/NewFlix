package flix.com.vision.models;

import ac.c;
import android.util.Base64;
import androidx.annotation.Keep;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import u9.b;

@Keep
/* loaded from: classes2.dex */
public class Json {

    @b(JsonStorageKeyNames.DATA_KEY)
    private final String data;

    @b("hash")
    private final String hash;

    public Json() {
        String str = "" + getData();
        this.data = str;
        this.hash = hash(c.j("屁股混蛋亲吻我的鸡巴他妈的", str));
    }

    private int getData() {
        return new Random().nextInt(900);
    }

    private String hash(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArrDigest) {
                sb2.append(String.format("%02x", Byte.valueOf(b10)));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String toBase64(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }
}
