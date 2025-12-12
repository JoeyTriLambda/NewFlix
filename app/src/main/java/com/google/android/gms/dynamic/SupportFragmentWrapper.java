package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f7566a;

    public SupportFragmentWrapper(Fragment fragment) {
        this.f7566a = fragment;
    }

    @KeepForSdk
    public static SupportFragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzA() {
        return this.f7566a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzb() {
        return this.f7566a.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzc() {
        return this.f7566a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle zzd() {
        return this.f7566a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zze() {
        return wrap(this.f7566a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzf() {
        return wrap(this.f7566a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.f7566a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.f7566a.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzi() {
        return ObjectWrapper.wrap(this.f7566a.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String zzj() {
        return this.f7566a.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.f7566a.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzl(boolean z10) {
        this.f7566a.setHasOptionsMenu(z10);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzm(boolean z10) {
        this.f7566a.setMenuVisibility(z10);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzn(boolean z10) {
        this.f7566a.setRetainInstance(z10);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzo(boolean z10) {
        this.f7566a.setUserVisibleHint(z10);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzp(Intent intent) {
        this.f7566a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzq(Intent intent, int i10) {
        this.f7566a.startActivityForResult(intent, i10);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzr(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.f7566a.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.f7566a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzt() {
        return this.f7566a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzu() {
        return this.f7566a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzv() {
        return this.f7566a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzw() {
        return this.f7566a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzx() {
        return this.f7566a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzy() {
        return this.f7566a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzz() {
        return this.f7566a.isResumed();
    }
}
