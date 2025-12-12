package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends m0 implements w.c {

    /* renamed from: r0, reason: collision with root package name */
    public static final o f1133r0;
    public final SearchAutoComplete A;
    public final View B;
    public final View C;
    public final View D;
    public final ImageView E;
    public final ImageView F;
    public final ImageView G;
    public final ImageView H;
    public final View I;
    public q J;
    public final Rect K;
    public final Rect L;
    public final int[] M;
    public final int[] N;
    public final ImageView O;
    public final Drawable P;
    public final int Q;
    public final int R;
    public final Intent S;
    public final Intent T;
    public final CharSequence U;
    public View.OnFocusChangeListener V;
    public View.OnClickListener W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f1134a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f1135b0;

    /* renamed from: c0, reason: collision with root package name */
    public e1.a f1136c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f1137d0;

    /* renamed from: e0, reason: collision with root package name */
    public CharSequence f1138e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f1139f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f1140g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f1141h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f1142i0;

    /* renamed from: j0, reason: collision with root package name */
    public CharSequence f1143j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f1144k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f1145l0;

    /* renamed from: m0, reason: collision with root package name */
    public SearchableInfo f1146m0;

    /* renamed from: n0, reason: collision with root package name */
    public Bundle f1147n0;

    /* renamed from: o0, reason: collision with root package name */
    public final b f1148o0;

    /* renamed from: p0, reason: collision with root package name */
    public final c f1149p0;

    /* renamed from: q0, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1150q0;

    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* renamed from: p, reason: collision with root package name */
        public int f1151p;

        /* renamed from: q, reason: collision with root package name */
        public SearchView f1152q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f1153r;

        /* renamed from: s, reason: collision with root package name */
        public final a f1154s;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.f1153r) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.f1153r = false;
                }
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 29) {
                k.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            o oVar = SearchView.f1133r0;
            oVar.getClass();
            o.a();
            Method method = oVar.f1168c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1151p <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1153r) {
                a aVar = this.f1154s;
                removeCallbacks(aVar);
                post(aVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z10, int i10, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z10, i10, rect);
            SearchView searchView = this.f1152q;
            searchView.o(searchView.isIconified());
            searchView.post(searchView.f1148o0);
            if (searchView.A.hasFocus()) {
                searchView.e();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1152q.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f1152q.hasFocus() && getVisibility() == 0) {
                this.f1153r = true;
                Context context = getContext();
                o oVar = SearchView.f1133r0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            a aVar = this.f1154s;
            if (!z10) {
                this.f1153r = false;
                removeCallbacks(aVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1153r = true;
                    return;
                }
                this.f1153r = false;
                removeCallbacks(aVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1152q = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f1151p = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f1154s = new a();
            this.f1151p = getThreshold();
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.k();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e1.a aVar = SearchView.this.f1136c0;
            if (aVar instanceof w0) {
                aVar.changeCursor(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.V;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView searchView = SearchView.this;
            View view2 = searchView.I;
            if (view2.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.C.getPaddingLeft();
                Rect rect = new Rect();
                boolean zIsLayoutRtl = k1.isLayoutRtl(searchView);
                int dimensionPixelSize = searchView.f1134a0 ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) : 0;
                SearchAutoComplete searchAutoComplete = searchView.A;
                searchAutoComplete.getDropDownBackground().getPadding(rect);
                searchAutoComplete.setDropDownHorizontalOffset(zIsLayoutRtl ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SearchView searchView = SearchView.this;
            ImageView imageView = searchView.E;
            SearchAutoComplete searchAutoComplete = searchView.A;
            if (view == imageView) {
                searchView.o(false);
                searchAutoComplete.requestFocus();
                searchAutoComplete.setImeVisibility(true);
                View.OnClickListener onClickListener = searchView.W;
                if (onClickListener != null) {
                    onClickListener.onClick(searchView);
                    return;
                }
                return;
            }
            if (view == searchView.G) {
                searchView.f();
                return;
            }
            if (view == searchView.F) {
                searchView.i();
                return;
            }
            if (view != searchView.H) {
                if (view == searchAutoComplete) {
                    searchView.e();
                    return;
                }
                return;
            }
            SearchableInfo searchableInfo = searchView.f1146m0;
            if (searchableInfo == null) {
                return;
            }
            try {
                if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                        searchView.getContext().startActivity(searchView.d(searchView.T, searchableInfo));
                    }
                } else {
                    Intent intent = new Intent(searchView.S);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                    searchView.getContext().startActivity(intent);
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SearchView searchView = SearchView.this;
            if (searchView.f1146m0 == null) {
                return false;
            }
            SearchAutoComplete searchAutoComplete = searchView.A;
            if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
                if ((TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0) || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                    return false;
                }
                view.cancelLongPress();
                searchView.getContext().startActivity(searchView.c("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
                return true;
            }
            if (searchView.f1146m0 == null || searchView.f1136c0 == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
                return false;
            }
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                searchView.g(searchAutoComplete.getListSelection());
            } else {
                if (i10 != 21 && i10 != 22) {
                    if (i10 != 19) {
                        return false;
                    }
                    searchAutoComplete.getListSelection();
                    return false;
                }
                searchAutoComplete.setSelection(i10 == 21 ? 0 : searchAutoComplete.length());
                searchAutoComplete.setListSelection(0);
                searchAutoComplete.clearListSelection();
                searchAutoComplete.a();
            }
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.i();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.g(i10);
        }
    }

    public static class k {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public final Method f1166a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f1167b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f1168c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public o() throws NoSuchMethodException, SecurityException {
            this.f1166a = null;
            this.f1167b = null;
            this.f1168c = null;
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1166a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1167b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1168c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    public static class p extends f1.a {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public boolean f1169n;

        public class a implements Parcelable.ClassLoaderCreator<p> {
            @Override // android.os.Parcelable.Creator
            public p[] newArray(int i10) {
                return new p[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }
        }

        public p(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1169n + "}";
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f1169n));
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1169n = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class q extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final View f1170a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f1171b;

        /* renamed from: c, reason: collision with root package name */
        public final Rect f1172c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f1173d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1174e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1175f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1174e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1171b = new Rect();
            this.f1173d = new Rect();
            this.f1172c = new Rect();
            setBounds(rect, rect2);
            this.f1170a = view;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f1175f;
                    if (z11 && !this.f1173d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f1175f;
                        this.f1175f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else {
                if (this.f1171b.contains(x10, y10)) {
                    this.f1175f = true;
                    z10 = true;
                }
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            Rect rect = this.f1172c;
            View view = this.f1170a;
            if (!z10 || rect.contains(x10, y10)) {
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            } else {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            }
            return view.dispatchTouchEvent(motionEvent);
        }

        public void setBounds(Rect rect, Rect rect2) {
            this.f1171b.set(rect);
            Rect rect3 = this.f1173d;
            rect3.set(rect);
            int i10 = this.f1174e;
            rect3.inset(-i10, -i10);
            this.f1172c.set(rect2);
        }
    }

    static {
        f1133r0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    public final Intent c(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1143j0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1147n0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f1146m0.getSearchActivity());
        return intent;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1140g0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.A;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f1140g0 = false;
    }

    public final Intent d(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1147n0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.A;
        if (i10 >= 29) {
            k.a(searchAutoComplete);
            return;
        }
        o oVar = f1133r0;
        oVar.getClass();
        o.a();
        Method method = oVar.f1166a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        oVar.getClass();
        o.a();
        Method method2 = oVar.f1167b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public final void f() {
        SearchAutoComplete searchAutoComplete = this.A;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f1134a0) {
            clearFocus();
            o(true);
        }
    }

    public final void g(int i10) {
        int position;
        String columnString;
        Cursor cursor = this.f1136c0.getCursor();
        if (cursor != null && cursor.moveToPosition(i10)) {
            Intent intentC = null;
            try {
                String columnString2 = w0.getColumnString(cursor, "suggest_intent_action");
                if (columnString2 == null) {
                    columnString2 = this.f1146m0.getSuggestIntentAction();
                }
                if (columnString2 == null) {
                    columnString2 = "android.intent.action.SEARCH";
                }
                String columnString3 = w0.getColumnString(cursor, "suggest_intent_data");
                if (columnString3 == null) {
                    columnString3 = this.f1146m0.getSuggestIntentData();
                }
                if (columnString3 != null && (columnString = w0.getColumnString(cursor, "suggest_intent_data_id")) != null) {
                    columnString3 = columnString3 + "/" + Uri.encode(columnString);
                }
                intentC = c(columnString2, columnString3 == null ? null : Uri.parse(columnString3), w0.getColumnString(cursor, "suggest_intent_extra_data"), w0.getColumnString(cursor, "suggest_intent_query"));
            } catch (RuntimeException e10) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e10);
            }
            if (intentC != null) {
                try {
                    getContext().startActivity(intentC);
                } catch (RuntimeException e11) {
                    Log.e("SearchView", "Failed launch activity: " + intentC, e11);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.A;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public int getImeOptions() {
        return this.A.getImeOptions();
    }

    public int getInputType() {
        return this.A.getInputType();
    }

    public int getMaxWidth() {
        return this.f1141h0;
    }

    public CharSequence getQuery() {
        return this.A.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1138e0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1146m0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.U : getContext().getText(this.f1146m0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.R;
    }

    public int getSuggestionRowLayout() {
        return this.Q;
    }

    public e1.a getSuggestionsAdapter() {
        return this.f1136c0;
    }

    public final void h(int i10) {
        Editable text = this.A.getText();
        Cursor cursor = this.f1136c0.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i10)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceConvertToString = this.f1136c0.convertToString(cursor);
        if (charSequenceConvertToString != null) {
            setQuery(charSequenceConvertToString);
        } else {
            setQuery(text);
        }
    }

    public final void i() {
        SearchAutoComplete searchAutoComplete = this.A;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f1146m0 != null) {
            getContext().startActivity(c("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public boolean isIconified() {
        return this.f1135b0;
    }

    public final void j() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.A.getText());
        if (!z11 && (!this.f1134a0 || this.f1144k0)) {
            z10 = false;
        }
        int i10 = z10 ? 0 : 8;
        ImageView imageView = this.G;
        imageView.setVisibility(i10);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void k() {
        int[] iArr = this.A.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.C.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.D.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void l() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z10 = this.f1134a0;
        SearchAutoComplete searchAutoComplete = this.A;
        if (z10 && (drawable = this.P) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void m() {
        int i10 = 0;
        if (!((this.f1137d0 || this.f1142i0) && !isIconified()) || (this.F.getVisibility() != 0 && this.H.getVisibility() != 0)) {
            i10 = 8;
        }
        this.D.setVisibility(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.f1137d0
            if (r0 == 0) goto L23
            r1 = 0
            if (r0 != 0) goto Lb
            boolean r0 = r2.f1142i0
            if (r0 == 0) goto L13
        Lb:
            boolean r0 = r2.isIconified()
            if (r0 != 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L23
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L23
            if (r3 != 0) goto L25
            boolean r3 = r2.f1142i0
            if (r3 != 0) goto L23
            goto L25
        L23:
            r1 = 8
        L25:
            android.widget.ImageView r3 = r2.F
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.n(boolean):void");
    }

    public final void o(boolean z10) {
        this.f1135b0 = z10;
        int i10 = 8;
        int i11 = z10 ? 0 : 8;
        boolean z11 = !TextUtils.isEmpty(this.A.getText());
        this.E.setVisibility(i11);
        n(z11);
        this.B.setVisibility(z10 ? 8 : 0);
        ImageView imageView = this.O;
        imageView.setVisibility((imageView.getDrawable() == null || this.f1134a0) ? 8 : 0);
        j();
        boolean z12 = !z11;
        if (this.f1142i0 && !isIconified() && z12) {
            this.F.setVisibility(8);
            i10 = 0;
        }
        this.H.setVisibility(i10);
        m();
    }

    @Override // w.c
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        o(true);
        this.A.setImeOptions(this.f1145l0);
        this.f1144k0 = false;
    }

    @Override // w.c
    public void onActionViewExpanded() {
        if (this.f1144k0) {
            return;
        }
        this.f1144k0 = true;
        SearchAutoComplete searchAutoComplete = this.A;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f1145l0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1148o0);
        post(this.f1149p0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.m0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            SearchAutoComplete searchAutoComplete = this.A;
            int[] iArr = this.M;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.N;
            getLocationInWindow(iArr2);
            int i14 = iArr[1] - iArr2[1];
            int i15 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i15;
            int height = searchAutoComplete.getHeight() + i14;
            Rect rect = this.K;
            rect.set(i15, i14, width, height);
            int i16 = rect.left;
            int i17 = rect.right;
            int i18 = i13 - i11;
            Rect rect2 = this.L;
            rect2.set(i16, 0, i17, i18);
            q qVar = this.J;
            if (qVar != null) {
                qVar.setBounds(rect2, rect);
                return;
            }
            q qVar2 = new q(rect2, rect, searchAutoComplete);
            this.J = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    @Override // androidx.appcompat.widget.m0, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (isIconified()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.f1141h0;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f1141h0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.f1141h0) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onQueryRefine(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.getSuperState());
        o(pVar.f1169n);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.f1169n = isIconified();
        return pVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        post(this.f1148o0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.f1140g0 || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i10, rect);
        }
        boolean zRequestFocus = this.A.requestFocus(i10, rect);
        if (zRequestFocus) {
            o(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1147n0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            f();
            return;
        }
        o(false);
        SearchAutoComplete searchAutoComplete = this.A;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.W;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f1134a0 == z10) {
            return;
        }
        this.f1134a0 = z10;
        o(z10);
        l();
    }

    public void setImeOptions(int i10) {
        this.A.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.A.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.f1141h0 = i10;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.V = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.W = onClickListener;
    }

    public void setQuery(CharSequence charSequence, boolean z10) {
        SearchAutoComplete searchAutoComplete = this.A;
        searchAutoComplete.setText(charSequence);
        if (charSequence != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1143j0 = charSequence;
        }
        if (!z10 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        i();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1138e0 = charSequence;
        l();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.f1139f0 = z10;
        e1.a aVar = this.f1136c0;
        if (aVar instanceof w0) {
            ((w0) aVar).setQueryRefinement(z10 ? 2 : 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSearchableInfo(android.app.SearchableInfo r8) {
        /*
            r7 = this;
            r7.f1146m0 = r8
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = r7.A
            r1 = 1
            r2 = 65536(0x10000, float:9.1835E-41)
            r3 = 0
            if (r8 == 0) goto L69
            int r8 = r8.getSuggestThreshold()
            r0.setThreshold(r8)
            android.app.SearchableInfo r8 = r7.f1146m0
            int r8 = r8.getImeOptions()
            r0.setImeOptions(r8)
            android.app.SearchableInfo r8 = r7.f1146m0
            int r8 = r8.getInputType()
            r4 = r8 & 15
            if (r4 != r1) goto L34
            r4 = -65537(0xfffffffffffeffff, float:NaN)
            r8 = r8 & r4
            android.app.SearchableInfo r4 = r7.f1146m0
            java.lang.String r4 = r4.getSuggestAuthority()
            if (r4 == 0) goto L34
            r8 = r8 | r2
            r4 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 | r4
        L34:
            r0.setInputType(r8)
            e1.a r8 = r7.f1136c0
            if (r8 == 0) goto L3e
            r8.changeCursor(r3)
        L3e:
            android.app.SearchableInfo r8 = r7.f1146m0
            java.lang.String r8 = r8.getSuggestAuthority()
            if (r8 == 0) goto L66
            androidx.appcompat.widget.w0 r8 = new androidx.appcompat.widget.w0
            android.content.Context r4 = r7.getContext()
            android.app.SearchableInfo r5 = r7.f1146m0
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r6 = r7.f1150q0
            r8.<init>(r4, r7, r5, r6)
            r7.f1136c0 = r8
            r0.setAdapter(r8)
            e1.a r8 = r7.f1136c0
            androidx.appcompat.widget.w0 r8 = (androidx.appcompat.widget.w0) r8
            boolean r4 = r7.f1139f0
            if (r4 == 0) goto L62
            r4 = 2
            goto L63
        L62:
            r4 = 1
        L63:
            r8.setQueryRefinement(r4)
        L66:
            r7.l()
        L69:
            android.app.SearchableInfo r8 = r7.f1146m0
            if (r8 == 0) goto L99
            boolean r8 = r8.getVoiceSearchEnabled()
            if (r8 == 0) goto L99
            android.app.SearchableInfo r8 = r7.f1146m0
            boolean r8 = r8.getVoiceSearchLaunchWebSearch()
            if (r8 == 0) goto L7e
            android.content.Intent r3 = r7.S
            goto L88
        L7e:
            android.app.SearchableInfo r8 = r7.f1146m0
            boolean r8 = r8.getVoiceSearchLaunchRecognizer()
            if (r8 == 0) goto L88
            android.content.Intent r3 = r7.T
        L88:
            if (r3 == 0) goto L99
            android.content.Context r8 = r7.getContext()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            android.content.pm.ResolveInfo r8 = r8.resolveActivity(r3, r2)
            if (r8 == 0) goto L99
            goto L9a
        L99:
            r1 = 0
        L9a:
            r7.f1142i0 = r1
            if (r1 == 0) goto La3
            java.lang.String r8 = "nm"
            r0.setPrivateImeOptions(r8)
        La3:
            boolean r8 = r7.isIconified()
            r7.o(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.f1137d0 = z10;
        o(isIconified());
    }

    public void setSuggestionsAdapter(e1.a aVar) {
        this.f1136c0 = aVar;
        this.A.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.K = new Rect();
        this.L = new Rect();
        this.M = new int[2];
        this.N = new int[2];
        this.f1148o0 = new b();
        this.f1149p0 = new c();
        this.f1150q0 = new WeakHashMap<>();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        i iVar = new i();
        j jVar = new j();
        a aVar = new a();
        int[] iArr = R.styleable.SearchView;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        x0.j0.saveAttributeDataForStyleable(this, context, iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        LayoutInflater.from(context).inflate(c1VarObtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.A = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.B = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.C = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.D = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.E = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.F = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.G = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.H = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.O = imageView5;
        x0.j0.setBackground(viewFindViewById, c1VarObtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        x0.j0.setBackground(viewFindViewById2, c1VarObtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        int i11 = R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(c1VarObtainStyledAttributes.getDrawable(i11));
        imageView2.setImageDrawable(c1VarObtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(c1VarObtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(c1VarObtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(c1VarObtainStyledAttributes.getDrawable(i11));
        this.P = c1VarObtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        f1.setTooltipText(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.Q = c1VarObtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.R = c1VarObtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(aVar);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(gVar);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(c1VarObtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = c1VarObtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.U = c1VarObtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.f1138e0 = c1VarObtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        int i12 = c1VarObtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (i12 != -1) {
            setImeOptions(i12);
        }
        int i13 = c1VarObtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (i13 != -1) {
            setInputType(i13);
        }
        setFocusable(c1VarObtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        c1VarObtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.S = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.T = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.I = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        o(this.f1134a0);
        l();
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.A;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView searchView = SearchView.this;
            Editable text = searchView.A.getText();
            searchView.f1143j0 = text;
            boolean z10 = !TextUtils.isEmpty(text);
            searchView.n(z10);
            boolean z11 = !z10;
            int i13 = 8;
            if (searchView.f1142i0 && !searchView.isIconified() && z11) {
                searchView.F.setVisibility(8);
                i13 = 0;
            }
            searchView.H.setVisibility(i13);
            searchView.j();
            searchView.m();
            charSequence.toString();
            searchView.getClass();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.h(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSuggestionListener(n nVar) {
    }
}
