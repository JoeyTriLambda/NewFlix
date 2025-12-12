package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.SearchEditText;
import androidx.leanback.widget.SearchOrbView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SearchBar extends RelativeLayout {
    public static final /* synthetic */ int I = 0;
    public final int A;
    public final int B;
    public SpeechRecognizer C;
    public boolean D;
    public SoundPool E;
    public final SparseIntArray F;
    public boolean G;
    public final Context H;

    /* renamed from: b, reason: collision with root package name */
    public SearchEditText f3116b;

    /* renamed from: m, reason: collision with root package name */
    public SpeechOrbView f3117m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView f3118n;

    /* renamed from: o, reason: collision with root package name */
    public String f3119o;

    /* renamed from: p, reason: collision with root package name */
    public String f3120p;

    /* renamed from: q, reason: collision with root package name */
    public String f3121q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f3122r;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f3123s;

    /* renamed from: t, reason: collision with root package name */
    public final InputMethodManager f3124t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3125u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f3126v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3127w;

    /* renamed from: x, reason: collision with root package name */
    public final int f3128x;

    /* renamed from: y, reason: collision with root package name */
    public final int f3129y;

    /* renamed from: z, reason: collision with root package name */
    public final int f3130z;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) throws Resources.NotFoundException {
            SearchBar searchBar = SearchBar.this;
            if (z10) {
                searchBar.f3123s.post(new o0(searchBar));
            } else {
                searchBar.f3124t.hideSoftInputFromWindow(searchBar.f3116b.getWindowToken(), 0);
            }
            searchBar.b(z10);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchBar searchBar = SearchBar.this;
            searchBar.setSearchQueryInternal(searchBar.f3116b.getText().toString());
        }
    }

    public class d implements SearchEditText.a {
        public d() {
        }

        public void onKeyboardDismiss() {
            SearchBar.this.getClass();
        }
    }

    public class e implements TextView.OnEditorActionListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchBar searchBar = SearchBar.this;
                searchBar.f3125u = true;
                searchBar.f3117m.requestFocus();
            }
        }

        public e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchBar searchBar = SearchBar.this;
            if (3 == i10 || i10 == 0) {
                searchBar.getClass();
            }
            if (1 == i10) {
                searchBar.getClass();
            }
            if (2 != i10) {
                return false;
            }
            searchBar.f3124t.hideSoftInputFromWindow(searchBar.f3116b.getWindowToken(), 0);
            searchBar.f3123s.postDelayed(new a(), 500L);
            return true;
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchBar searchBar = SearchBar.this;
            if (searchBar.G) {
                searchBar.stopRecognition();
            } else {
                searchBar.startRecognition();
            }
        }
    }

    public class g implements View.OnFocusChangeListener {
        public g() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) throws Resources.NotFoundException {
            SearchBar searchBar = SearchBar.this;
            if (z10) {
                searchBar.f3124t.hideSoftInputFromWindow(searchBar.f3116b.getWindowToken(), 0);
                if (searchBar.f3125u) {
                    searchBar.startRecognition();
                    searchBar.f3125u = false;
                }
            } else {
                searchBar.stopRecognition();
            }
            searchBar.b(z10);
        }
    }

    public interface i {
    }

    public interface j {
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() throws Resources.NotFoundException {
        String string = getResources().getString(R.string.lb_search_bar_hint);
        if (!TextUtils.isEmpty(this.f3121q)) {
            string = this.f3117m.isFocused() ? getResources().getString(R.string.lb_search_bar_hint_with_title_speech, this.f3121q) : getResources().getString(R.string.lb_search_bar_hint_with_title, this.f3121q);
        } else if (this.f3117m.isFocused()) {
            string = getResources().getString(R.string.lb_search_bar_hint_speech);
        }
        this.f3120p = string;
        SearchEditText searchEditText = this.f3116b;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    public final void b(boolean z10) throws Resources.NotFoundException {
        if (z10) {
            this.f3126v.setAlpha(this.B);
            boolean zIsFocused = this.f3117m.isFocused();
            int i10 = this.f3130z;
            if (zIsFocused) {
                this.f3116b.setTextColor(i10);
                this.f3116b.setHintTextColor(i10);
            } else {
                this.f3116b.setTextColor(this.f3128x);
                this.f3116b.setHintTextColor(i10);
            }
        } else {
            this.f3126v.setAlpha(this.A);
            this.f3116b.setTextColor(this.f3127w);
            this.f3116b.setHintTextColor(this.f3129y);
        }
        a();
    }

    public Drawable getBadgeDrawable() {
        return this.f3122r;
    }

    public CharSequence getHint() {
        return this.f3120p;
    }

    public String getTitle() {
        return this.f3121q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.E = new SoundPool(2, 1, 0);
        int[] iArr = {R.raw.lb_voice_failure, R.raw.lb_voice_open, R.raw.lb_voice_no_input, R.raw.lb_voice_success};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            this.F.put(i11, this.E.load(this.H, i11, 1));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopRecognition();
        this.E.release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        this.f3126v = ((RelativeLayout) findViewById(R.id.lb_search_bar_items)).getBackground();
        this.f3116b = (SearchEditText) findViewById(R.id.lb_search_text_editor);
        ImageView imageView = (ImageView) findViewById(R.id.lb_search_bar_badge);
        this.f3118n = imageView;
        Drawable drawable = this.f3122r;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f3116b.setOnFocusChangeListener(new a());
        this.f3116b.addTextChangedListener(new c(new b()));
        this.f3116b.setOnKeyboardDismissListener(new d());
        this.f3116b.setOnEditorActionListener(new e());
        this.f3116b.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView speechOrbView = (SpeechOrbView) findViewById(R.id.lb_search_bar_speech_orb);
        this.f3117m = speechOrbView;
        speechOrbView.setOnOrbClickedListener(new f());
        this.f3117m.setOnFocusChangeListener(new g());
        b(hasFocus());
        a();
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f3122r = drawable;
        ImageView imageView = this.f3118n;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.f3118n.setVisibility(0);
            } else {
                this.f3118n.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setNextFocusDownId(int i10) {
        this.f3117m.setNextFocusDownId(i10);
        this.f3116b.setNextFocusDownId(i10);
    }

    public void setSearchAffordanceColors(SearchOrbView.c cVar) {
        SpeechOrbView speechOrbView = this.f3117m;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(cVar);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.c cVar) {
        SpeechOrbView speechOrbView = this.f3117m;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(cVar);
        }
    }

    public void setSearchQuery(String str) {
        stopRecognition();
        this.f3116b.setText(str);
        setSearchQueryInternal(str);
    }

    public void setSearchQueryInternal(String str) {
        if (TextUtils.equals(this.f3119o, str)) {
            return;
        }
        this.f3119o = str;
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        stopRecognition();
        SpeechRecognizer speechRecognizer2 = this.C;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener(null);
            if (this.D) {
                this.C.cancel();
                this.D = false;
            }
        }
        this.C = speechRecognizer;
    }

    public void setTitle(String str) throws Resources.NotFoundException {
        this.f3121q = str;
        a();
    }

    public void startRecognition() {
        if (this.G) {
            return;
        }
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.C == null) {
            return;
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            int i10 = Build.VERSION.SDK_INT;
            throw new IllegalStateException("android.permission.RECORD_AUDIO required for search");
        }
        this.G = true;
        this.f3116b.setText("");
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        this.C.setRecognitionListener(new h());
        this.D = true;
        this.C.startListening(intent);
    }

    public void stopRecognition() {
        if (this.G) {
            this.f3116b.setText(this.f3119o);
            this.f3116b.setHint(this.f3120p);
            this.G = false;
            if (this.C == null) {
                return;
            }
            this.f3117m.showNotListening();
            if (this.D) {
                this.C.cancel();
                this.D = false;
            }
            this.C.setRecognitionListener(null);
        }
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3123s = new Handler();
        this.f3125u = false;
        this.F = new SparseIntArray();
        this.G = false;
        this.H = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(R.layout.lb_search_bar, (ViewGroup) this, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.lb_search_bar_height));
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f3119o = "";
        this.f3124t = (InputMethodManager) context.getSystemService("input_method");
        this.f3128x = resources.getColor(R.color.lb_search_bar_text_speech_mode);
        this.f3127w = resources.getColor(R.color.lb_search_bar_text);
        this.B = resources.getInteger(R.integer.lb_search_bar_speech_mode_background_alpha);
        this.A = resources.getInteger(R.integer.lb_search_bar_text_mode_background_alpha);
        this.f3130z = resources.getColor(R.color.lb_search_bar_hint_speech_mode);
        this.f3129y = resources.getColor(R.color.lb_search_bar_hint);
    }

    public class h implements RecognitionListener {
        public h() {
        }

        @Override // android.speech.RecognitionListener
        public void onError(int i10) {
            switch (i10) {
                case 1:
                    int i11 = SearchBar.I;
                    Log.w("SearchBar", "recognizer network timeout");
                    break;
                case 2:
                    int i12 = SearchBar.I;
                    Log.w("SearchBar", "recognizer network error");
                    break;
                case 3:
                    int i13 = SearchBar.I;
                    Log.w("SearchBar", "recognizer audio error");
                    break;
                case 4:
                    int i14 = SearchBar.I;
                    Log.w("SearchBar", "recognizer server error");
                    break;
                case 5:
                    int i15 = SearchBar.I;
                    Log.w("SearchBar", "recognizer client error");
                    break;
                case 6:
                    int i16 = SearchBar.I;
                    Log.w("SearchBar", "recognizer speech timeout");
                    break;
                case 7:
                    int i17 = SearchBar.I;
                    Log.w("SearchBar", "recognizer no match");
                    break;
                case 8:
                    int i18 = SearchBar.I;
                    Log.w("SearchBar", "recognizer busy");
                    break;
                case 9:
                    int i19 = SearchBar.I;
                    Log.w("SearchBar", "recognizer insufficient permissions");
                    break;
                default:
                    int i20 = SearchBar.I;
                    Log.d("SearchBar", "recognizer other error");
                    break;
            }
            SearchBar searchBar = SearchBar.this;
            searchBar.stopRecognition();
            searchBar.f3123s.post(new n0(searchBar, R.raw.lb_voice_failure));
        }

        @Override // android.speech.RecognitionListener
        public void onPartialResults(Bundle bundle) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
            if (stringArrayList == null || stringArrayList.size() == 0) {
                return;
            }
            SearchBar.this.f3116b.updateRecognizedText(stringArrayList.get(0), stringArrayList.size() > 1 ? stringArrayList.get(1) : null);
        }

        @Override // android.speech.RecognitionListener
        public void onReadyForSpeech(Bundle bundle) {
            SearchBar searchBar = SearchBar.this;
            searchBar.f3117m.showListening();
            searchBar.f3123s.post(new n0(searchBar, R.raw.lb_voice_open));
        }

        @Override // android.speech.RecognitionListener
        public void onResults(Bundle bundle) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
            SearchBar searchBar = SearchBar.this;
            if (stringArrayList != null) {
                String str = stringArrayList.get(0);
                searchBar.f3119o = str;
                searchBar.f3116b.setText(str);
                TextUtils.isEmpty(searchBar.f3119o);
            }
            searchBar.stopRecognition();
            searchBar.f3123s.post(new n0(searchBar, R.raw.lb_voice_success));
        }

        @Override // android.speech.RecognitionListener
        public void onRmsChanged(float f10) {
            SearchBar.this.f3117m.setSoundLevel(f10 < 0.0f ? 0 : (int) (f10 * 10.0f));
        }

        @Override // android.speech.RecognitionListener
        public void onBeginningOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public void onEndOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public void onBufferReceived(byte[] bArr) {
        }

        @Override // android.speech.RecognitionListener
        public void onEvent(int i10, Bundle bundle) {
        }
    }

    public class c implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f3133b;

        public c(b bVar) {
            this.f3133b = bVar;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchBar searchBar = SearchBar.this;
            if (searchBar.G) {
                return;
            }
            Handler handler = searchBar.f3123s;
            Runnable runnable = this.f3133b;
            handler.removeCallbacks(runnable);
            searchBar.f3123s.post(runnable);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public void setPermissionListener(j jVar) {
    }

    public void setSearchBarListener(i iVar) {
    }

    @Deprecated
    public void setSpeechRecognitionCallback(u0 u0Var) {
    }
}
