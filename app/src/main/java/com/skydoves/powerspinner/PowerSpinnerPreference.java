package com.skydoves.powerspinner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.Preference;
import zf.f;
import zf.i;

/* compiled from: PowerSpinnerPreference.kt */
/* loaded from: classes2.dex */
public final class PowerSpinnerPreference extends Preference {

    /* renamed from: v, reason: collision with root package name */
    public final PowerSpinnerView f10437v;

    public PowerSpinnerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void a(TypedArray typedArray) throws Resources.NotFoundException {
        int i10 = R.styleable.PowerSpinnerView_spinner_arrow_show;
        PowerSpinnerView powerSpinnerView = this.f10437v;
        powerSpinnerView.setShowArrow(typedArray.getBoolean(i10, powerSpinnerView.getShowArrow()));
        int integer = typedArray.getInteger(R.styleable.PowerSpinnerView_spinner_arrow_gravity, powerSpinnerView.getArrowGravity().getValue());
        SpinnerGravity spinnerGravity = SpinnerGravity.START;
        if (integer == spinnerGravity.getValue()) {
            powerSpinnerView.setArrowGravity(spinnerGravity);
        } else {
            SpinnerGravity spinnerGravity2 = SpinnerGravity.TOP;
            if (integer == spinnerGravity2.getValue()) {
                powerSpinnerView.setArrowGravity(spinnerGravity2);
            } else {
                SpinnerGravity spinnerGravity3 = SpinnerGravity.END;
                if (integer == spinnerGravity3.getValue()) {
                    powerSpinnerView.setArrowGravity(spinnerGravity3);
                } else {
                    SpinnerGravity spinnerGravity4 = SpinnerGravity.BOTTOM;
                    if (integer == spinnerGravity4.getValue()) {
                        powerSpinnerView.setArrowGravity(spinnerGravity4);
                    }
                }
            }
        }
        powerSpinnerView.setArrowPadding(typedArray.getDimensionPixelSize(R.styleable.PowerSpinnerView_spinner_arrow_padding, powerSpinnerView.getArrowPadding()));
        powerSpinnerView.setArrowAnimate(typedArray.getBoolean(R.styleable.PowerSpinnerView_spinner_arrow_animate, powerSpinnerView.getArrowAnimate()));
        powerSpinnerView.setArrowAnimationDuration(typedArray.getInteger(R.styleable.PowerSpinnerView_spinner_arrow_animate_duration, (int) powerSpinnerView.getArrowAnimationDuration()));
        powerSpinnerView.setShowDivider(typedArray.getBoolean(R.styleable.PowerSpinnerView_spinner_divider_show, powerSpinnerView.getShowDivider()));
        powerSpinnerView.setDividerSize(typedArray.getDimensionPixelSize(R.styleable.PowerSpinnerView_spinner_divider_size, powerSpinnerView.getDividerSize()));
        powerSpinnerView.setDividerColor(typedArray.getColor(R.styleable.PowerSpinnerView_spinner_divider_color, powerSpinnerView.getDividerColor()));
        powerSpinnerView.setSpinnerPopupBackgroundColor(typedArray.getColor(R.styleable.PowerSpinnerView_spinner_popup_background, powerSpinnerView.getSpinnerPopupBackgroundColor()));
        int integer2 = typedArray.getInteger(R.styleable.PowerSpinnerView_spinner_popup_animation, powerSpinnerView.getSpinnerPopupAnimation().getValue());
        SpinnerAnimation spinnerAnimation = SpinnerAnimation.DROPDOWN;
        if (integer2 == spinnerAnimation.getValue()) {
            powerSpinnerView.setSpinnerPopupAnimation(spinnerAnimation);
        } else {
            SpinnerAnimation spinnerAnimation2 = SpinnerAnimation.FADE;
            if (integer2 == spinnerAnimation2.getValue()) {
                powerSpinnerView.setSpinnerPopupAnimation(spinnerAnimation2);
            } else {
                SpinnerAnimation spinnerAnimation3 = SpinnerAnimation.BOUNCE;
                if (integer2 == spinnerAnimation3.getValue()) {
                    powerSpinnerView.setSpinnerPopupAnimation(spinnerAnimation3);
                }
            }
        }
        powerSpinnerView.setSpinnerPopupAnimationStyle(typedArray.getResourceId(R.styleable.PowerSpinnerView_spinner_popup_animation_style, powerSpinnerView.getSpinnerPopupAnimationStyle()));
        powerSpinnerView.setSpinnerPopupWidth(typedArray.getDimensionPixelSize(R.styleable.PowerSpinnerView_spinner_popup_width, powerSpinnerView.getSpinnerPopupWidth()));
        powerSpinnerView.setSpinnerPopupHeight(typedArray.getDimensionPixelSize(R.styleable.PowerSpinnerView_spinner_popup_height, powerSpinnerView.getSpinnerPopupHeight()));
        powerSpinnerView.setSpinnerPopupElevation(typedArray.getDimensionPixelSize(R.styleable.PowerSpinnerView_spinner_popup_elevation, powerSpinnerView.getSpinnerPopupElevation()));
        int resourceId = typedArray.getResourceId(R.styleable.PowerSpinnerView_spinner_item_array, -1);
        if (resourceId != -1) {
            powerSpinnerView.setItems(resourceId);
        }
        powerSpinnerView.setDismissWhenNotifiedItemSelected(typedArray.getBoolean(R.styleable.PowerSpinnerView_spinner_dismiss_notified_select, powerSpinnerView.getDismissWhenNotifiedItemSelected()));
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        i.checkNotNullParameter(typedArray, "a");
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    public /* synthetic */ PowerSpinnerPreference(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? androidx.preference.R.attr.preferenceStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerSpinnerPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.checkNotNullParameter(context, "context");
        this.f10437v = new PowerSpinnerView(context);
        setLayoutResource(R.layout.layout_preference_power_spinner_library);
        if (attributeSet != null && i10 != androidx.preference.R.attr.preferenceStyle) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PowerSpinnerView, i10, 0);
            i.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…fStyleAttr,\n      0\n    )");
            try {
                a(typedArrayObtainStyledAttributes);
                return;
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, R.styleable.PowerSpinnerView);
            i.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "context.obtainStyledAttr…yleable.PowerSpinnerView)");
            try {
                a(typedArrayObtainStyledAttributes2);
            } finally {
                typedArrayObtainStyledAttributes2.recycle();
            }
        }
    }
}
