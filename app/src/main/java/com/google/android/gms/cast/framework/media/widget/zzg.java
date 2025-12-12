package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzg extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastSeekBar f6707a;

    public /* synthetic */ zzg(CastSeekBar castSeekBar) {
        this.f6707a = castSeekBar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(SeekBar.class.getName());
        CastSeekBar castSeekBar = this.f6707a;
        accessibilityEvent.setItemCount(castSeekBar.f6635b.f6702b);
        accessibilityEvent.setCurrentItemIndex(castSeekBar.getProgress());
    }

    @Override // android.view.View.AccessibilityDelegate
    @TargetApi(16)
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SeekBar.class.getName());
        if (PlatformVersion.isAtLeastJellyBean() && view.isEnabled()) {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    @TargetApi(16)
    public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (!view.isEnabled()) {
            return false;
        }
        if (super.performAccessibilityAction(view, i10, bundle)) {
            return true;
        }
        if (PlatformVersion.isAtLeastJellyBean() && (i10 == 4096 || i10 == 8192)) {
            int i11 = CastSeekBar.E;
            CastSeekBar castSeekBar = this.f6707a;
            castSeekBar.f6636m = true;
            zzd zzdVar = castSeekBar.f6640q;
            if (zzdVar != null) {
                zzdVar.zzb(castSeekBar);
            }
            int i12 = castSeekBar.f6635b.f6702b / 20;
            if (i10 == 8192) {
                i12 = -i12;
            }
            castSeekBar.c(castSeekBar.getProgress() + i12);
            castSeekBar.f6636m = false;
            zzd zzdVar2 = castSeekBar.f6640q;
            if (zzdVar2 != null) {
                zzdVar2.zzc(castSeekBar);
            }
        }
        return false;
    }
}
