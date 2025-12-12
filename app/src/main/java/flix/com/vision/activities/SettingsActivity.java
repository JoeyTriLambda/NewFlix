package flix.com.vision.activities;

import ac.c;
import ac.l;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.tv.Constant;
import hd.e;
import java.io.File;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import r.j;
import ub.a2;
import ub.d2;
import ub.q0;
import ub.z1;

/* loaded from: classes2.dex */
public class SettingsActivity extends j {

    /* renamed from: o2, reason: collision with root package name */
    public static final /* synthetic */ int f11809o2 = 0;
    public TextView A0;
    public LinearLayout A1;
    public TextView B0;
    public LinearLayout B1;
    public TextView C0;
    public LinearLayout C1;
    public TextView D0;
    public LinearLayout D1;
    public TextView E0;
    public LinearLayout E1;
    public TextView F0;
    public LinearLayout F1;
    public TextView G0;
    public LinearLayout G1;
    public TextView H0;
    public LinearLayout H1;
    public TextView I0;
    public LinearLayout I1;
    public TextView J0;
    public LinearLayout J1;
    public TextView K0;
    public LinearLayout K1;
    public ArrayList<String> L;
    public TextView L0;
    public LinearLayout L1;
    public ArrayList<String> M;
    public TextView M0;
    public CheckBox M1;
    public View N;
    public TextView N0;
    public CheckBox N1;
    public ImageView O;
    public TextView O0;
    public CheckBox O1;
    public ImageView P;
    public TextView P0;
    public CheckBox P1;
    public ImageView Q;
    public TextView Q0;
    public CheckBox Q1;
    public c4.a R;
    public TextView R0;
    public CheckBox R1;
    public Typeface S;
    public TextView S0;
    public CheckBox S1;
    public Typeface T;
    public TextView T0;
    public CheckBox T1;
    public ProgressDialog U;
    public TextView U0;
    public CheckBox U1;
    public boolean V;
    public FrameLayout V0;
    public CheckBox V1;
    public boolean W;
    public FrameLayout W0;
    public CheckBox W1;
    public CharSequence[] X;
    public FrameLayout X0;
    public CheckBox X1;
    public CharSequence[] Y;
    public FrameLayout Y0;
    public CheckBox Y1;
    public CharSequence[] Z;
    public FrameLayout Z0;
    public CheckBox Z1;

    /* renamed from: a0, reason: collision with root package name */
    public CharSequence[] f11810a0;

    /* renamed from: a1, reason: collision with root package name */
    public FrameLayout f11811a1;

    /* renamed from: a2, reason: collision with root package name */
    public CheckBox f11812a2;

    /* renamed from: b0, reason: collision with root package name */
    public CircleImageView f11813b0;

    /* renamed from: b1, reason: collision with root package name */
    public FrameLayout f11814b1;

    /* renamed from: b2, reason: collision with root package name */
    public CheckBox f11815b2;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f11816c0;

    /* renamed from: c1, reason: collision with root package name */
    public FrameLayout f11817c1;

    /* renamed from: c2, reason: collision with root package name */
    public CheckBox f11818c2;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f11819d0;

    /* renamed from: d1, reason: collision with root package name */
    public FrameLayout f11820d1;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f11822e0;

    /* renamed from: e1, reason: collision with root package name */
    public FrameLayout f11823e1;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f11825f0;

    /* renamed from: f1, reason: collision with root package name */
    public FrameLayout f11826f1;

    /* renamed from: f2, reason: collision with root package name */
    public RecyclerView f11827f2;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f11828g0;

    /* renamed from: g1, reason: collision with root package name */
    public LinearLayout f11829g1;

    /* renamed from: g2, reason: collision with root package name */
    public View f11830g2;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f11831h0;

    /* renamed from: h1, reason: collision with root package name */
    public LinearLayout f11832h1;

    /* renamed from: h2, reason: collision with root package name */
    public l f11833h2;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f11834i0;

    /* renamed from: i1, reason: collision with root package name */
    public LinearLayout f11835i1;

    /* renamed from: j0, reason: collision with root package name */
    public TextView f11837j0;

    /* renamed from: j1, reason: collision with root package name */
    public LinearLayout f11838j1;

    /* renamed from: j2, reason: collision with root package name */
    public View f11839j2;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f11840k0;

    /* renamed from: k1, reason: collision with root package name */
    public LinearLayout f11841k1;

    /* renamed from: k2, reason: collision with root package name */
    public String[] f11842k2;

    /* renamed from: l0, reason: collision with root package name */
    public TextView f11843l0;

    /* renamed from: l1, reason: collision with root package name */
    public LinearLayout f11844l1;

    /* renamed from: m0, reason: collision with root package name */
    public TextView f11846m0;

    /* renamed from: m1, reason: collision with root package name */
    public LinearLayout f11847m1;

    /* renamed from: n0, reason: collision with root package name */
    public TextView f11849n0;

    /* renamed from: n1, reason: collision with root package name */
    public LinearLayout f11850n1;

    /* renamed from: n2, reason: collision with root package name */
    public boolean f11851n2;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f11852o0;

    /* renamed from: o1, reason: collision with root package name */
    public LinearLayout f11853o1;

    /* renamed from: p0, reason: collision with root package name */
    public TextView f11854p0;

    /* renamed from: p1, reason: collision with root package name */
    public LinearLayout f11855p1;

    /* renamed from: q0, reason: collision with root package name */
    public TextView f11856q0;

    /* renamed from: q1, reason: collision with root package name */
    public LinearLayout f11857q1;

    /* renamed from: r0, reason: collision with root package name */
    public TextView f11858r0;

    /* renamed from: r1, reason: collision with root package name */
    public LinearLayout f11859r1;

    /* renamed from: s0, reason: collision with root package name */
    public TextView f11860s0;

    /* renamed from: s1, reason: collision with root package name */
    public LinearLayout f11861s1;

    /* renamed from: t0, reason: collision with root package name */
    public TextView f11862t0;

    /* renamed from: t1, reason: collision with root package name */
    public LinearLayout f11863t1;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f11864u0;

    /* renamed from: u1, reason: collision with root package name */
    public LinearLayout f11865u1;

    /* renamed from: v0, reason: collision with root package name */
    public TextView f11866v0;

    /* renamed from: v1, reason: collision with root package name */
    public LinearLayout f11867v1;

    /* renamed from: w0, reason: collision with root package name */
    public TextView f11868w0;

