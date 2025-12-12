package k5;

import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.ArrayList;
import java.util.Arrays;
import l6.u;

/* compiled from: Atom.java */
/* loaded from: classes.dex */
public abstract class a {
    public static final int A0;
    public static final int B0;
    public static final int C0;
    public static final int D0;
    public static final int E0;
    public static final int F0;
    public static final int G0;
    public static final int H0;
    public static final int I0;
    public static final int J0;
    public static final int K0;
    public static final int L0;
    public static final int M0;
    public static final int N0;
    public static final int O0;

    /* renamed from: l0, reason: collision with root package name */
    public static final int f14759l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final int f14761m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final int f14763n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f14765o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final int f14767p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final int f14769q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final int f14771r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final int f14773s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final int f14775t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final int f14777u0;

    /* renamed from: v0, reason: collision with root package name */
    public static final int f14779v0;

    /* renamed from: w0, reason: collision with root package name */
    public static final int f14781w0;

    /* renamed from: x0, reason: collision with root package name */
    public static final int f14783x0;

    /* renamed from: y0, reason: collision with root package name */
    public static final int f14785y0;

    /* renamed from: z0, reason: collision with root package name */
    public static final int f14787z0;

    /* renamed from: a, reason: collision with root package name */
    public final int f14788a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f14738b = u.getIntegerCodeForString("ftyp");

    /* renamed from: c, reason: collision with root package name */
    public static final int f14740c = u.getIntegerCodeForString("avc1");

    /* renamed from: d, reason: collision with root package name */
    public static final int f14742d = u.getIntegerCodeForString("avc3");

    /* renamed from: e, reason: collision with root package name */
    public static final int f14744e = u.getIntegerCodeForString("hvc1");

    /* renamed from: f, reason: collision with root package name */
    public static final int f14746f = u.getIntegerCodeForString("hev1");

    /* renamed from: g, reason: collision with root package name */
    public static final int f14748g = u.getIntegerCodeForString("s263");

    /* renamed from: h, reason: collision with root package name */
    public static final int f14750h = u.getIntegerCodeForString("d263");

    /* renamed from: i, reason: collision with root package name */
    public static final int f14752i = u.getIntegerCodeForString("mdat");

    /* renamed from: j, reason: collision with root package name */
    public static final int f14754j = u.getIntegerCodeForString("mp4a");

    /* renamed from: k, reason: collision with root package name */
    public static final int f14756k = u.getIntegerCodeForString(".mp3");

    /* renamed from: l, reason: collision with root package name */
    public static final int f14758l = u.getIntegerCodeForString("wave");

    /* renamed from: m, reason: collision with root package name */
    public static final int f14760m = u.getIntegerCodeForString("lpcm");

    /* renamed from: n, reason: collision with root package name */
    public static final int f14762n = u.getIntegerCodeForString("sowt");

    /* renamed from: o, reason: collision with root package name */
    public static final int f14764o = u.getIntegerCodeForString("ac-3");

    /* renamed from: p, reason: collision with root package name */
    public static final int f14766p = u.getIntegerCodeForString("dac3");

    /* renamed from: q, reason: collision with root package name */
    public static final int f14768q = u.getIntegerCodeForString("ec-3");

    /* renamed from: r, reason: collision with root package name */
    public static final int f14770r = u.getIntegerCodeForString("dec3");

    /* renamed from: s, reason: collision with root package name */
    public static final int f14772s = u.getIntegerCodeForString("dtsc");

    /* renamed from: t, reason: collision with root package name */
    public static final int f14774t = u.getIntegerCodeForString("dtsh");

    /* renamed from: u, reason: collision with root package name */
    public static final int f14776u = u.getIntegerCodeForString("dtsl");

    /* renamed from: v, reason: collision with root package name */
    public static final int f14778v = u.getIntegerCodeForString("dtse");

    /* renamed from: w, reason: collision with root package name */
    public static final int f14780w = u.getIntegerCodeForString("ddts");

    /* renamed from: x, reason: collision with root package name */
    public static final int f14782x = u.getIntegerCodeForString("tfdt");

    /* renamed from: y, reason: collision with root package name */
    public static final int f14784y = u.getIntegerCodeForString("tfhd");

    /* renamed from: z, reason: collision with root package name */
    public static final int f14786z = u.getIntegerCodeForString("trex");
    public static final int A = u.getIntegerCodeForString("trun");
    public static final int B = u.getIntegerCodeForString("sidx");
    public static final int C = u.getIntegerCodeForString("moov");
    public static final int D = u.getIntegerCodeForString("mvhd");
    public static final int E = u.getIntegerCodeForString("trak");
    public static final int F = u.getIntegerCodeForString("mdia");
    public static final int G = u.getIntegerCodeForString("minf");
    public static final int H = u.getIntegerCodeForString("stbl");
    public static final int I = u.getIntegerCodeForString("avcC");
    public static final int J = u.getIntegerCodeForString("hvcC");
    public static final int K = u.getIntegerCodeForString("esds");
    public static final int L = u.getIntegerCodeForString("moof");
    public static final int M = u.getIntegerCodeForString("traf");
    public static final int N = u.getIntegerCodeForString("mvex");
    public static final int O = u.getIntegerCodeForString("mehd");
    public static final int P = u.getIntegerCodeForString("tkhd");
    public static final int Q = u.getIntegerCodeForString("edts");
    public static final int R = u.getIntegerCodeForString("elst");
    public static final int S = u.getIntegerCodeForString("mdhd");
    public static final int T = u.getIntegerCodeForString("hdlr");
    public static final int U = u.getIntegerCodeForString("stsd");
    public static final int V = u.getIntegerCodeForString("pssh");
    public static final int W = u.getIntegerCodeForString("sinf");
    public static final int X = u.getIntegerCodeForString("schm");
    public static final int Y = u.getIntegerCodeForString("schi");
    public static final int Z = u.getIntegerCodeForString("tenc");

