package flix.com.vision.filepickerlibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dd.b;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.enums.MimeType;
import flix.com.vision.filepickerlibrary.enums.Request;
import flix.com.vision.filepickerlibrary.enums.Scope;
import java.io.File;
import r.j;

/* loaded from: classes2.dex */
public class FilePicker extends j implements cd.c {

    /* renamed from: d0, reason: collision with root package name */
    public static final OvershootInterpolator f12267d0 = new OvershootInterpolator();
    public Toolbar K;
    public FloatingActionButton L;
    public boolean M;
    public File[] N;
    public RecyclerView O;
    public LinearLayout P;
    public Animation Q;
    public Animation R;
    public File S;
    public File T;
    public dd.b U;
    public File V;
    public boolean W;
    public final a X = new a();
    public Scope Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public Request f12268a0;

    /* renamed from: b0, reason: collision with root package name */
    public Intent f12269b0;

    /* renamed from: c0, reason: collision with root package name */
    public LinearLayoutManager f12270c0;

    public class a extends b.d {
        public a() {
        }

        @Override // dd.b.d
        public void onItemClicked(View view, int i10) {
            FilePicker filePicker = FilePicker.this;
            if (i10 > 0) {
                File[] fileArr = filePicker.N;
                if (i10 <= fileArr.length - 1) {
                    filePicker.V = fileArr[i10];
                }
            }
            if (filePicker.U.getSelectedPosition() == i10) {
                FilePicker.d(filePicker);
                filePicker.U.setSelectedPosition(-1);
                return;
            }
            filePicker.U.setSelectedPosition(i10);
            if (filePicker.W) {
                return;
            }
            filePicker.P.clearAnimation();
            filePicker.P.startAnimation(filePicker.Q);
            filePicker.P.setVisibility(0);
            filePicker.W = true;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            cd.b.newInstance().show(FilePicker.this.getFragmentManager(), "NameDialog");
        }
    }

