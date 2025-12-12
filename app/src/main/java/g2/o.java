package g2;

/* compiled from: RoomMasterTable.kt */
/* loaded from: classes.dex */
public final class o {
    public static final String createInsertQuery(String str) {
        zf.i.checkNotNullParameter(str, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
