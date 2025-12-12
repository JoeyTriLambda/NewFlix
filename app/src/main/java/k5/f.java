package k5;

import android.util.Log;
import cz.msebera.android.httpclient.HttpHeaders;
import l6.u;

/* compiled from: MetadataUtil.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f14864a = u.getIntegerCodeForString("nam");

    /* renamed from: b, reason: collision with root package name */
    public static final int f14865b = u.getIntegerCodeForString("trk");

    /* renamed from: c, reason: collision with root package name */
    public static final int f14866c = u.getIntegerCodeForString("cmt");

    /* renamed from: d, reason: collision with root package name */
    public static final int f14867d = u.getIntegerCodeForString("day");

    /* renamed from: e, reason: collision with root package name */
    public static final int f14868e = u.getIntegerCodeForString("ART");

    /* renamed from: f, reason: collision with root package name */
    public static final int f14869f = u.getIntegerCodeForString("too");

    /* renamed from: g, reason: collision with root package name */
    public static final int f14870g = u.getIntegerCodeForString("alb");

    /* renamed from: h, reason: collision with root package name */
    public static final int f14871h = u.getIntegerCodeForString("com");

    /* renamed from: i, reason: collision with root package name */
    public static final int f14872i = u.getIntegerCodeForString("wrt");

    /* renamed from: j, reason: collision with root package name */
    public static final int f14873j = u.getIntegerCodeForString("lyr");

    /* renamed from: k, reason: collision with root package name */
    public static final int f14874k = u.getIntegerCodeForString("gen");

    /* renamed from: l, reason: collision with root package name */
    public static final int f14875l = u.getIntegerCodeForString("covr");

    /* renamed from: m, reason: collision with root package name */
    public static final int f14876m = u.getIntegerCodeForString("gnre");

    /* renamed from: n, reason: collision with root package name */
    public static final int f14877n = u.getIntegerCodeForString("grp");

    /* renamed from: o, reason: collision with root package name */
    public static final int f14878o = u.getIntegerCodeForString("disk");

    /* renamed from: p, reason: collision with root package name */
    public static final int f14879p = u.getIntegerCodeForString("trkn");

    /* renamed from: q, reason: collision with root package name */
    public static final int f14880q = u.getIntegerCodeForString("tmpo");

    /* renamed from: r, reason: collision with root package name */
    public static final int f14881r = u.getIntegerCodeForString("cpil");

    /* renamed from: s, reason: collision with root package name */
    public static final int f14882s = u.getIntegerCodeForString("aART");

    /* renamed from: t, reason: collision with root package name */
    public static final int f14883t = u.getIntegerCodeForString("sonm");

    /* renamed from: u, reason: collision with root package name */
    public static final int f14884u = u.getIntegerCodeForString("soal");

    /* renamed from: v, reason: collision with root package name */
    public static final int f14885v = u.getIntegerCodeForString("soar");

    /* renamed from: w, reason: collision with root package name */
    public static final int f14886w = u.getIntegerCodeForString("soaa");

    /* renamed from: x, reason: collision with root package name */
    public static final int f14887x = u.getIntegerCodeForString("soco");

    /* renamed from: y, reason: collision with root package name */
    public static final int f14888y = u.getIntegerCodeForString("rtng");

    /* renamed from: z, reason: collision with root package name */
    public static final int f14889z = u.getIntegerCodeForString("pgap");
    public static final int A = u.getIntegerCodeForString("sosn");
    public static final int B = u.getIntegerCodeForString("tvsh");
    public static final int C = u.getIntegerCodeForString("----");
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static s5.e a(int i10, l6.l lVar) {
        int i11 = lVar.readInt();
        if (lVar.readInt() == a.F0) {
            lVar.skipBytes(8);
            String nullTerminatedString = lVar.readNullTerminatedString(i11 - 16);
            return new s5.e("und", nullTerminatedString, nullTerminatedString);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.getAtomTypeString(i10));
        return null;
    }

    public static s5.a b(l6.l lVar) {
        int i10 = lVar.readInt();
        if (lVar.readInt() != a.F0) {
            Log.w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int fullAtomFlags = a.parseFullAtomFlags(lVar.readInt());
        String str = fullAtomFlags == 13 ? "image/jpeg" : fullAtomFlags == 14 ? "image/png" : null;
        if (str == null) {
            o1.a.o("Unrecognized cover art flags: ", fullAtomFlags, "MetadataUtil");
            return null;
        }
        lVar.skipBytes(4);
        int i11 = i10 - 16;
        byte[] bArr = new byte[i11];
        lVar.readBytes(bArr, 0, i11);
        return new s5.a(str, null, 3, bArr);
    }

    public static s5.j c(int i10, l6.l lVar, String str) {
        int i11 = lVar.readInt();
        if (lVar.readInt() == a.F0 && i11 >= 22) {
            lVar.skipBytes(10);
            int unsignedShort = lVar.readUnsignedShort();
            if (unsignedShort > 0) {
                String strF = ac.c.f("", unsignedShort);
                int unsignedShort2 = lVar.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    strF = strF + "/" + unsignedShort2;
                }
                return new s5.j(str, null, strF);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.getAtomTypeString(i10));
        return null;
    }

    public static s5.e d(int i10, l6.l lVar) {
        String nullTerminatedString = null;
        String nullTerminatedString2 = null;
        int i11 = -1;
        int i12 = -1;
        while (lVar.getPosition() < i10) {
            int position = lVar.getPosition();
            int i13 = lVar.readInt();
            int i14 = lVar.readInt();
            lVar.skipBytes(4);
            if (i14 == a.D0) {
                nullTerminatedString = lVar.readNullTerminatedString(i13 - 12);
            } else if (i14 == a.E0) {
                nullTerminatedString2 = lVar.readNullTerminatedString(i13 - 12);
            } else {
                if (i14 == a.F0) {
                    i11 = position;
                    i12 = i13;
                }
                lVar.skipBytes(i13 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(nullTerminatedString) || !"iTunSMPB".equals(nullTerminatedString2) || i11 == -1) {
            return null;
        }
        lVar.setPosition(i11);
        lVar.skipBytes(16);
        return new s5.e("und", nullTerminatedString2, lVar.readNullTerminatedString(i12 - 16));
    }

    public static s5.j e(int i10, l6.l lVar, String str) {
        int i11 = lVar.readInt();
        if (lVar.readInt() == a.F0) {
            lVar.skipBytes(8);
            return new s5.j(str, null, lVar.readNullTerminatedString(i11 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.getAtomTypeString(i10));
        return null;
    }

    public static s5.h f(int i10, String str, l6.l lVar, boolean z10, boolean z11) {
        int iG = g(lVar);
        if (z11) {
            iG = Math.min(1, iG);
        }
        if (iG >= 0) {
            return z10 ? new s5.j(str, null, Integer.toString(iG)) : new s5.e("und", str, Integer.toString(iG));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.getAtomTypeString(i10));
        return null;
    }

    public static int g(l6.l lVar) {
        lVar.skipBytes(4);
        if (lVar.readInt() == a.F0) {
            lVar.skipBytes(8);
            return lVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static q5.a.b parseIlstElement(l6.l r8) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.f.parseIlstElement(l6.l):q5.a$b");
    }
}
