package fd;

import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* compiled from: Dpad.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f11538a = -1;

    public int getDirectionPressed(InputEvent inputEvent) {
        if (inputEvent instanceof MotionEvent) {
            MotionEvent motionEvent = (MotionEvent) inputEvent;
            float axisValue = motionEvent.getAxisValue(15);
            float axisValue2 = motionEvent.getAxisValue(16);
            if (Float.compare(axisValue, -1.0f) == 0) {
                this.f11538a = 1;
            } else if (Float.compare(axisValue, 1.0f) == 0) {
                this.f11538a = 2;
            } else if (Float.compare(axisValue2, -1.0f) == 0) {
                this.f11538a = 0;
            } else if (Float.compare(axisValue2, 1.0f) == 0) {
                this.f11538a = 3;
            }
        } else if (inputEvent instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) inputEvent;
            if (keyEvent.getKeyCode() == 21) {
                this.f11538a = 1;
            } else if (keyEvent.getKeyCode() == 22) {
                this.f11538a = 2;
            } else if (keyEvent.getKeyCode() == 19) {
                this.f11538a = 0;
            } else if (keyEvent.getKeyCode() == 20) {
                this.f11538a = 3;
            } else if (keyEvent.getKeyCode() == 23) {
                this.f11538a = 4;
            } else if (keyEvent.getKeyCode() == 231) {
                this.f11538a = 231;
            } else if (keyEvent.getKeyCode() == 85) {
                this.f11538a = 5;
            } else if (keyEvent.getKeyCode() == 90) {
                this.f11538a = 6;
            } else if (keyEvent.getKeyCode() == 89) {
                this.f11538a = 7;
            } else if (keyEvent.getKeyCode() == 126) {
                this.f11538a = 8;
            } else if (keyEvent.getKeyCode() == 127) {
                this.f11538a = 9;
            } else if (keyEvent.getKeyCode() == 4) {
                this.f11538a = 10;
            } else if (keyEvent.getKeyCode() == 82) {
                this.f11538a = 11;
            }
        }
        return this.f11538a;
    }
}
