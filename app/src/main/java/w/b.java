package w;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: b, reason: collision with root package name */
    public Object f20778b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20779m;

    /* compiled from: ActionMode.java */
    public interface a {
        boolean onActionItemClicked(b bVar, MenuItem menuItem);

        boolean onCreateActionMode(b bVar, Menu menu);

        void onDestroyActionMode(b bVar);

        boolean onPrepareActionMode(b bVar, Menu menu);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public Object getTag() {
        return this.f20778b;
    }

    public abstract CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.f20779m;
    }

    public abstract void invalidate();

    public abstract boolean isTitleOptional();

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i10);

    public abstract void setSubtitle(CharSequence charSequence);

    public void setTag(Object obj) {
        this.f20778b = obj;
    }

    public abstract void setTitle(int i10);

    public abstract void setTitle(CharSequence charSequence);

    public void setTitleOptionalHint(boolean z10) {
        this.f20779m = z10;
    }
}
