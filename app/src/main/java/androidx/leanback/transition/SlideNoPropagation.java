package androidx.leanback.transition;

import android.content.Context;
import android.transition.Slide;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class SlideNoPropagation extends Slide {
    public SlideNoPropagation() {
    }

    @Override // android.transition.Slide
    public void setSlideEdge(int i10) {
        super.setSlideEdge(i10);
        setPropagation(null);
    }

    public SlideNoPropagation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
