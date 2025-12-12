package c6;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import b6.h;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import l6.k;
import l6.l;

/* compiled from: Cea708Decoder.java */
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: f, reason: collision with root package name */
    public final l f5200f = new l();

    /* renamed from: g, reason: collision with root package name */
    public final k f5201g = new k();

    /* renamed from: h, reason: collision with root package name */
    public final int f5202h;

    /* renamed from: i, reason: collision with root package name */
    public final a[] f5203i;

    /* renamed from: j, reason: collision with root package name */
    public a f5204j;

    /* renamed from: k, reason: collision with root package name */
    public List<b6.a> f5205k;

    /* renamed from: l, reason: collision with root package name */
    public List<b6.a> f5206l;

    /* renamed from: m, reason: collision with root package name */
    public b f5207m;

    /* renamed from: n, reason: collision with root package name */
    public int f5208n;

    /* compiled from: Cea708Decoder.java */
    public static final class a {
        public static final int[] A;
        public static final int[] B;
        public static final boolean[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int[] G;

        /* renamed from: w, reason: collision with root package name */
        public static final int f5209w = getArgbColorFromCeaColor(2, 2, 2, 0);

        /* renamed from: x, reason: collision with root package name */
        public static final int f5210x;

        /* renamed from: y, reason: collision with root package name */
        public static final int f5211y;

        /* renamed from: z, reason: collision with root package name */
        public static final int[] f5212z;

        /* renamed from: a, reason: collision with root package name */
        public final LinkedList f5213a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        public final SpannableStringBuilder f5214b = new SpannableStringBuilder();

        /* renamed from: c, reason: collision with root package name */
        public boolean f5215c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f5216d;

        /* renamed from: e, reason: collision with root package name */
        public int f5217e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f5218f;

        /* renamed from: g, reason: collision with root package name */
        public int f5219g;

        /* renamed from: h, reason: collision with root package name */
        public int f5220h;

        /* renamed from: i, reason: collision with root package name */
        public int f5221i;

        /* renamed from: j, reason: collision with root package name */
        public int f5222j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f5223k;

        /* renamed from: l, reason: collision with root package name */
        public int f5224l;

        /* renamed from: m, reason: collision with root package name */
        public int f5225m;

        /* renamed from: n, reason: collision with root package name */
        public int f5226n;

        /* renamed from: o, reason: collision with root package name */
        public int f5227o;

        /* renamed from: p, reason: collision with root package name */
        public int f5228p;

        /* renamed from: q, reason: collision with root package name */
        public int f5229q;

        /* renamed from: r, reason: collision with root package name */
        public int f5230r;

        /* renamed from: s, reason: collision with root package name */
        public int f5231s;

        /* renamed from: t, reason: collision with root package name */
        public int f5232t;

        /* renamed from: u, reason: collision with root package name */
        public int f5233u;

        /* renamed from: v, reason: collision with root package name */
        public int f5234v;

        static {
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 0);
            f5210x = argbColorFromCeaColor;
            int argbColorFromCeaColor2 = getArgbColorFromCeaColor(0, 0, 0, 3);
            f5211y = argbColorFromCeaColor2;
            f5212z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor2};
        }

        public a() {
            reset();
        }

        public static int getArgbColorFromCeaColor(int i10, int i11, int i12) {
            return getArgbColorFromCeaColor(i10, i11, i12, 0);
        }

        public void append(char c10) {
            SpannableStringBuilder spannableStringBuilder = this.f5214b;
            if (c10 != '\n') {
                spannableStringBuilder.append(c10);
                return;
            }
            LinkedList linkedList = this.f5213a;
            linkedList.add(buildSpannableString());
            spannableStringBuilder.clear();
            if (this.f5228p != -1) {
                this.f5228p = 0;
            }
            if (this.f5229q != -1) {
                this.f5229q = 0;
            }
            if (this.f5230r != -1) {
                this.f5230r = 0;
            }
            if (this.f5232t != -1) {
                this.f5232t = 0;
            }
            while (true) {
                if ((!this.f5223k || linkedList.size() < this.f5222j) && linkedList.size() < 15) {
                    return;
                } else {
                    linkedList.remove(0);
                }
            }
        }

        public void backspace() {
            SpannableStringBuilder spannableStringBuilder = this.f5214b;
            int length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.delete(length - 1, length);
            }
        }

        public c6.b build() {
            Layout.Alignment alignment;
            float f10;
            float f11;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i10 = 0;
            while (true) {
                LinkedList linkedList = this.f5213a;
                if (i10 >= linkedList.size()) {
                    break;
                }
                spannableStringBuilder.append((CharSequence) linkedList.get(i10));
                spannableStringBuilder.append('\n');
                i10++;
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            int i11 = this.f5224l;
            if (i11 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i11 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f5224l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f5218f) {
                f10 = this.f5220h / 99.0f;
                f11 = this.f5219g / 99.0f;
            } else {
                f10 = this.f5220h / 209.0f;
                f11 = this.f5219g / 74.0f;
            }
            float f12 = (f10 * 0.9f) + 0.05f;
            float f13 = (f11 * 0.9f) + 0.05f;
            int i12 = this.f5221i;
            int i13 = i12 % 3;
            int i14 = i13 == 0 ? 0 : i13 == 1 ? 1 : 2;
            int i15 = i12 / 3;
            int i16 = i15 == 0 ? 0 : i15 == 1 ? 1 : 2;
            int i17 = this.f5227o;
            return new c6.b(spannableStringBuilder, alignment2, f13, 0, i14, f12, i16, Float.MIN_VALUE, i17 != f5210x, i17, this.f5217e);
        }

        public SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f5214b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f5228p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f5228p, length, 33);
                }
                if (this.f5229q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f5229q, length, 33);
                }
                if (this.f5230r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5231s), this.f5230r, length, 33);
                }
                if (this.f5232t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f5233u), this.f5232t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void clear() {
            this.f5213a.clear();
            this.f5214b.clear();
            this.f5228p = -1;
            this.f5229q = -1;
            this.f5230r = -1;
            this.f5232t = -1;
            this.f5234v = 0;
        }

        public void defineWindow(boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f5215c = true;
            this.f5216d = z10;
            this.f5223k = z11;
            this.f5217e = i10;
            this.f5218f = z13;
            this.f5219g = i11;
            this.f5220h = i12;
            this.f5221i = i15;
            int i18 = i13 + 1;
            if (this.f5222j != i18) {
                this.f5222j = i18;
                while (true) {
                    LinkedList linkedList = this.f5213a;
                    if ((!z11 || linkedList.size() < this.f5222j) && linkedList.size() < 15) {
                        break;
                    } else {
                        linkedList.remove(0);
                    }
                }
            }
            if (i16 != 0 && this.f5225m != i16) {
                this.f5225m = i16;
                int i19 = i16 - 1;
                setWindowAttributes(D[i19], f5211y, C[i19], 0, A[i19], B[i19], f5212z[i19]);
            }
            if (i17 == 0 || this.f5226n == i17) {
                return;
            }
            this.f5226n = i17;
            int i20 = i17 - 1;
            setPenAttributes(0, 1, 1, false, false, F[i20], E[i20]);
            setPenColor(f5209w, G[i20], f5210x);
        }

        public boolean isDefined() {
            return this.f5215c;
        }

        public boolean isEmpty() {
            return !isDefined() || (this.f5213a.isEmpty() && this.f5214b.length() == 0);
        }

        public boolean isVisible() {
            return this.f5216d;
        }

        public void reset() {
            clear();
            this.f5215c = false;
            this.f5216d = false;
            this.f5217e = 4;
            this.f5218f = false;
            this.f5219g = 0;
            this.f5220h = 0;
            this.f5221i = 0;
            this.f5222j = 15;
            this.f5223k = true;
            this.f5224l = 0;
            this.f5225m = 0;
            this.f5226n = 0;
            int i10 = f5210x;
            this.f5227o = i10;
            this.f5231s = f5209w;
            this.f5233u = i10;
        }

        public void setPenAttributes(int i10, int i11, int i12, boolean z10, boolean z11, int i13, int i14) {
            int i15 = this.f5228p;
            SpannableStringBuilder spannableStringBuilder = this.f5214b;
            if (i15 != -1) {
                if (!z10) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f5228p, spannableStringBuilder.length(), 33);
                    this.f5228p = -1;
                }
            } else if (z10) {
                this.f5228p = spannableStringBuilder.length();
            }
            if (this.f5229q == -1) {
                if (z11) {
                    this.f5229q = spannableStringBuilder.length();
                }
            } else {
                if (z11) {
                    return;
                }
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f5229q, spannableStringBuilder.length(), 33);
                this.f5229q = -1;
            }
        }

        public void setPenColor(int i10, int i11, int i12) {
            int i13 = this.f5230r;
            SpannableStringBuilder spannableStringBuilder = this.f5214b;
            if (i13 != -1 && this.f5231s != i10) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5231s), this.f5230r, spannableStringBuilder.length(), 33);
            }
            if (i10 != f5209w) {
                this.f5230r = spannableStringBuilder.length();
                this.f5231s = i10;
            }
            if (this.f5232t != -1 && this.f5233u != i11) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f5233u), this.f5232t, spannableStringBuilder.length(), 33);
            }
            if (i11 != f5210x) {
                this.f5232t = spannableStringBuilder.length();
                this.f5233u = i11;
            }
        }

        public void setPenLocation(int i10, int i11) {
            if (this.f5234v != i10) {
                append('\n');
            }
            this.f5234v = i10;
        }

        public void setVisibility(boolean z10) {
            this.f5216d = z10;
        }

        public void setWindowAttributes(int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
            this.f5227o = i10;
            this.f5224l = i15;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getArgbColorFromCeaColor(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                l6.a.checkIndex(r4, r0, r1)
                l6.a.checkIndex(r5, r0, r1)
                l6.a.checkIndex(r6, r0, r1)
                l6.a.checkIndex(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L21
                if (r7 == r1) goto L21
                r3 = 2
                if (r7 == r3) goto L1e
                r3 = 3
                if (r7 == r3) goto L1c
                goto L21
            L1c:
                r7 = 0
                goto L23
            L1e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L23
            L21:
                r7 = 255(0xff, float:3.57E-43)
            L23:
                if (r4 <= r1) goto L28
                r4 = 255(0xff, float:3.57E-43)
                goto L29
            L28:
                r4 = 0
            L29:
                if (r5 <= r1) goto L2e
                r5 = 255(0xff, float:3.57E-43)
                goto L2f
            L2e:
                r5 = 0
            L2f:
                if (r6 <= r1) goto L33
                r0 = 255(0xff, float:3.57E-43)
            L33:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: c6.c.a.getArgbColorFromCeaColor(int, int, int, int):int");
        }
    }

    /* compiled from: Cea708Decoder.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5235a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5236b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f5237c;

        /* renamed from: d, reason: collision with root package name */
        public int f5238d = 0;

        public b(int i10, int i11) {
            this.f5235a = i10;
            this.f5236b = i11;
            this.f5237c = new byte[(i11 * 2) - 1];
        }
    }

    public c(int i10) {
        this.f5202h = i10 == -1 ? 1 : i10;
        this.f5203i = new a[8];
        for (int i11 = 0; i11 < 8; i11++) {
            this.f5203i[i11] = new a();
        }
        this.f5204j = this.f5203i[0];
        c();
    }

    public final void a() {
        b bVar = this.f5207m;
        if (bVar == null) {
            return;
        }
        int i10 = bVar.f5238d;
        if (i10 != (bVar.f5236b * 2) - 1) {
            StringBuilder sb2 = new StringBuilder("DtvCcPacket ended prematurely; size is ");
            sb2.append((this.f5207m.f5236b * 2) - 1);
            sb2.append(", but current index is ");
            sb2.append(this.f5207m.f5238d);
            sb2.append(" (sequence number ");
            sb2.append(this.f5207m.f5235a);
            sb2.append("); ignoring packet");
            Log.w("Cea708Decoder", sb2.toString());
        } else {
            k kVar = this.f5201g;
            kVar.reset(bVar.f5237c, i10);
            int i11 = 3;
            int bits = kVar.readBits(3);
            int bits2 = kVar.readBits(5);
            if (bits == 7) {
                kVar.skipBits(2);
                bits += kVar.readBits(6);
            }
            if (bits2 == 0) {
                if (bits != 0) {
                    Log.w("Cea708Decoder", "serviceNumber is non-zero (" + bits + ") when blockSize is 0");
                }
            } else if (bits == this.f5202h) {
                boolean z10 = false;
                while (kVar.bitsLeft() > 0) {
                    int bits3 = kVar.readBits(8);
                    if (bits3 == 16) {
                        int bits4 = kVar.readBits(8);
                        if (bits4 > 31) {
                            if (bits4 <= 127) {
                                if (bits4 == 32) {
                                    this.f5204j.append(TokenParser.SP);
                                } else if (bits4 == 33) {
                                    this.f5204j.append((char) 160);
                                } else if (bits4 == 37) {
                                    this.f5204j.append((char) 8230);
                                } else if (bits4 == 42) {
                                    this.f5204j.append((char) 352);
                                } else if (bits4 == 44) {
                                    this.f5204j.append((char) 338);
                                } else if (bits4 == 63) {
                                    this.f5204j.append((char) 376);
                                } else if (bits4 == 57) {
                                    this.f5204j.append((char) 8482);
                                } else if (bits4 == 58) {
                                    this.f5204j.append((char) 353);
                                } else if (bits4 == 60) {
                                    this.f5204j.append((char) 339);
                                } else if (bits4 != 61) {
                                    switch (bits4) {
                                        case 48:
                                            this.f5204j.append((char) 9608);
                                            break;
                                        case 49:
                                            this.f5204j.append((char) 8216);
                                            break;
                                        case 50:
                                            this.f5204j.append((char) 8217);
                                            break;
                                        case 51:
                                            this.f5204j.append((char) 8220);
                                            break;
                                        case 52:
                                            this.f5204j.append((char) 8221);
                                            break;
                                        case 53:
                                            this.f5204j.append((char) 8226);
                                            break;
                                        default:
                                            switch (bits4) {
                                                case 118:
                                                    this.f5204j.append((char) 8539);
                                                    break;
                                                case 119:
                                                    this.f5204j.append((char) 8540);
                                                    break;
                                                case 120:
                                                    this.f5204j.append((char) 8541);
                                                    break;
                                                case 121:
                                                    this.f5204j.append((char) 8542);
                                                    break;
                                                case 122:
                                                    this.f5204j.append((char) 9474);
                                                    break;
                                                case 123:
                                                    this.f5204j.append((char) 9488);
                                                    break;
                                                case 124:
                                                    this.f5204j.append((char) 9492);
                                                    break;
                                                case 125:
                                                    this.f5204j.append((char) 9472);
                                                    break;
                                                case 126:
                                                    this.f5204j.append((char) 9496);
                                                    break;
                                                case 127:
                                                    this.f5204j.append((char) 9484);
                                                    break;
                                                default:
                                                    o1.a.o("Invalid G2 character: ", bits4, "Cea708Decoder");
                                                    break;
                                            }
                                    }
                                } else {
                                    this.f5204j.append((char) 8480);
                                }
                            } else if (bits4 <= 159) {
                                if (bits4 <= 135) {
                                    kVar.skipBits(32);
                                } else if (bits4 <= 143) {
                                    kVar.skipBits(40);
                                } else if (bits4 <= 159) {
                                    kVar.skipBits(2);
                                    kVar.skipBits(kVar.readBits(6) * 8);
                                }
                            } else if (bits4 > 255) {
                                o1.a.o("Invalid extended command: ", bits4, "Cea708Decoder");
                            } else if (bits4 == 160) {
                                this.f5204j.append((char) 13252);
                            } else {
                                o1.a.o("Invalid G3 character: ", bits4, "Cea708Decoder");
                                this.f5204j.append('_');
                            }
                            z10 = true;
                        } else if (bits4 > 7) {
                            if (bits4 <= 15) {
                                kVar.skipBits(8);
                            } else if (bits4 <= 23) {
                                kVar.skipBits(16);
                            } else if (bits4 <= 31) {
                                kVar.skipBits(24);
                            }
                        }
                    } else if (bits3 > 31) {
                        if (bits3 <= 127) {
                            if (bits3 == 127) {
                                this.f5204j.append((char) 9835);
                            } else {
                                this.f5204j.append((char) (bits3 & 255));
                            }
                        } else if (bits3 <= 159) {
                            a[] aVarArr = this.f5203i;
                            switch (bits3) {
                                case 128:
                                case 129:
                                case 130:
                                case 131:
                                case 132:
                                case 133:
                                case 134:
                                case 135:
                                    int i12 = bits3 - 128;
                                    if (this.f5208n != i12) {
                                        this.f5208n = i12;
                                        this.f5204j = aVarArr[i12];
                                        break;
                                    }
                                    break;
                                case 136:
                                    for (int i13 = 1; i13 <= 8; i13++) {
                                        if (kVar.readBit()) {
                                            aVarArr[8 - i13].clear();
                                        }
                                    }
                                    break;
                                case 137:
                                    for (int i14 = 1; i14 <= 8; i14++) {
                                        if (kVar.readBit()) {
                                            aVarArr[8 - i14].setVisibility(true);
                                        }
                                    }
                                    break;
                                case 138:
                                    for (int i15 = 1; i15 <= 8; i15++) {
                                        if (kVar.readBit()) {
                                            aVarArr[8 - i15].setVisibility(false);
                                        }
                                    }
                                    break;
                                case 139:
                                    for (int i16 = 1; i16 <= 8; i16++) {
                                        if (kVar.readBit()) {
                                            aVarArr[8 - i16].setVisibility(!r2.isVisible());
                                        }
                                    }
                                    break;
                                case 140:
                                    for (int i17 = 1; i17 <= 8; i17++) {
                                        if (kVar.readBit()) {
                                            aVarArr[8 - i17].reset();
                                        }
                                    }
                                    break;
                                case 141:
                                    kVar.skipBits(8);
                                    break;
                                case 142:
                                    break;
                                case 143:
                                    c();
                                    break;
                                case 144:
                                    if (this.f5204j.isDefined()) {
                                        this.f5204j.setPenAttributes(kVar.readBits(4), kVar.readBits(2), kVar.readBits(2), kVar.readBit(), kVar.readBit(), kVar.readBits(i11), kVar.readBits(i11));
                                        break;
                                    } else {
                                        kVar.skipBits(16);
                                        break;
                                    }
                                case 145:
                                    if (this.f5204j.isDefined()) {
                                        int argbColorFromCeaColor = a.getArgbColorFromCeaColor(kVar.readBits(2), kVar.readBits(2), kVar.readBits(2), kVar.readBits(2));
                                        int argbColorFromCeaColor2 = a.getArgbColorFromCeaColor(kVar.readBits(2), kVar.readBits(2), kVar.readBits(2), kVar.readBits(2));
                                        kVar.skipBits(2);
                                        this.f5204j.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, a.getArgbColorFromCeaColor(kVar.readBits(2), kVar.readBits(2), kVar.readBits(2)));
                                        break;
                                    } else {
                                        kVar.skipBits(24);
                                        break;
                                    }
                                case 146:
                                    if (this.f5204j.isDefined()) {
                                        kVar.skipBits(4);
                                        int bits5 = kVar.readBits(4);
                                        kVar.skipBits(2);
                                        this.f5204j.setPenLocation(bits5, kVar.readBits(6));
                                        break;
                                    } else {
                                        kVar.skipBits(16);
                                        break;
                                    }
                                case 147:
                                case 148:
                                case 149:
                                case 150:
                                default:
                                    o1.a.o("Invalid C1 command: ", bits3, "Cea708Decoder");
                                    break;
                                case 151:
                                    if (this.f5204j.isDefined()) {
                                        int argbColorFromCeaColor3 = a.getArgbColorFromCeaColor(kVar.readBits(2), kVar.readBits(2), kVar.readBits(2), kVar.readBits(2));
                                        int bits6 = kVar.readBits(2);
                                        int argbColorFromCeaColor4 = a.getArgbColorFromCeaColor(kVar.readBits(2), kVar.readBits(2), kVar.readBits(2));
                                        if (kVar.readBit()) {
                                            bits6 |= 4;
                                        }
                                        boolean bit = kVar.readBit();
                                        int bits7 = kVar.readBits(2);
                                        int bits8 = kVar.readBits(2);
                                        int bits9 = kVar.readBits(2);
                                        kVar.skipBits(8);
                                        this.f5204j.setWindowAttributes(argbColorFromCeaColor3, argbColorFromCeaColor4, bit, bits6, bits7, bits8, bits9);
                                        break;
                                    } else {
                                        kVar.skipBits(32);
                                        break;
                                    }
                                case 152:
                                case 153:
                                case 154:
                                case 155:
                                case 156:
                                case 157:
                                case 158:
                                case 159:
                                    int i18 = bits3 - 152;
                                    a aVar = aVarArr[i18];
                                    kVar.skipBits(2);
                                    boolean bit2 = kVar.readBit();
                                    boolean bit3 = kVar.readBit();
                                    boolean bit4 = kVar.readBit();
                                    int bits10 = kVar.readBits(i11);
                                    boolean bit5 = kVar.readBit();
                                    int bits11 = kVar.readBits(7);
                                    int bits12 = kVar.readBits(8);
                                    int bits13 = kVar.readBits(4);
                                    int bits14 = kVar.readBits(4);
                                    kVar.skipBits(2);
                                    int bits15 = kVar.readBits(6);
                                    kVar.skipBits(2);
                                    aVar.defineWindow(bit2, bit3, bit4, bits10, bit5, bits11, bits12, bits14, bits15, bits13, kVar.readBits(i11), kVar.readBits(i11));
                                    if (this.f5208n != i18) {
                                        this.f5208n = i18;
                                        this.f5204j = aVarArr[i18];
                                        break;
                                    }
                                    break;
                            }
                        } else if (bits3 <= 255) {
                            this.f5204j.append((char) (bits3 & 255));
                        } else {
                            o1.a.o("Invalid base command: ", bits3, "Cea708Decoder");
                        }
                        z10 = true;
                    } else if (bits3 != 0) {
                        if (bits3 == i11) {
                            this.f5205k = b();
                        } else if (bits3 != 8) {
                            switch (bits3) {
                                case 12:
                                    c();
                                    break;
                                case 13:
                                    this.f5204j.append('\n');
                                    break;
                                case 14:
                                    break;
                                default:
                                    if (bits3 < 17 || bits3 > 23) {
                                        if (bits3 < 24 || bits3 > 31) {
                                            o1.a.o("Invalid C0 command: ", bits3, "Cea708Decoder");
                                            break;
                                        } else {
                                            Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + bits3);
                                            kVar.skipBits(16);
                                            break;
                                        }
                                    } else {
                                        Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + bits3);
                                        kVar.skipBits(8);
                                        break;
                                    }
                            }
                        } else {
                            this.f5204j.backspace();
                        }
                    }
                    i11 = 3;
                }
                if (z10) {
                    this.f5205k = b();
                }
            }
        }
        this.f5207m = null;
    }

    public final List<b6.a> b() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 8; i10++) {
            a[] aVarArr = this.f5203i;
            if (!aVarArr[i10].isEmpty() && aVarArr[i10].isVisible()) {
                arrayList.add(aVarArr[i10].build());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    public final void c() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f5203i[i10].reset();
        }
    }

    @Override // c6.d
    public b6.d createSubtitle() {
        List<b6.a> list = this.f5205k;
        this.f5206l = list;
        return new f(list);
    }

    @Override // c6.d
    public void decode(b6.g gVar) {
        byte[] bArrArray = gVar.f11142n.array();
        int iLimit = gVar.f11142n.limit();
        l lVar = this.f5200f;
        lVar.reset(bArrArray, iLimit);
        while (lVar.bytesLeft() >= 3) {
            int unsignedByte = lVar.readUnsignedByte() & 7;
            int i10 = unsignedByte & 3;
            boolean z10 = (unsignedByte & 4) == 4;
            byte unsignedByte2 = (byte) lVar.readUnsignedByte();
            byte unsignedByte3 = (byte) lVar.readUnsignedByte();
            if (i10 == 2 || i10 == 3) {
                if (z10) {
                    if (i10 == 3) {
                        a();
                        int i11 = (unsignedByte2 & 192) >> 6;
                        int i12 = unsignedByte2 & 63;
                        if (i12 == 0) {
                            i12 = 64;
                        }
                        b bVar = new b(i11, i12);
                        this.f5207m = bVar;
                        int i13 = bVar.f5238d;
                        bVar.f5238d = i13 + 1;
                        bVar.f5237c[i13] = unsignedByte3;
                    } else {
                        l6.a.checkArgument(i10 == 2);
                        b bVar2 = this.f5207m;
                        if (bVar2 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr = bVar2.f5237c;
                            int i14 = bVar2.f5238d;
                            int i15 = i14 + 1;
                            bArr[i14] = unsignedByte2;
                            bVar2.f5238d = i15 + 1;
                            bArr[i15] = unsignedByte3;
                        }
                    }
                    b bVar3 = this.f5207m;
                    if (bVar3.f5238d == (bVar3.f5236b * 2) - 1) {
                        a();
                    }
                }
            }
        }
    }

    @Override // c6.d, e5.c
    public /* bridge */ /* synthetic */ b6.g dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // c6.d, e5.c
    public /* bridge */ /* synthetic */ h dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // c6.d, e5.c
    public void flush() {
        super.flush();
        this.f5205k = null;
        this.f5206l = null;
        this.f5208n = 0;
        this.f5204j = this.f5203i[0];
        c();
        this.f5207m = null;
    }

    @Override // c6.d
    public boolean isNewSubtitleDataAvailable() {
        return this.f5205k != this.f5206l;
    }

    @Override // c6.d
    public /* bridge */ /* synthetic */ void queueInputBuffer(b6.g gVar) throws SubtitleDecoderException {
        super.queueInputBuffer(gVar);
    }

    @Override // c6.d, e5.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // c6.d, b6.e
    public /* bridge */ /* synthetic */ void setPositionUs(long j10) {
        super.setPositionUs(j10);
    }
}
