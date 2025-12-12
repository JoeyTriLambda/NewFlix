package flix.com.vision.filepickerlibrary;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.devpaul.materiallibrary.views.MaterialFloatingActionButton;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.enums.MimeType;
import flix.com.vision.filepickerlibrary.enums.Request;
import flix.com.vision.filepickerlibrary.enums.Scope;
import flix.com.vision.filepickerlibrary.enums.ThemeType;
import java.io.File;

/* loaded from: classes2.dex */
public class FilePickerActivity extends ListActivity implements cd.c {
    public static final /* synthetic */ int I = 0;
    public String A;
    public Request B;
    public Intent C;
    public int D;
    public int E;
    public int F;
    public int G;
    public View H;

    /* renamed from: b, reason: collision with root package name */
    public File[] f12281b;

    /* renamed from: m, reason: collision with root package name */
    public ListView f12282m;

    /* renamed from: n, reason: collision with root package name */
    public Button f12283n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f12284o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f12285p;

    /* renamed from: q, reason: collision with root package name */
    public MaterialFloatingActionButton f12286q;

    /* renamed from: r, reason: collision with root package name */
    public Animation f12287r;

    /* renamed from: s, reason: collision with root package name */
    public Animation f12288s;

    /* renamed from: t, reason: collision with root package name */
    public File f12289t;

    /* renamed from: u, reason: collision with root package name */
    public File f12290u;

    /* renamed from: v, reason: collision with root package name */
    public dd.a f12291v;

    /* renamed from: w, reason: collision with root package name */
    public File f12292w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12293x;

    /* renamed from: y, reason: collision with root package name */
    public Scope f12294y;

    /* renamed from: z, reason: collision with root package name */
    public ThemeType f12295z;