    /* renamed from: a0, reason: collision with root package name */
    public static final int f14737a0 = u.getIntegerCodeForString("encv");

    /* renamed from: b0, reason: collision with root package name */
    public static final int f14739b0 = u.getIntegerCodeForString("enca");

    /* renamed from: c0, reason: collision with root package name */
    public static final int f14741c0 = u.getIntegerCodeForString("frma");

    /* renamed from: d0, reason: collision with root package name */
    public static final int f14743d0 = u.getIntegerCodeForString("saiz");

    /* renamed from: e0, reason: collision with root package name */
    public static final int f14745e0 = u.getIntegerCodeForString("saio");

    /* renamed from: f0, reason: collision with root package name */
    public static final int f14747f0 = u.getIntegerCodeForString("sbgp");

    /* renamed from: g0, reason: collision with root package name */
    public static final int f14749g0 = u.getIntegerCodeForString("sgpd");

    /* renamed from: h0, reason: collision with root package name */
    public static final int f14751h0 = u.getIntegerCodeForString("uuid");

    /* renamed from: i0, reason: collision with root package name */
    public static final int f14753i0 = u.getIntegerCodeForString("senc");

    /* renamed from: j0, reason: collision with root package name */
    public static final int f14755j0 = u.getIntegerCodeForString("pasp");

    /* renamed from: k0, reason: collision with root package name */
    public static final int f14757k0 = u.getIntegerCodeForString("TTML");

    /* compiled from: Atom.java */
    /* renamed from: k5.a$a, reason: collision with other inner class name */
    public static final class C0177a extends a {
        public final long P0;
        public final ArrayList Q0;
        public final ArrayList R0;

        public C0177a(int i10, long j10) {
            super(i10);
            this.P0 = j10;
            this.Q0 = new ArrayList();
            this.R0 = new ArrayList();
        }

        public void add(b bVar) {
            this.Q0.add(bVar);
        }

        public C0177a getContainerAtomOfType(int i10) {
            ArrayList arrayList = this.R0;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                C0177a c0177a = (C0177a) arrayList.get(i11);
                if (c0177a.f14788a == i10) {
                    return c0177a;
                }
            }
            return null;
        }

        public b getLeafAtomOfType(int i10) {
            ArrayList arrayList = this.Q0;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = (b) arrayList.get(i11);
                if (bVar.f14788a == i10) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // k5.a
        public String toString() {
            return a.getAtomTypeString(this.f14788a) + " leaves: " + Arrays.toString(this.Q0.toArray()) + " containers: " + Arrays.toString(this.R0.toArray());
        }

        public void add(C0177a c0177a) {
            this.R0.add(c0177a);
        }
    }

    /* compiled from: Atom.java */
    public static final class b extends a {
        public final l6.l P0;

        public b(int i10, l6.l lVar) {
            super(i10);
            this.P0 = lVar;
        }
    }

    static {
        u.getIntegerCodeForString("vmhd");
        f14759l0 = u.getIntegerCodeForString("mp4v");
        f14761m0 = u.getIntegerCodeForString("stts");
        f14763n0 = u.getIntegerCodeForString("stss");
        f14765o0 = u.getIntegerCodeForString("ctts");
        f14767p0 = u.getIntegerCodeForString("stsc");
        f14769q0 = u.getIntegerCodeForString("stsz");
        f14771r0 = u.getIntegerCodeForString("stz2");
        f14773s0 = u.getIntegerCodeForString("stco");
        f14775t0 = u.getIntegerCodeForString("co64");
        f14777u0 = u.getIntegerCodeForString("tx3g");
        f14779v0 = u.getIntegerCodeForString("wvtt");
        f14781w0 = u.getIntegerCodeForString("stpp");
        f14783x0 = u.getIntegerCodeForString("c608");
        f14785y0 = u.getIntegerCodeForString("samr");
        f14787z0 = u.getIntegerCodeForString("sawb");
        A0 = u.getIntegerCodeForString("udta");
        B0 = u.getIntegerCodeForString("meta");
        C0 = u.getIntegerCodeForString("ilst");
        D0 = u.getIntegerCodeForString("mean");
        E0 = u.getIntegerCodeForString(MediationMetaData.KEY_NAME);
        F0 = u.getIntegerCodeForString(JsonStorageKeyNames.DATA_KEY);
        G0 = u.getIntegerCodeForString("emsg");
        H0 = u.getIntegerCodeForString("st3d");
        I0 = u.getIntegerCodeForString("sv3d");
        J0 = u.getIntegerCodeForString("proj");
        K0 = u.getIntegerCodeForString("vp08");
        L0 = u.getIntegerCodeForString("vp09");
        M0 = u.getIntegerCodeForString("vpcC");
        N0 = u.getIntegerCodeForString("camm");
        O0 = u.getIntegerCodeForString("alac");
    }

    public a(int i10) {
        this.f14788a = i10;
    }

    public static String getAtomTypeString(int i10) {
        return "" + ((char) ((i10 >> 24) & 255)) + ((char) ((i10 >> 16) & 255)) + ((char) ((i10 >> 8) & 255)) + ((char) (i10 & 255));
    }

    public static int parseFullAtomFlags(int i10) {
        return i10 & 16777215;
    }

    public static int parseFullAtomVersion(int i10) {
        return (i10 >> 24) & 255;
    }

    public String toString() {
        return getAtomTypeString(this.f14788a);
    }
}
