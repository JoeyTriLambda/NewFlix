package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.widget.o;
import x0.j0;
import y0.d;

/* loaded from: classes.dex */
public class CheckableImageButton extends o implements Checkable {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f9174r = {R.attr.state_checked};

    /* renamed from: o, reason: collision with root package name */
    public boolean f9175o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9176p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9177q;

    public class a extends x0.a {
        public a() {
        }

        @Override // x0.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            CheckableImageButton checkableImageButton = CheckableImageButton.this;
            dVar.setCheckable(checkableImageButton.isCheckable());
            dVar.setChecked(checkableImageButton.isChecked());
        }
    }

    public static class b extends f1.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public boolean f9179n;

        public class a implements Parcelable.ClassLoaderCreator<b> {
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i10) {
                return new b[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f9179n ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9179n = parcel.readInt() == 1;
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public boolean isCheckable() {
        return this.f9176p;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9175o;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        return this.f9175o ? View.mergeDrawableStates(super.onCreateDrawableState(i10 + 1), f9174r) : super.onCreateDrawableState(i10);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.f9179n);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f9179n = this.f9175o;
        return bVar;
    }

    public void setCheckable(boolean z10) {
        if (this.f9176p != z10) {
            this.f9176p = z10;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (!this.f9176p || this.f9175o == z10) {
            return;
        }
        this.f9175o = z10;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z10) {
        this.f9177q = z10;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (this.f9177q) {
            super.setPressed(z10);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f9175o);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9176p = true;
        this.f9177q = true;
        j0.setAccessibilityDelegate(this, new a());
    }
}
