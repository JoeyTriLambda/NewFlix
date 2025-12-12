package w;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b0.k;
import java.util.ArrayList;
import w.b;

/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public final class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20792a;

    /* renamed from: b, reason: collision with root package name */
    public final b f20793b;

    /* compiled from: SupportActionModeWrapper.java */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f20794a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f20795b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f20796c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final k<Menu, Menu> f20797d = new k<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f20795b = context;
            this.f20794a = callback;
        }

        public ActionMode getActionModeWrapper(b bVar) {
            ArrayList<f> arrayList = this.f20796c;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = arrayList.get(i10);
                if (fVar != null && fVar.f20793b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f20795b, bVar);
            arrayList.add(fVar2);
            return fVar2;
        }

        @Override // w.b.a
        public boolean onActionItemClicked(b bVar, MenuItem menuItem) {
            return this.f20794a.onActionItemClicked(getActionModeWrapper(bVar), new x.c(this.f20795b, (q0.b) menuItem));
        }

        @Override // w.b.a
        public boolean onCreateActionMode(b bVar, Menu menu) {
            ActionMode actionModeWrapper = getActionModeWrapper(bVar);
            k<Menu, Menu> kVar = this.f20797d;
            Menu eVar = kVar.get(menu);
            if (eVar == null) {
                eVar = new x.e(this.f20795b, (q0.a) menu);
                kVar.put(menu, eVar);
            }
            return this.f20794a.onCreateActionMode(actionModeWrapper, eVar);
        }

        @Override // w.b.a
        public void onDestroyActionMode(b bVar) {
            this.f20794a.onDestroyActionMode(getActionModeWrapper(bVar));
        }

        @Override // w.b.a
        public boolean onPrepareActionMode(b bVar, Menu menu) {
            ActionMode actionModeWrapper = getActionModeWrapper(bVar);
            k<Menu, Menu> kVar = this.f20797d;
            Menu eVar = kVar.get(menu);
            if (eVar == null) {
                eVar = new x.e(this.f20795b, (q0.a) menu);
                kVar.put(menu, eVar);
            }
            return this.f20794a.onPrepareActionMode(actionModeWrapper, eVar);
        }
    }

    public f(Context context, b bVar) {
        this.f20792a = context;
        this.f20793b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f20793b.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f20793b.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new x.e(this.f20792a, (q0.a) this.f20793b.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f20793b.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f20793b.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f20793b.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f20793b.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f20793b.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f20793b.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f20793b.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f20793b.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f20793b.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f20793b.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f20793b.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f20793b.setTitleOptionalHint(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f20793b.setSubtitle(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f20793b.setTitle(i10);
    }
}
