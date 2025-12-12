package r6;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R;
import i7.r;
import java.io.IOException;
import java.util.Locale;
import n7.d;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: BadgeState.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f18622a;

    /* renamed from: b, reason: collision with root package name */
    public final a f18623b;

    /* renamed from: c, reason: collision with root package name */
    public final float f18624c;

    /* renamed from: d, reason: collision with root package name */
    public final float f18625d;

    /* renamed from: e, reason: collision with root package name */
    public final float f18626e;

    /* renamed from: f, reason: collision with root package name */
    public final float f18627f;

    /* renamed from: g, reason: collision with root package name */
    public final float f18628g;

    /* renamed from: h, reason: collision with root package name */
    public final float f18629h;

    /* renamed from: i, reason: collision with root package name */
    public final int f18630i;

    /* renamed from: j, reason: collision with root package name */
    public final int f18631j;

    /* renamed from: k, reason: collision with root package name */
    public final int f18632k;

    public b(Context context) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet drawableXml;
        int styleAttribute;
        int i10 = r6.a.f18608z;
        int i11 = r6.a.f18607y;
        a aVar = new a();
        this.f18623b = aVar;
        a aVar2 = new a();
        int i12 = aVar2.f18633b;
        if (i12 != 0) {
            drawableXml = e7.a.parseDrawableXml(context, i12, "badge");
            styleAttribute = drawableXml.getStyleAttribute();
        } else {
            drawableXml = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context, drawableXml, R.styleable.Badge, i10, styleAttribute == 0 ? i11 : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f18624c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.f18630i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.f18631j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f18625d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        int i13 = R.styleable.Badge_badgeWidth;
        int i14 = R.dimen.m3_badge_size;
        this.f18626e = typedArrayObtainStyledAttributes.getDimension(i13, resources.getDimension(i14));
        int i15 = R.styleable.Badge_badgeWithTextWidth;
        int i16 = R.dimen.m3_badge_with_text_size;
        this.f18628g = typedArrayObtainStyledAttributes.getDimension(i15, resources.getDimension(i16));
        this.f18627f = typedArrayObtainStyledAttributes.getDimension(R.styleable.Badge_badgeHeight, resources.getDimension(i14));
        this.f18629h = typedArrayObtainStyledAttributes.getDimension(R.styleable.Badge_badgeWithTextHeight, resources.getDimension(i16));
        boolean z10 = true;
        this.f18632k = typedArrayObtainStyledAttributes.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        int i17 = aVar2.f18641t;
        aVar.f18641t = i17 == -2 ? 255 : i17;
        int i18 = aVar2.f18643v;
        if (i18 != -2) {
            aVar.f18643v = i18;
        } else {
            int i19 = R.styleable.Badge_number;
            if (typedArrayObtainStyledAttributes.hasValue(i19)) {
                aVar.f18643v = typedArrayObtainStyledAttributes.getInt(i19, 0);
            } else {
                aVar.f18643v = -1;
            }
        }
        String str = aVar2.f18642u;
        if (str != null) {
            aVar.f18642u = str;
        } else {
            int i20 = R.styleable.Badge_badgeText;
            if (typedArrayObtainStyledAttributes.hasValue(i20)) {
                aVar.f18642u = typedArrayObtainStyledAttributes.getString(i20);
            }
        }
        aVar.f18647z = aVar2.f18647z;
        CharSequence charSequence = aVar2.A;
        aVar.A = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        int i21 = aVar2.B;
        aVar.B = i21 == 0 ? R.plurals.mtrl_badge_content_description : i21;
        int i22 = aVar2.C;
        aVar.C = i22 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i22;
        Boolean bool = aVar2.E;
        if (bool != null && !bool.booleanValue()) {
            z10 = false;
        }
        aVar.E = Boolean.valueOf(z10);
        int i23 = aVar2.f18644w;
        aVar.f18644w = i23 == -2 ? typedArrayObtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, -2) : i23;
        int i24 = aVar2.f18645x;
        aVar.f18645x = i24 == -2 ? typedArrayObtainStyledAttributes.getInt(R.styleable.Badge_maxNumber, -2) : i24;
        Integer num = aVar2.f18637p;
        aVar.f18637p = Integer.valueOf(num == null ? typedArrayObtainStyledAttributes.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        Integer num2 = aVar2.f18638q;
        aVar.f18638q = Integer.valueOf(num2 == null ? typedArrayObtainStyledAttributes.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0) : num2.intValue());
        Integer num3 = aVar2.f18639r;
        aVar.f18639r = Integer.valueOf(num3 == null ? typedArrayObtainStyledAttributes.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        Integer num4 = aVar2.f18640s;
        aVar.f18640s = Integer.valueOf(num4 == null ? typedArrayObtainStyledAttributes.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : num4.intValue());
        Integer num5 = aVar2.f18634m;
        aVar.f18634m = Integer.valueOf(num5 == null ? n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.Badge_backgroundColor).getDefaultColor() : num5.intValue());
        Integer num6 = aVar2.f18636o;
        aVar.f18636o = Integer.valueOf(num6 == null ? typedArrayObtainStyledAttributes.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = aVar2.f18635n;
        if (num7 != null) {
            aVar.f18635n = num7;
        } else {
            int i25 = R.styleable.Badge_badgeTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i25)) {
                aVar.f18635n = Integer.valueOf(n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, i25).getDefaultColor());
            } else {
                aVar.f18635n = Integer.valueOf(new d(context, aVar.f18636o.intValue()).getTextColor().getDefaultColor());
            }
        }
        Integer num8 = aVar2.D;
        aVar.D = Integer.valueOf(num8 == null ? typedArrayObtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, 8388661) : num8.intValue());
        Integer num9 = aVar2.F;
        aVar.F = Integer.valueOf(num9 == null ? typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        Integer num10 = aVar2.G;
        aVar.G = Integer.valueOf(num10 == null ? typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        Integer num11 = aVar2.H;
        aVar.H = Integer.valueOf(num11 == null ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0) : num11.intValue());
        Integer num12 = aVar2.I;
        aVar.I = Integer.valueOf(num12 == null ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0) : num12.intValue());
        Integer num13 = aVar2.J;
        aVar.J = Integer.valueOf(num13 == null ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, aVar.H.intValue()) : num13.intValue());
        Integer num14 = aVar2.K;
        aVar.K = Integer.valueOf(num14 == null ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, aVar.I.intValue()) : num14.intValue());
        Integer num15 = aVar2.N;
        aVar.N = Integer.valueOf(num15 == null ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : num15.intValue());
        Integer num16 = aVar2.L;
        aVar.L = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        Integer num17 = aVar2.M;
        aVar.M = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        Boolean bool2 = aVar2.O;
        aVar.O = Boolean.valueOf(bool2 == null ? typedArrayObtainStyledAttributes.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : bool2.booleanValue());
        typedArrayObtainStyledAttributes.recycle();
        Locale locale = aVar2.f18646y;
        if (locale == null) {
            aVar.f18646y = Build.VERSION.SDK_INT >= 24 ? Locale.getDefault(Locale.Category.FORMAT) : Locale.getDefault();
        } else {
            aVar.f18646y = locale;
        }
        this.f18622a = aVar2;
    }

    /* compiled from: BadgeState.java */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0240a();
        public CharSequence A;
        public int B;
        public int C;
        public Integer D;
        public Boolean E;
        public Integer F;
        public Integer G;
        public Integer H;
        public Integer I;
        public Integer J;
        public Integer K;
        public Integer L;
        public Integer M;
        public Integer N;
        public Boolean O;

        /* renamed from: b, reason: collision with root package name */
        public int f18633b;

        /* renamed from: m, reason: collision with root package name */
        public Integer f18634m;

        /* renamed from: n, reason: collision with root package name */
        public Integer f18635n;

        /* renamed from: o, reason: collision with root package name */
        public Integer f18636o;

        /* renamed from: p, reason: collision with root package name */
        public Integer f18637p;

        /* renamed from: q, reason: collision with root package name */
        public Integer f18638q;

        /* renamed from: r, reason: collision with root package name */
        public Integer f18639r;

        /* renamed from: s, reason: collision with root package name */
        public Integer f18640s;

        /* renamed from: t, reason: collision with root package name */
        public int f18641t;

        /* renamed from: u, reason: collision with root package name */
        public String f18642u;

        /* renamed from: v, reason: collision with root package name */
        public int f18643v;

        /* renamed from: w, reason: collision with root package name */
        public int f18644w;

        /* renamed from: x, reason: collision with root package name */
        public int f18645x;

        /* renamed from: y, reason: collision with root package name */
        public Locale f18646y;

        /* renamed from: z, reason: collision with root package name */
        public CharSequence f18647z;

        /* compiled from: BadgeState.java */
        /* renamed from: r6.b$a$a, reason: collision with other inner class name */
        public class C0240a implements Parcelable.Creator<a> {
            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i10) {
                return new a[i10];
            }
        }

        public a() {
            this.f18641t = 255;
            this.f18643v = -2;
            this.f18644w = -2;
            this.f18645x = -2;
            this.E = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f18633b);
            parcel.writeSerializable(this.f18634m);
            parcel.writeSerializable(this.f18635n);
            parcel.writeSerializable(this.f18636o);
            parcel.writeSerializable(this.f18637p);
            parcel.writeSerializable(this.f18638q);
            parcel.writeSerializable(this.f18639r);
            parcel.writeSerializable(this.f18640s);
            parcel.writeInt(this.f18641t);
            parcel.writeString(this.f18642u);
            parcel.writeInt(this.f18643v);
            parcel.writeInt(this.f18644w);
            parcel.writeInt(this.f18645x);
            CharSequence charSequence = this.f18647z;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.A;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.B);
            parcel.writeSerializable(this.D);
            parcel.writeSerializable(this.F);
            parcel.writeSerializable(this.G);
            parcel.writeSerializable(this.H);
            parcel.writeSerializable(this.I);
            parcel.writeSerializable(this.J);
            parcel.writeSerializable(this.K);
            parcel.writeSerializable(this.N);
            parcel.writeSerializable(this.L);
            parcel.writeSerializable(this.M);
            parcel.writeSerializable(this.E);
            parcel.writeSerializable(this.f18646y);
            parcel.writeSerializable(this.O);
        }

        public a(Parcel parcel) {
            this.f18641t = 255;
            this.f18643v = -2;
            this.f18644w = -2;
            this.f18645x = -2;
            this.E = Boolean.TRUE;
            this.f18633b = parcel.readInt();
            this.f18634m = (Integer) parcel.readSerializable();
            this.f18635n = (Integer) parcel.readSerializable();
            this.f18636o = (Integer) parcel.readSerializable();
            this.f18637p = (Integer) parcel.readSerializable();
            this.f18638q = (Integer) parcel.readSerializable();
            this.f18639r = (Integer) parcel.readSerializable();
            this.f18640s = (Integer) parcel.readSerializable();
            this.f18641t = parcel.readInt();
            this.f18642u = parcel.readString();
            this.f18643v = parcel.readInt();
            this.f18644w = parcel.readInt();
            this.f18645x = parcel.readInt();
            this.f18647z = parcel.readString();
            this.A = parcel.readString();
            this.B = parcel.readInt();
            this.D = (Integer) parcel.readSerializable();
            this.F = (Integer) parcel.readSerializable();
            this.G = (Integer) parcel.readSerializable();
            this.H = (Integer) parcel.readSerializable();
            this.I = (Integer) parcel.readSerializable();
            this.J = (Integer) parcel.readSerializable();
            this.K = (Integer) parcel.readSerializable();
            this.N = (Integer) parcel.readSerializable();
            this.L = (Integer) parcel.readSerializable();
            this.M = (Integer) parcel.readSerializable();
            this.E = (Boolean) parcel.readSerializable();
            this.f18646y = (Locale) parcel.readSerializable();
            this.O = (Boolean) parcel.readSerializable();
        }
    }
}
