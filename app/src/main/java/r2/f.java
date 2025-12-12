package r2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.IOException;
import java.util.ArrayList;
import o0.d;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatorInflaterCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* compiled from: AnimatorInflaterCompat.java */
    public static class a implements TypeEvaluator<d.a[]> {

        /* renamed from: a, reason: collision with root package name */
        public d.a[] f18381a;

        @Override // android.animation.TypeEvaluator
        public d.a[] evaluate(float f10, d.a[] aVarArr, d.a[] aVarArr2) {
            if (!o0.d.canMorph(aVarArr, aVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!o0.d.canMorph(this.f18381a, aVarArr)) {
                this.f18381a = o0.d.deepCopyNodes(aVarArr);
            }
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                this.f18381a[i10].interpolatePathDataNode(aVarArr[i10], aVarArr2[i10], f10);
            }
            return this.f18381a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x0326, code lost:
    
        if (r33 == null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0328, code lost:
    
        if (r14 == null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x032a, code lost:
    
        r1 = new android.animation.Animator[r14.size()];
        r2 = r14.iterator();
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0339, code lost:
    
        if (r2.hasNext() == false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x033b, code lost:
    
        r1[r15] = (android.animation.Animator) r2.next();
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0347, code lost:
    
        if (r34 != 0) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0349, code lost:
    
        r33.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x034d, code lost:
    
        r33.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0350, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.animation.Animator a(android.content.Context r28, android.content.res.Resources r29, android.content.res.Resources.Theme r30, android.content.res.XmlResourceParser r31, android.util.AttributeSet r32, android.animation.AnimatorSet r33, int r34, float r35) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 849
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.f.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.content.res.XmlResourceParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Keyframe b(Keyframe keyframe, float f10) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f10) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f10) : Keyframe.ofObject(f10);
    }

    public static PropertyValuesHolder c(TypedArray typedArray, int i10, int i11, int i12, String str) {
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i11);
        boolean z10 = typedValuePeekValue != null;
        int i13 = z10 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i12);
        boolean z11 = typedValuePeekValue2 != null;
        int i14 = z11 ? typedValuePeekValue2.type : 0;
        if (i10 == 4) {
            i10 = ((z10 && d(i13)) || (z11 && d(i14))) ? 3 : 0;
        }
        boolean z12 = i10 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i10 != 2) {
            g gVar = i10 == 3 ? g.getInstance() : null;
            if (z12) {
                if (z10) {
                    float dimension = i13 == 5 ? typedArray.getDimension(i11, 0.0f) : typedArray.getFloat(i11, 0.0f);
                    if (z11) {
                        propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i14 == 5 ? typedArray.getDimension(i12, 0.0f) : typedArray.getFloat(i12, 0.0f));
                    } else {
                        propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i14 == 5 ? typedArray.getDimension(i12, 0.0f) : typedArray.getFloat(i12, 0.0f));
                }
                propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
            } else if (z10) {
                int dimension2 = i13 == 5 ? (int) typedArray.getDimension(i11, 0.0f) : d(i13) ? typedArray.getColor(i11, 0) : typedArray.getInt(i11, 0);
                if (z11) {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2, i14 == 5 ? (int) typedArray.getDimension(i12, 0.0f) : d(i14) ? typedArray.getColor(i12, 0) : typedArray.getInt(i12, 0));
                } else {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else if (z11) {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, i14 == 5 ? (int) typedArray.getDimension(i12, 0.0f) : d(i14) ? typedArray.getColor(i12, 0) : typedArray.getInt(i12, 0));
            }
            if (propertyValuesHolderOfInt == null || gVar == null) {
                return propertyValuesHolderOfInt;
            }
            propertyValuesHolderOfInt.setEvaluator(gVar);
            return propertyValuesHolderOfInt;
        }
        String string = typedArray.getString(i11);
        String string2 = typedArray.getString(i12);
        d.a[] aVarArrCreateNodesFromPathData = o0.d.createNodesFromPathData(string);
        d.a[] aVarArrCreateNodesFromPathData2 = o0.d.createNodesFromPathData(string2);
        if (aVarArrCreateNodesFromPathData == null && aVarArrCreateNodesFromPathData2 == null) {
            return null;
        }
        if (aVarArrCreateNodesFromPathData == null) {
            if (aVarArrCreateNodesFromPathData2 != null) {
                return PropertyValuesHolder.ofObject(str, new a(), aVarArrCreateNodesFromPathData2);
            }
            return null;
        }
        a aVar = new a();
        if (aVarArrCreateNodesFromPathData2 == null) {
            propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, aVarArrCreateNodesFromPathData);
        } else {
            if (!o0.d.canMorph(aVarArrCreateNodesFromPathData, aVarArrCreateNodesFromPathData2)) {
                throw new InflateException(" Can't morph from " + string + " to " + string2);
            }
            propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, aVarArrCreateNodesFromPathData, aVarArrCreateNodesFromPathData2);
        }
        return propertyValuesHolderOfObject;
    }

    public static boolean d(int i10) {
        return i10 >= 28 && i10 <= 31;
    }

    public static ValueAnimator e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, float f10, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        ValueAnimator valueAnimator;
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        TypedArray typedArrayObtainAttributes = n0.i.obtainAttributes(resources, theme, attributeSet, r2.a.f18361g);
        TypedArray typedArrayObtainAttributes2 = n0.i.obtainAttributes(resources, theme, attributeSet, r2.a.f18365k);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long namedInt = n0.i.getNamedInt(typedArrayObtainAttributes, xmlResourceParser, "duration", 1, HttpStatus.SC_MULTIPLE_CHOICES);
        int i10 = 0;
        long namedInt2 = n0.i.getNamedInt(typedArrayObtainAttributes, xmlResourceParser, "startOffset", 2, 0);
        int namedInt3 = n0.i.getNamedInt(typedArrayObtainAttributes, xmlResourceParser, "valueType", 7, 4);
        if (n0.i.hasAttribute(xmlResourceParser, "valueFrom") && n0.i.hasAttribute(xmlResourceParser, "valueTo")) {
            if (namedInt3 == 4) {
                TypedValue typedValuePeekValue = typedArrayObtainAttributes.peekValue(5);
                boolean z10 = typedValuePeekValue != null;
                int i11 = z10 ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayObtainAttributes.peekValue(6);
                boolean z11 = typedValuePeekValue2 != null;
                namedInt3 = ((z10 && d(i11)) || (z11 && d(z11 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder propertyValuesHolderC = c(typedArrayObtainAttributes, namedInt3, 5, 6, "");
            if (propertyValuesHolderC != null) {
                valueAnimator3.setValues(propertyValuesHolderC);
            }
        }
        valueAnimator3.setDuration(namedInt);
        valueAnimator3.setStartDelay(namedInt2);
        valueAnimator3.setRepeatCount(n0.i.getNamedInt(typedArrayObtainAttributes, xmlResourceParser, "repeatCount", 3, 0));
        valueAnimator3.setRepeatMode(n0.i.getNamedInt(typedArrayObtainAttributes, xmlResourceParser, "repeatMode", 4, 1));
        if (typedArrayObtainAttributes2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String namedString = n0.i.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "pathData", 1);
            if (namedString != null) {
                String namedString2 = n0.i.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "propertyXName", 2);
                String namedString3 = n0.i.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "propertyYName", 3);
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(typedArrayObtainAttributes2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path pathCreatePathFromPathData = o0.d.createPathFromPathData(namedString);
                float f11 = 0.5f * f10;
                PathMeasure pathMeasure = new PathMeasure(pathCreatePathFromPathData, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float length = 0.0f;
                do {
                    length += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(length));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(pathCreatePathFromPathData, false);
                int iMin = Math.min(100, ((int) (length / f11)) + 1);
                float[] fArr = new float[iMin];
                float[] fArr2 = new float[iMin];
                float[] fArr3 = new float[2];
                float f12 = length / (iMin - 1);
                valueAnimator = valueAnimator3;
                typedArray = typedArrayObtainAttributes;
                int i12 = 0;
                float f13 = 0.0f;
                while (true) {
                    if (i10 >= iMin) {
                        break;
                    }
                    int i13 = iMin;
                    pathMeasure2.getPosTan(f13 - ((Float) arrayList.get(i12)).floatValue(), fArr3, null);
                    fArr[i10] = fArr3[0];
                    fArr2[i10] = fArr3[1];
                    f13 += f12;
                    int i14 = i12 + 1;
                    if (i14 < arrayList.size() && f13 > ((Float) arrayList.get(i14)).floatValue()) {
                        pathMeasure2.nextContour();
                        i12 = i14;
                    }
                    i10++;
                    iMin = i13;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = namedString2 != null ? PropertyValuesHolder.ofFloat(namedString2, fArr) : null;
                PropertyValuesHolder propertyValuesHolderOfFloat2 = namedString3 != null ? PropertyValuesHolder.ofFloat(namedString3, fArr2) : null;
                if (propertyValuesHolderOfFloat == null) {
                    i10 = 0;
                    objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                } else {
                    i10 = 0;
                    if (propertyValuesHolderOfFloat2 == null) {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat);
                    } else {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                    }
                }
            } else {
                valueAnimator = valueAnimator3;
                typedArray = typedArrayObtainAttributes;
                objectAnimator2.setPropertyName(n0.i.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
            typedArray = typedArrayObtainAttributes;
        }
        TypedArray typedArray2 = typedArray;
        int namedResourceId = n0.i.getNamedResourceId(typedArray2, xmlResourceParser, "interpolator", i10, i10);
        if (namedResourceId > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(e.loadInterpolator(context, namedResourceId));
        } else {
            valueAnimator2 = valueAnimator;
        }
        typedArray2.recycle();
        if (typedArrayObtainAttributes2 != null) {
            typedArrayObtainAttributes2.recycle();
        }
        return valueAnimator2;
    }

    public static Animator loadAnimator(Context context, int i10) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i10) : loadAnimator(context, context.getResources(), context.getTheme(), i10);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i10) throws Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i10, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i10, float f10) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i10);
                    Animator animatorA = a(context, resources, theme, animation, Xml.asAttributeSet(animation), null, 0, f10);
                    animation.close();
                    return animatorA;
                } catch (IOException e10) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i10));
                    notFoundException.initCause(e10);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e11) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i10));
                notFoundException2.initCause(e11);
                throw notFoundException2;
            }
        } catch (Throwable th2) {
            if (animation != null) {
                animation.close();
            }
            throw th2;
        }
    }
}
