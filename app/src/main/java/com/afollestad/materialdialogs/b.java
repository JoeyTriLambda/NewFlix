package com.afollestad.materialdialogs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import n3.c;

/* compiled from: DialogInit.java */
/* loaded from: classes.dex */
public final class b {
    public static int getInflateLayout(MaterialDialog.c cVar) {
        return cVar.f5323n != null ? R.layout.md_dialog_custom : cVar.F != null ? R.layout.md_dialog_list : cVar.I > -2 ? R.layout.md_dialog_progress : R.layout.md_dialog_basic;
    }

    public static int getTheme(MaterialDialog.c cVar) {
        Context context = cVar.f5310a;
        int i10 = R.attr.md_dark_theme;
        Theme theme = cVar.f5332w;
        Theme theme2 = Theme.DARK;
        boolean zResolveBoolean = o3.a.resolveBoolean(context, i10, theme == theme2);
        if (!zResolveBoolean) {
            theme2 = Theme.LIGHT;
        }
        cVar.f5332w = theme2;
        return zResolveBoolean ? R.style.MD_Dark : R.style.MD_Light;
    }

    public static void init(MaterialDialog materialDialog) {
        MaterialDialog.c cVar = materialDialog.f5289n;
        materialDialog.setCancelable(cVar.f5333x);
        materialDialog.setCanceledOnTouchOutside(cVar.f5334y);
        int i10 = cVar.H;
        Context context = cVar.f5310a;
        if (i10 == 0) {
            cVar.H = o3.a.resolveColor(context, R.attr.md_background_color);
        }
        if (cVar.H != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.md_bg_corner_radius));
            gradientDrawable.setColor(cVar.H);
            o3.a.setBackgroundCompat(materialDialog.f16099b, gradientDrawable);
        }
        cVar.f5325p = o3.a.resolveActionTextColorStateList(context, R.attr.md_positive_color, cVar.f5325p);
        cVar.f5327r = o3.a.resolveActionTextColorStateList(context, R.attr.md_neutral_color, cVar.f5327r);
        cVar.f5326q = o3.a.resolveActionTextColorStateList(context, R.attr.md_negative_color, cVar.f5326q);
        cVar.f5324o = o3.a.resolveColor(context, R.attr.md_widget_color, cVar.f5324o);
        cVar.f5318i = o3.a.resolveColor(context, R.attr.md_title_color, o3.a.resolveColor(materialDialog.getContext(), android.R.attr.textColorPrimary));
        int iResolveColor = o3.a.resolveColor(context, R.attr.md_content_color, o3.a.resolveColor(materialDialog.getContext(), android.R.attr.textColorSecondary));
        cVar.f5319j = iResolveColor;
        o3.a.resolveColor(context, R.attr.md_item_color, iResolveColor);
        materialDialog.f5292q = (TextView) materialDialog.f16099b.findViewById(R.id.title);
        materialDialog.f5291p = (ImageView) materialDialog.f16099b.findViewById(R.id.icon);
        materialDialog.f5293r = materialDialog.f16099b.findViewById(R.id.titleFrame);
        materialDialog.f5297v = (TextView) materialDialog.f16099b.findViewById(R.id.content);
        materialDialog.f5290o = (ListView) materialDialog.f16099b.findViewById(R.id.contentListView);
        materialDialog.f5300y = (MDButton) materialDialog.f16099b.findViewById(R.id.buttonDefaultPositive);
        materialDialog.f5301z = (MDButton) materialDialog.f16099b.findViewById(R.id.buttonDefaultNeutral);
        materialDialog.A = (MDButton) materialDialog.f16099b.findViewById(R.id.buttonDefaultNegative);
        materialDialog.f5300y.setVisibility(cVar.f5321l != null ? 0 : 8);
        materialDialog.f5301z.setVisibility(8);
        materialDialog.A.setVisibility(cVar.f5322m != null ? 0 : 8);
        Drawable drawableResolveDrawable = o3.a.resolveDrawable(context, R.attr.md_icon);
        if (drawableResolveDrawable != null) {
            materialDialog.f5291p.setVisibility(0);
            materialDialog.f5291p.setImageDrawable(drawableResolveDrawable);
        } else {
            materialDialog.f5291p.setVisibility(8);
        }
        int dimensionPixelSize = cVar.E;
        if (dimensionPixelSize == -1) {
            dimensionPixelSize = o3.a.resolveDimension(context, R.attr.md_icon_max_size);
        }
        if (o3.a.resolveBoolean(context, R.attr.md_icon_limit_icon_to_default_size)) {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.md_icon_max_size);
        }
        if (dimensionPixelSize > -1) {
            materialDialog.f5291p.setAdjustViewBounds(true);
            materialDialog.f5291p.setMaxHeight(dimensionPixelSize);
            materialDialog.f5291p.setMaxWidth(dimensionPixelSize);
            materialDialog.f5291p.requestLayout();
        }
        materialDialog.f16099b.setDividerColor(o3.a.resolveColor(context, R.attr.md_divider_color, o3.a.resolveColor(materialDialog.getContext(), R.attr.md_divider)));
        TextView textView = materialDialog.f5292q;
        if (textView != null) {
            materialDialog.setTypeface(textView, cVar.D);
            materialDialog.f5292q.setTextColor(cVar.f5318i);
            materialDialog.f5292q.setGravity(cVar.f5312c.getGravityInt());
            materialDialog.f5292q.setTextAlignment(cVar.f5312c.getTextAlignment());
            CharSequence charSequence = cVar.f5311b;
            if (charSequence == null) {
                materialDialog.f5293r.setVisibility(8);
            } else {
                materialDialog.f5292q.setText(charSequence);
                materialDialog.f5293r.setVisibility(0);
            }
        }
        TextView textView2 = materialDialog.f5297v;
        if (textView2 != null) {
            textView2.setMovementMethod(new LinkMovementMethod());
            materialDialog.setTypeface(materialDialog.f5297v, cVar.C);
            materialDialog.f5297v.setLineSpacing(0.0f, cVar.f5335z);
            ColorStateList colorStateList = cVar.f5328s;
            if (colorStateList == null) {
                materialDialog.f5297v.setLinkTextColor(o3.a.resolveColor(materialDialog.getContext(), android.R.attr.textColorPrimary));
            } else {
                materialDialog.f5297v.setLinkTextColor(colorStateList);
            }
            materialDialog.f5297v.setTextColor(cVar.f5319j);
            materialDialog.f5297v.setGravity(cVar.f5313d.getGravityInt());
            materialDialog.f5297v.setTextAlignment(cVar.f5313d.getTextAlignment());
            CharSequence charSequence2 = cVar.f5320k;
            if (charSequence2 != null) {
                materialDialog.f5297v.setText(charSequence2);
                materialDialog.f5297v.setVisibility(0);
            } else {
                materialDialog.f5297v.setVisibility(8);
            }
        }
        materialDialog.f16099b.setButtonGravity(cVar.f5316g);
        materialDialog.f16099b.setButtonStackedGravity(cVar.f5314e);
        materialDialog.f16099b.setForceStack(false);
        boolean zResolveBoolean = o3.a.resolveBoolean(context, android.R.attr.textAllCaps, true);
        if (zResolveBoolean) {
            zResolveBoolean = o3.a.resolveBoolean(context, R.attr.textAllCaps, true);
        }
        MDButton mDButton = materialDialog.f5300y;
        materialDialog.setTypeface(mDButton, cVar.D);
        mDButton.setAllCapsCompat(zResolveBoolean);
        mDButton.setText(cVar.f5321l);
        mDButton.setTextColor(cVar.f5325p);
        MDButton mDButton2 = materialDialog.f5300y;
        DialogAction dialogAction = DialogAction.POSITIVE;
        mDButton2.setStackedSelector(materialDialog.a(dialogAction, true));
        materialDialog.f5300y.setDefaultSelector(materialDialog.a(dialogAction, false));
        materialDialog.f5300y.setTag(dialogAction);
        materialDialog.f5300y.setOnClickListener(materialDialog);
        materialDialog.f5300y.setVisibility(0);
        MDButton mDButton3 = materialDialog.A;
        materialDialog.setTypeface(mDButton3, cVar.D);
        mDButton3.setAllCapsCompat(zResolveBoolean);
        mDButton3.setText(cVar.f5322m);
        mDButton3.setTextColor(cVar.f5326q);
        MDButton mDButton4 = materialDialog.A;
        DialogAction dialogAction2 = DialogAction.NEGATIVE;
        mDButton4.setStackedSelector(materialDialog.a(dialogAction2, true));
        materialDialog.A.setDefaultSelector(materialDialog.a(dialogAction2, false));
        materialDialog.A.setTag(dialogAction2);
        materialDialog.A.setOnClickListener(materialDialog);
        materialDialog.A.setVisibility(0);
        MDButton mDButton5 = materialDialog.f5301z;
        materialDialog.setTypeface(mDButton5, cVar.D);
        mDButton5.setAllCapsCompat(zResolveBoolean);
        mDButton5.setText((CharSequence) null);
        mDButton5.setTextColor(cVar.f5327r);
        MDButton mDButton6 = materialDialog.f5301z;
        DialogAction dialogAction3 = DialogAction.NEUTRAL;
        mDButton6.setStackedSelector(materialDialog.a(dialogAction3, true));
        materialDialog.f5301z.setDefaultSelector(materialDialog.a(dialogAction3, false));
        materialDialog.f5301z.setTag(dialogAction3);
        materialDialog.f5301z.setOnClickListener(materialDialog);
        materialDialog.f5301z.setVisibility(0);
        ListView listView = materialDialog.f5290o;
        if (listView != null && cVar.F != null) {
            listView.setSelector(materialDialog.getListSelector());
            SpinnerAdapter spinnerAdapter = cVar.F;
            if (spinnerAdapter == null) {
                materialDialog.B = MaterialDialog.ListType.REGULAR;
                cVar.F = new a(materialDialog, MaterialDialog.ListType.getLayoutForType(materialDialog.B));
            } else if (spinnerAdapter instanceof n3.a) {
                ((n3.a) spinnerAdapter).setDialog(materialDialog);
            }
        }
        MaterialDialog.c cVar2 = materialDialog.f5289n;
        cVar2.getClass();
        if (cVar2.I > -2) {
            ProgressBar progressBar = (ProgressBar) materialDialog.f16099b.findViewById(android.R.id.progress);
            materialDialog.f5294s = progressBar;
            if (progressBar != null) {
                HorizontalProgressDrawable horizontalProgressDrawable = new HorizontalProgressDrawable(cVar2.getContext());
                horizontalProgressDrawable.setTint(cVar2.f5324o);
                materialDialog.f5294s.setProgressDrawable(horizontalProgressDrawable);
                materialDialog.f5294s.setIndeterminateDrawable(horizontalProgressDrawable);
                materialDialog.f5294s.setIndeterminate(false);
                materialDialog.f5294s.setProgress(0);
                materialDialog.f5294s.setMax(0);
                TextView textView3 = (TextView) materialDialog.f16099b.findViewById(R.id.label);
                materialDialog.f5295t = textView3;
                if (textView3 != null) {
                    textView3.setTextColor(cVar2.f5319j);
                    materialDialog.setTypeface(materialDialog.f5295t, cVar2.D);
                    materialDialog.f5295t.setText(cVar2.M.format(0L));
                }
                TextView textView4 = (TextView) materialDialog.f16099b.findViewById(R.id.minMax);
                materialDialog.f5296u = textView4;
                if (textView4 != null) {
                    textView4.setTextColor(cVar2.f5319j);
                    materialDialog.setTypeface(materialDialog.f5296u, cVar2.C);
                    materialDialog.f5296u.setVisibility(8);
                }
            }
        }
        EditText editText = (EditText) materialDialog.f16099b.findViewById(android.R.id.input);
        materialDialog.f5298w = editText;
        if (editText != null) {
            materialDialog.setTypeface(editText, cVar2.C);
            materialDialog.setInternalInputCallback();
            materialDialog.f5298w.setHint((CharSequence) null);
            materialDialog.f5298w.setSingleLine();
            materialDialog.f5298w.setTextColor(cVar2.f5319j);
            materialDialog.f5298w.setHintTextColor(o3.a.adjustAlpha(cVar2.f5319j, 0.3f));
            c.setTint(materialDialog.f5298w, cVar2.f5324o);
            int i11 = cVar2.J;
            if (i11 != -1) {
                materialDialog.f5298w.setInputType(i11);
                if ((i11 & 128) == 128) {
                    materialDialog.f5298w.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            TextView textView5 = (TextView) materialDialog.f16099b.findViewById(R.id.minMax);
            materialDialog.f5299x = textView5;
            if (cVar2.K > 0 || cVar2.L > -1) {
                materialDialog.invalidateInputMinMaxIndicator(materialDialog.f5298w.getText().toString().length(), true);
            } else {
                textView5.setVisibility(8);
                materialDialog.f5299x = null;
            }
        }
        if (cVar.f5323n != null) {
            ((MDRootLayout) materialDialog.f16099b.findViewById(R.id.root)).noTitleNoPadding();
            FrameLayout frameLayout = (FrameLayout) materialDialog.f16099b.findViewById(R.id.customViewFrame);
            View view = cVar.f5323n;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (cVar.G) {
                Resources resources = materialDialog.getContext().getResources();
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(materialDialog.getContext());
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.md_content_padding_top);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize4);
                    view.setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                }
                scrollView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                view = scrollView;
            }
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        materialDialog.setOnShowListenerInternal();
        materialDialog.invalidateList();
        materialDialog.setViewInternal(materialDialog.f16099b);
        materialDialog.checkIfListInitScroll();
    }
}
