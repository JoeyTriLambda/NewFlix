package i6;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import i6.e;
import java.util.ArrayList;
import java.util.Collections;
import l6.l;
import l6.u;

/* compiled from: Mp4WebvttDecoder.java */
/* loaded from: classes.dex */
public final class b extends b6.b {

    /* renamed from: o, reason: collision with root package name */
    public static final int f13215o = u.getIntegerCodeForString("payl");

    /* renamed from: p, reason: collision with root package name */
    public static final int f13216p = u.getIntegerCodeForString("sttg");

    /* renamed from: q, reason: collision with root package name */
    public static final int f13217q = u.getIntegerCodeForString("vttc");

    /* renamed from: m, reason: collision with root package name */
    public final l f13218m;

    /* renamed from: n, reason: collision with root package name */
    public final e.b f13219n;

    public b() {
        super("Mp4WebvttDecoder");
        this.f13218m = new l();
        this.f13219n = new e.b();
    }

    @Override // b6.b
    public c decode(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException, NumberFormatException {
        l lVar = this.f13218m;
        lVar.reset(bArr, i10);
        ArrayList arrayList = new ArrayList();
        while (lVar.bytesLeft() > 0) {
            if (lVar.bytesLeft() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int i11 = lVar.readInt();
            if (lVar.readInt() == f13217q) {
                int i12 = i11 - 8;
                e.b bVar = this.f13219n;
                bVar.reset();
                while (i12 > 0) {
                    if (i12 < 8) {
                        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                    }
                    int i13 = lVar.readInt();
                    int i14 = lVar.readInt();
                    int i15 = i13 - 8;
                    String str = new String(lVar.f15881a, lVar.getPosition(), i15);
                    lVar.skipBytes(i15);
                    i12 = (i12 - 8) - i15;
                    if (i14 == f13216p) {
                        f.c(str, bVar);
                    } else if (i14 == f13215o) {
                        f.d(null, str.trim(), bVar, Collections.emptyList());
                    }
                }
                arrayList.add(bVar.build());
            } else {
                lVar.skipBytes(i11 - 8);
            }
        }
        return new c(arrayList);
    }
}
