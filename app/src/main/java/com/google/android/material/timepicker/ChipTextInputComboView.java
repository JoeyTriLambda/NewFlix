package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import i7.q;
import i7.t;
import x0.j0;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f9478n = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Chip f9479b;

    /* renamed from: m, reason: collision with root package name */
    public final EditText f9480m;

    public class a extends q {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean zIsEmpty = TextUtils.isEmpty(editable);
            ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
            if (zIsEmpty) {
                chipTextInputComboView.f9479b.setText(e.formatText(chipTextInputComboView.getResources(), "00"));
                return;
            }
            int i10 = ChipTextInputComboView.f9478n;
            String text = e.formatText(chipTextInputComboView.getResources(), editable);
            if (TextUtils.isEmpty(text)) {
                text = e.formatText(chipTextInputComboView.getResources(), "00");
            }
            chipTextInputComboView.f9479b.setText(text);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9479b.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f9480m.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        Chip chip = this.f9479b;
        chip.setChecked(z10);
        int i10 = z10 ? 0 : 4;
        EditText editText = this.f9480m;
        editText.setVisibility(i10);
        chip.setVisibility(z10 ? 8 : 0);
        if (isChecked()) {
            t.requestFocusAndShowKeyboard(editText, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f9479b.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f9479b.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f9479b.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f9479b = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f9480m = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a());
        if (Build.VERSION.SDK_INT >= 24) {
            editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R.id.material_label);
        editText.setId(j0.generateViewId());
        j0.setLabelFor(textView, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
