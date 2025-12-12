package com.google.android.youtube.player;

import a8.e;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.youtube.player.a;
import com.google.android.youtube.player.b;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class YouTubePlayerView extends ViewGroup implements b.InterfaceC0093b {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f9546w = 0;

    /* renamed from: b, reason: collision with root package name */
    public final a f9547b;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f9548m;

    /* renamed from: n, reason: collision with root package name */
    public final b f9549n;

    /* renamed from: o, reason: collision with root package name */
    public a8.b f9550o;

    /* renamed from: p, reason: collision with root package name */
    public e f9551p;

    /* renamed from: q, reason: collision with root package name */
    public View f9552q;

    /* renamed from: r, reason: collision with root package name */
    public final a8.d f9553r;

    /* renamed from: s, reason: collision with root package name */
    public b.InterfaceC0093b f9554s;

    /* renamed from: t, reason: collision with root package name */
    public Bundle f9555t;

    /* renamed from: u, reason: collision with root package name */
    public b.a f9556u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9557v;

    public final class a implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            YouTubePlayerView youTubePlayerView = YouTubePlayerView.this;
            if (youTubePlayerView.f9551p != null) {
                HashSet hashSet = youTubePlayerView.f9548m;
                if (!hashSet.contains(view2) || hashSet.contains(view)) {
                    return;
                }
                youTubePlayerView.f9551p.g();
            }
        }
    }

    public interface b {
        void a(YouTubePlayerView youTubePlayerView);

        void a(YouTubePlayerView youTubePlayerView, String str, b.a aVar);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(View view) {
        if (!(view == this.f9553r || (this.f9551p != null && view == this.f9552q))) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    @Override // android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i10) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i10);
        arrayList.addAll(arrayList2);
        HashSet hashSet = this.f9548m;
        hashSet.clear();
        hashSet.addAll(arrayList2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        a(view);
        super.addView(view);
    }

    public final void b() {
        e eVar = this.f9551p;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f9551p != null) {
            if (keyEvent.getAction() == 0) {
                return this.f9551p.a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 1) {
                return this.f9551p.b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.f9548m.add(view);
    }

    public final void initialize(String str, b.a aVar) {
        a8.a.a(str, (Object) "Developer key cannot be null or empty");
        this.f9549n.a(this, str, aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f9547b);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e eVar = this.f9551p;
        if (eVar != null) {
            eVar.a(configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f9547b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        if (getChildCount() <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        View childAt = getChildAt(0);
        childAt.measure(i10, i11);
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f9548m.add(view2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i10) {
        super((Context) a8.a.a(context, "context cannot be null"), attributeSet, i10);
        if (!(context instanceof com.google.android.youtube.player.a)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
        }
        a.C0092a c0092a = ((com.google.android.youtube.player.a) context).f9559b;
        this.f9549n = (b) a8.a.a(c0092a, "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        setClipToPadding(false);
        a8.d dVar = new a8.d(context);
        this.f9553r = dVar;
        requestTransparentRegion(dVar);
        addView(dVar);
        this.f9548m = new HashSet();
        this.f9547b = new a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i10, i11);
        arrayList.addAll(arrayList2);
        HashSet hashSet = this.f9548m;
        hashSet.clear();
        hashSet.addAll(arrayList2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10) {
        a(view);
        super.addView(view, i10);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, int i11) {
        a(view);
        super.addView(view, i10, i11);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void setClipToPadding(boolean z10) {
    }

    @Override // android.view.View
    public final void setPadding(int i10, int i11, int i12, int i13) {
    }
}
