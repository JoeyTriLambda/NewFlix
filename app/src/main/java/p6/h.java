package p6;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: MotionSpec.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final b0.k<String, i> f17616a = new b0.k<>();

    /* renamed from: b, reason: collision with root package name */
    public final b0.k<String, PropertyValuesHolder[]> f17617b = new b0.k<>();

    public static h a(ArrayList arrayList) {
        h hVar = new h();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Animator animator = (Animator) arrayList.get(i10);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.setPropertyValues(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f17605b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f17606c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f17607d;
            }
            i iVar = new i(startDelay, duration, interpolator);
            iVar.f17621d = objectAnimator.getRepeatCount();
            iVar.f17622e = objectAnimator.getRepeatMode();
            hVar.setTiming(propertyName, iVar);
        }
        return hVar;
    }

    public static h createFromAttribute(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return createFromResource(context, resourceId);
    }

    public static h createFromResource(Context context, int i10) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return a(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return a(arrayList);
        } catch (Exception e10) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i10), e10);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f17616a.equals(((h) obj).f17616a);
        }
        return false;
    }

    public i getTiming(String str) {
        if (hasTiming(str)) {
            return this.f17616a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long getTotalDuration() {
        b0.k<String, i> kVar = this.f17616a;
        int size = kVar.size();
        long jMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i iVarValueAt = kVar.valueAt(i10);
            jMax = Math.max(jMax, iVarValueAt.getDuration() + iVarValueAt.getDelay());
        }
        return jMax;
    }

    public boolean hasTiming(String str) {
        return this.f17616a.get(str) != null;
    }

    public int hashCode() {
        return this.f17616a.hashCode();
    }

    public void setPropertyValues(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f17617b.put(str, propertyValuesHolderArr);
    }

    public void setTiming(String str, i iVar) {
        this.f17616a.put(str, iVar);
    }

    public String toString() {
        return StringUtils.LF + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f17616a + "}\n";
    }
}
