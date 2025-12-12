package k9;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.adblockplus.libadblockplus.security.JavaSignatureVerifier;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IidStore.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f15033c = {"*", "FCM", "GCM", ""};

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f15034a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15035b;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(g8.f r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.getApplicationContext()
            java.lang.String r1 = "com.google.android.gms.appid"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.f15034a = r0
            g8.i r0 = r4.getOptions()
            java.lang.String r0 = r0.getGcmSenderId()
            if (r0 == 0) goto L1b
            goto L4b
        L1b:
            g8.i r4 = r4.getOptions()
            java.lang.String r0 = r4.getApplicationId()
            java.lang.String r4 = "1:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L34
            java.lang.String r4 = "2:"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L34
            goto L4b
        L34:
            java.lang.String r4 = ":"
            java.lang.String[] r4 = r0.split(r4)
            int r0 = r4.length
            r1 = 4
            r2 = 0
            if (r0 == r1) goto L41
        L3f:
            r0 = r2
            goto L4b
        L41:
            r0 = 1
            r0 = r4[r0]
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L4b
            goto L3f
        L4b:
            r3.f15035b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k9.a.<init>(g8.f):void");
    }

    public final String a() {
        String string;
        synchronized (this.f15034a) {
            string = this.f15034a.getString("|S|id", null);
        }
        return string;
    }

    public final String b() {
        PublicKey publicKeyGeneratePublic;
        synchronized (this.f15034a) {
            String strEncodeToString = null;
            String string = this.f15034a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            try {
                publicKeyGeneratePublic = KeyFactory.getInstance(JavaSignatureVerifier.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e10) {
                Log.w("ContentValues", "Invalid key stored " + e10);
                publicKeyGeneratePublic = null;
            }
            if (publicKeyGeneratePublic == null) {
                return null;
            }
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKeyGeneratePublic.getEncoded());
                bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
                strEncodeToString = Base64.encodeToString(bArrDigest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
                Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            }
            return strEncodeToString;
        }
    }

    public String readIid() {
        synchronized (this.f15034a) {
            String strA = a();
            if (strA != null) {
                return strA;
            }
            return b();
        }
    }

    public String readToken() {
        synchronized (this.f15034a) {
            String[] strArr = f15033c;
            int i10 = 0;
            while (true) {
                String string = null;
                if (i10 >= 4) {
                    return null;
                }
                String str = strArr[i10];
                String string2 = this.f15034a.getString("|T|" + this.f15035b + "|" + str, null);
                if (string2 != null && !string2.isEmpty()) {
                    if (string2.startsWith("{")) {
                        try {
                            string = new JSONObject(string2).getString("token");
                        } catch (JSONException unused) {
                        }
                        string2 = string;
                    }
                    return string2;
                }
                i10++;
            }
        }
    }
}
