package g6;

import android.util.Log;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: TtmlDecoder.java */
/* loaded from: classes.dex */
public final class a extends b6.b {

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f12732n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f12733o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f12734p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f12735q = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: r, reason: collision with root package name */
    public static final C0153a f12736r = new C0153a(30.0f, 1, 1);

    /* renamed from: m, reason: collision with root package name */
    public final XmlPullParserFactory f12737m;

    /* compiled from: TtmlDecoder.java */
    /* renamed from: g6.a$a, reason: collision with other inner class name */
    public static final class C0153a {

        /* renamed from: a, reason: collision with root package name */
        public final float f12738a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12739b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12740c;

        public C0153a(float f10, int i10, int i11) {
            this.f12738a = f10;
            this.f12739b = i10;
            this.f12740c = i11;
        }
    }

    public a() throws XmlPullParserException {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f12737m = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    public static e c(e eVar) {
        return eVar == null ? new e() : eVar;
    }

    public static boolean d(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    public static void e(String str, e eVar) throws SubtitleDecoderException {
        Matcher matcher;
        String strGroup;
        String[] strArrSplit = str.split("\\s+");
        int length = strArrSplit.length;
        Pattern pattern = f12734p;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                throw new SubtitleDecoderException(ac.c.m(new StringBuilder("Invalid number of entries for fontSize: "), strArrSplit.length, "."));
            }
            matcher = pattern.matcher(strArrSplit[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(ac.c.k("Invalid expression for fontSize: '", str, "'."));
        }
        strGroup = matcher.group(3);
        strGroup.getClass();
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                eVar.setFontSizeUnit(3);
                break;
            case "em":
                eVar.setFontSizeUnit(2);
                break;
            case "px":
                eVar.setFontSizeUnit(1);
                break;
            default:
                throw new SubtitleDecoderException(ac.c.k("Invalid unit for fontSize: '", strGroup, "'."));
        }
        eVar.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
    }

    public static C0153a f(XmlPullParser xmlPullParser) throws SubtitleDecoderException, NumberFormatException {
        float f10;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i10 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (attributeValue2.split(StringUtils.SPACE).length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f10 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f10 = 1.0f;
        }
        C0153a c0153a = f12736r;
        int i11 = c0153a.f12739b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i11 = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        return new C0153a(i10 * f10, i11, attributeValue4 != null ? Integer.parseInt(attributeValue4) : c0153a.f12740c);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g(org.xmlpull.v1.XmlPullParser r11, java.util.HashMap r12, java.util.HashMap r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.g(org.xmlpull.v1.XmlPullParser, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static g6.b h(org.xmlpull.v1.XmlPullParser r21, g6.b r22, java.util.HashMap r23, g6.a.C0153a r24) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.h(org.xmlpull.v1.XmlPullParser, g6.b, java.util.HashMap, g6.a$a):g6.b");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static g6.e i(org.xmlpull.v1.XmlPullParser r11, g6.e r12) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.i(org.xmlpull.v1.XmlPullParser, g6.e):g6.e");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:43:0x00cf. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long j(java.lang.String r13, g6.a.C0153a r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.a.j(java.lang.String, g6.a$a):long");
    }

    @Override // b6.b
    public f decode(byte[] bArr, int i10, boolean z10) throws XmlPullParserException, SubtitleDecoderException, NumberFormatException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f12737m.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            f fVar = null;
            map2.put("", new c(null));
            int i11 = 0;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i10), null);
            LinkedList linkedList = new LinkedList();
            C0153a c0153aF = f12736r;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                b bVar = (b) linkedList.peekLast();
                if (i11 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            c0153aF = f(xmlPullParserNewPullParser);
                        }
                        if (!d(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        } else if ("head".equals(name)) {
                            g(xmlPullParserNewPullParser, map, map2);
                        } else {
                            try {
                                b bVarH = h(xmlPullParserNewPullParser, bVar, map2, c0153aF);
                                linkedList.addLast(bVarH);
                                if (bVar != null) {
                                    bVar.addChild(bVarH);
                                }
                            } catch (SubtitleDecoderException e10) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e10);
                            }
                        }
                        i11++;
                    } else if (eventType == 4) {
                        bVar.addChild(b.buildTextNode(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            fVar = new f((b) linkedList.getLast(), map, map2);
                        }
                        linkedList.removeLast();
                    }
                } else if (eventType == 2) {
                    i11++;
                } else if (eventType == 3) {
                    i11--;
                }
                xmlPullParserNewPullParser.next();
            }
            return fVar;
        } catch (IOException e11) {
            throw new IllegalStateException("Unexpected error when reading input.", e11);
        } catch (XmlPullParserException e12) {
            throw new SubtitleDecoderException("Unable to decode source", e12);
        }
    }
}
