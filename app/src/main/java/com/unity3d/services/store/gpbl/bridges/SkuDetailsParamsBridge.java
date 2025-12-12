package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.reflection.GenericBridge;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SkuDetailsParamsBridge extends GenericBridge {
    private static final String newBuilderMethodName = "newBuilder";
    private static final Map<String, Class<?>[]> staticMethods = new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge.1
        {
            put(SkuDetailsParamsBridge.newBuilderMethodName, new Class[0]);
        }
    };
    private final Object _skuDetailsParamsInternalInstance;

    public static class BuilderBridge extends GenericBridge {
        private static final String buildMethodName = "build";
        private static final String setSkusListMethodName = "setSkusList";
        private static final String setTypeMethodName = "setType";
        private Object _skuDetailsParamsBuilderInternalInstance;

        public BuilderBridge(Object obj) {
            super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge.BuilderBridge.1
                {
                    put("build", new Class[0]);
                    put(BuilderBridge.setSkusListMethodName, new Class[]{List.class});
                    put(BuilderBridge.setTypeMethodName, new Class[]{String.class});
                }
            });
            this._skuDetailsParamsBuilderInternalInstance = obj;
        }

        public SkuDetailsParamsBridge build() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
            return new SkuDetailsParamsBridge(callNonVoidMethod("build", this._skuDetailsParamsBuilderInternalInstance, new Object[0]));
        }

        @Override // com.unity3d.services.core.reflection.GenericBridge
        public String getClassName() {
            return "com.android.billingclient.api.SkuDetailsParams$Builder";
        }

        public BuilderBridge setSkuList(List<String> list) {
            this._skuDetailsParamsBuilderInternalInstance = callNonVoidMethod(setSkusListMethodName, this._skuDetailsParamsBuilderInternalInstance, list);
            return this;
        }

        public BuilderBridge setType(String str) {
            this._skuDetailsParamsBuilderInternalInstance = callNonVoidMethod(setTypeMethodName, this._skuDetailsParamsBuilderInternalInstance, str);
            return this;
        }
    }

    public SkuDetailsParamsBridge(Object obj) {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge.2
            {
                put(SkuDetailsParamsBridge.newBuilderMethodName, new Class[0]);
            }
        });
        this._skuDetailsParamsInternalInstance = obj;
    }

    public static Object callNonVoidStaticMethod(String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return getClassForBridge().getMethod(str, staticMethods.get(str)).invoke(null, objArr);
    }

    public static Class<?> getClassForBridge() throws ClassNotFoundException {
        return Class.forName("com.android.billingclient.api.SkuDetailsParams");
    }

    public static BuilderBridge newBuilder() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return new BuilderBridge(callNonVoidStaticMethod(newBuilderMethodName, new Object[0]));
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.android.billingclient.api.SkuDetailsParams";
    }

    public Object getInternalInstance() {
        return this._skuDetailsParamsInternalInstance;
    }
}
