package kc;

import android.text.Editable;
import android.text.TextWatcher;
import flix.com.vision.bvp.BetterVideoPlayer;

/* compiled from: SubtitleOffsetDialog.java */
/* loaded from: classes2.dex */
public final class h implements TextWatcher {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f15079b;

    public h(i iVar) {
        this.f15079b = iVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) throws NumberFormatException {
        String string = editable.toString();
        if (string.isEmpty()) {
            string = "0.0";
        }
        i iVar = this.f15079b;
        iVar.f15083o.setText(string.concat(" s"));
        iVar.f15083o.setTag(string.trim());
        String str = (String) iVar.f15083o.getTag();
        String str2 = str != null ? str : "0.0";
        double d10 = 0.0d;
        if (str2.length() > 0) {
            try {
                d10 = Double.parseDouble(str2);
            } catch (NumberFormatException e10) {
                e10.printStackTrace();
            }
        }
        long j10 = (long) (1000.0d * d10);
        iVar.f15083o.setText(d10 + "s");
        BetterVideoPlayer betterVideoPlayer = iVar.f15085q;
        if (betterVideoPlayer != null) {
            betterVideoPlayer.setOffSet(j10);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
