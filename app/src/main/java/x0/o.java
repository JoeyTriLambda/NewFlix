package x0;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* compiled from: MenuProvider.java */
/* loaded from: classes.dex */
public interface o {
    void onCreateMenu(Menu menu, MenuInflater menuInflater);

    void onMenuClosed(Menu menu);

    boolean onMenuItemSelected(MenuItem menuItem);

    void onPrepareMenu(Menu menu);
}
