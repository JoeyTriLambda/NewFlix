package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: b, reason: collision with root package name */
    public int[] f1950b;

    /* renamed from: m, reason: collision with root package name */
    public int f1951m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f1952n;

    /* renamed from: o, reason: collision with root package name */
    public g0.b f1953o;

    /* renamed from: p, reason: collision with root package name */
    public String f1954p;

    /* renamed from: q, reason: collision with root package name */
    public String f1955q;

    /* renamed from: r, reason: collision with root package name */
    public View[] f1956r;

    /* renamed from: s, reason: collision with root package name */
    public final HashMap<Integer, String> f1957s;

    public b(Context context) {
        super(context);
        this.f1950b = new int[32];
        this.f1956r = null;
        this.f1957s = new HashMap<>();
        this.f1952n = context;
        init(null);
    }

    public final void a(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        Context context;
        if (str == null || str.length() == 0 || (context = this.f1952n) == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int identifier = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, strTrim);
            if (designInformation instanceof Integer) {
                identifier = ((Integer) designInformation).intValue();
            }
        }
        if (identifier == 0 && constraintLayout != null) {
            identifier = d(constraintLayout, strTrim);
        }
        if (identifier == 0) {
            try {
                identifier = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
        }
        if (identifier != 0) {
            this.f1957s.put(Integer.valueOf(identifier), strTrim);
            b(identifier);
        } else {
            Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
        }
    }

    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f1951m; i10++) {
            View viewById = constraintLayout.getViewById(this.f1950b[i10]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final void b(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f1951m + 1;
        int[] iArr = this.f1950b;
        if (i11 > iArr.length) {
            this.f1950b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1950b;
        int i12 = this.f1951m;
        iArr2[i12] = i10;
        this.f1951m = i12 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f1952n == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.a) && strTrim.equals(((ConstraintLayout.a) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f1952n.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1950b, this.f1951m);
    }

    public View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1956r;
        if (viewArr == null || viewArr.length != this.f1951m) {
            this.f1956r = new View[this.f1951m];
        }
        for (int i10 = 0; i10 < this.f1951m; i10++) {
            this.f1956r[i10] = constraintLayout.getViewById(this.f1950b[i10]);
        }
        return this.f1956r;
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f1954p = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f1955q = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f1954p;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1955q;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f1954p = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f1951m = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                a(str.substring(i10));
                return;
            } else {
                a(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f1955q = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f1951m = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                c(str.substring(i10));
                return;
            } else {
                c(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1954p = null;
        this.f1951m = 0;
        for (int i10 : iArr) {
            b(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f1954p == null) {
            b(i10);
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        HashMap<Integer, String> map;
        String str;
        int iD;
        if (isInEditMode()) {
            setIds(this.f1954p);
        }
        g0.b bVar = this.f1953o;
        if (bVar == null) {
            return;
        }
        bVar.removeAllIds();
        for (int i10 = 0; i10 < this.f1951m; i10++) {
            int i11 = this.f1950b[i10];
            View viewById = constraintLayout.getViewById(i11);
            if (viewById == null && (iD = d(constraintLayout, (str = (map = this.f1957s).get(Integer.valueOf(i11))))) != 0) {
                this.f1950b[i10] = iD;
                map.put(Integer.valueOf(iD), str);
                viewById = constraintLayout.getViewById(iD);
            }
            if (viewById != null) {
                this.f1953o.add(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f1953o.updateConstraints(constraintLayout.f1881n);
    }

    public void validateParams() {
        if (this.f1953o == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).f1927q0 = this.f1953o;
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1950b = new int[32];
        this.f1956r = null;
        this.f1957s = new HashMap<>();
        this.f1952n = context;
        init(attributeSet);
    }

    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((ConstraintLayout) parent);
    }

    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
    }
}
