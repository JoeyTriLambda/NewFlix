package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.m0;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import r.e;
import r.f;
import r.g;
import r.u;
import x0.j0;

/* loaded from: classes.dex */
public final class AlertController {
    public TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final boolean K;
    public final c L;

    /* renamed from: a, reason: collision with root package name */
    public final Context f848a;

    /* renamed from: b, reason: collision with root package name */
    public final u f849b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f850c;

    /* renamed from: d, reason: collision with root package name */
    public final int f851d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f852e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f853f;

    /* renamed from: g, reason: collision with root package name */
    public RecycleListView f854g;

    /* renamed from: h, reason: collision with root package name */
    public View f855h;

    /* renamed from: i, reason: collision with root package name */
    public int f856i;

    /* renamed from: k, reason: collision with root package name */
    public Button f858k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f859l;

    /* renamed from: m, reason: collision with root package name */
    public Message f860m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f861n;

    /* renamed from: o, reason: collision with root package name */
    public Button f862o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f863p;

    /* renamed from: q, reason: collision with root package name */
    public Message f864q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f865r;

    /* renamed from: s, reason: collision with root package name */
    public Button f866s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f867t;

    /* renamed from: u, reason: collision with root package name */
    public Message f868u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f869v;

    /* renamed from: w, reason: collision with root package name */
    public NestedScrollView f870w;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f872y;

    /* renamed from: z, reason: collision with root package name */
    public ImageView f873z;

    /* renamed from: j, reason: collision with root package name */
    public boolean f857j = false;

    /* renamed from: x, reason: collision with root package name */
    public int f871x = 0;
    public int E = -1;
    public final a M = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: b, reason: collision with root package name */
        public final int f874b;

