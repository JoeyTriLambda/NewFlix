package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.u;

/* compiled from: HlsPlaylistParser.java */
/* loaded from: classes.dex */
public final class c implements a.InterfaceC0074a<z5.a> {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f5936a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f5937b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f5938c = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f5939d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f5940e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f5941f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f5942g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f5943h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f5944i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f5945j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f5946k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f5947l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f5948m = Pattern.compile("METHOD=(NONE|AES-128)");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f5949n = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f5950o = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f5951p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f5952q = Pattern.compile("LANGUAGE=\"(.+?)\"");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f5953r = Pattern.compile("NAME=\"(.+?)\"");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f5954s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f5955t = a("AUTOSELECT");

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f5956u = a("DEFAULT");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f5957v = a("FORCED");

    /* compiled from: HlsPlaylistParser.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedReader f5958a;

        /* renamed from: b, reason: collision with root package name */
        public final Queue<String> f5959b;

        /* renamed from: c, reason: collision with root package name */
        public String f5960c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f5959b = queue;
            this.f5958a = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            String strTrim;
            if (this.f5960c != null) {
                return true;
            }
            Queue<String> queue = this.f5959b;
            if (!queue.isEmpty()) {
                this.f5960c = queue.poll();
                return true;
            }
            do {
                String line = this.f5958a.readLine();
                this.f5960c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f5960c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (!hasNext()) {
                return null;
            }
            String str = this.f5960c;
            this.f5960c = null;
            return str;
        }
    }

    public static Pattern a(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    public static boolean b(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals("YES");
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0119  */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.source.hls.playlist.a c(com.google.android.exoplayer2.source.hls.playlist.c.a r35, java.lang.String r36) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.c.c(com.google.android.exoplayer2.source.hls.playlist.c$a, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.a");
    }

    public static b d(a aVar, String str) throws IOException, NumberFormatException {
        long j10;
        long jMsToUs;
        boolean z10;
        int i10;
        int i11;
        int i12;
        boolean z11;
        boolean z12;
        b.a aVar2;
        long j11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j12 = -9223372036854775807L;
        char c10 = 0;
        long j13 = -9223372036854775807L;
        int i13 = 0;
        int i14 = 0;
        boolean zEquals = false;
        long j14 = 0;
        long j15 = 0;
        String str2 = null;
        boolean z13 = false;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        boolean z14 = false;
        boolean z15 = false;
        b.a aVar3 = null;
        long j16 = 0;
        int i18 = 0;
        String str3 = null;
        loop0: while (true) {
            j10 = j13;
            jMsToUs = j15;
            z10 = z13;
            i10 = i15;
            i11 = i16;
            i12 = i17;
            z11 = z14;
            z12 = z15;
            aVar2 = aVar3;
            long j17 = -1;
            long j18 = 0;
            j11 = j12;
            String strE = str2;
            String strF = str3;
            while (aVar.hasNext()) {
                String next = aVar.next();
                if (next.startsWith("#EXT")) {
                    arrayList2.add(next);
                }
                if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String strF2 = f(next, f5942g);
                    if ("VOD".equals(strF2)) {
                        i13 = 1;
                    } else if ("EVENT".equals(strF2)) {
                        i13 = 2;
                    }
                } else if (next.startsWith("#EXT-X-START")) {
                    j11 = (long) (Double.parseDouble(f(next, f5945j)) * 1000000.0d);
                } else {
                    boolean zStartsWith = next.startsWith("#EXT-X-MAP");
                    Pattern pattern = f5949n;
                    if (zStartsWith) {
                        String strF3 = f(next, pattern);
                        String strE2 = e(next, f5947l);
                        if (strE2 != null) {
                            String[] strArrSplit = strE2.split("@");
                            j17 = Long.parseLong(strArrSplit[c10]);
                            if (strArrSplit.length > 1) {
                                j16 = Long.parseLong(strArrSplit[1]);
                            }
                        }
                        aVar2 = new b.a(strF3, j16, j17);
                        j17 = -1;
                        j16 = 0;
                    } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                        j10 = Integer.parseInt(f(next, f5940e)) * 1000000;
                    } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        i18 = Integer.parseInt(f(next, f5943h));
                        i11 = i18;
                    } else if (next.startsWith("#EXT-X-VERSION")) {
                        i12 = Integer.parseInt(f(next, f5941f));
                    } else if (next.startsWith("#EXTINF")) {
                        j18 = (long) (Double.parseDouble(f(next, f5944i)) * 1000000.0d);
                    } else if (next.startsWith("#EXT-X-KEY")) {
                        zEquals = "AES-128".equals(f(next, f5948m));
                        if (zEquals) {
                            strF = f(next, pattern);
                            strE = e(next, f5950o);
                        } else {
                            strE = null;
                            strF = null;
                        }
                    } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                        String[] strArrSplit2 = f(next, f5946k).split("@");
                        j17 = Long.parseLong(strArrSplit2[c10]);
                        if (strArrSplit2.length > 1) {
                            j16 = Long.parseLong(strArrSplit2[1]);
                        }
                    } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i10 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                        z10 = true;
                    } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                        i14++;
                    } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (jMsToUs == 0) {
                            jMsToUs = c5.b.msToUs(u.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j14;
                        } else {
                            c10 = 0;
                        }
                    } else if (!next.startsWith("#")) {
                        String hexString = !zEquals ? null : strE != null ? strE : Integer.toHexString(i18);
                        int i19 = i18 + 1;
                        long j19 = j17 == -1 ? 0L : j16;
                        arrayList.add(new b.a(next, j18, i14, j14, zEquals, strF, hexString, j19, j17));
                        j14 += j18;
                        if (j17 != -1) {
                            j19 += j17;
                        }
                        j16 = j19;
                        str2 = strE;
                        str3 = strF;
                        i18 = i19;
                        j12 = j11;
                        j13 = j10;
                        j15 = jMsToUs;
                        z13 = z10;
                        i15 = i10;
                        i16 = i11;
                        i17 = i12;
                        z14 = z11;
                        z15 = z12;
                        aVar3 = aVar2;
                        c10 = 0;
                    } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        c10 = 0;
                        z11 = true;
                    } else if (next.equals("#EXT-X-ENDLIST")) {
                        c10 = 0;
                        z12 = true;
                    } else {
                        c10 = 0;
                    }
                }
            }
            break loop0;
        }
        return new b(i13, str, arrayList2, j11, jMsToUs, z10, i10, i11, i12, j10, z11, z12, jMsToUs != 0, aVar2, arrayList);
    }

    public static String e(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String f(String str, Pattern pattern) throws ParserException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:3:0x000f, B:5:0x0018, B:7:0x0020, B:10:0x0029, B:33:0x006b, B:35:0x0071, B:38:0x007c, B:40:0x0084, B:43:0x0098, B:45:0x00a0, B:47:0x00a8, B:49:0x00b0, B:51:0x00b8, B:53:0x00c0, B:55:0x00c8, B:57:0x00d0, B:60:0x00d9, B:61:0x00dd, B:66:0x00fc, B:67:0x0103, B:13:0x0030, B:15:0x0036, B:21:0x0042, B:24:0x004b, B:26:0x0054, B:28:0x005a, B:30:0x0060, B:31:0x0065), top: B:70:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0052 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0074a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z5.a parse(android.net.Uri r7, java.io.InputStream r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.c.parse(android.net.Uri, java.io.InputStream):z5.a");
    }
}
