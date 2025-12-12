package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1382a;

    /* renamed from: b, reason: collision with root package name */
    public final View f1383b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f1384c;

    /* renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f1385d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f1386e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f1387f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f1388g;

    public i1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1385d = layoutParams;
        this.f1386e = new Rect();
        this.f1387f = new int[2];
        this.f1388g = new int[2];
        this.f1382a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1383b = viewInflate;
        this.f1384c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(i1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }
}
