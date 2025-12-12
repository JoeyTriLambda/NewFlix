package flix.com.vision.tv;

import ac.z;
import ae.e;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unity3d.ads.metadata.MediationMetaData;
import com.uwetrottmann.trakt5.TraktV2;
import flix.com.vision.App;
import flix.com.vision.R;
import hd.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import v7.b;
import wb.a;

/* loaded from: classes2.dex */
public class MyImportActivity extends a {
    public static final /* synthetic */ int P = 0;
    public RecyclerView K;
    public z L;
    public RelativeLayout M;
    public final ArrayList<h> N = new ArrayList<>();
    public ImageView O;

    public void editItem(h hVar) {
        if (hVar.f13010n.equalsIgnoreCase("3")) {
            Toast.makeText(getBaseContext(), "local files cannot be edited", 1).show();
            return;
        }
        if (hVar.f13010n.equalsIgnoreCase(TraktV2.API_VERSION)) {
            Toast.makeText(getBaseContext(), "Our playlist cannot be edited", 1).show();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) M3UImportActivity.class);
        intent.putExtra("url", hVar.f13008b);
        intent.putExtra("label", hVar.f13009m);
        startActivity(intent);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 12345 && i11 == -1) {
            String stringExtra = intent.getStringExtra("fileExtraPath");
            h hVar = new h();
            try {
                hVar.f13009m = stringExtra.split("/")[r0.length - 1];
            } catch (Exception unused) {
                hVar.f13009m = stringExtra;
            }
            hVar.f13008b = stringExtra;
            hVar.f13010n = "3";
            App.getInstance().f11573u.addHistoryIPTV(hVar);
            Intent intent2 = new Intent(this, (Class<?>) TVCategoriesActivity2.class);
            intent2.putExtra("is_file", true);
            intent2.putExtra("url", stringExtra);
            startActivity(intent2);
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tv_history);
        Iterator<h> it = App.getInstance().f11573u.getHistoryIPTVFromDb().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            ArrayList<h> arrayList = this.N;
            if (!zHasNext) {
                Collections.sort(arrayList);
                this.O = (ImageView) findViewById(R.id.image_plus_button);
                this.K = (RecyclerView) findViewById(R.id.recyclerview);
                this.M = (RelativeLayout) findViewById(R.id.add_button);
                this.L = new z(getBaseContext(), arrayList, this);
                this.K.setLayoutManager(new LinearLayoutManager(this));
                this.K.setAdapter(this.L);
                this.K.requestFocus();
                this.M.setOnClickListener(new e(this, 0));
                this.M.setOnFocusChangeListener(new b(this, 7));
                return;
            }
            h next = it.next();
            String str = next.f13010n;
            if (str != null && !str.equals("1")) {
                arrayList.add(next);
            }
        }
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        ArrayList<h> arrayList = this.N;
        arrayList.clear();
        Iterator<h> it = App.getInstance().f11573u.getHistoryIPTVFromDb().iterator();
        while (it.hasNext()) {
            h next = it.next();
            String str = next.f13010n;
            if (str != null && !str.equals("1")) {
                arrayList.add(next);
            }
        }
        this.L.notifyDataSetChanged();
    }

    public void openItem(h hVar) {
        Intent intent = new Intent(this, (Class<?>) TVCategoriesActivity2.class);
        String str = hVar.f13010n;
        intent.putExtra("is_file", str != null && str.equals("3"));
        intent.putExtra("url", hVar.f13008b);
        intent.putExtra(MediationMetaData.KEY_NAME, hVar.f13009m);
        startActivity(intent);
    }

    public void removeItem(h hVar) {
        App.getInstance().f11573u.deleteHistoryIptvItem(hVar);
        this.N.remove(hVar);
        this.L.notifyDataSetChanged();
    }
}
