package v2;

import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* compiled from: WebMessageAdapter.java */
/* loaded from: classes.dex */
public final class i implements WebMessageBoundaryInterface {
    public static u2.c webMessageCompatFromBoundaryInterface(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        InvocationHandler[] ports = webMessageBoundaryInterface.getPorts();
        u2.d[] dVarArr = new u2.d[ports.length];
        for (int i10 = 0; i10 < ports.length; i10++) {
            dVarArr[i10] = new k(ports[i10]);
        }
        if (!l.f20439a.isSupportedByWebView()) {
            return new u2.c(webMessageBoundaryInterface.getData(), dVarArr);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new u2.c(webMessagePayloadBoundaryInterface.getAsString(), dVarArr);
        }
        if (type != 1) {
            return null;
        }
        return new u2.c(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), dVarArr);
    }
}
