package kc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.adult.AdultPINSetupActivity;
import flix.com.vision.activities.adult.AdultZonePINEntryActivity;
import flix.com.vision.tv.Constant;
import java.util.Objects;
import ub.z0;

/* compiled from: FVDialog.java */
/* loaded from: classes2.dex */
public final class d extends DialogFragment implements View.OnFocusChangeListener, View.OnKeyListener {

    /* renamed from: c0, reason: collision with root package name */
    public static Typeface f15050c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    public static c4.a f15051d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    public static boolean f15052e0 = false;
    public LinearLayout A;
    public LinearLayout B;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public RelativeLayout O;
    public RelativeLayout P;
    public RelativeLayout Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f15053a0;

    /* renamed from: b, reason: collision with root package name */
    public View.OnClickListener f15054b;

    /* renamed from: m, reason: collision with root package name */
    public View.OnClickListener f15056m;

    /* renamed from: n, reason: collision with root package name */
    public View.OnClickListener f15057n;

    /* renamed from: o, reason: collision with root package name */
    public View.OnClickListener f15058o;

    /* renamed from: p, reason: collision with root package name */
    public View.OnClickListener f15059p;

    /* renamed from: q, reason: collision with root package name */
    public View.OnClickListener f15060q;

    /* renamed from: r, reason: collision with root package name */
    public View.OnClickListener f15061r;

    /* renamed from: s, reason: collision with root package name */
    public View.OnClickListener f15062s;

    /* renamed from: t, reason: collision with root package name */
    public View.OnClickListener f15063t;

    /* renamed from: u, reason: collision with root package name */
    public View.OnClickListener f15064u;

    /* renamed from: v, reason: collision with root package name */
    public Handler f15065v;

    /* renamed from: w, reason: collision with root package name */
    public b f15066w;

    /* renamed from: y, reason: collision with root package name */
    public SpinKitView f15068y;

    /* renamed from: z, reason: collision with root package name */
    public LinearLayout f15069z;

    /* renamed from: x, reason: collision with root package name */
    public boolean f15067x = false;
    public float C = -1.0f;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f15055b0 = false;

