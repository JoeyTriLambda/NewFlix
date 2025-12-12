package j4;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.util.Property;
import android.view.animation.Interpolator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import l4.f;

/* compiled from: SpriteAnimatorBuilder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final f f14584a;

    /* renamed from: b, reason: collision with root package name */
    public Interpolator f14585b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14586c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f14587d = 2000;

    /* renamed from: e, reason: collision with root package name */
    public int f14588e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f14589f = new HashMap();

    /* compiled from: SpriteAnimatorBuilder.java */
    public class a extends b<Float> {
        public a(d dVar, float[] fArr, Property property, Float[] fArr2) {
            super(dVar, fArr, property, fArr2);
        }
    }

    /* compiled from: SpriteAnimatorBuilder.java */
    public class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f14590a;

        /* renamed from: b, reason: collision with root package name */
        public final Property f14591b;

        /* renamed from: c, reason: collision with root package name */
        public final T[] f14592c;

        public b(d dVar, float[] fArr, Property property, T[] tArr) {
            this.f14590a = fArr;
            this.f14591b = property;
            this.f14592c = tArr;
        }
    }

    /* compiled from: SpriteAnimatorBuilder.java */
    public class c extends b<Integer> {
        public c(d dVar, float[] fArr, Property property, Integer[] numArr) {
            super(dVar, fArr, property, numArr);
        }
    }

    public d(f fVar) {
        this.f14584a = fVar;
    }

    public static void a(int i10, int i11) {
        if (i10 != i11) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public d alpha(float[] fArr, Integer... numArr) {
        c(fArr, f.L, numArr);
        return this;
    }

    public final void b(float[] fArr, j4.b bVar, Float[] fArr2) {
        a(fArr.length, fArr2.length);
        this.f14589f.put(bVar.getName(), new a(this, fArr, bVar, fArr2));
    }

    public ObjectAnimator build() {
        HashMap map = this.f14589f;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[map.size()];
        Iterator it = map.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            b bVar = (b) ((Map.Entry) it.next()).getValue();
            float[] fArr = bVar.f14590a;
            Keyframe[] keyframeArr = new Keyframe[fArr.length];
            int i11 = this.f14588e;
            float f10 = fArr[i11];
            while (true) {
                int i12 = this.f14588e;
                Object[] objArr = bVar.f14592c;
                if (i11 < objArr.length + i12) {
                    int i13 = i11 - i12;
                    int length = i11 % objArr.length;
                    float f11 = fArr[length] - f10;
                    if (f11 < 0.0f) {
                        f11 += fArr[fArr.length - 1];
                    }
                    if (bVar instanceof c) {
                        keyframeArr[i13] = Keyframe.ofInt(f11, ((Integer) objArr[length]).intValue());
                    } else if (bVar instanceof a) {
                        keyframeArr[i13] = Keyframe.ofFloat(f11, ((Float) objArr[length]).floatValue());
                    } else {
                        keyframeArr[i13] = Keyframe.ofObject(f11, objArr[length]);
                    }
                    i11++;
                }
            }
            propertyValuesHolderArr[i10] = PropertyValuesHolder.ofKeyframe(bVar.f14591b, keyframeArr);
            i10++;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f14584a, propertyValuesHolderArr);
        objectAnimatorOfPropertyValuesHolder.setDuration(this.f14587d);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(this.f14586c);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(this.f14585b);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public final void c(float[] fArr, j4.c cVar, Integer[] numArr) {
        a(fArr.length, numArr.length);
        this.f14589f.put(cVar.getName(), new c(this, fArr, cVar, numArr));
    }

    public d duration(long j10) {
        this.f14587d = j10;
        return this;
    }

    public d easeInOut(float... fArr) {
        interpolator(k4.b.easeInOut(fArr));
        return this;
    }

    public d interpolator(Interpolator interpolator) {
        this.f14585b = interpolator;
        return this;
    }

    public d rotate(float[] fArr, Integer... numArr) {
        c(fArr, f.F, numArr);
        return this;
    }

    public d rotateX(float[] fArr, Integer... numArr) {
        c(fArr, f.E, numArr);
        return this;
    }

    public d rotateY(float[] fArr, Integer... numArr) {
        c(fArr, f.G, numArr);
        return this;
    }

    public d scale(float[] fArr, Float... fArr2) {
        b(fArr, f.K, fArr2);
        return this;
    }

    public d scaleY(float[] fArr, Float... fArr2) {
        b(fArr, f.J, fArr2);
        return this;
    }

    public d startFrame(int i10) {
        if (i10 < 0) {
            Log.w("SpriteAnimatorBuilder", "startFrame should always be non-negative");
            i10 = 0;
        }
        this.f14588e = i10;
        return this;
    }

    public d translateXPercentage(float[] fArr, Float... fArr2) {
        b(fArr, f.H, fArr2);
        return this;
    }

    public d translateYPercentage(float[] fArr, Float... fArr2) {
        b(fArr, f.I, fArr2);
        return this;
    }
}
