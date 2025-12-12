package androidx.mediarouter.app;

import ac.z;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import flix.com.vision.App;
import flix.com.vision.activities.AnimeHistoryActivity;
import flix.com.vision.activities.DonationActvity;
import flix.com.vision.activities.DramaHistoryActivity;
import flix.com.vision.activities.YouTubePlayerActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.activities.player.YouTubeWebviewActivity;
import flix.com.vision.subtitles.SubtitlesWebViewActivity;
import flix.com.vision.tv.PlayerActivityLiveExternal;
import io.github.giangpham96.expandable_textview.ExpandableTextView;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3600b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3601m;

    public /* synthetic */ b(Object obj, int i10) {
        this.f3600b = i10;
        this.f3601m = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws SQLException {
        int i10 = this.f3600b;
        Object obj = this.f3601m;
        switch (i10) {
            case 0:
                ((c) obj).dismiss();
                break;
            case 1:
                com.google.android.material.datepicker.p pVar = (com.google.android.material.datepicker.p) obj;
                pVar.X0.setEnabled(pVar.getDateSelector().isSelectionComplete());
                pVar.V0.toggle();
                pVar.K0 = pVar.K0 != 1 ? 1 : 0;
                pVar.t(pVar.V0);
                pVar.s();
                break;
            case 2:
            default:
                ExpandableTextView expandableTextView = (ExpandableTextView) obj;
                int i11 = ExpandableTextView.C;
                zf.i.checkNotNullParameter(expandableTextView, "this$0");
                expandableTextView.toggle();
                break;
            case 3:
                v7.e eVar = (v7.e) obj;
                EditText editText = eVar.f20535i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    eVar.l();
                    break;
                }
                break;
            case 4:
                ((v7.k) obj).p();
                break;
            case 5:
                v7.r rVar = (v7.r) obj;
                EditText editText2 = rVar.f20607f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = rVar.f20607f;
                    if (editText3 != null && (editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        i = 1;
                    }
                    if (i != 0) {
                        rVar.f20607f.setTransformationMethod(null);
                    } else {
                        rVar.f20607f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    if (selectionEnd >= 0) {
                        rVar.f20607f.setSelection(selectionEnd);
                    }
                    rVar.l();
                    break;
                }
                break;
            case 6:
                AnimeHistoryActivity animeHistoryActivity = (AnimeHistoryActivity) obj;
                int i12 = AnimeHistoryActivity.P;
                animeHistoryActivity.getClass();
                App.getInstance().f11573u.clearHistoryAnime();
                animeHistoryActivity.M.clear();
                animeHistoryActivity.N.notifyDataSetChanged();
                be.d.makeToast(animeHistoryActivity, "Anime history cleared", true);
                break;
            case 7:
                DonationActvity donationActvity = (DonationActvity) obj;
                int i13 = DonationActvity.K;
                donationActvity.getClass();
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", "donation@flixvision.tv");
                intent.putExtra("android.intent.extra.SUBJECT", "FLIXVISION Donation");
                if (intent.resolveActivity(donationActvity.getPackageManager()) != null) {
                    donationActvity.startActivity(intent);
                    break;
                }
                break;
            case 8:
                DramaHistoryActivity dramaHistoryActivity = (DramaHistoryActivity) obj;
                int i14 = DramaHistoryActivity.O;
                dramaHistoryActivity.getClass();
                App.getInstance().f11573u.clearHistoryDrama();
                dramaHistoryActivity.L.clear();
                dramaHistoryActivity.M.notifyDataSetChanged();
                be.d.makeToast(dramaHistoryActivity, "Drama history cleared", true);
                break;
            case 9:
                int i15 = YouTubePlayerActivity.f11878t;
                ((YouTubePlayerActivity) obj).finish();
                break;
            case 10:
                AdultVideosFavoritesActivity adultVideosFavoritesActivity = (AdultVideosFavoritesActivity) obj;
                int i16 = AdultVideosFavoritesActivity.X;
                adultVideosFavoritesActivity.getClass();
                adultVideosFavoritesActivity.startActivity(new Intent(adultVideosFavoritesActivity, (Class<?>) AdultVideosSearchActivity.class));
                break;
            case 11:
                int i17 = YouTubeWebviewActivity.U;
                ((YouTubeWebviewActivity) obj).finish();
                break;
            case 12:
                ((z.a) obj).f613v.performClick();
                break;
            case 13:
                int i18 = SubtitlesWebViewActivity.R;
                ((SubtitlesWebViewActivity) obj).finish();
                break;
            case 14:
                int i19 = PlayerActivityLiveExternal.f12465h0;
                ((PlayerActivityLiveExternal) obj).finish();
                break;
        }
    }
}
