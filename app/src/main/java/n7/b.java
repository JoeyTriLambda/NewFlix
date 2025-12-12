package n7;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* compiled from: MaterialAttributes.java */
/* loaded from: classes.dex */
public final class b {
    public static TypedValue resolve(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i10, boolean z10) {
        TypedValue typedValueResolve = resolve(context, i10);
        return (typedValueResolve == null || typedValueResolve.type != 18) ? z10 : typedValueResolve.data != 0;
    }

    public static int resolveInteger(Context context, int i10, int i11) {
        TypedValue typedValueResolve = resolve(context, i10);
        return (typedValueResolve == null || typedValueResolve.type != 16) ? i11 : typedValueResolve.data;
    }

    public static int resolveOrThrow(Context context, int i10, String str) {
        return resolveTypedValueOrThrow(context, i10, str).data;
    }

    public static TypedValue resolveTypedValueOrThrow(View view, int i10) {
        return resolveTypedValueOrThrow(view.getContext(), i10, view.getClass().getCanonicalName());
    }

    public static TypedValue resolveTypedValueOrThrow(Context context, int i10, String str) {
        TypedValue typedValueResolve = resolve(context, i10);
        if (typedValueResolve != null) {
            return typedValueResolve;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i10)));
    }
}
