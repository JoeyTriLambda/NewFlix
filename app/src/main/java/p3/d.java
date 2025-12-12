package p3;

import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public Map<String, List<Layer>> f17430c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, g> f17431d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, u3.b> f17432e;

    /* renamed from: f, reason: collision with root package name */
    public List<u3.g> f17433f;

    /* renamed from: g, reason: collision with root package name */
    public b0.l<u3.c> f17434g;

    /* renamed from: h, reason: collision with root package name */
    public b0.h<Layer> f17435h;

    /* renamed from: i, reason: collision with root package name */
    public List<Layer> f17436i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f17437j;

    /* renamed from: k, reason: collision with root package name */
    public float f17438k;

    /* renamed from: l, reason: collision with root package name */
    public float f17439l;

    /* renamed from: m, reason: collision with root package name */
    public float f17440m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f17441n;

    /* renamed from: a, reason: collision with root package name */
    public final o f17428a = new o();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet<String> f17429b = new HashSet<>();

    /* renamed from: o, reason: collision with root package name */
    public int f17442o = 0;

    public void addWarning(String str) {
        a4.d.warning(str);
        this.f17429b.add(str);
    }

    public Rect getBounds() {
        return this.f17437j;
    }

    public b0.l<u3.c> getCharacters() {
        return this.f17434g;
    }

    public float getDuration() {
        return (long) ((getDurationFrames() / this.f17440m) * 1000.0f);
    }

    public float getDurationFrames() {
        return this.f17439l - this.f17438k;
    }

    public float getEndFrame() {
        return this.f17439l;
    }

    public Map<String, u3.b> getFonts() {
        return this.f17432e;
    }

    public float getFrameRate() {
        return this.f17440m;
    }

    public Map<String, g> getImages() {
        return this.f17431d;
    }

    public List<Layer> getLayers() {
        return this.f17436i;
    }

    public u3.g getMarker(String str) {
        this.f17433f.size();
        for (int i10 = 0; i10 < this.f17433f.size(); i10++) {
            u3.g gVar = this.f17433f.get(i10);
            if (gVar.matchesName(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int getMaskAndMatteCount() {
        return this.f17442o;
    }

    public o getPerformanceTracker() {
        return this.f17428a;
    }

    public List<Layer> getPrecomps(String str) {
        return this.f17430c.get(str);
    }

    public float getStartFrame() {
        return this.f17438k;
    }

    public boolean hasDashPattern() {
        return this.f17441n;
    }

    public void incrementMatteOrMaskCount(int i10) {
        this.f17442o += i10;
    }

    public void init(Rect rect, float f10, float f11, float f12, List<Layer> list, b0.h<Layer> hVar, Map<String, List<Layer>> map, Map<String, g> map2, b0.l<u3.c> lVar, Map<String, u3.b> map3, List<u3.g> list2) {
        this.f17437j = rect;
        this.f17438k = f10;
        this.f17439l = f11;
        this.f17440m = f12;
        this.f17436i = list;
        this.f17435h = hVar;
        this.f17430c = map;
        this.f17431d = map2;
        this.f17434g = lVar;
        this.f17432e = map3;
        this.f17433f = list2;
    }

    public Layer layerModelForId(long j10) {
        return this.f17435h.get(j10);
    }

    public void setHasDashPattern(boolean z10) {
        this.f17441n = z10;
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f17428a.f17541a = z10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.f17436i.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString("\t"));
        }
        return sb2.toString();
    }
}
