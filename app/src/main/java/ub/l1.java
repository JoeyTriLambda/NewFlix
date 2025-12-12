package ub;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import flix.com.vision.R;
import flix.com.vision.activities.MovieDetailActivity;

/* compiled from: MovieDetailActivity.java */
/* loaded from: classes2.dex */
public final class l1 implements sa.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MovieDetailActivity f20226a;

    public l1(MovieDetailActivity movieDetailActivity) {
        this.f20226a = movieDetailActivity;
    }

    @Override // sa.b
    public void onSuccess() throws Resources.NotFoundException {
        MovieDetailActivity movieDetailActivity = this.f20226a;
        movieDetailActivity.f11728a1.invalidate();
        int darkVibrantColor = b2.b.from(((BitmapDrawable) movieDetailActivity.f11728a1.getDrawable()).getBitmap()).generate().getDarkVibrantColor(0);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(movieDetailActivity.getResources().getColor(R.color.colorPrimary)), Integer.valueOf(darkVibrantColor));
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(movieDetailActivity, 12));
        valueAnimatorOfObject.start();
    }

    @Override // sa.b
    public void onError(Exception exc) {
    }
}
