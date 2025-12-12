package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.loopj.android.http.AsyncHttpClient;

/* compiled from: LinearSmoothScroller.java */
/* loaded from: classes.dex */
public class m extends RecyclerView.v {

    /* renamed from: k, reason: collision with root package name */
    public PointF f4229k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f4230l;

    /* renamed from: n, reason: collision with root package name */
    public float f4232n;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f4227i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f4228j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    public boolean f4231m = false;

    /* renamed from: o, reason: collision with root package name */
    public int f4233o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f4234p = 0;

    public m(Context context) {
        this.f4230l = context.getResources().getDisplayMetrics();
    }

    public int calculateDtToFit(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 != 0) {
            if (i14 == 1) {
                return i13 - i11;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i15 = i12 - i10;
        if (i15 > 0) {
            return i15;
        }
        int i16 = i13 - i11;
        if (i16 < 0) {
            return i16;
        }
        return 0;
    }

    public int calculateDxToMakeVisible(View view, int i10) {
        RecyclerView.l layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i10);
    }

    public int calculateDyToMakeVisible(View view, int i10) {
        RecyclerView.l layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i10);
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int calculateTimeForDeceleration(int i10) {
        return (int) Math.ceil(calculateTimeForScrolling(i10) / 0.3356d);
    }

    public int calculateTimeForScrolling(int i10) {
        float fAbs = Math.abs(i10);
        if (!this.f4231m) {
            this.f4232n = calculateSpeedPerPixel(this.f4230l);
            this.f4231m = true;
        }
        return (int) Math.ceil(fAbs * this.f4232n);
    }

    public int getHorizontalSnapPreference() {
        PointF pointF = this.f4229k;
        if (pointF != null) {
            float f10 = pointF.x;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF pointF = this.f4229k;
        if (pointF != null) {
            float f10 = pointF.y;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public void onSeekTargetStep(int i10, int i11, RecyclerView.w wVar, RecyclerView.v.a aVar) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        int i12 = this.f4233o;
        int i13 = i12 - i10;
        if (i12 * i13 <= 0) {
            i13 = 0;
        }
        this.f4233o = i13;
        int i14 = this.f4234p;
        int i15 = i14 - i11;
        int i16 = i14 * i15 > 0 ? i15 : 0;
        this.f4234p = i16;
        if (i13 == 0 && i16 == 0) {
            updateActionForInterimTarget(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public void onStop() {
        this.f4234p = 0;
        this.f4233o = 0;
        this.f4229k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public void onTargetFound(View view, RecyclerView.w wVar, RecyclerView.v.a aVar) {
        int iCalculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int iCalculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((iCalculateDyToMakeVisible * iCalculateDyToMakeVisible) + (iCalculateDxToMakeVisible * iCalculateDxToMakeVisible)));
        if (iCalculateTimeForDeceleration > 0) {
            aVar.update(-iCalculateDxToMakeVisible, -iCalculateDyToMakeVisible, iCalculateTimeForDeceleration, this.f4228j);
        }
    }

    public void updateActionForInterimTarget(RecyclerView.v.a aVar) {
        PointF pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (pointFComputeScrollVectorForPosition == null || (pointFComputeScrollVectorForPosition.x == 0.0f && pointFComputeScrollVectorForPosition.y == 0.0f)) {
            aVar.jumpTo(getTargetPosition());
            stop();
            return;
        }
        normalize(pointFComputeScrollVectorForPosition);
        this.f4229k = pointFComputeScrollVectorForPosition;
        this.f4233o = (int) (pointFComputeScrollVectorForPosition.x * 10000.0f);
        this.f4234p = (int) (pointFComputeScrollVectorForPosition.y * 10000.0f);
        aVar.update((int) (this.f4233o * 1.2f), (int) (this.f4234p * 1.2f), (int) (calculateTimeForScrolling(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT) * 1.2f), this.f4227i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public void onStart() {
    }
}