    public class c extends RecyclerView.p {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            FilePicker filePicker = FilePicker.this;
            int iFindFirstVisibleItemPosition = filePicker.f12270c0.findFirstVisibleItemPosition();
            if (Math.abs(i11) >= 5) {
                if (i11 > 0) {
                    filePicker.toggleButton(false);
                } else if (i11 < 0) {
                    filePicker.toggleButton(true);
                }
                if (filePicker.W) {
                    FilePicker.d(filePicker);
                    filePicker.U.setSelectedPosition(-1);
                    filePicker.getClass();
                } else if (iFindFirstVisibleItemPosition > filePicker.U.getSelectedPosition()) {
                    FilePicker.d(filePicker);
                    filePicker.U.setSelectedPosition(-1);
                }
            } else {
                filePicker.getClass();
            }
            super.onScrolled(recyclerView, i10, i11);
        }
    }

    public class d extends MaterialDialog.d {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.d
        public void onNegative(MaterialDialog materialDialog) {
            FilePicker filePicker = FilePicker.this;
            filePicker.setResult(0);
            filePicker.finish();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.d
        public void onPositive(MaterialDialog materialDialog) {
            l0.a.requestPermissions(FilePicker.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
        }
    }

    public class e implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f12275b;

        public e(boolean z10) {
            this.f12275b = z10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            FilePicker filePicker = FilePicker.this;
            ViewTreeObserver viewTreeObserver = filePicker.L.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            filePicker.toggleButton(this.f12275b);
            return true;
        }
    }

    public class f extends AsyncTask<File, Void, File[]> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f12277a;

        /* renamed from: b, reason: collision with root package name */
        public ProgressDialog f12278b;

        /* renamed from: c, reason: collision with root package name */
        public File f12279c;

        public f(Context context) {
            this.f12277a = context;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(this.f12277a);
            this.f12278b = progressDialog;
            FilePicker filePicker = FilePicker.this;
            progressDialog.setMessage(filePicker.getString(R.string.file_picker_progress_dialog_loading));
            this.f12278b.setCancelable(false);
            this.f12278b.show();
            FilePicker.d(filePicker);
            filePicker.O.setAdapter(null);
            super.onPreExecute();
        }

        @Override // android.os.AsyncTask
        public File[] doInBackground(File... fileArr) {
            File file = fileArr[0];
            this.f12279c = file;
            return file.listFiles();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(File[] fileArr) {
            FilePicker filePicker = FilePicker.this;
            filePicker.N = fileArr;
            if (this.f12279c.getPath().equalsIgnoreCase(Environment.getExternalStorageDirectory().getPath())) {
                filePicker.K.setTitle(filePicker.getString(R.string.file_picker_default_directory_title));
            } else {
                filePicker.K.setTitle(this.f12279c.getName());
            }
            filePicker.T = this.f12279c.getParentFile();
            filePicker.S = this.f12279c;
            File[] fileArr2 = filePicker.N;
            if (fileArr2 != null) {
                dd.b bVar = new dd.b(filePicker, fileArr2, filePicker.Y, filePicker.X);
                filePicker.U = bVar;
                filePicker.O.setAdapter(bVar);
            }
            if (!filePicker.M) {
                filePicker.toggleButton(true);
            }
            if (this.f12278b.isShowing()) {
                this.f12278b.dismiss();
            }
            super.onPostExecute((f) filePicker.N);
        }
    }

    public static void d(FilePicker filePicker) {
        if (filePicker.W) {
            filePicker.P.clearAnimation();
            filePicker.P.startAnimation(filePicker.R);
            filePicker.P.setVisibility(4);
            filePicker.W = false;
        }
    }

    public final void e() throws Exception {
        this.S = new File(Environment.getExternalStorageDirectory().getPath());
        this.V = new File(this.S.getPath());
        this.T = this.S.getParentFile();
        if (this.S.isDirectory()) {
            new f(this).execute(this.S);
            return;
        }
        try {
            throw new Exception(getString(R.string.file_picker_directory_error));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.T != null && !this.S.getPath().equals(Environment.getExternalStorageDirectory().getPath())) {
            new f(this).execute(this.T);
        } else {
            setResult(0);
            finish();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) throws Exception {
        super.onCreate(bundle);
        setContentView(R.layout.material_file_picker_activity_layout);
        this.O = (RecyclerView) findViewById(R.id.file_picker_recycler_view);
        this.K = (Toolbar) findViewById(R.id.file_picker_base_toolbar);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.file_picker_floating_action_button);
        this.L = floatingActionButton;
        floatingActionButton.setOnClickListener(new b());
        this.M = true;
        this.W = false;
        Object obj = getIntent().getExtras().get("mimeType");
        if (obj instanceof String) {
            this.Z = (String) obj;
        } else if (obj instanceof MimeType) {
            this.Z = ((MimeType) obj).getMimeType();
        } else {
            this.Z = null;
        }
        this.Q = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        this.R = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        AnimationUtils.loadAnimation(this, R.anim.scale_in);
        AnimationUtils.loadAnimation(this, R.anim.scale_out);
        Intent intent = getIntent();
        Scope scope = (Scope) intent.getSerializableExtra("scope");
        this.Y = scope;
        if (scope == null) {
            this.Y = Scope.ALL;
        }
        this.f12268a0 = (Request) intent.getSerializableExtra("request");
        intent.getIntExtra("intentExtraColorId", android.R.color.holo_blue_light);
        intent.getIntExtra("intentExtraDrawableId", -1);
        intent.getIntExtra("intentExtraFabColorId", -1);
        this.f12270c0 = new LinearLayoutManager(this);
        this.O.setItemAnimator(new androidx.recyclerview.widget.c());
        this.O.setLayoutManager(this.f12270c0);
        this.O.setHasFixedSize(true);
        dd.b bVar = new dd.b(this, new File[0], this.Y, this.X);
        this.U = bVar;
        this.O.setAdapter(bVar);
        this.O.addOnScrollListener(new c());
        this.P = (LinearLayout) findViewById(R.id.button_container);
        ((Button) findViewById(R.id.select_button)).setOnClickListener(new flix.com.vision.filepickerlibrary.a(this));
        ((Button) findViewById(R.id.open_button)).setOnClickListener(new flix.com.vision.filepickerlibrary.b(this));
        this.P.setVisibility(4);
        if (Build.VERSION.SDK_INT != 23) {
            e();
        } else if (m0.a.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            if (l0.a.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                new MaterialDialog.c(this).title(R.string.file_picker_permission_rationale_dialog_title).content(R.string.file_picker_permission_rationale_dialog_content).positiveText(R.string.file_picker_ok).negativeText(R.string.file_picker_cancel).callback(new d()).show();
            } else {
                l0.a.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            setResult(0);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) throws Exception {
        if (i10 != 101) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0) {
            e();
        } else {
            setResult(0);
            finish();
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // cd.c
    public void onReturnFileName(String str) {
        if (str.equalsIgnoreCase("") || str.isEmpty()) {
            str = null;
        }
        if (str == null || this.S == null) {
            return;
        }
        File file = new File(this.S.getPath() + "//" + str);
        if (!file.exists() ? file.mkdirs() : false) {
            new f(this).execute(this.S);
        }
    }

    public void toggleButton(boolean z10) {
        if (this.M != z10) {
            this.M = z10;
            int height = this.L.getHeight();
            if (height == 0) {
                ViewTreeObserver viewTreeObserver = this.L.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(new e(z10));
                    return;
                }
            }
            if (z10) {
                height = 0;
            }
            this.L.animate().setInterpolator(f12267d0).setDuration(350L).translationY(height);
            this.L.setClickable(z10);
        }
    }
}
