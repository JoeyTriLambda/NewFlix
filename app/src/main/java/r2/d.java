package r2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public final class d extends h implements Animatable {

    /* renamed from: m, reason: collision with root package name */
    public final c f18368m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f18369n;

    /* renamed from: o, reason: collision with root package name */
    public b f18370o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<r2.c> f18371p;

    /* renamed from: q, reason: collision with root package name */
    public final a f18372q;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            d.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            d.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            d.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            ArrayList arrayList = new ArrayList(dVar.f18371p);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((r2.c) arrayList.get(i10)).onAnimationEnd(dVar);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d dVar = d.this;
            ArrayList arrayList = new ArrayList(dVar.f18371p);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((r2.c) arrayList.get(i10)).onAnimationStart(dVar);
            }
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final int f18375a;

        /* renamed from: b, reason: collision with root package name */
        public i f18376b;

        /* renamed from: c, reason: collision with root package name */
        public AnimatorSet f18377c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f18378d;

        /* renamed from: e, reason: collision with root package name */
        public b0.b<Animator, String> f18379e;

        public c(Context context, c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f18375a = cVar.f18375a;
                i iVar = cVar.f18376b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f18376b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f18376b = (i) constantState.newDrawable();
                    }
                    i iVar2 = (i) this.f18376b.mutate();
                    this.f18376b = iVar2;
                    iVar2.setCallback(callback);
                    this.f18376b.setBounds(cVar.f18376b.getBounds());
                    this.f18376b.f18389q = false;
                }
                ArrayList<Animator> arrayList = cVar.f18378d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f18378d = new ArrayList<>(size);
                    this.f18379e = new b0.b<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = cVar.f18378d.get(i10);
                        Animator animatorClone = animator.clone();
                        String str = cVar.f18379e.get(animator);
                        animatorClone.setTarget(this.f18376b.f18385m.f18437b.f18435o.get(str));
                        this.f18378d.add(animatorClone);
                        this.f18379e.put(animatorClone, str);
                    }
                    setupAnimatorSet();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f18375a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.f18377c == null) {
                this.f18377c = new AnimatorSet();
            }
            this.f18377c.playTogether(this.f18378d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public d() {
        this(null);
    }

    public static d create(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            d dVar = new d(context);
            Drawable drawable = n0.g.getDrawable(context.getResources(), i10, context.getTheme());
            dVar.f18383b = drawable;
            drawable.setCallback(dVar.f18372q);
            new C0236d(dVar.f18383b.getConstantState());
            return dVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i10);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(context, context.getResources(), xml, attributeSetAsAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e10) {
            Log.e("AnimatedVDCompat", "parser error", e10);
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("AnimatedVDCompat", "parser error", e11);
            return null;
        }
    }

    public static d createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        d dVar = new d(context);
        dVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return dVar;
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.applyTheme(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            return p0.a.canApplyTheme(drawable);
        }
        return false;
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        c cVar = this.f18368m;
        cVar.f18376b.draw(canvas);
        if (cVar.f18377c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f18383b;
        return drawable != null ? p0.a.getAlpha(drawable) : this.f18368m.f18376b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f18368m.f18375a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f18383b;
        return drawable != null ? p0.a.getColorFilter(drawable) : this.f18368m.f18376b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f18383b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0236d(this.f18383b.getConstantState());
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f18368m.f18376b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f18368m.f18376b.getIntrinsicWidth();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getOpacity() : this.f18368m.f18376b.getOpacity();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
    
        r3.setupAnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void inflate(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            r7 = this;
            android.graphics.drawable.Drawable r0 = r7.f18383b
            if (r0 == 0) goto L8
            p0.a.inflate(r0, r8, r9, r10, r11)
            return
        L8:
            int r0 = r9.getEventType()
            int r1 = r9.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            r2.d$c r3 = r7.f18368m
            if (r0 == r2) goto Lb4
            int r4 = r9.getDepth()
            if (r4 >= r1) goto L1f
            r4 = 3
            if (r0 == r4) goto Lb4
        L1f:
            r4 = 2
            if (r0 != r4) goto Lae
            java.lang.String r0 = r9.getName()
            java.lang.String r4 = "animated-vector"
            boolean r4 = r4.equals(r0)
            r5 = 0
            if (r4 == 0) goto L54
            int[] r0 = r2.a.f18359e
            android.content.res.TypedArray r0 = n0.i.obtainAttributes(r8, r11, r10, r0)
            int r4 = r0.getResourceId(r5, r5)
            if (r4 == 0) goto L50
            r2.i r4 = r2.i.create(r8, r4, r11)
            r4.f18389q = r5
            r2.d$a r5 = r7.f18372q
            r4.setCallback(r5)
            r2.i r5 = r3.f18376b
            if (r5 == 0) goto L4e
            r6 = 0
            r5.setCallback(r6)
        L4e:
            r3.f18376b = r4
        L50:
            r0.recycle()
            goto Lae
        L54:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lae
            int[] r0 = r2.a.f18360f
            android.content.res.TypedArray r0 = r8.obtainAttributes(r10, r0)
            java.lang.String r4 = r0.getString(r5)
            int r5 = r0.getResourceId(r2, r5)
            if (r5 == 0) goto Lab
            android.content.Context r6 = r7.f18369n
            if (r6 == 0) goto La0
            android.animation.Animator r5 = r2.f.loadAnimator(r6, r5)
            r2.i r6 = r3.f18376b
            r2.i$g r6 = r6.f18385m
            r2.i$f r6 = r6.f18437b
            b0.b<java.lang.String, java.lang.Object> r6 = r6.f18435o
            java.lang.Object r6 = r6.get(r4)
            r5.setTarget(r6)
            java.util.ArrayList<android.animation.Animator> r6 = r3.f18378d
            if (r6 != 0) goto L95
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r3.f18378d = r6
            b0.b r6 = new b0.b
            r6.<init>()
            r3.f18379e = r6
        L95:
            java.util.ArrayList<android.animation.Animator> r6 = r3.f18378d
            r6.add(r5)
            b0.b<android.animation.Animator, java.lang.String> r3 = r3.f18379e
            r3.put(r5, r4)
            goto Lab
        La0:
            r0.recycle()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Context can't be null when inflating animators"
            r8.<init>(r9)
            throw r8
        Lab:
            r0.recycle()
        Lae:
            int r0 = r9.next()
            goto L12
        Lb4:
            r3.setupAnimatorSet()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.d.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f18383b;
        return drawable != null ? p0.a.isAutoMirrored(drawable) : this.f18368m.f18376b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f18383b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f18368m.f18377c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.isStateful() : this.f18368m.f18376b.isStateful();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f18368m.f18376b.setBounds(rect);
        }
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.setLevel(i10) : this.f18368m.f18376b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.setState(iArr) : this.f18368m.f18376b.setState(iArr);
    }

    public void registerAnimationCallback(r2.c cVar) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (cVar.f18367a == null) {
                cVar.f18367a = new r2.b(cVar);
            }
            animatedVectorDrawable.registerAnimationCallback(cVar.f18367a);
            return;
        }
        if (cVar == null) {
            return;
        }
        if (this.f18371p == null) {
            this.f18371p = new ArrayList<>();
        }
        if (this.f18371p.contains(cVar)) {
            return;
        }
        this.f18371p.add(cVar);
        if (this.f18370o == null) {
            this.f18370o = new b();
        }
        this.f18368m.f18377c.addListener(this.f18370o);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f18368m.f18376b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setAutoMirrored(drawable, z10);
        } else {
            this.f18368m.f18376b.setAutoMirrored(z10);
        }
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setTint(drawable, i10);
        } else {
            this.f18368m.f18376b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setTintList(drawable, colorStateList);
        } else {
            this.f18368m.f18376b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setTintMode(drawable, mode);
        } else {
            this.f18368m.f18376b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f18368m.f18376b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        c cVar = this.f18368m;
        if (cVar.f18377c.isStarted()) {
            return;
        }
        cVar.f18377c.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f18368m.f18377c.end();
        }
    }

    public boolean unregisterAnimationCallback(r2.c cVar) {
        b bVar;
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (cVar.f18367a == null) {
                cVar.f18367a = new r2.b(cVar);
            }
            animatedVectorDrawable.unregisterAnimationCallback(cVar.f18367a);
        }
        ArrayList<r2.c> arrayList = this.f18371p;
        if (arrayList == null || cVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(cVar);
        if (this.f18371p.size() == 0 && (bVar = this.f18370o) != null) {
            this.f18368m.f18377c.removeListener(bVar);
            this.f18370o = null;
        }
        return zRemove;
    }

    public d(Context context) {
        this.f18370o = null;
        this.f18371p = null;
        a aVar = new a();
        this.f18372q = aVar;
        this.f18369n = context;
        this.f18368m = new c(context, null, aVar, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f18368m.f18376b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: r2.d$d, reason: collision with other inner class name */
    public static class C0236d extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f18380a;

        public C0236d(Drawable.ConstantState constantState) {
            this.f18380a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f18380a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f18380a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f18380a.newDrawable();
            dVar.f18383b = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.f18372q);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f18380a.newDrawable(resources);
            dVar.f18383b = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.f18372q);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f18380a.newDrawable(resources, theme);
            dVar.f18383b = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.f18372q);
            return dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
