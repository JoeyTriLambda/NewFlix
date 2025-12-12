package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class AnnotatedCreatorCollector extends CollectorBase {
    private AnnotatedConstructor _defaultConstructor;
    private final TypeResolutionContext _typeContext;

    public AnnotatedCreatorCollector(AnnotationIntrospector annotationIntrospector, TypeResolutionContext typeResolutionContext) {
        super(annotationIntrospector);
        this._typeContext = typeResolutionContext;
    }

    private List<AnnotatedConstructor> _findPotentialConstructors(JavaType javaType, Class<?> cls) throws SecurityException {
        ClassUtil.Ctor ctor;
        ArrayList arrayList;
        int i10;
        List<AnnotatedConstructor> listEmptyList;
        if (javaType.isEnumType()) {
            ctor = null;
            arrayList = null;
        } else {
            ctor = null;
            arrayList = null;
            for (ClassUtil.Ctor ctor2 : ClassUtil.getConstructors(javaType.getRawClass())) {
                if (isIncludableConstructor(ctor2.getConstructor())) {
                    if (ctor2.getParamCount() == 0) {
                        ctor = ctor2;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(ctor2);
                    }
                }
            }
        }
        if (arrayList == null) {
            listEmptyList = Collections.emptyList();
            if (ctor == null) {
                return listEmptyList;
            }
            i10 = 0;
        } else {
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i11 = 0; i11 < size; i11++) {
                arrayList2.add(null);
            }
            i10 = size;
            listEmptyList = arrayList2;
        }
        if (cls != null) {
            MemberKey[] memberKeyArr = null;
            for (ClassUtil.Ctor ctor3 : ClassUtil.getConstructors(cls)) {
                if (ctor3.getParamCount() == 0) {
                    if (ctor != null) {
                        this._defaultConstructor = constructDefaultConstructor(ctor, ctor3);
                        ctor = null;
                    }
                } else if (arrayList != null) {
                    if (memberKeyArr == null) {
                        memberKeyArr = new MemberKey[i10];
                        for (int i12 = 0; i12 < i10; i12++) {
                            memberKeyArr[i12] = new MemberKey(((ClassUtil.Ctor) arrayList.get(i12)).getConstructor());
                        }
                    }
                    MemberKey memberKey = new MemberKey(ctor3.getConstructor());
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i10) {
                            break;
                        }
                        if (memberKey.equals(memberKeyArr[i13])) {
                            listEmptyList.set(i13, constructNonDefaultConstructor((ClassUtil.Ctor) arrayList.get(i13), ctor3));
                            break;
                        }
                        i13++;
                    }
                }
            }
        }
        if (ctor != null) {
            this._defaultConstructor = constructDefaultConstructor(ctor, null);
        }
        for (int i14 = 0; i14 < i10; i14++) {
            if (listEmptyList.get(i14) == null) {
                listEmptyList.set(i14, constructNonDefaultConstructor((ClassUtil.Ctor) arrayList.get(i14), null));
            }
        }
        return listEmptyList;
    }

    private List<AnnotatedMethod> _findPotentialFactories(JavaType javaType, Class<?> cls) {
        ArrayList arrayList = null;
        for (Method method : ClassUtil.getClassMethods(javaType.getRawClass())) {
            if (Modifier.isStatic(method.getModifiers())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(method);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(null);
        }
        if (cls != null) {
            MemberKey[] memberKeyArr = null;
            for (Method method2 : ClassUtil.getDeclaredMethods(cls)) {
                if (Modifier.isStatic(method2.getModifiers())) {
                    if (memberKeyArr == null) {
                        memberKeyArr = new MemberKey[size];
                        for (int i11 = 0; i11 < size; i11++) {
                            memberKeyArr[i11] = new MemberKey((Method) arrayList.get(i11));
                        }
                    }
                    MemberKey memberKey = new MemberKey(method2);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size) {
                            break;
                        }
                        if (memberKey.equals(memberKeyArr[i12])) {
                            arrayList2.set(i12, constructFactoryCreator((Method) arrayList.get(i12), method2));
                            break;
                        }
                        i12++;
                    }
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            if (((AnnotatedMethod) arrayList2.get(i13)) == null) {
                arrayList2.set(i13, constructFactoryCreator((Method) arrayList.get(i13), null));
            }
        }
        return arrayList2;
    }

    private AnnotationMap[] collectAnnotations(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        int length = annotationArr.length;
        AnnotationMap[] annotationMapArr = new AnnotationMap[length];
        for (int i10 = 0; i10 < length; i10++) {
            AnnotationCollector annotationCollectorCollectAnnotations = collectAnnotations(AnnotationCollector.emptyCollector(), annotationArr[i10]);
            if (annotationArr2 != null) {
                annotationCollectorCollectAnnotations = collectAnnotations(annotationCollectorCollectAnnotations, annotationArr2[i10]);
            }
            annotationMapArr[i10] = annotationCollectorCollectAnnotations.asAnnotationMap();
        }
        return annotationMapArr;
    }

    public static AnnotatedClass.Creators collectCreators(AnnotationIntrospector annotationIntrospector, TypeResolutionContext typeResolutionContext, JavaType javaType, Class<?> cls) {
        return new AnnotatedCreatorCollector(annotationIntrospector, typeResolutionContext).collect(javaType, cls);
    }

    private static boolean isIncludableConstructor(Constructor<?> constructor) {
        return !constructor.isSynthetic();
    }

    public AnnotatedClass.Creators collect(JavaType javaType, Class<?> cls) throws SecurityException {
        List<AnnotatedConstructor> list_findPotentialConstructors = _findPotentialConstructors(javaType, cls);
        List<AnnotatedMethod> list_findPotentialFactories = _findPotentialFactories(javaType, cls);
        AnnotationIntrospector annotationIntrospector = this._intr;
        if (annotationIntrospector != null) {
            AnnotatedConstructor annotatedConstructor = this._defaultConstructor;
            if (annotatedConstructor != null && annotationIntrospector.hasIgnoreMarker(annotatedConstructor)) {
                this._defaultConstructor = null;
            }
            int size = list_findPotentialConstructors.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                if (this._intr.hasIgnoreMarker(list_findPotentialConstructors.get(size))) {
                    list_findPotentialConstructors.remove(size);
                }
            }
            int size2 = list_findPotentialFactories.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    break;
                }
                if (this._intr.hasIgnoreMarker(list_findPotentialFactories.get(size2))) {
                    list_findPotentialFactories.remove(size2);
                }
            }
        }
        return new AnnotatedClass.Creators(this._defaultConstructor, list_findPotentialConstructors, list_findPotentialFactories);
    }

    public AnnotatedConstructor constructDefaultConstructor(ClassUtil.Ctor ctor, ClassUtil.Ctor ctor2) {
        return this._intr == null ? new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), CollectorBase._emptyAnnotationMap(), CollectorBase.NO_ANNOTATION_MAPS) : new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), collectAnnotations(ctor, ctor2), CollectorBase.NO_ANNOTATION_MAPS);
    }

    public AnnotatedMethod constructFactoryCreator(Method method, Method method2) {
        int length = method.getParameterTypes().length;
        if (this._intr == null) {
            return new AnnotatedMethod(this._typeContext, method, CollectorBase._emptyAnnotationMap(), CollectorBase._emptyAnnotationMaps(length));
        }
        if (length == 0) {
            return new AnnotatedMethod(this._typeContext, method, collectAnnotations(method, method2), CollectorBase.NO_ANNOTATION_MAPS);
        }
        return new AnnotatedMethod(this._typeContext, method, collectAnnotations(method, method2), collectAnnotations(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.databind.introspect.AnnotatedConstructor constructNonDefaultConstructor(com.fasterxml.jackson.databind.util.ClassUtil.Ctor r9, com.fasterxml.jackson.databind.util.ClassUtil.Ctor r10) {
        /*
            r8 = this;
            int r0 = r9.getParamCount()
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r8._intr
            if (r1 != 0) goto L1c
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r10 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            com.fasterxml.jackson.databind.introspect.TypeResolutionContext r1 = r8._typeContext
            java.lang.reflect.Constructor r9 = r9.getConstructor()
            com.fasterxml.jackson.databind.introspect.AnnotationMap r2 = com.fasterxml.jackson.databind.introspect.CollectorBase._emptyAnnotationMap()
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r0 = com.fasterxml.jackson.databind.introspect.CollectorBase._emptyAnnotationMaps(r0)
            r10.<init>(r1, r9, r2, r0)
            return r10
        L1c:
            if (r0 != 0) goto L30
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            com.fasterxml.jackson.databind.introspect.TypeResolutionContext r1 = r8._typeContext
            java.lang.reflect.Constructor r2 = r9.getConstructor()
            com.fasterxml.jackson.databind.introspect.AnnotationMap r9 = r8.collectAnnotations(r9, r10)
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r10 = com.fasterxml.jackson.databind.introspect.CollectorBase.NO_ANNOTATION_MAPS
            r0.<init>(r1, r2, r9, r10)
            return r0
        L30:
            java.lang.annotation.Annotation[][] r1 = r9.getParameterAnnotations()
            int r2 = r1.length
            r3 = 0
            if (r0 == r2) goto L9b
            java.lang.Class r2 = r9.getDeclaringClass()
            boolean r4 = com.fasterxml.jackson.databind.util.ClassUtil.isEnumType(r2)
            r5 = 0
            r6 = 1
            r7 = 2
            if (r4 == 0) goto L57
            int r4 = r1.length
            int r4 = r4 + r7
            if (r0 != r4) goto L57
            int r2 = r1.length
            int r2 = r2 + r7
            java.lang.annotation.Annotation[][] r2 = new java.lang.annotation.Annotation[r2][]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r5, r2, r7, r4)
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r3 = r8.collectAnnotations(r2, r3)
        L55:
            r1 = r2
            goto L72
        L57:
            boolean r2 = r2.isMemberClass()
            if (r2 == 0) goto L72
            int r2 = r1.length
            int r2 = r2 + r6
            if (r0 != r2) goto L72
            int r2 = r1.length
            int r2 = r2 + r6
            java.lang.annotation.Annotation[][] r2 = new java.lang.annotation.Annotation[r2][]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r5, r2, r6, r4)
            java.lang.annotation.Annotation[] r1 = com.fasterxml.jackson.databind.introspect.CollectorBase.NO_ANNOTATIONS
            r2[r5] = r1
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r3 = r8.collectAnnotations(r2, r3)
            goto L55
        L72:
            if (r3 == 0) goto L75
            goto La6
        L75:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Class r9 = r9.getDeclaringClass()
            java.lang.String r9 = r9.getName()
            r2[r5] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r2[r6] = r9
            int r9 = r1.length
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r2[r7] = r9
            java.lang.String r9 = "Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations"
            java.lang.String r9 = java.lang.String.format(r9, r2)
            r10.<init>(r9)
            throw r10
        L9b:
            if (r10 != 0) goto L9e
            goto La2
        L9e:
            java.lang.annotation.Annotation[][] r3 = r10.getParameterAnnotations()
        La2:
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r3 = r8.collectAnnotations(r1, r3)
        La6:
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            com.fasterxml.jackson.databind.introspect.TypeResolutionContext r1 = r8._typeContext
            java.lang.reflect.Constructor r2 = r9.getConstructor()
            com.fasterxml.jackson.databind.introspect.AnnotationMap r9 = r8.collectAnnotations(r9, r10)
            r0.<init>(r1, r2, r9, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.AnnotatedCreatorCollector.constructNonDefaultConstructor(com.fasterxml.jackson.databind.util.ClassUtil$Ctor, com.fasterxml.jackson.databind.util.ClassUtil$Ctor):com.fasterxml.jackson.databind.introspect.AnnotatedConstructor");
    }

    private AnnotationMap collectAnnotations(ClassUtil.Ctor ctor, ClassUtil.Ctor ctor2) {
        AnnotationCollector annotationCollectorCollectAnnotations = collectAnnotations(ctor.getConstructor().getDeclaredAnnotations());
        if (ctor2 != null) {
            annotationCollectorCollectAnnotations = collectAnnotations(annotationCollectorCollectAnnotations, ctor2.getConstructor().getDeclaredAnnotations());
        }
        return annotationCollectorCollectAnnotations.asAnnotationMap();
    }

    private final AnnotationMap collectAnnotations(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        AnnotationCollector annotationCollectorCollectAnnotations = collectAnnotations(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            annotationCollectorCollectAnnotations = collectAnnotations(annotationCollectorCollectAnnotations, annotatedElement2.getDeclaredAnnotations());
        }
        return annotationCollectorCollectAnnotations.asAnnotationMap();
    }
}
