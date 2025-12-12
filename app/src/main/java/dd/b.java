package dd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.enums.Scope;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/* compiled from: FileRecyclerViewAdapter.java */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.Adapter {

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f10988d;

    /* renamed from: f, reason: collision with root package name */
    public final float f10990f;

    /* renamed from: g, reason: collision with root package name */
    public final Scope f10991g;

    /* renamed from: h, reason: collision with root package name */
    public final File[] f10992h;

    /* renamed from: i, reason: collision with root package name */
    public final d f10993i;

    /* renamed from: k, reason: collision with root package name */
    public final View f10995k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f10996l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f10997m;

    /* renamed from: j, reason: collision with root package name */
    public final a f10994j = new a();

    /* renamed from: e, reason: collision with root package name */
    public int f10989e = -1;

    /* compiled from: FileRecyclerViewAdapter.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = b.this.f10993i;
            if (dVar != null) {
                dVar.onItemClicked(view, ((Integer) view.getTag(R.id.POSITION_KEY)).intValue());
            }
        }
    }

    /* compiled from: FileRecyclerViewAdapter.java */
    /* renamed from: dd.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC0131b implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10999b;

        public ViewOnClickListenerC0131b(int i10) {
            this.f10999b = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            TextView textView = (TextView) bVar.f10995k.findViewById(R.id.file_info_size);
            View view2 = bVar.f10995k;
            TextView textView2 = (TextView) view2.findViewById(R.id.file_info_date_created);
            TextView textView3 = (TextView) view2.findViewById(R.id.file_info_path);
            ArrayList arrayList = bVar.f10996l;
            int i10 = this.f10999b;
            File file = (File) arrayList.get(i10);
            boolean zIsDirectory = file.isDirectory();
            Context context = bVar.f10997m;
            if (zIsDirectory) {
                new g(textView, file, bVar.f10997m.getString(R.string.file_picker_adapter_size_string)).execute(new Void[0]);
            } else {
                textView.setText(String.format(context.getString(R.string.file_picker_adapter_size_string), Long.valueOf(file.length())));
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(file.lastModified());
            textView2.setText(String.format(context.getString(R.string.file_picker_adapter_last_modified_string), DateFormat.getDateInstance().format(calendar.getTime())));
            textView3.setText(String.format(context.getString(R.string.file_picker_adapter_file_path_string), file.getAbsolutePath()));
            new MaterialDialog.c(view.getContext()).title(String.format(context.getString(R.string.file_picker_file_info_dialog_file_path), ((File) arrayList.get(i10)).getName())).customView(view2, true).theme(Theme.LIGHT).show();
        }
    }

    /* compiled from: FileRecyclerViewAdapter.java */
    public class c extends AsyncTask<File, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ImageView> f11001a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap.CompressFormat f11002b;

        public c(b bVar, ImageView imageView, Bitmap.CompressFormat compressFormat) {
            imageView.setBackgroundDrawable(imageView.getContext().getResources().getDrawable(R.drawable.fplib_rectangle));
            this.f11001a = new WeakReference<>(imageView);
            this.f11002b = compressFormat;
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(File... fileArr) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(fileArr[0].getAbsolutePath());
            if (bitmapDecodeFile != null) {
                return b.decodeSampledBitmapFromByteArray(b.encodeBitmapToArray(bitmapDecodeFile, this.f11002b), 54, 54);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            ImageView imageView;
            WeakReference<ImageView> weakReference = this.f11001a;
            if (weakReference.get() == null || bitmap == null || (imageView = weakReference.get()) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    /* compiled from: FileRecyclerViewAdapter.java */
    public static abstract class d {
        public abstract void onItemClicked(View view, int i10);
    }

    /* compiled from: FileRecyclerViewAdapter.java */
    public static class e extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final ImageView f11003u;

        /* renamed from: v, reason: collision with root package name */
        public final TextView f11004v;

        public e(View view) {
            super(view);
            this.f11003u = (ImageView) view.findViewById(R.id.file_item_image_view);
            this.f11004v = (TextView) view.findViewById(R.id.file_item_file_name);
        }
    }

    /* compiled from: FileRecyclerViewAdapter.java */
    public static class f extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final TextView f11005u;

        /* renamed from: v, reason: collision with root package name */
        public final TextView f11006v;

        /* renamed from: w, reason: collision with root package name */
        public final ImageView f11007w;

        /* renamed from: x, reason: collision with root package name */
        public final ImageView f11008x;

        public f(View view) {
            super(view);
            this.f11006v = (TextView) view.findViewById(R.id.file_item_file_info);
            this.f11005u = (TextView) view.findViewById(R.id.file_item_file_name);
            this.f11007w = (ImageView) view.findViewById(R.id.file_item_image_view);
            this.f11008x = (ImageView) view.findViewById(R.id.file_item_file_info_button);
        }
    }

    /* compiled from: FileRecyclerViewAdapter.java */
    public class g extends AsyncTask<Void, Void, Long> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TextView> f11009a;

        /* renamed from: b, reason: collision with root package name */
        public final File f11010b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11011c;

        public g(TextView textView, File file, String str) {
            this.f11010b = file;
            this.f11009a = new WeakReference<>(textView);
            this.f11011c = str;
        }

        public static long a(File file) {
            long j10;
            long length;
            int i10 = 0;
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    j10 = i10;
                    length = a(file2);
                } else {
                    j10 = i10;
                    length = file2.length();
                }
                i10 = (int) (length + j10);
            }
            return i10;
        }

        @Override // android.os.AsyncTask
        public Long doInBackground(Void... voidArr) {
            return Long.valueOf(a(this.f11010b));
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Long l10) {
            TextView textView = this.f11009a.get();
            if (textView != null) {
                textView.setText(String.format(this.f11011c, l10));
            }
        }
    }

    public b(Context context, File[] fileArr, Scope scope, d dVar) {
        this.f10997m = context;
        this.f10992h = fileArr;
        this.f10990f = context.getResources().getDimension(R.dimen.file_picker_lib_default_icon_padding);
        this.f10991g = scope;
        this.f10988d = context.getResources().getDrawable(R.drawable.fplib_ic_folder);
        this.f10996l = new ArrayList(Arrays.asList(fileArr));
        if (scope == Scope.DIRECTORIES) {
            for (int i10 = 0; i10 < this.f10996l.size(); i10++) {
                if (a(((File) this.f10996l.get(i10)).getPath()) != null) {
                    this.f10996l.remove(i10);
                }
            }
        }
        this.f10993i = dVar;
        this.f10995k = LayoutInflater.from(context).inflate(R.layout.file_info_layout, (ViewGroup) null);
    }

    public static String a(String str) {
        if (str.indexOf("?") > -1) {
            str = str.substring(0, str.indexOf("?"));
        }
        if (str.lastIndexOf(".") == -1) {
            return null;
        }
        String strSubstring = str.substring(str.lastIndexOf("."));
        if (strSubstring.indexOf("%") > -1) {
            strSubstring = strSubstring.substring(0, strSubstring.indexOf("%"));
        }
        if (strSubstring.indexOf("/") > -1) {
            strSubstring = strSubstring.substring(0, strSubstring.indexOf("/"));
        }
        return strSubstring.toLowerCase();
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int iRound = Math.round(i12 / i11);
        int iRound2 = Math.round(i13 / i10);
        return iRound < iRound2 ? iRound : iRound2;
    }

    public static Bitmap decodeSampledBitmapFromByteArray(byte[] bArr, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static byte[] encodeBitmapToArray(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final LayerDrawable b(int i10) {
        Context context = this.f10997m;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{context.getResources().getDrawable(R.drawable.fplib_circle), context.getResources().getDrawable(i10)});
        int i11 = (int) this.f10990f;
        layerDrawable.setLayerInset(1, i11, i11, i11, i11);
        return layerDrawable;
    }

    public boolean directoryExists(File[] fileArr) {
        for (File file : fileArr) {
            if (file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public File getItem(int i10) {
        return (File) this.f10996l.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10996l.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        ArrayList arrayList = this.f10996l;
        int size = arrayList.size();
        File[] fileArr = this.f10992h;
        if (size > 0 && directoryExists(fileArr) && i10 == 0) {
            return 123;
        }
        if (arrayList.size() == 0) {
            return 124;
        }
        directoryExists(fileArr);
        return 124;
    }

    public int getSelectedPosition() {
        return this.f10989e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.z zVar, int i10) {
        File item = getItem(i10);
        boolean z10 = zVar instanceof f;
        Context context = this.f10997m;
        if (!z10) {
            if (zVar instanceof e) {
                e eVar = (e) zVar;
                eVar.f11004v.setText("Folders");
                eVar.f11003u.setBackgroundColor(context.getResources().getColor(android.R.color.background_light));
                return;
            }
            return;
        }
        f fVar = (f) zVar;
        fVar.f11005u.setText(item.getName());
        Integer numValueOf = Integer.valueOf(i10);
        View view = fVar.f4041a;
        view.setTag(R.id.POSITION_KEY, numValueOf);
        view.setOnClickListener(this.f10994j);
        if (this.f10989e == i10) {
            view.setBackgroundColor(context.getResources().getColor(R.color.card_detailing));
        } else {
            view.setBackgroundColor(context.getResources().getColor(android.R.color.background_light));
        }
        LayerDrawable layerDrawableB = b(R.drawable.fplib_ic_action_info);
        ImageView imageView = fVar.f11008x;
        imageView.setBackgroundDrawable(layerDrawableB);
        imageView.setClickable(true);
        imageView.setOnClickListener(new ViewOnClickListenerC0131b(i10));
        Scope scope = Scope.ALL;
        ArrayList arrayList = this.f10996l;
        TextView textView = fVar.f11005u;
        ImageView imageView2 = fVar.f11007w;
        Scope scope2 = this.f10991g;
        if (scope2 != scope) {
            if (scope2 == Scope.DIRECTORIES && ((File) arrayList.get(i10)).isDirectory()) {
                imageView2.setBackgroundDrawable(this.f10988d);
                textView.setText(((File) arrayList.get(i10)).getName());
                return;
            }
            return;
        }
        textView.setText(((File) arrayList.get(i10)).getName());
        if (!((File) arrayList.get(i10)).isDirectory()) {
            fVar.f11006v.setText(String.format(context.getString(R.string.file_picker_adapter_file_size_only_string), Long.valueOf(((File) arrayList.get(i10)).length())));
        }
        String strA = a(((File) arrayList.get(i10)).toString());
        if (((File) arrayList.get(i10)).isDirectory()) {
            imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_action_file_folder));
            return;
        }
        if (strA != null) {
            if (strA.equalsIgnoreCase(".doc")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_doc_file));
                return;
            }
            if (strA.equalsIgnoreCase(".docx")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_doc_file));
                return;
            }
            if (strA.equalsIgnoreCase(".xls")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_xls_file));
                return;
            }
            if (strA.equalsIgnoreCase(".xlsx")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_xlsx_file));
                return;
            }
            if (strA.equalsIgnoreCase(".xml")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_xml_file));
                return;
            }
            if (strA.equalsIgnoreCase(".html")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_html_file));
                return;
            }
            if (strA.equalsIgnoreCase(".pdf")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_pdf_file));
                return;
            }
            if (strA.equalsIgnoreCase(".txt")) {
                imageView2.setBackgroundDrawable(b(R.drawable.fplib_ic_txt_file));
                return;
            }
            if (strA.equalsIgnoreCase(".jpeg")) {
                imageView2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.fplib_rectangle));
                new c(this, imageView2, Bitmap.CompressFormat.JPEG).execute((File) arrayList.get(i10));
            } else if (strA.equalsIgnoreCase(".jpg")) {
                imageView2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.fplib_rectangle));
                new c(this, imageView2, Bitmap.CompressFormat.JPEG).execute((File) arrayList.get(i10));
            } else if (!strA.equalsIgnoreCase(".png")) {
                imageView2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.fplib_ic_default_file));
            } else {
                imageView2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.fplib_rectangle));
                new c(this, imageView2, Bitmap.CompressFormat.PNG).execute((File) arrayList.get(i10));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.z onCreateViewHolder(ViewGroup viewGroup, int i10) {
        Context context = this.f10997m;
        if (i10 == 124) {
            return new f(LayoutInflater.from(context).inflate(R.layout.file_list_item, viewGroup, false));
        }
        if (i10 == 123) {
            return new e(LayoutInflater.from(context).inflate(R.layout.file_list_header_view, viewGroup, false));
        }
        throw new RuntimeException(context.getString(R.string.file_picker_recycler_adapter_view_holder_type_error));
    }

    public void setSelectedPosition(int i10) {
        this.f10989e = i10;
        notifyDataSetChanged();
    }
}
