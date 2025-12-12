package h7;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes.dex */
public final class d extends com.google.android.material.floatingactionbutton.d {
    public StateListAnimator I;

    public d(FloatingActionButton floatingActionButton, FloatingActionButton.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void e(Rect rect) {
        if (((FloatingActionButton.b) this.f9161r).isCompatPaddingEnabled()) {
            super.e(rect);
            return;
        }
        boolean z10 = this.f9145b;
        FloatingActionButton floatingActionButton = this.f9160q;
        if (!z10 || floatingActionButton.getSizeDimension() >= 0) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (0 - floatingActionButton.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void g() {
        n();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float getElevation() {
        return this.f9160q.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void h(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            FloatingActionButton floatingActionButton = this.f9160q;
            if (!floatingActionButton.isEnabled()) {
                floatingActionButton.setElevation(0.0f);
                floatingActionButton.setTranslationZ(0.0f);
                return;
            }
            floatingActionButton.setElevation(this.f9147d);
            if (floatingActionButton.isPressed()) {
                floatingActionButton.setTranslationZ(this.f9149f);
            } else if (floatingActionButton.isFocused() || floatingActionButton.isHovered()) {
                floatingActionButton.setTranslationZ(this.f9148e);
            } else {
                floatingActionButton.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void i(float f10, float f11, float f12) {
        int i10 = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.f9160q;
        if (i10 == 21) {
            floatingActionButton.refreshDrawableState();
        } else if (floatingActionButton.getStateListAnimator() == this.I) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.d.C, o(f10, f12));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.d.D, o(f10, f11));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.d.E, o(f10, f11));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.d.F, o(f10, f11));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f10).setDuration(0L));
            if (i10 >= 22 && i10 <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.d.f9141x);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.d.G, animatorSet);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.d.H, o(0.0f, 0.0f));
            this.I = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (l()) {
            n();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final boolean l() {
        if (((FloatingActionButton.b) this.f9161r).isCompatPaddingEnabled()) {
            return true;
        }
        return !(!this.f9145b || this.f9160q.getSizeDimension() >= 0);
    }

    public final AnimatorSet o(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        FloatingActionButton floatingActionButton = this.f9160q;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.d.f9141x);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void f() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void k() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void m() {
    }
}
