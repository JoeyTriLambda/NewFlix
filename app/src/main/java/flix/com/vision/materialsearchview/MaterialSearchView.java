package flix.com.vision.materialsearchview;

import ac.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import flix.com.vision.R;
import flix.com.vision.materialsearchview.adapters.CursorSearchAdapter;
import flix.com.vision.materialsearchview.db.HistoryContract;
import flix.com.vision.materialsearchview.utils.AnimationUtils;
import java.util.ArrayList;
import java.util.List;
import m0.a;
import r.m;
import x0.j0;

/* loaded from: classes2.dex */
public class MaterialSearchView extends FrameLayout {
    public static int F = 10;
    public CursorSearchAdapter A;
    public Editable B;
    public OnQueryTextListener C;
    public SearchViewListener D;
    public OnVoiceClickedListener E;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12346b;

    /* renamed from: m, reason: collision with root package name */
    public final Context f12347m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12348n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12349o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12350p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12351q;

    /* renamed from: r, reason: collision with root package name */
    public String f12352r;

    /* renamed from: s, reason: collision with root package name */
    public View f12353s;

    /* renamed from: t, reason: collision with root package name */
    public FrameLayout f12354t;

    /* renamed from: u, reason: collision with root package name */
    public LinearLayout f12355u;

    /* renamed from: v, reason: collision with root package name */
    public EditText f12356v;

    /* renamed from: w, reason: collision with root package name */
    public ImageButton f12357w;

    /* renamed from: x, reason: collision with root package name */
    public ImageButton f12358x;

    /* renamed from: y, reason: collision with root package name */
    public ImageButton f12359y;

    /* renamed from: z, reason: collision with root package name */
    public ListView f12360z;

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnVoiceClickedListener {
        void onVoiceClicked();
    }

    public interface SearchViewListener {
        void onSearchViewClosed();

        void onSearchViewOpened();
    }

    public MaterialSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getAppCompatActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return getResources().getDimensionPixelSize(typedValue.resourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor getHistoryCursor() {
        return this.f12347m.getContentResolver().query(HistoryContract.HistoryEntry.f12373a, null, "is_history = ?", new String[]{"1"}, "insert_date DESC LIMIT " + F);
    }

    public static void setMaxHistoryResults(int i10) {
        F = i10;
    }

    private void setTintColor(int i10) {
        this.f12353s.setBackgroundColor(i10);
    }

    public void activityResumed() {
        c();
    }

    public synchronized void addSuggestions(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("query", str);
            contentValues.put("insert_date", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("is_history", (Integer) 0);
            arrayList.add(contentValues);
        }
        this.f12347m.getContentResolver().bulkInsert(HistoryContract.HistoryEntry.f12373a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
    }

    public void adjustTintAlpha(float f10) {
        if (f10 < 0.0f || f10 > 1.0d) {
            return;
        }
        Drawable background = this.f12353s.getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            if (f10 >= 0.0f) {
                color = Color.argb(Math.round(Color.alpha(color) * f10), Color.red(color), Color.green(color), Color.blue(color));
            }
            this.f12353s.setBackgroundColor(color);
        }
    }

    public final void b(boolean z10) {
        if (z10) {
            if (this.f12347m.getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).size() > 0) {
                this.f12358x.setVisibility(0);
                return;
            }
        }
        this.f12358x.setVisibility(8);
    }

    public final void c() {
        this.A.changeCursor(getHistoryCursor());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f12351q = true;
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        super.clearFocus();
        this.f12356v.clearFocus();
        this.f12351q = false;
    }

    public synchronized void clearHistory() {
        this.f12347m.getContentResolver().delete(HistoryContract.HistoryEntry.f12373a, "is_history = ?", new String[]{"1"});
    }

    public synchronized void clearSuggestions() {
        this.f12347m.getContentResolver().delete(HistoryContract.HistoryEntry.f12373a, "is_history = ?", new String[]{"0"});
    }

