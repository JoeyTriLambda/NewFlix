package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.lang3.ClassUtils;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes2.dex */
class BasicIdGenerator {
    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public BasicIdGenerator() {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused) {
            hostName = "localhost";
        }
        this.hostname = hostName;
        try {
            this.rnd = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e10) {
            throw new Error(e10);
        }
    }

    public synchronized void generate(StringBuilder sb2) {
        this.count++;
        int iNextInt = this.rnd.nextInt();
        sb2.append(System.currentTimeMillis());
        sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        Formatter formatter = new Formatter(sb2, Locale.US);
        formatter.format("%1$016x-%2$08x", Long.valueOf(this.count), Integer.valueOf(iNextInt));
        formatter.close();
        sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb2.append(this.hostname);
    }

    public String generate() {
        StringBuilder sb2 = new StringBuilder();
        generate(sb2);
        return sb2.toString();
    }
}
