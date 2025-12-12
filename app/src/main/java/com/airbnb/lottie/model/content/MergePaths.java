package com.airbnb.lottie.model.content;

import a4.d;
import p3.f;
import r3.c;
import r3.l;
import w3.b;

/* loaded from: classes.dex */
public final class MergePaths implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5414a;

    /* renamed from: b, reason: collision with root package name */
    public final MergePathsMode f5415b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5416c;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i10) {
            MergePathsMode mergePathsMode = MERGE;
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? mergePathsMode : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : mergePathsMode;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z10) {
        this.f5414a = str;
        this.f5415b = mergePathsMode;
        this.f5416c = z10;
    }

    public MergePathsMode getMode() {
        return this.f5415b;
    }

    public String getName() {
        return this.f5414a;
    }

    public boolean isHidden() {
        return this.f5416c;
    }

    @Override // w3.b
    public c toContent(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        if (fVar.enableMergePathsForKitKatAndAbove()) {
            return new l(this);
        }
        d.warning("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f5415b + '}';
    }
}
