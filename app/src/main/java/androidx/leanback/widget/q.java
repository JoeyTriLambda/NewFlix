package androidx.leanback.widget;

/* compiled from: ItemAlignmentFacet.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final a[] f3323a = {new a()};

    /* compiled from: ItemAlignmentFacet.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f3324a = -1;

        /* renamed from: b, reason: collision with root package name */
        public final int f3325b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f3326c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f3327d = 50.0f;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3328e = false;

        public final int getItemAlignmentFocusViewId() {
            int i10 = this.f3325b;
            return i10 != -1 ? i10 : this.f3324a;
        }

        public final int getItemAlignmentOffset() {
            return this.f3326c;
        }

        public final float getItemAlignmentOffsetPercent() {
            return this.f3327d;
        }

        public final int getItemAlignmentViewId() {
            return this.f3324a;
        }

        public boolean isAlignedToTextViewBaseLine() {
            return false;
        }

        public final void setItemAlignmentOffset(int i10) {
            this.f3326c = i10;
        }

        public final void setItemAlignmentOffsetPercent(float f10) {
            if ((f10 < 0.0f || f10 > 100.0f) && f10 != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.f3327d = f10;
        }

        public final void setItemAlignmentOffsetWithPadding(boolean z10) {
            this.f3328e = z10;
        }

        public final void setItemAlignmentViewId(int i10) {
            this.f3324a = i10;
        }
    }

    public a[] getAlignmentDefs() {
        return this.f3323a;
    }
}
