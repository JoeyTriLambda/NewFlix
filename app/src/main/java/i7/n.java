package i7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f13311a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f13312b = null;

    /* renamed from: c, reason: collision with root package name */
    public final a f13313c = new a();

    /* compiled from: StateListAnimator.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            n nVar = n.this;
            if (nVar.f13312b == animator) {
                nVar.f13312b = null;
            }
        }
    }

    /* compiled from: StateListAnimator.java */
    public static class b {
        public b(int[] iArr, ValueAnimator valueAnimator) {
        }
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f13313c);
        this.f13311a.add(bVar);
    }
}
