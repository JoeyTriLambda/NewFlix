package dd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.FilePickerActivity;
import flix.com.vision.filepickerlibrary.enums.Scope;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: FileListAdapter.java */
/* loaded from: classes2.dex */
public final class a extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final FilePickerActivity f10976b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f10977m;

    /* renamed from: n, reason: collision with root package name */
    public final LayoutInflater f10978n;

    /* renamed from: o, reason: collision with root package name */
    public int f10979o = -1;

    /* renamed from: p, reason: collision with root package name */
    public final float f10980p;

    /* renamed from: q, reason: collision with root package name */
    public final Drawable f10981q;

    /* renamed from: r, reason: collision with root package name */
    public final Scope f10982r;

    /* compiled from: FileListAdapter.java */
    /* renamed from: dd.a$a, reason: collision with other inner class name */
    public class AsyncTaskC0130a extends AsyncTask<File, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ImageView> f10983a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap.CompressFormat f10984b;

        public AsyncTaskC0130a(a aVar, ImageView imageView, Bitmap.CompressFormat compressFormat) {
            imageView.setBackgroundDrawable(imageView.getContext().getResources().getDrawable(R.drawable.fplib_rectangle));
            this.f10983a = new WeakReference<>(imageView);
            this.f10984b = compressFormat;
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(File... fileArr) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(fileArr[0].getAbsolutePath());
            if (bitmapDecodeFile != null) {
                return a.decodeSampledBitmapFromByteArray(a.encodeBitmapToArray(bitmapDecodeFile, this.f10984b), 54, 54);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            ImageView imageView;
            WeakReference<ImageView> weakReference = this.f10983a;
            if (weakReference.get() == null || bitmap == null || (imageView = weakReference.get()) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    /* compiled from: FileListAdapter.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f10985a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f10986b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f10987c;
    }

    public a(FilePickerActivity filePickerActivity, File[] fileArr, Scope scope) {
        this.f10976b = filePickerActivity;
        this.f10977m = new ArrayList(Arrays.asList(fileArr));
        this.f10978n = LayoutInflater.from(filePickerActivity);
        this.f10982r = scope;
        this.f10981q = filePickerActivity.getResources().getDrawable(R.drawable.fplib_ic_folder);
        this.f10980p = filePickerActivity.getResources().getDimension(R.dimen.file_picker_lib_default_icon_padding);
        if (scope == Scope.DIRECTORIES) {
            for (int i10 = 0; i10 < this.f10977m.size(); i10++) {
                if (a(((File) this.f10977m.get(i10)).getPath()) != null) {
                    this.f10977m.remove(i10);
                }
            }
        }
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
        FilePickerActivity filePickerActivity = this.f10976b;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{filePickerActivity.getResources().getDrawable(R.drawable.fplib_circle), filePickerActivity.getResources().getDrawable(i10)});
        int i11 = (int) this.f10980p;
        layerDrawable.setLayerInset(1, i11, i11, i11, i11);
        return layerDrawable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10977m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f10977m.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public int getSelectedPosition() {
        return this.f10979o;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f10978n.inflate(R.layout.file_list_item, (ViewGroup) null);
            bVar = new b();
            bVar.f10986b = (TextView) view.findViewById(R.id.file_item_file_info);
            bVar.f10985a = (TextView) view.findViewById(R.id.file_item_file_name);
            bVar.f10987c = (ImageView) view.findViewById(R.id.file_item_image_view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        int i11 = this.f10979o;
        FilePickerActivity filePickerActivity = this.f10976b;
        if (i11 == i10) {
            view.setBackgroundColor(filePickerActivity.getResources().getColor(R.color.md_blue_500));
        } else {
            view.setBackgroundColor(filePickerActivity.getResources().getColor(android.R.color.background_light));
        }
        Scope scope = Scope.ALL;
        ArrayList arrayList = this.f10977m;
        Scope scope2 = this.f10982r;
        if (scope2 == scope) {
            bVar.f10985a.setText(((File) arrayList.get(i10)).getName());
            if (!((File) arrayList.get(i10)).isDirectory()) {
                bVar.f10986b.setText(String.format(filePickerActivity.getString(R.string.file_picker_adapter_file_size_only_string), Long.valueOf(((File) arrayList.get(i10)).length())));
            }
            String strA = a(((File) arrayList.get(i10)).toString());
            if (((File) arrayList.get(i10)).isDirectory()) {
                bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_action_file_folder));
            } else if (strA != null) {
                if (strA.equalsIgnoreCase(".doc") || strA.equalsIgnoreCase(".docx")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_doc_file));
                } else if (strA.equalsIgnoreCase(".xls")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_xls_file));
                } else if (strA.equalsIgnoreCase(".xlsx")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_xlsx_file));
                } else if (strA.equalsIgnoreCase(".xml")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_xml_file));
                } else if (strA.equalsIgnoreCase(".html")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_html_file));
                } else if (strA.equalsIgnoreCase(".pdf")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_pdf_file));
                } else if (strA.equalsIgnoreCase(".txt")) {
                    bVar.f10987c.setBackgroundDrawable(b(R.drawable.fplib_ic_txt_file));
                } else if (strA.equalsIgnoreCase(".jpeg")) {
                    bVar.f10987c.setBackgroundDrawable(filePickerActivity.getResources().getDrawable(R.drawable.fplib_rectangle));
                    new AsyncTaskC0130a(this, bVar.f10987c, Bitmap.CompressFormat.JPEG).execute((File) arrayList.get(i10));
                } else if (strA.equalsIgnoreCase(".jpg")) {
                    bVar.f10987c.setBackgroundDrawable(filePickerActivity.getResources().getDrawable(R.drawable.fplib_rectangle));
                    new AsyncTaskC0130a(this, bVar.f10987c, Bitmap.CompressFormat.JPEG).execute((File) arrayList.get(i10));
                } else if (strA.equalsIgnoreCase(".png")) {
                    bVar.f10987c.setBackgroundDrawable(filePickerActivity.getResources().getDrawable(R.drawable.fplib_rectangle));
                    new AsyncTaskC0130a(this, bVar.f10987c, Bitmap.CompressFormat.PNG).execute((File) arrayList.get(i10));
                } else {
                    bVar.f10987c.setBackgroundDrawable(filePickerActivity.getResources().getDrawable(R.drawable.fplib_ic_default_file));
                }
            }
        } else if (scope2 == Scope.DIRECTORIES && ((File) arrayList.get(i10)).isDirectory()) {
            bVar.f10987c.setBackgroundDrawable(this.f10981q);
            bVar.f10985a.setText(((File) arrayList.get(i10)).getName());
        }
        return view;
    }

    public void setSelectedPosition(int i10) {
        this.f10979o = i10;
        notifyDataSetChanged();
    }
}
