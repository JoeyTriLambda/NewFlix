package l0;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class y {

    /* compiled from: RemoteInput.java */
    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static Bundle b(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }

        public static RemoteInput fromCompat(y yVar) {
            Set<String> allowedDataTypes;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(yVar.getResultKey()).setLabel(yVar.getLabel()).setChoices(yVar.getChoices()).setAllowFreeFormInput(yVar.getAllowFreeFormInput()).addExtras(yVar.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = yVar.getAllowedDataTypes()) != null) {
                Iterator<String> it = allowedDataTypes.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, yVar.getEditChoicesBeforeSending());
            }
            return builderAddExtras.build();
        }
    }

    /* compiled from: RemoteInput.java */
    public static class b {
        public static void a(y yVar, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(a.fromCompat(yVar), intent, map);
        }

        public static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        public static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z10) {
            return builder.setAllowDataType(str, z10);
        }
    }

    /* compiled from: RemoteInput.java */
    public static class c {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i10) {
            return builder.setEditChoicesBeforeSending(i10);
        }
    }

    public boolean getAllowFreeFormInput() {
        return false;
    }

    public Set<String> getAllowedDataTypes() {
        return null;
    }

    public CharSequence[] getChoices() {
        return null;
    }

    public int getEditChoicesBeforeSending() {
        return 0;
    }

    public Bundle getExtras() {
        return null;
    }

    public CharSequence getLabel() {
        return null;
    }

    public String getResultKey() {
        return null;
    }

    public boolean isDataOnly() {
        return (getAllowFreeFormInput() || (getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }
}
