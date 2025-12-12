package com.airbnb.lottie.model.layer;

import ac.c;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import p3.d;
import v3.j;
import v3.k;
import v3.l;

/* loaded from: classes.dex */
public final class Layer {

    /* renamed from: a, reason: collision with root package name */
    public final List<w3.b> f5470a;

    /* renamed from: b, reason: collision with root package name */
    public final d f5471b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5472c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5473d;

    /* renamed from: e, reason: collision with root package name */
    public final LayerType f5474e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5475f;

    /* renamed from: g, reason: collision with root package name */
    public final String f5476g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Mask> f5477h;

    /* renamed from: i, reason: collision with root package name */
    public final l f5478i;

    /* renamed from: j, reason: collision with root package name */
    public final int f5479j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5480k;

    /* renamed from: l, reason: collision with root package name */
    public final int f5481l;

    /* renamed from: m, reason: collision with root package name */
    public final float f5482m;

    /* renamed from: n, reason: collision with root package name */
    public final float f5483n;

    /* renamed from: o, reason: collision with root package name */
    public final int f5484o;

    /* renamed from: p, reason: collision with root package name */
    public final int f5485p;

    /* renamed from: q, reason: collision with root package name */
    public final j f5486q;

    /* renamed from: r, reason: collision with root package name */
    public final k f5487r;

    /* renamed from: s, reason: collision with root package name */
    public final v3.b f5488s;

    /* renamed from: t, reason: collision with root package name */
    public final List<b4.a<Float>> f5489t;

    /* renamed from: u, reason: collision with root package name */
    public final MatteType f5490u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f5491v;

    public enum LayerType {
        PRE_COMP,
        /* JADX INFO: Fake field, exist only in values array */
        SOLID,
        IMAGE,
        /* JADX INFO: Fake field, exist only in values array */
        NULL,
        /* JADX INFO: Fake field, exist only in values array */
        SHAPE,
        /* JADX INFO: Fake field, exist only in values array */
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        /* JADX INFO: Fake field, exist only in values array */
        ADD,
        INVERT,
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN
    }

    public Layer(List<w3.b> list, d dVar, String str, long j10, LayerType layerType, long j11, String str2, List<Mask> list2, l lVar, int i10, int i11, int i12, float f10, float f11, int i13, int i14, j jVar, k kVar, List<b4.a<Float>> list3, MatteType matteType, v3.b bVar, boolean z10) {
        this.f5470a = list;
        this.f5471b = dVar;
        this.f5472c = str;
        this.f5473d = j10;
        this.f5474e = layerType;
        this.f5475f = j11;
        this.f5476g = str2;
        this.f5477h = list2;
        this.f5478i = lVar;
        this.f5479j = i10;
        this.f5480k = i11;
        this.f5481l = i12;
        this.f5482m = f10;
        this.f5483n = f11;
        this.f5484o = i13;
        this.f5485p = i14;
        this.f5486q = jVar;
        this.f5487r = kVar;
        this.f5489t = list3;
        this.f5490u = matteType;
        this.f5488s = bVar;
        this.f5491v = z10;
    }

    public long getId() {
        return this.f5473d;
    }

    public LayerType getLayerType() {
        return this.f5474e;
    }

    public boolean isHidden() {
        return this.f5491v;
    }

    public String toString(String str) {
        int i10;
        StringBuilder sbR = c.r(str);
        sbR.append(this.f5472c);
        sbR.append(StringUtils.LF);
        d dVar = this.f5471b;
        Layer layerLayerModelForId = dVar.layerModelForId(this.f5475f);
        if (layerLayerModelForId != null) {
            sbR.append("\t\tParents: ");
            sbR.append(layerLayerModelForId.f5472c);
            for (Layer layerLayerModelForId2 = dVar.layerModelForId(layerLayerModelForId.f5475f); layerLayerModelForId2 != null; layerLayerModelForId2 = dVar.layerModelForId(layerLayerModelForId2.f5475f)) {
                sbR.append("->");
                sbR.append(layerLayerModelForId2.f5472c);
            }
            sbR.append(str);
            sbR.append(StringUtils.LF);
        }
        List<Mask> list = this.f5477h;
        if (!list.isEmpty()) {
            sbR.append(str);
            sbR.append("\tMasks: ");
            sbR.append(list.size());
            sbR.append(StringUtils.LF);
        }
        int i11 = this.f5479j;
        if (i11 != 0 && (i10 = this.f5480k) != 0) {
            sbR.append(str);
            sbR.append("\tBackground: ");
            sbR.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(this.f5481l)));
        }
        List<w3.b> list2 = this.f5470a;
        if (!list2.isEmpty()) {
            sbR.append(str);
            sbR.append("\tShapes:\n");
            for (w3.b bVar : list2) {
                sbR.append(str);
                sbR.append("\t\t");
                sbR.append(bVar);
                sbR.append(StringUtils.LF);
            }
        }
        return sbR.toString();
    }

    public String toString() {
        return toString("");
    }
}
