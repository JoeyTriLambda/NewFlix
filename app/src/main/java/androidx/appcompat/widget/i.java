package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* compiled from: AppCompatCheckedTextViewHelper.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final CheckedTextView f1367a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f1368b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1369c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1370d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1371e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1372f;

    public i(CheckedTextView checkedTextView) {
        this.f1367a = checkedTextView;
    }

    public final void a() {
        CheckedTextView checkedTextView = this.f1367a;
        Drawable checkMarkDrawable = d1.b.getCheckMarkDrawable(checkedTextView);
        if (checkMarkDrawable != null) {
            if (this.f1370d || this.f1371e) {
                Drawable drawableMutate = p0.a.wrap(checkMarkDrawable).mutate();
                if (this.f1370d) {
                    p0.a.setTintList(drawableMutate, this.f1368b);
                }
                if (this.f1371e) {
                    p0.a.setTintMode(drawableMutate, this.f1369c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(checkedTextView.getDrawableState());
                }
                checkedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }
}
