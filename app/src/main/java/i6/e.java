package i6;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;

/* compiled from: WebvttCue.java */
/* loaded from: classes.dex */
public final class e extends b6.a {

    /* renamed from: o, reason: collision with root package name */
    public final long f13235o;

    /* renamed from: p, reason: collision with root package name */
    public final long f13236p;

    /* compiled from: WebvttCue.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13237a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f13237a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13237a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13237a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: WebvttCue.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public long f13238a;

        /* renamed from: b, reason: collision with root package name */
        public long f13239b;

        /* renamed from: c, reason: collision with root package name */
        public SpannableStringBuilder f13240c;

        /* renamed from: d, reason: collision with root package name */
        public Layout.Alignment f13241d;

        /* renamed from: e, reason: collision with root package name */
        public float f13242e;

        /* renamed from: f, reason: collision with root package name */
        public int f13243f;

        /* renamed from: g, reason: collision with root package name */
        public int f13244g;

        /* renamed from: h, reason: collision with root package name */
        public float f13245h;

        /* renamed from: i, reason: collision with root package name */
        public int f13246i;

        /* renamed from: j, reason: collision with root package name */
        public float f13247j;

        public b() {
            reset();
        }

        public e build() {
            if (this.f13245h != Float.MIN_VALUE && this.f13246i == Integer.MIN_VALUE) {
                Layout.Alignment alignment = this.f13241d;
                if (alignment == null) {
                    this.f13246i = Integer.MIN_VALUE;
                } else {
                    int i10 = a.f13237a[alignment.ordinal()];
                    if (i10 == 1) {
                        this.f13246i = 0;
                    } else if (i10 == 2) {
                        this.f13246i = 1;
                    } else if (i10 != 3) {
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.f13241d);
                        this.f13246i = 0;
                    } else {
                        this.f13246i = 2;
                    }
                }
            }
            return new e(this.f13238a, this.f13239b, this.f13240c, this.f13241d, this.f13242e, this.f13243f, this.f13244g, this.f13245h, this.f13246i, this.f13247j);
        }

        public void reset() {
            this.f13238a = 0L;
            this.f13239b = 0L;
            this.f13240c = null;
            this.f13241d = null;
            this.f13242e = Float.MIN_VALUE;
            this.f13243f = Integer.MIN_VALUE;
            this.f13244g = Integer.MIN_VALUE;
            this.f13245h = Float.MIN_VALUE;
            this.f13246i = Integer.MIN_VALUE;
            this.f13247j = Float.MIN_VALUE;
        }

        public b setEndTime(long j10) {
            this.f13239b = j10;
            return this;
        }

        public b setLine(float f10) {
            this.f13242e = f10;
            return this;
        }

        public b setLineAnchor(int i10) {
            this.f13244g = i10;
            return this;
        }

        public b setLineType(int i10) {
            this.f13243f = i10;
            return this;
        }

        public b setPosition(float f10) {
            this.f13245h = f10;
            return this;
        }

        public b setPositionAnchor(int i10) {
            this.f13246i = i10;
            return this;
        }

        public b setStartTime(long j10) {
            this.f13238a = j10;
            return this;
        }

        public b setText(SpannableStringBuilder spannableStringBuilder) {
            this.f13240c = spannableStringBuilder;
            return this;
        }

        public b setTextAlignment(Layout.Alignment alignment) {
            this.f13241d = alignment;
            return this;
        }

        public b setWidth(float f10) {
            this.f13247j = f10;
            return this;
        }
    }

    public e(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public boolean isNormalCue() {
        return this.f4778m == Float.MIN_VALUE && this.f4779n == Float.MIN_VALUE;
    }

    public e(long j10, long j11, CharSequence charSequence) {
        this(j10, j11, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public e(long j10, long j11, CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12) {
        super(charSequence, alignment, f10, i10, i11, f11, i12, f12);
        this.f13235o = j10;
        this.f13236p = j11;
    }
}
