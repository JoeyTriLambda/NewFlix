package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class ConstraintAttribute {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1862a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1863b;

    /* renamed from: c, reason: collision with root package name */
    public final AttributeType f1864c;

    /* renamed from: d, reason: collision with root package name */
    public int f1865d;

    /* renamed from: e, reason: collision with root package name */
    public float f1866e;

    /* renamed from: f, reason: collision with root package name */
    public String f1867f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1868g;

    /* renamed from: h, reason: collision with root package name */
    public int f1869h;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z10) {
        this.f1862a = false;
        this.f1863b = str;
        this.f1864c = attributeType;
        this.f1862a = z10;
        setValue(obj);
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> map, View view) {
        HashMap<String, ConstraintAttribute> map2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            ConstraintAttribute constraintAttribute = map.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return map2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> map) {
        AttributeType attributeType;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        AttributeType attributeType2 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    int i11 = R.styleable.CustomAttribute_customPixelDimension;
                    AttributeType attributeType3 = AttributeType.DIMENSION_TYPE;
                    if (index == i11) {
                        objValueOf2 = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                    } else if (index == R.styleable.CustomAttribute_customDimension) {
                        objValueOf2 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                    } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                        attributeType = AttributeType.FLOAT_TYPE;
                        objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                        attributeType = AttributeType.INT_TYPE;
                        objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    } else if (index == R.styleable.CustomAttribute_customStringValue) {
                        attributeType = AttributeType.STRING_TYPE;
                        objValueOf = typedArrayObtainStyledAttributes.getString(index);
                    } else if (index == R.styleable.CustomAttribute_customReference) {
                        attributeType = AttributeType.REFERENCE_TYPE;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        if (resourceId == -1) {
                            resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        objValueOf = Integer.valueOf(resourceId);
                    }
                    attributeType2 = attributeType3;
                }
                Object obj = objValueOf;
                attributeType2 = attributeType;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            map.put(string, new ConstraintAttribute(string, attributeType2, objValueOf2, z10));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            ConstraintAttribute constraintAttribute = map.get(str);
            String strJ = !constraintAttribute.f1862a ? ac.c.j("set", str) : str;
            try {
                switch (constraintAttribute.f1864c) {
                    case INT_TYPE:
                        cls.getMethod(strJ, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f1865d));
                        break;
                    case FLOAT_TYPE:
                        cls.getMethod(strJ, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f1866e));
                        break;
                    case COLOR_TYPE:
                        cls.getMethod(strJ, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f1869h));
                        break;
                    case COLOR_DRAWABLE_TYPE:
                        Method method = cls.getMethod(strJ, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f1869h);
                        method.invoke(view, colorDrawable);
                        break;
                    case STRING_TYPE:
                        cls.getMethod(strJ, CharSequence.class).invoke(view, constraintAttribute.f1867f);
                        break;
                    case BOOLEAN_TYPE:
                        cls.getMethod(strJ, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f1868g));
                        break;
                    case DIMENSION_TYPE:
                        cls.getMethod(strJ, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f1866e));
                        break;
                    case REFERENCE_TYPE:
                        cls.getMethod(strJ, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f1865d));
                        break;
                }
            } catch (IllegalAccessException e10) {
                StringBuilder sbV = ac.c.v(" Custom Attribute \"", str, "\" not found on ");
                sbV.append(cls.getName());
                Log.e("TransitionLayout", sbV.toString());
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                Log.e("TransitionLayout", e11.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                Log.e("TransitionLayout", cls.getName() + " must have a method " + strJ);
            } catch (InvocationTargetException e12) {
                StringBuilder sbV2 = ac.c.v(" Custom Attribute \"", str, "\" not found on ");
                sbV2.append(cls.getName());
                Log.e("TransitionLayout", sbV2.toString());
                e12.printStackTrace();
            }
        }
    }

    public void setValue(Object obj) {
        switch (this.f1864c) {
            case INT_TYPE:
            case REFERENCE_TYPE:
                this.f1865d = ((Integer) obj).intValue();
                break;
            case FLOAT_TYPE:
                this.f1866e = ((Float) obj).floatValue();
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.f1869h = ((Integer) obj).intValue();
                break;
            case STRING_TYPE:
                this.f1867f = (String) obj;
                break;
            case BOOLEAN_TYPE:
                this.f1868g = ((Boolean) obj).booleanValue();
                break;
            case DIMENSION_TYPE:
                this.f1866e = ((Float) obj).floatValue();
                break;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f1862a = false;
        this.f1863b = constraintAttribute.f1863b;
        this.f1864c = constraintAttribute.f1864c;
        setValue(obj);
    }
}
