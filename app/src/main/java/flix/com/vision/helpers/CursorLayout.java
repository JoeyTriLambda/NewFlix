package flix.com.vision.helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import cz.msebera.android.httpclient.HttpStatus;
import gd.m;

/* loaded from: classes2.dex */
public class CursorLayout extends FrameLayout {
    public static float A = 0.0f;
    public static int B = 100;

    /* renamed from: y, reason: collision with root package name */
    public static int f12329y;

    /* renamed from: z, reason: collision with root package name */
    public static float f12330z;

    /* renamed from: b, reason: collision with root package name */
    public m f12331b;

    /* renamed from: m, reason: collision with root package name */
    public final Point f12332m;

    /* renamed from: n, reason: collision with root package name */
    public final a f12333n;

    /* renamed from: o, reason: collision with root package name */
    public final PointF f12334o;

    /* renamed from: p, reason: collision with root package name */
    public final PointF f12335p;

    /* renamed from: q, reason: collision with root package name */
    public final b f12336q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12337r;

    /* renamed from: s, reason: collision with root package name */
    public long f12338s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f12339t;

    /* renamed from: u, reason: collision with root package name */
    public final PointF f12340u;

    /* renamed from: v, reason: collision with root package name */
    public int f12341v;

    /* renamed from: w, reason: collision with root package name */
    public int f12342w;

    /* renamed from: x, reason: collision with root package name */
    public int f12343x;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CursorLayout cursorLayout = CursorLayout.this;
            cursorLayout.invalidate();
            m mVar = cursorLayout.f12331b;
            if (mVar != null) {
                try {
                    mVar.infoToggle(false);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CursorLayout cursorLayout = CursorLayout.this;
            Handler handler = cursorLayout.getHandler();
            a aVar = cursorLayout.f12333n;
            if (handler != null) {
                cursorLayout.getHandler().removeCallbacks(aVar);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = jCurrentTimeMillis - cursorLayout.f12338s;
            cursorLayout.f12338s = jCurrentTimeMillis;
            float f10 = j10 * 0.05f;
            PointF pointF = cursorLayout.f12335p;
            float f11 = pointF.x;
            Point point = cursorLayout.f12332m;
            pointF.set(cursorLayout.bound((cursorLayout.bound(point.x, 1.0f) * f10) + f11, CursorLayout.A), cursorLayout.bound((cursorLayout.bound(point.y, 1.0f) * f10) + pointF.y, CursorLayout.A));
            if (Math.abs(pointF.x) < 0.1f) {
                pointF.x = 0.0f;
            }
            if (Math.abs(pointF.y) < 0.1f) {
                pointF.y = 0.0f;
            }
            if (point.x == 0 && point.y == 0 && pointF.x == 0.0f && pointF.y == 0.0f) {
                if (cursorLayout.getHandler() != null) {
                    cursorLayout.getHandler().postDelayed(aVar, 5000L);
                    return;
                }
                return;
            }
            PointF pointF2 = cursorLayout.f12340u;
            PointF pointF3 = cursorLayout.f12334o;
            pointF2.set(pointF3);
            pointF3.offset(pointF.x, pointF.y);
            float f12 = pointF3.x;
            if (f12 < 0.0f) {
                pointF3.x = 0.0f;
            } else if (f12 > cursorLayout.getWidth() - 1) {
                pointF3.x = cursorLayout.getWidth() - 1;
            }
            float f13 = pointF3.y;
            if (f13 < 0.0f) {
                pointF3.y = 0.0f;
            } else if (f13 > cursorLayout.getHeight() - 1) {
                pointF3.y = cursorLayout.getHeight() - 1;
            }
            if (!pointF2.equals(pointF3) && cursorLayout.f12337r) {
                cursorLayout.dispatchMotionEvent(pointF3.x, pointF3.y, 2);
            }
            View childAt = cursorLayout.getChildAt(0);
            if (childAt != null) {
                float f14 = pointF3.y;
                int height = cursorLayout.getHeight();
                int i10 = CursorLayout.B;
                if (f14 > height - i10) {
                    float f15 = pointF.y;
                    if (f15 > 0.0f && childAt.canScrollVertically((int) f15)) {
                        childAt.scrollTo(childAt.getScrollX(), childAt.getScrollY() + ((int) pointF.y));
                    }
                } else if (pointF3.y < i10) {
                    float f16 = pointF.y;
                    if (f16 < 0.0f && childAt.canScrollVertically((int) f16)) {
                        childAt.scrollTo(childAt.getScrollX(), childAt.getScrollY() + ((int) pointF.y));
                    }
                }
                float f17 = pointF3.x;
                int width = cursorLayout.getWidth();
                int i11 = CursorLayout.B;
                if (f17 > width - i11) {
                    float f18 = pointF.x;
                    if (f18 > 0.0f && childAt.canScrollHorizontally((int) f18)) {
                        childAt.scrollTo(childAt.getScrollX() + ((int) pointF.x), childAt.getScrollY());
                    }
                } else if (pointF3.x < i11) {
                    float f19 = pointF.x;
                    if (f19 < 0.0f && childAt.canScrollHorizontally((int) f19)) {
                        childAt.scrollTo(childAt.getScrollX() + ((int) pointF.x), childAt.getScrollY());
                    }
                }
            }
            cursorLayout.invalidate();
            if (cursorLayout.getHandler() != null) {
                cursorLayout.getHandler().post(this);
            }
        }
    }

    public interface c {
    }

    public CursorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12332m = new Point(0, 0);
        this.f12333n = new a();
        this.f12334o = new PointF(0.0f, 0.0f);
        this.f12335p = new PointF(0.0f, 0.0f);
        this.f12336q = new b();
        this.f12337r = false;
        this.f12338s = System.currentTimeMillis();
        Paint paint = new Paint();
        this.f12339t = paint;
        this.f12340u = new PointF();
        this.f12341v = 255;
        this.f12342w = 255;
        this.f12343x = 255;
        if (isInEditMode()) {
            return;
        }
        paint.setAntiAlias(true);
        setWillNotDraw(false);
        Context context2 = getContext();
        getContext();
        Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i10 = point.x;
        int i11 = i10 / 20;
        f12330z = i10 / HttpStatus.SC_BAD_REQUEST;
        f12329y = i10 / 80;
        A = i10 / 25;
        B = i10 / 15;
    }

