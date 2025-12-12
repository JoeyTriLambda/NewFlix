package x5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.upstream.a;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.t;
import l6.u;
import l6.v;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import x5.h;

/* compiled from: DashManifestParser.java */
/* loaded from: classes.dex */
public final class c extends DefaultHandler implements a.InterfaceC0074a<b> {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f21571c = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f21572d = Pattern.compile("CC([1-4])=.*");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f21573e = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: a, reason: collision with root package name */
    public final String f21574a;

    /* renamed from: b, reason: collision with root package name */
    public final XmlPullParserFactory f21575b;

    /* compiled from: DashManifestParser.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c5.i f21576a;

        /* renamed from: b, reason: collision with root package name */
        public final String f21577b;

        /* renamed from: c, reason: collision with root package name */
        public final h f21578c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<c.b> f21579d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList<d> f21580e;

        public a(c5.i iVar, String str, h hVar, ArrayList<c.b> arrayList, ArrayList<d> arrayList2) {
            this.f21576a = iVar;
            this.f21577b = str;
            this.f21578c = hVar;
            this.f21579d = arrayList;
            this.f21580e = arrayList2;
        }
    }

    public c() {
        this(null);
    }

    public static boolean a(String str) {
        return l6.i.isText(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    public static String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return t.resolve(str, xmlPullParser.getText());
    }

    public static int parseCea608AccessibilityChannel(List<d> list) {
        String str;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f21581a) && (str = dVar.f21582b) != null) {
                Matcher matcher = f21572d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + str);
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List<d> list) {
        String str;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f21581a) && (str = dVar.f21582b) != null) {
                Matcher matcher = f21573e.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + str);
            }
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j10) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : u.parseXsDateTime(attributeValue);
    }

    public static d parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", "");
        String string2 = parseString(xmlPullParser, "value", null);
        String string3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!v.isEndTag(xmlPullParser, str));
        return new d(string, string2, string3);
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : u.parseXsDuration(attributeValue);
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f10) throws NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f10;
        }
        Matcher matcher = f21571c.matcher(attributeValue);
        if (!matcher.matches()) {
            return f10;
        }
        int i10 = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i10 / Integer.parseInt(r2) : i10;
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i10 : Integer.parseInt(attributeValue);
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : Long.parseLong(attributeValue);
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public x5.a buildAdaptationSet(int i10, int i11, List<g> list, List<d> list2, List<d> list3) {
        return new x5.a(i10, i11, list, list2, list3);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c5.i buildFormat(java.lang.String r11, java.lang.String r12, int r13, int r14, float r15, int r16, int r17, int r18, java.lang.String r19, int r20, java.util.List<x5.d> r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.buildFormat(java.lang.String, java.lang.String, int, int, float, int, int, int, java.lang.String, int, java.util.List, java.lang.String):c5.i");
    }

    public b buildMediaPresentationDescription(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, k kVar, Uri uri, List<e> list) {
        return new b(j10, j11, j12, z10, j13, j14, j15, kVar, uri, list);
    }

    public e buildPeriod(String str, long j10, List<x5.a> list) {
        return new e(str, j10, list);
    }

    public f buildRangedUri(String str, long j10, long j11) {
        return new f(str, j10, j11);
    }

    public g buildRepresentation(a aVar, String str, ArrayList<c.b> arrayList, ArrayList<d> arrayList2) {
        c5.i iVarCopyWithDrmInitData = aVar.f21576a;
        ArrayList<c.b> arrayList3 = aVar.f21579d;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            iVarCopyWithDrmInitData = iVarCopyWithDrmInitData.copyWithDrmInitData(new com.google.android.exoplayer2.drm.c(arrayList3));
        }
        ArrayList<d> arrayList4 = aVar.f21580e;
        arrayList4.addAll(arrayList2);
        return g.newInstance(str, -1L, iVarCopyWithDrmInitData, aVar.f21577b, aVar.f21578c, arrayList4);
    }

    public h.b buildSegmentList(f fVar, long j10, long j11, int i10, long j12, List<h.d> list, List<f> list2) {
        return new h.b(fVar, j10, j11, i10, j12, list, list2);
    }

    public h.c buildSegmentTemplate(f fVar, long j10, long j11, int i10, long j12, List<h.d> list, j jVar, j jVar2) {
        return new h.c(fVar, j10, j11, i10, j12, list, jVar, jVar2);
    }

    public h.d buildSegmentTimelineElement(long j10, long j11) {
        return new h.d(j10, j11);
    }

    public h.e buildSingleSegmentBase(f fVar, long j10, long j11, long j12, long j13) {
        return new h.e(fVar, j10, j11, j12, j13);
    }

    public k buildUtcTimingElement(String str, String str2) {
        return new k(str, str2);
    }

    public int getContentType(c5.i iVar) {
        String str = iVar.f5120q;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (l6.i.isVideo(str)) {
            return 2;
        }
        if (l6.i.isAudio(str)) {
            return 1;
        }
        return a(str) ? 3 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0207 A[LOOP:0: B:3:0x0062->B:80:0x0207, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d5 A[EDGE_INSN: B:81:0x01d5->B:74:0x01d5 BREAK  A[LOOP:0: B:3:0x0062->B:80:0x0207], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public x5.a parseAdaptationSet(org.xmlpull.v1.XmlPullParser r39, java.lang.String r40, x5.h r41) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.parseAdaptationSet(org.xmlpull.v1.XmlPullParser, java.lang.String, x5.h):x5.a");
    }

    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(parseString(xmlPullParser, "schemeIdUri", null)) ? parseInt(xmlPullParser, "value", -1) : -1;
        do {
            xmlPullParser.next();
        } while (!v.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[LOOP:0: B:3:0x0017->B:34:0x0096, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b A[EDGE_INSN: B:35:0x008b->B:31:0x008b BREAK  A[LOOP:0: B:3:0x0017->B:34:0x0096], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.drm.c.b parseContentProtection(org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = r10.getAttributeValue(r1, r0)
            java.lang.String r2 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r0 = r2.equals(r0)
            java.lang.String r2 = "value"
            java.lang.String r5 = r10.getAttributeValue(r1, r2)
            r2 = 0
            r3 = r1
            r4 = r3
            r6 = 0
        L17:
            r10.next()
            r7 = 4
            if (r3 != 0) goto L42
            java.lang.String r8 = "cenc:pssh"
            boolean r8 = l6.v.isStartTag(r10, r8)
            if (r8 == 0) goto L42
            int r8 = r10.next()
            if (r8 != r7) goto L42
            java.lang.String r3 = r10.getText()
            byte[] r3 = android.util.Base64.decode(r3, r2)
            java.util.UUID r4 = k5.h.parseUuid(r3)
            if (r4 != 0) goto L81
            java.lang.String r3 = "MpdParser"
            java.lang.String r7 = "Skipping malformed cenc:pssh data"
            android.util.Log.w(r3, r7)
            r7 = r1
            goto L82
        L42:
            if (r3 != 0) goto L66
            if (r0 == 0) goto L66
            java.lang.String r8 = "mspr:pro"
            boolean r8 = l6.v.isStartTag(r10, r8)
            if (r8 == 0) goto L66
            int r8 = r10.next()
            if (r8 != r7) goto L66
            java.util.UUID r3 = c5.b.f5035e
            java.lang.String r4 = r10.getText()
            byte[] r4 = android.util.Base64.decode(r4, r2)
            byte[] r4 = k5.h.buildPsshAtom(r3, r4)
            r7 = r4
            r8 = r6
            r4 = r3
            goto L83
        L66:
            java.lang.String r7 = "widevine:license"
            boolean r7 = l6.v.isStartTag(r10, r7)
            if (r7 == 0) goto L81
            java.lang.String r6 = "robustness_level"
            java.lang.String r6 = r10.getAttributeValue(r1, r6)
            if (r6 == 0) goto L80
            java.lang.String r7 = "HW"
            boolean r6 = r6.startsWith(r7)
            if (r6 == 0) goto L80
            r6 = 1
            goto L81
        L80:
            r6 = 0
        L81:
            r7 = r3
        L82:
            r8 = r6
        L83:
            java.lang.String r3 = "ContentProtection"
            boolean r3 = l6.v.isEndTag(r10, r3)
            if (r3 == 0) goto L96
            if (r7 == 0) goto L95
            com.google.android.exoplayer2.drm.c$b r1 = new com.google.android.exoplayer2.drm.c$b
            java.lang.String r6 = "video/mp4"
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)
        L95:
            return r1
        L96:
            r3 = r7
            r6 = r8
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.parseContentProtection(org.xmlpull.v1.XmlPullParser):com.google.android.exoplayer2.drm.c$b");
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if (MimeTypes.BASE_TYPE_VIDEO.equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    public f parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0178 A[LOOP:0: B:22:0x0065->B:67:0x0178, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public x5.b parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser r32, java.lang.String r33) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser, java.lang.String):x5.b");
    }

    public Pair<e, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j10) throws XmlPullParserException, IOException, NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long duration = parseDuration(xmlPullParser, "start", j10);
        long duration2 = parseDuration(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        h segmentTemplate = null;
        do {
            xmlPullParser.next();
            if (v.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z10) {
                    str = parseBaseUrl(xmlPullParser, str);
                    z10 = true;
                }
            } else if (v.isStartTag(xmlPullParser, "AdaptationSet")) {
                arrayList.add(parseAdaptationSet(xmlPullParser, str, segmentTemplate));
            } else if (v.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentTemplate = parseSegmentBase(xmlPullParser, null);
            } else if (v.isStartTag(xmlPullParser, "SegmentList")) {
                segmentTemplate = parseSegmentList(xmlPullParser, null);
            } else if (v.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentTemplate = parseSegmentTemplate(xmlPullParser, null);
            }
        } while (!v.isEndTag(xmlPullParser, "Period"));
        return Pair.create(buildPeriod(attributeValue, duration, arrayList), Long.valueOf(duration2));
    }

    public f parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) throws NumberFormatException {
        long j10;
        long j11;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j10 = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j11 = (Long.parseLong(strArrSplit[1]) - j10) + 1;
            }
            return buildRangedUri(attributeValue, j10, j11);
        }
        j10 = 0;
        j11 = -1;
        return buildRangedUri(attributeValue, j10, j11);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0107 A[LOOP:0: B:3:0x0052->B:38:0x0107, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00de A[EDGE_INSN: B:39:0x00de->B:32:0x00de BREAK  A[LOOP:0: B:3:0x0052->B:38:0x0107], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public x5.c.a parseRepresentation(org.xmlpull.v1.XmlPullParser r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, int r24, float r25, int r26, int r27, java.lang.String r28, int r29, java.util.List<x5.d> r30, x5.h r31) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.c.parseRepresentation(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, int, java.util.List, x5.h):x5.c$a");
    }

    public int parseRole(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", null);
        String string2 = parseString(xmlPullParser, "value", null);
        do {
            xmlPullParser.next();
        } while (!v.isEndTag(xmlPullParser, "Role"));
        return ("urn:mpeg:dash:role:2011".equals(string) && "main".equals(string2)) ? 1 : 0;
    }

    public h.e parseSegmentBase(XmlPullParser xmlPullParser, h.e eVar) throws XmlPullParserException, NumberFormatException, IOException {
        long j10;
        long j11;
        long j12 = parseLong(xmlPullParser, "timescale", eVar != null ? eVar.f21601b : 1L);
        long j13 = parseLong(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f21602c : 0L);
        long j14 = eVar != null ? eVar.f21611d : 0L;
        long j15 = eVar != null ? eVar.f21612e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            j11 = Long.parseLong(strArrSplit[0]);
            j10 = (Long.parseLong(strArrSplit[1]) - j11) + 1;
        } else {
            j10 = j15;
            j11 = j14;
        }
        f initialization = eVar != null ? eVar.f21600a : null;
        do {
            xmlPullParser.next();
            if (v.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            }
        } while (!v.isEndTag(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(initialization, j12, j13, j11, j10);
    }

    public h.b parseSegmentList(XmlPullParser xmlPullParser, h.b bVar) throws XmlPullParserException, IOException {
        long j10 = parseLong(xmlPullParser, "timescale", bVar != null ? bVar.f21601b : 1L);
        long j11 = parseLong(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f21602c : 0L);
        long j12 = parseLong(xmlPullParser, "duration", bVar != null ? bVar.f21604e : -9223372036854775807L);
        int i10 = parseInt(xmlPullParser, "startNumber", bVar != null ? bVar.f21603d : 1);
        List<f> arrayList = null;
        f initialization = null;
        List<h.d> segmentTimeline = null;
        do {
            xmlPullParser.next();
            if (v.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (v.isStartTag(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser);
            } else if (v.isStartTag(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(parseSegmentUrl(xmlPullParser));
            }
        } while (!v.isEndTag(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (initialization == null) {
                initialization = bVar.f21600a;
            }
            if (segmentTimeline == null) {
                segmentTimeline = bVar.f21605f;
            }
            if (arrayList == null) {
                arrayList = bVar.f21606g;
            }
        }
        return buildSegmentList(initialization, j10, j11, i10, j12, segmentTimeline, arrayList);
    }

    public h.c parseSegmentTemplate(XmlPullParser xmlPullParser, h.c cVar) throws XmlPullParserException, IOException {
        long j10 = parseLong(xmlPullParser, "timescale", cVar != null ? cVar.f21601b : 1L);
        long j11 = parseLong(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f21602c : 0L);
        long j12 = parseLong(xmlPullParser, "duration", cVar != null ? cVar.f21604e : -9223372036854775807L);
        int i10 = parseInt(xmlPullParser, "startNumber", cVar != null ? cVar.f21603d : 1);
        f initialization = null;
        j urlTemplate = parseUrlTemplate(xmlPullParser, "media", cVar != null ? cVar.f21608h : null);
        j urlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", cVar != null ? cVar.f21607g : null);
        List<h.d> segmentTimeline = null;
        do {
            xmlPullParser.next();
            if (v.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (v.isStartTag(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser);
            }
        } while (!v.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (initialization == null) {
                initialization = cVar.f21600a;
            }
            if (segmentTimeline == null) {
                segmentTimeline = cVar.f21605f;
            }
        }
        return buildSegmentTemplate(initialization, j10, j11, i10, j12, segmentTimeline, urlTemplate2, urlTemplate);
    }

    public List<h.d> parseSegmentTimeline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j10 = 0;
        do {
            xmlPullParser.next();
            if (v.isStartTag(xmlPullParser, "S")) {
                j10 = parseLong(xmlPullParser, "t", j10);
                long j11 = parseLong(xmlPullParser, "d", -9223372036854775807L);
                int i10 = parseInt(xmlPullParser, "r", 0) + 1;
                for (int i11 = 0; i11 < i10; i11++) {
                    arrayList.add(buildSegmentTimelineElement(j10, j11));
                    j10 += j11;
                }
            }
        } while (!v.isEndTag(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    public f parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public j parseUrlTemplate(XmlPullParser xmlPullParser, String str, j jVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? j.compile(attributeValue) : jVar;
    }

    public k parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    public c(String str) {
        this.f21574a = str;
        try {
            this.f21575b = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0074a
    public b parse(Uri uri, InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f21575b.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return parseMediaPresentationDescription(xmlPullParserNewPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e10) {
            throw new ParserException(e10);
        }
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
    }
}
