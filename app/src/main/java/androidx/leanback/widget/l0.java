package androidx.leanback.widget;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.f0;

/* compiled from: RowHeaderPresenter.java */
/* loaded from: classes.dex */
public final class l0 extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f3284a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f3285b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3286c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3287d;

    /* compiled from: RowHeaderPresenter.java */
    public static class a extends f0.a {

        /* renamed from: b, reason: collision with root package name */
        public float f3288b;

        /* renamed from: c, reason: collision with root package name */
        public float f3289c;

        /* renamed from: d, reason: collision with root package name */
        public final RowHeaderView f3290d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f3291e;

        public a(View view) {
            super(view);
            RowHeaderView rowHeaderView = (RowHeaderView) view.findViewById(R.id.row_header);
            this.f3290d = rowHeaderView;
            this.f3291e = (TextView) view.findViewById(R.id.row_header_description);
            if (rowHeaderView != null) {
                rowHeaderView.getCurrentTextColor();
            }
            this.f3289c = this.f3216a.getResources().getFraction(R.fraction.lb_browse_header_unselect_alpha, 1, 1);
        }
    }

    public l0() {
        this(R.layout.lb_row_header);
    }

    public static float getFontDescent(TextView textView, Paint paint) {
        if (paint.getTextSize() != textView.getTextSize()) {
            paint.setTextSize(textView.getTextSize());
        }
        if (paint.getTypeface() != textView.getTypeface()) {
            paint.setTypeface(textView.getTypeface());
        }
        return paint.descent();
    }

    public int getSpaceUnderBaseline(a aVar) {
        int paddingBottom = aVar.f3216a.getPaddingBottom();
        View view = aVar.f3216a;
        return view instanceof TextView ? paddingBottom + ((int) getFontDescent((TextView) view, this.f3285b)) : paddingBottom;
    }

    @Override // androidx.leanback.widget.f0
    public void onBindViewHolder(f0.a aVar, Object obj) {
        m headerItem = obj == null ? null : ((j0) obj).getHeaderItem();
        a aVar2 = (a) aVar;
        if (headerItem == null) {
            RowHeaderView rowHeaderView = aVar2.f3290d;
            if (rowHeaderView != null) {
                rowHeaderView.setText((CharSequence) null);
            }
            TextView textView = aVar2.f3291e;
            if (textView != null) {
                textView.setText((CharSequence) null);
            }
            aVar.f3216a.setContentDescription(null);
            if (this.f3286c) {
                aVar.f3216a.setVisibility(8);
                return;
            }
            return;
        }
        RowHeaderView rowHeaderView2 = aVar2.f3290d;
        if (rowHeaderView2 != null) {
            rowHeaderView2.setText(headerItem.getName());
        }
        TextView textView2 = aVar2.f3291e;
        if (textView2 != null) {
            if (TextUtils.isEmpty(headerItem.getDescription())) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
            textView2.setText(headerItem.getDescription());
        }
        aVar.f3216a.setContentDescription(headerItem.getContentDescription());
        aVar.f3216a.setVisibility(0);
    }

    @Override // androidx.leanback.widget.f0
    public f0.a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(this.f3284a, viewGroup, false));
        if (this.f3287d) {
            setSelectLevel(aVar, 0.0f);
        }
        return aVar;
    }

    public void onSelectLevelChanged(a aVar) {
        if (this.f3287d) {
            View view = aVar.f3216a;
            float f10 = aVar.f3289c;
            view.setAlpha(((1.0f - f10) * aVar.f3288b) + f10);
        }
    }

    @Override // androidx.leanback.widget.f0
    public void onUnbindViewHolder(f0.a aVar) {
        a aVar2 = (a) aVar;
        RowHeaderView rowHeaderView = aVar2.f3290d;
        if (rowHeaderView != null) {
            rowHeaderView.setText((CharSequence) null);
        }
        TextView textView = aVar2.f3291e;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (this.f3287d) {
            setSelectLevel(aVar2, 0.0f);
        }
    }

    public void setNullItemVisibilityGone(boolean z10) {
        this.f3286c = z10;
    }

    public final void setSelectLevel(a aVar, float f10) {
        aVar.f3288b = f10;
        onSelectLevelChanged(aVar);
    }

    public l0(int i10) {
        this(i10, true);
    }

    public l0(int i10, boolean z10) {
        this.f3285b = new Paint(1);
        this.f3284a = i10;
        this.f3287d = z10;
    }
}
