package androidx.mediarouter.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class MediaRouteActionProvider extends x0.b {

    /* renamed from: c, reason: collision with root package name */
    public a2.m f3545c;

    /* renamed from: d, reason: collision with root package name */
    public final m f3546d;

    /* renamed from: e, reason: collision with root package name */
    public MediaRouteButton f3547e;

    public MediaRouteActionProvider(Context context) {
        super(context);
        this.f3545c = a2.m.f182c;
        this.f3546d = m.getDefault();
        a2.n.getInstance(context);
    }

    @Override // x0.b
    public View onCreateActionView() {
        if (this.f3547e != null) {
            Log.e("MRActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
        }
        MediaRouteButton mediaRouteButtonOnCreateMediaRouteButton = onCreateMediaRouteButton();
        this.f3547e = mediaRouteButtonOnCreateMediaRouteButton;
        mediaRouteButtonOnCreateMediaRouteButton.setCheatSheetEnabled(true);
        this.f3547e.setRouteSelector(this.f3545c);
        this.f3547e.setDialogFactory(this.f3546d);
        this.f3547e.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return this.f3547e;
    }

    public MediaRouteButton onCreateMediaRouteButton() {
        return new MediaRouteButton(getContext());
    }

    @Override // x0.b
    public boolean onPerformDefaultAction() {
        MediaRouteButton mediaRouteButton = this.f3547e;
        if (mediaRouteButton != null) {
            return mediaRouteButton.showDialog();
        }
        return false;
    }

    public void setRouteSelector(a2.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f3545c.equals(mVar)) {
            return;
        }
        this.f3545c = mVar;
        MediaRouteButton mediaRouteButton = this.f3547e;
        if (mediaRouteButton != null) {
            mediaRouteButton.setRouteSelector(mVar);
        }
    }
}
