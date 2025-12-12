package fd;

import java.text.DecimalFormat;

/* compiled from: Helpers.java */
/* loaded from: classes2.dex */
public final class e {
    public static String readableFileSize(long j10) {
        if (j10 < 0) {
            j10 *= -1;
        }
        if (j10 <= 0) {
            return "0";
        }
        try {
            double d10 = j10;
            int iLog10 = (int) (Math.log10(d10) / Math.log10(1024.0d));
            return new DecimalFormat("#,##0.#").format(d10 / Math.pow(1024.0d, iLog10)) + new String[]{"B", "kB", "MB", "GB", "TB"}[iLog10];
        } catch (Exception unused) {
            return "N/A";
        }
    }
}
