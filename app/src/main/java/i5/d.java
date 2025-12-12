package i5;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.c;
import com.unity3d.services.core.device.MimeTypes;
import g5.l;
import g5.m;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import l6.g;
import l6.j;
import l6.l;
import l6.u;

/* compiled from: MatroskaExtractor.java */
/* loaded from: classes.dex */
public final class d implements g5.e {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: a0, reason: collision with root package name */
    public static final byte[] f13147a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

    /* renamed from: b0, reason: collision with root package name */
    public static final byte[] f13148b0 = u.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: c0, reason: collision with root package name */
    public static final byte[] f13149c0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: d0, reason: collision with root package name */
    public static final long f13150d0 = 10000;

    /* renamed from: e0, reason: collision with root package name */
    public static final byte[] f13151e0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

    /* renamed from: f0, reason: collision with root package name */
    public static final UUID f13152f0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A;
    public g B;
    public g C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public g5.g Y;

    /* renamed from: a, reason: collision with root package name */
    public final i5.b f13153a;

    /* renamed from: b, reason: collision with root package name */
    public final f f13154b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray<b> f13155c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13156d;

    /* renamed from: e, reason: collision with root package name */
    public final l f13157e;

    /* renamed from: f, reason: collision with root package name */
    public final l f13158f;

    /* renamed from: g, reason: collision with root package name */
    public final l f13159g;

    /* renamed from: h, reason: collision with root package name */
    public final l f13160h;

    /* renamed from: i, reason: collision with root package name */
    public final l f13161i;

    /* renamed from: j, reason: collision with root package name */
    public final l f13162j;

    /* renamed from: k, reason: collision with root package name */
    public final l f13163k;

    /* renamed from: l, reason: collision with root package name */
    public final l f13164l;

    /* renamed from: m, reason: collision with root package name */
    public final l f13165m;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f13166n;

    /* renamed from: o, reason: collision with root package name */
    public long f13167o;

    /* renamed from: p, reason: collision with root package name */
    public long f13168p;

    /* renamed from: q, reason: collision with root package name */
    public long f13169q;

    /* renamed from: r, reason: collision with root package name */
    public long f13170r;

    /* renamed from: s, reason: collision with root package name */
    public long f13171s;

    /* renamed from: t, reason: collision with root package name */
    public b f13172t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13173u;

    /* renamed from: v, reason: collision with root package name */
    public int f13174v;

    /* renamed from: w, reason: collision with root package name */
    public long f13175w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13176x;

    /* renamed from: y, reason: collision with root package name */
    public long f13177y;

    /* renamed from: z, reason: collision with root package name */
    public long f13178z;

    /* compiled from: MatroskaExtractor.java */
    public final class a implements c {
        public a() {
        }

