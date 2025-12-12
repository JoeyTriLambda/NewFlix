package ic;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import flix.com.vision.R;

/* compiled from: DesignerToastFV.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static View f13356a;

    /* renamed from: b, reason: collision with root package name */
    public static TextView f13357b;

    /* renamed from: c, reason: collision with root package name */
    public static TextView f13358c;

    /* renamed from: d, reason: collision with root package name */
    public static ImageView f13359d;

    public static void Success(Context context, String str, String str2, int i10, int i11) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.toast_dark_layout, (ViewGroup) null, false);
            f13356a = viewInflate;
            f13357b = (TextView) viewInflate.findViewById(R.id.dark_toast_message);
            f13359d = (ImageView) viewInflate.findViewById(R.id.dark_toast_icon);
            f13358c = (TextView) viewInflate.findViewById(R.id.dark_toast_description);
            f13357b.setText(str);
            f13358c.setText(str2);
            f13359d.setImageResource(R.drawable.ic_success2);
            f13357b.setTextColor(context.getResources().getColor(R.color.accent));
            Toast toast = new Toast(context);
            toast.setDuration(i11);
            toast.setGravity(i10, 0, 20);
            toast.setView(f13356a);
            toast.show();
        } catch (Exception e10) {
            Log.e("ContentValues", "Success: ", e10);
        }
    }
}
