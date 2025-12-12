package p6;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R;

/* compiled from: ChildrenAlphaProperty.java */
/* loaded from: classes.dex */
public final class d extends Property<ViewGroup, Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f17610a = new d();

    public d() {
        super(Float.class, "childrenAlpha");
    }

    @Override // android.util.Property
    public Float get(ViewGroup viewGroup) {
        Float f10 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        return f10 != null ? f10 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public void set(ViewGroup viewGroup, Float f10) {
        float fFloatValue = f10.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).setAlpha(fFloatValue);
        }
    }
}
