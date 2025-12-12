package w;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import w.b;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public final class e extends b implements e.a {

    /* renamed from: n, reason: collision with root package name */
    public final Context f20786n;

    /* renamed from: o, reason: collision with root package name */
    public final ActionBarContextView f20787o;

    /* renamed from: p, reason: collision with root package name */
    public final b.a f20788p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference<View> f20789q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20790r;

    /* renamed from: s, reason: collision with root package name */
    public final androidx.appcompat.view.menu.e f20791s;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f20786n = context;
        this.f20787o = actionBarContextView;
        this.f20788p = aVar;
        androidx.appcompat.view.menu.e defaultShowAsAction = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f20791s = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
    }

    @Override // w.b
    public void finish() {
        if (this.f20790r) {
            return;
        }
        this.f20790r = true;
        this.f20788p.onDestroyActionMode(this);
    }

    @Override // w.b
    public View getCustomView() {
        WeakReference<View> weakReference = this.f20789q;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // w.b
    public Menu getMenu() {
        return this.f20791s;
    }

    @Override // w.b
    public MenuInflater getMenuInflater() {
        return new g(this.f20787o.getContext());
    }

    @Override // w.b
    public CharSequence getSubtitle() {
        return this.f20787o.getSubtitle();
    }

    @Override // w.b
    public CharSequence getTitle() {
        return this.f20787o.getTitle();
    }

    @Override // w.b
    public void invalidate() {
        this.f20788p.onPrepareActionMode(this, this.f20791s);
    }

    @Override // w.b
    public boolean isTitleOptional() {
        return this.f20787o.isTitleOptional();
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f20788p.onActionItemClicked(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
        invalidate();
        this.f20787o.showOverflowMenu();
    }

    @Override // w.b
    public void setCustomView(View view) {
        this.f20787o.setCustomView(view);
        this.f20789q = view != null ? new WeakReference<>(view) : null;
    }

    @Override // w.b
    public void setSubtitle(CharSequence charSequence) {
        this.f20787o.setSubtitle(charSequence);
    }

    @Override // w.b
    public void setTitle(CharSequence charSequence) {
        this.f20787o.setTitle(charSequence);
    }

    @Override // w.b
    public void setTitleOptionalHint(boolean z10) {
        super.setTitleOptionalHint(z10);
        this.f20787o.setTitleOptional(z10);
    }

    @Override // w.b
    public void setSubtitle(int i10) {
        setSubtitle(this.f20786n.getString(i10));
    }

    @Override // w.b
    public void setTitle(int i10) {
        setTitle(this.f20786n.getString(i10));
    }
}