    public void closeSearch() {
        if (this.f12346b) {
            this.f12356v.setText("");
            this.f12360z.setVisibility(8);
            clearFocus();
            if (this.f12348n) {
                final FrameLayout frameLayout = this.f12354t;
                AnimationUtils.circleHideView(this.f12355u, new AnimatorListenerAdapter() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.9
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        frameLayout.setVisibility(8);
                    }
                });
            } else {
                this.f12354t.setVisibility(8);
            }
            SearchViewListener searchViewListener = this.D;
            if (searchViewListener != null) {
                searchViewListener.onSearchViewClosed();
            }
            this.f12346b = false;
        }
    }

    public CursorAdapter getAdapter() {
        return this.A;
    }

    public String getCurrentQuery() {
        return !TextUtils.isEmpty(this.B) ? this.B.toString() : "";
    }

    public String getSuggestionAtPosition(int i10) {
        return (i10 < 0 || i10 >= this.A.getCount()) ? "" : this.A.getItem(i10).toString();
    }

    public boolean isOpen() {
        return this.f12346b;
    }

    public void openSearch() {
        if (this.f12346b) {
            return;
        }
        this.f12356v.setText("");
        this.f12356v.requestFocus();
        if (this.f12348n) {
            this.f12354t.setVisibility(0);
            AnimationUtils.circleRevealView(this.f12355u);
        } else {
            this.f12354t.setVisibility(0);
        }
        SearchViewListener searchViewListener = this.D;
        if (searchViewListener != null) {
            searchViewListener.onSearchViewOpened();
        }
        this.f12346b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        return !this.f12351q && isFocusable() && this.f12356v.requestFocus(i10, rect);
    }

    public synchronized void saveQueryToDb(String str, long j10) {
        if (!TextUtils.isEmpty(str) && j10 > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("query", str);
            contentValues.put("insert_date", Long.valueOf(j10));
            contentValues.put("is_history", (Integer) 1);
            this.f12347m.getContentResolver().insert(HistoryContract.HistoryEntry.f12373a, contentValues);
        }
    }

    public void setBackIcon(int i10) {
        this.f12357w.setImageResource(i10);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        this.f12353s.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        setTintColor(i10);
    }

    public void setClearIcon(int i10) {
        this.f12359y.setImageResource(i10);
    }

    public void setCloseOnTintClick(boolean z10) {
        this.f12349o = z10;
    }

    public void setHint(CharSequence charSequence) {
        this.f12356v.setHint(charSequence);
    }

    public void setHintTextColor(int i10) {
        this.f12356v.setHintTextColor(i10);
    }

    public void setInputType(int i10) {
        this.f12356v.setInputType(i10);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f12360z.setOnItemClickListener(onItemClickListener);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f12360z.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.C = onQueryTextListener;
    }

    public void setOnVoiceClickedListener(OnVoiceClickedListener onVoiceClickedListener) {
        this.E = onVoiceClickedListener;
    }

    public void setSearchBarColor(int i10) {
        this.f12356v.setBackgroundColor(i10);
    }

    public void setSearchBarHeight(int i10) {
        this.f12355u.setMinimumHeight(i10);
        this.f12355u.getLayoutParams().height = i10;
    }

    public void setSearchViewListener(SearchViewListener searchViewListener) {
        this.D = searchViewListener;
    }

    public void setShouldAnimate(boolean z10) {
        this.f12348n = z10;
    }

    public void setShouldKeepHistory(boolean z10) {
        this.f12350p = z10;
    }

    public void setSuggestionBackground(int i10) {
        if (i10 > 0) {
            this.f12360z.setBackgroundResource(i10);
        }
    }

    public void setTextColor(int i10) {
        this.f12356v.setTextColor(i10);
    }

    public void setTintAlpha(int i10) {
        if (i10 < 0 || i10 > 255) {
            return;
        }
        Drawable background = this.f12353s.getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            setTintColor(Color.argb(i10, Color.red(color), Color.green(color), Color.blue(color)));
        }
    }

    public void setVoiceHintPrompt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f12352r = this.f12347m.getString(R.string.hint_prompt);
        } else {
            this.f12352r = str;
        }
    }

    public void setVoiceIcon(int i10) {
        this.f12358x.setImageResource(i10);
    }

    public MaterialSearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        this.f12347m = context;
        this.f12348n = true;
        this.f12350p = true;
        LayoutInflater.from(context).inflate(R.layout.search_view, (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.search_layout);
        this.f12354t = frameLayout;
        this.f12353s = frameLayout.findViewById(R.id.transparent_view);
        this.f12355u = (LinearLayout) this.f12354t.findViewById(R.id.search_bar);
        this.f12357w = (ImageButton) this.f12354t.findViewById(R.id.action_back);
        this.f12356v = (EditText) this.f12354t.findViewById(R.id.et_search);
        this.f12358x = (ImageButton) this.f12354t.findViewById(R.id.action_voice);
        this.f12359y = (ImageButton) this.f12354t.findViewById(R.id.action_clear);
        this.f12360z = (ListView) this.f12354t.findViewById(R.id.suggestion_list);
        this.f12357w.setOnClickListener(new View.OnClickListener() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialSearchView.this.closeSearch();
            }
        });
        this.f12358x.setOnClickListener(new View.OnClickListener() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialSearchView materialSearchView = MaterialSearchView.this;
                OnVoiceClickedListener onVoiceClickedListener = materialSearchView.E;
                if (onVoiceClickedListener != null) {
                    onVoiceClickedListener.onVoiceClicked();
                    return;
                }
                Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                intent.putExtra("android.speech.extra.PROMPT", materialSearchView.f12352r);
                intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                intent.putExtra("android.speech.extra.MAX_RESULTS", 1);
                Context context2 = materialSearchView.f12347m;
                if (context2 instanceof Activity) {
                    ((Activity) context2).startActivityForResult(intent, 42);
                }
            }
        });
        this.f12359y.setOnClickListener(new View.OnClickListener() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialSearchView.this.f12356v.setText("");
            }
        });
        this.f12353s.setOnClickListener(new View.OnClickListener() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialSearchView materialSearchView = MaterialSearchView.this;
                if (materialSearchView.f12349o) {
                    materialSearchView.closeSearch();
                }
            }
        });
        b(true);
        this.f12356v.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                MaterialSearchView materialSearchView = MaterialSearchView.this;
                Editable text = materialSearchView.f12356v.getText();
                if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
                    return true;
                }
                OnQueryTextListener onQueryTextListener = materialSearchView.C;
                if (onQueryTextListener != null && onQueryTextListener.onQueryTextSubmit(text.toString())) {
                    return true;
                }
                if (materialSearchView.f12350p) {
                    materialSearchView.saveQueryToDb(text.toString(), System.currentTimeMillis());
                }
                materialSearchView.c();
                materialSearchView.closeSearch();
                materialSearchView.f12356v.setText("");
                return true;
            }
        });
        this.f12356v.addTextChangedListener(new TextWatcher() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                MaterialSearchView materialSearchView = MaterialSearchView.this;
                materialSearchView.A.getFilter().filter(charSequence.toString());
                materialSearchView.A.notifyDataSetChanged();
                Editable text = materialSearchView.f12356v.getText();
                materialSearchView.B = text;
                if (TextUtils.isEmpty(text)) {
                    materialSearchView.f12359y.setVisibility(8);
                    materialSearchView.b(true);
                } else {
                    materialSearchView.b(false);
                    materialSearchView.f12359y.setVisibility(0);
                }
                OnQueryTextListener onQueryTextListener = materialSearchView.C;
                if (onQueryTextListener != null) {
                    onQueryTextListener.onQueryTextChange(charSequence.toString());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.f12356v.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z10) {
                if (z10) {
                    MaterialSearchView materialSearchView = MaterialSearchView.this;
                    EditText editText = materialSearchView.f12356v;
                    materialSearchView.getClass();
                    editText.requestFocus();
                    if (!(materialSearchView.f12347m.getResources().getConfiguration().keyboard != 1)) {
                        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    materialSearchView.f12360z.setVisibility(0);
                }
            }
        });
        CursorSearchAdapter cursorSearchAdapter = new CursorSearchAdapter(context, getHistoryCursor());
        this.A = cursorSearchAdapter;
        cursorSearchAdapter.setFilterQueryProvider(new FilterQueryProvider() { // from class: flix.com.vision.materialsearchview.MaterialSearchView.5
            @Override // android.widget.FilterQueryProvider
            public Cursor runQuery(CharSequence charSequence) {
                String string = charSequence.toString();
                boolean zIsEmpty = string.isEmpty();
                MaterialSearchView materialSearchView = MaterialSearchView.this;
                return zIsEmpty ? materialSearchView.getHistoryCursor() : materialSearchView.f12347m.getContentResolver().query(HistoryContract.HistoryEntry.f12373a, null, "query LIKE ?", new String[]{c.k("%", string, "%")}, "is_history DESC, query");
            }
        });
        this.f12360z.setAdapter((ListAdapter) this.A);
        this.f12360z.setTextFilterEnabled(true);
        m.setCompatVectorFromResourcesEnabled(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialSearchView, i10, 0);
        if (typedArrayObtainStyledAttributes != null) {
            if (typedArrayObtainStyledAttributes.hasValue(6)) {
                setBackground(typedArrayObtainStyledAttributes.getDrawable(6));
            }
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                setTextColor(typedArrayObtainStyledAttributes.getColor(0, a.getColor(context, R.color.black)));
            }
            if (typedArrayObtainStyledAttributes.hasValue(1)) {
                setHintTextColor(typedArrayObtainStyledAttributes.getColor(1, a.getColor(context, R.color.gray_50)));
            }
            if (typedArrayObtainStyledAttributes.hasValue(3)) {
                setHint(typedArrayObtainStyledAttributes.getString(3));
            }
            if (typedArrayObtainStyledAttributes.hasValue(10)) {
                setVoiceIcon(typedArrayObtainStyledAttributes.getResourceId(10, R.drawable.ic_action_voice_search));
            }
            if (typedArrayObtainStyledAttributes.hasValue(8)) {
                setClearIcon(typedArrayObtainStyledAttributes.getResourceId(8, R.drawable.ic_action_navigation_close));
            }
            if (typedArrayObtainStyledAttributes.hasValue(5)) {
                setBackIcon(typedArrayObtainStyledAttributes.getResourceId(5, R.drawable.ic_action_navigation_arrow_back));
            }
            if (typedArrayObtainStyledAttributes.hasValue(9)) {
                setSuggestionBackground(typedArrayObtainStyledAttributes.getResourceId(9, R.color.search_layover_bg));
            }
            if (typedArrayObtainStyledAttributes.hasValue(4)) {
                setInputType(typedArrayObtainStyledAttributes.getInteger(4, 1));
            }
            if (typedArrayObtainStyledAttributes.hasValue(7)) {
                setSearchBarHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(7, getAppCompatActionBarHeight()));
            } else {
                setSearchBarHeight(getAppCompatActionBarHeight());
            }
            if (typedArrayObtainStyledAttributes.hasValue(11)) {
                setVoiceHintPrompt(typedArrayObtainStyledAttributes.getString(11));
            } else {
                setVoiceHintPrompt(context.getString(R.string.hint_prompt));
            }
            j0.setFitsSystemWindows(this, typedArrayObtainStyledAttributes.getBoolean(2, false));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
