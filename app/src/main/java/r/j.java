package r;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j1;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import l0.z;
import r.c;
import w.b;

/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public class j extends androidx.fragment.app.p implements k, z.a, c.b {
    public m I;
    public j1 J;

    public j() {
        getSavedStateRegistry().registerSavedStateProvider("androidx:appcompat", new h(this));
        addOnContextAvailableListener(new i(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        getDelegate().addContentView(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().attachBaseContext2(context));
    }

    public final void c() {
        f0.set(getWindow().getDecorView(), this);
        g0.set(getWindow().getDecorView(), this);
        androidx.savedstate.b.set(getWindow().getDecorView(), this);
        androidx.activity.o.set(getWindow().getDecorView(), this);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // l0.j, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        return (T) getDelegate().findViewById(i10);
    }

    public m getDelegate() {
        if (this.I == null) {
            this.I = m.create(this, this);
        }
        return this.I;
    }

    @Override // r.c.b
    public c.a getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.J == null && j1.shouldBeUsed()) {
            this.J = new j1(this, super.getResources());
        }
        j1 j1Var = this.J;
        return j1Var == null ? super.getResources() : j1Var;
    }

    public a getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // l0.z.a
    public Intent getSupportParentActivityIntent() {
        return l0.m.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
        if (this.J != null) {
            this.J.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(l0.z zVar) {
        zVar.addParentStack(this);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        Window window;
        if ((Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().onPostCreate(bundle);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        l0.z zVarCreate = l0.z.create(this);
        onCreateSupportNavigateUpTaskStack(zVarCreate);
        onPrepareSupportNavigateUpTaskStack(zVarCreate);
        zVarCreate.startActivities();
        try {
            l0.a.finishAffinity(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        getDelegate().setTitle(charSequence);
    }

    @Override // r.k
    public w.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        c();
        getDelegate().setContentView(i10);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        getDelegate().setTheme(i10);
    }

    public void supportNavigateUpTo(Intent intent) {
        l0.m.navigateUpTo(this, intent);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return l0.m.shouldUpRecreateTask(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        c();
        getDelegate().setContentView(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        getDelegate().setContentView(view, layoutParams);
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public void onLocalesChanged(t0.h hVar) {
    }

    public void onNightModeChanged(int i10) {
    }

    public void onPrepareSupportNavigateUpTaskStack(l0.z zVar) {
    }

    @Override // r.k
    public void onSupportActionModeFinished(w.b bVar) {
    }

    @Override // r.k
    public void onSupportActionModeStarted(w.b bVar) {
    }
}
