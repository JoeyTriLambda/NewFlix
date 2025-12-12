package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class ThumbsBar extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f3176b;

    /* renamed from: m, reason: collision with root package name */
    public final int f3177m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3178n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3179o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3180p;

    /* renamed from: q, reason: collision with root package name */
    public int f3181q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3182r;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        int i10;
        int i11;
        while (getChildCount() > this.f3176b) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (true) {
            int childCount = getChildCount();
            int i12 = this.f3176b;
            i10 = this.f3178n;
            i11 = this.f3177m;
            if (childCount >= i12) {
                break;
            } else {
                addView(createThumbView(this), new LinearLayout.LayoutParams(i11, i10));
            }
        }
        int heroIndex = getHeroIndex();
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i13) {
                layoutParams.width = this.f3179o;
                layoutParams.height = this.f3180p;
            } else {
                layoutParams.width = i11;
                layoutParams.height = i10;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public View createThumbView(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredWidth = (childAt.getMeasuredWidth() / 2) + (getWidth() / 2);
        childAt.layout(width, getPaddingTop(), measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
        int measuredHeight = (childAt.getMeasuredHeight() / 2) + getPaddingTop();
        for (int i14 = heroIndex - 1; i14 >= 0; i14--) {
            int i15 = width - this.f3181q;
            View childAt2 = getChildAt(i14);
            childAt2.layout(i15 - childAt2.getMeasuredWidth(), measuredHeight - (childAt2.getMeasuredHeight() / 2), i15, (childAt2.getMeasuredHeight() / 2) + measuredHeight);
            width = i15 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex >= this.f3176b) {
                return;
            }
            int i16 = measuredWidth + this.f3181q;
            View childAt3 = getChildAt(heroIndex);
            childAt3.layout(i16, measuredHeight - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i16, (childAt3.getMeasuredHeight() / 2) + measuredHeight);
            measuredWidth = i16 + childAt3.getMeasuredWidth();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        if (this.f3182r) {
            return;
        }
        int i12 = measuredWidth - this.f3179o;
        int i13 = ((i12 + r3) - 1) / (this.f3177m + this.f3181q);
        if (i13 < 2) {
            i13 = 2;
        } else if ((i13 & 1) != 0) {
            i13++;
        }
        int i14 = i13 + 1;
        if (this.f3176b != i14) {
            this.f3176b = i14;
            a();
        }
    }

    public void setNumberOfThumbs(int i10) {
        this.f3182r = true;
        this.f3176b = i10;
        a();
    }

    public void setThumbSpace(int i10) {
        this.f3181q = i10;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3176b = -1;
        new SparseArray();
        this.f3182r = false;
        this.f3177m = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_width);
        this.f3178n = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_height);
        this.f3180p = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_width);
        this.f3179o = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_height);
        this.f3181q = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_margin);
    }
}
