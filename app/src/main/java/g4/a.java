package g4;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import v0.e;
import v0.f;

/* compiled from: StaticLayoutProxy.java */
/* loaded from: classes.dex */
public final class a {
    public static StaticLayout create(CharSequence charSequence, int i10, int i11, TextPaint textPaint, int i12, Layout.Alignment alignment, float f10, float f11, boolean z10, TextUtils.TruncateAt truncateAt, int i13, int i14, e eVar) {
        try {
            return new StaticLayout(charSequence, i10, i11, textPaint, i12, alignment, fromTextDirectionHeuristicCompat(eVar), f10, f11, z10, truncateAt, i13, i14);
        } catch (IllegalArgumentException e10) {
            if (e10.getMessage().contains("utext_close")) {
                return new StaticLayout(charSequence, i10, i11, textPaint, i12, alignment, fromTextDirectionHeuristicCompat(eVar), f10, f11, z10, truncateAt, i13, i14);
            }
            throw e10;
        }
    }

    public static TextDirectionHeuristic fromTextDirectionHeuristicCompat(e eVar) {
        return eVar == f.f20415a ? TextDirectionHeuristics.LTR : eVar == f.f20416b ? TextDirectionHeuristics.RTL : eVar == f.f20417c ? TextDirectionHeuristics.FIRSTSTRONG_LTR : eVar == f.f20418d ? TextDirectionHeuristics.FIRSTSTRONG_RTL : eVar == f.f20419e ? TextDirectionHeuristics.ANYRTL_LTR : eVar == f.C0293f.f20424b ? TextDirectionHeuristics.LOCALE : TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }
}
