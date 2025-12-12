package flix.com.vision.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.TraktTvConfigActivity;
import org.apache.commons.lang3.StringUtils;
import r.j;
import ub.a2;

/* loaded from: classes2.dex */
public class TraktTvConfigActivity extends j {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f11876a0 = 0;
    public LinearLayout K;
    public LinearLayout L;
    public LinearLayout M;
    public LinearLayout N;
    public LinearLayout O;
    public LinearLayout P;
    public LinearLayout Q;
    public CheckBox R;
    public CheckBox S;
    public CheckBox T;
    public CheckBox U;
    public CheckBox V;
    public CheckBox W;
    public CheckBox X;
    public TextView Y;
    public RelativeLayout Z;

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_trakt_tv_settings);
        this.Y = (TextView) findViewById(R.id.label_signout_button);
        this.Q = (LinearLayout) findViewById(R.id.setting_add_watched_list);
        this.L = (LinearLayout) findViewById(R.id.setting_check_me_in);
        this.M = (LinearLayout) findViewById(R.id.setting_facebook);
        this.N = (LinearLayout) findViewById(R.id.setting_twitter);
        this.O = (LinearLayout) findViewById(R.id.setting_tumblr);
        this.P = (LinearLayout) findViewById(R.id.setting_add_favorite);
        this.K = (LinearLayout) findViewById(R.id.setting_add_favorite_shows);
        this.R = (CheckBox) findViewById(R.id.switch_add_favorite_shows);
        this.S = (CheckBox) findViewById(R.id.switch_check_me_in);
        this.T = (CheckBox) findViewById(R.id.switch_facebook);
        this.U = (CheckBox) findViewById(R.id.switch_twitter);
        this.V = (CheckBox) findViewById(R.id.switch_tumblr);
        this.W = (CheckBox) findViewById(R.id.switch_add_favorite);
        this.X = (CheckBox) findViewById(R.id.switch_add_watched_list);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.sign_out);
        this.Z = relativeLayout;
        final int i10 = 0;
        relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i11) {
                    case 0:
                        int i12 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i13 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i14 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i15 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.R.setChecked(App.getInstance().f11574v.getBoolean("add_favorites_on_shows", true));
        this.S.setChecked(App.getInstance().f11574v.getBoolean("check_me_in", true));
        this.U.setChecked(App.getInstance().f11574v.getBoolean("twitter_on", true));
        this.V.setChecked(App.getInstance().f11574v.getBoolean("tumblr_on", true));
        this.T.setChecked(App.getInstance().f11574v.getBoolean("facebook_on", true));
        this.X.setChecked(App.getInstance().f11574v.getBoolean("sync_watched_list_on", true));
        this.W.setChecked(App.getInstance().f11574v.getBoolean("add_favorites_on", true));
        if (App.getInstance().f11574v.getBoolean("check_me_in", true)) {
            this.Q.setAlpha(0.5f);
            o1.a.j(App.getInstance().f11574v, "sync_watched_list_on", true);
        } else {
            this.Q.setAlpha(1.0f);
            this.M.setAlpha(0.5f);
            this.O.setAlpha(0.5f);
            this.N.setAlpha(0.5f);
        }
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i12 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i13 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i14 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i15 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i12 = 2;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i122 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i13 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i14 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i15 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i13 = 3;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i122 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i132 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i14 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i15 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i14 = 4;
        this.Z.setOnFocusChangeListener(new v7.b(this, i14));
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i14;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i122 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i132 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i142 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i15 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i15 = 5;
        this.P.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i15;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i122 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i132 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i142 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i152 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i16 = 6;
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i16;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i122 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i132 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i142 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i152 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        final int i17 = 7;
        this.Q.setOnClickListener(new View.OnClickListener(this) { // from class: ub.t2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktTvConfigActivity f20282m;

            {
                this.f20282m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i17;
                TraktTvConfigActivity traktTvConfigActivity = this.f20282m;
                switch (i112) {
                    case 0:
                        int i122 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        androidx.appcompat.app.d dVarCreate = new d.a(traktTvConfigActivity).create();
                        dVarCreate.setTitle(traktTvConfigActivity.getString(R.string.trakt_tv_label));
                        dVarCreate.setIcon(R.drawable.trakt_logo_3);
                        dVarCreate.setMessage(traktTvConfigActivity.getString(R.string.currently_signed_as_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("trakt_user_name", "") + traktTvConfigActivity.getString(R.string.do_you_want_sign_out_mess));
                        dVarCreate.setButton(-1, traktTvConfigActivity.getString(R.string.yes_sign_out_label), new u2(traktTvConfigActivity, 0));
                        dVarCreate.setButton(-2, traktTvConfigActivity.getString(R.string.cancel_label), new t0(6));
                        try {
                            dVarCreate.show();
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    case 1:
                        traktTvConfigActivity.S.performClick();
                        break;
                    case 2:
                        int i132 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.T.performClick();
                            break;
                        }
                        break;
                    case 3:
                        int i142 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.U.performClick();
                            break;
                        }
                        break;
                    case 4:
                        int i152 = TraktTvConfigActivity.f11876a0;
                        traktTvConfigActivity.getClass();
                        if (!App.getInstance().f11574v.getBoolean("check_me_in", true)) {
                            traktTvConfigActivity.V.performClick();
                            break;
                        }
                        break;
                    case 5:
                        traktTvConfigActivity.W.performClick();
                        break;
                    case 6:
                        traktTvConfigActivity.R.performClick();
                        break;
                    default:
                        traktTvConfigActivity.X.performClick();
                        break;
                }
            }
        });
        this.S.setOnCheckedChangeListener(new z6.a(this, i11));
        this.U.setOnCheckedChangeListener(new a2(13));
        this.T.setOnCheckedChangeListener(new a2(14));
        this.V.setOnCheckedChangeListener(new a2(15));
        this.W.setOnCheckedChangeListener(new a2(16));
        this.R.setOnCheckedChangeListener(new a2(17));
        this.X.setOnCheckedChangeListener(new a2(18));
    }
}