        /* renamed from: m, reason: collision with root package name */
        public final int f875m;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f875m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f874b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f874b, getPaddingRight(), z11 ? getPaddingBottom() : this.f875m);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f858k || (message3 = alertController.f860m) == null) ? (view != alertController.f862o || (message2 = alertController.f864q) == null) ? (view != alertController.f866s || (message = alertController.f868u) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            alertController.L.obtainMessage(1, alertController.f849b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f877a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f878b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f879c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f880d;

        /* renamed from: e, reason: collision with root package name */
        public View f881e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f882f;

        /* renamed from: g, reason: collision with root package name */
        public DialogInterface.OnClickListener f883g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f884h;

        /* renamed from: i, reason: collision with root package name */
        public DialogInterface.OnClickListener f885i;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnDismissListener f887k;

        /* renamed from: l, reason: collision with root package name */
        public DialogInterface.OnKeyListener f888l;

        /* renamed from: m, reason: collision with root package name */
        public CharSequence[] f889m;

        /* renamed from: n, reason: collision with root package name */
        public ListAdapter f890n;

        /* renamed from: o, reason: collision with root package name */
        public DialogInterface.OnClickListener f891o;

        /* renamed from: p, reason: collision with root package name */
        public View f892p;

        /* renamed from: q, reason: collision with root package name */
        public boolean[] f893q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f894r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f895s;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f897u;

        /* renamed from: t, reason: collision with root package name */
        public int f896t = -1;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f886j = true;

        public b(Context context) {
            this.f877a = context;
            this.f878b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void apply(AlertController alertController) {
            ListAdapter dVar;
            View view = this.f881e;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.f880d;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.f879c;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
            }
            CharSequence charSequence2 = this.f882f;
            if (charSequence2 != null) {
                alertController.setButton(-1, charSequence2, this.f883g, null, null);
            }
            CharSequence charSequence3 = this.f884h;
            if (charSequence3 != null) {
                alertController.setButton(-2, charSequence3, this.f885i, null, null);
            }
            if (this.f889m != null || this.f890n != null) {
                RecycleListView recycleListView = (RecycleListView) this.f878b.inflate(alertController.G, (ViewGroup) null);
                if (this.f894r) {
                    dVar = new androidx.appcompat.app.a(this, this.f877a, alertController.H, this.f889m, recycleListView);
                } else {
                    int i10 = this.f895s ? alertController.I : alertController.J;
                    dVar = this.f890n;
                    if (dVar == null) {
                        dVar = new d(this.f877a, i10, android.R.id.text1, this.f889m);
                    }
                }
                alertController.D = dVar;
                alertController.E = this.f896t;
                if (this.f891o != null) {
                    recycleListView.setOnItemClickListener(new androidx.appcompat.app.b(this, alertController));
                } else if (this.f897u != null) {
                    recycleListView.setOnItemClickListener(new androidx.appcompat.app.c(this, recycleListView, alertController));
                }
                if (this.f895s) {
                    recycleListView.setChoiceMode(1);
                } else if (this.f894r) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.f854g = recycleListView;
            }
            View view2 = this.f892p;
            if (view2 != null) {
                alertController.setView(view2);
            }
        }
    }

    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f898a;

        public c(DialogInterface dialogInterface) {
            this.f898a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f898a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, u uVar, Window window) {
        this.f848a = context;
        this.f849b = uVar;
        this.f850c = window;
        this.L = new c(uVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.F = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.G = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.H = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.I = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.K = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f851d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        uVar.supportRequestWindowFeature(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static void c(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup d(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public ListView getListView() {
        return this.f854g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void installContent() {
        int i10;
        int i11;
        View view;
        int i12;
        ListAdapter listAdapter;
        View viewFindViewById;
        this.f849b.setContentView(this.F);
        int i13 = R.id.parentPanel;
        Window window = this.f850c;
        View viewFindViewById2 = window.findViewById(i13);
        int i14 = R.id.topPanel;
        View viewFindViewById3 = viewFindViewById2.findViewById(i14);
        int i15 = R.id.contentPanel;
        View viewFindViewById4 = viewFindViewById2.findViewById(i15);
        int i16 = R.id.buttonPanel;
        View viewFindViewById5 = viewFindViewById2.findViewById(i16);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View viewInflate = this.f855h;
        Context context = this.f848a;
        if (viewInflate == null) {
            viewInflate = this.f856i != 0 ? LayoutInflater.from(context).inflate(this.f856i, viewGroup, false) : null;
        }
        boolean z10 = viewInflate != null;
        if (!z10 || !a(viewInflate)) {
            window.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f857j) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (this.f854g != null) {
                ((LinearLayout.LayoutParams) ((m0.a) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(i14);
        View viewFindViewById7 = viewGroup.findViewById(i15);
        View viewFindViewById8 = viewGroup.findViewById(i16);
        ViewGroup viewGroupD = d(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupD2 = d(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupD3 = d(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        this.f870w = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f870w.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupD2.findViewById(android.R.id.message);
        this.B = textView;
        if (textView != null) {
            CharSequence charSequence = this.f853f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                this.f870w.removeView(this.B);
                if (this.f854g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) this.f870w.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(this.f870w);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(this.f854g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupD2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupD3.findViewById(android.R.id.button1);
        this.f858k = button;
        a aVar = this.M;
        button.setOnClickListener(aVar);
        boolean zIsEmpty = TextUtils.isEmpty(this.f859l);
        int i17 = this.f851d;
        if (zIsEmpty && this.f861n == null) {
            this.f858k.setVisibility(8);
            i10 = 0;
        } else {
            this.f858k.setText(this.f859l);
            Drawable drawable = this.f861n;
            if (drawable != null) {
                drawable.setBounds(0, 0, i17, i17);
                this.f858k.setCompoundDrawables(this.f861n, null, null, null);
            }
            this.f858k.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroupD3.findViewById(android.R.id.button2);
        this.f862o = button2;
        button2.setOnClickListener(aVar);
        if (TextUtils.isEmpty(this.f863p) && this.f865r == null) {
            this.f862o.setVisibility(8);
        } else {
            this.f862o.setText(this.f863p);
            Drawable drawable2 = this.f865r;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i17, i17);
                this.f862o.setCompoundDrawables(this.f865r, null, null, null);
            }
            this.f862o.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroupD3.findViewById(android.R.id.button3);
        this.f866s = button3;
        button3.setOnClickListener(aVar);
        if (TextUtils.isEmpty(this.f867t) && this.f869v == null) {
            this.f866s.setVisibility(8);
            view = null;
        } else {
            this.f866s.setText(this.f867t);
            Drawable drawable3 = this.f869v;
            if (drawable3 != null) {
                i11 = 0;
                drawable3.setBounds(0, 0, i17, i17);
                this.f866s.setCompoundDrawables(this.f869v, null, null, null);
                view = null;
            } else {
                i11 = 0;
                view = null;
            }
            this.f866s.setVisibility(i11);
            i10 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i10 == 1) {
                b(this.f858k);
            } else if (i10 == 2) {
                b(this.f862o);
            } else if (i10 == 4) {
                b(this.f866s);
            }
        }
        if (!(i10 != 0)) {
            viewGroupD3.setVisibility(8);
        }
        if (this.C != null) {
            viewGroupD.addView(this.C, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            this.f873z = (ImageView) window.findViewById(android.R.id.icon);
            if ((!TextUtils.isEmpty(this.f852e)) && this.K) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                this.A = textView2;
                textView2.setText(this.f852e);
                int i18 = this.f871x;
                if (i18 != 0) {
                    this.f873z.setImageResource(i18);
                } else {
                    Drawable drawable4 = this.f872y;
                    if (drawable4 != null) {
                        this.f873z.setImageDrawable(drawable4);
                    } else {
                        this.A.setPadding(this.f873z.getPaddingLeft(), this.f873z.getPaddingTop(), this.f873z.getPaddingRight(), this.f873z.getPaddingBottom());
                        this.f873z.setVisibility(8);
                    }
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                this.f873z.setVisibility(8);
                viewGroupD.setVisibility(8);
            }
        }
        boolean z11 = viewGroup.getVisibility() != 8;
        boolean z12 = (viewGroupD == null || viewGroupD.getVisibility() == 8) ? 0 : 1;
        boolean z13 = viewGroupD3.getVisibility() != 8;
        if (!z13 && (viewFindViewById = viewGroupD2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (z12 != 0) {
            NestedScrollView nestedScrollView2 = this.f870w;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (this.f853f == null && this.f854g == null) ? view : viewGroupD.findViewById(R.id.titleDividerNoCustom);
            i12 = 0;
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            i12 = 0;
            View viewFindViewById10 = viewGroupD2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        RecycleListView recycleListView = this.f854g;
        if (recycleListView instanceof RecycleListView) {
            recycleListView.setHasDecor(z12, z13);
        }
        if (!z11) {
            View view2 = this.f854g;
            if (view2 == null) {
                view2 = this.f870w;
            }
            if (view2 != null) {
                if (z13) {
                    i12 = 2;
                }
                int i19 = z12 | i12;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                if (Build.VERSION.SDK_INT >= 23) {
                    j0.setScrollIndicators(view2, i19, 3);
                    if (viewFindViewById11 != null) {
                        viewGroupD2.removeView(viewFindViewById11);
                    }
                    if (viewFindViewById12 != null) {
                        viewGroupD2.removeView(viewFindViewById12);
                    }
                } else {
                    if (viewFindViewById11 != null && (i19 & 1) == 0) {
                        viewGroupD2.removeView(viewFindViewById11);
                        viewFindViewById11 = view;
                    }
                    if (viewFindViewById12 == null || (i19 & 2) != 0) {
                        view = viewFindViewById12;
                    } else {
                        viewGroupD2.removeView(viewFindViewById12);
                    }
                    if (viewFindViewById11 != null || view != null) {
                        if (this.f853f != null) {
                            this.f870w.setOnScrollChangeListener(new r.d(viewFindViewById11, view));
                            this.f870w.post(new e(this, viewFindViewById11, view));
                        } else {
                            RecycleListView recycleListView2 = this.f854g;
                            if (recycleListView2 != null) {
                                recycleListView2.setOnScrollListener(new f(viewFindViewById11, view));
                                this.f854g.post(new g(this, viewFindViewById11, view));
                            } else {
                                if (viewFindViewById11 != null) {
                                    viewGroupD2.removeView(viewFindViewById11);
                                }
                                if (view != null) {
                                    viewGroupD2.removeView(view);
                                }
                            }
                        }
                    }
                }
            }
        }
        RecycleListView recycleListView3 = this.f854g;
        if (recycleListView3 == null || (listAdapter = this.D) == null) {
            return;
        }
        recycleListView3.setAdapter(listAdapter);
        int i20 = this.E;
        if (i20 > -1) {
            recycleListView3.setItemChecked(i20, true);
            recycleListView3.setSelection(i20);
        }
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f870w;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f870w;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.L.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f867t = charSequence;
            this.f868u = message;
            this.f869v = drawable;
        } else if (i10 == -2) {
            this.f863p = charSequence;
            this.f864q = message;
            this.f865r = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f859l = charSequence;
            this.f860m = message;
            this.f861n = drawable;
        }
    }

    public void setCustomTitle(View view) {
        this.C = view;
    }

    public void setIcon(int i10) {
        this.f872y = null;
        this.f871x = i10;
        ImageView imageView = this.f873z;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f873z.setImageResource(this.f871x);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.f853f = charSequence;
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f852e = charSequence;
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(View view) {
        this.f855h = view;
        this.f856i = 0;
        this.f857j = false;
    }

    public void setIcon(Drawable drawable) {
        this.f872y = drawable;
        this.f871x = 0;
        ImageView imageView = this.f873z;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.f873z.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
