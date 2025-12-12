package f6;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.g;
import l6.l;

/* compiled from: SubripDecoder.java */
/* loaded from: classes.dex */
public final class a extends b6.b {

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f11519n = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");

    /* renamed from: m, reason: collision with root package name */
    public final StringBuilder f11520m;

    public a() {
        super("SubripDecoder");
        this.f11520m = new StringBuilder();
    }

    public static long c(Matcher matcher, int i10) {
        return (Long.parseLong(matcher.group(i10 + 4)) + (Long.parseLong(matcher.group(i10 + 3)) * 1000) + (Long.parseLong(matcher.group(i10 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i10 + 1)) * 60 * 60 * 1000)) * 1000;
    }

    @Override // b6.b
    public b decode(byte[] bArr, int i10, boolean z10) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i10);
        while (true) {
            String line = lVar.readLine();
            if (line == null) {
                break;
            }
            if (line.length() != 0) {
                try {
                    Integer.parseInt(line);
                    String line2 = lVar.readLine();
                    if (line2 == null) {
                        Log.w("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f11519n.matcher(line2);
                    if (matcher.matches()) {
                        boolean z11 = true;
                        gVar.add(c(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            z11 = false;
                        } else {
                            gVar.add(c(matcher, 6));
                        }
                        StringBuilder sb2 = this.f11520m;
                        sb2.setLength(0);
                        while (true) {
                            String line3 = lVar.readLine();
                            if (TextUtils.isEmpty(line3)) {
                                break;
                            }
                            if (sb2.length() > 0) {
                                sb2.append("<br>");
                            }
                            sb2.append(line3.trim());
                        }
                        arrayList.add(new b6.a(Html.fromHtml(sb2.toString())));
                        if (z11) {
                            arrayList.add(null);
                        }
                    } else {
                        Log.w("SubripDecoder", "Skipping invalid timing: ".concat(line2));
                    }
                } catch (NumberFormatException unused) {
                    Log.w("SubripDecoder", "Skipping invalid index: ".concat(line));
                }
            }
        }
        b6.a[] aVarArr = new b6.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new b(aVarArr, gVar.toArray());
    }
}
