package e6;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.g;
import l6.l;
import org.apache.commons.lang3.StringUtils;

/* compiled from: SsaDecoder.java */
/* loaded from: classes.dex */
public final class a extends b6.b {

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f11159r = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");

    /* renamed from: m, reason: collision with root package name */
    public final boolean f11160m;

    /* renamed from: n, reason: collision with root package name */
    public int f11161n;

    /* renamed from: o, reason: collision with root package name */
    public int f11162o;

    /* renamed from: p, reason: collision with root package name */
    public int f11163p;

    /* renamed from: q, reason: collision with root package name */
    public int f11164q;

    public a(List<byte[]> list) {
        String line;
        super("SsaDecoder");
        if (list == null) {
            this.f11160m = false;
            return;
        }
        this.f11160m = true;
        String str = new String(list.get(0));
        l6.a.checkArgument(str.startsWith("Format: "));
        c(str);
        l lVar = new l(list.get(1));
        do {
            line = lVar.readLine();
            if (line == null) {
                return;
            }
        } while (!line.startsWith("[Events]"));
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = f11159r.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 8
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r9 = android.text.TextUtils.split(r9, r0)
            int r0 = r9.length
            r8.f11161n = r0
            r0 = -1
            r8.f11162o = r0
            r8.f11163p = r0
            r8.f11164q = r0
            r1 = 0
            r2 = 0
        L18:
            int r3 = r8.f11161n
            if (r2 >= r3) goto L72
            r3 = r9[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = l6.u.toLowerInvariant(r3)
            r3.getClass()
            int r4 = r3.hashCode()
            r5 = 100571(0x188db, float:1.4093E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L55
            r5 = 3556653(0x36452d, float:4.983932E-39)
            if (r4 == r5) goto L4a
            r5 = 109757538(0x68ac462, float:5.219839E-35)
            if (r4 == r5) goto L3f
            goto L5d
        L3f:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L48
            goto L5d
        L48:
            r3 = 2
            goto L60
        L4a:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L53
            goto L5d
        L53:
            r3 = 1
            goto L60
        L55:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L5f
        L5d:
            r3 = -1
            goto L60
        L5f:
            r3 = 0
        L60:
            if (r3 == 0) goto L6d
            if (r3 == r7) goto L6a
            if (r3 == r6) goto L67
            goto L6f
        L67:
            r8.f11162o = r2
            goto L6f
        L6a:
            r8.f11164q = r2
            goto L6f
        L6d:
            r8.f11163p = r2
        L6f:
            int r2 = r2 + 1
            goto L18
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.a.c(java.lang.String):void");
    }

    @Override // b6.b
    public b decode(byte[] bArr, int i10, boolean z10) {
        long timecodeUs;
        String line;
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i10);
        boolean z11 = this.f11160m;
        if (!z11) {
            do {
                line = lVar.readLine();
                if (line == null) {
                    break;
                }
            } while (!line.startsWith("[Events]"));
        }
        while (true) {
            String line2 = lVar.readLine();
            if (line2 == null) {
                b6.a[] aVarArr = new b6.a[arrayList.size()];
                arrayList.toArray(aVarArr);
                return new b(aVarArr, gVar.toArray());
            }
            if (!z11 && line2.startsWith("Format: ")) {
                c(line2);
            } else if (line2.startsWith("Dialogue: ")) {
                if (this.f11161n == 0) {
                    Log.w("SsaDecoder", "Skipping dialogue line before format: ".concat(line2));
                } else {
                    String[] strArrSplit = line2.substring(10).split(",", this.f11161n);
                    long timecodeUs2 = parseTimecodeUs(strArrSplit[this.f11162o]);
                    if (timecodeUs2 == -9223372036854775807L) {
                        Log.w("SsaDecoder", "Skipping invalid timing: ".concat(line2));
                    } else {
                        String str = strArrSplit[this.f11163p];
                        if (str.trim().isEmpty()) {
                            timecodeUs = -9223372036854775807L;
                        } else {
                            timecodeUs = parseTimecodeUs(str);
                            if (timecodeUs == -9223372036854775807L) {
                                Log.w("SsaDecoder", "Skipping invalid timing: ".concat(line2));
                            }
                        }
                        arrayList.add(new b6.a(strArrSplit[this.f11164q].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", StringUtils.LF).replaceAll("\\\\n", StringUtils.LF)));
                        gVar.add(timecodeUs2);
                        if (timecodeUs != -9223372036854775807L) {
                            arrayList.add(null);
                            gVar.add(timecodeUs);
                        }
                    }
                }
            }
        }
    }
}
