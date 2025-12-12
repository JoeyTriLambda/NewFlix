package n0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: FontResourcesParserCompat.java */
    public static class a {
        public static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    public interface b {
    }

    /* compiled from: FontResourcesParserCompat.java */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final C0204d[] f16410a;

        public c(C0204d[] c0204dArr) {
            this.f16410a = c0204dArr;
        }

        public C0204d[] getEntries() {
            return this.f16410a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: n0.d$d, reason: collision with other inner class name */
    public static final class C0204d {

        /* renamed from: a, reason: collision with root package name */
        public final String f16411a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16412b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16413c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16414d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16415e;

        /* renamed from: f, reason: collision with root package name */
        public final int f16416f;

        public C0204d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f16411a = str;
            this.f16412b = i10;
            this.f16413c = z10;
            this.f16414d = str2;
            this.f16415e = i11;
            this.f16416f = i12;
        }

        public String getFileName() {
            return this.f16411a;
        }

        public int getResourceId() {
            return this.f16416f;
        }

        public int getTtcIndex() {
            return this.f16415e;
        }

        public String getVariationSettings() {
            return this.f16414d;
        }

        public int getWeight() {
            return this.f16412b;
        }

        public boolean isItalic() {
            return this.f16413c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    public static final class e implements b {

        /* renamed from: a, reason: collision with root package name */
        public final u0.g f16417a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16418b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16419c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16420d;

        public e(u0.g gVar, int i10, int i11, String str) {
            this.f16417a = gVar;
            this.f16419c = i10;
            this.f16418b = i11;
            this.f16420d = str;
        }

        public int getFetchStrategy() {
            return this.f16419c;
        }

        public u0.g getRequest() {
            return this.f16417a;
        }

        public String getSystemFontFamilyName() {
            return this.f16420d;
        }

        public int getTimeout() {
            return this.f16418b;
        }
    }

    public static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    public static b parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlPullParser.require(2, null, "font-family");
        if (!xmlPullParser.getName().equals("font-family")) {
            a(xmlPullParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new e(new u0.g(string, string2, string3, readCerts(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
                    int i10 = R.styleable.FontFamilyFont_fontWeight;
                    if (!typedArrayObtainAttributes2.hasValue(i10)) {
                        i10 = R.styleable.FontFamilyFont_android_fontWeight;
                    }
                    int i11 = typedArrayObtainAttributes2.getInt(i10, HttpStatus.SC_BAD_REQUEST);
                    int i12 = R.styleable.FontFamilyFont_fontStyle;
                    if (!typedArrayObtainAttributes2.hasValue(i12)) {
                        i12 = R.styleable.FontFamilyFont_android_fontStyle;
                    }
                    boolean z10 = 1 == typedArrayObtainAttributes2.getInt(i12, 0);
                    int i13 = R.styleable.FontFamilyFont_ttcIndex;
                    if (!typedArrayObtainAttributes2.hasValue(i13)) {
                        i13 = R.styleable.FontFamilyFont_android_ttcIndex;
                    }
                    int i14 = R.styleable.FontFamilyFont_fontVariationSettings;
                    if (!typedArrayObtainAttributes2.hasValue(i14)) {
                        i14 = R.styleable.FontFamilyFont_android_fontVariationSettings;
                    }
                    String string5 = typedArrayObtainAttributes2.getString(i14);
                    int i15 = typedArrayObtainAttributes2.getInt(i13, 0);
                    int i16 = R.styleable.FontFamilyFont_font;
                    if (!typedArrayObtainAttributes2.hasValue(i16)) {
                        i16 = R.styleable.FontFamilyFont_android_font;
                    }
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i16, 0);
                    String string6 = typedArrayObtainAttributes2.getString(i16);
                    typedArrayObtainAttributes2.recycle();
                    while (xmlPullParser.next() != 3) {
                        a(xmlPullParser);
                    }
                    arrayList.add(new C0204d(string6, i11, z10, string5, i15, resourceId2));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((C0204d[]) arrayList.toArray(new C0204d[0]));
    }

    public static List<List<byte[]>> readCerts(Resources resources, int i10) throws Resources.NotFoundException {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a.a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < typedArrayObtainTypedArray.length(); i11++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i10);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }
}
