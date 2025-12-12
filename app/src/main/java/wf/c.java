package wf;

import com.unity3d.ads.metadata.MediationMetaData;
import java.io.File;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.ClassUtils;
import zf.i;

/* compiled from: Utils.kt */
/* loaded from: classes2.dex */
public class c extends b {
    public static final String getExtension(File file) {
        i.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        i.checkNotNullExpressionValue(name, MediationMetaData.KEY_NAME);
        return StringsKt__StringsKt.substringAfterLast(name, ClassUtils.PACKAGE_SEPARATOR_CHAR, "");
    }
}
