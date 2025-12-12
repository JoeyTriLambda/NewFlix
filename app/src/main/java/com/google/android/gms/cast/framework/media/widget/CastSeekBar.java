package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class CastSeekBar extends View {
    public static final /* synthetic */ int E = 0;
    public final int A;
    public int[] B;
    public Point C;
    public zza D;

    /* renamed from: b, reason: collision with root package name */
    public zze f6635b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6636m;

    /* renamed from: n, reason: collision with root package name */
    public Integer f6637n;

    /* renamed from: o, reason: collision with root package name */
    public zzc f6638o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f6639p;

    /* renamed from: q, reason: collision with root package name */
    public zzd f6640q;

    /* renamed from: r, reason: collision with root package name */
    public final float f6641r;

    /* renamed from: s, reason: collision with root package name */
    public final float f6642s;

    /* renamed from: t, reason: collision with root package name */
    public final float f6643t;

    /* renamed from: u, reason: collision with root package name */
    public final float f6644u;

    /* renamed from: v, reason: collision with root package name */
    public final float f6645v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f6646w;

    /* renamed from: x, reason: collision with root package name */
    public final int f6647x;

    /* renamed from: y, reason: collision with root package name */
    public final int f6648y;

    /* renamed from: z, reason: collision with root package name */
    public final int f6649z;

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int a(int i10) {
        return (int) ((i10 / ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) * this.f6635b.f6702b);
    }

    public final void b(Canvas canvas, int i10, int i11, int i12, int i13, int i14) {
        Paint paint = this.f6646w;
        paint.setColor(i14);
        float f10 = i12;
        float f11 = i11 / f10;
        float f12 = i10 / f10;
        float f13 = i13;
        float f14 = this.f6643t;
        canvas.drawRect(f12 * f13, -f14, f11 * f13, f14, paint);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.google.android.gms.cast.framework.media.widget.zza] */
    public final void c(int i10) {
        zze zzeVar = this.f6635b;
        if (zzeVar.f6706f) {
            int i11 = zzeVar.f6704d;
            this.f6637n = Integer.valueOf(Math.min(Math.max(i10, i11), zzeVar.f6705e));
            zzd zzdVar = this.f6640q;
            if (zzdVar != null) {
                zzdVar.zza(this, getProgress(), true);
            }
            zza zzaVar = this.D;
            if (zzaVar == null) {
                this.D = new Runnable() { // from class: com.google.android.gms.cast.framework.media.widget.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6695b.sendAccessibilityEvent(4);
                    }
                };
            } else {
                removeCallbacks(zzaVar);
            }
            postDelayed(this.D, 200L);
            postInvalidate();
        }
    }

    public int getMaxProgress() {
        return this.f6635b.f6702b;
    }

    public int getProgress() {
        Integer num = this.f6637n;
        return num != null ? num.intValue() : this.f6635b.f6701a;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        zza zzaVar = this.D;
        if (zzaVar != null) {
            removeCallbacks(zzaVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        zzc zzcVar = this.f6638o;
        if (zzcVar == null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int progress = getProgress();
            int iSave2 = canvas.save();
            canvas.translate(0.0f, measuredHeight / 2);
            zze zzeVar = this.f6635b;
            if (zzeVar.f6706f) {
                int i10 = zzeVar.f6704d;
                if (i10 > 0) {
                    b(canvas, 0, i10, zzeVar.f6702b, measuredWidth, this.f6649z);
                }
                zze zzeVar2 = this.f6635b;
                int i11 = zzeVar2.f6704d;
                if (progress > i11) {
                    b(canvas, i11, progress, zzeVar2.f6702b, measuredWidth, this.f6647x);
                }
                zze zzeVar3 = this.f6635b;
                int i12 = zzeVar3.f6705e;
                if (i12 > progress) {
                    b(canvas, progress, i12, zzeVar3.f6702b, measuredWidth, this.f6648y);
                }
                zze zzeVar4 = this.f6635b;
                int i13 = zzeVar4.f6702b;
                int i14 = zzeVar4.f6705e;
                if (i13 > i14) {
                    b(canvas, i14, i13, i13, measuredWidth, this.f6649z);
                }
            } else {
                int iMax = Math.max(zzeVar.f6703c, 0);
                if (iMax > 0) {
                    b(canvas, 0, iMax, this.f6635b.f6702b, measuredWidth, this.f6649z);
                }
                if (progress > iMax) {
                    b(canvas, iMax, progress, this.f6635b.f6702b, measuredWidth, this.f6647x);
                }
                int i15 = this.f6635b.f6702b;
                if (i15 > progress) {
                    b(canvas, progress, i15, i15, measuredWidth, this.f6649z);
                }
            }
            canvas.restoreToCount(iSave2);
            ArrayList<zzb> arrayList = this.f6639p;
            Paint paint = this.f6646w;
            if (arrayList != null && !arrayList.isEmpty()) {
                paint.setColor(this.A);
                int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                int iSave3 = canvas.save();
                canvas.translate(0.0f, measuredHeight2 / 2);
                for (zzb zzbVar : arrayList) {
                    if (zzbVar != null) {
                        int iMin = Math.min(zzbVar.f6696a, this.f6635b.f6702b);
                        int i16 = (zzbVar.f6698c ? zzbVar.f6697b : 1) + iMin;
                        float f10 = measuredWidth2;
                        float f11 = this.f6635b.f6702b;
                        float f12 = (i16 * f10) / f11;
                        float f13 = (iMin * f10) / f11;
                        float f14 = f12 - f13;
                        float f15 = this.f6645v;
                        if (f14 < f15) {
                            f12 = f13 + f15;
                        }
                        if (f12 > f10) {
                            f12 = f10;
                        }
                        if (f12 - f13 < f15) {
                            f13 = f12 - f15;
                        }
                        float f16 = this.f6643t;
                        canvas.drawRect(f13, -f16, f12, f16, paint);
                    }
                }
                canvas.restoreToCount(iSave3);
            }
            if (isEnabled() && this.f6635b.f6706f) {
                paint.setColor(this.f6647x);
                int measuredWidth3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                double progress2 = getProgress();
                double d10 = this.f6635b.f6702b;
                int iSave4 = canvas.save();
                canvas.drawCircle((int) ((progress2 / d10) * measuredWidth3), measuredHeight3 / 2.0f, this.f6644u, paint);
                canvas.restoreToCount(iSave4);
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight4 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int iSave5 = canvas.save();
            canvas.translate(0.0f, measuredHeight4 / 2);
            b(canvas, 0, zzcVar.f6699a, zzcVar.f6700b, measuredWidth4, this.A);
            int i17 = this.f6649z;
            int i18 = zzcVar.f6699a;
            int i19 = zzcVar.f6700b;
            b(canvas, i18, i19, i19, measuredWidth4, i17);
            canvas.restoreToCount(iSave5);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        float paddingLeft = getPaddingLeft();
        setMeasuredDimension(View.resolveSizeAndState((int) (this.f6641r + paddingLeft + getPaddingRight()), i10, 0), View.resolveSizeAndState((int) (this.f6642s + getPaddingTop() + getPaddingBottom()), i11, 0));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f6635b.f6706f) {
            if (this.C == null) {
                this.C = new Point();
            }
            if (this.B == null) {
                this.B = new int[2];
            }
            getLocationOnScreen(this.B);
            this.C.set((((int) motionEvent.getRawX()) - this.B[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.B[1]);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f6636m = true;
                zzd zzdVar = this.f6640q;
                if (zzdVar != null) {
                    zzdVar.zzb(this);
                }
                c(a(this.C.x));
                return true;
            }
            if (action == 1) {
                c(a(this.C.x));
                this.f6636m = false;
                zzd zzdVar2 = this.f6640q;
                if (zzdVar2 != null) {
                    zzdVar2.zzc(this);
                }
                return true;
            }
            if (action == 2) {
                c(a(this.C.x));
                return true;
            }
            if (action == 3) {
                this.f6636m = false;
                this.f6637n = null;
                zzd zzdVar3 = this.f6640q;
                if (zzdVar3 != null) {
                    zzdVar3.zza(this, getProgress(), true);
                    this.f6640q.zzc(this);
                }
                postInvalidate();
                return true;
            }
        }
        return false;
    }

    public final void zzd(List list) {
        if (Objects.equal(this.f6639p, list)) {
            return;
        }
        this.f6639p = list == null ? null : new ArrayList(list);
        postInvalidate();
    }

    public final void zze(zze zzeVar) {
        if (this.f6636m) {
            return;
        }
        zze zzeVar2 = new zze();
        zzeVar2.f6701a = zzeVar.f6701a;
        zzeVar2.f6702b = zzeVar.f6702b;
        zzeVar2.f6703c = zzeVar.f6703c;
        zzeVar2.f6704d = zzeVar.f6704d;
        zzeVar2.f6705e = zzeVar.f6705e;
        zzeVar2.f6706f = zzeVar.f6706f;
        this.f6635b = zzeVar2;
        this.f6637n = null;
        zzd zzdVar = this.f6640q;
        if (zzdVar != null) {
            zzdVar.zza(this, getProgress(), false);
        }
        postInvalidate();
    }

    public CastSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f6639p = new ArrayList();
        setAccessibilityDelegate(new zzg(this));
        Paint paint = new Paint(1);
        this.f6646w = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f6641r = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.f6642s = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.f6643t = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.f6644u = context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.f6645v = context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        zze zzeVar = new zze();
        this.f6635b = zzeVar;
        zzeVar.f6702b = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.f6647x = context.getResources().getColor(resourceId);
        this.f6648y = context.getResources().getColor(resourceId2);
        this.f6649z = context.getResources().getColor(resourceId3);
        this.A = context.getResources().getColor(resourceId4);
        typedArrayObtainStyledAttributes.recycle();
    }
}
