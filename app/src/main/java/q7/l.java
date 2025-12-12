package q7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

/* compiled from: ShapeAppearanceModel.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final d f17968a;

    /* renamed from: b, reason: collision with root package name */
    public final d f17969b;

    /* renamed from: c, reason: collision with root package name */
    public final d f17970c;

    /* renamed from: d, reason: collision with root package name */
    public final d f17971d;

    /* renamed from: e, reason: collision with root package name */
    public final c f17972e;

    /* renamed from: f, reason: collision with root package name */
    public final c f17973f;

    /* renamed from: g, reason: collision with root package name */
    public final c f17974g;

    /* renamed from: h, reason: collision with root package name */
    public final c f17975h;

    /* renamed from: i, reason: collision with root package name */
    public final f f17976i;

    /* renamed from: j, reason: collision with root package name */
    public final f f17977j;

    /* renamed from: k, reason: collision with root package name */
    public final f f17978k;

    /* renamed from: l, reason: collision with root package name */
    public final f f17979l;

    /* compiled from: ShapeAppearanceModel.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public d f17980a;

        /* renamed from: b, reason: collision with root package name */
        public d f17981b;

        /* renamed from: c, reason: collision with root package name */
        public d f17982c;

        /* renamed from: d, reason: collision with root package name */
        public d f17983d;

        /* renamed from: e, reason: collision with root package name */
        public c f17984e;

        /* renamed from: f, reason: collision with root package name */
        public c f17985f;

        /* renamed from: g, reason: collision with root package name */
        public c f17986g;

        /* renamed from: h, reason: collision with root package name */
        public c f17987h;

        /* renamed from: i, reason: collision with root package name */
        public final f f17988i;

        /* renamed from: j, reason: collision with root package name */
        public final f f17989j;

        /* renamed from: k, reason: collision with root package name */
        public final f f17990k;

        /* renamed from: l, reason: collision with root package name */
        public final f f17991l;

        public a() {
            this.f17980a = new k();
            this.f17981b = new k();
            this.f17982c = new k();
            this.f17983d = new k();
            this.f17984e = new q7.a(0.0f);
            this.f17985f = new q7.a(0.0f);
            this.f17986g = new q7.a(0.0f);
            this.f17987h = new q7.a(0.0f);
            this.f17988i = new f();
            this.f17989j = new f();
            this.f17990k = new f();
            this.f17991l = new f();
        }

        public static float a(d dVar) {
            if (dVar instanceof k) {
                return ((k) dVar).f17967a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f17927a;
            }
            return -1.0f;
        }

        public l build() {
            return new l(this);
        }

        public a setAllCornerSizes(c cVar) {
            return setTopLeftCornerSize(cVar).setTopRightCornerSize(cVar).setBottomRightCornerSize(cVar).setBottomLeftCornerSize(cVar);
        }

        public a setBottomLeftCorner(int i10, c cVar) {
            return setBottomLeftCorner(i.a(i10)).setBottomLeftCornerSize(cVar);
        }

        public a setBottomLeftCornerSize(float f10) {
            this.f17987h = new q7.a(f10);
            return this;
        }

        public a setBottomRightCorner(int i10, c cVar) {
            return setBottomRightCorner(i.a(i10)).setBottomRightCornerSize(cVar);
        }

        public a setBottomRightCornerSize(float f10) {
            this.f17986g = new q7.a(f10);
            return this;
        }

        public a setTopLeftCorner(int i10, c cVar) {
            return setTopLeftCorner(i.a(i10)).setTopLeftCornerSize(cVar);
        }

        public a setTopLeftCornerSize(float f10) {
            this.f17984e = new q7.a(f10);
            return this;
        }

        public a setTopRightCorner(int i10, c cVar) {
            return setTopRightCorner(i.a(i10)).setTopRightCornerSize(cVar);
        }

        public a setTopRightCornerSize(float f10) {
            this.f17985f = new q7.a(f10);
            return this;
        }

        public a setBottomLeftCornerSize(c cVar) {
            this.f17987h = cVar;
            return this;
        }

        public a setBottomRightCornerSize(c cVar) {
            this.f17986g = cVar;
            return this;
        }

        public a setTopLeftCornerSize(c cVar) {
            this.f17984e = cVar;
            return this;
        }

        public a setTopRightCornerSize(c cVar) {
            this.f17985f = cVar;
            return this;
        }

        public a setBottomLeftCorner(d dVar) {
            this.f17983d = dVar;
            float fA = a(dVar);
            if (fA != -1.0f) {
                setBottomLeftCornerSize(fA);
            }
            return this;
        }

        public a setBottomRightCorner(d dVar) {
            this.f17982c = dVar;
            float fA = a(dVar);
            if (fA != -1.0f) {
                setBottomRightCornerSize(fA);
            }
            return this;
        }

        public a setTopLeftCorner(d dVar) {
            this.f17980a = dVar;
            float fA = a(dVar);
            if (fA != -1.0f) {
                setTopLeftCornerSize(fA);
            }
            return this;
        }

        public a setTopRightCorner(d dVar) {
            this.f17981b = dVar;
            float fA = a(dVar);
            if (fA != -1.0f) {
                setTopRightCornerSize(fA);
            }
            return this;
        }

        public a setAllCornerSizes(float f10) {
            return setTopLeftCornerSize(f10).setTopRightCornerSize(f10).setBottomRightCornerSize(f10).setBottomLeftCornerSize(f10);
        }

        public a(l lVar) {
            this.f17980a = new k();
            this.f17981b = new k();
            this.f17982c = new k();
            this.f17983d = new k();
            this.f17984e = new q7.a(0.0f);
            this.f17985f = new q7.a(0.0f);
            this.f17986g = new q7.a(0.0f);
            this.f17987h = new q7.a(0.0f);
            this.f17988i = new f();
            this.f17989j = new f();
            this.f17990k = new f();
            this.f17991l = new f();
            this.f17980a = lVar.f17968a;
            this.f17981b = lVar.f17969b;
            this.f17982c = lVar.f17970c;
            this.f17983d = lVar.f17971d;
            this.f17984e = lVar.f17972e;
            this.f17985f = lVar.f17973f;
            this.f17986g = lVar.f17974g;
            this.f17987h = lVar.f17975h;
            this.f17988i = lVar.f17976i;
            this.f17989j = lVar.f17977j;
            this.f17990k = lVar.f17978k;
            this.f17991l = lVar.f17979l;
        }
    }

    /* compiled from: ShapeAppearanceModel.java */
    public interface b {
    }

    static {
        new j(0.5f);
    }

    public l(a aVar) {
        this.f17968a = aVar.f17980a;
        this.f17969b = aVar.f17981b;
        this.f17970c = aVar.f17982c;
        this.f17971d = aVar.f17983d;
        this.f17972e = aVar.f17984e;
        this.f17973f = aVar.f17985f;
        this.f17974g = aVar.f17986g;
        this.f17975h = aVar.f17987h;
        this.f17976i = aVar.f17988i;
        this.f17977j = aVar.f17989j;
        this.f17978k = aVar.f17990k;
        this.f17979l = aVar.f17991l;
    }

    public static a a(Context context, int i10, int i11, c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ShapeAppearance);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i12);
            c cVarB = b(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cVar);
            c cVarB2 = b(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, cVarB);
            c cVarB3 = b(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, cVarB);
            c cVarB4 = b(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, cVarB);
            return new a().setTopLeftCorner(i13, cVarB2).setTopRightCorner(i14, cVarB3).setBottomRightCorner(i15, cVarB4).setBottomLeftCorner(i16, b(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, cVarB));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static c b(TypedArray typedArray, int i10, c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i11 = typedValuePeekValue.type;
        return i11 == 5 ? new q7.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i11 == 6 ? new j(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public static a builder() {
        return new a();
    }

    public f getBottomEdge() {
        return this.f17978k;
    }

    public d getBottomLeftCorner() {
        return this.f17971d;
    }

    public c getBottomLeftCornerSize() {
        return this.f17975h;
    }

    public d getBottomRightCorner() {
        return this.f17970c;
    }

    public c getBottomRightCornerSize() {
        return this.f17974g;
    }

    public f getLeftEdge() {
        return this.f17979l;
    }

    public f getRightEdge() {
        return this.f17977j;
    }

    public f getTopEdge() {
        return this.f17976i;
    }

    public d getTopLeftCorner() {
        return this.f17968a;
    }

    public c getTopLeftCornerSize() {
        return this.f17972e;
    }

    public d getTopRightCorner() {
        return this.f17969b;
    }

    public c getTopRightCornerSize() {
        return this.f17973f;
    }

    public boolean isRoundRect(RectF rectF) {
        boolean z10 = this.f17979l.getClass().equals(f.class) && this.f17977j.getClass().equals(f.class) && this.f17976i.getClass().equals(f.class) && this.f17978k.getClass().equals(f.class);
        float cornerSize = this.f17972e.getCornerSize(rectF);
        return z10 && ((this.f17973f.getCornerSize(rectF) > cornerSize ? 1 : (this.f17973f.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.f17975h.getCornerSize(rectF) > cornerSize ? 1 : (this.f17975h.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.f17974g.getCornerSize(rectF) > cornerSize ? 1 : (this.f17974g.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.f17969b instanceof k) && (this.f17968a instanceof k) && (this.f17970c instanceof k) && (this.f17971d instanceof k));
    }

    public a toBuilder() {
        return new a(this);
    }

    public l withCornerSize(float f10) {
        return toBuilder().setAllCornerSizes(f10).build();
    }

    public l withTransformedCornerSizes(b bVar) {
        h hVar = (h) bVar;
        return toBuilder().setTopLeftCornerSize(hVar.apply(getTopLeftCornerSize())).setTopRightCornerSize(hVar.apply(getTopRightCornerSize())).setBottomLeftCornerSize(hVar.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(hVar.apply(getBottomRightCornerSize())).build();
    }

    public static a builder(Context context, AttributeSet attributeSet, int i10, int i11) {
        return builder(context, attributeSet, i10, i11, 0);
    }

    public l withCornerSize(c cVar) {
        return toBuilder().setAllCornerSizes(cVar).build();
    }

    public static a builder(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return builder(context, attributeSet, i10, i11, new q7.a(i12));
    }

    public static a builder(Context context, AttributeSet attributeSet, int i10, int i11, c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    public static a builder(Context context, int i10, int i11) {
        return a(context, i10, i11, new q7.a(0));
    }

    public l() {
        this.f17968a = new k();
        this.f17969b = new k();
        this.f17970c = new k();
        this.f17971d = new k();
        this.f17972e = new q7.a(0.0f);
        this.f17973f = new q7.a(0.0f);
        this.f17974g = new q7.a(0.0f);
        this.f17975h = new q7.a(0.0f);
        this.f17976i = new f();
        this.f17977j = new f();
        this.f17978k = new f();
        this.f17979l = new f();
    }
}
