package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.mediarouter.R;

/* loaded from: classes.dex */
class MediaRouteExpandCollapseButton extends androidx.appcompat.widget.o {

    /* renamed from: o, reason: collision with root package name */
    public final AnimationDrawable f3567o;

    /* renamed from: p, reason: collision with root package name */
    public final AnimationDrawable f3568p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3569q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3570r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3571s;

    /* renamed from: t, reason: collision with root package name */
    public View.OnClickListener f3572t;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = MediaRouteExpandCollapseButton.this;
            boolean z10 = !mediaRouteExpandCollapseButton.f3571s;
            mediaRouteExpandCollapseButton.f3571s = z10;
            if (z10) {
                mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f3567o);
                mediaRouteExpandCollapseButton.f3567o.start();
                mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.f3570r);
            } else {
                mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f3568p);
                mediaRouteExpandCollapseButton.f3568p.start();
                mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.f3569q);
            }
            View.OnClickListener onClickListener = mediaRouteExpandCollapseButton.f3572t;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3572t = onClickListener;
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        AnimationDrawable animationDrawable = (AnimationDrawable) m0.a.getDrawable(context, R.drawable.mr_group_expand);
        this.f3567o = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) m0.a.getDrawable(context, R.drawable.mr_group_collapse);
        this.f3568p = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(r.c(context, i10), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(R.string.mr_controller_expand_group);
        this.f3569q = string;
        this.f3570r = context.getString(R.string.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new a());
    }
}
