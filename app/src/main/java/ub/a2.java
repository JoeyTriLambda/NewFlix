package ub;

import android.widget.CompoundButton;
import flix.com.vision.App;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.TraktTvConfigActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20151a;

    public /* synthetic */ a2(int i10) {
        this.f20151a = i10;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        switch (this.f20151a) {
            case 0:
                int i10 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_hide_episodes", z10);
                break;
            case 1:
                int i11 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_adult_show_big_pictures", z10);
                break;
            case 2:
                int i12 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_logo_as_loading_players", z10);
                break;
            case 3:
                int i13 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_play_intro_sound", z10);
                break;
            case 4:
                int i14 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_show_adult_zone_hide_related", z10);
                break;
            case 5:
                int i15 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_adult_zone_animate", z10);
                break;
            case 6:
                int i16 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_adult_zone_always_play_best", z10);
                break;
            case 7:
                int i17 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_show_time", z10);
                break;
            case 8:
                int i18 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_hide_unreleased", z10);
                break;
            case 9:
                int i19 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_show_hindi_dubbed_direct", z10);
                break;
            case 10:
                int i20 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_classic_search", z10);
                break;
            case 11:
                int i21 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_show_debrid_links_only", z10);
                break;
            case 12:
                int i22 = SettingsActivity.f11809o2;
                o1.a.j(App.getInstance().f11574v, "pref_auto_play_next_ep", z10);
                break;
            case 13:
                int i23 = TraktTvConfigActivity.f11876a0;
                o1.a.j(App.getInstance().f11574v, "twitter_on", z10);
                break;
            case 14:
                int i24 = TraktTvConfigActivity.f11876a0;
                o1.a.j(App.getInstance().f11574v, "facebook_on", z10);
                break;
            case 15:
                int i25 = TraktTvConfigActivity.f11876a0;
                o1.a.j(App.getInstance().f11574v, "tumblr_on", z10);
                break;
            case 16:
                int i26 = TraktTvConfigActivity.f11876a0;
                o1.a.j(App.getInstance().f11574v, "add_favorites_on", z10);
                break;
            case 17:
                int i27 = TraktTvConfigActivity.f11876a0;
                o1.a.j(App.getInstance().f11574v, "add_favorites_on_shows", z10);
                break;
            default:
                int i28 = TraktTvConfigActivity.f11876a0;
                o1.a.j(App.getInstance().f11574v, "sync_watched_list_on", z10);
                break;
        }
    }
}
