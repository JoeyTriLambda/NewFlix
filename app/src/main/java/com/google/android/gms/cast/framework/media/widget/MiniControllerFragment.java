package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzml;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class MiniControllerFragment extends Fragment implements ControlButtonsContainer {
    public static final Logger F0 = new Logger("MiniControllerFragment");
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public UIMediaController E0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f6676h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f6677i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f6678j0;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f6679k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f6680l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f6681m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f6682n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f6683o0;

    /* renamed from: p0, reason: collision with root package name */
    public int[] f6684p0;

    /* renamed from: q0, reason: collision with root package name */
    public final ImageView[] f6685q0 = new ImageView[3];

    /* renamed from: r0, reason: collision with root package name */
    public int f6686r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f6687s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f6688t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f6689u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f6690v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f6691w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f6692x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f6693y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f6694z0;

    public final void o(UIMediaController uIMediaController, RelativeLayout relativeLayout, int i10, int i11) {
        ImageView imageView = (ImageView) relativeLayout.findViewById(i10);
        int i12 = this.f6684p0[i11];
        if (i12 == R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
            return;
        }
        if (i12 == R.id.cast_button_type_custom) {
            return;
        }
        if (i12 == R.id.cast_button_type_play_pause_toggle) {
            int i13 = this.f6687s0;
            int i14 = this.f6688t0;
            int i15 = this.f6689u0;
            if (this.f6686r0 == 1) {
                i13 = this.f6690v0;
                i14 = this.f6691w0;
                i15 = this.f6692x0;
            }
            Drawable drawableZzc = zzs.zzc(getContext(), this.f6683o0, i13);
            Drawable drawableZzc2 = zzs.zzc(getContext(), this.f6683o0, i14);
            Drawable drawableZzc3 = zzs.zzc(getContext(), this.f6683o0, i15);
            imageView.setImageDrawable(drawableZzc2);
            ProgressBar progressBar = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(8, i10);
            layoutParams.addRule(6, i10);
            layoutParams.addRule(5, i10);
            layoutParams.addRule(7, i10);
            layoutParams.addRule(15);
            progressBar.setLayoutParams(layoutParams);
            progressBar.setVisibility(8);
            Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
            int i16 = this.f6682n0;
            if (i16 != 0 && indeterminateDrawable != null) {
                indeterminateDrawable.setColorFilter(i16, PorterDuff.Mode.SRC_IN);
            }
            relativeLayout.addView(progressBar);
            uIMediaController.bindImageViewToPlayPauseToggle(imageView, drawableZzc, drawableZzc2, drawableZzc3, progressBar, true);
            return;
        }
        if (i12 == R.id.cast_button_type_skip_previous) {
            imageView.setImageDrawable(zzs.zzc(getContext(), this.f6683o0, this.f6693y0));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_prev));
            uIMediaController.bindViewToSkipPrev(imageView, 0);
            return;
        }
        if (i12 == R.id.cast_button_type_skip_next) {
            imageView.setImageDrawable(zzs.zzc(getContext(), this.f6683o0, this.f6694z0));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_next));
            uIMediaController.bindViewToSkipNext(imageView, 0);
            return;
        }
        if (i12 == R.id.cast_button_type_rewind_30_seconds) {
            imageView.setImageDrawable(zzs.zzc(getContext(), this.f6683o0, this.A0));
            imageView.setContentDescription(getResources().getString(R.string.cast_rewind_30));
            uIMediaController.bindViewToRewind(imageView, 30000L);
        } else if (i12 == R.id.cast_button_type_forward_30_seconds) {
            imageView.setImageDrawable(zzs.zzc(getContext(), this.f6683o0, this.B0));
            imageView.setContentDescription(getResources().getString(R.string.cast_forward_30));
            uIMediaController.bindViewToForward(imageView, 30000L);
        } else if (i12 == R.id.cast_button_type_mute_toggle) {
            imageView.setImageDrawable(zzs.zzc(getContext(), this.f6683o0, this.C0));
            uIMediaController.bindImageViewToMuteToggle(imageView);
        } else if (i12 == R.id.cast_button_type_closed_caption) {
            imageView.setImageDrawable(zzs.zzc(getContext(), this.f6683o0, this.D0));
            uIMediaController.bindViewToClosedCaption(imageView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        UIMediaController uIMediaController = new UIMediaController(getActivity());
        this.E0 = uIMediaController;
        View viewInflate = layoutInflater.inflate(R.layout.cast_mini_controller, viewGroup, false);
        viewInflate.setVisibility(8);
        uIMediaController.bindViewVisibilityToMediaSession(viewInflate, 8);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.container_current);
        int i10 = this.f6680l0;
        if (i10 != 0) {
            relativeLayout.setBackgroundResource(i10);
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon_view);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title_view);
        if (this.f6677i0 != 0) {
            textView.setTextAppearance(getActivity(), this.f6677i0);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.subtitle_view);
        this.f6679k0 = textView2;
        if (this.f6678j0 != 0) {
            textView2.setTextAppearance(getActivity(), this.f6678j0);
        }
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
        if (this.f6681m0 != 0) {
            ((LayerDrawable) progressBar.getProgressDrawable()).setColorFilter(this.f6681m0, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController.bindTextViewToMetadataOfCurrentItem(textView, "com.google.android.gms.cast.metadata.TITLE");
        uIMediaController.bindTextViewToSmartSubtitle(this.f6679k0);
        uIMediaController.bindProgressBar(progressBar);
        uIMediaController.bindViewToLaunchExpandedController(relativeLayout);
        if (this.f6676h0) {
            uIMediaController.bindImageViewToImageOfCurrentItem(imageView, new ImageHints(2, getResources().getDimensionPixelSize(R.dimen.cast_mini_controller_icon_width), getResources().getDimensionPixelSize(R.dimen.cast_mini_controller_icon_height)), R.drawable.cast_album_art_placeholder);
        } else {
            imageView.setVisibility(8);
        }
        int i11 = R.id.button_0;
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(i11);
        ImageView[] imageViewArr = this.f6685q0;
        imageViewArr[0] = imageView2;
        int i12 = R.id.button_1;
        imageViewArr[1] = (ImageView) relativeLayout.findViewById(i12);
        int i13 = R.id.button_2;
        imageViewArr[2] = (ImageView) relativeLayout.findViewById(i13);
        o(uIMediaController, relativeLayout, i11, 0);
        o(uIMediaController, relativeLayout, i12, 1);
        o(uIMediaController, relativeLayout, i13, 2);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        UIMediaController uIMediaController = this.E0;
        if (uIMediaController != null) {
            uIMediaController.dispose();
            this.E0 = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) throws Resources.NotFoundException {
        super.onInflate(context, attributeSet, bundle);
        if (this.f6684p0 == null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CastMiniController, R.attr.castMiniControllerStyle, R.style.CastMiniController);
            this.f6676h0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CastMiniController_castShowImageThumbnail, true);
            this.f6677i0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castTitleTextAppearance, 0);
            this.f6678j0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castSubtitleTextAppearance, 0);
            this.f6680l0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castBackground, 0);
            int color = typedArrayObtainStyledAttributes.getColor(R.styleable.CastMiniController_castProgressBarColor, 0);
            this.f6681m0 = color;
            this.f6682n0 = typedArrayObtainStyledAttributes.getColor(R.styleable.CastMiniController_castMiniControllerLoadingIndicatorColor, color);
            this.f6683o0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castButtonColor, 0);
            int i10 = R.styleable.CastMiniController_castPlayButtonDrawable;
            this.f6687s0 = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
            int i11 = R.styleable.CastMiniController_castPauseButtonDrawable;
            this.f6688t0 = typedArrayObtainStyledAttributes.getResourceId(i11, 0);
            int i12 = R.styleable.CastMiniController_castStopButtonDrawable;
            this.f6689u0 = typedArrayObtainStyledAttributes.getResourceId(i12, 0);
            this.f6690v0 = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
            this.f6691w0 = typedArrayObtainStyledAttributes.getResourceId(i11, 0);
            this.f6692x0 = typedArrayObtainStyledAttributes.getResourceId(i12, 0);
            this.f6693y0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castSkipPreviousButtonDrawable, 0);
            this.f6694z0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castSkipNextButtonDrawable, 0);
            this.A0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castRewind30ButtonDrawable, 0);
            this.B0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castForward30ButtonDrawable, 0);
            this.C0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castMuteToggleButtonDrawable, 0);
            this.D0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castClosedCaptionsButtonDrawable, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastMiniController_castControlButtons, 0);
            if (resourceId != 0) {
                TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                Preconditions.checkArgument(typedArrayObtainTypedArray.length() == 3);
                this.f6684p0 = new int[typedArrayObtainTypedArray.length()];
                for (int i13 = 0; i13 < typedArrayObtainTypedArray.length(); i13++) {
                    this.f6684p0[i13] = typedArrayObtainTypedArray.getResourceId(i13, 0);
                }
                typedArrayObtainTypedArray.recycle();
                if (this.f6676h0) {
                    this.f6684p0[0] = R.id.cast_button_type_empty;
                }
                this.f6686r0 = 0;
                for (int i14 : this.f6684p0) {
                    if (i14 != R.id.cast_button_type_empty) {
                        this.f6686r0++;
                    }
                }
            } else {
                F0.w("Unable to read attribute castControlButtons.", new Object[0]);
                int i15 = R.id.cast_button_type_empty;
                this.f6684p0 = new int[]{i15, i15, i15};
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        com.google.android.gms.internal.cast.zzo.zzd(zzml.CAF_MINI_CONTROLLER);
    }
}
