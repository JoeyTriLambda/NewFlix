package z6;

import android.view.KeyEvent;
import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import flix.com.vision.App;
import flix.com.vision.activities.TraktTvConfigActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22613a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f22614b;

    public /* synthetic */ a(KeyEvent.Callback callback, int i10) {
        this.f22613a = i10;
        this.f22614b = callback;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int i10 = this.f22613a;
        KeyEvent.Callback callback = this.f22614b;
        switch (i10) {
            case 0:
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ((Chip) callback).f8967t;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
                    break;
                }
                break;
            default:
                TraktTvConfigActivity traktTvConfigActivity = (TraktTvConfigActivity) callback;
                int i11 = TraktTvConfigActivity.f11876a0;
                traktTvConfigActivity.getClass();
                o1.a.j(App.getInstance().f11574v, "check_me_in", z10);
                if (!z10) {
                    o1.a.j(App.getInstance().f11574v, "sync_watched_list_on", true);
                    traktTvConfigActivity.X.setChecked(true);
                    traktTvConfigActivity.Q.setEnabled(true);
                    traktTvConfigActivity.Q.setAlpha(1.0f);
                    traktTvConfigActivity.M.setAlpha(0.5f);
                    traktTvConfigActivity.O.setAlpha(0.5f);
                    traktTvConfigActivity.N.setAlpha(0.5f);
                    break;
                } else {
                    traktTvConfigActivity.Q.setAlpha(0.5f);
                    traktTvConfigActivity.X.setChecked(false);
                    o1.a.j(App.getInstance().f11574v, "sync_watched_list_on", false);
                    traktTvConfigActivity.T.setEnabled(true);
                    traktTvConfigActivity.V.setEnabled(true);
                    traktTvConfigActivity.U.setEnabled(true);
                    traktTvConfigActivity.M.setEnabled(true);
                    traktTvConfigActivity.M.setAlpha(1.0f);
                    traktTvConfigActivity.O.setEnabled(true);
                    traktTvConfigActivity.O.setAlpha(1.0f);
                    traktTvConfigActivity.N.setEnabled(true);
                    traktTvConfigActivity.N.setAlpha(1.0f);
                    break;
                }
        }
    }
}
