package ub;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;

/* compiled from: MainActivity.java */
/* loaded from: classes2.dex */
public final class c1 extends r.c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20162i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(MainActivity mainActivity, Activity activity, DrawerLayout drawerLayout, Toolbar toolbar) {
        super(activity, drawerLayout, toolbar, R.string.dr_closed, R.string.dr_opened);
        this.f20162i = mainActivity;
    }

    @Override // r.c, androidx.drawerlayout.widget.DrawerLayout.e
    public void onDrawerClosed(View view) {
        super.onDrawerClosed(view);
        try {
            this.f20162i.f11701d0.requestFocus();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // r.c, androidx.drawerlayout.widget.DrawerLayout.e
    public void onDrawerOpened(View view) {
        super.onDrawerOpened(view);
        try {
            this.f20162i.X.requestFocus();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
