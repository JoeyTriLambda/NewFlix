package ub;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.activities.SearchActivityTV;
import org.apache.commons.lang3.StringUtils;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class r1 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20261b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SearchActivityTV f20262m;

    public /* synthetic */ r1(SearchActivityTV searchActivityTV, int i10) {
        this.f20261b = i10;
        this.f20262m = searchActivityTV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20261b;
        SearchActivityTV searchActivityTV = this.f20262m;
        switch (i10) {
            case 0:
                int i11 = SearchActivityTV.f11775j0;
                searchActivityTV.onLetterClicked(StringUtils.SPACE);
                break;
            case 1:
                searchActivityTV.Q = SearchActivityTV.removeLastChar(searchActivityTV.Q);
                searchActivityTV.e();
                break;
            case 2:
                if (!searchActivityTV.Q.isEmpty()) {
                    searchActivityTV.Q = "";
                    searchActivityTV.e();
                    break;
                }
                break;
            case 3:
                int i12 = SearchActivityTV.f11775j0;
                searchActivityTV.getClass();
                try {
                    Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                    intent.putExtra("android.speech.extra.PROMPT", "Say a Movie Title or Actor name");
                    intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                    searchActivityTV.startActivityForResult(intent, 1210);
                    break;
                } catch (Exception unused) {
                    Toast.makeText(searchActivityTV.getBaseContext(), "Voice Search is not supported on this device", 1).show();
                }
            default:
                int i13 = SearchActivityTV.f11775j0;
                searchActivityTV.getClass();
                searchActivityTV.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:flix.com.vision")), 2000);
                break;
        }
    }
}
