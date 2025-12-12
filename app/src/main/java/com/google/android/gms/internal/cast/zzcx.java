package com.google.android.gms.internal.cast;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzcx extends zzcr {
    private final RelativeLayout zza;
    private final TextView zzb;
    private final CastSeekBar zzc;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzd;

    public zzcx(RelativeLayout relativeLayout, CastSeekBar castSeekBar, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) throws Resources.NotFoundException {
        this.zza = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tooltip);
        this.zzb = textView;
        this.zzc = castSeekBar;
        this.zzd = zzaVar;
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarTooltipBackgroundColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        textView.getBackground().setColorFilter(textView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        super.onSessionEnded();
        zzd();
    }

    @Override // com.google.android.gms.internal.cast.zzcr
    public final void zza(boolean z10) {
        super.zza(z10);
        zzd();
    }

    @Override // com.google.android.gms.internal.cast.zzcr
    public final void zzb(long j10) {
        zzd();
    }

    public final void zzd() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || zzc()) {
            this.zza.setVisibility(8);
            return;
        }
        this.zza.setVisibility(0);
        TextView textView = this.zzb;
        com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar = this.zzd;
        textView.setText(zzaVar.zzl(zzaVar.zze() + this.zzc.getProgress()));
        CastSeekBar castSeekBar = this.zzc;
        int measuredWidth = (castSeekBar.getMeasuredWidth() - castSeekBar.getPaddingLeft()) - this.zzc.getPaddingRight();
        this.zzb.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        TextView textView2 = this.zzb;
        CastSeekBar castSeekBar2 = this.zzc;
        int measuredWidth2 = textView2.getMeasuredWidth();
        int iMin = Math.min(Math.max(0, ((int) ((castSeekBar2.getProgress() / this.zzc.getMaxProgress()) * measuredWidth)) - (measuredWidth2 / 2)), measuredWidth - measuredWidth2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zzb.getLayoutParams();
        layoutParams.leftMargin = iMin;
        this.zzb.setLayoutParams(layoutParams);
    }
}
