package y0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http2.Http2;
import y0.g;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static int f21816d;

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f21817a;

    /* renamed from: b, reason: collision with root package name */
    public int f21818b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f21819c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f21820e = new a(1, (CharSequence) null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f21821f = new a(2, (CharSequence) null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f21822g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f21823h;

        /* renamed from: i, reason: collision with root package name */
        public static final a f21824i;

        /* renamed from: j, reason: collision with root package name */
        public static final a f21825j;

        /* renamed from: k, reason: collision with root package name */
        public static final a f21826k;

        /* renamed from: l, reason: collision with root package name */
        public static final a f21827l;

        /* renamed from: m, reason: collision with root package name */
        public static final a f21828m;

        /* renamed from: n, reason: collision with root package name */
        public static final a f21829n;

        /* renamed from: o, reason: collision with root package name */
        public static final a f21830o;

        /* renamed from: p, reason: collision with root package name */
        public static final a f21831p;

        /* renamed from: a, reason: collision with root package name */
        public final Object f21832a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21833b;

        /* renamed from: c, reason: collision with root package name */
        public final Class<? extends g.a> f21834c;

        /* renamed from: d, reason: collision with root package name */
        public final g f21835d;

        static {
            new a(4, (CharSequence) null);
            new a(8, (CharSequence) null);
            f21822g = new a(16, (CharSequence) null);
            new a(32, (CharSequence) null);
            new a(64, (CharSequence) null);
            new a(128, (CharSequence) null);
            new a(256, g.b.class);
            new a(512, g.b.class);
            new a(1024, g.c.class);
            new a(2048, g.c.class);
            f21823h = new a(4096, (CharSequence) null);
            f21824i = new a(8192, (CharSequence) null);
            new a(Http2.INITIAL_MAX_FRAME_SIZE, (CharSequence) null);
            new a(32768, (CharSequence) null);
            new a(65536, (CharSequence) null);
            new a(131072, g.C0317g.class);
            f21825j = new a(262144, (CharSequence) null);
            f21826k = new a(524288, (CharSequence) null);
            f21827l = new a(1048576, (CharSequence) null);
            new a(2097152, g.h.class);
            int i10 = Build.VERSION.SDK_INT;
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);
            f21828m = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            f21829n = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            f21830o = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            f21831p = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            new a(i10 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, g.f.class);
            new a(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, g.d.class);
            new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            new a(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            new a(i10 >= 34 ? C0316d.getActionScrollInDirection() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a createReplacementAction(CharSequence charSequence, g gVar) {
            return new a(null, this.f21833b, charSequence, gVar, this.f21834c);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = ((a) obj).f21832a;
            Object obj3 = this.f21832a;
            return obj3 == null ? obj2 == null : obj3.equals(obj2);
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f21832a).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f21832a).getLabel();
        }

        public int hashCode() {
            Object obj = this.f21832a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean perform(View view, Bundle bundle) {
            g gVar = this.f21835d;
            if (gVar == null) {
                return false;
            }
            Class<? extends g.a> cls = this.f21834c;
            g.a aVar = null;
            if (cls != null) {
                try {
                    g.a aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.setBundle(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e10) {
                        e = e10;
                        aVar = aVarNewInstance;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls == null ? "null" : cls.getName()), e);
                        return gVar.perform(view, aVar);
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
            return gVar.perform(view, aVar);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("AccessibilityActionCompat: ");
            String strB = d.b(this.f21833b);
            if (strB.equals("ACTION_UNKNOWN") && getLabel() != null) {
                strB = getLabel().toString();
            }
            sb2.append(strB);
            return sb2.toString();
        }

        public a(int i10, CharSequence charSequence, g gVar) {
            this(null, i10, charSequence, gVar, null);
        }

        public a(int i10, Class cls) {
            this(null, i10, null, null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.f21833b = i10;
            this.f21835d = gVar;
            if (obj == null) {
                this.f21832a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f21832a = obj;
            }
            this.f21834c = cls;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class b {
        public static Object createRangeInfo(int i10, float f10, float f11, float f12) {
            return new AccessibilityNodeInfo.RangeInfo(i10, f10, f11, f12);
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class c {
        public static f buildCollectionItemInfoCompat(boolean z10, int i10, int i11, int i12, int i13, boolean z11, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z10).setColumnIndex(i10).setRowIndex(i11).setColumnSpan(i12).setRowSpan(i13).setSelected(z11).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static d getChild(AccessibilityNodeInfo accessibilityNodeInfo, int i10, int i11) {
            return d.e(accessibilityNodeInfo.getChild(i10, i11));
        }

        public static String getCollectionItemColumnTitle(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static d getParent(AccessibilityNodeInfo accessibilityNodeInfo, int i10) {
            return d.e(accessibilityNodeInfo.getParent(i10));
        }

        public static String getUniqueId(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void setTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setTextSelectable(z10);
        }

        public static void setUniqueId(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: y0.d$d, reason: collision with other inner class name */
    public static class C0316d {
        public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void getBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence getContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z10);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void setContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo, long j10) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j10));
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z10) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z10);
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z10);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Object f21836a;

        public e(AccessibilityNodeInfo.CollectionInfo collectionInfo) {
            this.f21836a = collectionInfo;
        }

        public static e obtain(int i10, int i11, boolean z10, int i12) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }

        public static e obtain(int i10, int i11, boolean z10) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final Object f21837a;

        public f(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
            this.f21837a = collectionItemInfo;
        }

        public static f obtain(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    @Deprecated
    public d(Object obj) {
        this.f21817a = (AccessibilityNodeInfo) obj;
    }

    public static String b(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static d e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            return new d((Object) accessibilityNodeInfo);
        }
        return null;
    }

    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static d obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    public static d wrap(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public final ArrayList a(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void addAction(int i10) {
        this.f21817a.addAction(i10);
    }

    public void addChild(View view) {
        this.f21817a.addChild(view);
    }

    public void addSpansToExtras(CharSequence charSequence, View view) {
        int iKeyAt;
        if (Build.VERSION.SDK_INT < 26) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                    if (((WeakReference) sparseArray.valueAt(i10)).get() == null) {
                        arrayList.add(Integer.valueOf(i10));
                    }
                }
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    sparseArray.remove(((Integer) arrayList.get(i11)).intValue());
                }
            }
            ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans == null || clickableSpans.length <= 0) {
                return;
            }
            getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", androidx.core.R.id.accessibility_action_clickable_span);
            int i12 = androidx.core.R.id.tag_accessibility_clickable_spans;
            SparseArray sparseArray2 = (SparseArray) view.getTag(i12);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                view.setTag(i12, sparseArray2);
            }
            for (int i13 = 0; i13 < clickableSpans.length; i13++) {
                ClickableSpan clickableSpan = clickableSpans[i13];
                int i14 = 0;
                while (true) {
                    if (i14 >= sparseArray2.size()) {
                        iKeyAt = f21816d;
                        f21816d = iKeyAt + 1;
                        break;
                    } else {
                        if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i14)).get())) {
                            iKeyAt = sparseArray2.keyAt(i14);
                            break;
                        }
                        i14++;
                    }
                }
                sparseArray2.put(iKeyAt, new WeakReference(clickableSpans[i13]));
                ClickableSpan clickableSpan2 = clickableSpans[i13];
                Spanned spanned = (Spanned) charSequence;
                a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(iKeyAt));
            }
        }
    }

    public final boolean c(int i10) {
        Bundle extras = getExtras();
        return extras != null && (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10;
    }

    public final void d(int i10, boolean z10) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i11 = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f21817a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f21817a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.f21819c == dVar.f21819c && this.f21818b == dVar.f21818b;
    }

    public List<a> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f21817a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10), 0, null, null, null));
        }
        return arrayList;
    }

    @Deprecated
    public int getActions() {
        return this.f21817a.getActions();
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.f21817a.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.f21817a.getBoundsInScreen(rect);
    }

    public void getBoundsInWindow(Rect rect) {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        if (i10 >= 34) {
            C0316d.getBoundsInWindow(accessibilityNodeInfo, rect);
            return;
        }
        Rect rect2 = (Rect) accessibilityNodeInfo.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public int getChildCount() {
        return this.f21817a.getChildCount();
    }

    public CharSequence getClassName() {
        return this.f21817a.getClassName();
    }

    public CharSequence getContainerTitle() {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        return i10 >= 34 ? C0316d.getContainerTitle(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence getContentDescription() {
        return this.f21817a.getContentDescription();
    }

    public CharSequence getError() {
        return this.f21817a.getError();
    }

    public Bundle getExtras() {
        return this.f21817a.getExtras();
    }

    public int getMaxTextLength() {
        return this.f21817a.getMaxTextLength();
    }

    public CharSequence getPackageName() {
        return this.f21817a.getPackageName();
    }

    public CharSequence getStateDescription() {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        return i10 >= 30 ? b.getStateDescription(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence getText() {
        boolean z10 = !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        if (!z10) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList arrayListA = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList arrayListA2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList arrayListA3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList arrayListA4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i10 = 0; i10 < arrayListA.size(); i10++) {
            spannableString.setSpan(new y0.a(((Integer) arrayListA4.get(i10)).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) arrayListA.get(i10)).intValue(), ((Integer) arrayListA2.get(i10)).intValue(), ((Integer) arrayListA3.get(i10)).intValue());
        }
        return spannableString;
    }

    public CharSequence getTooltipText() {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        return i10 >= 28 ? accessibilityNodeInfo.getTooltipText() : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public String getUniqueId() {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        return i10 >= 33 ? c.getUniqueId(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String getViewIdResourceName() {
        return this.f21817a.getViewIdResourceName();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityDataSensitive() {
        return Build.VERSION.SDK_INT >= 34 ? C0316d.isAccessibilityDataSensitive(this.f21817a) : c(64);
    }

    public boolean isAccessibilityFocused() {
        return this.f21817a.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.f21817a.isCheckable();
    }

    public boolean isChecked() {
        return this.f21817a.isChecked();
    }

    public boolean isClickable() {
        return this.f21817a.isClickable();
    }

    public boolean isContextClickable() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f21817a.isContextClickable();
        }
        return false;
    }

    public boolean isEnabled() {
        return this.f21817a.isEnabled();
    }

    public boolean isFocusable() {
        return this.f21817a.isFocusable();
    }

    public boolean isFocused() {
        return this.f21817a.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return c(67108864);
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f21817a.isImportantForAccessibility();
        }
        return true;
    }

    public boolean isLongClickable() {
        return this.f21817a.isLongClickable();
    }

    public boolean isPassword() {
        return this.f21817a.isPassword();
    }

    public boolean isScrollable() {
        return this.f21817a.isScrollable();
    }

    public boolean isSelected() {
        return this.f21817a.isSelected();
    }

    public boolean isShowingHintText() {
        return Build.VERSION.SDK_INT >= 26 ? this.f21817a.isShowingHintText() : c(4);
    }

    public boolean isTextSelectable() {
        return Build.VERSION.SDK_INT >= 33 ? c.isTextSelectable(this.f21817a) : c(8388608);
    }

    public boolean isVisibleToUser() {
        return this.f21817a.isVisibleToUser();
    }

    public boolean performAction(int i10, Bundle bundle) {
        return this.f21817a.performAction(i10, bundle);
    }

    public boolean removeAction(a aVar) {
        return this.f21817a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f21832a);
    }

    public void setAccessibilityFocused(boolean z10) {
        this.f21817a.setAccessibilityFocused(z10);
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.f21817a.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.f21817a.setBoundsInScreen(rect);
    }

    public void setCheckable(boolean z10) {
        this.f21817a.setCheckable(z10);
    }

    public void setChecked(boolean z10) {
        this.f21817a.setChecked(z10);
    }

    public void setClassName(CharSequence charSequence) {
        this.f21817a.setClassName(charSequence);
    }

    public void setClickable(boolean z10) {
        this.f21817a.setClickable(z10);
    }

    public void setCollectionInfo(Object obj) {
        this.f21817a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f21836a);
    }

    public void setCollectionItemInfo(Object obj) {
        this.f21817a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f21837a);
    }

    public void setContentDescription(CharSequence charSequence) {
        this.f21817a.setContentDescription(charSequence);
    }

    public void setDismissable(boolean z10) {
        this.f21817a.setDismissable(z10);
    }

    public void setEnabled(boolean z10) {
        this.f21817a.setEnabled(z10);
    }

    public void setError(CharSequence charSequence) {
        this.f21817a.setError(charSequence);
    }

    public void setFocusable(boolean z10) {
        this.f21817a.setFocusable(z10);
    }

    public void setFocused(boolean z10) {
        this.f21817a.setFocused(z10);
    }

    public void setHeading(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f21817a.setHeading(z10);
        } else {
            d(2, z10);
        }
    }

    public void setHintText(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        if (i10 >= 26) {
            accessibilityNodeInfo.setHintText(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void setLabelFor(View view) {
        this.f21817a.setLabelFor(view);
    }

    public void setMaxTextLength(int i10) {
        this.f21817a.setMaxTextLength(i10);
    }

    public void setPackageName(CharSequence charSequence) {
        this.f21817a.setPackageName(charSequence);
    }

    public void setPaneTitle(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        if (i10 >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void setParent(View view) {
        this.f21818b = -1;
        this.f21817a.setParent(view);
    }

    public void setRoleDescription(CharSequence charSequence) {
        this.f21817a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public void setScreenReaderFocusable(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f21817a.setScreenReaderFocusable(z10);
        } else {
            d(1, z10);
        }
    }

    public void setScrollable(boolean z10) {
        this.f21817a.setScrollable(z10);
    }

    public void setSelected(boolean z10) {
        this.f21817a.setSelected(z10);
    }

    public void setShowingHintText(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f21817a.setShowingHintText(z10);
        } else {
            d(4, z10);
        }
    }

    public void setSource(View view) {
        this.f21819c = -1;
        this.f21817a.setSource(view);
    }

    public void setStateDescription(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f21817a;
        if (i10 >= 30) {
            b.setStateDescription(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        this.f21817a.setText(charSequence);
    }

    public void setTraversalAfter(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f21817a.setTraversalAfter(view);
        }
    }

    public void setVisibleToUser(boolean z10) {
        this.f21817a.setVisibleToUser(z10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb2.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb2.append("; boundsInScreen: " + rect);
        getBoundsInWindow(rect);
        sb2.append("; boundsInWindow: " + rect);
        sb2.append("; packageName: ");
        sb2.append(getPackageName());
        sb2.append("; className: ");
        sb2.append(getClassName());
        sb2.append("; text: ");
        sb2.append(getText());
        sb2.append("; error: ");
        sb2.append(getError());
        sb2.append("; maxTextLength: ");
        sb2.append(getMaxTextLength());
        sb2.append("; stateDescription: ");
        sb2.append(getStateDescription());
        sb2.append("; contentDescription: ");
        sb2.append(getContentDescription());
        sb2.append("; tooltipText: ");
        sb2.append(getTooltipText());
        sb2.append("; viewIdResName: ");
        sb2.append(getViewIdResourceName());
        sb2.append("; uniqueId: ");
        sb2.append(getUniqueId());
        sb2.append("; checkable: ");
        sb2.append(isCheckable());
        sb2.append("; checked: ");
        sb2.append(isChecked());
        sb2.append("; focusable: ");
        sb2.append(isFocusable());
        sb2.append("; focused: ");
        sb2.append(isFocused());
        sb2.append("; selected: ");
        sb2.append(isSelected());
        sb2.append("; clickable: ");
        sb2.append(isClickable());
        sb2.append("; longClickable: ");
        sb2.append(isLongClickable());
        sb2.append("; contextClickable: ");
        sb2.append(isContextClickable());
        sb2.append("; enabled: ");
        sb2.append(isEnabled());
        sb2.append("; password: ");
        sb2.append(isPassword());
        sb2.append("; scrollable: " + isScrollable());
        sb2.append("; containerTitle: ");
        sb2.append(getContainerTitle());
        sb2.append("; granularScrollingSupported: ");
        sb2.append(isGranularScrollingSupported());
        sb2.append("; importantForAccessibility: ");
        sb2.append(isImportantForAccessibility());
        sb2.append("; visible: ");
        sb2.append(isVisibleToUser());
        sb2.append("; isTextSelectable: ");
        sb2.append(isTextSelectable());
        sb2.append("; accessibilityDataSensitive: ");
        sb2.append(isAccessibilityDataSensitive());
        sb2.append("; [");
        List<a> actionList = getActionList();
        for (int i10 = 0; i10 < actionList.size(); i10++) {
            a aVar = actionList.get(i10);
            String strB = b(aVar.getId());
            if (strB.equals("ACTION_UNKNOWN") && aVar.getLabel() != null) {
                strB = aVar.getLabel().toString();
            }
            sb2.append(strB);
            if (i10 != actionList.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.f21817a;
    }

    public static d obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public void addAction(a aVar) {
        this.f21817a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f21832a);
    }

    public void addChild(View view, int i10) {
        this.f21817a.addChild(view, i10);
    }

    public static d obtain(d dVar) {
        return wrap(AccessibilityNodeInfo.obtain(dVar.f21817a));
    }

    public void setParent(View view, int i10) {
        this.f21818b = i10;
        this.f21817a.setParent(view, i10);
    }

    public void setSource(View view, int i10) {
        this.f21819c = i10;
        this.f21817a.setSource(view, i10);
    }

    public d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f21817a = accessibilityNodeInfo;
    }

    @Deprecated
    public void recycle() {
    }
}
