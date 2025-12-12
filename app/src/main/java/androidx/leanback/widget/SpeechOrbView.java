package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.leanback.R;
import androidx.leanback.widget.SearchOrbView;

/* loaded from: classes.dex */
public class SpeechOrbView extends SearchOrbView {
    public final float D;
    public SearchOrbView.c E;
    public SearchOrbView.c F;
    public int G;
    public boolean H;

    public SpeechOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.leanback.widget.SearchOrbView
    public int getLayoutResourceId() {
        return R.layout.lb_speech_orb;
    }

    public void setListeningOrbColors(SearchOrbView.c cVar) {
        this.E = cVar;
    }

    public void setNotListeningOrbColors(SearchOrbView.c cVar) {
        this.F = cVar;
    }

    public void setSoundLevel(int i10) {
        if (this.H) {
            int i11 = this.G;
            if (i10 > i11) {
                this.G = ((i10 - i11) / 2) + i11;
            } else {
                this.G = (int) (i11 * 0.7f);
            }
            float focusedZoom = (((this.D - getFocusedZoom()) * this.G) / 100.0f) + 1.0f;
            View view = this.f3144n;
            view.setScaleX(focusedZoom);
            view.setScaleY(focusedZoom);
        }
    }

    public void showListening() {
        setOrbColors(this.E);
        setOrbIcon(getResources().getDrawable(R.drawable.lb_ic_search_mic));
        a(true);
        enableOrbColorAnimation(false);
        View view = this.f3144n;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.G = 0;
        this.H = true;
    }

    public void showNotListening() {
        setOrbColors(this.F);
        setOrbIcon(getResources().getDrawable(R.drawable.lb_ic_search_mic_out));
        a(hasFocus());
        View view = this.f3144n;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.H = false;
    }

    public SpeechOrbView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.G = 0;
        this.H = false;
        Resources resources = context.getResources();
        this.D = resources.getFraction(R.fraction.lb_search_bar_speech_orb_max_level_zoom, 1, 1);
        this.F = new SearchOrbView.c(resources.getColor(R.color.lb_speech_orb_not_recording), resources.getColor(R.color.lb_speech_orb_not_recording_pulsed), resources.getColor(R.color.lb_speech_orb_not_recording_icon));
        int i11 = R.color.lb_speech_orb_recording;
        this.E = new SearchOrbView.c(resources.getColor(i11), resources.getColor(i11), 0);
        showNotListening();
    }
}
