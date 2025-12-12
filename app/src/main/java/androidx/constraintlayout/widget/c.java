package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: ConstraintLayoutStates.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f1958a;

    /* renamed from: b, reason: collision with root package name */
    public int f1959b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f1960c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray<a> f1961d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray<d> f1962e = new SparseArray<>();

    /* compiled from: ConstraintLayoutStates.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1963a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f1964b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public final int f1965c;

        /* renamed from: d, reason: collision with root package name */
        public final d f1966d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f1965c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f1963a = typedArrayObtainStyledAttributes.getResourceId(index, this.f1963a);
                } else if (index == R.styleable.State_constraints) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1965c);
                    this.f1965c = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1966d = dVar;
                        dVar.clone(context, resourceId);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public int findMatch(float f10, float f11) {
            int i10 = 0;
            while (true) {
                ArrayList<b> arrayList = this.f1964b;
                if (i10 >= arrayList.size()) {
                    return -1;
                }
                if (arrayList.get(i10).a(f10, f11)) {
                    return i10;
                }
                i10++;
            }
        }
    }

    /* compiled from: ConstraintLayoutStates.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f1967a;

        /* renamed from: b, reason: collision with root package name */
        public final float f1968b;

        /* renamed from: c, reason: collision with root package name */
        public final float f1969c;

        /* renamed from: d, reason: collision with root package name */
        public final float f1970d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1971e;

        /* renamed from: f, reason: collision with root package name */
        public final d f1972f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f1967a = Float.NaN;
            this.f1968b = Float.NaN;
            this.f1969c = Float.NaN;
            this.f1970d = Float.NaN;
            this.f1971e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1971e);
                    this.f1971e = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1972f = dVar;
                        dVar.clone(context, resourceId);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f1970d = typedArrayObtainStyledAttributes.getDimension(index, this.f1970d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f1968b = typedArrayObtainStyledAttributes.getDimension(index, this.f1968b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f1969c = typedArrayObtainStyledAttributes.getDimension(index, this.f1969c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f1967a = typedArrayObtainStyledAttributes.getDimension(index, this.f1967a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final boolean a(float f10, float f11) {
            float f12 = this.f1967a;
            if (!Float.isNaN(f12) && f10 < f12) {
                return false;
            }
            float f13 = this.f1968b;
            if (!Float.isNaN(f13) && f11 < f13) {
                return false;
            }
            float f14 = this.f1969c;
            if (!Float.isNaN(f14) && f10 > f14) {
                return false;
            }
            float f15 = this.f1970d;
            return Float.isNaN(f15) || f11 <= f15;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r8, androidx.constraintlayout.widget.ConstraintLayout r9, int r10) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r7 = this;
            r7.<init>()
            r0 = -1
            r7.f1959b = r0
            r7.f1960c = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.f1961d = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.f1962e = r1
            r7.f1958a = r9
            android.content.res.Resources r9 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r9.getXml(r10)
            int r10 = r9.getEventType()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r1 = 0
        L25:
            r2 = 1
            if (r10 == r2) goto La6
            if (r10 == 0) goto L95
            r3 = 2
            if (r10 == r3) goto L2f
            goto L98
        L2f:
            java.lang.String r10 = r9.getName()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            int r4 = r10.hashCode()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L64;
                case 80204913: goto L5a;
                case 1382829617: goto L51;
                case 1657696882: goto L47;
                case 1901439077: goto L3d;
                default: goto L3c;
            }     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
        L3c:
            goto L6e
        L3d:
            java.lang.String r2 = "Variant"
            boolean r10 = r10.equals(r2)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            if (r10 == 0) goto L6e
            r2 = 3
            goto L6f
        L47:
            java.lang.String r2 = "layoutDescription"
            boolean r10 = r10.equals(r2)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            if (r10 == 0) goto L6e
            r2 = 0
            goto L6f
        L51:
            java.lang.String r4 = "StateSet"
            boolean r10 = r10.equals(r4)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            if (r10 == 0) goto L6e
            goto L6f
        L5a:
            java.lang.String r2 = "State"
            boolean r10 = r10.equals(r2)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            if (r10 == 0) goto L6e
            r2 = 2
            goto L6f
        L64:
            java.lang.String r2 = "ConstraintSet"
            boolean r10 = r10.equals(r2)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            if (r10 == 0) goto L6e
            r2 = 4
            goto L6f
        L6e:
            r2 = -1
        L6f:
            if (r2 == r3) goto L87
            if (r2 == r6) goto L7a
            if (r2 == r5) goto L76
            goto L98
        L76:
            r7.a(r8, r9)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            goto L98
        L7a:
            androidx.constraintlayout.widget.c$b r10 = new androidx.constraintlayout.widget.c$b     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r10.<init>(r8, r9)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            if (r1 == 0) goto L98
            java.util.ArrayList<androidx.constraintlayout.widget.c$b> r2 = r1.f1964b     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r2.add(r10)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            goto L98
        L87:
            androidx.constraintlayout.widget.c$a r10 = new androidx.constraintlayout.widget.c$a     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r10.<init>(r8, r9)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            android.util.SparseArray<androidx.constraintlayout.widget.c$a> r1 = r7.f1961d     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            int r2 = r10.f1963a     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r1.put(r2, r10)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            r1 = r10
            goto L98
        L95:
            r9.getName()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
        L98:
            int r10 = r9.next()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> La2
            goto L25
        L9d:
            r8 = move-exception
            r8.printStackTrace()
            goto La6
        La2:
            r8 = move-exception
            r8.printStackTrace()
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.<init>(android.content.Context, androidx.constraintlayout.widget.ConstraintLayout, int):void");
    }

    public final void a(Context context, XmlResourceParser xmlResourceParser) throws NumberFormatException {
        d dVar = new d();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlResourceParser.getAttributeName(i10);
            String attributeValue = xmlResourceParser.getAttributeValue(i10);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.load(context, xmlResourceParser);
                this.f1962e.put(identifier, dVar);
                return;
            }
        }
    }

    public void updateConstraints(int i10, float f10, float f11) {
        int iFindMatch;
        int i11 = this.f1959b;
        ConstraintLayout constraintLayout = this.f1958a;
        SparseArray<a> sparseArray = this.f1961d;
        if (i11 == i10) {
            a aVarValueAt = i10 == -1 ? sparseArray.valueAt(0) : sparseArray.get(i11);
            int i12 = this.f1960c;
            if ((i12 == -1 || !aVarValueAt.f1964b.get(i12).a(f10, f11)) && this.f1960c != (iFindMatch = aVarValueAt.findMatch(f10, f11))) {
                ArrayList<b> arrayList = aVarValueAt.f1964b;
                d dVar = iFindMatch == -1 ? null : arrayList.get(iFindMatch).f1972f;
                if (iFindMatch != -1) {
                    int i13 = arrayList.get(iFindMatch).f1971e;
                }
                if (dVar == null) {
                    return;
                }
                this.f1960c = iFindMatch;
                dVar.applyTo(constraintLayout);
                return;
            }
            return;
        }
        this.f1959b = i10;
        a aVar = sparseArray.get(i10);
        int iFindMatch2 = aVar.findMatch(f10, f11);
        ArrayList<b> arrayList2 = aVar.f1964b;
        d dVar2 = iFindMatch2 == -1 ? aVar.f1966d : arrayList2.get(iFindMatch2).f1972f;
        if (iFindMatch2 != -1) {
            int i14 = arrayList2.get(iFindMatch2).f1971e;
        }
        if (dVar2 != null) {
            this.f1960c = iFindMatch2;
            dVar2.applyTo(constraintLayout);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
    }

    public void setOnConstraintsChanged(j0.a aVar) {
    }
}