    public static void a(TextView textView, int i10) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(textView.getContext(), i10), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public static d newInstance(Activity activity, boolean z10) {
        d dVar = new d();
        AssetManager assets = activity.getAssets();
        String str = Constant.f12450b;
        f15050c0 = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        f15051d0 = new c4.a();
        f15052e0 = z10;
        return dVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        try {
            onDismiss(dialogInterface);
            this.f15065v.removeCallbacks(this.f15066w);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        RelativeLayout relativeLayout;
        final int i10 = 0;
        View viewInflate = layoutInflater.inflate(this.f15067x ? R.layout.fvision_dialog_menu : App.K ? R.layout.fvision_dialog : R.layout.fvision_dialog_phones, viewGroup, false);
        this.N = (TextView) viewInflate.findViewById(R.id.button_user_torrents);
        this.B = (LinearLayout) viewInflate.findViewById(R.id.horizontal_buttons);
        this.M = (TextView) viewInflate.findViewById(R.id.button_restart);
        this.L = (TextView) viewInflate.findViewById(R.id.button_discord);
        this.K = (TextView) viewInflate.findViewById(R.id.button_k_drama);
        this.J = (TextView) viewInflate.findViewById(R.id.button_twitter);
        this.I = (TextView) viewInflate.findViewById(R.id.button_check_update);
        this.F = (TextView) viewInflate.findViewById(R.id.button_trakt_tv);
        this.G = (TextView) viewInflate.findViewById(R.id.button_donation);
        this.H = (TextView) viewInflate.findViewById(R.id.button_watched);
        this.E = (TextView) viewInflate.findViewById(R.id.button_import_playlist);
        this.D = (TextView) viewInflate.findViewById(R.id.button_my_playlists);
        this.f15068y = (SpinKitView) viewInflate.findViewById(R.id.spin_kit);
        this.f15069z = (LinearLayout) viewInflate.findViewById(R.id.dialog_main_content);
        this.A = (LinearLayout) viewInflate.findViewById(R.id.menu_buttons);
        this.O = (RelativeLayout) viewInflate.findViewById(R.id.dialog_button_rel1);
        this.P = (RelativeLayout) viewInflate.findViewById(R.id.dialog_button_rel2);
        this.Q = (RelativeLayout) viewInflate.findViewById(R.id.dialog_button_rel3);
        this.R = (TextView) viewInflate.findViewById(R.id.dialog_title);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.dialog_message);
        this.S = textView5;
        textView5.setMovementMethod(new ScrollingMovementMethod());
        this.T = (TextView) viewInflate.findViewById(R.id.button1_text_view);
        this.U = (TextView) viewInflate.findViewById(R.id.button2_text_view);
        this.V = (TextView) viewInflate.findViewById(R.id.button3_text_view);
        RelativeLayout relativeLayout2 = this.Q;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new z0(this, 10));
        }
        this.P.setOnClickListener(new z0(this, 11));
        this.O.setOnClickListener(new z0(this, 12));
        if (this.f15054b == null) {
            this.O.setVisibility(8);
        }
        if (this.f15056m == null) {
            this.P.setVisibility(8);
        }
        if (this.f15057n == null && (relativeLayout = this.Q) != null) {
            relativeLayout.setVisibility(8);
        }
        this.S.setText(this.X);
        this.R.setText(this.W);
        String str = this.Y;
        if (str != null && (textView4 = this.T) != null) {
            textView4.setText(str.toUpperCase());
        }
        String str2 = this.Z;
        if (str2 != null && (textView3 = this.U) != null) {
            textView3.setText(str2.toUpperCase());
        }
        String str3 = this.f15053a0;
        if (str3 != null && (textView2 = this.V) != null) {
            textView2.setText(str3.toUpperCase());
        }
        this.O.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: kc.c

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ d f15049m;

            {
                this.f15049m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i11 = i10;
                d dVar = this.f15049m;
                switch (i11) {
                    case 0:
                        if (!z10) {
                            dVar.T.setTextColor(dVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            dVar.T.setTextColor(dVar.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            dVar.U.setTextColor(dVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            dVar.U.setTextColor(dVar.getResources().getColor(R.color.black));
                            break;
                        }
                    default:
                        if (!z10) {
                            dVar.V.setTextColor(dVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            dVar.V.setTextColor(dVar.getResources().getColor(R.color.black));
                            break;
                        }
                }
            }
        });
        final int i11 = 1;
        this.P.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: kc.c

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ d f15049m;

            {
                this.f15049m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i112 = i11;
                d dVar = this.f15049m;
                switch (i112) {
                    case 0:
                        if (!z10) {
                            dVar.T.setTextColor(dVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            dVar.T.setTextColor(dVar.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            dVar.U.setTextColor(dVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            dVar.U.setTextColor(dVar.getResources().getColor(R.color.black));
                            break;
                        }
                    default:
                        if (!z10) {
                            dVar.V.setTextColor(dVar.getResources().getColor(R.color.white));
                            break;
                        } else {
                            dVar.V.setTextColor(dVar.getResources().getColor(R.color.black));
                            break;
                        }
                }
            }
        });
        RelativeLayout relativeLayout3 = this.Q;
        final int i12 = 2;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: kc.c

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ d f15049m;

                {
                    this.f15049m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i112 = i12;
                    d dVar = this.f15049m;
                    switch (i112) {
                        case 0:
                            if (!z10) {
                                dVar.T.setTextColor(dVar.getResources().getColor(R.color.white));
                                break;
                            } else {
                                dVar.T.setTextColor(dVar.getResources().getColor(R.color.black));
                                break;
                            }
                        case 1:
                            if (!z10) {
                                dVar.U.setTextColor(dVar.getResources().getColor(R.color.white));
                                break;
                            } else {
                                dVar.U.setTextColor(dVar.getResources().getColor(R.color.black));
                                break;
                            }
                        default:
                            if (!z10) {
                                dVar.V.setTextColor(dVar.getResources().getColor(R.color.white));
                                break;
                            } else {
                                dVar.V.setTextColor(dVar.getResources().getColor(R.color.black));
                                break;
                            }
                    }
                }
            });
        }
        if (this.f15055b0) {
            this.f15069z.setVisibility(8);
            this.f15068y.setVisibility(0);
        }
        if (this.f15067x) {
            this.J.setOnFocusChangeListener(this);
            this.I.setOnFocusChangeListener(this);
            this.L.setOnFocusChangeListener(this);
            this.N.setOnFocusChangeListener(this);
            this.M.setOnFocusChangeListener(this);
            this.E.setOnFocusChangeListener(this);
            this.D.setOnFocusChangeListener(this);
            this.K.setOnFocusChangeListener(this);
            this.F.setOnFocusChangeListener(this);
            this.G.setOnFocusChangeListener(this);
            this.H.setOnFocusChangeListener(this);
            this.J.setOnKeyListener(this);
            this.I.setOnKeyListener(this);
            this.L.setOnKeyListener(this);
            this.N.setOnKeyListener(this);
            this.M.setOnKeyListener(this);
            this.E.setOnKeyListener(this);
            this.D.setOnKeyListener(this);
            this.K.setOnKeyListener(this);
            this.F.setOnKeyListener(this);
            this.G.setOnKeyListener(this);
            this.H.setOnKeyListener(this);
        }
        float f10 = this.C;
        if (f10 > 0.0f && (textView = this.S) != null) {
            textView.setTextSize(2, f10);
        }
        Window window = getDialog().getWindow();
        Objects.requireNonNull(window);
        window.requestFeature(1);
        setCancelable(f15052e0);
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (!(view instanceof TextView) || view.isActivated()) {
            return;
        }
        if (z10) {
            TextView textView = (TextView) view;
            textView.setTextColor(getResources().getColor(R.color.black));
            a(textView, R.color.black);
        } else {
            TextView textView2 = (TextView) view;
            a(textView2, R.color.white);
            textView2.setTextColor(getResources().getColor(R.color.color_grey));
        }
    }

    @Override // android.view.View.OnKeyListener
    @SuppressLint({"NonConstantResourceId"})
    public boolean onKey(View view, int i10, KeyEvent keyEvent) throws PackageManager.NameNotFoundException {
        boolean z10;
        final int i11 = 1;
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (i10 == 4) {
            dismiss();
            return true;
        }
        if (getActivity() == null) {
            return true;
        }
        final int i12 = 0;
        if (i10 == 23) {
            dismiss();
            switch (view.getId()) {
                case R.id.button_adult_zone /* 2131427604 */:
                    if (!App.getInstance().f11574v.getBoolean("pref_adult_zone_pin_set", false)) {
                        startActivity(new Intent(getActivity(), (Class<?>) AdultPINSetupActivity.class));
                        break;
                    } else {
                        startActivity(new Intent(getActivity(), (Class<?>) AdultZonePINEntryActivity.class));
                        break;
                    }
                case R.id.button_check_update /* 2131427608 */:
                    View.OnClickListener onClickListener = this.f15058o;
                    if (onClickListener != null) {
                        this.I.setOnClickListener(onClickListener);
                        this.I.performClick();
                        break;
                    }
                    break;
                case R.id.button_discord /* 2131427611 */:
                    FragmentManager fragmentManager = getFragmentManager();
                    final d dVarNewInstance = newInstance(getActivity(), true);
                    dVarNewInstance.setTitle("Discord");
                    dVarNewInstance.setMessage("Join the Flix Vision community at https://discord.gg/tKjc4PTvxu");
                    dVarNewInstance.setButton1("OK", new z0(dVarNewInstance, 13));
                    try {
                        getActivity().getPackageManager().getPackageInfo("com.discord", 0);
                        i12 = 1;
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (i12 != 0) {
                        dVarNewInstance.setButton2("OPEN APP", new View.OnClickListener(this) { // from class: kc.a

                            /* renamed from: m, reason: collision with root package name */
                            public final /* synthetic */ d f15044m;

                            {
                                this.f15044m = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                int i13 = i11;
                                d dVar = dVarNewInstance;
                                d dVar2 = this.f15044m;
                                switch (i13) {
                                    case 0:
                                        dVar2.getClass();
                                        dVar.dismiss();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse("https://twitter.com/FlixVisionApp"));
                                            dVar2.startActivity(intent);
                                            break;
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                    default:
                                        dVar2.getClass();
                                        dVar.dismiss();
                                        try {
                                            Intent intent2 = new Intent("android.intent.action.VIEW");
                                            intent2.setData(Uri.parse("https://discord.gg/tKjc4PTvxu"));
                                            dVar2.startActivity(intent2);
                                            break;
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                            return;
                                        }
                                }
                            }
                        });
                    }
                    try {
                        dVarNewInstance.show(fragmentManager, "");
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                    String str = Constant.f12450b;
                    editorEdit.putBoolean("discord_check", true).apply();
                    break;
                case R.id.button_donation /* 2131427612 */:
                    View.OnClickListener onClickListener2 = this.f15062s;
                    if (onClickListener2 != null) {
                        this.G.setOnClickListener(onClickListener2);
                        this.G.performClick();
                        break;
                    }
                    break;
                case R.id.button_import_playlist /* 2131427618 */:
                    View.OnClickListener onClickListener3 = this.f15064u;
                    if (onClickListener3 != null) {
                        this.E.setOnClickListener(onClickListener3);
                        this.E.performClick();
                        break;
                    }
                    break;
                case R.id.button_k_drama /* 2131427619 */:
                    View.OnClickListener onClickListener4 = this.f15060q;
                    if (onClickListener4 != null) {
                        this.K.setOnClickListener(onClickListener4);
                        this.K.performClick();
                        break;
                    }
                    break;
                case R.id.button_my_playlists /* 2131427624 */:
                    View.OnClickListener onClickListener5 = this.f15063t;
                    if (onClickListener5 != null) {
                        this.D.setOnClickListener(onClickListener5);
                        this.D.performClick();
                        break;
                    }
                    break;
                case R.id.button_restart /* 2131427628 */:
                    try {
                        getActivity().finish();
                        App.getInstance().restartApp();
                        break;
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        break;
                    }
                case R.id.button_trakt_tv /* 2131427635 */:
                    View.OnClickListener onClickListener6 = this.f15061r;
                    if (onClickListener6 != null) {
                        this.F.setOnClickListener(onClickListener6);
                        this.F.performClick();
                        break;
                    }
                    break;
                case R.id.button_twitter /* 2131427637 */:
                    FragmentManager fragmentManager2 = getFragmentManager();
                    final d dVarNewInstance2 = newInstance(getActivity(), true);
                    dVarNewInstance2.setTitle("Twitter");
                    dVarNewInstance2.setMessage("Find us on twitter at @FlixVisionApp");
                    dVarNewInstance2.setButton1("OK", new z0(dVarNewInstance2, 9));
                    try {
                        getActivity().getPackageManager().getPackageInfo("com.twitter.android", 0);
                        z10 = true;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        z10 = false;
                    }
                    if (z10) {
                        dVarNewInstance2.setButton2("OPEN APP", new View.OnClickListener(this) { // from class: kc.a

                            /* renamed from: m, reason: collision with root package name */
                            public final /* synthetic */ d f15044m;

                            {
                                this.f15044m = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                int i13 = i12;
                                d dVar = dVarNewInstance2;
                                d dVar2 = this.f15044m;
                                switch (i13) {
                                    case 0:
                                        dVar2.getClass();
                                        dVar.dismiss();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse("https://twitter.com/FlixVisionApp"));
                                            dVar2.startActivity(intent);
                                            break;
                                        } catch (Exception e102) {
                                            e102.printStackTrace();
                                        }
                                    default:
                                        dVar2.getClass();
                                        dVar.dismiss();
                                        try {
                                            Intent intent2 = new Intent("android.intent.action.VIEW");
                                            intent2.setData(Uri.parse("https://discord.gg/tKjc4PTvxu"));
                                            dVar2.startActivity(intent2);
                                            break;
                                        } catch (Exception e112) {
                                            e112.printStackTrace();
                                            return;
                                        }
                                }
                            }
                        });
                    }
                    try {
                        dVarNewInstance2.show(fragmentManager2, "");
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    SharedPreferences.Editor editorEdit2 = App.getInstance().f11574v.edit();
                    String str2 = Constant.f12450b;
                    editorEdit2.putBoolean("twitter_check", true).apply();
                    break;
                case R.id.button_user_torrents /* 2131427638 */:
                    try {
                        startActivity(new Intent(getActivity(), (Class<?>) UserTorrentsActivity.class));
                        break;
                    } catch (Exception e13) {
                        e13.printStackTrace();
                        break;
                    }
                case R.id.button_watched /* 2131427639 */:
                    View.OnClickListener onClickListener7 = this.f15059p;
                    if (onClickListener7 != null) {
                        this.H.setOnClickListener(onClickListener7);
                        this.H.performClick();
                        break;
                    }
                    break;
            }
            return true;
        }
        return false;
        return true;
        return true;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [kc.b] */
    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final int i10 = 0;
        this.f15066w = new Runnable(this) { // from class: kc.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ d f15047m;

            {
                this.f15047m = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i11 = i10;
                d dVar = this.f15047m;
                switch (i11) {
                    case 0:
                        dVar.setCancelable(true);
                        break;
                    default:
                        TextView textView = dVar.D;
                        if (textView != null && !textView.isFocused()) {
                            d.a(dVar.D, R.color.white);
                            dVar.D.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView2 = dVar.E;
                        if (textView2 != null && !textView2.isFocused()) {
                            d.a(dVar.E, R.color.white);
                            dVar.E.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView3 = dVar.F;
                        if (textView3 != null && !textView3.isFocused()) {
                            d.a(dVar.F, R.color.white);
                            dVar.F.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView4 = dVar.G;
                        if (textView4 != null && !textView4.isFocused()) {
                            d.a(dVar.G, R.color.white);
                            dVar.G.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView5 = dVar.H;
                        if (textView5 != null && !textView5.isFocused()) {
                            d.a(dVar.H, R.color.white);
                            dVar.H.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView6 = dVar.I;
                        if (textView6 != null && !textView6.isFocused()) {
                            d.a(dVar.I, R.color.white);
                            dVar.I.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView7 = dVar.L;
                        if (textView7 != null && !textView7.isFocused()) {
                            d.a(dVar.L, R.color.white);
                            dVar.L.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView8 = dVar.J;
                        if (textView8 != null && !textView8.isFocused()) {
                            d.a(dVar.J, R.color.white);
                            dVar.J.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView9 = dVar.K;
                        if (textView9 != null && !textView9.isFocused()) {
                            d.a(dVar.K, R.color.white);
                            dVar.K.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView10 = dVar.M;
                        if (textView10 != null && !textView10.isFocused()) {
                            d.a(dVar.M, R.color.white);
                            dVar.M.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                        }
                        TextView textView11 = dVar.N;
                        if (textView11 != null && !textView11.isFocused()) {
                            d.a(dVar.N, R.color.white);
                            dVar.N.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            break;
                        }
                        break;
                }
            }
        };
        this.f15065v = new Handler();
        final int i11 = 1;
        try {
            f15051d0.applyFontToView(this.T, f15050c0);
            f15051d0.applyFontToView(this.U, f15050c0);
            f15051d0.applyFontToView(this.V, f15050c0);
            f15051d0.applyFontToView(this.S, f15050c0);
            f15051d0.applyFontToView(this.R, f15050c0);
            this.O.requestFocus();
            new Handler().postDelayed(new Runnable(this) { // from class: kc.b

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ d f15047m;

                {
                    this.f15047m = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i112 = i11;
                    d dVar = this.f15047m;
                    switch (i112) {
                        case 0:
                            dVar.setCancelable(true);
                            break;
                        default:
                            TextView textView = dVar.D;
                            if (textView != null && !textView.isFocused()) {
                                d.a(dVar.D, R.color.white);
                                dVar.D.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView2 = dVar.E;
                            if (textView2 != null && !textView2.isFocused()) {
                                d.a(dVar.E, R.color.white);
                                dVar.E.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView3 = dVar.F;
                            if (textView3 != null && !textView3.isFocused()) {
                                d.a(dVar.F, R.color.white);
                                dVar.F.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView4 = dVar.G;
                            if (textView4 != null && !textView4.isFocused()) {
                                d.a(dVar.G, R.color.white);
                                dVar.G.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView5 = dVar.H;
                            if (textView5 != null && !textView5.isFocused()) {
                                d.a(dVar.H, R.color.white);
                                dVar.H.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView6 = dVar.I;
                            if (textView6 != null && !textView6.isFocused()) {
                                d.a(dVar.I, R.color.white);
                                dVar.I.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView7 = dVar.L;
                            if (textView7 != null && !textView7.isFocused()) {
                                d.a(dVar.L, R.color.white);
                                dVar.L.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView8 = dVar.J;
                            if (textView8 != null && !textView8.isFocused()) {
                                d.a(dVar.J, R.color.white);
                                dVar.J.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView9 = dVar.K;
                            if (textView9 != null && !textView9.isFocused()) {
                                d.a(dVar.K, R.color.white);
                                dVar.K.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView10 = dVar.M;
                            if (textView10 != null && !textView10.isFocused()) {
                                d.a(dVar.M, R.color.white);
                                dVar.M.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                            }
                            TextView textView11 = dVar.N;
                            if (textView11 != null && !textView11.isFocused()) {
                                d.a(dVar.N, R.color.white);
                                dVar.N.setTextColor(dVar.getResources().getColor(R.color.color_grey));
                                break;
                            }
                            break;
                    }
                }
            }, 100L);
        } catch (Exception unused) {
        }
        if (this.f15067x) {
            setCancelable(true);
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            this.A.setVisibility(0);
            this.B.setVisibility(8);
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.f15055b0) {
            this.f15065v.postDelayed(this.f15066w, 10000L);
        }
    }

    public void setButton1(String str, View.OnClickListener onClickListener) {
        this.Y = str;
        this.f15054b = onClickListener;
    }

    public void setButton2(String str, View.OnClickListener onClickListener) {
        this.Z = str;
        this.f15056m = onClickListener;
    }

    public void setButton3(String str, View.OnClickListener onClickListener) {
        this.f15053a0 = str;
        this.f15057n = onClickListener;
    }

    public void setButton_check_update_listener(View.OnClickListener onClickListener) {
        this.f15058o = onClickListener;
    }

    public void setButton_contact_us_listener(View.OnClickListener onClickListener) {
        this.f15060q = onClickListener;
    }

    public void setImport_Playlist_listener(View.OnClickListener onClickListener) {
        this.f15064u = onClickListener;
    }

    public void setListener_donation(View.OnClickListener onClickListener) {
        this.f15062s = onClickListener;
    }

    public void setListener_watched(View.OnClickListener onClickListener) {
        this.f15059p = onClickListener;
    }

    public void setMenuMode() {
        f15052e0 = true;
        this.f15067x = true;
    }

    public void setMessage(String str) {
        this.X = str;
    }

    public void setMessageTextSize(float f10) {
        this.C = f10;
    }

    public void setMyplaylist_listener(View.OnClickListener onClickListener) {
        this.f15063t = onClickListener;
    }

    public void setTitle(String str) {
        this.W = str;
    }

    public void setTrakt_listener(View.OnClickListener onClickListener) {
        this.f15061r = onClickListener;
    }

    public void setloading() {
        this.f15055b0 = true;
    }
}
