package i6;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import i6.e;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.l;

/* compiled from: WebvttDecoder.java */
/* loaded from: classes.dex */
public final class g extends b6.b {

    /* renamed from: m, reason: collision with root package name */
    public final f f13258m;

    /* renamed from: n, reason: collision with root package name */
    public final l f13259n;

    /* renamed from: o, reason: collision with root package name */
    public final e.b f13260o;

    /* renamed from: p, reason: collision with root package name */
    public final a f13261p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f13262q;

    public g() {
        super("WebvttDecoder");
        this.f13258m = new f();
        this.f13259n = new l();
        this.f13260o = new e.b();
        this.f13261p = new a();
        this.f13262q = new ArrayList();
    }

    @Override // b6.b
    public i decode(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException, NumberFormatException {
        l lVar = this.f13259n;
        lVar.reset(bArr, i10);
        e.b bVar = this.f13260o;
        bVar.reset();
        ArrayList arrayList = this.f13262q;
        arrayList.clear();
        h.validateWebvttHeaderLine(lVar);
        while (!TextUtils.isEmpty(lVar.readLine())) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            boolean zB = false;
            char c10 = 65535;
            int position = 0;
            while (c10 == 65535) {
                position = lVar.getPosition();
                String line = lVar.readLine();
                c10 = line == null ? (char) 0 : "STYLE".equals(line) ? (char) 2 : "NOTE".startsWith(line) ? (char) 1 : (char) 3;
            }
            lVar.setPosition(position);
            if (c10 == 0) {
                return new i(arrayList2);
            }
            if (c10 == 1) {
                while (!TextUtils.isEmpty(lVar.readLine())) {
                }
            } else if (c10 == 2) {
                if (!arrayList2.isEmpty()) {
                    throw new SubtitleDecoderException("A style block was found after the first cue.");
                }
                lVar.readLine();
                d block = this.f13261p.parseBlock(lVar);
                if (block != null) {
                    arrayList.add(block);
                }
            } else if (c10 == 3) {
                e.b bVar2 = this.f13260o;
                f fVar = this.f13258m;
                fVar.getClass();
                String line2 = lVar.readLine();
                if (line2 != null) {
                    Pattern pattern = f.f13248b;
                    Matcher matcher = pattern.matcher(line2);
                    if (matcher.matches()) {
                        zB = f.b(null, matcher, lVar, bVar2, fVar.f13250a, arrayList);
                    } else {
                        String line3 = lVar.readLine();
                        if (line3 != null) {
                            Matcher matcher2 = pattern.matcher(line3);
                            if (matcher2.matches()) {
                                zB = f.b(line2.trim(), matcher2, lVar, bVar2, fVar.f13250a, arrayList);
                            }
                        }
                    }
                }
                if (zB) {
                    arrayList2.add(bVar.build());
                    bVar.reset();
                }
            }
        }
    }
}