        public void binaryElement(int i10, int i11, g5.f fVar) throws InterruptedException, IOException {
            long j10;
            int i12;
            int i13;
            int i14;
            d dVar = d.this;
            dVar.getClass();
            int i15 = 1;
            int i16 = 0;
            if (i10 != 161 && i10 != 163) {
                if (i10 == 16981) {
                    b bVar = dVar.f13172t;
                    byte[] bArr = new byte[i11];
                    bVar.f13185f = bArr;
                    ((g5.b) fVar).readFully(bArr, 0, i11);
                    return;
                }
                if (i10 == 18402) {
                    byte[] bArr2 = new byte[i11];
                    ((g5.b) fVar).readFully(bArr2, 0, i11);
                    dVar.f13172t.f13186g = new m.a(1, bArr2, 0, 0);
                    return;
                }
                if (i10 == 21419) {
                    l lVar = dVar.f13161i;
                    Arrays.fill(lVar.f15881a, (byte) 0);
                    ((g5.b) fVar).readFully(lVar.f15881a, 4 - i11, i11);
                    lVar.setPosition(0);
                    dVar.f13174v = (int) lVar.readUnsignedInt();
                    return;
                }
                if (i10 == 25506) {
                    b bVar2 = dVar.f13172t;
                    byte[] bArr3 = new byte[i11];
                    bVar2.f13187h = bArr3;
                    ((g5.b) fVar).readFully(bArr3, 0, i11);
                    return;
                }
                if (i10 != 30322) {
                    throw new ParserException(ac.c.f("Unexpected id: ", i10));
                }
                b bVar3 = dVar.f13172t;
                byte[] bArr4 = new byte[i11];
                bVar3.f13194o = bArr4;
                ((g5.b) fVar).readFully(bArr4, 0, i11);
                return;
            }
            int i17 = dVar.E;
            l lVar2 = dVar.f13159g;
            if (i17 == 0) {
                f fVar2 = dVar.f13154b;
                dVar.K = (int) fVar2.readUnsignedVarint(fVar, false, true, 8);
                dVar.L = fVar2.getLastLength();
                dVar.G = -9223372036854775807L;
                dVar.E = 1;
                lVar2.reset();
            }
            b bVar4 = dVar.f13155c.get(dVar.K);
            if (bVar4 == null) {
                ((g5.b) fVar).skipFully(i11 - dVar.L);
                dVar.E = 0;
                return;
            }
            if (dVar.E == 1) {
                dVar.c(fVar, 3);
                int i18 = (lVar2.f15881a[2] & 6) >> 1;
                byte b10 = 255;
                if (i18 == 0) {
                    dVar.I = 1;
                    int[] iArr = dVar.J;
                    if (iArr == null) {
                        iArr = new int[1];
                    } else if (iArr.length < 1) {
                        iArr = new int[Math.max(iArr.length * 2, 1)];
                    }
                    dVar.J = iArr;
                    iArr[0] = (i11 - dVar.L) - 3;
                } else {
                    if (i10 != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    }
                    int i19 = 4;
                    dVar.c(fVar, 4);
                    int i20 = (lVar2.f15881a[3] & 255) + 1;
                    dVar.I = i20;
                    int[] iArr2 = dVar.J;
                    if (iArr2 == null) {
                        iArr2 = new int[i20];
                    } else if (iArr2.length < i20) {
                        iArr2 = new int[Math.max(iArr2.length * 2, i20)];
                    }
                    dVar.J = iArr2;
                    if (i18 == 2) {
                        int i21 = (i11 - dVar.L) - 4;
                        int i22 = dVar.I;
                        Arrays.fill(iArr2, 0, i22, i21 / i22);
                    } else {
                        if (i18 != 1) {
                            if (i18 != 3) {
                                throw new ParserException(ac.c.f("Unexpected lacing value: ", i18));
                            }
                            int i23 = 0;
                            int i24 = 0;
                            while (true) {
                                int i25 = dVar.I;
                                if (i23 >= i25 - 1) {
                                    dVar.J[i25 - 1] = ((i11 - dVar.L) - i19) - i24;
                                    i15 = 1;
                                    break;
                                }
                                dVar.J[i23] = i16;
                                i19++;
                                dVar.c(fVar, i19);
                                int i26 = i19 - 1;
                                if (lVar2.f15881a[i26] == 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                int i27 = 0;
                                while (true) {
                                    if (i27 >= 8) {
                                        j10 = 0;
                                        break;
                                    }
                                    int i28 = i15 << (7 - i27);
                                    if ((lVar2.f15881a[i26] & i28) != 0) {
                                        int i29 = i19 + i27;
                                        dVar.c(fVar, i29);
                                        int i30 = i26 + 1;
                                        j10 = (~i28) & lVar2.f15881a[i26] & b10;
                                        while (i30 < i29) {
                                            int i31 = lVar2.f15881a[i30] & 255;
                                            i30++;
                                            j10 = i31 | (j10 << 8);
                                            i29 = i29;
                                        }
                                        int i32 = i29;
                                        if (i23 > 0) {
                                            j10 -= (1 << ((i27 * 7) + 6)) - 1;
                                        }
                                        i19 = i32;
                                    } else {
                                        i27++;
                                        i15 = 1;
                                        b10 = 255;
                                    }
                                }
                                if (j10 < -2147483648L || j10 > 2147483647L) {
                                    break;
                                }
                                int i33 = (int) j10;
                                int[] iArr3 = dVar.J;
                                if (i23 != 0) {
                                    i33 += iArr3[i23 - 1];
                                }
                                iArr3[i23] = i33;
                                i24 += i33;
                                i23++;
                                i15 = 1;
                                i16 = 0;
                                b10 = 255;
                            }
                            throw new ParserException("EBML lacing sample size out of range.");
                        }
                        int i34 = 0;
                        int i35 = 0;
                        while (true) {
                            i12 = dVar.I;
                            if (i34 >= i12 - 1) {
                                break;
                            }
                            dVar.J[i34] = 0;
                            do {
                                i19++;
                                dVar.c(fVar, i19);
                                i13 = lVar2.f15881a[i19 - 1] & 255;
                                int[] iArr4 = dVar.J;
                                i14 = iArr4[i34] + i13;
                                iArr4[i34] = i14;
                            } while (i13 == 255);
                            i35 += i14;
                            i34++;
                        }
                        dVar.J[i12 - 1] = ((i11 - dVar.L) - i19) - i35;
                    }
                }
                byte[] bArr5 = lVar2.f15881a;
                dVar.F = dVar.e((bArr5[i15] & 255) | (bArr5[0] << 8)) + dVar.A;
                byte b11 = lVar2.f15881a[2];
                dVar.M = ((bVar4.f13182c == 2 || (i10 == 163 && (b11 & 128) == 128)) ? 1 : 0) | ((b11 & 8) == 8 ? Integer.MIN_VALUE : 0);
                dVar.E = 2;
                dVar.H = 0;
            }
            if (i10 != 163) {
                dVar.f(fVar, bVar4, dVar.J[0]);
                return;
            }
            while (true) {
                int i36 = dVar.H;
                if (i36 >= dVar.I) {
                    dVar.E = 0;
                    return;
                } else {
                    dVar.f(fVar, bVar4, dVar.J[i36]);
                    dVar.a(bVar4, dVar.F + ((dVar.H * bVar4.f13183d) / 1000));
                    dVar.H++;
                }
            }
        }

        public void endMasterElement(int i10) throws ParserException {
            g5.l aVar;
            g gVar;
            g gVar2;
            int i11;
            d dVar = d.this;
            SparseArray<b> sparseArray = dVar.f13155c;
            if (i10 == 160) {
                if (dVar.E != 2) {
                    return;
                }
                if (!dVar.X) {
                    dVar.M |= 1;
                }
                dVar.a(sparseArray.get(dVar.K), dVar.F);
                dVar.E = 0;
                return;
            }
            if (i10 == 174) {
                String str = dVar.f13172t.f13180a;
                if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                    b bVar = dVar.f13172t;
                    bVar.initializeOutput(dVar.Y, bVar.f13181b);
                    b bVar2 = dVar.f13172t;
                    sparseArray.put(bVar2.f13181b, bVar2);
                }
                dVar.f13172t = null;
                return;
            }
            if (i10 == 19899) {
                int i12 = dVar.f13174v;
                if (i12 != -1) {
                    long j10 = dVar.f13175w;
                    if (j10 != -1) {
                        if (i12 == 475249515) {
                            dVar.f13177y = j10;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            }
            if (i10 == 25152) {
                b bVar3 = dVar.f13172t;
                if (bVar3.f13184e) {
                    m.a aVar2 = bVar3.f13186g;
                    if (aVar2 == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    bVar3.f13188i = new com.google.android.exoplayer2.drm.c(new c.b(c5.b.f5032b, null, MimeTypes.VIDEO_WEBM, aVar2.f12729b));
                    return;
                }
                return;
            }
            if (i10 == 28032) {
                b bVar4 = dVar.f13172t;
                if (bVar4.f13184e && bVar4.f13185f != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            }
            if (i10 == 357149030) {
                if (dVar.f13169q == -9223372036854775807L) {
                    dVar.f13169q = 1000000L;
                }
                long j11 = dVar.f13170r;
                if (j11 != -9223372036854775807L) {
                    dVar.f13171s = dVar.e(j11);
                    return;
                }
                return;
            }
            if (i10 == 374648427) {
                if (sparseArray.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                dVar.Y.endTracks();
                return;
            }
            if (i10 == 475249515 && !dVar.f13173u) {
                g5.g gVar3 = dVar.Y;
                if (dVar.f13168p == -1 || dVar.f13171s == -9223372036854775807L || (gVar = dVar.B) == null || gVar.size() == 0 || (gVar2 = dVar.C) == null || gVar2.size() != dVar.B.size()) {
                    dVar.B = null;
                    dVar.C = null;
                    aVar = new l.a(dVar.f13171s);
                } else {
                    int size = dVar.B.size();
                    int[] iArr = new int[size];
                    long[] jArr = new long[size];
                    long[] jArr2 = new long[size];
                    long[] jArr3 = new long[size];
                    for (int i13 = 0; i13 < size; i13++) {
                        jArr3[i13] = dVar.B.get(i13);
                        jArr[i13] = dVar.C.get(i13) + dVar.f13168p;
                    }
                    while (true) {
                        i11 = size - 1;
                        if (i >= i11) {
                            break;
                        }
                        int i14 = i + 1;
                        iArr[i] = (int) (jArr[i14] - jArr[i]);
                        jArr2[i] = jArr3[i14] - jArr3[i];
                        i = i14;
                    }
                    iArr[i11] = (int) ((dVar.f13168p + dVar.f13167o) - jArr[i11]);
                    jArr2[i11] = dVar.f13171s - jArr3[i11];
                    dVar.B = null;
                    dVar.C = null;
                    aVar = new g5.a(iArr, jArr, jArr2, jArr3);
                }
                gVar3.seekMap(aVar);
                dVar.f13173u = true;
            }
        }

        public void floatElement(int i10, double d10) throws ParserException {
            d dVar = d.this;
            if (i10 == 181) {
                dVar.f13172t.I = (int) d10;
            }
            if (i10 == 17545) {
                dVar.f13170r = (long) d10;
                return;
            }
            switch (i10) {
                case 21969:
                    dVar.f13172t.f13202w = (float) d10;
                    break;
                case 21970:
                    dVar.f13172t.f13203x = (float) d10;
                    break;
                case 21971:
                    dVar.f13172t.f13204y = (float) d10;
                    break;
                case 21972:
                    dVar.f13172t.f13205z = (float) d10;
                    break;
                case 21973:
                    dVar.f13172t.A = (float) d10;
                    break;
                case 21974:
                    dVar.f13172t.B = (float) d10;
                    break;
                case 21975:
                    dVar.f13172t.C = (float) d10;
                    break;
                case 21976:
                    dVar.f13172t.D = (float) d10;
                    break;
                case 21977:
                    dVar.f13172t.E = (float) d10;
                    break;
                case 21978:
                    dVar.f13172t.F = (float) d10;
                    break;
                default:
                    dVar.getClass();
                    break;
            }
        }

        public int getElementType(int i10) {
            d.this.getClass();
            switch (i10) {
                case 131:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 241:
                case 251:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 22186:
                case 22203:
                case 25188:
                case 2352003:
                case 2807729:
                    return 2;
                case 134:
                case 17026:
                case 2274716:
                    return 3;
                case 160:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    return 1;
                case 161:
                case 163:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    return 4;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                    return 5;
                default:
                    return 0;
            }
        }

        public void integerElement(int i10, long j10) throws ParserException {
            d dVar = d.this;
            dVar.getClass();
            if (i10 == 20529) {
                if (j10 == 0) {
                    return;
                }
                throw new ParserException("ContentEncodingOrder " + j10 + " not supported");
            }
            if (i10 == 20530) {
                if (j10 == 1) {
                    return;
                }
                throw new ParserException("ContentEncodingScope " + j10 + " not supported");
            }
            switch (i10) {
                case 131:
                    dVar.f13172t.f13182c = (int) j10;
                    return;
                case 136:
                    dVar.f13172t.L = j10 == 1;
                    return;
                case 155:
                    dVar.G = dVar.e(j10);
                    return;
                case 159:
                    dVar.f13172t.G = (int) j10;
                    return;
                case 176:
                    dVar.f13172t.f13189j = (int) j10;
                    return;
                case 179:
                    dVar.B.add(dVar.e(j10));
                    return;
                case 186:
                    dVar.f13172t.f13190k = (int) j10;
                    return;
                case 215:
                    dVar.f13172t.f13181b = (int) j10;
                    return;
                case 231:
                    dVar.A = dVar.e(j10);
                    return;
                case 241:
                    if (dVar.D) {
                        return;
                    }
                    dVar.C.add(j10);
                    dVar.D = true;
                    return;
                case 251:
                    dVar.X = true;
                    return;
                case 16980:
                    if (j10 == 3) {
                        return;
                    }
                    throw new ParserException("ContentCompAlgo " + j10 + " not supported");
                case 17029:
                    if (j10 < 1 || j10 > 2) {
                        throw new ParserException("DocTypeReadVersion " + j10 + " not supported");
                    }
                    return;
                case 17143:
                    if (j10 == 1) {
                        return;
                    }
                    throw new ParserException("EBMLReadVersion " + j10 + " not supported");
                case 18401:
                    if (j10 == 5) {
                        return;
                    }
                    throw new ParserException("ContentEncAlgo " + j10 + " not supported");
                case 18408:
                    if (j10 == 1) {
                        return;
                    }
                    throw new ParserException("AESSettingsCipherMode " + j10 + " not supported");
                case 21420:
                    dVar.f13175w = j10 + dVar.f13168p;
                    return;
                case 21432:
                    int i11 = (int) j10;
                    if (i11 == 0) {
                        dVar.f13172t.f13195p = 0;
                        return;
                    }
                    if (i11 == 1) {
                        dVar.f13172t.f13195p = 2;
                        return;
                    } else if (i11 == 3) {
                        dVar.f13172t.f13195p = 1;
                        return;
                    } else {
                        if (i11 != 15) {
                            return;
                        }
                        dVar.f13172t.f13195p = 3;
                        return;
                    }
                case 21680:
                    dVar.f13172t.f13191l = (int) j10;
                    return;
                case 21682:
                    dVar.f13172t.f13193n = (int) j10;
                    return;
                case 21690:
                    dVar.f13172t.f13192m = (int) j10;
                    return;
                case 21930:
                    dVar.f13172t.M = j10 == 1;
                    return;
                case 22186:
                    dVar.f13172t.J = j10;
                    return;
                case 22203:
                    dVar.f13172t.K = j10;
                    return;
                case 25188:
                    dVar.f13172t.H = (int) j10;
                    return;
                case 2352003:
                    dVar.f13172t.f13183d = (int) j10;
                    return;
                case 2807729:
                    dVar.f13169q = j10;
                    return;
                default:
                    switch (i10) {
                        case 21945:
                            int i12 = (int) j10;
                            if (i12 == 1) {
                                dVar.f13172t.f13199t = 2;
                                return;
                            } else {
                                if (i12 != 2) {
                                    return;
                                }
                                dVar.f13172t.f13199t = 1;
                                return;
                            }
                        case 21946:
                            int i13 = (int) j10;
                            if (i13 != 1) {
                                if (i13 == 16) {
                                    dVar.f13172t.f13198s = 6;
                                    return;
                                } else if (i13 == 18) {
                                    dVar.f13172t.f13198s = 7;
                                    return;
                                } else if (i13 != 6 && i13 != 7) {
                                    return;
                                }
                            }
                            dVar.f13172t.f13198s = 3;
                            return;
                        case 21947:
                            b bVar = dVar.f13172t;
                            bVar.f13196q = true;
                            int i14 = (int) j10;
                            if (i14 == 1) {
                                bVar.f13197r = 1;
                                return;
                            }
                            if (i14 == 9) {
                                bVar.f13197r = 6;
                                return;
                            } else {
                                if (i14 == 4 || i14 == 5 || i14 == 6 || i14 == 7) {
                                    bVar.f13197r = 2;
                                    return;
                                }
                                return;
                            }
                        case 21948:
                            dVar.f13172t.f13200u = (int) j10;
                            return;
                        case 21949:
                            dVar.f13172t.f13201v = (int) j10;
                            return;
                        default:
                            return;
                    }
            }
        }

        public boolean isLevel1Element(int i10) {
            d.this.getClass();
            return i10 == 357149030 || i10 == 524531317 || i10 == 475249515 || i10 == 374648427;
        }

        public void startMasterElement(int i10, long j10, long j11) throws ParserException {
            d dVar = d.this;
            dVar.getClass();
            if (i10 == 160) {
                dVar.X = false;
                return;
            }
            if (i10 == 174) {
                dVar.f13172t = new b();
                return;
            }
            if (i10 == 187) {
                dVar.D = false;
                return;
            }
            if (i10 == 19899) {
                dVar.f13174v = -1;
                dVar.f13175w = -1L;
                return;
            }
            if (i10 == 20533) {
                dVar.f13172t.f13184e = true;
                return;
            }
            if (i10 == 21968) {
                dVar.f13172t.f13196q = true;
                return;
            }
            if (i10 == 408125543) {
                long j12 = dVar.f13168p;
                if (j12 != -1 && j12 != j10) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                dVar.f13168p = j10;
                dVar.f13167o = j11;
                return;
            }
            if (i10 == 475249515) {
                dVar.B = new g();
                dVar.C = new g();
            } else if (i10 == 524531317 && !dVar.f13173u) {
                if (dVar.f13156d && dVar.f13177y != -1) {
                    dVar.f13176x = true;
                } else {
                    dVar.Y.seekMap(new l.a(dVar.f13171s));
                    dVar.f13173u = true;
                }
            }
        }

        public void stringElement(int i10, String str) throws ParserException {
            d dVar = d.this;
            dVar.getClass();
            if (i10 == 134) {
                dVar.f13172t.f13180a = str;
                return;
            }
            if (i10 != 17026) {
                if (i10 != 2274716) {
                    return;
                }
                dVar.f13172t.N = str;
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw new ParserException(ac.c.k("DocType ", str, " not supported"));
            }
        }
    }

    /* compiled from: MatroskaExtractor.java */
    public static final class b {
        public boolean L;
        public m O;
        public int P;

        /* renamed from: a, reason: collision with root package name */
        public String f13180a;

        /* renamed from: b, reason: collision with root package name */
        public int f13181b;

        /* renamed from: c, reason: collision with root package name */
        public int f13182c;

        /* renamed from: d, reason: collision with root package name */
        public int f13183d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f13184e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f13185f;

        /* renamed from: g, reason: collision with root package name */
        public m.a f13186g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f13187h;

        /* renamed from: i, reason: collision with root package name */
        public com.google.android.exoplayer2.drm.c f13188i;

        /* renamed from: j, reason: collision with root package name */
        public int f13189j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f13190k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f13191l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f13192m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f13193n = 0;

        /* renamed from: o, reason: collision with root package name */
        public byte[] f13194o = null;

        /* renamed from: p, reason: collision with root package name */
        public int f13195p = -1;

        /* renamed from: q, reason: collision with root package name */
        public boolean f13196q = false;

        /* renamed from: r, reason: collision with root package name */
        public int f13197r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f13198s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f13199t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f13200u = 1000;

        /* renamed from: v, reason: collision with root package name */
        public int f13201v = 200;

        /* renamed from: w, reason: collision with root package name */
        public float f13202w = -1.0f;

        /* renamed from: x, reason: collision with root package name */
        public float f13203x = -1.0f;

        /* renamed from: y, reason: collision with root package name */
        public float f13204y = -1.0f;

        /* renamed from: z, reason: collision with root package name */
        public float f13205z = -1.0f;
        public float A = -1.0f;
        public float B = -1.0f;
        public float C = -1.0f;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 1;
        public int H = -1;
        public int I = 8000;
        public long J = 0;
        public long K = 0;
        public boolean M = true;
        public String N = "eng";

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:225:0x03d8  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x03f9  */
        /* JADX WARN: Removed duplicated region for block: B:239:0x0420  */
        /* JADX WARN: Removed duplicated region for block: B:240:0x0422  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x042a  */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0451  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void initializeOutput(g5.g r45, int r46) throws com.google.android.exoplayer2.ParserException {
            /*
                Method dump skipped, instructions count: 1728
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: i5.d.b.initializeOutput(g5.g, int):void");
        }
    }

    public d(int i10) {
        i5.a aVar = new i5.a();
        this.f13168p = -1L;
        this.f13169q = -9223372036854775807L;
        this.f13170r = -9223372036854775807L;
        this.f13171s = -9223372036854775807L;
        this.f13177y = -1L;
        this.f13178z = -1L;
        this.A = -9223372036854775807L;
        this.f13153a = aVar;
        aVar.init(new a());
        this.f13156d = (i10 & 1) == 0;
        this.f13154b = new f();
        this.f13155c = new SparseArray<>();
        this.f13159g = new l6.l(4);
        this.f13160h = new l6.l(ByteBuffer.allocate(4).putInt(-1).array());
        this.f13161i = new l6.l(4);
        this.f13157e = new l6.l(j.f15860a);
        this.f13158f = new l6.l(4);
        this.f13162j = new l6.l();
        this.f13163k = new l6.l();
        this.f13164l = new l6.l(8);
        this.f13165m = new l6.l();
    }

    public final void a(b bVar, long j10) {
        if ("S_TEXT/UTF8".equals(bVar.f13180a)) {
            b(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, f13147a0);
        } else if ("S_TEXT/ASS".equals(bVar.f13180a)) {
            b(bVar, "%01d:%02d:%02d:%02d", 21, f13150d0, f13151e0);
        }
        bVar.O.sampleMetadata(j10, this.M, this.V, 0, bVar.f13186g);
        this.W = true;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        this.f13162j.reset();
    }

    public final void b(b bVar, String str, int i10, long j10, byte[] bArr) {
        byte[] utf8Bytes;
        byte[] bArr2;
        l6.l lVar = this.f13163k;
        byte[] bArr3 = lVar.f15881a;
        long j11 = this.G;
        if (j11 == -9223372036854775807L) {
            utf8Bytes = bArr;
            bArr2 = utf8Bytes;
        } else {
            int i11 = (int) (j11 / 3600000000L);
            long j12 = j11 - ((i11 * 3600) * 1000000);
            int i12 = (int) (j12 / 60000000);
            long j13 = j12 - ((i12 * 60) * 1000000);
            int i13 = (int) (j13 / 1000000);
            utf8Bytes = u.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j13 - (i13 * 1000000)) / j10))));
            bArr2 = bArr;
        }
        System.arraycopy(utf8Bytes, 0, bArr3, i10, bArr2.length);
        bVar.O.sampleData(lVar, lVar.limit());
        this.V = lVar.limit() + this.V;
    }

    public final void c(g5.f fVar, int i10) throws InterruptedException, IOException {
        l6.l lVar = this.f13159g;
        if (lVar.limit() >= i10) {
            return;
        }
        if (lVar.capacity() < i10) {
            byte[] bArr = lVar.f15881a;
            lVar.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i10)), lVar.limit());
        }
        ((g5.b) fVar).readFully(lVar.f15881a, lVar.limit(), i10 - lVar.limit());
        lVar.setLimit(i10);
    }

    public final int d(g5.f fVar, m mVar, int i10) throws InterruptedException, IOException {
        int iSampleData;
        l6.l lVar = this.f13162j;
        int iBytesLeft = lVar.bytesLeft();
        if (iBytesLeft > 0) {
            iSampleData = Math.min(i10, iBytesLeft);
            mVar.sampleData(lVar, iSampleData);
        } else {
            iSampleData = mVar.sampleData(fVar, i10, false);
        }
        this.N += iSampleData;
        this.V += iSampleData;
        return iSampleData;
    }

    public final long e(long j10) throws ParserException {
        long j11 = this.f13169q;
        if (j11 != -9223372036854775807L) {
            return u.scaleLargeTimestamp(j10, j11, 1000L);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    public final void f(g5.f fVar, b bVar, int i10) throws InterruptedException, IOException {
        int i11;
        if ("S_TEXT/UTF8".equals(bVar.f13180a)) {
            g(fVar, Z, i10);
            return;
        }
        if ("S_TEXT/ASS".equals(bVar.f13180a)) {
            g(fVar, f13149c0, i10);
            return;
        }
        m mVar = bVar.O;
        boolean z10 = this.O;
        l6.l lVar = this.f13162j;
        if (!z10) {
            if (bVar.f13184e) {
                this.M &= -1073741825;
                boolean z11 = this.P;
                l6.l lVar2 = this.f13159g;
                if (!z11) {
                    ((g5.b) fVar).readFully(lVar2.f15881a, 0, 1);
                    this.N++;
                    byte b10 = lVar2.f15881a[0];
                    if ((b10 & 128) == 128) {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                    this.S = b10;
                    this.P = true;
                }
                byte b11 = this.S;
                if ((b11 & 1) == 1) {
                    boolean z12 = (b11 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        l6.l lVar3 = this.f13164l;
                        ((g5.b) fVar).readFully(lVar3.f15881a, 0, 8);
                        this.N += 8;
                        this.Q = true;
                        lVar2.f15881a[0] = (byte) ((z12 ? 128 : 0) | 8);
                        lVar2.setPosition(0);
                        mVar.sampleData(lVar2, 1);
                        this.V++;
                        lVar3.setPosition(0);
                        mVar.sampleData(lVar3, 8);
                        this.V += 8;
                    }
                    if (z12) {
                        if (!this.R) {
                            ((g5.b) fVar).readFully(lVar2.f15881a, 0, 1);
                            this.N++;
                            lVar2.setPosition(0);
                            this.T = lVar2.readUnsignedByte();
                            this.R = true;
                        }
                        int i12 = this.T * 4;
                        lVar2.reset(i12);
                        ((g5.b) fVar).readFully(lVar2.f15881a, 0, i12);
                        this.N += i12;
                        short s10 = (short) ((this.T / 2) + 1);
                        int i13 = (s10 * 6) + 2;
                        ByteBuffer byteBuffer = this.f13166n;
                        if (byteBuffer == null || byteBuffer.capacity() < i13) {
                            this.f13166n = ByteBuffer.allocate(i13);
                        }
                        this.f13166n.position(0);
                        this.f13166n.putShort(s10);
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i11 = this.T;
                            if (i14 >= i11) {
                                break;
                            }
                            int unsignedIntToInt = lVar2.readUnsignedIntToInt();
                            if (i14 % 2 == 0) {
                                this.f13166n.putShort((short) (unsignedIntToInt - i15));
                            } else {
                                this.f13166n.putInt(unsignedIntToInt - i15);
                            }
                            i14++;
                            i15 = unsignedIntToInt;
                        }
                        int i16 = (i10 - this.N) - i15;
                        if (i11 % 2 == 1) {
                            this.f13166n.putInt(i16);
                        } else {
                            this.f13166n.putShort((short) i16);
                            this.f13166n.putInt(0);
                        }
                        byte[] bArrArray = this.f13166n.array();
                        l6.l lVar4 = this.f13165m;
                        lVar4.reset(bArrArray, i13);
                        mVar.sampleData(lVar4, i13);
                        this.V += i13;
                    }
                }
            } else {
                byte[] bArr = bVar.f13185f;
                if (bArr != null) {
                    lVar.reset(bArr, bArr.length);
                }
            }
            this.O = true;
        }
        int iLimit = lVar.limit() + i10;
        if (!"V_MPEG4/ISO/AVC".equals(bVar.f13180a) && !"V_MPEGH/ISO/HEVC".equals(bVar.f13180a)) {
            while (true) {
                int i17 = this.N;
                if (i17 >= iLimit) {
                    break;
                } else {
                    d(fVar, mVar, iLimit - i17);
                }
            }
        } else {
            l6.l lVar5 = this.f13158f;
            byte[] bArr2 = lVar5.f15881a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i18 = bVar.P;
            int i19 = 4 - i18;
            while (this.N < iLimit) {
                int i20 = this.U;
                if (i20 == 0) {
                    int iMin = Math.min(i18, lVar.bytesLeft());
                    ((g5.b) fVar).readFully(bArr2, i19 + iMin, i18 - iMin);
                    if (iMin > 0) {
                        lVar.readBytes(bArr2, i19, iMin);
                    }
                    this.N += i18;
                    lVar5.setPosition(0);
                    this.U = lVar5.readUnsignedIntToInt();
                    l6.l lVar6 = this.f13157e;
                    lVar6.setPosition(0);
                    mVar.sampleData(lVar6, 4);
                    this.V += 4;
                } else {
                    this.U = i20 - d(fVar, mVar, i20);
                }
            }
        }
        if ("A_VORBIS".equals(bVar.f13180a)) {
            l6.l lVar7 = this.f13160h;
            lVar7.setPosition(0);
            mVar.sampleData(lVar7, 4);
            this.V += 4;
        }
    }

    public final void g(g5.f fVar, byte[] bArr, int i10) throws InterruptedException, IOException {
        int length = bArr.length + i10;
        l6.l lVar = this.f13163k;
        if (lVar.capacity() < length) {
            lVar.f15881a = Arrays.copyOf(bArr, length + i10);
        } else {
            System.arraycopy(bArr, 0, lVar.f15881a, 0, bArr.length);
        }
        ((g5.b) fVar).readFully(lVar.f15881a, bArr.length, i10);
        lVar.reset(length);
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.Y = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0005 A[SYNTHETIC] */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(g5.f r9, g5.k r10) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r8.W = r0
            r1 = 1
            r2 = 1
        L5:
            if (r2 == 0) goto L3f
            boolean r3 = r8.W
            if (r3 != 0) goto L3f
            i5.b r2 = r8.f13153a
            i5.a r2 = (i5.a) r2
            boolean r2 = r2.read(r9)
            if (r2 == 0) goto L5
            r3 = r9
            g5.b r3 = (g5.b) r3
            long r3 = r3.getPosition()
            boolean r5 = r8.f13176x
            if (r5 == 0) goto L2a
            r8.f13178z = r3
            long r3 = r8.f13177y
            r10.f12726a = r3
            r8.f13176x = r0
        L28:
            r3 = 1
            goto L3c
        L2a:
            boolean r3 = r8.f13173u
            if (r3 == 0) goto L3b
            long r3 = r8.f13178z
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L3b
            r10.f12726a = r3
            r8.f13178z = r5
            goto L28
        L3b:
            r3 = 0
        L3c:
            if (r3 == 0) goto L5
            return r1
        L3f:
            if (r2 == 0) goto L42
            goto L43
        L42:
            r0 = -1
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.d.read(g5.f, g5.k):int");
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.A = -9223372036854775807L;
        this.E = 0;
        ((i5.a) this.f13153a).reset();
        this.f13154b.reset();
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        this.f13162j.reset();
    }

    @Override // g5.e
    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        return new e().sniff(fVar);
    }

    @Override // g5.e
    public void release() {
    }
}
