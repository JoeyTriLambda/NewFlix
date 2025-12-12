package flix.com.vision.bvp;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class OnSwipeTouchListener implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public int f12158b;

    /* renamed from: m, reason: collision with root package name */
    public float f12159m;

    /* renamed from: n, reason: collision with root package name */
    public float f12160n;

    /* renamed from: o, reason: collision with root package name */
    public float f12161o;

    /* renamed from: p, reason: collision with root package name */
    public float f12162p;

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public abstract void onAfterMove();

    public abstract void onBeforeMove(Direction direction);

    public abstract void onClick();

    public abstract void onMove(Direction direction, float f10);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x10;
        float y10;
        float f10;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f12159m = motionEvent.getX();
            this.f12160n = motionEvent.getY();
            this.f12158b = 0;
        } else {
            if (actionMasked == 1) {
                motionEvent.getX();
                motionEvent.getY();
                if (this.f12158b == 0) {
                    onClick();
                    return true;
                }
                onAfterMove();
                this.f12158b = 0;
                return true;
            }
            if (actionMasked == 2) {
                if (this.f12158b == 0) {
                    x10 = motionEvent.getX() - this.f12159m;
                    y10 = motionEvent.getY();
                    f10 = this.f12160n;
                } else {
                    x10 = motionEvent.getX() - this.f12161o;
                    y10 = motionEvent.getY();
                    f10 = this.f12162p;
                }
                float f11 = y10 - f10;
                int i10 = this.f12158b;
                Direction direction = Direction.DOWN;
                Direction direction2 = Direction.UP;
                Direction direction3 = Direction.RIGHT;
                Direction direction4 = Direction.LEFT;
                if (i10 == 0 && Math.abs(x10) > 100.0f) {
                    this.f12158b = 1;
                    this.f12161o = motionEvent.getX();
                    this.f12162p = motionEvent.getY();
                    if (x10 > 0.0f) {
                        onBeforeMove(direction3);
                    } else {
                        onBeforeMove(direction4);
                    }
                } else if (this.f12158b == 0 && Math.abs(f11) > 100.0f) {
                    this.f12158b = 2;
                    this.f12161o = motionEvent.getX();
                    this.f12162p = motionEvent.getY();
                    if (f11 > 0.0f) {
                        onBeforeMove(direction);
                    } else {
                        onBeforeMove(direction2);
                    }
                }
                int i11 = this.f12158b;
                if (i11 == 1) {
                    if (x10 > 0.0f) {
                        onMove(direction3, x10);
                    } else {
                        onMove(direction4, -x10);
                    }
                } else if (i11 == 2) {
                    if (f11 > 0.0f) {
                        onMove(direction, f11);
                    } else {
                        onMove(direction2, -f11);
                    }
                }
            }
        }
        return true;
    }
}
