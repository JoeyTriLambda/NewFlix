package androidx.activity;

import android.view.View;

/* compiled from: ViewTreeFullyLoadedReporterOwner.kt */
/* loaded from: classes.dex */
public final class n {
    public static final void set(View view, j jVar) {
        zf.i.checkNotNullParameter(view, "<this>");
        zf.i.checkNotNullParameter(jVar, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, jVar);
    }
}
