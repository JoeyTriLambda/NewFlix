package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DividerItemDecoration.java */
/* loaded from: classes.dex */
public final class i extends RecyclerView.k {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f4168d = {R.attr.listDivider};

    /* renamed from: a, reason: collision with root package name */
    public Drawable f4169a;

    /* renamed from: b, reason: collision with root package name */
    public int f4170b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f4171c = new Rect();

    public i(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f4168d);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f4169a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.w wVar) {
        Drawable drawable = this.f4169a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f4170b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar) {
        int height;
        int paddingTop;
        int width;
        int paddingLeft;
        if (recyclerView.getLayoutManager() == null || this.f4169a == null) {
            return;
        }
        int i10 = this.f4170b;
        Rect rect = this.f4171c;
        int i11 = 0;
        if (i10 == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingLeft = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                paddingLeft = 0;
            }
            int childCount = recyclerView.getChildCount();
            while (i11 < childCount) {
                View childAt = recyclerView.getChildAt(i11);
                recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                int iRound = Math.round(childAt.getTranslationY()) + rect.bottom;
                this.f4169a.setBounds(paddingLeft, iRound - this.f4169a.getIntrinsicHeight(), width, iRound);
                this.f4169a.draw(canvas);
                i11++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount2 = recyclerView.getChildCount();
        while (i11 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i11);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, rect);
            int iRound2 = Math.round(childAt2.getTranslationX()) + rect.right;
            this.f4169a.setBounds(iRound2 - this.f4169a.getIntrinsicWidth(), paddingTop, iRound2, height);
            this.f4169a.draw(canvas);
            i11++;
        }
        canvas.restore();
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f4169a = drawable;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f4170b = i10;
    }
}
