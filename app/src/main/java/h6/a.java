package h6;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import b6.d;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.charset.Charset;
import java.util.List;
import l6.l;
import l6.u;

/* compiled from: Tx3gDecoder.java */
/* loaded from: classes.dex */
public final class a extends b6.b {

    /* renamed from: t, reason: collision with root package name */
    public static final int f12933t = u.getIntegerCodeForString("styl");

    /* renamed from: u, reason: collision with root package name */
    public static final int f12934u = u.getIntegerCodeForString("tbox");

    /* renamed from: m, reason: collision with root package name */
    public final l f12935m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12936n;

    /* renamed from: o, reason: collision with root package name */
    public int f12937o;

    /* renamed from: p, reason: collision with root package name */
    public int f12938p;

    /* renamed from: q, reason: collision with root package name */
    public String f12939q;

    /* renamed from: r, reason: collision with root package name */
    public float f12940r;

    /* renamed from: s, reason: collision with root package name */
    public int f12941s;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f12935m = new l();
        if (list == null || list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f12937o = 0;
            this.f12938p = -1;
            this.f12939q = "sans-serif";
            this.f12936n = false;
            this.f12940r = 0.85f;
            return;
        }
        byte[] bArr = list.get(0);
        this.f12937o = bArr[24];
        this.f12938p = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f12939q = "Serif".equals(new String(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i10 = bArr[25] * 20;
        this.f12941s = i10;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f12936n = z10;
        if (!z10) {
            this.f12940r = 0.85f;
            return;
        }
        float f10 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i10;
        this.f12940r = f10;
        this.f12940r = u.constrainValue(f10, 0.0f, 0.95f);
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            int i15 = i14 | 33;
            boolean z10 = (i10 & 1) != 0;
            boolean z11 = (i10 & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i12, i13, i15);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i12, i13, i15);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, i13, i15);
            }
            boolean z12 = (i10 & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i13, i15);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i12, i13, i15);
        }
    }

    @Override // b6.b
    public d decode(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        char cPeekChar;
        l lVar = this.f12935m;
        lVar.reset(bArr, i10);
        int i11 = 1;
        if (!(lVar.bytesLeft() >= 2)) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
        int unsignedShort = lVar.readUnsignedShort();
        String string = unsignedShort == 0 ? "" : (lVar.bytesLeft() < 2 || !((cPeekChar = lVar.peekChar()) == 65279 || cPeekChar == 65534)) ? lVar.readString(unsignedShort, Charset.forName("UTF-8")) : lVar.readString(unsignedShort, Charset.forName("UTF-16"));
        if (string.isEmpty()) {
            return b.f12942m;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        c(spannableStringBuilder, this.f12937o, 0, 0, spannableStringBuilder.length(), 16711680);
        int i12 = this.f12938p;
        int length = spannableStringBuilder.length();
        if (i12 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i12 >>> 8) | ((i12 & 255) << 24)), 0, length, 16711713);
        }
        String str = this.f12939q;
        int length2 = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fConstrainValue = this.f12940r;
        while (lVar.bytesLeft() >= 8) {
            int position = lVar.getPosition();
            int i13 = lVar.readInt();
            int i14 = lVar.readInt();
            if (i14 == f12933t) {
                if (!(lVar.bytesLeft() >= 2)) {
                    throw new SubtitleDecoderException("Unexpected subtitle format.");
                }
                int unsignedShort2 = lVar.readUnsignedShort();
                int i15 = 0;
                while (i15 < unsignedShort2) {
                    if (!(lVar.bytesLeft() >= 12)) {
                        throw new SubtitleDecoderException("Unexpected subtitle format.");
                    }
                    int unsignedShort3 = lVar.readUnsignedShort();
                    int unsignedShort4 = lVar.readUnsignedShort();
                    lVar.skipBytes(2);
                    int unsignedByte = lVar.readUnsignedByte();
                    lVar.skipBytes(i11);
                    int i16 = lVar.readInt();
                    int i17 = i15;
                    int i18 = unsignedShort2;
                    c(spannableStringBuilder, unsignedByte, this.f12937o, unsignedShort3, unsignedShort4, 0);
                    if (i16 != this.f12938p) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan((i16 >>> 8) | ((i16 & 255) << 24)), unsignedShort3, unsignedShort4, 33);
                    }
                    i15 = i17 + 1;
                    unsignedShort2 = i18;
                    i11 = 1;
                }
            } else if (i14 == f12934u && this.f12936n) {
                if (!(lVar.bytesLeft() >= 2)) {
                    throw new SubtitleDecoderException("Unexpected subtitle format.");
                }
                fConstrainValue = u.constrainValue(lVar.readUnsignedShort() / this.f12941s, 0.0f, 0.95f);
            }
            lVar.setPosition(position + i13);
            i11 = 1;
        }
        return new b(new b6.a(spannableStringBuilder, null, fConstrainValue, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }
}
