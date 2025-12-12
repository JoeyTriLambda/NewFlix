package androidx.mediarouter.app;

import a2.n;
import a2.u;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.appcompat.widget.f1;
import androidx.fragment.app.g0;
import androidx.fragment.app.y;
import x0.j0;

/* loaded from: classes.dex */
public class MediaRouteButton extends View {
    public static final SparseArray<Drawable.ConstantState> A = new SparseArray<>(2);
    public static final int[] B = {R.attr.state_checked};
    public static final int[] C = {R.attr.state_checkable};

    /* renamed from: b, reason: collision with root package name */
    public final a2.n f3548b;

    /* renamed from: m, reason: collision with root package name */
    public final a f3549m;

    /* renamed from: n, reason: collision with root package name */
    public a2.m f3550n;

    /* renamed from: o, reason: collision with root package name */
    public m f3551o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3552p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3553q;

    /* renamed from: r, reason: collision with root package name */
    public b f3554r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f3555s;

    /* renamed from: t, reason: collision with root package name */
    public int f3556t;

    /* renamed from: u, reason: collision with root package name */
    public int f3557u;

    /* renamed from: v, reason: collision with root package name */
    public int f3558v;

    /* renamed from: w, reason: collision with root package name */
    public final ColorStateList f3559w;

    /* renamed from: x, reason: collision with root package name */
    public final int f3560x;

    /* renamed from: y, reason: collision with root package name */
    public final int f3561y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3562z;

    public final class a extends n.a {
        public a() {
        }