    public final void a(KeyEvent keyEvent, int i10, int i11, boolean z10) {
        this.f12338s = System.currentTimeMillis();
        if (!z10) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
            this.f12335p.set(0.0f, 0.0f);
        } else {
            if (getKeyDispatcherState().isTracking(keyEvent)) {
                return;
            }
            Handler handler = getHandler();
            b bVar = this.f12336q;
            handler.removeCallbacks(bVar);
            handler.post(bVar);
            getKeyDispatcherState().startTracking(keyEvent, this);
        }
        Point point = this.f12332m;
        if (i10 == -100) {
            i10 = point.x;
        }
        if (i11 == -100) {
            i11 = point.y;
        }
        point.set(i10, i11);
    }

    public float bound(float f10, float f11) {
        if (f10 > f11) {
            return f11;
        }
        float f12 = -f11;
        return f10 < f12 ? f12 : f10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        if (System.currentTimeMillis() - this.f12338s > 5000) {
            return;
        }
        PointF pointF = this.f12334o;
        float f10 = pointF.x;
        float f11 = pointF.y;
        Paint paint = this.f12339t;
        paint.setColor(Color.argb(128, this.f12341v, this.f12342w, this.f12343x));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f10, f11, f12329y, paint);
        paint.setColor(-7829368);
        paint.setStrokeWidth(f12330z);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f10, f11, f12329y, paint);
        m mVar = this.f12331b;
        if (mVar != null) {
            try {
                mVar.infoToggle(true);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        PointF pointF = this.f12334o;
        if (keyCode != 66 && keyCode != 160) {
            if (keyCode == 4) {
                try {
                    m mVar = this.f12331b;
                    if (mVar != null) {
                        mVar.showDialog();
                    }
                } catch (Exception unused) {
                }
                return true;
            }
            switch (keyCode) {
                case 19:
                    if (keyEvent.getAction() == 0) {
                        if (pointF.y <= 0.0f) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        a(keyEvent, -100, -1, true);
                    } else if (keyEvent.getAction() == 1) {
                        a(keyEvent, -100, 0, false);
                    }
                    return true;
                case 20:
                    if (keyEvent.getAction() == 0) {
                        if (pointF.y >= getHeight()) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        a(keyEvent, -100, 1, true);
                    } else if (keyEvent.getAction() == 1) {
                        a(keyEvent, -100, 0, false);
                    }
                    return true;
                case 21:
                    if (keyEvent.getAction() == 0) {
                        if (pointF.x <= 0.0f) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        a(keyEvent, -1, -100, true);
                    } else if (keyEvent.getAction() == 1) {
                        a(keyEvent, 0, -100, false);
                    }
                    return true;
                case 22:
                    if (keyEvent.getAction() == 0) {
                        if (pointF.x >= getWidth()) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        a(keyEvent, 1, -100, true);
                    } else if (keyEvent.getAction() == 1) {
                        a(keyEvent, 0, -100, false);
                    }
                    return true;
                case 23:
                    break;
                default:
                    switch (keyCode) {
                        case 268:
                            if (keyEvent.getAction() == 0) {
                                a(keyEvent, -1, -1, true);
                            } else if (keyEvent.getAction() == 1) {
                                a(keyEvent, 0, 0, false);
                            }
                            return true;
                        case 269:
                            if (keyEvent.getAction() == 0) {
                                a(keyEvent, -1, 1, true);
                            } else if (keyEvent.getAction() == 1) {
                                a(keyEvent, 0, 0, false);
                            }
                            return true;
                        case 270:
                            if (keyEvent.getAction() == 0) {
                                a(keyEvent, 1, -1, true);
                            } else if (keyEvent.getAction() == 1) {
                                a(keyEvent, 0, 0, false);
                            }
                            return true;
                        case 271:
                            if (keyEvent.getAction() == 0) {
                                a(keyEvent, 1, 1, true);
                            } else if (keyEvent.getAction() == 1) {
                                a(keyEvent, 0, 0, false);
                            }
                            return true;
                    }
            }
        }
        if (System.currentTimeMillis() - this.f12338s > 5000) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0 && !getKeyDispatcherState().isTracking(keyEvent)) {
            getKeyDispatcherState().startTracking(keyEvent, this);
            this.f12337r = true;
            dispatchMotionEvent(pointF.x, pointF.y, 0);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
            dispatchMotionEvent(pointF.x, pointF.y, 1);
            this.f12337r = false;
        }
        return true;
    }

    public void dispatchMotionEvent(float f10, float f11, int i10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = 0;
        pointerProperties.toolType = 1;
        MotionEvent.PointerProperties[] pointerPropertiesArr = {pointerProperties};
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f10;
        pointerCoords.y = f11;
        pointerCoords.pressure = 1.0f;
        pointerCoords.size = 1.0f;
        dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, i10, 1, pointerPropertiesArr, new MotionEvent.PointerCoords[]{pointerCoords}, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (isInEditMode()) {
            return;
        }
        this.f12334o.set(i10 / 2.0f, i11 / 2.0f);
        if (getHandler() != null) {
            getHandler().postDelayed(this.f12333n, 5000L);
        }
    }

    public void setActivity(m mVar) {
        this.f12331b = mVar;
    }

    public void setCursorColor(int i10, int i11, int i12) {
        this.f12341v = i10;
        this.f12342w = i11;
        this.f12343x = i12;
    }

    public void setCallback(c cVar) {
    }
}
