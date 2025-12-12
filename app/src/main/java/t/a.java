package t;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import b0.h;
import b0.l;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t.b;
import t.e;

/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public final class a extends t.e implements p0.c {
    public b A;
    public f B;
    public int C;
    public int D;
    public boolean E;

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: t.a$a, reason: collision with other inner class name */
    public static class C0253a extends f {

        /* renamed from: a, reason: collision with root package name */
        public final Animatable f19293a;

        public C0253a(Animatable animatable) {
            this.f19293a = animatable;
        }

        @Override // t.a.f
        public void start() {
            this.f19293a.start();
        }

        @Override // t.a.f
        public void stop() {
            this.f19293a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class b extends e.a {
        public h<Long> I;
        public l<Integer> J;

        public b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.I = bVar.I;
                this.J = bVar.J;
            } else {
                this.I = new h<>();
                this.J = new l<>();
            }
        }

        @Override // t.e.a, t.b.d
        public final void b() {
            this.I = this.I.m11clone();
            this.J = this.J.m12clone();
        }

        public final int d(int i10, int i11, Drawable drawable, boolean z10) {
            int iAddChild = super.addChild(drawable);
            long j10 = i10;
            long j11 = i11;
            long j12 = (j10 << 32) | j11;
            long j13 = z10 ? 8589934592L : 0L;
            long j14 = iAddChild;
            this.I.append(j12, Long.valueOf(j14 | j13));
            if (z10) {
                this.I.append(j10 | (j11 << 32), Long.valueOf(4294967296L | j14 | j13));
            }
            return iAddChild;
        }

        @Override // t.e.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // t.e.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class c extends f {

        /* renamed from: a, reason: collision with root package name */
        public final r2.d f19294a;

        public c(r2.d dVar) {
            this.f19294a = dVar;
        }

        @Override // t.a.f
        public void start() {
            this.f19294a.start();
        }

        @Override // t.a.f
        public void stop() {
            this.f19294a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class d extends f {

        /* renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f19295a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19296b;

        public d(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i10 = z10 ? numberOfFrames - 1 : 0;
            int i11 = z10 ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z10);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
            u.b.setAutoCancel(objectAnimatorOfInt, true);
            objectAnimatorOfInt.setDuration(eVar.f19299c);
            objectAnimatorOfInt.setInterpolator(eVar);
            this.f19296b = z11;
            this.f19295a = objectAnimatorOfInt;
        }

        @Override // t.a.f
        public boolean canReverse() {
            return this.f19296b;
        }

        @Override // t.a.f
        public void reverse() {
            this.f19295a.reverse();
        }

        @Override // t.a.f
        public void start() {
            this.f19295a.start();
        }

        @Override // t.a.f
        public void stop() {
            this.f19295a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static class e implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        public int[] f19297a;

        /* renamed from: b, reason: collision with root package name */
        public int f19298b;

        /* renamed from: c, reason: collision with root package name */
        public int f19299c;

        public e(AnimationDrawable animationDrawable, boolean z10) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f19298b = numberOfFrames;
            int[] iArr = this.f19297a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f19297a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f19297a;
            int i10 = 0;
            for (int i11 = 0; i11 < numberOfFrames; i11++) {
                int duration = animationDrawable.getDuration(z10 ? (numberOfFrames - i11) - 1 : i11);
                iArr2[i11] = duration;
                i10 += duration;
            }
            this.f19299c = i10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            int i10 = (int) ((f10 * this.f19299c) + 0.5f);
            int i11 = this.f19298b;
            int[] iArr = this.f19297a;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = iArr[i12];
                if (i10 < i13) {
                    break;
                }
                i10 -= i13;
                i12++;
            }
            return (i12 / i11) + (i12 < i11 ? i10 / this.f19299c : 0.0f);
        }
    }

    public a() {
        this(null, null);
    }

    public static a createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // t.e, t.b
    public final b.d b() {
        return new b(this.A, this, null);
    }

    @Override // t.e, t.b
    public final void e(b.d dVar) {
        super.e(dVar);
        if (dVar instanceof b) {
            this.A = (b) dVar;
        }
    }

    @Override // t.e
    /* renamed from: f */
    public final e.a b() {
        return new b(this.A, this, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x021b, code lost:
    
        onStateChange(getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0222, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void inflate(android.content.Context r18, android.content.res.Resources r19, org.xmlpull.v1.XmlPullParser r20, android.util.AttributeSet r21, android.content.res.Resources.Theme r22) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t.a.inflate(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // t.e, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // t.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.B;
        if (fVar != null) {
            fVar.stop();
            this.B = null;
            d(this.C);
            this.C = -1;
            this.D = -1;
        }
    }

    @Override // t.e, t.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.E && super.mutate() == this) {
            this.A.b();
            this.E = true;
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f  */
    @Override // t.e, t.b, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onStateChange(int[] r18) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t.a.onStateChange(int[]):boolean");
    }

    @Override // t.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        f fVar = this.B;
        if (fVar != null && (visible || z11)) {
            if (z10) {
                fVar.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public a(b bVar, Resources resources) {
        this.C = -1;
        this.D = -1;
        e(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    public static abstract class f {
        public boolean canReverse() {
            return false;
        }

        public abstract void start();

        public abstract void stop();

        public void reverse() {
        }
    }
}
