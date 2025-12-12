package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import c5.i;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.a;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.UUID;
import k5.h;
import l6.u;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public final class SsManifestParser implements a.InterfaceC0074a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f5961a;

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super(ac.c.j("Missing required field: ", str));
        }
    }

    public static class b extends a {

        /* renamed from: e, reason: collision with root package name */
        public boolean f5966e;

        /* renamed from: f, reason: collision with root package name */
        public UUID f5967f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f5968g;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object build() {
            UUID uuid = this.f5967f;
            return new a.C0073a(uuid, h.buildPsshAtom(uuid, this.f5968g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean handleChildInline(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void parseEndTag(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f5966e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void parseStartTag(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f5966e = true;
                String attributeValue = xmlPullParser.getAttributeValue(null, "SystemID");
                if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                    attributeValue = attributeValue.substring(1, attributeValue.length() - 1);
                }
                this.f5967f = UUID.fromString(attributeValue);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void parseText(XmlPullParser xmlPullParser) {
            if (this.f5966e) {
                this.f5968g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class c extends a {

        /* renamed from: e, reason: collision with root package name */
        public i f5969e;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        public static ArrayList a(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] bytesFromHexString = u.getBytesFromHexString(str);
                byte[][] bArrSplitNalUnits = l6.c.splitNalUnits(bytesFromHexString);
                if (bArrSplitNalUnits == null) {
                    arrayList.add(bytesFromHexString);
                } else {
                    Collections.addAll(arrayList, bArrSplitNalUnits);
                }
            }
            return arrayList;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object build() {
            return this.f5969e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v11, types: [java.util.List] */
        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            int iIntValue = ((Integer) getNormalizedAttribute("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue(null, "Index");
            int requiredInt = parseRequiredInt(xmlPullParser, "Bitrate");
            String requiredString = parseRequiredString(xmlPullParser, "FourCC");
            String str = (requiredString.equalsIgnoreCase("H264") || requiredString.equalsIgnoreCase("X264") || requiredString.equalsIgnoreCase("AVC1") || requiredString.equalsIgnoreCase("DAVC")) ? MimeTypes.VIDEO_H264 : (requiredString.equalsIgnoreCase("AAC") || requiredString.equalsIgnoreCase("AACL") || requiredString.equalsIgnoreCase("AACH") || requiredString.equalsIgnoreCase("AACP")) ? "audio/mp4a-latm" : requiredString.equalsIgnoreCase("TTML") ? "application/ttml+xml" : (requiredString.equalsIgnoreCase("ac-3") || requiredString.equalsIgnoreCase("dac3")) ? "audio/ac3" : (requiredString.equalsIgnoreCase("ec-3") || requiredString.equalsIgnoreCase("dec3")) ? "audio/eac3" : requiredString.equalsIgnoreCase("dtsc") ? "audio/vnd.dts" : (requiredString.equalsIgnoreCase("dtsh") || requiredString.equalsIgnoreCase("dtsl")) ? "audio/vnd.dts.hd" : requiredString.equalsIgnoreCase("dtse") ? "audio/vnd.dts.hd;profile=lbr" : requiredString.equalsIgnoreCase("opus") ? "audio/opus" : null;
            if (iIntValue == 2) {
                this.f5969e = i.createVideoContainerFormat(attributeValue, "video/mp4", str, null, requiredInt, parseRequiredInt(xmlPullParser, "MaxWidth"), parseRequiredInt(xmlPullParser, "MaxHeight"), -1.0f, a(xmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
                return;
            }
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    this.f5969e = i.createTextContainerFormat(attributeValue, "application/mp4", str, null, requiredInt, 0, (String) getNormalizedAttribute("Language"));
                    return;
                } else {
                    this.f5969e = i.createContainerFormat(attributeValue, "application/mp4", str, null, requiredInt, 0, null);
                    return;
                }
            }
            if (str == null) {
                str = "audio/mp4a-latm";
            }
            int requiredInt2 = parseRequiredInt(xmlPullParser, "Channels");
            int requiredInt3 = parseRequiredInt(xmlPullParser, "SamplingRate");
            ArrayList arrayListA = a(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
            boolean zIsEmpty = arrayListA.isEmpty();
            ArrayList arrayListSingletonList = arrayListA;
            if (zIsEmpty) {
                arrayListSingletonList = arrayListA;
                if ("audio/mp4a-latm".equals(str)) {
                    arrayListSingletonList = Collections.singletonList(l6.c.buildAacLcAudioSpecificConfig(requiredInt3, requiredInt2));
                }
            }
            this.f5969e = i.createAudioContainerFormat(attributeValue, "audio/mp4", str, null, requiredInt, requiredInt2, requiredInt3, arrayListSingletonList, 0, (String) getNormalizedAttribute("Language"));
        }
    }

    public static class d extends a {

        /* renamed from: e, reason: collision with root package name */
        public final LinkedList f5970e;

        /* renamed from: f, reason: collision with root package name */
        public int f5971f;

        /* renamed from: g, reason: collision with root package name */
        public int f5972g;

        /* renamed from: h, reason: collision with root package name */
        public long f5973h;

        /* renamed from: i, reason: collision with root package name */
        public long f5974i;

        /* renamed from: j, reason: collision with root package name */
        public long f5975j;

        /* renamed from: k, reason: collision with root package name */
        public int f5976k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f5977l;

        /* renamed from: m, reason: collision with root package name */
        public a.C0073a f5978m;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.f5976k = -1;
            this.f5978m = null;
            this.f5970e = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void addChild(Object obj) {
            if (obj instanceof a.b) {
                this.f5970e.add((a.b) obj);
            } else if (obj instanceof a.C0073a) {
                l6.a.checkState(this.f5978m == null);
                this.f5978m = (a.C0073a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object build() {
            LinkedList linkedList = this.f5970e;
            int size = linkedList.size();
            a.b[] bVarArr = new a.b[size];
            linkedList.toArray(bVarArr);
            a.C0073a c0073a = this.f5978m;
            if (c0073a != null) {
                com.google.android.exoplayer2.drm.c cVar = new com.google.android.exoplayer2.drm.c(new c.b(c0073a.f5998a, null, "video/mp4", c0073a.f5999b));
                for (int i10 = 0; i10 < size; i10++) {
                    a.b bVar = bVarArr[i10];
                    int i11 = 0;
                    while (true) {
                        i[] iVarArr = bVar.f6002c;
                        if (i11 < iVarArr.length) {
                            iVarArr[i11] = iVarArr[i11].copyWithDrmInitData(cVar);
                            i11++;
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.f5971f, this.f5972g, this.f5973h, this.f5974i, this.f5975j, this.f5976k, this.f5977l, this.f5978m, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            this.f5971f = parseRequiredInt(xmlPullParser, "MajorVersion");
            this.f5972g = parseRequiredInt(xmlPullParser, "MinorVersion");
            this.f5973h = parseLong(xmlPullParser, "TimeScale", 10000000L);
            this.f5974i = parseRequiredLong(xmlPullParser, "Duration");
            this.f5975j = parseLong(xmlPullParser, "DVRWindowLength", 0L);
            this.f5976k = parseInt(xmlPullParser, "LookaheadCount", -1);
            this.f5977l = parseBoolean(xmlPullParser, "IsLive", false);
            putNormalizedAttribute("TimeScale", Long.valueOf(this.f5973h));
        }
    }

    public static class e extends a {

        /* renamed from: e, reason: collision with root package name */
        public final String f5979e;

        /* renamed from: f, reason: collision with root package name */
        public final LinkedList f5980f;

        /* renamed from: g, reason: collision with root package name */
        public int f5981g;

        /* renamed from: h, reason: collision with root package name */
        public String f5982h;

        /* renamed from: i, reason: collision with root package name */
        public long f5983i;

        /* renamed from: j, reason: collision with root package name */
        public String f5984j;

        /* renamed from: k, reason: collision with root package name */
        public String f5985k;

        /* renamed from: l, reason: collision with root package name */
        public int f5986l;

        /* renamed from: m, reason: collision with root package name */
        public int f5987m;

        /* renamed from: n, reason: collision with root package name */
        public int f5988n;

        /* renamed from: o, reason: collision with root package name */
        public int f5989o;

        /* renamed from: p, reason: collision with root package name */
        public String f5990p;

        /* renamed from: q, reason: collision with root package name */
        public ArrayList<Long> f5991q;

        /* renamed from: r, reason: collision with root package name */
        public long f5992r;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f5979e = str;
            this.f5980f = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void addChild(Object obj) {
            if (obj instanceof i) {
                this.f5980f.add((i) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object build() {
            LinkedList linkedList = this.f5980f;
            i[] iVarArr = new i[linkedList.size()];
            linkedList.toArray(iVarArr);
            return new a.b(this.f5979e, this.f5985k, this.f5981g, this.f5982h, this.f5983i, this.f5984j, this.f5986l, this.f5987m, this.f5988n, this.f5989o, this.f5990p, iVarArr, this.f5991q, this.f5992r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean handleChildInline(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            int i10 = 1;
            if (!"c".equals(xmlPullParser.getName())) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
                if (attributeValue == null) {
                    throw new MissingFieldException("Type");
                }
                if (!MimeTypes.BASE_TYPE_AUDIO.equalsIgnoreCase(attributeValue)) {
                    if (MimeTypes.BASE_TYPE_VIDEO.equalsIgnoreCase(attributeValue)) {
                        i10 = 2;
                    } else {
                        if (!"text".equalsIgnoreCase(attributeValue)) {
                            throw new ParserException(ac.c.k("Invalid key value[", attributeValue, "]"));
                        }
                        i10 = 3;
                    }
                }
                this.f5981g = i10;
                putNormalizedAttribute("Type", Integer.valueOf(i10));
                if (this.f5981g == 3) {
                    this.f5982h = parseRequiredString(xmlPullParser, "Subtype");
                } else {
                    this.f5982h = xmlPullParser.getAttributeValue(null, "Subtype");
                }
                this.f5984j = xmlPullParser.getAttributeValue(null, "Name");
                this.f5985k = parseRequiredString(xmlPullParser, "Url");
                this.f5986l = parseInt(xmlPullParser, "MaxWidth", -1);
                this.f5987m = parseInt(xmlPullParser, "MaxHeight", -1);
                this.f5988n = parseInt(xmlPullParser, "DisplayWidth", -1);
                this.f5989o = parseInt(xmlPullParser, "DisplayHeight", -1);
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
                this.f5990p = attributeValue2;
                putNormalizedAttribute("Language", attributeValue2);
                long j10 = parseInt(xmlPullParser, "TimeScale", -1);
                this.f5983i = j10;
                if (j10 == -1) {
                    this.f5983i = ((Long) getNormalizedAttribute("TimeScale")).longValue();
                }
                this.f5991q = new ArrayList<>();
                return;
            }
            int size = this.f5991q.size();
            long jLongValue = parseLong(xmlPullParser, "t", -9223372036854775807L);
            if (jLongValue == -9223372036854775807L) {
                if (size == 0) {
                    jLongValue = 0;
                } else {
                    if (this.f5992r == -1) {
                        throw new ParserException("Unable to infer start time");
                    }
                    jLongValue = this.f5992r + this.f5991q.get(size - 1).longValue();
                }
            }
            this.f5991q.add(Long.valueOf(jLongValue));
            this.f5992r = parseLong(xmlPullParser, "d", -9223372036854775807L);
            long j11 = parseLong(xmlPullParser, "r", 1L);
            if (j11 > 1 && this.f5992r == -9223372036854775807L) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j12 = i10;
                if (j12 >= j11) {
                    return;
                }
                this.f5991q.add(Long.valueOf((this.f5992r * j12) + jLongValue));
                i10++;
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f5961a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0074a
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a parse(Uri uri, InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f5961a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e10) {
            throw new ParserException(e10);
        }
    }

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5962a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5963b;

        /* renamed from: c, reason: collision with root package name */
        public final a f5964c;

        /* renamed from: d, reason: collision with root package name */
        public final LinkedList f5965d = new LinkedList();

        public a(a aVar, String str, String str2) {
            this.f5964c = aVar;
            this.f5962a = str;
            this.f5963b = str2;
        }

        public abstract Object build();

        public final Object getNormalizedAttribute(String str) {
            int i10 = 0;
            while (true) {
                LinkedList linkedList = this.f5965d;
                if (i10 >= linkedList.size()) {
                    a aVar = this.f5964c;
                    if (aVar == null) {
                        return null;
                    }
                    return aVar.getNormalizedAttribute(str);
                }
                Pair pair = (Pair) linkedList.get(i10);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
                i10++;
            }
        }

        public boolean handleChildInline(String str) {
            return false;
        }

        public final Object parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                a eVar = null;
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f5963b.equals(name)) {
                        parseStartTag(xmlPullParser);
                        z10 = true;
                    } else if (z10) {
                        if (i10 > 0) {
                            i10++;
                        } else if (handleChildInline(name)) {
                            parseStartTag(xmlPullParser);
                        } else {
                            boolean zEquals = "QualityLevel".equals(name);
                            String str = this.f5962a;
                            if (zEquals) {
                                eVar = new c(this, str);
                            } else if ("Protection".equals(name)) {
                                eVar = new b(this, str);
                            } else if ("StreamIndex".equals(name)) {
                                eVar = new e(this, str);
                            }
                            if (eVar == null) {
                                i10 = 1;
                            } else {
                                addChild(eVar.parse(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z10 && i10 == 0) {
                        parseText(xmlPullParser);
                    }
                } else if (!z10) {
                    continue;
                } else if (i10 > 0) {
                    i10--;
                } else {
                    String name2 = xmlPullParser.getName();
                    parseEndTag(xmlPullParser);
                    if (!handleChildInline(name2)) {
                        return build();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean parseBoolean(XmlPullParser xmlPullParser, String str, boolean z10) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z10;
        }

        public final int parseInt(XmlPullParser xmlPullParser, String str, int i10) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i10;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final long parseLong(XmlPullParser xmlPullParser, String str, long j10) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j10;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final int parseRequiredInt(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final long parseRequiredLong(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final String parseRequiredString(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public abstract void parseStartTag(XmlPullParser xmlPullParser) throws ParserException;

        public final void putNormalizedAttribute(String str, Object obj) {
            this.f5965d.add(Pair.create(str, obj));
        }

        public void addChild(Object obj) {
        }

        public void parseEndTag(XmlPullParser xmlPullParser) {
        }

        public void parseText(XmlPullParser xmlPullParser) {
        }
    }
}
