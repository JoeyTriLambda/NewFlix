package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int E = 0;
    public final Chip D;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i10 = TimePickerView.E;
            TimePickerView.this.getClass();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.D.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a aVar = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        ((MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle)).addOnButtonCheckedListener(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.f
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z10) {
                int i12 = TimePickerView.E;
                this.f9507a.getClass();
            }
        });
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.D = chip2;
        h hVar = new h(new GestureDetector(getContext(), new g(this)));
        chip.setOnTouchListener(hVar);
        chip2.setOnTouchListener(hVar);
        int i11 = R.id.selection_type;
        chip.setTag(i11, 12);
        chip2.setTag(i11, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }
}
