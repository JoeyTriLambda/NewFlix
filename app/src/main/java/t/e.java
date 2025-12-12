package t;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import t.b;

/* compiled from: StateListDrawableCompat.java */
/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: y, reason: collision with root package name */
    public a f19355y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f19356z;

    /* compiled from: StateListDrawableCompat.java */
    public static class a extends b.d {
        public int[][] H;

        public a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.H = aVar.H;
            } else {
                this.H = new int[this.f19321g.length][];
            }
        }

        @Override // t.b.d
        public void b() {
            int[][] iArr = this.H;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.H[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.H = iArr2;
        }

        public final int c(int[] iArr) {
            int[][] iArr2 = this.H;
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // t.b.d
        public void growArray(int i10, int i11) {
            super.growArray(i10, i11);
            int[][] iArr = new int[i11][];
            System.arraycopy(this.H, 0, iArr, 0, i10);
            this.H = iArr;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new e(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    public e(a aVar, Resources resources) {
        e(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // t.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // t.b
    public void e(b.d dVar) {
        this.f19301b = dVar;
        int i10 = this.f19307r;
        if (i10 >= 0) {
            Drawable child = dVar.getChild(i10);
            this.f19303n = child;
            if (child != null) {
                c(child);
            }
        }
        this.f19304o = null;
        if (dVar instanceof a) {
            this.f19355y = (a) dVar;
        }
    }

    @Override // t.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.f19355y, this, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // t.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f19356z && super.mutate() == this) {
            this.f19355y.b();
            this.f19356z = true;
        }
        return this;
    }

    @Override // t.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iC = this.f19355y.c(iArr);
        if (iC < 0) {
            iC = this.f19355y.c(StateSet.WILD_CARD);
        }
        return d(iC) || zOnStateChange;
    }

    public e() {
    }
}
