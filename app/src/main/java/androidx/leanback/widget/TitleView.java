package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.SearchOrbView;

/* loaded from: classes.dex */
public class TitleView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f3183b;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f3184m;

    /* renamed from: n, reason: collision with root package name */
    public final SearchOrbView f3185n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3186o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3187p;

    /* renamed from: q, reason: collision with root package name */
    public final a f3188q;

    public class a extends z0 {
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.browseTitleViewStyle);
    }

    public Drawable getBadgeDrawable() {
        return this.f3183b.getDrawable();
    }

    public SearchOrbView.c getSearchAffordanceColors() {
        return this.f3185n.getOrbColors();
    }

    public View getSearchAffordanceView() {
        return this.f3185n;
    }

    public CharSequence getTitle() {
        return this.f3184m.getText();
    }

    public z0 getTitleViewAdapter() {
        return this.f3188q;
    }

    public void setBadgeDrawable(Drawable drawable) {
        ImageView imageView = this.f3183b;
        imageView.setImageDrawable(drawable);
        Drawable drawable2 = imageView.getDrawable();
        TextView textView = this.f3184m;
        if (drawable2 != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.f3187p = onClickListener != null;
        SearchOrbView searchOrbView = this.f3185n;
        searchOrbView.setOnOrbClickedListener(onClickListener);
        searchOrbView.setVisibility((this.f3187p && (this.f3186o & 4) == 4) ? 0 : 4);
    }

    public void setSearchAffordanceColors(SearchOrbView.c cVar) {
        this.f3185n.setOrbColors(cVar);
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f3184m;
        textView.setText(charSequence);
        ImageView imageView = this.f3183b;
        if (imageView.getDrawable() != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }

    public TitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3186o = 6;
        this.f3187p = false;
        this.f3188q = new a();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.lb_title_view, this);
        this.f3183b = (ImageView) viewInflate.findViewById(R.id.title_badge);
        this.f3184m = (TextView) viewInflate.findViewById(R.id.title_text);
        this.f3185n = (SearchOrbView) viewInflate.findViewById(R.id.title_orb);
        setClipToPadding(false);
        setClipChildren(false);
    }
}
