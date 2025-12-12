package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import java.util.List;
import p3.f;
import r3.c;
import r3.r;
import v3.d;
import w3.b;

/* loaded from: classes.dex */
public final class ShapeStroke implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5436a;

    /* renamed from: b, reason: collision with root package name */
    public final v3.b f5437b;

    /* renamed from: c, reason: collision with root package name */
    public final List<v3.b> f5438c;

    /* renamed from: d, reason: collision with root package name */
    public final v3.a f5439d;

    /* renamed from: e, reason: collision with root package name */
    public final d f5440e;

    /* renamed from: f, reason: collision with root package name */
    public final v3.b f5441f;

    /* renamed from: g, reason: collision with root package name */
    public final LineCapType f5442g;

    /* renamed from: h, reason: collision with root package name */
    public final LineJoinType f5443h;

    /* renamed from: i, reason: collision with root package name */
    public final float f5444i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5445j;

    public enum LineCapType {
        /* JADX INFO: Fake field, exist only in values array */
        BUTT,
        /* JADX INFO: Fake field, exist only in values array */
        ROUND,
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int iOrdinal = ordinal();
            return iOrdinal != 0 ? iOrdinal != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        /* JADX INFO: Fake field, exist only in values array */
        MITER,
        /* JADX INFO: Fake field, exist only in values array */
        ROUND,
        /* JADX INFO: Fake field, exist only in values array */
        BEVEL;

        public Paint.Join toPaintJoin() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return Paint.Join.MITER;
            }
            if (iOrdinal == 1) {
                return Paint.Join.ROUND;
            }
            if (iOrdinal != 2) {
                return null;
            }
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String str, v3.b bVar, List<v3.b> list, v3.a aVar, d dVar, v3.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f10, boolean z10) {
        this.f5436a = str;
        this.f5437b = bVar;
        this.f5438c = list;
        this.f5439d = aVar;
        this.f5440e = dVar;
        this.f5441f = bVar2;
        this.f5442g = lineCapType;
        this.f5443h = lineJoinType;
        this.f5444i = f10;
        this.f5445j = z10;
    }

    public LineCapType getCapType() {
        return this.f5442g;
    }

    public v3.a getColor() {
        return this.f5439d;
    }

    public v3.b getDashOffset() {
        return this.f5437b;
    }

    public LineJoinType getJoinType() {
        return this.f5443h;
    }

    public List<v3.b> getLineDashPattern() {
        return this.f5438c;
    }

    public float getMiterLimit() {
        return this.f5444i;
    }

    public String getName() {
        return this.f5436a;
    }

    public d getOpacity() {
        return this.f5440e;
    }

    public v3.b getWidth() {
        return this.f5441f;
    }

    public boolean isHidden() {
        return this.f5445j;
    }

    @Override // w3.b
    public c toContent(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(fVar, aVar, this);
    }
}
