package flix.com.vision.models;

import gd.h;
import hd.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public class MySourceArrayList extends ArrayList<o> {

    /* renamed from: b, reason: collision with root package name */
    public int f12409b = 0;

    /* renamed from: m, reason: collision with root package name */
    public String f12410m = "";

    /* renamed from: n, reason: collision with root package name */
    public final h f12411n;

    public MySourceArrayList(h hVar) {
        this.f12411n = hVar;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends o> collection) {
        for (o oVar : collection) {
            if (oVar.topLink()) {
                add(0, oVar);
            } else {
                add(oVar);
            }
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean add(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (oVar.f13047w) {
            this.f12410m += " | " + oVar.D;
        }
        if (!oVar.hasMultiSubtitles() && contains(oVar)) {
            return false;
        }
        String str = oVar.D;
        if (str != null && str.startsWith("//")) {
            oVar.D = "http:" + oVar.D;
        }
        if (oVar.C.toLowerCase().contains("BITPORNO")) {
            oVar.C = oVar.C.replace("BITPORNO", "RAPIDVIDEO");
        }
        if (oVar.unavailable()) {
            return false;
        }
        if (oVar.topLink()) {
            add(0, oVar);
        } else {
            super.add((MySourceArrayList) oVar);
            if (oVar.A || oVar.f13050z || oVar.B) {
                this.f12409b++;
            }
        }
        h hVar = this.f12411n;
        if (hVar != null) {
            hVar.onAdded();
        }
        Collections.sort(this);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public synchronized void add(int i10, o oVar) {
        if (oVar == null) {
            return;
        }
        this.f12410m += " | " + oVar.D;
        if (oVar.hasMultiSubtitles() || !contains(oVar)) {
            String str = oVar.D;
            if (str != null && str.startsWith("//")) {
                oVar.D = "http:" + oVar.D;
            }
            if (oVar.unavailable()) {
                return;
            }
            super.add(i10, (int) oVar);
            if (oVar.A || oVar.f13050z || oVar.B) {
                this.f12409b++;
            }
            h hVar = this.f12411n;
            if (hVar != null) {
                hVar.onAdded();
            }
            Collections.sort(this);
        }
    }
}
