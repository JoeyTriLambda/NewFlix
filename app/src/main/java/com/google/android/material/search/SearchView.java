package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k7.e;
import q7.i;

/* loaded from: classes.dex */
public final class SearchView extends FrameLayout implements CoordinatorLayout.b, k7.b {

    /* renamed from: b, reason: collision with root package name */
    public SearchBar f9248b;

    /* renamed from: m, reason: collision with root package name */
    public int f9249m;

    /* renamed from: n, reason: collision with root package name */
    public TransitionState f9250n;

    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (searchView.isSetupWithSearchBar() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }
    }

    public enum TransitionState {
        HIDING,
        HIDDEN,
        /* JADX INFO: Fake field, exist only in values array */
        SHOWING,
        SHOWN
    }

    public static class a extends f1.a {
        public static final Parcelable.Creator<a> CREATOR = new C0090a();

        /* renamed from: n, reason: collision with root package name */
        public String f9255n;

        /* renamed from: o, reason: collision with root package name */
        public int f9256o;

        /* renamed from: com.google.android.material.search.SearchView$a$a, reason: collision with other inner class name */
        public class C0090a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i10) {
                return new a[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        }

        public a(Parcel parcel) {
            this(parcel, null);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f9255n);
            parcel.writeInt(this.f9256o);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9255n = parcel.readString();
            this.f9256o = parcel.readInt();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface b {
        void onStateChanged(SearchView searchView, TransitionState transitionState, TransitionState transitionState2);
    }

    private Window getActivityWindow() {
        Activity activity = i7.a.getActivity(getContext());
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f9248b;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        throw null;
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 != -1) {
            addHeaderView(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) null, false));
        }
    }

    private void setUpStatusBarSpacer(int i10) {
        throw null;
    }

    public final boolean a() {
        return this.f9250n.equals(TransitionState.HIDDEN) || this.f9250n.equals(TransitionState.HIDING);
    }

    public void addHeaderView(View view) {
        throw null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
    }

    @Override // k7.b
    public void cancelBackProgress() {
        if (!a() && this.f9248b != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    public e getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.f9250n;
    }

    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return null;
    }

    public CharSequence getHint() {
        throw null;
    }

    public TextView getSearchPrefix() {
        return null;
    }

    public CharSequence getSearchPrefixText() {
        throw null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f9249m;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        throw null;
    }

    public Toolbar getToolbar() {
        return null;
    }

    @Override // k7.b
    public void handleBackInvoked() {
        if (!a()) {
            throw null;
        }
    }

    public boolean isSetupWithSearchBar() {
        return this.f9248b != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateSoftInputMode();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setText(aVar.f9255n);
        setVisible(aVar.f9256o == 0);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        Editable text = getText();
        aVar.f9255n = text == null ? null : text.toString();
        throw null;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        setUpBackgroundViewElevationOverlay(f10);
    }

    public void setHint(CharSequence charSequence) {
        throw null;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            new HashMap(viewGroup.getChildCount());
        }
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            if (viewGroup.getChildAt(i10) != this) {
                throw null;
            }
        }
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        throw null;
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        throw null;
    }

    public void setStatusBarSpacerEnabled(boolean z10) {
        setStatusBarSpacerEnabledInternal(z10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        throw null;
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        throw null;
    }

    public void setTransitionState(TransitionState transitionState) {
        if (this.f9250n.equals(transitionState)) {
            return;
        }
        if (transitionState == TransitionState.SHOWN) {
            setModalForAccessibility(true);
        } else if (transitionState == TransitionState.HIDDEN) {
            setModalForAccessibility(false);
        }
        TransitionState transitionState2 = this.f9250n;
        this.f9250n = transitionState;
        Iterator it = new LinkedHashSet((Collection) null).iterator();
        while (it.hasNext()) {
            ((b) it.next()).onStateChanged(this, transitionState2, transitionState);
        }
    }

    public void setVisible(boolean z10) {
        throw null;
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f9248b = searchBar;
        throw null;
    }

    @Override // k7.b
    public void startBackProgress(androidx.activity.b bVar) {
        if (!a() && this.f9248b != null) {
            throw null;
        }
    }

    @Override // k7.b
    public void updateBackProgress(androidx.activity.b bVar) {
        if (!a() && this.f9248b != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    public void updateSoftInputMode() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f9249m = activityWindow.getAttributes().softInputMode;
        }
    }

    public void setHint(int i10) {
        throw null;
    }

    public void setText(int i10) {
        throw null;
    }

    private void setUpBackgroundViewElevationOverlay(float f10) {
    }

    public void setAnimatedNavigationIcon(boolean z10) {
    }

    public void setAutoShowKeyboard(boolean z10) {
    }

    public void setMenuItemsAnimated(boolean z10) {
    }

    public void setUseWindowInsetsController(boolean z10) {
    }
}