        @Override // a2.n.a
        public void onProviderAdded(a2.n nVar, n.f fVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onProviderChanged(a2.n nVar, n.f fVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onProviderRemoved(a2.n nVar, n.f fVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onRouteAdded(a2.n nVar, n.g gVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onRouteChanged(a2.n nVar, n.g gVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onRouteRemoved(a2.n nVar, n.g gVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onRouteSelected(a2.n nVar, n.g gVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onRouteUnselected(a2.n nVar, n.g gVar) {
            MediaRouteButton.this.b();
        }

        @Override // a2.n.a
        public void onRouterParamsChanged(a2.n nVar, u uVar) {
            boolean z10 = uVar != null ? uVar.getExtras().getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON") : false;
            MediaRouteButton mediaRouteButton = MediaRouteButton.this;
            if (mediaRouteButton.f3553q != z10) {
                mediaRouteButton.f3553q = z10;
                mediaRouteButton.refreshDrawableState();
            }
        }
    }

    public final class b extends AsyncTask<Void, Void, Drawable> {

        /* renamed from: a, reason: collision with root package name */
        public final int f3564a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f3565b;

        public b(int i10, Context context) {
            this.f3564a = i10;
            this.f3565b = context;
        }

        @Override // android.os.AsyncTask
        public Drawable doInBackground(Void... voidArr) {
            SparseArray<Drawable.ConstantState> sparseArray = MediaRouteButton.A;
            int i10 = this.f3564a;
            if (sparseArray.get(i10) == null) {
                return s.a.getDrawable(this.f3565b, i10);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onCancelled(Drawable drawable) {
            if (drawable != null) {
                MediaRouteButton.A.put(this.f3564a, drawable.getConstantState());
            }
            MediaRouteButton.this.f3554r = null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Drawable drawable) {
            int i10 = this.f3564a;
            MediaRouteButton mediaRouteButton = MediaRouteButton.this;
            if (drawable != null) {
                MediaRouteButton.A.put(i10, drawable.getConstantState());
                mediaRouteButton.f3554r = null;
            } else {
                Drawable.ConstantState constantState = MediaRouteButton.A.get(i10);
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                mediaRouteButton.f3554r = null;
            }
            mediaRouteButton.setRemoteIndicatorDrawableInternal(drawable);
        }
    }

    public MediaRouteButton(Context context) {
        this(context, null);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private y getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof androidx.fragment.app.p) {
            return ((androidx.fragment.app.p) activity).getSupportFragmentManager();
        }
        return null;
    }

    public final void a() {
        if (this.f3556t > 0) {
            b bVar = this.f3554r;
            if (bVar != null) {
                bVar.cancel(false);
            }
            b bVar2 = new b(this.f3556t, getContext());
            this.f3554r = bVar2;
            this.f3556t = 0;
            bVar2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public final void b() {
        n.g selectedRoute = this.f3548b.getSelectedRoute();
        int connectionState = selectedRoute.isDefaultOrBluetooth() ^ true ? selectedRoute.getConnectionState() : 0;
        if (this.f3558v != connectionState) {
            this.f3558v = connectionState;
            d();
            refreshDrawableState();
        }
        if (connectionState == 1) {
            a();
        }
    }

    public final boolean c(int i10) {
        y fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        if (this.f3548b.getSelectedRoute().isDefaultOrBluetooth()) {
            if (fragmentManager.findFragmentByTag("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            d dVarOnCreateChooserDialogFragment = this.f3551o.onCreateChooserDialogFragment();
            dVarOnCreateChooserDialogFragment.setRouteSelector(this.f3550n);
            if (i10 == 2) {
                if (dVarOnCreateChooserDialogFragment.f3622y0 != null) {
                    throw new IllegalStateException("This must be called before creating dialog");
                }
                dVarOnCreateChooserDialogFragment.f3621x0 = true;
            }
            g0 g0VarBeginTransaction = fragmentManager.beginTransaction();
            g0VarBeginTransaction.add(dVarOnCreateChooserDialogFragment, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
            g0VarBeginTransaction.commitAllowingStateLoss();
        } else {
            if (fragmentManager.findFragmentByTag("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
                return false;
            }
            l lVarOnCreateControllerDialogFragment = this.f3551o.onCreateControllerDialogFragment();
            lVarOnCreateControllerDialogFragment.setRouteSelector(this.f3550n);
            if (i10 == 2) {
                if (lVarOnCreateControllerDialogFragment.f3690y0 != null) {
                    throw new IllegalStateException("This must be called before creating dialog");
                }
                lVarOnCreateControllerDialogFragment.f3689x0 = true;
            }
            g0 g0VarBeginTransaction2 = fragmentManager.beginTransaction();
            g0VarBeginTransaction2.add(lVarOnCreateControllerDialogFragment, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
            g0VarBeginTransaction2.commitAllowingStateLoss();
        }
        return true;
    }

    public final void d() {
        int i10 = this.f3558v;
        String string = getContext().getString(i10 != 1 ? i10 != 2 ? androidx.mediarouter.R.string.mr_cast_button_disconnected : androidx.mediarouter.R.string.mr_cast_button_connected : androidx.mediarouter.R.string.mr_cast_button_connecting);
        setContentDescription(string);
        if (!this.f3562z || TextUtils.isEmpty(string)) {
            string = null;
        }
        f1.setTooltipText(this, string);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3555s != null) {
            this.f3555s.setState(getDrawableState());
            if (this.f3555s.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f3555s.getCurrent();
                int i10 = this.f3558v;
                if (i10 == 1 || this.f3557u != i10) {
                    if (!animationDrawable.isRunning()) {
                        animationDrawable.start();
                    }
                } else if (i10 == 2 && !animationDrawable.isRunning()) {
                    animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
                }
            }
            invalidate();
        }
        this.f3557u = this.f3558v;
    }

    public m getDialogFactory() {
        return this.f3551o;
    }

    public a2.m getRouteSelector() {
        return this.f3550n;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3555s;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.f3552p = true;
        if (!this.f3550n.isEmpty()) {
            this.f3548b.addCallback(this.f3550n, this.f3549m);
        }
        b();
    }

    @Override // android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (this.f3548b == null || this.f3553q) {
            return iArrOnCreateDrawableState;
        }
        int i11 = this.f3558v;
        if (i11 == 1) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, C);
        } else if (i11 == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, B);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f3552p = false;
            if (!this.f3550n.isEmpty()) {
                this.f3548b.removeCallback(this.f3549m);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3555s != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f3555s.getIntrinsicWidth();
            int intrinsicHeight = this.f3555s.getIntrinsicHeight();
            int i10 = (((width - paddingLeft) - intrinsicWidth) / 2) + paddingLeft;
            int i11 = (((height - paddingTop) - intrinsicHeight) / 2) + paddingTop;
            this.f3555s.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f3555s.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingRight;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        Drawable drawable = this.f3555s;
        int paddingBottom = 0;
        if (drawable != null) {
            paddingRight = getPaddingRight() + getPaddingLeft() + drawable.getIntrinsicWidth();
        } else {
            paddingRight = 0;
        }
        int iMax = Math.max(this.f3560x, paddingRight);
        Drawable drawable2 = this.f3555s;
        if (drawable2 != null) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + drawable2.getIntrinsicHeight();
        }
        int iMax2 = Math.max(this.f3561y, paddingBottom);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, iMax);
        } else if (mode != 1073741824) {
            size = iMax;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, iMax2);
        } else if (mode2 != 1073741824) {
            size2 = iMax2;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        a();
        return showDialog() || zPerformClick;
    }

    public void setCheatSheetEnabled(boolean z10) {
        if (z10 != this.f3562z) {
            this.f3562z = z10;
            d();
        }
    }

    public void setDialogFactory(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.f3551o = mVar;
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.f3556t = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        b bVar = this.f3554r;
        if (bVar != null) {
            bVar.cancel(false);
        }
        Drawable drawable2 = this.f3555s;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f3555s);
        }
        if (drawable != null) {
            ColorStateList colorStateList = this.f3559w;
            if (colorStateList != null) {
                drawable = p0.a.wrap(drawable.mutate());
                p0.a.setTintList(drawable, colorStateList);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
        }
        this.f3555s = drawable;
        refreshDrawableState();
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3550n.equals(mVar)) {
            return;
        }
        if (this.f3552p) {
            boolean zIsEmpty = this.f3550n.isEmpty();
            a aVar = this.f3549m;
            a2.n nVar = this.f3548b;
            if (!zIsEmpty) {
                nVar.removeCallback(aVar);
            }
            if (!mVar.isEmpty()) {
                nVar.addCallback(mVar, aVar);
            }
        }
        this.f3550n = mVar;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        Drawable drawable = this.f3555s;
        if (drawable != null) {
            drawable.setVisible(i10 == 0, false);
        }
    }

    public boolean showDialog() {
        if (!this.f3552p) {
            return false;
        }
        u routerParams = this.f3548b.getRouterParams();
        if (routerParams == null) {
            return c(1);
        }
        if (routerParams.isOutputSwitcherEnabled() && a2.n.isMediaTransferEnabled() && s.showDialog(getContext())) {
            return true;
        }
        return c(routerParams.getDialogType());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3555s;
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.mediarouter.R.attr.mediaRouteButtonStyle);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i10) {
        Drawable.ConstantState constantState;
        int i11 = r.f3784a;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, r.f(context));
        int iH = r.h(contextThemeWrapper, androidx.mediarouter.R.attr.mediaRouteTheme);
        super(iH != 0 ? new ContextThemeWrapper(contextThemeWrapper, iH) : contextThemeWrapper, attributeSet, i10);
        this.f3550n = a2.m.f182c;
        this.f3551o = m.getDefault();
        Context context2 = getContext();
        int[] iArr = androidx.mediarouter.R.styleable.MediaRouteButton;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        j0.saveAttributeDataForStyleable(this, context2, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        if (isInEditMode()) {
            this.f3548b = null;
            this.f3549m = null;
            this.f3555s = s.a.getDrawable(context2, typedArrayObtainStyledAttributes.getResourceId(androidx.mediarouter.R.styleable.MediaRouteButton_externalRouteEnabledDrawableStatic, 0));
            return;
        }
        a2.n nVar = a2.n.getInstance(context2);
        this.f3548b = nVar;
        this.f3549m = new a();
        n.g selectedRoute = nVar.getSelectedRoute();
        int connectionState = selectedRoute.isDefaultOrBluetooth() ^ true ? selectedRoute.getConnectionState() : 0;
        this.f3558v = connectionState;
        this.f3557u = connectionState;
        this.f3559w = typedArrayObtainStyledAttributes.getColorStateList(androidx.mediarouter.R.styleable.MediaRouteButton_mediaRouteButtonTint);
        this.f3560x = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.mediarouter.R.styleable.MediaRouteButton_android_minWidth, 0);
        this.f3561y = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.mediarouter.R.styleable.MediaRouteButton_android_minHeight, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.mediarouter.R.styleable.MediaRouteButton_externalRouteEnabledDrawableStatic, 0);
        this.f3556t = typedArrayObtainStyledAttributes.getResourceId(androidx.mediarouter.R.styleable.MediaRouteButton_externalRouteEnabledDrawable, 0);
        typedArrayObtainStyledAttributes.recycle();
        int i12 = this.f3556t;
        SparseArray<Drawable.ConstantState> sparseArray = A;
        if (i12 != 0 && (constantState = sparseArray.get(i12)) != null) {
            setRemoteIndicatorDrawable(constantState.newDrawable());
        }
        if (this.f3555s == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = sparseArray.get(resourceId);
                if (constantState2 != null) {
                    setRemoteIndicatorDrawableInternal(constantState2.newDrawable());
                } else {
                    b bVar = new b(resourceId, getContext());
                    this.f3554r = bVar;
                    bVar.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                a();
            }
        }
        d();
        setClickable(true);
    }

    @Deprecated
    public void setAlwaysVisible(boolean z10) {
    }
}
