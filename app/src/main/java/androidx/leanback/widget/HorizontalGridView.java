package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.leanback.R;
import androidx.leanback.widget.j;

/* loaded from: classes.dex */
public class HorizontalGridView extends b {
    public boolean X0;
    public boolean Y0;
    public Paint Z0;

    /* renamed from: a1, reason: collision with root package name */
    public Bitmap f3057a1;

    /* renamed from: b1, reason: collision with root package name */
    public LinearGradient f3058b1;

    /* renamed from: c1, reason: collision with root package name */
    public int f3059c1;

    /* renamed from: d1, reason: collision with root package name */
    public int f3060d1;

    /* renamed from: e1, reason: collision with root package name */
    public Bitmap f3061e1;

    /* renamed from: f1, reason: collision with root package name */
    public LinearGradient f3062f1;

    /* renamed from: g1, reason: collision with root package name */
    public int f3063g1;

    /* renamed from: h1, reason: collision with root package name */
    public int f3064h1;

    /* renamed from: i1, reason: collision with root package name */
    public final Rect f3065i1;

    public HorizontalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Bitmap getTempBitmapHigh() {
        Bitmap bitmap = this.f3061e1;
        if (bitmap == null || bitmap.getWidth() != this.f3063g1 || this.f3061e1.getHeight() != getHeight()) {
            this.f3061e1 = Bitmap.createBitmap(this.f3063g1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f3061e1;
    }

    private Bitmap getTempBitmapLow() {
        Bitmap bitmap = this.f3057a1;
        if (bitmap == null || bitmap.getWidth() != this.f3059c1 || this.f3057a1.getHeight() != getHeight()) {
            this.f3057a1 = Bitmap.createBitmap(this.f3059c1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f3057a1;
    }

    public final void Z() {
        if (this.X0 || this.Y0) {
            setLayerType(2, null);
            setWillNotDraw(false);
        } else {
            setLayerType(0, null);
            setWillNotDraw(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        boolean z11 = this.X0;
        j jVar = this.Q0;
        boolean z12 = true;
        if (z11) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                jVar.getClass();
                j.d dVar = (j.d) childAt.getLayoutParams();
                dVar.getClass();
                if (childAt.getLeft() + dVar.f3264e < getPaddingLeft() - this.f3060d1) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (this.Y0) {
            for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
                View childAt2 = getChildAt(childCount2);
                jVar.getClass();
                j.d dVar2 = (j.d) childAt2.getLayoutParams();
                dVar2.getClass();
                if (childAt2.getRight() - dVar2.f3266g > (getWidth() - getPaddingRight()) + this.f3064h1) {
                    break;
                }
            }
            z12 = false;
        } else {
            z12 = false;
        }
        if (!z10) {
            this.f3057a1 = null;
        }
        if (!z12) {
            this.f3061e1 = null;
        }
        if (!z10 && !z12) {
            super.draw(canvas);
            return;
        }
        int paddingLeft = this.X0 ? (getPaddingLeft() - this.f3060d1) - this.f3059c1 : 0;
        int width = this.Y0 ? (getWidth() - getPaddingRight()) + this.f3064h1 + this.f3063g1 : getWidth();
        int iSave = canvas.save();
        canvas.clipRect((this.X0 ? this.f3059c1 : 0) + paddingLeft, 0, width - (this.Y0 ? this.f3063g1 : 0), getHeight());
        super.draw(canvas);
        canvas.restoreToCount(iSave);
        Canvas canvas2 = new Canvas();
        Rect rect = this.f3065i1;
        rect.top = 0;
        rect.bottom = getHeight();
        if (z10 && this.f3059c1 > 0) {
            Bitmap tempBitmapLow = getTempBitmapLow();
            tempBitmapLow.eraseColor(0);
            canvas2.setBitmap(tempBitmapLow);
            int iSave2 = canvas2.save();
            canvas2.clipRect(0, 0, this.f3059c1, getHeight());
            float f10 = -paddingLeft;
            canvas2.translate(f10, 0.0f);
            super.draw(canvas2);
            canvas2.restoreToCount(iSave2);
            this.Z0.setShader(this.f3058b1);
            canvas2.drawRect(0.0f, 0.0f, this.f3059c1, getHeight(), this.Z0);
            rect.left = 0;
            rect.right = this.f3059c1;
            canvas.translate(paddingLeft, 0.0f);
            canvas.drawBitmap(tempBitmapLow, rect, rect, (Paint) null);
            canvas.translate(f10, 0.0f);
        }
        if (!z12 || this.f3063g1 <= 0) {
            return;
        }
        Bitmap tempBitmapHigh = getTempBitmapHigh();
        tempBitmapHigh.eraseColor(0);
        canvas2.setBitmap(tempBitmapHigh);
        int iSave3 = canvas2.save();
        canvas2.clipRect(0, 0, this.f3063g1, getHeight());
        canvas2.translate(-(width - this.f3063g1), 0.0f);
        super.draw(canvas2);
        canvas2.restoreToCount(iSave3);
        this.Z0.setShader(this.f3062f1);
        canvas2.drawRect(0.0f, 0.0f, this.f3063g1, getHeight(), this.Z0);
        rect.left = 0;
        rect.right = this.f3063g1;
        canvas.translate(width - r3, 0.0f);
        canvas.drawBitmap(tempBitmapHigh, rect, rect, (Paint) null);
        canvas.translate(-(width - this.f3063g1), 0.0f);
    }

    public final boolean getFadingLeftEdge() {
        return this.X0;
    }

    public final int getFadingLeftEdgeLength() {
        return this.f3059c1;
    }

    public final int getFadingLeftEdgeOffset() {
        return this.f3060d1;
    }

    public final boolean getFadingRightEdge() {
        return this.Y0;
    }

    public final int getFadingRightEdgeLength() {
        return this.f3063g1;
    }

    public final int getFadingRightEdgeOffset() {
        return this.f3064h1;
    }

    public void initAttributes(Context context, AttributeSet attributeSet) {
        X(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbHorizontalGridView);
        setRowHeight(typedArrayObtainStyledAttributes);
        setNumRows(typedArrayObtainStyledAttributes.getInt(R.styleable.lbHorizontalGridView_numberOfRows, 1));
        typedArrayObtainStyledAttributes.recycle();
        Z();
        Paint paint = new Paint();
        this.Z0 = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void setFadingLeftEdge(boolean z10) {
        if (this.X0 != z10) {
            this.X0 = z10;
            if (!z10) {
                this.f3057a1 = null;
            }
            invalidate();
            Z();
        }
    }

    public final void setFadingLeftEdgeLength(int i10) {
        if (this.f3059c1 != i10) {
            this.f3059c1 = i10;
            if (i10 != 0) {
                this.f3058b1 = new LinearGradient(0.0f, 0.0f, this.f3059c1, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
            } else {
                this.f3058b1 = null;
            }
            invalidate();
        }
    }

    public final void setFadingLeftEdgeOffset(int i10) {
        if (this.f3060d1 != i10) {
            this.f3060d1 = i10;
            invalidate();
        }
    }

    public final void setFadingRightEdge(boolean z10) {
        if (this.Y0 != z10) {
            this.Y0 = z10;
            if (!z10) {
                this.f3061e1 = null;
            }
            invalidate();
            Z();
        }
    }

    public final void setFadingRightEdgeLength(int i10) {
        if (this.f3063g1 != i10) {
            this.f3063g1 = i10;
            if (i10 != 0) {
                this.f3062f1 = new LinearGradient(0.0f, 0.0f, this.f3063g1, 0.0f, -16777216, 0, Shader.TileMode.CLAMP);
            } else {
                this.f3062f1 = null;
            }
            invalidate();
        }
    }

    public final void setFadingRightEdgeOffset(int i10) {
        if (this.f3064h1 != i10) {
            this.f3064h1 = i10;
            invalidate();
        }
    }

    public void setNumRows(int i10) {
        this.Q0.setNumRows(i10);
        requestLayout();
    }

    public void setRowHeight(TypedArray typedArray) {
        int i10 = R.styleable.lbHorizontalGridView_rowHeight;
        if (typedArray.peekValue(i10) != null) {
            setRowHeight(typedArray.getLayoutDimension(i10, 0));
        }
    }

    public HorizontalGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Z0 = new Paint();
        this.f3065i1 = new Rect();
        this.Q0.setOrientation(0);
        initAttributes(context, attributeSet);
    }

    public void setRowHeight(int i10) {
        this.Q0.setRowHeight(i10);
        requestLayout();
    }
}