    /* renamed from: w1, reason: collision with root package name */
    public LinearLayout f11869w1;

    /* renamed from: x0, reason: collision with root package name */
    public TextView f11870x0;

    /* renamed from: x1, reason: collision with root package name */
    public LinearLayout f11871x1;

    /* renamed from: y0, reason: collision with root package name */
    public TextView f11872y0;

    /* renamed from: y1, reason: collision with root package name */
    public LinearLayout f11873y1;

    /* renamed from: z0, reason: collision with root package name */
    public TextView f11874z0;

    /* renamed from: z1, reason: collision with root package name */
    public LinearLayout f11875z1;
    public final String[] K = {"glg--Galician", "mni--Manipuri", "bos--Bosnian", "swe--Swedish", "ind--Indonesian", "ita--Italian", "est--Estonian", "vie--Vietnamese", "heb--Hebrew", "tam--Tamil", "rus--Russian", "spa--Spanish", "fin--Finnish", "epo--Esperanto", "lit--Lithuanian", "scc--Serbian", "hun--Hungarian", "pob--Portuguese (BR)", "ast--Asturian", "ben--Bengali", "hin--Hindi", "mon--Mongolian", "aze--Azerbaijani", "pom--Portuguese (MZ)", "arm--Armenian", "alb--Albanian", "khm--Khmer", "afr--Afrikaans", "lav--Latvian", "geo--Georgian", "nor--Norwegian", "ger--German", "bur--Burmese", "chi--Chinese (simplified)", "mac--Macedonian", "mne--Montenegrin", "tgl--Tagalog", "por--Portuguese", "zht--Chinese (traditional)", "bre--Breton", "kaz--Kazakh", "hrv--Croatian", "tur--Turkish", "kan--Kannada", "zhe--Chinese bilingual", "fre--French", "slo--Slovak", "ltz--Luxembourgish", "dut--Dutch", "kur--Kurdish", "ice--Icelandic", "mal--Malayalam", "oci--Occitan", "syr--Syriac", "bel--Belarusian", "baq--Basque", "swa--Swahili", "jpn--Japanese", "urd--Urdu", "ukr--Ukrainian", "bul--Bulgarian", "sin--Sinhalese", "dan--Danish", "rum--Romanian", "ell--Greek", "tel--Telugu", "tha--Thai", "cze--Czech", "pol--Polish", "eng--English", "cat--Catalan", "ext--Extremaduran", "may--Malay", "slv--Slovenian", "kor--Korean", "ara--Arabic", "per--Persian"};

    /* renamed from: d2, reason: collision with root package name */
    public String f11821d2 = "";

    /* renamed from: e2, reason: collision with root package name */
    public final int[] f11824e2 = {R.color.md_red_500, R.color.md_pink_500, R.color.md_purple_500, R.color.md_deep_purple_500, R.color.md_indigo_500, R.color.md_blue_500, R.color.md_light_blue_500, R.color.md_cyan_500, R.color.md_teal_500, R.color.md_green_500, R.color.md_light_green_500, R.color.md_lime_500, R.color.md_yellow_500, R.color.md_amber_500, R.color.md_orange_500, R.color.md_deep_orange_500, R.color.md_brown_500, R.color.md_grey_500, R.color.md_blue_grey_500, R.color.md_white_1};

    /* renamed from: i2, reason: collision with root package name */
    public final ArrayList<e> f11836i2 = new ArrayList<>();

    /* renamed from: l2, reason: collision with root package name */
    public final CharSequence[] f11845l2 = {"18sp", "23sp", "28sp", "33sp", "38sp", "48sp", "58sp"};

    /* renamed from: m2, reason: collision with root package name */
    public final CharSequence[] f11848m2 = {"Default Charset", "UTF-8 utf-8", "UTF-16 LE utf-16 le", "UTF-16 BE utf-16 be", "Western (Windows 1252) windows-1252", "Western (ISO 8859-1) iso-8859-1", "Western (ISO 8859-3) iso-8859-3", "Western (ISO 8859-15) iso-8859-15", "Western (Mac Roman) macroman", "Arabic (Windows 1256) windows-1256", "Arabic (ISO 8859-6) iso-8859-6", "Baltic (Windows 1257) windows-1257", "Baltic (ISO 8859-4) iso-8859-4", "Celtic (ISO 8859-14) iso-8859-14", "Central European (Windows 1250) windows-1250", "Central European (ISO 8859-2) iso-8859-2", "Central European (CP 852) cp-852", "Cyrillic (Windows 1251) windows-1251", "Cyrillic (CP 866) cp-866", "Cyrillic (ISO 8859-5) iso-8859-5", "Cyrillic (KO18-R) koi8-r", "Cyrillic (KOI8-U) koi8-u", "Estonian (ISO 8859-13) iso-8859-13", "Greek (Windows 1253) windows-1253", "Greek (ISO 8859-7) iso-8859-7", "Hebrew (Windows 1255) windows-1255", "Hebrew (ISO 8859-8) iso-8859-8", "Nordic (ISO 8859-10) iso-8859-10", "Romanian (ISO 8859-16) iso-8859-16", "Turkish (Windows 1254) windows-1254", "Turkish (ISO 8859-9) iso-8859-9", "Vietnamese (Windows 1258) windows-1258", "Simplified Chinese (GBK) gbk", "Simplified Chinese (GB18030) gb18030", "Traditional Chinese (Big5) c950", "Traditional Chinese (Big5-HKSCS) big5-hkscs", "Japanese (Shift JIS) Shift_JIS", "Japanese (EUC-JP) EUC_JP_LINUX", "Korean (EUC-KR) euc-kr", "Thai (Windows 874) windows-874", "Latin/Thai (ISO 8859-11) iso-8859-11", "Cyrillic (KOI8-RU) koi8-ru", "Tajik (KO18-T) KOI8_R", "Simplified Chinese (GB 2312) EUC_CN", "Nordic DOS (CP 865) Cp865", "Western European DOS (CP 850) cp850"};

