package r3;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public final class l implements m, j {

    /* renamed from: a, reason: collision with root package name */
    public final Path f18524a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Path f18525b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f18526c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f18527d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final MergePaths f18528e;

    public l(MergePaths mergePaths) {
        mergePaths.getName();
        this.f18528e = mergePaths;
    }

    @TargetApi(19)
    public final void a(Path.Op op) {
        Matrix matrix;
        Matrix matrix2;
        Path path = this.f18525b;
        path.reset();
        Path path2 = this.f18524a;
        path2.reset();
        ArrayList arrayList = this.f18527d;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            m mVar = (m) arrayList.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                ArrayList arrayList2 = (ArrayList) dVar.a();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path path3 = ((m) arrayList2.get(size2)).getPath();
                    s3.o oVar = dVar.f18476k;
                    if (oVar != null) {
                        matrix2 = oVar.getMatrix();
                    } else {
                        matrix2 = dVar.f18468c;
                        matrix2.reset();
                    }
                    path3.transform(matrix2);
                    path.addPath(path3);
                }
            } else {
                path.addPath(mVar.getPath());
            }
        }
        int i10 = 0;
        m mVar2 = (m) arrayList.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> listA = dVar2.a();
            while (true) {
                ArrayList arrayList3 = (ArrayList) listA;
                if (i10 >= arrayList3.size()) {
                    break;
                }
                Path path4 = ((m) arrayList3.get(i10)).getPath();
                s3.o oVar2 = dVar2.f18476k;
                if (oVar2 != null) {
                    matrix = oVar2.getMatrix();
                } else {
                    matrix = dVar2.f18468c;
                    matrix.reset();
                }
                path4.transform(matrix);
                path2.addPath(path4);
                i10++;
            }
        } else {
            path2.set(mVar2.getPath());
        }
        this.f18526c.op(path2, path, op);
    }

    @Override // r3.j
    public void absorbContent(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof m) {
                this.f18527d.add((m) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // r3.m
    public Path getPath() {
        Path path = this.f18526c;
        path.reset();
        MergePaths mergePaths = this.f18528e;
        if (mergePaths.isHidden()) {
            return path;
        }
        int iOrdinal = mergePaths.getMode().ordinal();
        if (iOrdinal == 0) {
            int i10 = 0;
            while (true) {
                ArrayList arrayList = this.f18527d;
                if (i10 >= arrayList.size()) {
                    break;
                }
                path.addPath(((m) arrayList.get(i10)).getPath());
                i10++;
            }
        } else if (iOrdinal == 1) {
            a(Path.Op.UNION);
        } else if (iOrdinal == 2) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (iOrdinal == 3) {
            a(Path.Op.INTERSECT);
        } else if (iOrdinal == 4) {
            a(Path.Op.XOR);
        }
        return path;
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f18527d;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((m) arrayList.get(i10)).setContents(list, list2);
            i10++;
        }
    }
}
