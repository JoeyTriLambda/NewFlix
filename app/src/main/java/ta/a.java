package ta;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.thebluealliance.spectrum.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* compiled from: ColorItem.java */
/* loaded from: classes2.dex */
public final class a extends FrameLayout implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final EventBus f19872b;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f19873m;

    /* renamed from: n, reason: collision with root package name */
    public final int f19874n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f19875o;

    /* renamed from: p, reason: collision with root package name */
    public int f19876p;

    /* compiled from: ColorItem.java */
    /* renamed from: ta.a$a, reason: collision with other inner class name */
    public class C0279a extends AnimatorListenerAdapter {
        public C0279a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.setItemCheckmarkAttributes(1.0f);
        }
    }

    /* compiled from: ColorItem.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f19873m.setVisibility(4);
            aVar.setItemCheckmarkAttributes(0.0f);
        }
    }

    public a(Context context, int i10, boolean z10, EventBus eventBus) {
        super(context);
        this.f19876p = 0;
        this.f19874n = i10;
        this.f19875o = z10;
        this.f19872b = eventBus;
        b();
        eventBus.register(this);
        setOnClickListener(this);
        LayoutInflater.from(getContext()).inflate(R.layout.color_item, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.selected_checkmark);
        this.f19873m = imageView;
        imageView.setColorFilter(ta.b.isColorDark(i10) ? -1 : -16777216);
        setChecked(this.f19875o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemCheckmarkAttributes(float f10) {
        this.f19873m.setAlpha(f10);
        this.f19873m.setScaleX(f10);
        this.f19873m.setScaleY(f10);
    }

    public final void b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-16777216);
        int i10 = this.f19874n;
        setForeground(new RippleDrawable(ColorStateList.valueOf(ta.b.getRippleColor(i10)), null, gradientDrawable));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        int i11 = this.f19876p;
        if (i11 != 0) {
            gradientDrawable2.setStroke(i11, ta.b.isColorDark(i10) ? -1 : -16777216);
        }
        gradientDrawable2.setColor(i10);
        setBackground(gradientDrawable2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f19872b.post(new c(this.f19874n));
    }

    @Subscribe
    public void onSelectedColorChanged(c cVar) {
        setChecked(cVar.getSelectedColor() == this.f19874n);
    }

    public void setChecked(boolean z10) {
        boolean z11 = this.f19875o;
        this.f19875o = z10;
        if (!z11 && z10) {
            setItemCheckmarkAttributes(0.0f);
            this.f19873m.setVisibility(0);
            this.f19873m.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(250L).setListener(new C0279a()).start();
        } else if (!z11 || z10) {
            this.f19873m.setVisibility(z10 ? 0 : 4);
            setItemCheckmarkAttributes(1.0f);
        } else {
            this.f19873m.setVisibility(0);
            setItemCheckmarkAttributes(1.0f);
            this.f19873m.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(250L).setListener(new b()).start();
        }
    }

    public void setOutlineWidth(int i10) {
        this.f19876p = i10;
        b();
    }
}