    public class b implements MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            FilePickerActivity filePickerActivity = FilePickerActivity.this;
            filePickerActivity.setResult(0);
            filePickerActivity.finish();
        }
    }

    public class c implements MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            l0.a.requestPermissions(FilePickerActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 107);
        }
    }

    public class d extends AsyncTask<File, Void, File[]> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f12299a;

        /* renamed from: b, reason: collision with root package name */
        public ProgressDialog f12300b;

        /* renamed from: c, reason: collision with root package name */
        public File f12301c;

        public d(Context context) {
            this.f12299a = context;
        }

        public boolean directoryExists(File[] fileArr) {
            for (File file : fileArr) {
                if (file.isDirectory()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(this.f12299a);
            this.f12300b = progressDialog;
            FilePickerActivity filePickerActivity = FilePickerActivity.this;
            progressDialog.setMessage(filePickerActivity.getString(R.string.file_picker_progress_dialog_loading));
            this.f12300b.setCancelable(false);
            this.f12300b.show();
            int i10 = FilePickerActivity.I;
            filePickerActivity.a();
            filePickerActivity.setListAdapter(null);
            super.onPreExecute();
        }

        @Override // android.os.AsyncTask
        public File[] doInBackground(File... fileArr) {
            File file = fileArr[0];
            this.f12301c = file;
            return file.listFiles();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(File[] fileArr) {
            FilePickerActivity filePickerActivity = FilePickerActivity.this;
            filePickerActivity.f12281b = fileArr;
            if (this.f12301c.getPath().equalsIgnoreCase(Environment.getExternalStorageDirectory().getPath())) {
                filePickerActivity.f12285p.setText(R.string.file_picker_default_directory_title);
            } else {
                filePickerActivity.f12285p.setText(this.f12301c.getName());
            }
            filePickerActivity.f12290u = this.f12301c.getParentFile();
            File file = this.f12301c;
            filePickerActivity.f12289t = file;
            if (file.listFiles() != null) {
                if (this.f12301c.listFiles().length > 0 && directoryExists(filePickerActivity.f12281b) && filePickerActivity.f12282m.getHeaderViewsCount() == 0) {
                    filePickerActivity.f12282m.addHeaderView(filePickerActivity.H);
                } else if ((this.f12301c.listFiles().length == 0 || !directoryExists(filePickerActivity.f12281b)) && filePickerActivity.f12282m.getHeaderViewsCount() == 1) {
                    filePickerActivity.f12282m.removeHeaderView(filePickerActivity.H);
                }
            }
            if (filePickerActivity.f12281b != null) {
                filePickerActivity.f12291v = new dd.a(filePickerActivity, filePickerActivity.f12281b, filePickerActivity.f12294y);
                filePickerActivity.setListAdapter(filePickerActivity.f12291v);
            }
            if (this.f12300b.isShowing()) {
                this.f12300b.dismiss();
            }
            super.onPostExecute((d) filePickerActivity.f12281b);
        }
    }

    public final void a() {
        if (this.f12293x) {
            this.f12284o.clearAnimation();
            this.f12284o.startAnimation(this.f12288s);
            this.f12284o.setVisibility(4);
            this.f12293x = false;
        }
    }

    public final void b() throws Exception {
        this.f12289t = new File(Environment.getExternalStorageDirectory().getPath());
        this.f12292w = new File(this.f12289t.getPath());
        this.f12290u = this.f12289t.getParentFile();
        if (this.f12289t.isDirectory()) {
            new d(this).execute(this.f12289t);
            return;
        }
        try {
            throw new Exception(getString(R.string.file_picker_directory_error));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f12293x) {
            this.f12282m.requestFocus();
            a();
        } else if (this.f12290u != null && !this.f12289t.getPath().equals(Environment.getExternalStorageDirectory().getPath())) {
            new d(this).execute(this.f12290u);
        } else {
            setResult(0);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Exception {
        super.onCreate(bundle);
        ThemeType themeType = (ThemeType) getIntent().getSerializableExtra("themeType");
        this.f12295z = themeType;
        if (themeType == null) {
            this.f12295z = ThemeType.ACTIVITY;
        }
        setThemeType(this.f12295z);
        this.f12293x = false;
        try {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e10) {
            e10.printStackTrace();
        }
        Object obj = getIntent().getExtras().get("mimeType");
        if (obj instanceof String) {
            this.A = (String) obj;
        } else if (obj instanceof MimeType) {
            this.A = ((MimeType) obj).getMimeType();
        } else {
            this.A = null;
        }
        this.f12287r = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        this.f12288s = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Intent intent = getIntent();
        Scope scope = (Scope) intent.getSerializableExtra("scope");
        this.f12294y = scope;
        if (scope == null) {
            this.f12294y = Scope.ALL;
        }
        this.B = (Request) intent.getSerializableExtra("request");
        this.D = intent.getIntExtra("intentExtraColorId", android.R.color.holo_blue_light);
        this.F = intent.getIntExtra("intentExtraDrawableId", -1);
        this.E = intent.getIntExtra("intentExtraFabColorId", -1);
        setContentView(R.layout.file_picker_activity_layout);
        ListView listView = (ListView) findViewById(android.R.id.list);
        this.f12282m = listView;
        listView.requestFocus();
        this.f12282m.setOnScrollListener(new a());
        View viewInflate = getLayoutInflater().inflate(R.layout.file_list_header_view, (ViewGroup) null);
        this.H = viewInflate;
        viewInflate.setFocusable(false);
        this.H.setClickable(false);
        this.H.setOnClickListener(null);
        this.H.setActivated(false);
        this.f12285p = (TextView) findViewById(R.id.file_directory_title);
        MaterialFloatingActionButton materialFloatingActionButton = (MaterialFloatingActionButton) findViewById(R.id.file_picker_add_button);
        this.f12286q = materialFloatingActionButton;
        materialFloatingActionButton.setOnClickListener(new cd.a(this));
        if (this.E != -1) {
            this.f12286q.setButtonColor(getResources().getColor(this.E));
        }
        ((Button) findViewById(R.id.select_button)).setOnClickListener(new flix.com.vision.filepickerlibrary.c(this));
        Button button = (Button) findViewById(R.id.open_button);
        this.f12283n = button;
        button.setOnClickListener(new flix.com.vision.filepickerlibrary.d(this));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_container);
        this.f12284o = linearLayout;
        linearLayout.setVisibility(4);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.header_container);
        int i10 = this.D;
        int i11 = this.F;
        if (i11 == -1) {
            try {
                relativeLayout.setBackgroundColor(getResources().getColor(i10));
            } catch (Resources.NotFoundException e11) {
                e11.printStackTrace();
            }
        } else {
            try {
                relativeLayout.setBackgroundDrawable(getResources().getDrawable(i11));
            } catch (Resources.NotFoundException e12) {
                e12.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT != 23) {
            b();
            return;
        }
        if (m0.a.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            b();
        } else if (l0.a.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            new MaterialDialog.c(this).title(R.string.file_picker_permission_rationale_dialog_title).content(R.string.file_picker_permission_rationale_dialog_content).positiveText(R.string.file_picker_ok).negativeText(R.string.file_picker_cancel).onPositive(new c()).onNegative(new b()).show();
        } else {
            l0.a.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 107);
        }
    }

    @Override // android.app.ListActivity
    public void onListItemClick(ListView listView, View view, int i10, long j10) {
        super.onListItemClick(listView, view, i10, j10);
        if (listView.getHeaderViewsCount() != 1) {
            i10++;
        }
        if (i10 > 0) {
            this.f12292w = this.f12281b[i10 - 1];
        }
        if (this.f12291v.getSelectedPosition() == i10) {
            a();
            this.f12291v.setSelectedPosition(-1);
            return;
        }
        this.f12291v.setSelectedPosition(i10 - 1);
        if (!this.f12293x) {
            this.f12284o.clearAnimation();
            this.f12284o.startAnimation(this.f12287r);
            this.f12284o.setVisibility(0);
            this.f12293x = true;
        }
        this.f12283n.requestFocus();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            setResult(0);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) throws Exception {
        if (i10 != 107) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0) {
            b();
        } else {
            setResult(0);
            finish();
        }
    }

    @Override // cd.c
    public void onReturnFileName(String str) {
        if (str.equalsIgnoreCase("") || str.isEmpty()) {
            str = null;
        }
        if (str == null || this.f12289t == null) {
            return;
        }
        File file = new File(this.f12289t.getPath() + "//" + str);
        if (!file.exists() ? file.mkdirs() : false) {
            new d(this).execute(this.f12289t);
        }
    }

    public void setThemeType(ThemeType themeType) {
        if (themeType == ThemeType.ACTIVITY) {
            setTheme(android.R.style.Theme.Holo.Light);
        } else if (themeType == ThemeType.DIALOG) {
            setTheme(android.R.style.Theme.Holo.Light.Dialog);
        } else if (themeType == ThemeType.DIALOG_NO_ACTION_BAR) {
            setTheme(android.R.style.Theme.Holo.Light.Dialog.NoActionBar);
        }
    }

    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            FilePickerActivity filePickerActivity = FilePickerActivity.this;
            if (!filePickerActivity.f12293x) {
                filePickerActivity.G = i10;
                return;
            }
            if (Math.abs(i10 - filePickerActivity.G) >= 3) {
                filePickerActivity.a();
                filePickerActivity.f12291v.setSelectedPosition(-1);
                filePickerActivity.G = i10;
            } else if (i10 > filePickerActivity.f12291v.getSelectedPosition()) {
                filePickerActivity.a();
                filePickerActivity.f12291v.setSelectedPosition(-1);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }
}
