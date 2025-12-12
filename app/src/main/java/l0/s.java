package l0;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public final class s {
    public static Bundle[] a(y[] yVarArr) {
        if (yVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[yVarArr.length];
        for (int i10 = 0; i10 < yVarArr.length; i10++) {
            y yVar = yVarArr[i10];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", yVar.getResultKey());
            bundle.putCharSequence("label", yVar.getLabel());
            bundle.putCharSequenceArray("choices", yVar.getChoices());
            bundle.putBoolean("allowFreeFormInput", yVar.getAllowFreeFormInput());
            bundle.putBundle("extras", yVar.getExtras());
            Set<String> allowedDataTypes = yVar.getAllowedDataTypes();
            if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
                Iterator<String> it = allowedDataTypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i10] = bundle;
        }
        return bundleArr;
    }
}