    public static String humanReadableByteCountBin(long j10) {
        long jAbs = j10 == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(j10);
        if (jAbs < 1024) {
            return j10 + " B";
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("KMGTPE");
        long j11 = jAbs;
        for (int i10 = 40; i10 >= 0 && jAbs > (1152865209611504844 >> i10); i10 -= 10) {
            j11 >>= 10;
            stringCharacterIterator.next();
        }
        return String.format("%.1f %ciB", Double.valueOf((j11 * Long.signum(j10)) / 1024.0d), Character.valueOf(stringCharacterIterator.current()));
    }

    public final void d(final String str, final boolean z10) {
        ArrayList<e> arrayList = this.f11836i2;
        arrayList.clear();
        for (int i10 : this.f11824e2) {
            e eVar = new e();
            eVar.f12990a = i10;
            if (App.getInstance().f11574v.getInt(str, !z10 ? R.color.md_deep_orange_500 : R.color.md_white_1) == i10) {
                eVar.f12991b = true;
            }
            arrayList.add(eVar);
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.color_chooser_dialog, (ViewGroup) null);
        this.f11830g2 = viewInflate;
        this.f11827f2 = (RecyclerView) viewInflate.findViewById(R.id.recyclerview);
        this.f11833h2 = new l(this, arrayList, str);
        this.f11827f2.setLayoutManager(new GridLayoutManager(this, 5));
        this.f11827f2.setAdapter(this.f11833h2);
        d dVarCreate = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogCustom)).create();
        dVarCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ub.y1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                int i11 = SettingsActivity.f11809o2;
                SettingsActivity settingsActivity = this.f20326b;
                settingsActivity.getClass();
                boolean z11 = z10;
                String str2 = str;
                try {
                    if (z11) {
                        settingsActivity.N.setBackgroundResource(App.getInstance().f11574v.getInt(str2, R.color.md_white_1));
                    } else {
                        settingsActivity.f11839j2.setBackgroundResource(App.getInstance().f11574v.getInt(str2, R.color.md_deep_orange_500));
                    }
                } catch (Exception unused) {
                }
            }
        });
        this.f11833h2.setAlertDialog(dVarCreate);
        dVarCreate.setView(this.f11830g2);
        this.f11827f2.requestFocus();
        try {
            dVarCreate.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean deleteDir(File file) {
        if (file == null || !file.isDirectory()) {
            if (file == null || !file.isFile()) {
                return false;
            }
            return file.delete();
        }
        for (String str : file.list()) {
            if (!deleteDir(new File(file, str))) {
                return false;
            }
        }
        return file.delete();
    }

    public final void e() {
        int i10 = App.getInstance().f11574v.getInt("pref_adult_zone_player", 0);
        String string = this.X[i10].toString();
        if (i10 == 0) {
            string = c.B(string, " (Includes related videos view in Player)");
        }
        this.N0.setText(string);
        if (i10 == 0) {
            this.O.setImageResource(R.drawable.app_logo_con_icon_1);
            return;
        }
        if (i10 == 1) {
            this.O.setImageResource(R.drawable.mxplayer);
            return;
        }
        if (i10 == 2) {
            this.O.setImageResource(R.drawable.vlc_icon);
        } else if (i10 == 3) {
            this.O.setImageResource(R.drawable.xplayer);
        } else {
            if (i10 != 4) {
                return;
            }
            this.O.setImageResource(R.drawable.ic_action_play_circle_filled);
        }
    }

    public final void f() {
        e();
        h();
        if (App.getInstance().f11574v.getBoolean("pref_adult_zone_pin_set", false)) {
            this.f11866v0.setText("Change AdultZone PIN");
            this.f11868w0.setText("Press here to change your current AdultZone PIN");
        } else {
            this.f11866v0.setText("Create AdultZone PIN");
            this.f11868w0.setText("Create your 4 Digits PIN to access AdultZone");
        }
    }

    public final void g() {
        int i10 = App.getInstance().f11574v.getInt("pref_tv_layout", 0);
        this.E0.setText(this.Y[i10].toString());
        if (i10 == 0) {
            this.Q.setImageResource(R.drawable.poster_immersive);
        } else {
            this.Q.setImageResource(R.drawable.poster_classic);
        }
    }

    public String getCacheSize() {
        File[] fileArrListFiles = getBaseContext().getCacheDir().listFiles();
        long length = 0;
        try {
            for (File file : getBaseContext().getExternalCacheDirs()) {
                length += file.length();
            }
            File file2 = new File(getBaseContext().getCacheDir().getParent());
            if (file2.exists()) {
                for (String str : file2.list()) {
                    if (!str.equals("lib")) {
                        length += new File(file2, str).length();
                    }
                }
            }
            File file3 = new File(getExternalCacheDir().getAbsolutePath() + "/subs/");
            if (file3.exists()) {
                for (String str2 : file3.list()) {
                    length += new File(file3, str2).length();
                }
            }
        } catch (Exception unused) {
        }
        for (File file4 : fileArrListFiles) {
            length += file4.length();
        }
        return humanReadableByteCountBin(length);
    }

    public final void h() {
        int i10 = App.getInstance().f11574v.getInt("player_index", 0);
        this.U0.setText(this.X[i10].toString());
        if (i10 == 0) {
            this.P.setImageResource(R.drawable.app_logo_con_icon_1);
            return;
        }
        if (i10 == 1) {
            this.P.setImageResource(R.drawable.mxplayer);
            return;
        }
        if (i10 == 2) {
            this.P.setImageResource(R.drawable.vlc_icon);
        } else if (i10 == 3) {
            this.P.setImageResource(R.drawable.xplayer);
        } else {
            if (i10 != 4) {
                return;
            }
            this.P.setImageResource(R.drawable.ic_action_play_circle_filled);
        }
    }

    public final void i() {
        if (!App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false) || App.getInstance().f11574v.getString("trakt_avatar", "").isEmpty()) {
            try {
                if (this.f11813b0 != null) {
                    Picasso.get().load(R.drawable.trakt_logo_3).fit().centerCrop().into(this.f11813b0);
                    this.f11813b0.setBorderColor(getResources().getColor(R.color.white));
                }
            } catch (Exception unused) {
            }
            this.f11852o0.setText(getResources().getString(R.string.connect_with_trakt_tv_to_keep_track_of_your_watched_content));
            return;
        }
        this.f11852o0.setText("You're connected with your account @" + App.getInstance().f11574v.getString("trakt_user_name", "n/A"));
        try {
            if (this.f11813b0 != null) {
                Picasso.get().load(App.getInstance().f11574v.getString("trakt_avatar", "")).fit().centerCrop().into(this.f11813b0);
                this.f11813b0.setBorderColor(getResources().getColor(R.color.white));
            }
        } catch (Exception unused2) {
        }
    }

    public final void j(Set<String> set, boolean z10) {
        String str;
        HashSet hashSet = new HashSet();
        hashSet.add("eng--English");
        if (set == null) {
            set = App.getInstance().f11574v.getStringSet("prefs_sub_lang_set_1", hashSet);
        }
        Iterator<String> it = set.iterator();
        String strC = "";
        String strC2 = strC;
        while (it.hasNext()) {
            String next = it.next();
            try {
                String[] strArrSplit = next.split("--");
                String str2 = strArrSplit[strArrSplit.length - 1];
                str = strArrSplit[0];
                next = str2;
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            strC = strC.length() > 0 ? c.C(strC, ", ", next) : next;
            strC2 = strC2.length() > 0 ? c.C(strC2, ", ", str) : str;
        }
        this.C0.setText(strC);
        if (z10) {
            App.getInstance().f11574v.edit().putString("sub_lang_name_1", strC).apply();
        }
        App.getInstance().f11574v.edit().putString("subtitle_code_multi_1", strC2).apply();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11851n2) {
            hd.l lVar = new hd.l();
            lVar.f13032c = App.getInstance().f11574v.getString("pref_subtitle_encoding_label", null);
            EventBus.getDefault().post(lVar);
        }
        if (this.V) {
            Intent intent = new Intent();
            intent.putExtra("result", 1100);
            setResult(1100, intent);
            finish();
        }
        if (this.W) {
            App.getInstance().f11566n = true;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting);
        final int i10 = 0;
        RealDebridCommon.f12051p = App.getInstance().f11574v.getBoolean("IS_RD_LOGGED_IN", false);
        this.L = new ArrayList<>();
        this.M = new ArrayList<>();
        ArrayList<String> arrayList = this.L;
        String[] strArr = this.K;
        arrayList.addAll(Arrays.asList(strArr));
        this.M.addAll(Arrays.asList(strArr));
        Collections.sort(this.L);
        Collections.sort(this.M);
        this.f11842k2 = new String[this.L.size()];
        for (int i11 = 0; i11 < this.L.size(); i11++) {
            try {
                this.f11842k2[i11] = this.L.get(i11).split("--")[r0.length - 1];
            } catch (Exception e10) {
                e10.printStackTrace();
                this.f11842k2[i11] = this.L.get(i11);
            }
        }
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.S = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.T = Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.R = new c4.a();
        final int i12 = 2;
        final int i13 = 1;
        this.f11810a0 = new CharSequence[]{"Single Language", "Multi Language"};
        int i14 = 5;
        final int i15 = 3;
        int i16 = 4;
        this.X = new CharSequence[]{"FLIX VISION Player (Default)", "MX Player", "VLC", "XPlayer", "Select Manually"};
        this.Y = new CharSequence[]{"MODERN", "CLASSIC"};
        int i17 = 6;
        this.Z = new CharSequence[]{"1 Minute", "2 Minutes", "3 Minutes", "4 Minutes", "5 Minutes", "6 Minutes"};
        this.M1 = (CheckBox) findViewById(R.id.checkbox_hi_res_image);
        this.f11829g1 = (LinearLayout) findViewById(R.id.setting_high_res_layout);
        this.N1 = (CheckBox) findViewById(R.id.show_movie_logo_checkbox);
        this.f11832h1 = (LinearLayout) findViewById(R.id.setting_show_logo_as_loading);
        this.f11835i1 = (LinearLayout) findViewById(R.id.setting_adult_big_pictures);
        this.f11838j1 = (LinearLayout) findViewById(R.id.setting_subtitle_text_encoding);
        this.f11816c0 = (TextView) findViewById(R.id.subtitle_encoding_textview);
        this.P1 = (CheckBox) findViewById(R.id.hide_continue);
        this.O1 = (CheckBox) findViewById(R.id.checkbox_adultzone_big_pictures);
        this.f11841k1 = (LinearLayout) findViewById(R.id.setting_hide_continue);
        this.f11870x0 = (TextView) findViewById(R.id.alldebrid_text4);
        this.f11872y0 = (TextView) findViewById(R.id.all_debrid_text2);
        this.f11874z0 = (TextView) findViewById(R.id.alldebrid_text3);
        this.f11844l1 = (LinearLayout) findViewById(R.id.setting_all_debrid);
        this.Q1 = (CheckBox) findViewById(R.id.show_rd_only_checkbox);
        this.f11847m1 = (LinearLayout) findViewById(R.id.setting_show_rd_only);
        this.V0 = (FrameLayout) findViewById(R.id.setting_adult_animate_frame_frame);
        this.W0 = (FrameLayout) findViewById(R.id.setting_sound_frame_frame);
        this.X0 = (FrameLayout) findViewById(R.id.setting_classic_search_frame);
        this.Y0 = (FrameLayout) findViewById(R.id.setting_tv_layout_frame);
        this.f11850n1 = (LinearLayout) findViewById(R.id.setting_classic_search);
        this.R1 = (CheckBox) findViewById(R.id.checkbox_classic_search);
        this.f11828g0 = (TextView) findViewById(R.id.backup_location_text);
        String backupFileLocation = jc.a.getBackupFileLocation(this);
        if (backupFileLocation != null) {
            this.f11828g0.setText("path: ".concat(backupFileLocation));
            this.f11828g0.setVisibility(0);
        }
        this.f11831h0 = (TextView) findViewById(R.id.rd_text2);
        this.f11855p1 = (LinearLayout) findViewById(R.id.setting_real_debrid);
        this.f11834i0 = (TextView) findViewById(R.id.subtitle_source_textview);
        int i18 = App.getInstance().f11574v.getInt("subtitle_source_index_2", 0);
        this.f11834i0.setText(this.f11810a0[i18]);
        if (i18 > 0) {
            this.f11834i0.setText(this.f11810a0[i18]);
        }
        this.f11857q1 = (LinearLayout) findViewById(R.id.setting_subtitle_source);
        this.C0 = (TextView) findViewById(R.id.subtitle_language_textview);
        if (App.getInstance().f11574v.getInt("subtitle_source_index_2", 0) == 0) {
            this.C0.setText(this.f11842k2[App.getInstance().f11574v.getInt("sub_lang_index_1", 19)]);
        } else {
            j(null, false);
        }
        this.f11819d0 = (TextView) findViewById(R.id.realdebrid_text3);
        this.f11822e0 = (TextView) findViewById(R.id.realdebrid_text4);
        this.f11825f0 = (TextView) findViewById(R.id.premiumize_text3);
        this.A0 = (TextView) findViewById(R.id.premiumize_text2);
        this.f11853o1 = (LinearLayout) findViewById(R.id.setting_premiumize);
        this.Z0 = (FrameLayout) findViewById(R.id.setting_backup_data);
        this.f11811a1 = (FrameLayout) findViewById(R.id.setting_restore_data);
        this.N = findViewById(R.id.color_template_view_subtitles);
        this.B0 = (TextView) findViewById(R.id.subtitle_size_textview);
        this.f11863t1 = (LinearLayout) findViewById(R.id.setting_subtitle_language);
        this.f11861s1 = (LinearLayout) findViewById(R.id.setting_subtitle_color);
        this.f11859r1 = (LinearLayout) findViewById(R.id.setting_subtitle_text_size);
        this.f11865u1 = (LinearLayout) findViewById(R.id.setting_autoplay_minutes_frame);
        this.f11837j0 = (TextView) findViewById(R.id.auto_play_minutes_text);
        this.f11867v1 = (LinearLayout) findViewById(R.id.setting_autoplay_frame);
        this.S1 = (CheckBox) findViewById(R.id.checkbox_auto_play_nextep);
        this.f11869w1 = (LinearLayout) findViewById(R.id.setting_sound_frame);
        this.f11814b1 = (FrameLayout) findViewById(R.id.frame_faqs);
        this.U1 = (CheckBox) findViewById(R.id.checkbox_hindi_direct);
        this.T1 = (CheckBox) findViewById(R.id.checkbox_sound);
        this.f11871x1 = (LinearLayout) findViewById(R.id.setting_hindi_frame_direct);
        this.Q = (ImageView) findViewById(R.id.tv_layout_imageview);
        this.E0 = (TextView) findViewById(R.id.setting_tv_layout_text_2);
        this.D0 = (TextView) findViewById(R.id.setting_tv_layout_text);
        this.f11873y1 = (LinearLayout) findViewById(R.id.setting_tv_layout);
        this.V1 = (CheckBox) findViewById(R.id.checkbox_adultzone_show_related);
        this.f11843l0 = (TextView) findViewById(R.id.text_adultZone_related1);
        this.f11840k0 = (TextView) findViewById(R.id.text_adultZone_related2);
        this.f11875z1 = (LinearLayout) findViewById(R.id.setting_adult_show_related_frame);
        this.W1 = (CheckBox) findViewById(R.id.checkbox_adultzone_animate);
        this.G0 = (TextView) findViewById(R.id.text_adultZone_animate1);
        this.F0 = (TextView) findViewById(R.id.text_adultZone_animate2);
        this.E1 = (LinearLayout) findViewById(R.id.setting_adult_animate_frame);
        this.X1 = (CheckBox) findViewById(R.id.checkbox_play_best_res);
        this.f11856q0 = (TextView) findViewById(R.id.text_adultZone_res_1);
        this.f11858r0 = (TextView) findViewById(R.id.text_adultZone_res_2);
        this.L1 = (LinearLayout) findViewById(R.id.setting_adult_best_res_frame);
        this.P = (ImageView) findViewById(R.id.tv_player_icon);
        this.T0 = (TextView) findViewById(R.id.setting_tv_player_text1);
        this.U0 = (TextView) findViewById(R.id.setting_tv_player_text2);
        this.K1 = (LinearLayout) findViewById(R.id.setting_tv_player);
        this.O = (ImageView) findViewById(R.id.adult_player_icon);
        this.M0 = (TextView) findViewById(R.id.setting_adult_player_text1);
        this.N0 = (TextView) findViewById(R.id.setting_adult_player_text2);
        this.J1 = (LinearLayout) findViewById(R.id.setting_adult_player);
        this.f11866v0 = (TextView) findViewById(R.id.setup_or_change_pin_text1);
        this.f11868w0 = (TextView) findViewById(R.id.setup_or_change_pin_text2);
        this.I1 = (LinearLayout) findViewById(R.id.setting_set_or_change_pin);
        this.f11818c2 = (CheckBox) findViewById(R.id.checkbox_adultzone);
        this.H1 = (LinearLayout) findViewById(R.id.setting_adult_frame);
        this.f11864u0 = (TextView) findViewById(R.id.text_adulzone1);
        this.f11862t0 = (TextView) findViewById(R.id.show_current_time_text1);
        this.f11854p0 = (TextView) findViewById(R.id.text_hindi1);
        this.f11860s0 = (TextView) findViewById(R.id.text_hindi2);
        this.G1 = (LinearLayout) findViewById(R.id.setting_hindi_frame);
        this.H0 = (TextView) findViewById(R.id.settings_text1);
        this.I0 = (TextView) findViewById(R.id.settings_text2);
        this.J0 = (TextView) findViewById(R.id.settings_text3);
        this.K0 = (TextView) findViewById(R.id.settings_text6);
        this.L0 = (TextView) findViewById(R.id.settings_text7);
        this.O0 = (TextView) findViewById(R.id.settings_text8);
        this.P0 = (TextView) findViewById(R.id.settings_text9);
        this.Q0 = (TextView) findViewById(R.id.settings_text10);
        this.R0 = (TextView) findViewById(R.id.settings_text11);
        this.S0 = (TextView) findViewById(R.id.settings_text12);
        this.f11815b2 = (CheckBox) findViewById(R.id.checkbox_hindi);
        this.f11812a2 = (CheckBox) findViewById(R.id.checkbox_hide_unreleased_movies);
        this.F1 = (LinearLayout) findViewById(R.id.setting_hide_unreleased_movies);
        this.f11852o0 = (TextView) findViewById(R.id.trakt_status_text);
        this.f11813b0 = (CircleImageView) findViewById(R.id.trakt_avatar);
        this.D1 = (LinearLayout) findViewById(R.id.setting_trakt);
        this.f11849n0 = (TextView) findViewById(R.id.cache_textview);
        this.Z1 = (CheckBox) findViewById(R.id.show_time_checkbox);
        this.C1 = (LinearLayout) findViewById(R.id.setting_show_time);
        this.f11826f1 = (FrameLayout) findViewById(R.id.version_frame);
        this.f11817c1 = (FrameLayout) findViewById(R.id.setting_update);
        this.f11820d1 = (FrameLayout) findViewById(R.id.setting_clear_cache);
        this.f11823e1 = (FrameLayout) findViewById(R.id.setting_clear_search_history);
        this.f11846m0 = (TextView) findViewById(R.id.version);
        this.A1 = (LinearLayout) findViewById(R.id.setting_mouse_color);
        this.f11839j2 = findViewById(R.id.color_template_view);
        this.B1 = (LinearLayout) findViewById(R.id.setting_hide_episodes);
        this.Y1 = (CheckBox) findViewById(R.id.hide_episodes);
        try {
            this.f11839j2.setBackgroundResource(App.getInstance().f11574v.getInt("mouse_toggle_color", R.color.md_deep_orange_500));
        } catch (Exception unused) {
        }
        try {
            this.N.setBackgroundResource(App.getInstance().f11574v.getInt("subtitle_color", R.color.md_white_1));
        } catch (Exception unused2) {
        }
        this.f11849n0.setText("Clear Cache - " + getCacheSize());
        this.B0.setText(this.f11845l2[App.getInstance().f11574v.getInt("pref_subtitle_size", 3)]);
        this.f11816c0.setText(this.f11848m2[App.getInstance().f11574v.getInt("pref_subtitle_encoding_index", 0)]);
        this.R.applyFontToView(this.D0, this.T);
        this.R.applyFontToView(this.E0, this.S);
        this.R.applyFontToView(this.f11843l0, this.S);
        this.R.applyFontToView(this.f11840k0, this.T);
        this.R.applyFontToView(this.G0, this.T);
        this.R.applyFontToView(this.F0, this.S);
        this.R.applyFontToView(this.f11856q0, this.T);
        this.R.applyFontToView(this.f11858r0, this.S);
        this.R.applyFontToView(this.T0, this.T);
        this.R.applyFontToView(this.U0, this.S);
        this.R.applyFontToView(this.M0, this.T);
        this.R.applyFontToView(this.N0, this.S);
        this.R.applyFontToView(this.f11866v0, this.T);
        this.R.applyFontToView(this.f11868w0, this.S);
        this.R.applyFontToView(this.f11864u0, this.S);
        this.R.applyFontToView(this.f11864u0, this.T);
        this.R.applyFontToView(this.f11846m0, this.S);
        this.R.applyFontToView(this.f11860s0, this.S);
        this.R.applyFontToView(this.H0, this.S);
        this.R.applyFontToView(this.I0, this.S);
        this.R.applyFontToView(this.J0, this.T);
        this.R.applyFontToView(this.f11862t0, this.T);
        this.R.applyFontToView(this.K0, this.S);
        this.R.applyFontToView(this.L0, this.S);
        this.R.applyFontToView(this.O0, this.T);
        this.R.applyFontToView(this.P0, this.S);
        this.R.applyFontToView(this.Q0, this.T);
        this.R.applyFontToView(this.R0, this.S);
        this.R.applyFontToView(this.S0, this.T);
        this.R.applyFontToView(this.f11854p0, this.T);
        this.R.applyFontToView(this.f11852o0, this.S);
        this.R.applyFontToView(this.f11849n0, this.S);
        this.f11837j0.setText(this.Z[App.getInstance().f11574v.getInt("pref_auto_play_minutes", 2)]);
        o1.a.l(this, 0, this.f11847m1);
        o1.a.l(this, 11, this.f11835i1);
        o1.a.l(this, 12, this.f11832h1);
        o1.a.l(this, 16, this.f11829g1);
        o1.a.l(this, 27, this.f11850n1);
        this.Z0.setOnClickListener(new d2(this, i16));
        this.f11811a1.setOnClickListener(new d2(this, i14));
        this.f11814b1.setOnClickListener(new d2(this, i17));
        int i19 = 7;
        this.K1.setOnClickListener(new d2(this, i19));
        int i20 = 8;
        this.f11853o1.setOnClickListener(new d2(this, i20));
        o1.a.l(this, 1, this.f11844l1);
        o1.a.l(this, 2, this.f11873y1);
        o1.a.l(this, 3, this.f11863t1);
        o1.a.l(this, 4, this.f11859r1);
        o1.a.l(this, 5, this.f11838j1);
        o1.a.l(this, 6, this.f11857q1);
        o1.a.l(this, 7, this.f11855p1);
        o1.a.l(this, 8, this.J1);
        int i21 = 9;
        this.I1.setOnClickListener(new z1(this, i21));
        i();
        o1.a.l(this, 10, this.D1);
        this.M1.setChecked(App.getInstance().f11574v.getBoolean("pref_hd_posters", false));
        this.N1.setChecked(App.getInstance().f11574v.getBoolean("pref_logo_as_loading_players", true));
        this.O1.setChecked(App.getInstance().f11574v.getBoolean("pref_adult_show_big_pictures", false));
        this.Z1.setChecked(App.getInstance().f11574v.getBoolean("pref_show_time", true));
        this.P1.setChecked(App.getInstance().f11574v.getBoolean("pref_hide_continue", false));
        this.f11812a2.setChecked(App.getInstance().f11574v.getBoolean("pref_hide_unreleased", true));
        this.T1.setChecked(App.getInstance().f11574v.getBoolean("pref_play_intro_sound", true));
        this.f11815b2.setChecked(App.getInstance().f11574v.getBoolean("pref_show_hindi_dubbed", false));
        this.U1.setChecked(App.getInstance().f11574v.getBoolean("pref_show_hindi_dubbed_direct", true));
        this.R1.setChecked(App.getInstance().f11574v.getBoolean("pref_classic_search", false));
        this.Q1.setChecked(App.getInstance().f11574v.getBoolean("pref_show_debrid_links_only", false));
        this.S1.setChecked(App.getInstance().f11574v.getBoolean("pref_auto_play_next_ep", false));
        this.f11818c2.setChecked(App.getInstance().f11574v.getBoolean("pref_show_adult_zone", true));
        this.V1.setChecked(App.getInstance().f11574v.getBoolean("pref_show_adult_zone_hide_related", true));
        this.Y1.setChecked(App.getInstance().f11574v.getBoolean("pref_hide_episodes", false));
        this.X1.setChecked(App.getInstance().f11574v.getBoolean("pref_adult_zone_always_play_best", true));
        this.W1.setChecked(App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true));
        this.Y1.setOnCheckedChangeListener(new a2(i10));
        this.O1.setOnCheckedChangeListener(new a2(i13));
        this.N1.setOnCheckedChangeListener(new a2(i12));
        this.M1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: ub.b2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SettingsActivity f20158b;

            {
                this.f20158b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                int i22 = i10;
                SettingsActivity settingsActivity = this.f20158b;
                switch (i22) {
                    case 0:
                        int i23 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hd_posters", z10);
                        App.I = z10;
                        be.d.makeToastLong(settingsActivity, "Please Restart to see the Change", false);
                        break;
                    case 1:
                        int i24 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hide_continue", z10);
                        settingsActivity.W = true;
                        break;
                    case 2:
                        int i25 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_show_hindi_dubbed", z10);
                        if (!z10) {
                            o1.a.j(App.getInstance().f11574v, "hindi_include_english", true);
                            break;
                        } else {
                            FragmentManager fragmentManager = settingsActivity.getFragmentManager();
                            kc.d dVarNewInstance = kc.d.newInstance(settingsActivity, false);
                            dVarNewInstance.setTitle("Include English Links");
                            dVarNewInstance.setMessage("Do you want to get English links too or only Hindi links? This is only for Movies");
                            dVarNewInstance.setButton1("INCLUDE ENGLISH", new q0(9));
                            dVarNewInstance.setButton2("ONLY HINDI", new q0(10));
                            try {
                                dVarNewInstance.show(fragmentManager, "");
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    default:
                        int i26 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        App.getInstance().f11574v.edit().putBoolean("pref_show_adult_zone", z10).apply();
                        if (App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                            Toast.makeText(settingsActivity.getBaseContext(), "Please restart App to see the change", 1).show();
                            break;
                        }
                        break;
                }
            }
        });
        this.T1.setOnCheckedChangeListener(new a2(i15));
        this.V1.setOnCheckedChangeListener(new a2(i16));
        this.W1.setOnCheckedChangeListener(new a2(i14));
        this.X1.setOnCheckedChangeListener(new a2(i17));
        this.Z1.setOnCheckedChangeListener(new a2(i19));
        this.P1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: ub.b2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SettingsActivity f20158b;

            {
                this.f20158b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                int i22 = i13;
                SettingsActivity settingsActivity = this.f20158b;
                switch (i22) {
                    case 0:
                        int i23 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hd_posters", z10);
                        App.I = z10;
                        be.d.makeToastLong(settingsActivity, "Please Restart to see the Change", false);
                        break;
                    case 1:
                        int i24 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hide_continue", z10);
                        settingsActivity.W = true;
                        break;
                    case 2:
                        int i25 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_show_hindi_dubbed", z10);
                        if (!z10) {
                            o1.a.j(App.getInstance().f11574v, "hindi_include_english", true);
                            break;
                        } else {
                            FragmentManager fragmentManager = settingsActivity.getFragmentManager();
                            kc.d dVarNewInstance = kc.d.newInstance(settingsActivity, false);
                            dVarNewInstance.setTitle("Include English Links");
                            dVarNewInstance.setMessage("Do you want to get English links too or only Hindi links? This is only for Movies");
                            dVarNewInstance.setButton1("INCLUDE ENGLISH", new q0(9));
                            dVarNewInstance.setButton2("ONLY HINDI", new q0(10));
                            try {
                                dVarNewInstance.show(fragmentManager, "");
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    default:
                        int i26 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        App.getInstance().f11574v.edit().putBoolean("pref_show_adult_zone", z10).apply();
                        if (App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                            Toast.makeText(settingsActivity.getBaseContext(), "Please restart App to see the change", 1).show();
                            break;
                        }
                        break;
                }
            }
        });
        this.f11812a2.setOnCheckedChangeListener(new a2(i20));
        this.f11815b2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: ub.b2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SettingsActivity f20158b;

            {
                this.f20158b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                int i22 = i12;
                SettingsActivity settingsActivity = this.f20158b;
                switch (i22) {
                    case 0:
                        int i23 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hd_posters", z10);
                        App.I = z10;
                        be.d.makeToastLong(settingsActivity, "Please Restart to see the Change", false);
                        break;
                    case 1:
                        int i24 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hide_continue", z10);
                        settingsActivity.W = true;
                        break;
                    case 2:
                        int i25 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_show_hindi_dubbed", z10);
                        if (!z10) {
                            o1.a.j(App.getInstance().f11574v, "hindi_include_english", true);
                            break;
                        } else {
                            FragmentManager fragmentManager = settingsActivity.getFragmentManager();
                            kc.d dVarNewInstance = kc.d.newInstance(settingsActivity, false);
                            dVarNewInstance.setTitle("Include English Links");
                            dVarNewInstance.setMessage("Do you want to get English links too or only Hindi links? This is only for Movies");
                            dVarNewInstance.setButton1("INCLUDE ENGLISH", new q0(9));
                            dVarNewInstance.setButton2("ONLY HINDI", new q0(10));
                            try {
                                dVarNewInstance.show(fragmentManager, "");
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    default:
                        int i26 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        App.getInstance().f11574v.edit().putBoolean("pref_show_adult_zone", z10).apply();
                        if (App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                            Toast.makeText(settingsActivity.getBaseContext(), "Please restart App to see the change", 1).show();
                            break;
                        }
                        break;
                }
            }
        });
        this.U1.setOnCheckedChangeListener(new a2(i21));
        this.R1.setOnCheckedChangeListener(new a2(10));
        this.Q1.setOnCheckedChangeListener(new a2(11));
        this.S1.setOnCheckedChangeListener(new a2(12));
        o1.a.l(this, 13, this.f11865u1);
        this.f11818c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: ub.b2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SettingsActivity f20158b;

            {
                this.f20158b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                int i22 = i15;
                SettingsActivity settingsActivity = this.f20158b;
                switch (i22) {
                    case 0:
                        int i23 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hd_posters", z10);
                        App.I = z10;
                        be.d.makeToastLong(settingsActivity, "Please Restart to see the Change", false);
                        break;
                    case 1:
                        int i24 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_hide_continue", z10);
                        settingsActivity.W = true;
                        break;
                    case 2:
                        int i25 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        o1.a.j(App.getInstance().f11574v, "pref_show_hindi_dubbed", z10);
                        if (!z10) {
                            o1.a.j(App.getInstance().f11574v, "hindi_include_english", true);
                            break;
                        } else {
                            FragmentManager fragmentManager = settingsActivity.getFragmentManager();
                            kc.d dVarNewInstance = kc.d.newInstance(settingsActivity, false);
                            dVarNewInstance.setTitle("Include English Links");
                            dVarNewInstance.setMessage("Do you want to get English links too or only Hindi links? This is only for Movies");
                            dVarNewInstance.setButton1("INCLUDE ENGLISH", new q0(9));
                            dVarNewInstance.setButton2("ONLY HINDI", new q0(10));
                            try {
                                dVarNewInstance.show(fragmentManager, "");
                                break;
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    default:
                        int i26 = SettingsActivity.f11809o2;
                        settingsActivity.getClass();
                        App.getInstance().f11574v.edit().putBoolean("pref_show_adult_zone", z10).apply();
                        if (App.getInstance().f11574v.getInt("pref_tv_layout", 0) != 0) {
                            Toast.makeText(settingsActivity.getBaseContext(), "Please restart App to see the change", 1).show();
                            break;
                        }
                        break;
                }
            }
        });
        o1.a.l(this, 14, this.f11875z1);
        o1.a.l(this, 15, this.L1);
        o1.a.l(this, 17, this.E1);
        o1.a.l(this, 18, this.f11869w1);
        o1.a.l(this, 19, this.B1);
        o1.a.l(this, 20, this.C1);
        o1.a.l(this, 21, this.f11841k1);
        o1.a.l(this, 22, this.F1);
        o1.a.l(this, 23, this.f11871x1);
        o1.a.l(this, 24, this.f11867v1);
        o1.a.l(this, 25, this.G1);
        o1.a.l(this, 26, this.H1);
        this.f11826f1.setOnClickListener(new z1(this, 28));
        this.f11826f1.setOnLongClickListener(new View.OnLongClickListener() { // from class: ub.c2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                int i22 = SettingsActivity.f11809o2;
                SettingsActivity settingsActivity = this.f20163b;
                settingsActivity.getClass();
                if (App.getInstance().f11574v.getBoolean("pref_adult_zone_pin_set", false)) {
                    Toast.makeText(settingsActivity.getBaseContext(), App.getInstance().f11574v.getString("pref_adult_zone_pin", "N/A") + "", 1).show();
                }
                return true;
            }
        });
        o1.a.l(this, 29, this.A1);
        this.f11861s1.setOnClickListener(new d2(this, i10));
        this.f11823e1.setOnClickListener(new d2(this, i13));
        this.f11820d1.setOnClickListener(new d2(this, i12));
        this.f11817c1.setOnClickListener(new d2(this, i15));
        f();
        try {
            this.f11821d2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            ArrayList<String> arrayList2 = App.B;
            this.f11846m0.setText("Version: " + this.f11821d2);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        g();
        this.f11873y1.requestFocus();
        if (RealDebridCommon.f12051p) {
            this.f11831h0.setText("Account Linked");
            this.f11819d0.setVisibility(0);
            this.f11822e0.setVisibility(0);
        }
        if (AllDebridCommon.f12043n) {
            this.f11874z0.setVisibility(0);
            this.f11870x0.setVisibility(0);
            this.f11872y0.setText("Account Linked");
            this.f11874z0.setText("User: " + App.getInstance().f11574v.getString("ALL_DEBRID_USERNAME", ""));
            String string = App.getInstance().f11574v.getString("ALL_DEBRID_PREMIUM_UNTIL", "");
            TextView textView = this.f11870x0;
            StringBuilder sb2 = new StringBuilder("IsPremium: ");
            StringBuilder sb3 = App.getInstance().f11574v.getBoolean("ALL_DEBRID_IS_PREMIUM", false) ? new StringBuilder("true, Valid Until: ") : new StringBuilder("false, Valid Until: ");
            sb3.append(string);
            sb2.append(sb3.toString());
            textView.setText(sb2.toString());
        }
        if (App.K) {
            return;
        }
        FrameLayout frameLayout = this.X0;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.Y0;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        FrameLayout frameLayout3 = this.W0;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(8);
        }
        FrameLayout frameLayout4 = this.V0;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        i();
        super.onResume();
        f();
        TextView textView = this.f11831h0;
        if (textView != null && RealDebridCommon.f12051p) {
            textView.setText("Account linked");
            this.f11819d0.setVisibility(0);
            this.f11822e0.setVisibility(0);
            this.f11819d0.setText("User: " + App.getInstance().f11574v.getString("REAL_DEBRID_USERNAME", "reconnect to see this info"));
            this.f11822e0.setText("Status: " + App.getInstance().f11574v.getString("REAL_DEBRID_A_TYPE", "reconnect to see this info") + ", Valid until " + App.getInstance().f11574v.getString("REAL_DEBRID_EXPIRATION", "N/A"));
        }
        if (this.A0 != null && PremiumizeCommon.f12045b) {
            String string = App.getInstance().f11574v.getString("PREM_PREMIUM_UNTIL", null);
            if (string != null && string.length() > 5) {
                this.f11825f0.setText("Valid until: ".concat(string));
                this.f11825f0.setVisibility(0);
            }
            this.A0.setText("Account linked");
        }
        if (AllDebridCommon.f12043n) {
            this.f11874z0.setVisibility(0);
            this.f11870x0.setVisibility(0);
            this.f11872y0.setText("Account Linked");
            this.f11874z0.setText("User: " + App.getInstance().f11574v.getString("ALL_DEBRID_USERNAME", ""));
            String string2 = App.getInstance().f11574v.getString("ALL_DEBRID_PREMIUM_UNTIL", "");
            TextView textView2 = this.f11870x0;
            StringBuilder sb2 = new StringBuilder("IsPremium: ");
            StringBuilder sb3 = App.getInstance().f11574v.getBoolean("ALL_DEBRID_IS_PREMIUM", false) ? new StringBuilder("true, Valid Until: ") : new StringBuilder("false, Valid Until: ");
            sb3.append(string2);
            sb2.append(sb3.toString());
            textView2.setText(sb2.toString());
        }
    }

    public void showReleaseNoteDialog() {
        Iterator<String> it = App.B.iterator();
        String strB = "";
        while (it.hasNext()) {
            strB = c.B(strB, it.next());
        }
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("v" + this.f11821d2 + " Release Note");
        dVarNewInstance.setMessage(strB);
        dVarNewInstance.setMessageTextSize(16.0f);
        dVarNewInstance.setButton1("OK", new q0(8));
        try {
            dVarNewInstance.setCancelable(true);
            try {
                dVarNewInstance.show(getFragmentManager(), "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
