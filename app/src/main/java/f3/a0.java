package f3;

import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import w2.b;

/* compiled from: WorkTypeConverters.kt */
/* loaded from: classes.dex */
public final class a0 {
    public static final int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        zf.i.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        int iOrdinal = backoffPolicy.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Set<b.C0302b> byteArrayToSetOfTriggers(byte[] bArr) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ObjectInputStream objectInputStream;
        zf.i.checkNotNullParameter(bArr, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                int i10 = objectInputStream.readInt();
                for (int i11 = 0; i11 < i10; i11++) {
                    Uri uri = Uri.parse(objectInputStream.readUTF());
                    boolean z10 = objectInputStream.readBoolean();
                    zf.i.checkNotNullExpressionValue(uri, "uri");
                    linkedHashSet.add(new b.C0302b(uri, z10));
                }
                lf.h hVar = lf.h.f16056a;
                wf.a.closeFinally(objectInputStream, null);
                lf.h hVar2 = lf.h.f16056a;
                wf.a.closeFinally(byteArrayInputStream, null);
                return linkedHashSet;
            } finally {
            }
        } finally {
        }
    }

    public static final BackoffPolicy intToBackoffPolicy(int i10) {
        if (i10 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i10 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException(o1.a.d("Could not convert ", i10, " to BackoffPolicy"));
    }

    public static final NetworkType intToNetworkType(int i10) {
        if (i10 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i10 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i10 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i10 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i10 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT < 30 || i10 != 5) {
            throw new IllegalArgumentException(o1.a.d("Could not convert ", i10, " to NetworkType"));
        }
        return NetworkType.TEMPORARILY_UNMETERED;
    }

    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int i10) {
        if (i10 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i10 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException(o1.a.d("Could not convert ", i10, " to OutOfQuotaPolicy"));
    }

    public static final WorkInfo$State intToState(int i10) {
        if (i10 == 0) {
            return WorkInfo$State.ENQUEUED;
        }
        if (i10 == 1) {
            return WorkInfo$State.RUNNING;
        }
        if (i10 == 2) {
            return WorkInfo$State.SUCCEEDED;
        }
        if (i10 == 3) {
            return WorkInfo$State.FAILED;
        }
        if (i10 == 4) {
            return WorkInfo$State.BLOCKED;
        }
        if (i10 == 5) {
            return WorkInfo$State.CANCELLED;
        }
        throw new IllegalArgumentException(o1.a.d("Could not convert ", i10, " to State"));
    }

    public static final int networkTypeToInt(NetworkType networkType) {
        zf.i.checkNotNullParameter(networkType, "networkType");
        int iOrdinal = networkType.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal == 2) {
            return 2;
        }
        if (iOrdinal == 3) {
            return 3;
        }
        if (iOrdinal == 4) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    public static final int outOfQuotaPolicyToInt(OutOfQuotaPolicy outOfQuotaPolicy) {
        zf.i.checkNotNullParameter(outOfQuotaPolicy, "policy");
        int iOrdinal = outOfQuotaPolicy.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final byte[] setOfTriggersToByteArray(Set<b.C0302b> set) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        zf.i.checkNotNullParameter(set, "triggers");
        if (set.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(set.size());
                for (b.C0302b c0302b : set) {
                    objectOutputStream.writeUTF(c0302b.getUri().toString());
                    objectOutputStream.writeBoolean(c0302b.isTriggeredForDescendants());
                }
                lf.h hVar = lf.h.f16056a;
                wf.a.closeFinally(objectOutputStream, null);
                wf.a.closeFinally(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                zf.i.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static final int stateToInt(WorkInfo$State workInfo$State) {
        zf.i.checkNotNullParameter(workInfo$State, AdOperationMetric.INIT_STATE);
        int iOrdinal = workInfo$State.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal == 2) {
            return 2;
        }
        if (iOrdinal == 3) {
            return 3;
        }
        if (iOrdinal == 4) {
            return 4;
        }
        if (iOrdinal == 5) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }
}
