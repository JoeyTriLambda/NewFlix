package com.unity3d.services.core.reflection;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public abstract class GenericBridge {
    private final Map<String, Class<?>[]> _functionAndParameters;
    private boolean _methodMapBuilt = false;
    private final String _className = getClassName();
    private final Map<String, Method> _methodMap = new HashMap();

    public GenericBridge(Map<String, Class<?>[]> map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this._functionAndParameters = map;
        buildMethodMap();
    }

    private void buildMethodMap() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z10 = true;
        for (Map.Entry<String, Class<?>[]> entry : getFunctionMap().entrySet()) {
            Class<?>[] value = entry.getValue();
            try {
                Method reflectiveMethod = getReflectiveMethod(classForName(), entry.getKey(), value);
                if (reflectiveMethod != null) {
                    this._methodMap.put(entry.getKey(), reflectiveMethod);
                }
            } catch (Exception unused) {
                DeviceLog.debug("ERROR: Could not find %s class with method %s and parameters : %s", this._className, entry.getKey(), value);
                z10 = false;
            }
        }
        this._methodMapBuilt = z10;
    }

    private Method getMethod(String str) {
        return this._methodMap.get(str);
    }

    private Method getReflectiveMethod(Class<?> cls, String str, Class<?>... clsArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (Exception e10) {
            DeviceLog.debug("ERROR: Could not find method %s in %s", str, cls.getName() + StringUtils.SPACE + e10.getLocalizedMessage());
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.METHOD_ERROR, new Object[0]);
            return null;
        }
    }

    public <T> T callNonVoidMethod(String str, Object obj, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = getMethod(str);
        if (method == null) {
            DeviceLog.debug("ERROR: Could not find method %s", str);
            return null;
        }
        try {
            return (T) method.invoke(obj, objArr);
        } catch (Exception e10) {
            DeviceLog.debug("ERROR: Could not invoke method %s : %s", str, e10.getLocalizedMessage());
            return null;
        }
    }

    public void callVoidMethod(String str, Object obj, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = getMethod(str);
        if (method == null) {
            DeviceLog.debug("ERROR: Could not find method %s", str);
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (Exception e10) {
            DeviceLog.debug("ERROR: Could not invoke method %s : %s", str, e10.getLocalizedMessage());
        }
    }

    public Class<?> classForName() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            return Class.forName(this._className);
        } catch (ClassNotFoundException e10) {
            DeviceLog.debug("ERROR: Could not find Class %s %s", this._className, e10.getLocalizedMessage());
            return null;
        }
    }

    public boolean exists() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (classForName() == null) {
            DeviceLog.debug("ERROR: Could not find class %s", this._className);
            return false;
        }
        if (!this._methodMapBuilt) {
            buildMethodMap();
        }
        return this._methodMap.size() == getFunctionMap().size();
    }

    public abstract String getClassName();

    public Map<String, Class<?>[]> getFunctionMap() {
        return this._functionAndParameters;
    }
}
