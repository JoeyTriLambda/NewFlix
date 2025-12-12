package org.jsoup.select;

import org.jsoup.nodes.g;

/* compiled from: NodeTraversor.java */
/* loaded from: classes2.dex */
public final class d {
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r5 == r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if (r5 != r9) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        r5 = r4.tail(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
    
        if (r5 != r6) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        if (r1 != r11) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        r3 = r1.nextSibling();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        if (r5 != r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        r1.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.jsoup.select.NodeFilter.FilterResult filter(org.jsoup.select.NodeFilter r10, org.jsoup.nodes.g r11) {
        /*
            r0 = 0
            r1 = r11
            r2 = 0
        L3:
            org.jsoup.select.NodeFilter$FilterResult r3 = org.jsoup.select.NodeFilter.FilterResult.CONTINUE
            if (r1 == 0) goto L60
            r4 = r10
            org.jsoup.select.a$b r4 = (org.jsoup.select.a.b) r4
            org.jsoup.select.NodeFilter$FilterResult r5 = r4.head(r1, r2)
            org.jsoup.select.NodeFilter$FilterResult r6 = org.jsoup.select.NodeFilter.FilterResult.STOP
            if (r5 != r6) goto L13
            return r5
        L13:
            if (r5 != r3) goto L22
            int r7 = r1.childNodeSize()
            if (r7 <= 0) goto L22
            org.jsoup.nodes.g r1 = r1.childNode(r0)
            int r2 = r2 + 1
            goto L3
        L22:
            org.jsoup.nodes.g r7 = r1.nextSibling()
            org.jsoup.select.NodeFilter$FilterResult r8 = org.jsoup.select.NodeFilter.FilterResult.REMOVE
            org.jsoup.select.NodeFilter$FilterResult r9 = org.jsoup.select.NodeFilter.FilterResult.SKIP_CHILDREN
            if (r7 != 0) goto L47
            if (r2 <= 0) goto L47
            if (r5 == r3) goto L32
            if (r5 != r9) goto L39
        L32:
            org.jsoup.select.NodeFilter$FilterResult r5 = r4.tail(r1, r2)
            if (r5 != r6) goto L39
            return r5
        L39:
            org.jsoup.nodes.g r7 = r1.parentNode()
            int r2 = r2 + (-1)
            if (r5 != r8) goto L44
            r1.remove()
        L44:
            r5 = r3
            r1 = r7
            goto L22
        L47:
            if (r5 == r3) goto L4b
            if (r5 != r9) goto L52
        L4b:
            org.jsoup.select.NodeFilter$FilterResult r5 = r4.tail(r1, r2)
            if (r5 != r6) goto L52
            return r5
        L52:
            if (r1 != r11) goto L55
            return r5
        L55:
            org.jsoup.nodes.g r3 = r1.nextSibling()
            if (r5 != r8) goto L5e
            r1.remove()
        L5e:
            r1 = r3
            goto L3
        L60:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.d.filter(org.jsoup.select.NodeFilter, org.jsoup.nodes.g):org.jsoup.select.NodeFilter$FilterResult");
    }

    public static void traverse(hh.a aVar, g gVar) {
        g gVarChildNode = gVar;
        int i10 = 0;
        while (gVarChildNode != null) {
            aVar.head(gVarChildNode, i10);
            if (gVarChildNode.childNodeSize() > 0) {
                gVarChildNode = gVarChildNode.childNode(0);
                i10++;
            } else {
                while (gVarChildNode.nextSibling() == null && i10 > 0) {
                    aVar.tail(gVarChildNode, i10);
                    gVarChildNode = gVarChildNode.parentNode();
                    i10--;
                }
                aVar.tail(gVarChildNode, i10);
                if (gVarChildNode == gVar) {
                    return;
                } else {
                    gVarChildNode = gVarChildNode.nextSibling();
                }
            }
        }
    }
}
