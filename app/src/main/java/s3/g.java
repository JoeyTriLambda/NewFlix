package s3;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f19033a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f19034b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Mask> f19035c;

    public g(List<Mask> list) {
        this.f19035c = list;
        this.f19033a = new ArrayList(list.size());
        this.f19034b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f19033a.add(list.get(i10).getMaskPath().createAnimation());
            this.f19034b.add(list.get(i10).getOpacity().createAnimation());
        }
    }

    public List<a<w3.g, Path>> getMaskAnimations() {
        return this.f19033a;
    }

    public List<Mask> getMasks() {
        return this.f19035c;
    }

    public List<a<Integer, Integer>> getOpacityAnimations() {
        return this.f19034b;
    }
}
