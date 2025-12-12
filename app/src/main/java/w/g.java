package w;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.i0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParserException;
import x0.n;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public final class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f20798e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f20799f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f20800a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f20801b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f20802c;

    /* renamed from: d, reason: collision with root package name */
    public Object f20803d;

    /* compiled from: SupportMenuInflater.java */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f20804c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public final Object f20805a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f20806b;

        public a(Object obj, String str) {
            this.f20805a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f20806b = cls.getMethod(str, f20804c);
            } catch (Exception e10) {
                StringBuilder sbV = ac.c.v("Couldn't resolve menu item onClick handler ", str, " in class ");
                sbV.append(cls.getName());
                InflateException inflateException = new InflateException(sbV.toString());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f20806b;
            try {
                Class<?> returnType = method.getReturnType();
                Class<?> cls = Boolean.TYPE;
                Object obj = this.f20805a;
                if (returnType == cls) {
                    return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                }
                method.invoke(obj, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    public class b {
        public CharSequence A;
        public CharSequence B;
        public ColorStateList C = null;
        public PorterDuff.Mode D = null;

        /* renamed from: a, reason: collision with root package name */
        public final Menu f20807a;

        /* renamed from: b, reason: collision with root package name */
        public int f20808b;

        /* renamed from: c, reason: collision with root package name */
        public int f20809c;

        /* renamed from: d, reason: collision with root package name */
        public int f20810d;

        /* renamed from: e, reason: collision with root package name */
        public int f20811e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f20812f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f20813g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20814h;

        /* renamed from: i, reason: collision with root package name */
        public int f20815i;

        /* renamed from: j, reason: collision with root package name */
        public int f20816j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f20817k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f20818l;

        /* renamed from: m, reason: collision with root package name */
        public int f20819m;

        /* renamed from: n, reason: collision with root package name */
        public char f20820n;

        /* renamed from: o, reason: collision with root package name */
        public int f20821o;

        /* renamed from: p, reason: collision with root package name */
        public char f20822p;

        /* renamed from: q, reason: collision with root package name */
        public int f20823q;

        /* renamed from: r, reason: collision with root package name */
        public int f20824r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f20825s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f20826t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f20827u;

        /* renamed from: v, reason: collision with root package name */
        public int f20828v;

        /* renamed from: w, reason: collision with root package name */
        public int f20829w;

        /* renamed from: x, reason: collision with root package name */
        public String f20830x;

        /* renamed from: y, reason: collision with root package name */
        public String f20831y;

        /* renamed from: z, reason: collision with root package name */
        public x0.b f20832z;

        public b(Menu menu) {
            this.f20807a = menu;
            resetGroup();
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f20802c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public void addItem() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f20814h = true;
            b(this.f20807a.add(this.f20808b, this.f20815i, this.f20816j, this.f20817k));
        }

        public SubMenu addSubMenuItem() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f20814h = true;
            SubMenu subMenuAddSubMenu = this.f20807a.addSubMenu(this.f20808b, this.f20815i, this.f20816j, this.f20817k);
            b(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final void b(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z10 = false;
            menuItem.setChecked(this.f20825s).setVisible(this.f20826t).setEnabled(this.f20827u).setCheckable(this.f20824r >= 1).setTitleCondensed(this.f20818l).setIcon(this.f20819m);
            int i10 = this.f20828v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            String str = this.f20831y;
            g gVar = g.this;
            if (str != null) {
                if (gVar.f20802c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                if (gVar.f20803d == null) {
                    gVar.f20803d = g.a(gVar.f20802c);
                }
                menuItem.setOnMenuItemClickListener(new a(gVar.f20803d, this.f20831y));
            }
            if (this.f20824r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof x.c) {
                    ((x.c) menuItem).setExclusiveCheckable(true);
                }
            }
            String str2 = this.f20830x;
            if (str2 != null) {
                menuItem.setActionView((View) a(str2, g.f20798e, gVar.f20800a));
                z10 = true;
            }
            int i11 = this.f20829w;
            if (i11 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            x0.b bVar = this.f20832z;
            if (bVar != null) {
                n.setActionProvider(menuItem, bVar);
            }
            n.setContentDescription(menuItem, this.A);
            n.setTooltipText(menuItem, this.B);
            n.setAlphabeticShortcut(menuItem, this.f20820n, this.f20821o);
            n.setNumericShortcut(menuItem, this.f20822p, this.f20823q);
            PorterDuff.Mode mode = this.D;
            if (mode != null) {
                n.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.C;
            if (colorStateList != null) {
                n.setIconTintList(menuItem, colorStateList);
            }
        }

        public boolean hasAddedItem() {
            return this.f20814h;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f20802c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f20808b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f20809c = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f20810d = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f20811e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f20812f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f20813g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            g gVar = g.this;
            c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(gVar.f20802c, attributeSet, R.styleable.MenuItem);
            this.f20815i = c1VarObtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.f20816j = (c1VarObtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f20809c) & (-65536)) | (c1VarObtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f20810d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f20817k = c1VarObtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.f20818l = c1VarObtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.f20819m = c1VarObtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            String string = c1VarObtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut);
            this.f20820n = string == null ? (char) 0 : string.charAt(0);
            this.f20821o = c1VarObtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            String string2 = c1VarObtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut);
            this.f20822p = string2 == null ? (char) 0 : string2.charAt(0);
            this.f20823q = c1VarObtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            int i10 = R.styleable.MenuItem_android_checkable;
            if (c1VarObtainStyledAttributes.hasValue(i10)) {
                this.f20824r = c1VarObtainStyledAttributes.getBoolean(i10, false) ? 1 : 0;
            } else {
                this.f20824r = this.f20811e;
            }
            this.f20825s = c1VarObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.f20826t = c1VarObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f20812f);
            this.f20827u = c1VarObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f20813g);
            this.f20828v = c1VarObtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.f20831y = c1VarObtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.f20829w = c1VarObtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.f20830x = c1VarObtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            String string3 = c1VarObtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z10 = string3 != null;
            if (z10 && this.f20829w == 0 && this.f20830x == null) {
                this.f20832z = (x0.b) a(string3, g.f20799f, gVar.f20801b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f20832z = null;
            }
            this.A = c1VarObtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.B = c1VarObtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            int i11 = R.styleable.MenuItem_iconTintMode;
            if (c1VarObtainStyledAttributes.hasValue(i11)) {
                this.D = i0.parseTintMode(c1VarObtainStyledAttributes.getInt(i11, -1), this.D);
            } else {
                this.D = null;
            }
            int i12 = R.styleable.MenuItem_iconTint;
            if (c1VarObtainStyledAttributes.hasValue(i12)) {
                this.C = c1VarObtainStyledAttributes.getColorStateList(i12);
            } else {
                this.C = null;
            }
            c1VarObtainStyledAttributes.recycle();
            this.f20814h = false;
        }

        public void resetGroup() {
            this.f20808b = 0;
            this.f20809c = 0;
            this.f20810d = 0;
            this.f20811e = 0;
            this.f20812f = true;
            this.f20813g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f20798e = clsArr;
        f20799f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f20802c = context;
        Object[] objArr = {context};
        this.f20800a = objArr;
        this.f20801b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlResourceParser.getName();
                    if (z11 && name2.equals(str)) {
                        str = null;
                        z11 = false;
                    } else if (name2.equals("group")) {
                        bVar.resetGroup();
                    } else if (name2.equals("item")) {
                        if (!bVar.hasAddedItem()) {
                            x0.b bVar2 = bVar.f20832z;
                            if (bVar2 == null || !bVar2.hasSubMenu()) {
                                bVar.addItem();
                            } else {
                                bVar.addSubMenuItem();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlResourceParser.getName();
                if (name3.equals("group")) {
                    bVar.readGroup(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.readItem(attributeSet);
                } else if (name3.equals("menu")) {
                    b(xmlResourceParser, attributeSet, bVar.addSubMenuItem());
                } else {
                    str = name3;
                    z11 = true;
                }
            }
            eventType = xmlResourceParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof q0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f20802c.getResources().getLayout(i10);
                    b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th2) {
            if (layout != null) {
                layout.close();
            }
            throw th2;
        }
    }
}
