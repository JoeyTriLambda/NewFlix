package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.common.internal.zaz;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public int f7038b;

    /* renamed from: m, reason: collision with root package name */
    public int f7039m;

    /* renamed from: n, reason: collision with root package name */
    public View f7040n;

    /* renamed from: o, reason: collision with root package name */
    public View.OnClickListener f7041o;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f7041o;
        if (onClickListener == null || view != this.f7040n) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i10) {
        setStyle(this.f7038b, i10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f7040n.setEnabled(z10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f7041o = onClickListener;
        View view = this.f7040n;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        setStyle(this.f7038b, this.f7039m);
    }

    public void setSize(int i10) {
        setStyle(i10, this.f7039m);
    }

    public void setStyle(int i10, int i11) {
        this.f7038b = i10;
        this.f7039m = i11;
        Context context = getContext();
        View view = this.f7040n;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f7040n = zaz.zaa(context, this.f7038b, this.f7039m);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i12 = this.f7038b;
            int i13 = this.f7039m;
            zaaa zaaaVar = new zaaa(context, null);
            zaaaVar.zaa(context.getResources(), i12, i13);
            this.f7040n = zaaaVar;
        }
        addView(this.f7040n);
        this.f7040n.setEnabled(isEnabled());
        this.f7040n.setOnClickListener(this);
    }
}
