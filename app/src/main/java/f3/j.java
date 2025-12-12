package f3;

import java.util.List;

/* compiled from: SystemIdInfoDao.kt */
/* loaded from: classes.dex */
public interface j {

    /* compiled from: SystemIdInfoDao.kt */
    public static final class a {
        public static i getSystemIdInfo(j jVar, m mVar) {
            zf.i.checkNotNullParameter(mVar, "id");
            return jVar.getSystemIdInfo(mVar.getWorkSpecId(), mVar.getGeneration());
        }

        public static void removeSystemIdInfo(j jVar, m mVar) {
            zf.i.checkNotNullParameter(mVar, "id");
            jVar.removeSystemIdInfo(mVar.getWorkSpecId(), mVar.getGeneration());
        }
    }

    i getSystemIdInfo(m mVar);

    i getSystemIdInfo(String str, int i10);

    List<String> getWorkSpecIds();

    void insertSystemIdInfo(i iVar);

    void removeSystemIdInfo(m mVar);

    void removeSystemIdInfo(String str);

    void removeSystemIdInfo(String str, int i10);
}
